package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.DeliveryCost;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
import com.yrdce.ipo.modules.sys.vo.Paging;
import com.yrdce.ipo.modules.sys.vo.Pickup;
import com.yrdce.ipo.modules.sys.vo.Position;

/**
 * 
 * @author Bob
 *
 */
public interface SettlementDeliveryService {

	// 获得交易商持仓信息
	public List<Position> getListByPosition(String firmid);

	// 提货申请
	public String applicationByPickup(DeliveryOrder deliveryOrder) throws Exception;// Pickup pickup

	public String applicationByexpress(DeliveryOrder deliveryOrder) throws Exception;// Express express

	// 提货确认
	// public List<DeliveryOrder> Confirm(String page, String rows, String userid) throws Exception;

	// 自提打印
	public List<DeliveryOrder> getPrint(String page, String rows, Paging paging) throws Exception;

	// 总页数
	public int counts(Paging paging, String deliveryMethod) throws Exception;

	public Pickup getDetail(String methodid) throws Exception;

	// 撤销提货列表
	public List<DeliveryOrder> getRevocationList(String page, String rows, Paging paging) throws Exception;

	// 撤销提货
	public String updateRevocationStatus(String deliveryorderid, String status, String userid) throws Exception;

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

	// 根据提货方式和提货id查申请主表
	public DeliveryOrder getorder(String method, String id);

}
