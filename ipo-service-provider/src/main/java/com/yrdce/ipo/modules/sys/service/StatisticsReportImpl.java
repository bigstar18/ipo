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
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryCost;
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
		List<IpoDeliveryorder> deliveryOrderList = DeliveryorderMapper.findByFirmIdAndDate(firmId, date);
		List<Billoflading> list = new ArrayList<Billoflading>();
		for (IpoDeliveryorder ipoDeliveryorder : deliveryOrderList) {
			String id = ipoDeliveryorder.getDeliveryorderId();
			String commodityId = ipoDeliveryorder.getCommodityId();
			String commodityName = ipoDeliveryorder.getCommodityName();
			//TODO  三目运算应拿掉，数据空缺，零时放置
			long counts = ipoDeliveryorder.getDeliveryCounts() != null ? ipoDeliveryorder.getDeliveryCounts()
					: 0;
			long quatity = ipoDeliveryorder.getDeliveryQuatity();
			String method = ipoDeliveryorder.getDeliveryMethod();
			IpoDeliveryCost ipoDeliveryCost = ipoDeliveryCostMapper.selectByPrimaryKey(id);
			//BigDecimal deliveryFee = ipoDeliveryCost.getDeliveryFee() != null
			//		? ipoDeliveryCost.getDeliveryFee() : new BigDecimal(0);
			BigDecimal rFee = ipoDeliveryCost.getRegistrationFee() != null
					? ipoDeliveryCost.getRegistrationFee() : new BigDecimal(0);
			BigDecimal cFee = ipoDeliveryCost.getCancellationFee() != null
					? ipoDeliveryCost.getCancellationFee() : new BigDecimal(0);
			BigDecimal insurance = ipoDeliveryCost.getInsurance() != null ? ipoDeliveryCost.getInsurance()
					: new BigDecimal(0);
			BigDecimal trudteeFee = ipoDeliveryCost.getTrusteeFee() != null ? ipoDeliveryCost.getTrusteeFee()
					: new BigDecimal(0);
			BigDecimal warehouseFee = ipoDeliveryCost.getWarehousingFee() != null
					? ipoDeliveryCost.getWarehousingFee() : new BigDecimal(0);
			Billoflading ipoBilloflading = new Billoflading();
			ipoBilloflading.setCommodityid(commodityId);
			ipoBilloflading.setCommodityname(commodityName);
			ipoBilloflading.setCounts(counts);
			ipoBilloflading.setQuantity(quatity);
			ipoBilloflading.setDeliverytype(method);
			ipoBilloflading.setBillofladingfee(rFee.add(cFee));
			ipoBilloflading.setWarehousingfee(warehouseFee);
			ipoBilloflading.setInsurance(insurance);
			ipoBilloflading.setTrusteefee(trudteeFee);
			list.add(ipoBilloflading);
		}
		return list;
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
				BigDecimal cost = ipoExpress.getCost();
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
