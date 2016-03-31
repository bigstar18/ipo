package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.text.ParseException;
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
import org.springframework.stereotype.Service;

import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDebitFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryCostMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryorderMapper;
import com.yrdce.ipo.modules.sys.dao.IpoExpressMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.dao.TCustomerholdsumMapper;
import com.yrdce.ipo.modules.sys.dao.TFirmHoldSumMaper;
import com.yrdce.ipo.modules.sys.dao.THFirmholdsumMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoDebitFlow;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;
import com.yrdce.ipo.modules.sys.entity.IpoExpress;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.entity.TCustomerholdsum;
import com.yrdce.ipo.modules.sys.entity.TFirmHoldSum;
import com.yrdce.ipo.modules.sys.vo.Billoflading;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.Delivery;
import com.yrdce.ipo.modules.sys.vo.FundSettlement;
import com.yrdce.ipo.modules.sys.vo.Holdcommodity;
import com.yrdce.ipo.modules.sys.vo.Order;
import com.yrdce.ipo.modules.sys.vo.Releasesubscription;

/**
 * @ClassName: StatisticsReportImpl
 * @Description:统计报表
 * @author bob
 */
@Service
public class StatisticsReportImpl implements StatisticsReportService {
	Logger logger = LoggerFactory.getLogger(StatisticsReportImpl.class);
	@Autowired
	private IpoCommodityConfMapper ipoCommodityConfMapper;
	@Autowired
	private IpoOrderMapper ipoOrderMapper;
	@Autowired
	private THFirmholdsumMapper hFirmholdsumMapper;
	@Autowired
	private IpoCommodityConfMapper ipoComConfMapper;
	@Autowired
	private TCustomerholdsumMapper tCustomerholdsumMapper;
	@Autowired
	private IpoDeliveryorderMapper DeliveryorderMapper;
	@Autowired
	private IpoDeliveryCostMapper ipoDeliveryCostMapper;
	@Autowired
	private IpoDebitFlowMapper ipoDebitFlowMapper;
	@Autowired
	private IpoExpressMapper ipoExpressMapper;
	@Autowired
	private IpoDeliveryMapper ipoDeliveryMapper;
	@Autowired
	private TFirmHoldSumMaper tFirmHoldSumMaper;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Override
	public Map<String, String> cGetCommIdList() {
		List<IpoCommodityConf> commidList = ipoCommodityConfMapper.findAllIpoCommConfs();
		Map<String, String> comMap = new HashMap<String, String>();
		for (IpoCommodityConf commodityConf : commidList) {
			String id = commodityConf.getCommodityid();
			String name = commodityConf.getCommodityname();
			comMap.put(id, name);
		}
		return comMap;
	}

	@Override
	public List<Order> oGetOrderList(String commid, String time) {
		List<IpoOrder> list1 = ipoOrderMapper.findCommidAndDate(commid, time);
		List<Order> list2 = new ArrayList<Order>();
		for (IpoOrder ipoOrder : list1) {
			Order order = new Order();
			BeanUtils.copyProperties(ipoOrder, order);
			list2.add(order);
		}
		return list2;
	}

	@Override
	public Commodity cGetCommd(String commid) {
		IpoCommodityConf commdInfo = ipoCommodityConfMapper.findIpoCommConfByCommid(commid);
		Commodity commodity = new Commodity();
		if (commdInfo != null) {
			BeanUtils.copyProperties(commdInfo, commodity);
			BigDecimal price = commdInfo.getPrice();
			double priceParam = price.doubleValue();
			commodity.setPrice(priceParam);
		}
		return commodity;
	}

	@Override
	public List<String> findAllFirmid() {
		List<String> firmIdList = DeliveryorderMapper.queryAllFrimId();
		return firmIdList;
	}

	@Override
	public String firmName(String firmId) {
		String firmName = DeliveryorderMapper.selectByFrim(firmId);
		return firmName;
	}

