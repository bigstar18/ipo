package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esotericsoftware.minlog.Log;
import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.common.constant.DeliveryConstant;
import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDebitFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryCostMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryorderMapper;
import com.yrdce.ipo.modules.sys.dao.IpoExpressMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOutboundMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPickupMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPositionFlowMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryCost;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;
import com.yrdce.ipo.modules.sys.entity.IpoExpress;
import com.yrdce.ipo.modules.sys.entity.IpoPickup;
import com.yrdce.ipo.modules.sys.vo.DebitFlow;
import com.yrdce.ipo.modules.sys.vo.DeliveryCost;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
import com.yrdce.ipo.modules.sys.vo.Pickup;
import com.yrdce.ipo.modules.warehouse.dao.IpoWarehouseStockMapper;
import com.yrdce.ipo.modules.warehouse.entity.IpoWarehouseStock;

@Service("deliveryorderservice")
public class DeliveryOrderServiceImpl implements DeliveryOrderService {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(DeliveryOrderServiceImpl.class);

	@Autowired
	private IpoDeliveryorderMapper deliveryordermapper;

	@Autowired
	private IpoExpressMapper ipoexpressmapper;

	@Autowired
	private IpoPickupMapper ipopickupmapper;
	@Autowired
	private IpoWarehouseStockMapper ipoWarehouseStockMapper;
	@Autowired
	private IpoOutboundMapper ipoOutboundMapper;
	@Autowired
	private IpoPositionFlowMapper ipopositionmapper;

	@Autowired
	private IpoDeliveryCostMapper ipoDeliveryCostMapper;

	@Autowired
	private IpoDebitFlowMapper debitFlowMapper;

	@Autowired
	private FFirmfundsMapper fundsMapper;

	@Autowired
	@Qualifier("customerHoldSumService")
	private CustomerHoldSumService customerHoldSumService;

	@Autowired
	private IpoCommodityConfMapper ipoCommodityConfmapper;

	public IpoDeliveryorderMapper getDeliveryordermapper() {
		return deliveryordermapper;
	}

	public void setDeliveryordermapper(
			IpoDeliveryorderMapper deliveryordermapper) {
		this.deliveryordermapper = deliveryordermapper;
	}

	public IpoExpressMapper getIpoexpressmapper() {
		return ipoexpressmapper;
	}

	public void setIpoexpressmapper(IpoExpressMapper ipoexpressmapper) {
		this.ipoexpressmapper = ipoexpressmapper;
	}

	public IpoPickupMapper getIpopickupmapper() {
		return ipopickupmapper;
	}

