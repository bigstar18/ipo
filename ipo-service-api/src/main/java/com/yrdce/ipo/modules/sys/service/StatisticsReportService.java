package com.yrdce.ipo.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.Order;

public interface StatisticsReportService {

	/**
	 * @Title: getCommName
	 * @Description: 获取所有发售业务的商品代码
	 */
	public Map<String, String> getCommIdList();

	/**
	 * @Title: getOrderList
	 * @Description: 通过商品id和时间查询申购订单
	 * @param commid
	 * @param time
	 */
	public List<Order> getOrderList(String commid, String time);

	/**
	 * @Title: getCommdList
	 * @Description: 商品id查询商品信息
	 * @param commid
	 */
	public Commodity getCommd(String commid);
}