	@Override
	public String nGetComName(String comid) {
		IpoCommodityConf ipoCommodityConf = ipoComConfMapper.findIpoCommConfByCommid(comid);
		String commodityName = ipoCommodityConf.getCommodityname();
		return commodityName;
	}

	@Override
	public List<Holdcommodity> hGetHold(String date, String firmid) {
		List<TFirmHoldSum> holdList = hFirmholdsumMapper.findByComIdAndFirmId(date, firmid, null);
		List<Holdcommodity> list = new ArrayList<Holdcommodity>();
		if (holdList.size() != 0)
			for (TFirmHoldSum tFirmHoldSum : holdList) {
				String commodityid = tFirmHoldSum.getCommodityId();
				String commodityName = nGetComName(commodityid);
				Holdcommodity holdcommodity = new Holdcommodity();
				holdcommodity.setFirmid(tFirmHoldSum.getFirmId());
				holdcommodity.setCommodityid(tFirmHoldSum.getCommodityId());
				holdcommodity.setEvenprice(tFirmHoldSum.getEvenPrice());
				holdcommodity.setHoldqty(tFirmHoldSum.getHoldqty());
				holdcommodity.setHoldinggainsandlosses(tFirmHoldSum.getFloatingLoss());
				holdcommodity.setCommodityname(commodityName);
				list.add(holdcommodity);
			}
		return list;
	}

	@Override
	public List<Holdcommodity> holdByCom(String date, String comid) {
		List<TFirmHoldSum> holdList = hFirmholdsumMapper.findByComIdAndFirmId(date, null, comid);
		List<Holdcommodity> list = new ArrayList<Holdcommodity>();
		if (holdList.size() != 0)
			for (TFirmHoldSum tFirmHoldSum : holdList) {
				String commodityid = tFirmHoldSum.getCommodityId();
				IpoCommodityConf ipoCommodityConf = ipoComConfMapper.findIpoCommConfByCommid(commodityid);
				String commodityName = ipoCommodityConf.getCommodityname();
				Holdcommodity holdcommodity = new Holdcommodity();
				holdcommodity.setFirmid(tFirmHoldSum.getFirmId());
				holdcommodity.setCommodityid(tFirmHoldSum.getCommodityId());
				holdcommodity.setEvenprice(tFirmHoldSum.getEvenPrice());
				holdcommodity.setHoldqty(tFirmHoldSum.getHoldqty());
				holdcommodity.setHoldinggainsandlosses(tFirmHoldSum.getFloatingLoss());
				holdcommodity.setCommodityname(commodityName);
				list.add(holdcommodity);
			}
		return list;
	}

	@Override
	public Map<String, String> findAllComid() {
		Map<String, String> comMap = new HashMap<String, String>();
		List<String> comidList = tFirmHoldSumMaper.findAllCom();
		for (String id : comidList) {
			IpoCommodityConf ipoCommodityConf = ipoComConfMapper.findIpoCommConfByCommid(id);
			if (ipoCommodityConf != null) {
				String commodityName = ipoCommodityConf.getCommodityname();
				comMap.put(id, commodityName);
			}
		}
		return comMap;
	}

	/**
	 * @Title: getFund
	 * @Description: 资金结算信息（客户端）
	 * @param firmId
	 * @param date
	 */

	@Override
	public FundSettlement fGetFund(String firmId, String date) {
		logger.info("资金结算信息（客户端）");
		FundSettlement fundSettlement = new FundSettlement();
		return fundSettlement;

	}

	/**
	 * @Title: getReleaInfo
	 * @Description: 申购明细（客户端）
	 * @param firmId
	 * @param date
	 */