	public void setIpopickupmapper(IpoPickupMapper ipopickupmapper) {
		this.ipopickupmapper = ipopickupmapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeliveryOrder> queryAllDeliOrdersByPage(String page,
			String rows, DeliveryOrder deorder) {
		Log.info("分页模糊查询提货单服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoDeliveryorder record = new IpoDeliveryorder();
		if (deorder != null) {
			BeanUtils.copyProperties(deorder, record);
			List<IpoDeliveryorder> dorderslist = deliveryordermapper
					.queryAllDeliOrdersByPage((curpage - 1) * pagesize + 1,
							curpage * pagesize, record);
			List<DeliveryOrder> dorderslist2 = new ArrayList<DeliveryOrder>();
			for (int i = 0; i < dorderslist.size(); i++) {
				DeliveryOrder temp = new DeliveryOrder();
				BeanUtils.copyProperties(dorderslist.get(i), temp);
				dorderslist2.add(temp);
				Log.info(temp.toString());
			}
			return dorderslist2;
		}
		return null;

	}

	@Override
	public Integer getQueryNum(DeliveryOrder deorder) {
		IpoDeliveryorder order = new IpoDeliveryorder();
		if (deorder != null) {
			BeanUtils.copyProperties(deorder, order);
			return deliveryordermapper.getQueryNum(order);
		}
		return 0;
	}

	@Override
	public DeliveryOrder getDeliveryOrderByDeliOrderID(String deliOrderID) {
		Log.info("根据提货单号查询提货单");
		IpoDeliveryorder deorder = deliveryordermapper
				.selectByPrimaryKey(deliOrderID);
		if (deorder != null) {
			DeliveryOrder order = new DeliveryOrder();
			BeanUtils.copyProperties(deorder, order);
			return order;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public String updateDeliveryOrder(DeliveryOrder order, String managerId) {
		Log.info("审核提货单服务");
		IpoDeliveryorder deorder = new IpoDeliveryorder();
		if (order != null) {
			BeanUtils.copyProperties(order, deorder);
			deorder.setApproveDate(new Date());
			deorder.setApprovers(managerId);
			deliveryordermapper.updateByPrimaryKey(deorder);
			return "true";
		}
		return "false";
	}

	@Override
	@Transactional
	public String frozenStock(DeliveryOrder deorder) {
		long quantity = deorder.getDeliveryQuatity();
		String commid = deorder.getCommodityId();
		IpoWarehouseStock stock = ipoWarehouseStockMapper.selectByCommoId(
				commid, Long.parseLong(deorder.getWarehouseId()));
		if (stock != null) {
			long frozennum = stock.getForzennum();
			long available = stock.getAvailablenum();
			long newfrozen = frozennum + quantity;
			long newavailble = available - quantity;
			stock.setForzennum(newfrozen);
			stock.setAvailablenum(newavailble);
			ipoWarehouseStockMapper.updateInfo(stock);
			log.info("冻结数量：" + stock.getForzennum() + "有效数量："
					+ stock.getAvailablenum() + "入库数量：" + stock.getStoragenum()
					+ "出库数量：" + stock.getOutboundnum());
			return "true";
		}
		return "false";
	}

	@Override
	public Pickup getPickUpDetail(String pickUpId) {
		Pickup pickup = new Pickup();
		IpoPickup detail = ipopickupmapper.selectByPrimaryKey(pickUpId);
		if (detail != null) {
			BeanUtils.copyProperties(detail, pickup);
			return pickup;
		}
		return null;
	}

	@Override
	public Express getExpressDetail(String expressId) {
		Express express = new Express();
		IpoExpress detail = ipoexpressmapper.selectByPrimaryKey(expressId);
		if (detail != null) {
			BeanUtils.copyProperties(detail, express);
			return express;
		}
		return null;
	}

	@Override
	public List<DeliveryOrder> cancelDeliOrdersByPage(String page, String rows) {
		Log.info("分页查询可撤销提货单服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoDeliveryorder> dorderslist = deliveryordermapper
				.cancelDeliOrdersByPage((curpage - 1) * pagesize + 1, curpage
						* pagesize);
		List<DeliveryOrder> dorderslist2 = new ArrayList<DeliveryOrder>();
		for (int i = 0; i < dorderslist.size(); i++) {
			DeliveryOrder temp = new DeliveryOrder();
			BeanUtils.copyProperties(dorderslist.get(i), temp);
			dorderslist2.add(temp);
			Log.info(temp.toString());
		}
		return dorderslist2;
	}

	@Override
	public Integer getCancelNum() {
		return deliveryordermapper.getCancelNum();
	}

	@Override
	@Transactional
	public String cancelDeorder(String deOrderId, String cancellId) {
		Log.info("撤销提货单服务");
		deliveryordermapper.cancelDeorder(deOrderId,
				DeliveryConstant.StatusType.CANCEL.getCode(), cancellId);
		return "true";
	}

	@Override
	public List<DeliveryOrder> queryCancelDeliOrdersByPage(String page,
			String rows, DeliveryOrder deorder) {
		Log.info("分页模糊查询提货单服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoDeliveryorder record = new IpoDeliveryorder();
		if (deorder != null) {
			BeanUtils.copyProperties(deorder, record);
			List<IpoDeliveryorder> dorderslist = deliveryordermapper
					.queryCancelDeliOrdersByPage((curpage - 1) * pagesize + 1,
							curpage * pagesize, record);
			List<DeliveryOrder> dorderslist2 = new ArrayList<DeliveryOrder>();
			for (int i = 0; i < dorderslist.size(); i++) {
				DeliveryOrder temp = new DeliveryOrder();
				BeanUtils.copyProperties(dorderslist.get(i), temp);
				dorderslist2.add(temp);
				Log.info(temp.toString());
			}
			return dorderslist2;
		}
		return null;
	}

	@Override
	public Integer getQueryCancelNum(DeliveryOrder deorder) {
		IpoDeliveryorder order = new IpoDeliveryorder();
		if (deorder != null) {
			BeanUtils.copyProperties(deorder, order);
			return deliveryordermapper.getQueryCancelNum(order);
		}
		return null;
	}

	public String genRandomNum() {
		final int maxNum = 36;
		int i;
		int count = 0;
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < 9) {
			i = Math.abs(r.nextInt(maxNum));
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}

	/**
	 * li
	 * 
	 */
	@Override
	public DeliveryOrder getPickupDeliveryInfo(DeliveryOrder order) {
		IpoDeliveryorder delivery = new IpoDeliveryorder();
		DeliveryOrder deliveryOrder = new DeliveryOrder();
		BeanUtils.copyProperties(order, delivery);
		IpoDeliveryorder temporder = deliveryordermapper
				.getPickupDeliveryInfo(delivery);
		if (temporder != null) {
			BeanUtils.copyProperties(temporder, deliveryOrder);
		}
		return deliveryOrder;
	}

	@Override
	public DeliveryOrder getExpressDeliveryInfo(DeliveryOrder order) {
		IpoDeliveryorder delivery = new IpoDeliveryorder();
		DeliveryOrder deliveryOrder = new DeliveryOrder();

		BeanUtils.copyProperties(order, delivery);
		IpoDeliveryorder temporder = deliveryordermapper
				.getExpressDeliveryInfo(delivery);
		if (temporder != null) {
			BeanUtils.copyProperties(temporder, deliveryOrder);
		}
		return deliveryOrder;
	}

	/**
	 * li 出库
	 */
	@Override
	@Transactional
	public int updateStatus(DeliveryOrder deliveryOrder, String outboundorderid) {

		IpoDeliveryorder deliveryorder2 = new IpoDeliveryorder();
		if (deliveryOrder != null) {
			IpoDeliveryorder deliveryorderInfo = deliveryordermapper
					.selectByPrimaryKey(deliveryOrder.getDeliveryorderId());
			String tempCommId = deliveryorderInfo.getCommodityId();
			String wareHouseId = deliveryorderInfo.getWarehouseId();
			// 扣仓库库存
			IpoWarehouseStock ipoWarehouseStock = ipoWarehouseStockMapper
					.selectByCommoId(tempCommId, Long.parseLong(wareHouseId));
			long forzennum = ipoWarehouseStock.getForzennum()
					- deliveryorderInfo.getDeliveryQuatity();
			long outboundnum = ipoWarehouseStock.getOutboundnum()
					+ deliveryorderInfo.getDeliveryQuatity();
			ipoWarehouseStock.setForzennum(forzennum);
			ipoWarehouseStock.setOutboundnum(outboundnum);
			BeanUtils.copyProperties(deliveryOrder, deliveryorder2);
			ipoWarehouseStockMapper.updateInfo(ipoWarehouseStock);
			log.info("冻结数量：" + ipoWarehouseStock.getForzennum() + "有效数量："
					+ ipoWarehouseStock.getAvailablenum() + "入库数量："
					+ ipoWarehouseStock.getStoragenum() + "出库数量："
					+ ipoWarehouseStock.getOutboundnum());
			// 改提货单状态
			deliveryordermapper.updateStatus(deliveryorder2);
			// 改出库单状态
			ipoOutboundMapper.updateOutBoundState(4, outboundorderid);
			// TODO 扣除客户持仓
			customerHoldSumService.reduceCustomerHold(
					deliveryorderInfo.getDeliveryQuatity(),
					deliveryorderInfo.getDealerId() + "00", tempCommId,
					(short) 1);
			// 插入注册费用流水
			BeanUtils.copyProperties(deliveryorderInfo, deliveryOrder);
			String flag = this.insertRegisterFee(deliveryOrder);
			// 配送的单子需插入配送费流水
			if (deliveryorderInfo.getDeliveryMethod().equals("在线配送")) {
				DeliveryOrder order = new DeliveryOrder();
				BeanUtils.copyProperties(deliveryorderInfo, order);
				String mark = this.insertExpressFee(order);
				if (mark.equals("true") && flag.equals("true")) {
					return 1;
				}
			} else {
				if (flag.equals("true")) {
					return 1;
				}
			}
		}
		return 0;
	}

	@Override
	@Transactional
	public String transferDeliveryOrder(String deliveryId, String userId) {
		IpoDeliveryorder example = deliveryordermapper
				.selectByPrimaryKey(deliveryId);
		if (example != null) {
			DeliveryOrder order = new DeliveryOrder();
			BeanUtils.copyProperties(example, order);
			order.setDealerId(userId);
			String result1 = this.insertTransferFee(order);// 冻结B的过户费并插入过户费流水
			if ("fundshort".equals(result1)) {
				return "fundshort";
			}
			// TODO b现货持仓增加
			customerHoldSumService.increaseCustomerHold(
					order.getDeliveryQuatity(), userId + "00",
					order.getCommodityId(), (short) 1);
			order.setDealerId(example.getDealerId());
			String result0 = this.insertRegisterFee(order);// 插入a注册费流水
			String result2 = this.unfrozenStock(order);// 解冻库存
			example.setApprovalStatus(DeliveryConstant.StatusType.TRANSFERRED
					.getCode());
			deliveryordermapper.updateByPrimaryKey(example);

			if (result0.equals("true") && result1.equals("true")
					&& result2.equals("true")) {
				return "true";
			}
			return "false";
		}
		return null;

	}

	@Override
	public String setExpressFee(DeliveryOrder order, Express express) {
		Log.info("设置配送费用");
		IpoDeliveryorder deorder = new IpoDeliveryorder();
		IpoExpress ipoexpress = new IpoExpress();
		if (order != null) {
			if (express != null) {
				BeanUtils.copyProperties(order, deorder);
				BeanUtils.copyProperties(express, ipoexpress);
				int num = deliveryordermapper.updateByPrimaryKey(deorder);
				int onum = ipoexpressmapper.updateByPrimaryKey(ipoexpress);
				if (onum == 1 && num == 1) {
					return "true";
				}
			}
		}
		return "false";
	}

	@Override
	public String unfrozenStock(DeliveryOrder order) {
		// 解冻库存
		IpoWarehouseStock stock = ipoWarehouseStockMapper.selectByCommoId(
				order.getCommodityId(), Long.parseLong(order.getWarehouseId()));
		if (stock != null) {
			long frozennum = stock.getForzennum();
			long available = stock.getAvailablenum();
			long newfrozen = frozennum - order.getDeliveryQuatity();
			long newavailble = available + order.getDeliveryQuatity();
			stock.setForzennum(newfrozen);
			stock.setAvailablenum(newavailble);
			log.info("冻结数量：" + stock.getForzennum() + "有效数量："
					+ stock.getAvailablenum() + "入库数量：" + stock.getStoragenum()
					+ "出库数量：" + stock.getOutboundnum());
			int snum = ipoWarehouseStockMapper.updateInfo(stock);
			if (snum == 1) {
				return "true";
			}
		}
		return "false";
	}

	@Override
	@Transactional
	public String insertTransferFee(DeliveryOrder order) {
		// 冻结过户费并插入过户费流水
		DebitFlow debitFlow = new DebitFlow();
		IpoCommodityConf commodity = ipoCommodityConfmapper
				.findIpoCommConfByCommid(order.getCommodityId());
		if (commodity != null) {
			BigDecimal transferFee = commodity.getTransferfeeradio();
			BigDecimal funds = new BigDecimal(order.getDeliveryQuatity())
					.multiply(commodity.getPrice()).multiply(transferFee)
					.divide(new BigDecimal(100));
			String flag = this.freezenFunds(order.getDealerId(), funds);
			if (("false").equals(flag)) {
				return "fundshort";
			}
			debitFlow.setAmount(funds);
			debitFlow.setBusinessType(ChargeConstant.BusinessType.DELIVERY
					.getCode());
			debitFlow.setChargeType(ChargeConstant.ChargeType.CHANGE_OWNER
					.getCode());
			debitFlow.setCommodityId(order.getCommodityId());
			debitFlow.setOrderId(String.valueOf(order.getDeliveryorderId()));
			debitFlow.setDebitState(ChargeConstant.DebitState.FROZEN_SUCCESS
					.getCode());
			debitFlow.setPayer(order.getDealerId());
			debitFlow.setDebitMode(ChargeConstant.DebitMode.ONLINE.getCode());
			debitFlow.setDebitChannel(ChargeConstant.DebitChannel.DEPOSIT
					.getCode());
			debitFlow.setCreateUser(order.getDealerId());
			debitFlow.setCreateDate(new Date());
			debitFlowMapper.insert(debitFlow);

			return "true";
		}
		return "false";
	}

	@Transactional
	public String insertRegisterFee(DeliveryOrder order) {
		// 注册费流水
		DebitFlow debitFlow = new DebitFlow();
		IpoCommodityConf commodity = ipoCommodityConfmapper
				.findIpoCommConfByCommid(order.getCommodityId());
		IpoDeliveryCost cost = ipoDeliveryCostMapper.selectByPrimaryKey(order
				.getDeliveryorderId());
		if (commodity != null && cost != null) {
			BigDecimal funds = cost.getRegistrationFee();
			debitFlow.setAmount(funds);
			debitFlow.setBusinessType(ChargeConstant.BusinessType.DELIVERY
					.getCode());
			debitFlow.setChargeType(ChargeConstant.ChargeType.REGISTER
					.getCode());
			debitFlow.setCommodityId(order.getCommodityId());
			debitFlow.setOrderId(String.valueOf(order.getDeliveryorderId()));
			debitFlow.setDebitState(ChargeConstant.DebitState.FROZEN_SUCCESS
					.getCode());
			debitFlow.setPayer(order.getDealerId());
			debitFlow.setDebitMode(ChargeConstant.DebitMode.ONLINE.getCode());
			debitFlow.setDebitChannel(ChargeConstant.DebitChannel.DEPOSIT
					.getCode());
			debitFlow.setCreateUser(order.getDealerId());
			debitFlow.setCreateDate(new Date());
			debitFlowMapper.insert(debitFlow);
			return "true";
		}
		return "false";
	}

	@Transactional
	public String insertExpressFee(DeliveryOrder order) {
		// 配送费流水
		DebitFlow debitFlow = new DebitFlow();
		IpoCommodityConf commodity = ipoCommodityConfmapper
				.findIpoCommConfByCommid(order.getCommodityId());
		IpoExpress express = ipoexpressmapper.selectByPrimaryKey(order
				.getMethodId());
		if (commodity != null && express != null) {
			BigDecimal funds = express.getCost();
			debitFlow.setAmount(funds);
			debitFlow.setBusinessType(ChargeConstant.BusinessType.DELIVERY
					.getCode());
			debitFlow.setChargeType(ChargeConstant.ChargeType.CARRIAGE
					.getCode());
			debitFlow.setCommodityId(order.getCommodityId());
			debitFlow.setOrderId(String.valueOf(order.getDeliveryorderId()));
			debitFlow.setDebitState(ChargeConstant.DebitState.FROZEN_SUCCESS
					.getCode());
			debitFlow.setPayer(order.getDealerId());
			debitFlow.setDebitMode(ChargeConstant.DebitMode.ONLINE.getCode());
			debitFlow.setDebitChannel(ChargeConstant.DebitChannel.DEPOSIT
					.getCode());
			debitFlow.setCreateUser(order.getDealerId());
			debitFlow.setCreateDate(new Date());
			debitFlowMapper.insert(debitFlow);
			return "true";
		}
		return "false";
	}

	@Override
	public DeliveryCost getCostByDeliveryOrder(DeliveryOrder order) {
		IpoDeliveryCost record = ipoDeliveryCostMapper.selectByPrimaryKey(order
				.getDeliveryorderId());
		if (record != null) {
			DeliveryCost result = new DeliveryCost();
			BeanUtils.copyProperties(record, result);
			return result;
		}
		return null;
	}

	@Override
	public String freezenFunds(String firmId, BigDecimal amount) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("money", "");
		param.put("userid", firmId);
		param.put("lock", 0);
		fundsMapper.getMonery(param);
		BigDecimal money = (BigDecimal) param.get("money");
		if (money.compareTo(amount) != -1) {
			Map<String, Object> param1 = new HashMap<String, Object>();
			param1.put("money", "");
			param1.put("userid", firmId);
			param1.put("amount", amount);
			param1.put("moduleid", "40");
			fundsMapper.getfrozen(param1);
			return "true";
		} else {
			return "false";
		}
	}
}
