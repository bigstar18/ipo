package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.utils.CommodityDistribution;
import com.yrdce.ipo.common.utils.DateUtil;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDistributionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDistributionRuleMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.dao.TCustomerholdsumMapper;
import com.yrdce.ipo.modules.sys.entity.FirmDistInfo;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoDistribution;
import com.yrdce.ipo.modules.sys.entity.IpoDistributionRule;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;

@Service("distTaskService")
public class DistTaskServiceImpl implements DistTaskService {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IpoOrderMapper ipoOrderMapper;
	@Autowired
	private IpoDistributionRuleMapper ipoDistributionRuleMapper;
	@Autowired
	private TCustomerholdsumMapper tcustomerholdsumMapper;
	@Autowired
	private IpoDistributionMapper ipoDistributionMapper;
	@Autowired
	private IpoCommodityMapper commodityMapper;

	private List<FirmDistInfo> firmdistInfoList;
	private List<IpoOrder> orderList;

	@Transactional()
	public void lottery() throws Exception {
		logger.info("摇号开始，开始获取商品信息");
		String time = DateUtil.getTime(1);
		// 查询发售表
		List<IpoCommodity> ipoCommodities = commodityMapper.selectByEnd(time);
		for (IpoCommodity ipoCommodity : ipoCommodities) {
			if (ipoCommodity.getStatus() == 1) {
				distCommodity(ipoCommodity.getCommodityid());
			}
		}
		logger.info("摇号结束");
	}

	// 摇号过程
	@Override
	@Transactional
	public void distCommodity(String commid) {
		int st = 1;
		try {
			IpoCommodity commodity = commodityMapper.queryByComid(commid);
			st = commodity.getStatus();
			int tempCounts = (int) (commodity.getCounts() / commodity.getUnits());
			logger.info("市场发售数量：" + tempCounts);
			commodityMapper.updateByStatus(31, commid);// 31表示摇号中
			orderList = ipoOrderMapper.selectByCid(commid);
			IpoDistributionRule distributionRule = ipoDistributionRuleMapper.selectInfoByCommId(commid);
			CommodityDistribution commodityDistribution;
			if (distributionRule == null) {
				commodityDistribution = new CommodityDistribution(tempCounts, 0, 100);
			} else {
				commodityDistribution = new CommodityDistribution(tempCounts,
						distributionRule.getHoldRatio().doubleValue(),
						distributionRule.getPurchaseRatio().doubleValue());
			}
			if (orderList.size() != 0) {
				firmdistInfoList = new ArrayList<FirmDistInfo>();
				for (IpoOrder ipoOrder : orderList) {
					logger.info("创建分配对象");
					FirmDistInfo firmDistInfo = creatFirmObj(commodity, ipoOrder, distributionRule);
					logger.info("创建分配对象成功");
					if (commodityDistribution.getAlldistNum() > 0) {
						firmDistInfo = commodityDistribution.distributionMain(firmDistInfo);
					} else {
						firmDistInfo.setDistNum(0);
					}
					firmdistInfoList.add(firmDistInfo);
					logger.info("第一轮分配成功,分配数量：" + firmDistInfo.getDistNum());
				}
				System.out.println("剩余量：" + commodityDistribution.getAlldistNum());
				if (commodityDistribution.getAlldistNum() > 0) {
					logger.info("随机分配开始");
					while (firmdistInfoList.size() > 0 && commodityDistribution.getAlldistNum() > 0) {
						for (int i = 0; i < firmdistInfoList.size(); i++) {
							FirmDistInfo firmDistInfo = firmdistInfoList.get(i);
							if (firmDistInfo.isFull()) {
								if (commodityDistribution.getAlldistNum() > 0 && i + 1 != firmdistInfoList.size()) {
									firmDistInfo = commodityDistribution.disCommodityByRandom(firmDistInfo);
								} else if (i + 1 == firmdistInfoList.size()) {
									int disNum = firmDistInfo.getDistNum() + commodityDistribution.getAlldistNum();
									if (disNum > firmDistInfo.getBuyNum()) {
										int tempNum = firmDistInfo.getBuyNum() - firmDistInfo.getDistNum();
										firmDistInfo.setDistNum(firmDistInfo.getBuyNum());
										commodityDistribution
												.setAlldistNum(commodityDistribution.getAlldistNum() - tempNum);
										firmDistInfo.setFull(false);
									} else {
										firmDistInfo.setDistNum(disNum);
										commodityDistribution.setAlldistNum(0);
									}
								}
							}
							if (!firmDistInfo.isFull()) {
								addDistributionInfo(firmDistInfo, commodity);
								firmdistInfoList.remove(i);
							}
						}
					}
				}
				if (commodityDistribution.getAlldistNum() == 0) {
					for (FirmDistInfo firmDistInfo : firmdistInfoList) {
						addDistributionInfo(firmDistInfo, commodity);
					}
					logger.info("记录成功");
				}

			}
			commodityMapper.updateByStatus(3, commid);
			logger.info("摇号结束");

		} catch (Exception e) {
			logger.error("摇号异常", e);
			commodityMapper.updateByStatus(st, commid);
		}
	}

