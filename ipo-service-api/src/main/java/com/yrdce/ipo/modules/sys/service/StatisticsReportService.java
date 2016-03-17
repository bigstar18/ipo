package com.yrdce.ipo.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.yrdce.ipo.modules.sys.vo.Billoflading;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.Delivery;
import com.yrdce.ipo.modules.sys.vo.FundSettlement;
import com.yrdce.ipo.modules.sys.vo.Holdcommodity;
import com.yrdce.ipo.modules.sys.vo.Order;
import com.yrdce.ipo.modules.sys.vo.Releasesubscription;

public interface StatisticsReportService {

	/**
	 * @Title: getCommName
	 * @Description: 获取所有发售业务的商品代码
	 */
	public Map<String, String> cGetCommIdList();

	/**
	 * @Title: getOrderList
	 * @Description: 通过商品id和时间查询申购订单
	 * @param commid
	 * @param time
	 */
	public List<Order> oGetOrderList(String commid, String time);

	/**
	 * @Title: getCommdList
	 * @Description: 商品id查询商品信息
	 * @param commid
	 */
	public Commodity cGetCommd(String commid);

	/**
	 * @Title: getFund
	 * @Description: 资金结算信息（客户端）
	 * @param firmId
	 * @param date
	 */
	public FundSettlement fGetFund(String firmId, String date);

	/**
	 * @Title: getReleaInfo
	 * @Description: 申购明细（客户端）
	 * @param firmId
	 * @param date
	 */
	public List<Releasesubscription> rGetReleaInfo(String firmId, String date);

	/**
	 * @Title: getHoldInfo
	 * @Description: 商品持有表（客户端）
	 * @param firmId
	 * @param date
	 */
	public List<Holdcommodity> hGetHoldInfo(String firmId, String date);

	/**
	 * @Title: getBillfladInfo
	 * @Description: 商品提货单表（客户端）
	 * @param firmId
	 * @param date
	 */
	public List<Billoflading> bGetBillfladInfo(String firmId, String date);

	/**
	 * @Title: getDeliveryInfo
	 * @Description: 商品过户、提货表（客户端）
	 * @param firmId
	 * @param date
	 */
	public List<Delivery> dGetDeliveryInfo(String firmId, String date);
}
