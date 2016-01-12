package com.yrdce.ipo.common.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPositionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoCommoditymanmaagementMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
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

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Transactional
	public void runSPO() {
		logger.info("增发状态定时任务启动");
		String time = sdf.format(new Date());
		List<IpoSpoCommoditymanmaagement> list = ipoSPOCommMapper.select(null);
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
		List<IpoSpoCommoditymanmaagement> list = ipoSPOCommMapper.select("1");
		for (IpoSpoCommoditymanmaagement ipospocomm : list) {
			String spoid = ipospocomm.getSpoId();
			logger.info(">>>>>>>>>>>>>>>>>>spoid：" + spoid);
			int sate = ipospocomm.getSpoSate();//
			if (sate == 1) {
				// 获得增发商品id
				String commodityid = ipospocomm.getCommunityId();
				logger.info(">>>>>>>>>>>>>>>>>>commodityid:" + commodityid);
				// 获得未增发的量
				long otration = ipospocomm.getNotRationCounts();
				logger.info(">>>>>>>>>>>>>>>>>>otration:" + otration);
				// 商品在持仓中的总量(现货持仓)
				int sum = ipoPositionMapper.selectSumByComm(commodityid);
				logger.info(">>>>>>>>>>>>>>>>>>sum:" + sum);
				// 现货持仓信息
				List<TFirmHoldSum> tFirmholdsumslist = ipoPositionMapper.selectPositionList(commodityid);
				for (TFirmHoldSum tFirmholdsums : tFirmholdsumslist) {
					String firmid = tFirmholdsums.getFirmid();
					logger.info(">>>>>>>>>>>>>>>>>>firmid:" + firmid);
					double position = tFirmholdsums.getHoldqty();
					logger.info(">>>>>>>>>>>>>>>>>>position:" + position);
					double value = position / (double) sum;
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
					ipoSpoRation.setRationSate(1);
					ipoSpoRationMapper.insert(ipoSpoRation);
					logger.info("散户增发定时任务结束");
				}
			}
			ipoSPOCommMapper.updateByStatus(5, spoid);
		}
	}
}
