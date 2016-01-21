package com.yrdce.ipo.common.task;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPositionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoCommoditymanmaagementMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoSpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.entity.IpoSpoRation;
import com.yrdce.ipo.modules.sys.entity.TFirmHoldSum;

/**
 * 增发状态定时任务
 * 
 * @author Bob
 */
public class SPOTask {

	static Logger logger = LoggerFactory.getLogger(SPOTask.class);
	@Autowired
	private IpoSpoRationMapper ipoSpoRationMapper;
	@Autowired
	private IpoSpoCommoditymanmaagementMapper ipoSPOCommMapper;
	@Autowired
	private IpoPositionMapper ipoPositionMapper;
	@Autowired
	private FFirmfundsMapper fundsMapper;
	@Autowired
	private IpoCommodityConfMapper ipoCommConfMapper;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Transactional
	public void runSPO() {
		logger.info("增发状态定时任务启动");
		String time = sdf.format(new Date());
		List<IpoSpoCommoditymanmaagement> list = ipoSPOCommMapper.select(null, null, null);
		// 遍历增发商品管理列表
		for (IpoSpoCommoditymanmaagement ipoSPOComm : list) {
			String spoid = ipoSPOComm.getSpoId();
			Date ipoDate = ipoSPOComm.getIpoDate();
			String ipotime = sdf.format(ipoDate);
			// 时间判断，更新配售表状态
			if (time == ipotime) {
				ipoSpoRationMapper.updateByStatus(1, spoid);
				logger.info("配售状态更新成功");
			}
		}
	}

	/**
	 * 比例增发散户的配售
	 * 
	 * @param
	 * @throws Exception
	 */
	@Transactional
	public void placing() throws Exception {
		logger.info("散户增发定时任务启动");
		List<IpoSpoCommoditymanmaagement> list = ipoSPOCommMapper.select("1", null, null);
		for (IpoSpoCommoditymanmaagement ipospocomm : list) {
			String spoid = ipospocomm.getSpoId();
			logger.debug(">>>>>>>>>>>>>>>>>>spoid：" + spoid);
			int sate = ipospocomm.getSpoSate();
			// 单价
			BigDecimal price = ipospocomm.getSpoPrice();
			logger.debug("单价price：" + price);
			if (sate == 1) {
				// 获得增发商品id
				String commodityid = ipospocomm.getCommodityid();
				logger.debug(">>>>>>>>>>>>>>>>>>commodityid:" + commodityid);
				// 手续费算法
				IpoCommodityConf ipoCommodityConf = ipoCommConfMapper.selectCommUnit(commodityid);
				short mode = ipoCommodityConf.getTradealgr();
				BigDecimal val = ipoCommodityConf.getBuy();
				// 获得未增发的量
				long otration = ipospocomm.getNotRationCounts();
				logger.debug(">>>>>>>>>>>>>>>>>>otration:" + otration);
				// 商品在持仓中的总量(现货持仓)
				int sum = ipoPositionMapper.selectSumByComm(commodityid);
				logger.debug(">>>>>>>>>>>>>>>>>>sum:" + sum);
				// 现货持仓信息
				List<TFirmHoldSum> tFirmholdsumslist = ipoPositionMapper.selectPositionList(commodityid);
				for (TFirmHoldSum tFirmholdsums : tFirmholdsumslist) {
					String firmid = tFirmholdsums.getFirmId();
					logger.debug(">>>>>>>>>>>>>>>>>>firmid:" + firmid);
					double position = tFirmholdsums.getHoldqty();
					logger.debug(">>>>>>>>>>>>>>>>>>position:" + position);
					double value = position / (double) sum;
					logger.debug(">>>>>>>>>>>>>>>>>>value:" + value);
					// 增发量
					long num = (long) (otration * value);
					BigDecimal counts1 = new BigDecimal(num);
					logger.debug("数量counts1：" + counts1);
					// 货款
					BigDecimal monery = price.multiply(counts1);
					logger.debug("商品费用Monery：" + monery);
					// 服务费
					BigDecimal fee = new BigDecimal(0);
					if (mode == 1) {
						BigDecimal valparam = val.divide(new BigDecimal("100"));
						fee = monery.multiply(valparam);
						logger.debug("比例手续费：" + fee);
					} else {
						fee = counts1.multiply(val);
						logger.debug("绝对值手续费：" + fee);
					}

					IpoSpoRation ipoSpoRation = new IpoSpoRation();
					ipoSpoRation.setSpoid(spoid);
					ipoSpoRation.setRationcounts(num);
					ipoSpoRation.setFirmid(firmid);
					ipoSpoRation.setOperationdate(new Date());
					String firmname = ipoSpoRationMapper.selectFirmname(firmid);
					ipoSpoRation.setFirmname(firmname);
					ipoSpoRation.setRationSate(1);
					ipoSpoRation.setServicefee(fee);
					ipoSpoRation.setRationloan(monery);
					ipoSpoRationMapper.insert(ipoSpoRation);
					logger.info("散户增发定时任务结束");
				}
			}
			ipoSPOCommMapper.updateByStatus(5, spoid);
		}
	}

	// 小于最小配售数量，自动增发失败
	public void automaticFail() {
		List<IpoSpoCommoditymanmaagement> list = ipoSPOCommMapper.select("1", new Date(), 3);
		for (IpoSpoCommoditymanmaagement ipospocomm : list) {
			String spoid = ipospocomm.getSpoId();
			long notcounts = ipospocomm.getNotRationCounts();
			long mincounts = ipospocomm.getMinRationCounts();
			if (notcounts > mincounts) {
				ipoSpoRationMapper.updateByStatus(3, spoid);
			}
		}
	}
}
