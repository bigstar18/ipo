package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.common.constant.DeliveryConstant;
import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDebitFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryCostMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryorderMapper;
import com.yrdce.ipo.modules.sys.dao.IpoExpressMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPickupMapper;
import com.yrdce.ipo.modules.sys.dao.TCustomerholdsumMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryCost;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryCostExtended;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;
import com.yrdce.ipo.modules.sys.entity.IpoExpress;
import com.yrdce.ipo.modules.sys.entity.IpoExpressExtended;
import com.yrdce.ipo.modules.sys.entity.IpoPickup;
import com.yrdce.ipo.modules.sys.entity.IpoPickupExtended;
import com.yrdce.ipo.modules.sys.entity.TCustomerholdsum;
import com.yrdce.ipo.modules.sys.vo.DebitFlow;
import com.yrdce.ipo.modules.sys.vo.DeliveryCost;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
import com.yrdce.ipo.modules.sys.vo.Paging;
import com.yrdce.ipo.modules.sys.vo.Pickup;
import com.yrdce.ipo.modules.sys.vo.Position;

/**
 * 交收提货
 * 
 * @author Bob
 *
 */
@Service
public class SettlementDeliveryServiceImpl implements SettlementDeliveryService {

	static Logger logger = LoggerFactory
			.getLogger(SettlementDeliveryServiceImpl.class);

	@Autowired
	private IpoPickupMapper ipoPickupMapper;
	@Autowired
	private IpoDeliveryorderMapper ipoDeliveryorderMapper;
	@Autowired
	private IpoExpressMapper ipoExpressMapper;
	@Autowired
	private IpoDeliveryCostMapper ipoDeliveryCostMapper;
	@Autowired
	private FFirmfundsMapper fundsMapper;
	@Autowired
	private IpoDebitFlowMapper ipoDebitFlowMapper;
	@Autowired
	private TCustomerholdsumMapper tCustomerholdsumMapper;
	@Autowired
	private IpoCommodityConfMapper commodityConfMapper;
	@Autowired
	@Qualifier("customerHoldSumService")
	private CustomerHoldSumService customerHoldSumService;
	@Autowired
	@Qualifier("deliveryorderservice")
	private DeliveryOrderService deliveryorderservice;

	private final static String REGISTRATION_FEE = "1001";

	private final static String CANCELLATION_FEE = "1002";

	@Override
	// 获得交易商持仓信息
	public List<Position> getListByPosition(String firmid) {
		logger.info("获得交易商持仓信息");
		List<TCustomerholdsum> list1 = tCustomerholdsumMapper.selectHQT(firmid);
		List<Position> list2 = new ArrayList<Position>();
		for (TCustomerholdsum customerholdsum : list1) {
			String commodityid = customerholdsum.getCommodityid();
			IpoCommodityConf commodityConf = commodityConfMapper
					.findIpoCommConfByCommid(commodityid);
			String commodityname = commodityConf.getCommodityname();
			BigDecimal contractfactor = commodityConf.getContractfactor();
			BigDecimal deliunittocontract = commodityConf
					.getDeliunittocontract();
			BigDecimal unit = contractfactor.multiply(deliunittocontract);
			long holdqty = customerholdsum.getHoldqty();
			long frozenqty = customerholdsum.getFrozenqty();
			Position position = new Position();
			position.setCommodityid(commodityid);
			position.setCommodityname(commodityname);
			position.setPosition(holdqty - frozenqty);
			position.setPositionUnit(unit);
			position.setSettlementdate(commodityConf.getDeliverystartday());

			// 分割仓库名称
			String[] warehouse1 = customerholdsum.getWarehouseName().split(",");
			String[] warehouse2 = position.getWarehouse();
			warehouse2 = (String[]) warehouse1.clone();
			position.setWarehouse(warehouse2);

			// 分割仓库id
			String[] warehouseid1 = customerholdsum.getWarehouseId().split(",");
			String[] warehouseid2 = position.getWarehouseid();
			warehouseid2 = (String[]) warehouseid1.clone();
			position.setWarehouseid(warehouseid2);
			list2.add(position);
		}
		return list2;
		/*
		 * List<IpoPosition> list1 = ipoPositionMapper.selectByFirmid(firmid);
		 * List<Position> list2 = new ArrayList<Position>(); for (IpoPosition
		 * ipoPosition : list1) { Position position = new Position();
		 * BeanUtils.copyProperties(ipoPosition, position);
		 * 
		 * // 分割仓库名称 String[] warehouse1 =
		 * ipoPosition.getWarehouseName().split(","); String[] warehouse2 =
		 * position.getWarehouse(); warehouse2 = (String[]) warehouse1.clone();
		 * position.setWarehouse(warehouse2);
		 * 
		 * // 分割仓库id String[] warehouseid1 =
		 * ipoPosition.getWarehouseId().split(","); String[] warehouseid2 =
		 * position.getWarehouseid(); warehouseid2 = (String[])
		 * warehouseid1.clone(); position.setWarehouseid(warehouseid2);
		 * list2.add(position); } return list2;
		 */
	}