	// 添加摇号记录
	private void addDistributionInfo(FirmDistInfo firmDistInfo, IpoCommodity commodity) {
		IpoDistribution ipoDistribution = new IpoDistribution();
		IpoDistribution tempDistribution = ipoDistributionMapper.selectByPrimaryKey(firmDistInfo.getId());
		ipoDistribution.setZcounts(firmDistInfo.getDistNum());
		ipoDistribution.setId(firmDistInfo.getId());
		ipoDistribution.setCommodityid(commodity.getCommodityid());
		ipoDistribution.setCommodityname(commodity.getCommodityname());
		ipoDistribution.setUserid(firmDistInfo.getFirmId());
		if (tempDistribution == null) {
			ipoDistributionMapper.insert(ipoDistribution);
		} else {
			ipoDistributionMapper.updateByPrimaryKey(ipoDistribution);
		}
	}

	// 实例化一个等待摇号的交易商对象
	private FirmDistInfo creatFirmObj(IpoCommodity ipoCommodity, IpoOrder ipoOrder,
			IpoDistributionRule distributionRule) {
		int countsBuy = ipoOrderMapper.selectbysid(ipoOrder.getCommodityid());
		long holdCounts = tcustomerholdsumMapper.selectByCommId(orderList);
		long firmhoidCounts = tcustomerholdsumMapper.selectFirmHold(ipoOrder.getUserid());
		long tempCountsBuy = countsBuy / ipoCommodity.getUnits();
		long tempCountsOrder = ipoOrder.getCounts() / ipoCommodity.getUnits();
		logger.info("申购量：" + ipoOrder.getCounts() + "单位：" + ipoCommodity.getUnits() + "交易商购买量：" + tempCountsBuy);
		double firmCapitalRatio = (double) tempCountsOrder / (double) tempCountsBuy;
		double firmPositionRatio = 0;
		if (holdCounts != 0) {
			firmPositionRatio = (double) firmhoidCounts / (double) holdCounts;
		}
		FirmDistInfo distInfo = new FirmDistInfo();
		distInfo.setFirmCapitalRatio(firmCapitalRatio);
		distInfo.setFirmId(ipoOrder.getUserid());
		distInfo.setId(ipoOrder.getOrderid());
		distInfo.setBuyNum(ipoOrder.getCounts());
		if (distributionRule != null) {
			if (distributionRule.getMaxqty().intValue() > ipoOrder.getCounts()) {
				distInfo.setMaxdistNum(ipoOrder.getCounts());
			} else {
				distInfo.setMaxdistNum(distributionRule.getMaxqty().intValue());
			}

		}
		distInfo.setFirmPositionRatio(firmPositionRatio);
		logger.info(
				"创建交易商[" + distInfo.getFirmId() + "]成功，申购比例[" + firmCapitalRatio + "]持仓比例[" + firmPositionRatio + "]");
		return distInfo;
	}

}
