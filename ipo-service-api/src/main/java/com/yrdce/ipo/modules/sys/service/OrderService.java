package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Order;

public interface OrderService {

	// 根据用户ID获取订单表的信息分页展示
	public List<Order> getOrderInfo(String page, String rows, String userId) throws Exception;

	// 获取当前用户所有订单记录数
	public int getAll(String userid) throws Exception;

	// 订单表的信息分页展示
	public List<Order> getOrder(String page, String rows) throws Exception;

	// 获取所有订单记录数
	public int getAllOrder() throws Exception;

	/**
	 * 获取500未结算商品申购单
	 * hxx
	 * 
	 * @param page
	 * @param rows
	 * @param userId
	 * @return
	 * @throws Exception
	 */
	public List<Order> queryUnsettleOrdersByCommId(String commId) throws Exception;

	/**
	 * hxx
	 * 
	 * @param commId
	 * @return
	 * @throws Exception
	 */
	public int updateOrderSettled(String commId) throws Exception;

}