	// 自提申请
	@Override
	@Transactional
	public String applicationByPickup(DeliveryOrder deliveryOrder)
			throws Exception {
		logger.info("自提申请");
		// 自提表
		IpoPickup ipoPickup = new IpoPickup();
		BeanUtils.copyProperties(deliveryOrder, ipoPickup);
		ipoPickupMapper.insert(ipoPickup);
		String pickupId = ipoPickup.getPickupId();

		IpoDeliveryorder ipoDeliveryorder = this.applicationMethod(
				deliveryOrder, pickupId);
		if (ipoDeliveryorder == null) {
			return "error";
		}

		ipoDeliveryorderMapper.insert(ipoDeliveryorder);
		return "success";
	}

	// 在线配送申请
	@Override
	@Transactional
	public String applicationByexpress(DeliveryOrder deliveryOrder)
			throws Exception {
		logger.info("在线配送申请");
		// 在线配送
		IpoExpress ipoExpress = new IpoExpress();
		BeanUtils.copyProperties(deliveryOrder, ipoExpress);
		ipoExpressMapper.insert(ipoExpress);
		String expressId = ipoExpress.getExpressId();

		IpoDeliveryorder ipoDeliveryorder = this.applicationMethod(
				deliveryOrder, expressId);
		if (ipoDeliveryorder == null) {
			return "error";
		}

		ipoDeliveryorderMapper.insert(ipoDeliveryorder);
		return "success";
	}

	// 申请共用部分方法
	@Transactional
	private IpoDeliveryorder applicationMethod(DeliveryOrder deliveryOrder,
			String id) {
		// 提货单表
		IpoDeliveryorder ipoDeliveryorder = new IpoDeliveryorder();
		BeanUtils.copyProperties(deliveryOrder, ipoDeliveryorder);
		ipoDeliveryorder.setApprovalStatus(DeliveryConstant.StatusType.REGISTER
				.getCode());
		ipoDeliveryorder.setMethodId(id);
		// 生成主键
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String id1 = sdf.format(new Date());
		String id2 = String.valueOf(ipoDeliveryorderMapper.sequence());
		String primaryKey = id1 + id2;
		ipoDeliveryorder.setDeliveryorderId(primaryKey);
		ipoDeliveryorder.setApplyDate(new Date());
		// 查询用户名称并插入表中
		String dealerId = ipoDeliveryorder.getDealerId();
		String dealername = ipoDeliveryorderMapper.selectByFrim(dealerId);
		ipoDeliveryorder.setDealerName(dealername);

		long quatity = deliveryOrder.getDeliveryQuatity();
		String firmid = deliveryOrder.getDealerId() + "00";
		String commid = deliveryOrder.getCommodityId();

		// 注册费
		IpoCommodityConf commodityConf = commodityConfMapper
				.findIpoCommConfByCommid(commid);
		BigDecimal registfeeradio = commodityConf.getRegistfeeradio();
		BigDecimal valparam = registfeeradio.divide(new BigDecimal("100"));
		BigDecimal price = commodityConf.getPrice();
		BigDecimal quatityParam = new BigDecimal(quatity);
		BigDecimal fee = valparam.multiply(price.multiply(quatityParam));
		IpoDeliveryCost ipoDeliveryCost = new IpoDeliveryCost();
		ipoDeliveryCost.setDeliveryId(primaryKey);
		ipoDeliveryCost.setDeliveryMethod(deliveryOrder.getDeliveryMethod());
		ipoDeliveryCost.setApplyDate(new Date());
		ipoDeliveryCost.setRegistrationFee(fee);
		ipoDeliveryCostMapper.insert(ipoDeliveryCost);
		boolean statu = capital(dealerId, fee);
		if (statu) {
			// 更新持仓量
			customerHoldSumService.freezeCustomerHold(quatity, firmid, commid,
					(short) 1);

			// 扣款流水
			/*
			 * this.fundsFlow(ChargeConstant.ChargeType.REGISTER.getCode(),
			 * commid, primaryKey, deliveryOrder.getDealerId(), fee);
			 */

			return ipoDeliveryorder;
		} else {
			return null;
		}

		/*
		 * long quatity = deliveryOrder.getDeliveryQuatity(); String firmid =
		 * deliveryOrder.getDealerId(); String commid =
		 * deliveryOrder.getCommodityId(); IpoPosition ipoPosition =
		 * ipoPositionMapper.selectPosition(firmid, commid); long position =
		 * ipoPosition.getPosition(); long num = position - quatity;
		 * ipoPositionMapper.updatePosition(firmid, commid, num);
		 */

	}

