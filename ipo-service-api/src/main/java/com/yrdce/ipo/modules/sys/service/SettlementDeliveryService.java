package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.DeliveryCost;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
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

	// 自提打印
	public List<Pickup> getApplication(String page, String rows, String userid) throws Exception;

	public Pickup getDetail() throws Exception;

	// 撤销提货
	public String getRevocation(String DELIVERYORDER_ID) throws Exception;

	// 在线配送
	public List<Express> getListByExpress(String page, String rows, String userid) throws Exception;

	public String confirm();

	// 提货查询
	public List<DeliveryOrder> getListByOrder(String page, String rows, String userid) throws Exception;

	public Pickup getDetailByPickup(long methodid) throws Exception;

	public Express getDetailByExpress(long methodid) throws Exception;

	// 费用查询
	public List<DeliveryCost> getListByDeliveryCost(String page, String rows, String userid) throws Exception;

}
