package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.Order;

/**
 * @ClassName: StatisticsReportImpl
 * @Description:统计报表
 * @author bob
 */
@Service
public class StatisticsReportImpl implements StatisticsReportService {
	@Autowired
	private IpoCommodityConfMapper ipoCommodityConfMapper;
	@Autowired
	private IpoOrderMapper ipoOrderMapper;

	@Override
	public Map<String, String> getCommIdList() {
		List<IpoCommodityConf> commidList = ipoCommodityConfMapper.findAllIpoCommConfs();
		Map<String, String> comMap = new HashMap<String, String>();
		for (IpoCommodityConf commodityConf : commidList) {
			String id = commodityConf.getCommodityid();
			String name = commodityConf.getCommodityname();
			comMap.put(id, name);
		}
		return comMap;
	}

	@Override
	public List<Order> getOrderList(String commid, String time) {
		List<IpoOrder> list1 = ipoOrderMapper.findCommidAndDate(commid, time);
		List<Order> list2 = new ArrayList<Order>();
		for (IpoOrder ipoOrder : list1) {
			Order order = new Order();
			BeanUtils.copyProperties(ipoOrder, order);
			list2.add(order);
		}
		return list2;
	}

	@Override
	public Commodity getCommd(String commid) {
		IpoCommodityConf commdInfo = ipoCommodityConfMapper.findIpoCommConfByCommid(commid);
		Commodity commodity = new Commodity();
		if (commdInfo != null) {
			BeanUtils.copyProperties(commdInfo, commodity);
			BigDecimal price = commdInfo.getPrice();
			double priceParam = price.doubleValue();
			commodity.setPrice(priceParam);
		}
		return commodity;
	}

}
