package com.yrdce.ipo.common.task;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPositionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoCommoditymanmaagementMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
import com.yrdce.ipo.modules.sys.entity.IpoPosition;
import com.yrdce.ipo.modules.sys.entity.IpoSpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.entity.IpoSpoRation;

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

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Transactional
	public void runSPO() {
		logger.info("增发状态定时任务启动");
		String time = sdf.format(new Date());
		List<IpoSpoCommoditymanmaagement> list = ipoSPOCommMapper.select(null);
		// 遍历增发商品管理列表
		for (IpoSpoCommoditymanmaagement ipoSPOComm : list) {
			String spoid = ipoSPOComm.getSpoId();
			Date spoDate = ipoSPOComm.getSpoDate();
			String spotime = sdf.format(spoDate);

			// 时间判断，更新增发表状态
			if (time == spotime) {
				// 增发价格
				BigDecimal price = ipoSPOComm.getPositionsPrice();
				List<IpoSpoRation> list2 = ipoSpoRationMapper.selectInfoBySPOid(spoid);
				for (IpoSpoRation ipoSpoRation : list2) {
					// 承销商id
					String salesid = ipoSpoRation.getSalesid();
					if (salesid != null) {
						// 交易商id
						String firmid = ipoSpoRation.getFirmid();
						// 买了多少
						long counts = ipoSpoRation.getRationcounts();
						BigDecimal countsparam = new BigDecimal(counts);
						// 计算应冻结多少
						BigDecimal monery = countsparam.multiply(price);
						float allmonery = monery.floatValue();
						// 资金冻结
						Map<String, Object> param = new HashMap<String, Object>();
						param.put("monery", "");
						param.put("userid", firmid);
						param.put("amount", allmonery);
						param.put("moduleid", "40");
						fundsMapper.getfrozen(param);
					}
				}
				ipoSPOCommMapper.updateByStatus(4, spoid);
				logger.info("增发状态更新成功");
			}
			Date ipoDate = ipoSPOComm.getIpoDate();
			String ipotime = sdf.format(ipoDate);
			// 时间判断，更新配售表状态
			if (time == ipotime) {
				ipoSpoRationMapper.updateByStatus(3, spoid);
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
		List<IpoSpoCommoditymanmaagement> list = ipoSPOCommMapper.select("1");
		for (IpoSpoCommoditymanmaagement ipospocomm : list) {
			String spoid = ipospocomm.getSpoId();
			logger.info(">>>>>>>>>>>>>>>>>>spoid：" + spoid);
			Date spodate = ipospocomm.getSpoDate();
			logger.info(">>>>>>>>>>>>>>>>>>spodate:" + spodate);
			String nowtime = sdf.format(new Date());
			String spodateparam = sdf.format(spodate);
			// 判断是否到增发日期
			if (nowtime.equals(spodateparam)) {
				// 获得增发商品id
				String commodityid = ipospocomm.getCommunityId();
				logger.info(">>>>>>>>>>>>>>>>>>commodityid:" + commodityid);
				// 获得未增发的量
				long otration = ipospocomm.getNotRationCounts();
				logger.info(">>>>>>>>>>>>>>>>>>otration:" + otration);
				// 商品在持仓中的总量
				double sum = ipoPositionMapper.selectSumByComm(commodityid);
				logger.info(">>>>>>>>>>>>>>>>>>sum:" + sum);
				List<IpoPosition> ipoPositionslist = ipoPositionMapper.selectPositionList(commodityid);
				for (IpoPosition ipoPosition : ipoPositionslist) {
					String firmid = ipoPosition.getFirmid();
					logger.info(">>>>>>>>>>>>>>>>>>firmid:" + firmid);
					double position = ipoPosition.getPosition();
					logger.info(">>>>>>>>>>>>>>>>>>position:" + position);
					double value = position / sum;
					logger.info(">>>>>>>>>>>>>>>>>>value:" + value);
					// 增发量
					long num = (long) (otration * value);
					IpoSpoRation ipoSpoRation = new IpoSpoRation();
					ipoSpoRation.setSpoid(spoid);
					ipoSpoRation.setRationcounts(num);
					ipoSpoRation.setFirmid(firmid);
					ipoSpoRation.setOperationdate(new Date());
					String firmname = ipoSpoRationMapper.selectFirmname(firmid);
					ipoSpoRation.setFirmname(firmname);
					ipoSpoRation.setRationSate(2);
					ipoSpoRationMapper.insert(ipoSpoRation);
					logger.info("散户增发定时任务结束");
				}
			}
		}
	}
}