	// 注册费
	@Override
	public BigDecimal costQuery(String commid, Long quatity, String type) {
		IpoCommodityConf commodityConf = commodityConfMapper
				.findIpoCommConfByCommid(commid);
		BigDecimal cost = new BigDecimal(0);
		if (type.equals(REGISTRATION_FEE)) {
			cost = commodityConf.getRegistfeeradio();
		} else if (type.equals(CANCELLATION_FEE)) {
			cost = commodityConf.getCancelfeeradio();
		}
		BigDecimal valparam = cost.divide(new BigDecimal("100"));
		BigDecimal price = commodityConf.getPrice();
		BigDecimal quatityParam = new BigDecimal(quatity);
		BigDecimal fee = valparam.multiply(price.multiply(quatityParam));
		return fee;
	}

	// 自提打印
	@Override
	public List<DeliveryOrder> getPrint(String page, String rows, Paging paging)
			throws Exception {
		logger.info("自提打印:" + paging.getDealerId() + "单号："
				+ paging.getDeliveryorderId());
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoDeliveryorder> list1 = ipoDeliveryorderMapper.selectByPickup(
				(curpage - 1) * pagesize + 1, curpage * pagesize, paging);
		List<DeliveryOrder> list2 = new ArrayList<DeliveryOrder>();
		for (IpoDeliveryorder ipoDeliveryorder : list1) {
			DeliveryOrder deliveryOrder = new DeliveryOrder();
			BeanUtils.copyProperties(ipoDeliveryorder, deliveryOrder);
			list2.add(deliveryOrder);
		}
		return list2;
	}

	// 自提打印总页数
	@Override
	public int counts(Paging paging, String deliveryMethod) throws Exception {
		logger.info("自提打印总页数" + "userid:" + paging.getDealerId() + "单号："
				+ paging.getDeliveryorderId());
		if (deliveryMethod.equals("no")) {
			logger.info("无参数的条数查询");
			return ipoDeliveryorderMapper.selectCounts(paging, null);
		} else {
			logger.info("有参数的条数查询");
			return ipoDeliveryorderMapper.selectCounts(paging, deliveryMethod);
		}
	}

	// 自提详细信息
	@Override
	public Pickup getDetail(String methodid) throws Exception {
		logger.info("自提信息信息" + "methodid:" + methodid);
		IpoPickupExtended ipoPickup = ipoDeliveryorderMapper
				.selectByPickUp(methodid);
		Pickup pickup = new Pickup();
		BeanUtils.copyProperties(ipoPickup, pickup);
		return pickup;
	}

	// 撤销申请页面展示
	@Override
	public List<DeliveryOrder> getRevocationList(String page, String rows,
			Paging paging) throws Exception {
		logger.info("撤销提货列表:" + paging.getDealerId() + "单号："
				+ paging.getDeliveryorderId());
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoDeliveryorder> list1 = ipoDeliveryorderMapper.selectRevocation(
				(curpage - 1) * pagesize + 1, curpage * pagesize, paging);
		List<DeliveryOrder> list2 = new ArrayList<DeliveryOrder>();
		for (IpoDeliveryorder ipoDeliveryorder : list1) {
			DeliveryOrder deliveryOrder = new DeliveryOrder();
			BeanUtils.copyProperties(ipoDeliveryorder, deliveryOrder);
			list2.add(deliveryOrder);
		}
		return list2;
	}

	// 状态修改
	@Override
	@Transactional
	public String updateRevocationStatus(String deliveryorderid, String status)
			throws Exception {
		logger.info("状态修改" + "deliveryorderid:" + deliveryorderid + "status:"
				+ status);
		int i = ipoDeliveryorderMapper.updateByStatus(deliveryorderid, status);
		if (i == 1) {
			return "success";
		} else {
			return "error";
		}
	}

