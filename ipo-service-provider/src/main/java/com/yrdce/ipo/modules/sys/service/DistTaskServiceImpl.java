package com.yrdce.ipo.modules.sys.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.utils.CommodityDistribution;
import com.yrdce.ipo.common.utils.DateUtil;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDistributionRuleMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.dao.TCustomerholdsumMapper;
import com.yrdce.ipo.modules.sys.entity.FirmDistInfo;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoDistributionRule;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;

public class DistTaskServiceImpl {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IpoCommodityConfMapper commodityConfMapper;
	@Autowired
	private IpoOrderMapper ipoOrderMapper;
	@Autowired
	private IpoDistributionRuleMapper ipoDistributionRuleMapper;
	@Autowired
	private TCustomerholdsumMapper tcustomerholdsumMapper;

	private List<FirmDistInfo> firmdistInfoList;
	private List<IpoOrder> orderList;

	@Transactional()
	private void getCommodityInfos() throws Exception {
		logger.info("分配开始，开始获取商品信息");
		List<IpoCommodityConf> commodityConfList = commodityConfMapper.findAllIpoCommConfs();
		for (IpoCommodityConf ipoCommodityConf : commodityConfList) {
			int day = ipoCommodityConf.getTradedays();
			String oldtime = DateUtil.getTime(day);
			Date endtime = ipoCommodityConf.getEndtime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String endtime1 = sdf.format(endtime);
			if (oldtime.equals(endtime1) && ipoCommodityConf.getStatus().intValue() == 1) {
				logger.info("T+N天符合要求");
				distCommodity(ipoCommodityConf);
			}
		}
	}

	// 分配过程
	private void distCommodity(IpoCommodityConf ipoCommodityConf) throws Exception {
		orderList = ipoOrderMapper.selectByCid(ipoCommodityConf.getCommodityid());
		IpoDistributionRule distributionRule = ipoDistributionRuleMapper
				.selectInfoByCommId(ipoCommodityConf.getCommodityid());
		CommodityDistribution commodityDistribution = new CommodityDistribution((int) ipoCommodityConf.getCounts(),
				distributionRule.getPurchaseRatio().doubleValue(), distributionRule.getHoldRatio().doubleValue());
		if (orderList.size() != 0) {
			firmdistInfoList = new ArrayList<FirmDistInfo>();
			for (IpoOrder ipoOrder : orderList) {
				FirmDistInfo firmDistInfo = creatFirmObj(ipoCommodityConf, ipoOrder, distributionRule);
				if (commodityDistribution.getAlldistNum() > 0) {
					firmDistInfo = commodityDistribution.distributionMain(firmDistInfo);
				}
				firmdistInfoList.add(firmDistInfo);
			}
			for (FirmDistInfo firmDistInfo : firmdistInfoList) {
				if (commodityDistribution.getAlldistNum() > 0) {
					firmDistInfo = commodityDistribution.disCommodityByRandom(firmDistInfo);
				}

			}
		}
	}

	// 实例化一个等待摇号的交易商对象
	private FirmDistInfo creatFirmObj(IpoCommodityConf ipoCommodityConf, IpoOrder ipoOrder,
			IpoDistributionRule distributionRule) {
		int countsBuy = ipoOrderMapper.selectbysid(ipoOrder.getCommodityid());
		int holdCounts = tcustomerholdsumMapper.selectByCommId(orderList);
		int firmhoidCounts = tcustomerholdsumMapper.selectFirmHold(ipoOrder.getUserid());
		long tempCountsBuy = countsBuy / ipoCommodityConf.getUnits();
		long tempCountsOrder = ipoOrder.getCounts() / ipoCommodityConf.getUnits();
		double firmCapitalRatio = tempCountsOrder / tempCountsBuy;
		double firmPositionRatio = firmhoidCounts / holdCounts;
		FirmDistInfo distInfo = new FirmDistInfo();
		distInfo.setFirmCapitalRatio(firmCapitalRatio);
		distInfo.setFirmId(ipoOrder.getUserid());
		distInfo.setMaxdistNum(distributionRule.getMaxqty().intValue());
		distInfo.setFirmPositionRatio(firmPositionRatio);
		return distInfo;
	}

}
