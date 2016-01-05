package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
import com.yrdce.ipo.modules.sys.vo.Pickup;

/**
 * @author chenjing
 *
 */
public interface DeliveryOrderService {

	/**
	 * 分页查询所有提货单(模糊查询)
	 * 
	 * @param page
	 * @param rows
	 * @param deorder
	 * @return
	 */
	public List<DeliveryOrder> queryAllDeliOrdersByPage(String page,
			String rows, DeliveryOrder deorder);

	/**
	 * 查询提货单总数(模糊查询)
	 * 
	 * @param deorder
	 * @return
	 */
	public Integer getQueryNum(DeliveryOrder deorder);

	/**
	 * 分页查询可取消提货单(模糊查询)
	 * 
	 * @param page
	 * @param rows
	 * @param deorder
	 * @return
	 */
	public List<DeliveryOrder> queryCancelDeliOrdersByPage(String page,
			String rows, DeliveryOrder deorder);

	/**
	 * 查询可取消提货单总数(模糊查询)
	 * 
	 * @param deorder
	 * @return
	 */
	public Integer getQueryCancelNum(DeliveryOrder deorder);

	/**
	 * 分页查询可撤销提货单
	 * 
	 * @param page
	 * @param rows
	 * @return
	 */
	public List<DeliveryOrder> cancelDeliOrdersByPage(String page, String rows);

	/**
	 * 查询可撤销提货单总数
	 * 
	 * @return
	 */
	public Integer getCancelNum();

	/**
	 * 根据提货单号查询提货单
	 * 
	 * @param deliveryOrderID
	 * @return
	 */
	public DeliveryOrder getDeliveryOrderByDeliOrderID(String deliOrderID);

	/**
	 * 审核自提提货单
	 * 
	 * @param order
	 * @param pickup
	 * @return
	 */
	public String updateDeliveryOrder(DeliveryOrder order, Pickup pickup,
			String managerId);

	/**
	 * 审核配送提货单
	 * 
	 * @param order
	 * @param express
	 * @return
	 */
	public String updateDeliveryOrder(DeliveryOrder order, Express express,
			String managerId);

	/**
	 * 查询自提详细信息
	 * 
	 * @param pickUpId
	 * @return
	 */
	public Pickup getPickUpDetail(String pickUpId);

	/**
	 * 查询配送详细信息
	 * 
	 * @param expressId
	 * @return
	 */
	public Express getExpressDetail(String expressId);

	/**
	 * 撤销提货单
	 * 
	 * @param order
	 * @param express
	 * @return
	 */
	public String cancelDeorder(String deOrderId, String cancellerId);

	/**
	 * 根据提货单号 密码 查自提 li
	 */
	public DeliveryOrder getPickupDeliveryInfo(DeliveryOrder order);

	/**
	 * 根据提货单号差配送单信息
	 *
	 * li
	 */
	public DeliveryOrder getExpressDeliveryInfo(DeliveryOrder order);
	/**
	 *修改提货单状态
	 *li 
	 * */
	public int updateStatus(DeliveryOrder deliveryOrder); 

}
