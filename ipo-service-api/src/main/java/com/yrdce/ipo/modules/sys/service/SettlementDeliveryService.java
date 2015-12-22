package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.DeliveryCost;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
import com.yrdce.ipo.modules.sys.vo.Paging;
import com.yrdce.ipo.modules.sys.vo.Pickup;

/**
 * 
 * @author Bob
 *
 */
public interface SettlementDeliveryService {

	// 提货申请
	public String applicationByPickup(Pickup pickup) throws Exception;

	public String applicationByexpress(Express express) throws Exception;

	// 提货确认
	// public List<DeliveryOrder> Confirm(String page, String rows, String userid) throws Exception;

	// 自提打印
	public List<DeliveryOrder> getPrint(String page, String rows, Paging paging) throws Exception;

	// 总页数
	public int counts(Paging paging, String deliveryMethod) throws Exception;

	public Pickup getDetail(String methodid) throws Exception;

	// 撤销提货
	public String getRevocation(String deliveryorderid, String status) throws Exception;

	// 在线配送
	public List<Express> getListByExpress(String page, String rows, Paging paging) throws Exception;

	// public Express confirm(String methodid, String deliveryorderid) throws Exception;

	// 提货查询
	public List<DeliveryOrder> getListByOrder(String page, String rows, Paging paging) throws Exception;

	public int countsByAll(Paging paging) throws Exception;

	public Pickup getDetailByPickup(String methodid) throws Exception;

	public Express getDetailByExpress(String methodid) throws Exception;

	// 费用查询
	public List<DeliveryCost> getListByDeliveryCost(String page, String rows, Paging paging) throws Exception;

	// 费用页数
	public int countsByCost(Paging paging) throws Exception;

}
