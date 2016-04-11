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
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpecialcounterfeeMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoCommoditymanmaagementMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
import com.yrdce.ipo.modules.sys.dao.TFirmHoldSumMaper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoSpecialcounterfee;
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
	private TFirmHoldSumMaper tFirmHoldSumMaper;
	@Autowired
	private IpoCommodityConfMapper ipoCommConfMapper;
	@Autowired
	private FFirmfundsMapper fundsMapper;
	@Autowired
	private IpoSpecialcounterfeeMapper ipoSpecialcounterfeeMapper;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	public void runSPO() {
		logger.info("增发配售状态定时任务启动");
		String time = sdf.format(new Date());
		List<IpoSpoCommoditymanmaagement> list = ipoSPOCommMapper.select("2", null, null);
		// 遍历增发商品管理列表
		for (IpoSpoCommoditymanmaagement ipoSPOComm : list) {
			String spoid = ipoSPOComm.getSpoId();
			Date ipoDate = ipoSPOComm.getIpoDate();
			String ipotime = sdf.format(ipoDate);
			int timeParam = Integer.parseInt(time);
			int ipotimeParam = Integer.parseInt(ipotime);
			// 时间判断，更新配售表状态
			if (timeParam >= ipotimeParam) {
				ipoSpoRationMapper.updateByStatus(2, spoid);
				logger.info("配售状态更新成功");
			}
		}
	}

	@Transactional
	public void updateStatu() {
		logger.info("增发上市状态定时任务启动");
		String time = sdf.format(new Date());
		List<IpoSpoCommoditymanmaagement> list = ipoSPOCommMapper.findBySpoDate(2);
		// 遍历增发商品管理列表
		for (IpoSpoCommoditymanmaagement ipoSPOComm : list) {
			String spoid = ipoSPOComm.getSpoId();
			Date ipoDate = ipoSPOComm.getIpoDate();
			//String ipotime = sdf.format(ipoDate);
			int timeParam = Integer.parseInt(time);
			int ipotime = Integer.parseInt(sdf.format(ipoDate));
			// 时间判断，更新配售表状态
			if (timeParam >= ipotime) {
				ipoSPOCommMapper.updateForListed(1, spoid);
				logger.info("上市状态更新成功");
			}
		}
	}

	@Transactional
	public void updateSpoSateStatu() {
		logger.info("比例增发未到增发日期状态定时任务启动");
		String time = sdf.format(new Date());
		List<IpoSpoCommoditymanmaagement> list = ipoSPOCommMapper.findBySpoDate(4);
		// 遍历增发商品管理列表
		for (IpoSpoCommoditymanmaagement ipoSPOComm : list) {
			String spoid = ipoSPOComm.getSpoId();
			Date spoDate = ipoSPOComm.getSpoDate();
			//String ipotime = sdf.format(ipoDate);
			int timeParam = Integer.parseInt(time);
			int ipotime = Integer.parseInt(sdf.format(spoDate));
			// 时间判断，更新配售表状态
			if (timeParam >= ipotime) {
				ipoSPOCommMapper.updateByStatus(1, spoid);
				logger.info("状态更新成功");
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
				String commodityid = ipospocomm.getCommodityId();
				logger.debug(">>>>>>>>>>>>>>>>>>commodityid:" + commodityid);
				// 手续费算法
				IpoCommodityConf ipoCommodityConf = ipoCommConfMapper.selectCommUnit(commodityid);
				short mode = ipoCommodityConf.getTradealgr();
				BigDecimal val = ipoCommodityConf.getBuy();
				// 获得未增发的量
				long otration = ipospocomm.getNotRationCounts();
				logger.debug(">>>>>>>>>>>>>>>>>>otration:" + otration);
				// 商品在持仓中的总量(现货持仓)
				int sum = tFirmHoldSumMaper.selectSumByComm(commodityid);
				logger.debug(">>>>>>>>>>>>>>>>>>sum:" + sum);
				// 现货持仓信息
				List<TFirmHoldSum> tFirmholdsumslist = tFirmHoldSumMaper.selectPositionList(commodityid);
				for (int i = 0; i < tFirmholdsumslist.size(); i++) {
					//for (TFirmHoldSum tFirmholdsums : tFirmholdsumslist) {
					//String firmid = tFirmholdsums.getFirmId();
					String firmid = tFirmholdsumslist.get(i).getFirmId();
					logger.debug(">>>>>>>>>>>>>>>>>>firmid:" + firmid);
					//double position = tFirmholdsums.getHoldqty();
					double position = tFirmholdsumslist.get(i).getHoldqty();
					logger.debug(">>>>>>>>>>>>>>>>>>position:" + position);
					double value = position / (double) sum;
					logger.debug(">>>>>>>>>>>>>>>>>>value:" + value);
					// 增发量?????????????
					long num = 0;
					long count = 0;
					if (i + 1 == tFirmholdsumslist.size()) {
						num = otration - count;
						//num = (long) (otration * value);
					} else {
						num = (long) (otration * value);
						count = count + num;
					}
					BigDecimal counts1 = new BigDecimal(num);
					logger.debug("数量counts1：" + counts1);
					// 货款
					BigDecimal money = price.multiply(counts1);
					logger.debug("商品费用Monery：" + money);
					IpoSpecialcounterfee ipoSpecialcounterfee = ipoSpecialcounterfeeMapper.selectInfo(firmid,
							commodityid, "1");
					BigDecimal fee = new BigDecimal(0);
					BigDecimal buy = new BigDecimal(0);
					short tradealgr = 0;
					if (ipoSpecialcounterfee != null) {
						tradealgr = ipoSpecialcounterfee.getTradealgr();
						buy = ipoSpecialcounterfee.getCounterfee();
						if (tradealgr == 1) {
							BigDecimal valparam = buy.divide(new BigDecimal("100"));
							fee = money.multiply(valparam);
							logger.debug("特殊比例手续费：" + fee);
						} else {
							fee = counts1.multiply(buy);
							logger.debug("特殊绝对值手续费：" + fee);
						}
					} else {
						// 服务费
						if (mode == 1) {
							BigDecimal valparam = val.divide(new BigDecimal("100"));
							fee = money.multiply(valparam);
							logger.debug("比例手续费：" + fee);
						} else {
							fee = counts1.multiply(val);
							logger.debug("绝对值手续费：" + fee);
						}
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
					ipoSpoRation.setRationloan(money);
					ipoSpoRationMapper.insert(ipoSpoRation);
					logger.info("散户增发定时任务结束");
				}
				ipoSPOCommMapper.updateByStatus(5, spoid);
			}
		}
	}

	// 小于最小配售数量，自动增发失败
	@Transactional
	public void automaticFail() {
		List<IpoSpoCommoditymanmaagement> list = ipoSPOCommMapper.select("1", new Date(), 3);
		logger.info("list长度{}", list.size());
		try {
			int a = 0;
			for (IpoSpoCommoditymanmaagement ipospocomm : list) {
				String spoid = ipospocomm.getSpoId();
				long sucCounts = (long) ipospocomm.getSuccessRationCounts();
				long minCounts = (long) ipospocomm.getMinRationCounts();
				if (minCounts > sucCounts) {
					a = ipoSPOCommMapper.updateByStatus(3, spoid);
					List<IpoSpoRation> list2 = ipoSpoRationMapper.selectInfoBySPOid(spoid);
					if (list2.size() != 0 || !list2.isEmpty())
						for (IpoSpoRation ipoSpoRation : list2) {
							String firmid = ipoSpoRation.getFirmid();
							BigDecimal rationLoan = ipoSpoRation.getRationloan() != null
									? ipoSpoRation.getRationloan() : new BigDecimal(0);
							BigDecimal serviceFee = ipoSpoRation.getServicefee() != null
									? ipoSpoRation.getServicefee() : new BigDecimal(0);
							BigDecimal all = rationLoan.add(serviceFee);
							float allmoney = 0 - all.floatValue();
							logger.info("解冻资金共计：{},交易商代码：{}", allmoney, firmid);
							Map<String, Object> param = new HashMap<String, Object>();
							param.put("money", "");
							param.put("userid", firmid);
							param.put("amount", allmoney);
							param.put("moduleid", "40");
							fundsMapper.getfrozen(param);
						}
				}
			}
			logger.info("更新{}数据", a);
		} catch (Exception e) {
			logger.error("异常{}", e);
		}
	}

}