	/**
	 * @Title: determine
	 * @Description: 客户确认配售收取货款
	 * @param deliveryorderid
	 * @param userid
	 */
	@Override
	@Transactional
	public boolean determine(String deliveryorderid, String userid) {
		logger.info("客户确认配售收取货款:" + "deliveryorderid:" + deliveryorderid
				+ "userid:" + userid);
		IpoExpress ipoExpress = ipoExpressMapper.selectExpress(deliveryorderid);
		// IpoDeliveryorder ipoDeliveryorder =
		// ipoDeliveryorderMapper.selectByPrimaryKey(deliveryorderid);
		// String commodid = ipoDeliveryorder.getCommodityId();
		BigDecimal cost = ipoExpress.getCost();
		boolean statu = capital(userid, cost);
		/*
		 * if (statu) {
		 * this.fundsFlow(ChargeConstant.ChargeType.CARRIAGE.getCode(),
		 * commodid, deliveryorderid, userid, cost); return "success"; } else {
		 * return "error"; }
		 */
		return statu;
	}

	/**
	 * @Title: revoke
	 * @Description: 撤销申请
	 * @param deliveryorderid
	 * @param status
	 * @return 参数说明
	 */
	@Override
	@Transactional
	public String revoke(String deliveryorderid, String status) {
		logger.info("撤销申请:" + "deliveryorderid:" + deliveryorderid + "status:"
				+ status);
		// 获取此条订单的属性
		IpoDeliveryorder ipoDeliveryorder = ipoDeliveryorderMapper
				.selectByPrimaryKey(deliveryorderid);
		String firmid = ipoDeliveryorder.getDealerId();
		String commid = ipoDeliveryorder.getCommodityId();
		long quatity = ipoDeliveryorder.getDeliveryQuatity();
		customerHoldSumService.unfreezeCustomerHold(quatity, firmid + "00",
				commid, (short) 1);
		if (status == DeliveryConstant.StatusType.MARKETPASS.getCode()
				|| status == DeliveryConstant.StatusType.REGISTER.getCode()
				|| status == DeliveryConstant.StatusType.EXPRESSCOSTSET
						.getCode()) {
			DeliveryOrder deliveryOrder = new DeliveryOrder();
			BeanUtils.copyProperties(ipoDeliveryorder, deliveryOrder);
			deliveryorderservice.unfrozenStock(deliveryOrder);
		}

		// 注销费
		IpoCommodityConf commodityConf = commodityConfMapper
				.findIpoCommConfByCommid(commid);
		BigDecimal cancelfeeradio = commodityConf.getCancelfeeradio();
		BigDecimal valparam = cancelfeeradio.divide(new BigDecimal("100"));
		BigDecimal price = commodityConf.getPrice();
		BigDecimal quatityParam = new BigDecimal(quatity);
		BigDecimal fee = valparam.multiply(price.multiply(quatityParam));
		ipoDeliveryCostMapper.updateFee(deliveryorderid, fee);

		boolean statu = capital(firmid, fee);
		if (statu) {
			// 扣款流水
			this.fundsFlow(ChargeConstant.ChargeType.CANCEL.getCode(), commid,
					deliveryorderid, firmid, fee);
			return "success";
		} else {
			return "error";
		}

	}

	// 在线配送
	@Override
	public List<Express> getListByExpress(String page, String rows,
			Paging paging) throws Exception {
		logger.info("在线配送" + "用户ID:" + paging.getDealerId() + "单号："
				+ paging.getDeliveryorderId());
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoExpressExtended> list1 = ipoDeliveryorderMapper
				.selectByExpress((curpage - 1) * pagesize + 1, curpage
						* pagesize, paging);
		List<Express> list2 = new ArrayList<Express>();
		for (IpoExpressExtended ipoExpressExtended : list1) {
			Express express = new Express();
			BeanUtils.copyProperties(ipoExpressExtended, express);
			list2.add(express);
		}
		return list2;
	}

	// 提货查询
	@Override
	public List<DeliveryOrder> getListByOrder(String page, String rows,
			Paging paging) throws Exception {
		logger.info("提货查询" + "用户ID:" + paging.getDealerId() + "单号："
				+ paging.getDeliveryorderId());
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoDeliveryorder> list1 = ipoDeliveryorderMapper.selectByUserid(
				(curpage - 1) * pagesize + 1, curpage * pagesize, paging);
		List<DeliveryOrder> list2 = new ArrayList<DeliveryOrder>();
		for (IpoDeliveryorder ipoDeliveryorder : list1) {
			DeliveryOrder deliveryOrder = new DeliveryOrder();
			BeanUtils.copyProperties(ipoDeliveryorder, deliveryOrder);
			list2.add(deliveryOrder);
		}
		return list2;
	}