	@Override
	public List<Releasesubscription> rGetReleaInfo(String firmId, String date) {
		logger.info("申购明细（客户端）");
		List<IpoOrder> orderList = ipoOrderMapper.findFirmIdAndDate(firmId, date);
		List<Releasesubscription> list = new ArrayList<Releasesubscription>();
		if (orderList != null || !orderList.isEmpty()) {
			for (IpoOrder ipoOrder : orderList) {
				String commodityId = ipoOrder.getCommodityid();
				String commodityName = ipoOrder.getCommodityname();
				Date createTime = ipoOrder.getCreatetime();
				int counts = ipoOrder.getCounts();
				BigDecimal frozenfunds = ipoOrder.getFrozenfunds();
				BigDecimal frozenfee = ipoOrder.getFrozencounterfee();
				BigDecimal unfreezefunds = ipoOrder.getUnfreezefunds();
				BigDecimal unfreezefees = ipoOrder.getUnfreezefees();
				IpoCommodityConf ipoCommodityConf = ipoComConfMapper.findIpoCommConfByCommid(commodityId);
				BigDecimal price = ipoCommodityConf.getPrice();
				// 插入发行申购汇总表
				Releasesubscription ipoReleasesubscription = new Releasesubscription();
				ipoReleasesubscription.setCommodityid(commodityId);
				ipoReleasesubscription.setCommodityname(commodityName);
				ipoReleasesubscription.setCreatetime(new Date());
				ipoReleasesubscription.setIssuancefee(frozenfee);
				ipoReleasesubscription.setIssueprice(price);
				ipoReleasesubscription.setPurchaseamount(frozenfunds);
				ipoReleasesubscription.setPurchasequantity(counts);
				ipoReleasesubscription.setPurchasetime(createTime);
				ipoReleasesubscription.setRefundablepurchaseamount(unfreezefunds);
				ipoReleasesubscription.setRefundableservicefee(unfreezefees);
				list.add(ipoReleasesubscription);
			}
		}
		return list;
	}

	/**
	 * @Title: getHoldInfo
	 * @Description: 商品持有表（客户端）
	 * @param firmId
	 * @param date
	 */

	@Override
	public List<Holdcommodity> hGetHoldInfo(String firmId, String date) {
		logger.info("商品持有表（客户端）");
		List<TCustomerholdsum> customerholdList = tCustomerholdsumMapper.findFirmIdAndDate(firmId, date);
		List<Holdcommodity> list = new ArrayList<Holdcommodity>();
		for (TCustomerholdsum tCustomerholdsum : customerholdList) {
			String commodityid = tCustomerholdsum.getCommodityid();
			BigDecimal evenPrice = tCustomerholdsum.getEvenprice();
			BigDecimal floatingLoss = tCustomerholdsum.getFloatingloss();
			long frozenqty = tCustomerholdsum.getFrozenqty();
			long holdqty = tCustomerholdsum.getHoldqty();
			long available = holdqty - frozenqty;
			IpoCommodityConf ipoCommodityConf = ipoComConfMapper.findIpoCommConfByCommid(commodityid);
			String commodityName = "null";
			BigDecimal price = null;
			BigDecimal value = null;
			if (ipoCommodityConf != null) {
				commodityName = ipoCommodityConf.getCommodityname();
				price = ipoCommodityConf.getPrice();
				value = (new BigDecimal(holdqty)).multiply(price);
			}
			Holdcommodity ipoHoldcommodity = new Holdcommodity();
			ipoHoldcommodity.setCommodityid(commodityid);
			ipoHoldcommodity.setCommodityname(commodityName);
			ipoHoldcommodity.setEvenprice(evenPrice);
			ipoHoldcommodity.setFrozenqty(frozenqty);
			ipoHoldcommodity.setHoldinggainsandlosses(floatingLoss);
			ipoHoldcommodity.setHoldqty(holdqty);
			ipoHoldcommodity.setQuantityavailable(available);
			ipoHoldcommodity.setPrice(price);
			ipoHoldcommodity.setMarketvalue(value);
			list.add(ipoHoldcommodity);
		}
		return list;
	}

