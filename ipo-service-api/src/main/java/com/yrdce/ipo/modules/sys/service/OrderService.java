package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Order;

public interface OrderService {

	// 根据用户ID获取订单表的信息分页展示
	public List<Order> getOrderInfo(String page, String rows, String userId);

	// 获取当前用户所有订单记录数
	public int getAll(String userid);

	// 订单表的信息分页展示
	public List<Order> getOrder(String page, String rows);

	// 获取所有订单记录数
	public int getAllOrder();

}