	// 提货查询总页数
	@Override
	public int countsByAll(Paging paging) throws Exception {
		logger.info("提货查询总页数" + "用户ID:" + paging.getDealerId() + "单号："
				+ paging.getDeliveryorderId());
		return ipoDeliveryorderMapper.allCounts(paging);
	}

	// 根据提货方式和提货id查申请主表
	@Override
	public DeliveryOrder getorder(String method, String id) {
		IpoDeliveryorder ipoDeliveryorder = ipoDeliveryorderMapper
				.selectByMethodAndId(method, id);
		DeliveryOrder deliveryOrder = new DeliveryOrder();
		BeanUtils.copyProperties(ipoDeliveryorder, deliveryOrder);
		return deliveryOrder;
	}

	// 提货查询(自提)详细信息
	@Override
	public Pickup getDetailByPickup(String methodid) throws Exception {
		logger.info("提货查询(自提)详细信息" + "methodid:" + methodid);
		IpoPickup ipoPickup = ipoPickupMapper.selectByPrimaryKey(methodid);
		Pickup pickup = new Pickup();
		BeanUtils.copyProperties(ipoPickup, pickup);
		return pickup;
	}

	// 提货查询(在线配送)详细信息
	@Override
	public Express getDetailByExpress(String methodid) throws Exception {
		logger.info("提货查询(在线配送)详细信息" + "methodid:" + methodid);
		IpoExpress ipoExpress = ipoExpressMapper.selectByPrimaryKey(methodid);
		Express express = new Express();
		BeanUtils.copyProperties(ipoExpress, express);
		return express;
	}

	// 费用查询
	@Override
	public List<DeliveryCost> getListByDeliveryCost(String page, String rows,
			Paging paging) throws Exception {
		logger.info("费用查询" + "用户ID:" + paging.getDealerId() + "单号："
				+ paging.getDeliveryorderId());
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoDeliveryCostExtended> list1 = ipoDeliveryCostMapper
				.selectByUserid((curpage - 1) * pagesize + 1, curpage
						* pagesize, paging);
		List<DeliveryCost> list2 = new ArrayList<DeliveryCost>();
		for (IpoDeliveryCost ipodeliveryCost : list1) {
			BigDecimal registr = ipodeliveryCost.getRegistrationFee() != null ? ipodeliveryCost
					.getRegistrationFee() : new BigDecimal(0);
			BigDecimal cance = ipodeliveryCost.getCancellationFee() != null ? ipodeliveryCost
					.getCancellationFee() : new BigDecimal(0);
			ipodeliveryCost.setDeliveryFee(cance.add(registr));
			DeliveryCost deliveryCost = new DeliveryCost();
			BeanUtils.copyProperties(ipodeliveryCost, deliveryCost);
			list2.add(deliveryCost);
		}
		return list2;
	}

	@Override
	public int countsByCost(Paging paging) throws Exception {
		return ipoDeliveryCostMapper.countsByCost(paging);
	}

	// 收付款流水
	private String fundsFlow(String chargeType, String commodityid, String id,
			String userid, BigDecimal money) {
		// 货款流水
		DebitFlow debitFlow = new DebitFlow();
		debitFlow.setBusinessType(ChargeConstant.BusinessType.DELIVERY
				.getCode());
		debitFlow.setChargeType(chargeType);
		debitFlow.setCommodityId(commodityid);
		debitFlow.setOrderId(id);
		debitFlow.setDebitState(ChargeConstant.DebitState.FROZEN_SUCCESS
				.getCode());
		debitFlow.setPayer(userid);
		debitFlow.setAmount(money);
		debitFlow.setDebitMode(ChargeConstant.DebitMode.ONLINE.getCode());
		debitFlow
				.setDebitChannel(ChargeConstant.DebitChannel.DEPOSIT.getCode());
		debitFlow.setBuyBackFlag(0);
		debitFlow.setCreateUser(userid);
		debitFlow.setCreateDate(new Date());
		ipoDebitFlowMapper.insert(debitFlow);
		return "success";
	}

	public Boolean capital(String userid, BigDecimal cost) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("money", "");
		param.put("userid", userid);
		param.put("lock", 0);
		fundsMapper.getMonery(param);
		BigDecimal money = (BigDecimal) param.get("money");
		if (money.compareTo(cost) != -1) {
			float amount = cost.floatValue();
			Map<String, Object> param1 = new HashMap<String, Object>();
			param1.put("money", "");
			param1.put("userid", userid);
			param1.put("amount", amount);
			param1.put("moduleid", "40");
			fundsMapper.getfrozen(param1);
			return true;
		} else {
			return false;
		}
	}
}