	/**
	 * @Title: getBillfladInfo
	 * @Description: 商品提货单表（客户端）
	 * @param firmId
	 * @param date
	 */

	@Override
	public List<Billoflading> bGetBillfladInfo(String firmId, String date) {
		logger.info("商品提货单表（客户端）");

		IpoDebitFlow ipoDebitFlow = new IpoDebitFlow();
		Date time = null;
		try {
			time = sdf.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ipoDebitFlow.setCreateDate(time);
		ipoDebitFlow.setPayer(firmId);
		//注册费
		String delivery = ChargeConstant.BusinessType.DELIVERY.getCode();
		String register = ChargeConstant.ChargeType.REGISTER.getCode();
		ipoDebitFlow.setBusinessType(delivery);
		ipoDebitFlow.setChargeType(register);
		List<IpoDebitFlow> debitFlowList1 = ipoDebitFlowMapper.findInfo(ipoDebitFlow);
		//注销费
		String cancel = ChargeConstant.ChargeType.CANCEL.getCode();
		ipoDebitFlow.setChargeType(cancel);
		List<IpoDebitFlow> debitFlowList2 = ipoDebitFlowMapper.findInfo(ipoDebitFlow);
		//仓储费
		String warehousing = ChargeConstant.ChargeType.WAREHOUSING.getCode();
		ipoDebitFlow.setChargeType(warehousing);
		List<IpoDebitFlow> debitFlowList3 = ipoDebitFlowMapper.findInfo(ipoDebitFlow);
		//保险费
		String insurance = ChargeConstant.ChargeType.INSURANCE.getCode();
		ipoDebitFlow.setChargeType(insurance);
		List<IpoDebitFlow> debitFlowList4 = ipoDebitFlowMapper.findInfo(ipoDebitFlow);
		//托管费
		String trustee = ChargeConstant.ChargeType.TRUSTEE.getCode();
		ipoDebitFlow.setChargeType(trustee);
		List<IpoDebitFlow> debitFlowList5 = ipoDebitFlowMapper.findInfo(ipoDebitFlow);

		List<Billoflading> bIpoBillofladings = new ArrayList<Billoflading>();
		if (debitFlowList1.size() != 0) {
			for (IpoDebitFlow register1 : debitFlowList1) {
				String id = register1.getOrderId();
				IpoDeliveryorder ipoDeliveryorder = DeliveryorderMapper.selectByPrimaryKey(id);
				Billoflading ipoBilloflading = setBilloflading(ipoDeliveryorder);
				String deliveryId = register1.getOrderId();
				BigDecimal deliveryMoery = register1.getAmount();
				ipoBilloflading.setBillofladingfee(deliveryMoery);
				for (IpoDebitFlow cancel1 : debitFlowList2) {
					String cancelId = cancel1.getOrderId();
					if (deliveryId.equals(cancelId)) {
						BigDecimal cancelMoney = cancel1.getAmount();
						ipoBilloflading
								.setBillofladingfee(ipoBilloflading.getBillofladingfee().add(cancelMoney));
					}
				}
				for (IpoDebitFlow warehousing1 : debitFlowList3) {
					String warehousingId = warehousing1.getOrderId();
					if (deliveryId.equals(warehousingId)) {
						BigDecimal warehousingMoney = warehousing1.getAmount();
						ipoBilloflading.setWarehousingfee(warehousingMoney);
					}
				}
				for (IpoDebitFlow insurance1 : debitFlowList4) {
					String insuranceId = insurance1.getOrderId();
					if (deliveryId.equals(insuranceId)) {
						BigDecimal insuranceMoney = insurance1.getAmount();
						ipoBilloflading.setInsurance(insuranceMoney);
					}
				}
				for (IpoDebitFlow trustee1 : debitFlowList5) {
					String trusteeId = trustee1.getOrderId();
					if (deliveryId.equals(trusteeId)) {
						BigDecimal trusteeMoney = trustee1.getAmount();
						ipoBilloflading.setTrusteefee(trusteeMoney);
					}
				}
				bIpoBillofladings.add(ipoBilloflading);
			}
		} else if (debitFlowList2.size() != 0) {
			for (IpoDebitFlow cancel1 : debitFlowList2) {
				String id = cancel1.getOrderId();
				IpoDeliveryorder ipoDeliveryorder = DeliveryorderMapper.selectByPrimaryKey(id);
				Billoflading ipoBilloflading = setBilloflading(ipoDeliveryorder);
				String deliveryId = cancel1.getOrderId();
				String cancelId = cancel1.getOrderId();
				if (deliveryId.equals(cancelId)) {
					BigDecimal cancelMoney = cancel1.getAmount();
					ipoBilloflading.setBillofladingfee(ipoBilloflading.getBillofladingfee().add(cancelMoney));
				}

				for (IpoDebitFlow warehousing1 : debitFlowList3) {
					String warehousingId = warehousing1.getOrderId();
					if (deliveryId.equals(warehousingId)) {
						BigDecimal warehousingMoney = warehousing1.getAmount();
						ipoBilloflading.setWarehousingfee(warehousingMoney);
					}
				}
				for (IpoDebitFlow insurance1 : debitFlowList4) {
					String insuranceId = insurance1.getOrderId();
					if (deliveryId.equals(insuranceId)) {
						BigDecimal insuranceMoney = insurance1.getAmount();
						ipoBilloflading.setInsurance(insuranceMoney);
					}
				}
				for (IpoDebitFlow trustee1 : debitFlowList5) {
					String trusteeId = trustee1.getOrderId();
					if (deliveryId.equals(trusteeId)) {
						BigDecimal trusteeMoney = trustee1.getAmount();
						ipoBilloflading.setTrusteefee(trusteeMoney);
					}
				}
				bIpoBillofladings.add(ipoBilloflading);
			}
		} else if (debitFlowList3.size() != 0) {
			for (IpoDebitFlow warehousing1 : debitFlowList3) {
				String id = warehousing1.getOrderId();
				IpoDeliveryorder ipoDeliveryorder = DeliveryorderMapper.selectByPrimaryKey(id);
				Billoflading ipoBilloflading = setBilloflading(ipoDeliveryorder);
				String deliveryId = warehousing1.getOrderId();
				String warehousingId = warehousing1.getOrderId();
				if (deliveryId.equals(warehousingId)) {
					BigDecimal warehousingMoney = warehousing1.getAmount();
					ipoBilloflading.setWarehousingfee(warehousingMoney);
				}
				for (IpoDebitFlow insurance1 : debitFlowList4) {
					String insuranceId = insurance1.getOrderId();
					if (deliveryId.equals(insuranceId)) {
						BigDecimal insuranceMoney = insurance1.getAmount();
						ipoBilloflading.setInsurance(insuranceMoney);
					}
				}
				for (IpoDebitFlow trustee1 : debitFlowList5) {
					String trusteeId = trustee1.getOrderId();
					if (deliveryId.equals(trusteeId)) {
						BigDecimal trusteeMoney = trustee1.getAmount();
						ipoBilloflading.setTrusteefee(trusteeMoney);
					}
				}
				bIpoBillofladings.add(ipoBilloflading);
			}
		} else if (debitFlowList4.size() != 0) {
			for (IpoDebitFlow insurance1 : debitFlowList4) {
				String id = insurance1.getOrderId();
				IpoDeliveryorder ipoDeliveryorder = DeliveryorderMapper.selectByPrimaryKey(id);
				Billoflading ipoBilloflading = setBilloflading(ipoDeliveryorder);
				String deliveryId = insurance1.getOrderId();
				String insuranceId = insurance1.getOrderId();
				if (deliveryId.equals(insuranceId)) {
					BigDecimal insuranceMoney = insurance1.getAmount();
					ipoBilloflading.setInsurance(insuranceMoney);
				}
				for (IpoDebitFlow trustee1 : debitFlowList5) {
					String trusteeId = trustee1.getOrderId();
					if (deliveryId.equals(trusteeId)) {
						BigDecimal trusteeMoney = trustee1.getAmount();
						ipoBilloflading.setTrusteefee(trusteeMoney);
					}
				}
				bIpoBillofladings.add(ipoBilloflading);
			}
		} else if (debitFlowList5.size() != 0) {
			for (IpoDebitFlow trustee1 : debitFlowList5) {
				String id = trustee1.getOrderId();
				IpoDeliveryorder ipoDeliveryorder = DeliveryorderMapper.selectByPrimaryKey(id);
				BigDecimal trusteeMoney = trustee1.getAmount();
				Billoflading ipoBilloflading = setBilloflading(ipoDeliveryorder);
				ipoBilloflading.setTrusteefee(trusteeMoney);
				bIpoBillofladings.add(ipoBilloflading);
			}
		}
		return bIpoBillofladings;
	}

	private Billoflading setBilloflading(IpoDeliveryorder deliveryorder) {
		Billoflading ipoBilloflading = new Billoflading();
		ipoBilloflading.setCommodityid(deliveryorder.getCommodityId());
		ipoBilloflading.setCommodityname(deliveryorder.getCommodityName());
		ipoBilloflading.setCounts(deliveryorder.getDeliveryCounts());
		ipoBilloflading.setQuantity(deliveryorder.getDeliveryQuatity());
		ipoBilloflading.setDeliverytype(deliveryorder.deliveryMethod);
		return ipoBilloflading;
	}

	/**
	 * @Title: getDeliveryInfo
	 * @Description: 商品过户、提货表（客户端）
	 * @param firmId
	 * @param date
	 */
	@Override
	public List<Delivery> dGetDeliveryInfo(String firmId, String date) {
		logger.info(" 商品过户、提货表（客户端）");
		String businessType = ChargeConstant.BusinessType.DELIVERY.getCode();
		String chargeType = ChargeConstant.ChargeType.CHANGE_OWNER.getCode();
		IpoDebitFlow ipoDelivery = new IpoDebitFlow();
		ipoDelivery.setBusinessType(businessType);
		ipoDelivery.setChargeType(chargeType);
		List<Delivery> list = new ArrayList<Delivery>();
		try {
			Date time = sdf.parse(date);
			ipoDelivery.setCreateDate(time);
			ipoDelivery.setPayer(firmId);
			List<IpoDebitFlow> bebitFlowList = ipoDebitFlowMapper.findInfo(ipoDelivery);
			for (IpoDebitFlow ipoDebitFlow : bebitFlowList) {
				String id = ipoDebitFlow.getOrderId();
				BigDecimal amount = ipoDebitFlow.getAmount();
				IpoDeliveryorder deliveryOrder = DeliveryorderMapper.selectByPrimaryKey(id);
				String commodityId = deliveryOrder.getCommodityId();
				String commodityName = deliveryOrder.getCommodityName();
				long counts = deliveryOrder.getDeliveryCounts() != null ? deliveryOrder.getDeliveryCounts()
						: 0;
				long quatity = deliveryOrder.getDeliveryQuatity();
				String method = deliveryOrder.getDeliveryMethod();
				IpoExpress ipoExpress = ipoExpressMapper.selectExpress(id);
				BigDecimal cost = new BigDecimal(0);
				if (ipoExpress != null) {
					cost = ipoExpress.getCost();
				}
				Delivery delivery = new Delivery();
				delivery.setCommodityid(commodityId);
				delivery.setCommodityname(commodityName);
				delivery.setCounts(counts);
				delivery.setQuantity(quatity);
				delivery.setDeliverytype(method);
				delivery.setTransferfee(amount);
				delivery.setPostage(cost);
				list.add(delivery);
			}
			return list;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return list;
	}

}
