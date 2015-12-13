package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;

/**
 * @author chenjing
 *
 */
public interface DeliveryOrderService {

	/**
	 * 分页查询所有提货单
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<DeliveryOrder> findAllDeliOrdersByPage(String page, String rows);

	/**
	 * 查询提货单总数
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public Integer getTotalNum();

	/**
	 * 分页查询待审核提货单
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<DeliveryOrder> approveDeliOrdersByPage(String page, String rows);

	/**
	 * 查询待审核提货单总数
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public Integer getApproveNum();

	/**
	 * 根据提货单号查询提货单
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public DeliveryOrder getDeliveryOrderByDeliOrderID(String deliOrderID);

	/**
	 * 审核提货单
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public String updateDeliveryOrder(DeliveryOrder order);

}
