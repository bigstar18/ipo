package com.yrdce.ipo.common.task;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.modules.sys.dao.BrBrokerMapper;
import com.yrdce.ipo.modules.sys.dao.IpoBillofladingMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDebitFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryCostMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryorderMapper;
import com.yrdce.ipo.modules.sys.dao.IpoExpressMapper;
import com.yrdce.ipo.modules.sys.dao.IpoHoldcommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.dao.IpoReleasesubscriptionMapper;
import com.yrdce.ipo.modules.sys.dao.TCustomerholdsumMapper;
import com.yrdce.ipo.modules.sys.entity.BrBroker;
import com.yrdce.ipo.modules.sys.entity.IpoBilloflading;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoDebitFlow;
import com.yrdce.ipo.modules.sys.entity.IpoDelivery;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryCost;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;
import com.yrdce.ipo.modules.sys.entity.IpoExpress;
import com.yrdce.ipo.modules.sys.entity.IpoHoldcommodity;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.entity.IpoReleasesubscription;
import com.yrdce.ipo.modules.sys.entity.TCustomerholdsum;

/**
 * 
 * @ClassName: BrokerTask
 * @Description: 经济会员报表数据汇总
 * @author bob
 */
public class BrokerTask {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private BrBrokerMapper brokerMapper;
	@Autowired
	private IpoOrderMapper orderMapper;
	@Autowired
	private IpoCommodityConfMapper ipoComConfMapper;
	@Autowired
	private IpoReleasesubscriptionMapper ReleasesubMapper;
	@Autowired
	private IpoDeliveryorderMapper DeliveryorderMapper;
	@Autowired
	private IpoDeliveryCostMapper ipoDeliveryCostMapper;
	@Autowired
	private IpoBillofladingMapper ipoBillofladingMapper;
	@Autowired
	private IpoDebitFlowMapper ipoDebitFlowMapper;
	@Autowired
	private IpoExpressMapper ipoExpressMapper;
	@Autowired
	private IpoDeliveryMapper ipoDeliveryMapper;
	@Autowired
	private TCustomerholdsumMapper tCustomerholdsumMapper;
	@Autowired
	private IpoHoldcommodityMapper ipoHoldcommodityMapper;

	/**
	 * @Title: releasesub
	 * @Description: 发行申购明细
	 */
	@Transactional
	public void releasesub() {
		logger.info("经纪会员发行申购明细汇总开始执行");
		List<BrBroker> brokersList = brokerMapper.findMemberTrader();
		for (BrBroker ipoBroker : brokersList) {
			String brokerid = ipoBroker.getBrokerid();
			String brokername = ipoBroker.getName();
			String firmid = ipoBroker.getFirmid();
			List<IpoOrder> orderList = orderMapper.selectByfirmid(firmid);
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
					IpoReleasesubscription ipoReleasesubscription = new IpoReleasesubscription();
					ipoReleasesubscription.setBrokerid(brokerid);
					ipoReleasesubscription.setBrokername(brokername);
					ipoReleasesubscription.setCommodityid(commodityId);
					ipoReleasesubscription.setCommodityname(commodityName);
					ipoReleasesubscription.setCreatetime(new Date());
					ipoReleasesubscription.setFirmid(firmid);
					ipoReleasesubscription.setIssuancefee(frozenfee);
					ipoReleasesubscription.setIssueprice(price);
					ipoReleasesubscription.setPurchaseamount(frozenfunds);
					ipoReleasesubscription.setPurchasequantity(counts);
					ipoReleasesubscription.setPurchasetime(createTime);
					ipoReleasesubscription.setRefundablepurchaseamount(unfreezefunds);
					ipoReleasesubscription.setRefundableservicefee(unfreezefees);
					ReleasesubMapper.insert(ipoReleasesubscription);
				}
			}
		}
	}

	/**
	 * @Title: billoFlading
	 * @Description: 商品提货单
	 */
	@Transactional
	public void billoFlading() {
		logger.info("经纪会员商品提货单汇总开始执行");
		List<BrBroker> brokersList = brokerMapper.findMemberTrader();
		for (BrBroker ipoBroker : brokersList) {
			String brokerid = ipoBroker.getBrokerid();
			String brokername = ipoBroker.getName();
			String firmid = ipoBroker.getFirmid();
			List<IpoDeliveryorder> deliveryOrderList = DeliveryorderMapper.selectFirmid(firmid);
			for (IpoDeliveryorder ipoDeliveryorder : deliveryOrderList) {
				String id = ipoDeliveryorder.getDeliveryorderId();
				logger.info("String id={}", id);
				String commodityId = ipoDeliveryorder.getCommodityId();
				logger.info("String commodityId={}", commodityId);
				String commodityName = ipoDeliveryorder.getCommodityName();
				logger.info("String commodityName ={}", commodityName);
				//TODO  三目运算应拿掉，数据空缺，零时放置
				long counts = ipoDeliveryorder.getDeliveryCounts() != null
						? ipoDeliveryorder.getDeliveryCounts() : 0;
				logger.info("long counts ={}", counts);
				long quatity = ipoDeliveryorder.getDeliveryQuatity();
				logger.info("long quatity ={}", quatity);
				String method = ipoDeliveryorder.getDeliveryMethod();
				Date apply = ipoDeliveryorder.getApplyDate();
				IpoDeliveryCost ipoDeliveryCost = ipoDeliveryCostMapper.selectByPrimaryKey(id);
				BigDecimal deliveryFee = ipoDeliveryCost.getDeliveryFee() != null
						? ipoDeliveryCost.getDeliveryFee() : new BigDecimal(0);
				BigDecimal insurance = ipoDeliveryCost.getInsurance() != null ? ipoDeliveryCost.getInsurance()
						: new BigDecimal(0);
				BigDecimal trudteeFee = ipoDeliveryCost.getTrusteeFee() != null
						? ipoDeliveryCost.getTrusteeFee() : new BigDecimal(0);
				BigDecimal warehouseFee = ipoDeliveryCost.getWarehousingFee() != null
						? ipoDeliveryCost.getWarehousingFee() : new BigDecimal(0);
				IpoBilloflading ipoBilloflading = new IpoBilloflading();
				ipoBilloflading.setBrokerid(brokerid);
				ipoBilloflading.setBrokername(brokername);
				ipoBilloflading.setFirmid(firmid);
				ipoBilloflading.setCommodityid(commodityId);
				ipoBilloflading.setCommodityname(commodityName);
				ipoBilloflading.setCounts(counts);
				ipoBilloflading.setQuantity(quatity);
				ipoBilloflading.setDeliverytype(method);
				ipoBilloflading.setBillofladingfee(deliveryFee);
				ipoBilloflading.setWarehousingfee(warehouseFee);
				ipoBilloflading.setInsurance(insurance);
				ipoBilloflading.setTrusteefee(trudteeFee);
				ipoBilloflading.setRegistrationdate(apply);
				ipoBilloflading.setCreatetime(new Date());
				ipoBillofladingMapper.insert(ipoBilloflading);
			}
		}
	}

	/**
	 * @Title: delivery
	 * @Description: 提货表
	 */
	@Transactional
	public void delivery() {
		logger.info("经纪会员提货表汇总开始执行");
		List<BrBroker> brokersList = brokerMapper.findMemberTrader();
		for (BrBroker ipoBroker : brokersList) {
			String brokerid = ipoBroker.getBrokerid();
			String brokername = ipoBroker.getName();
			String firmid = ipoBroker.getFirmid();
			String businessType = ChargeConstant.BusinessType.DELIVERY.getCode();
			String chargeType = ChargeConstant.ChargeType.CHANGE_OWNER.getCode();
			List<IpoDebitFlow> bebitFlowList = ipoDebitFlowMapper.selectInfo(businessType, chargeType,
					firmid);
			for (IpoDebitFlow ipoDebitFlow : bebitFlowList) {
				String id = ipoDebitFlow.getOrderId();
				BigDecimal amount = ipoDebitFlow.getAmount();
				logger.info("BigDecimal amount ={}", amount);
				IpoDeliveryorder deliveryOrder = DeliveryorderMapper.selectByPrimaryKey(id);
				String commodityId = deliveryOrder.getCommodityId();
				String commodityName = deliveryOrder.getCommodityName();
				logger.info("String commodityName ={}", commodityName);
				long counts = deliveryOrder.getDeliveryCounts() != null ? deliveryOrder.getDeliveryCounts()
						: 0;
				logger.info("long counts ={}", counts);
				long quatity = deliveryOrder.getDeliveryQuatity();
				logger.info("long quatity = {}", quatity);
				String method = deliveryOrder.getDeliveryMethod();
				Date apply = deliveryOrder.getApplyDate();
				IpoExpress ipoExpress = ipoExpressMapper.selectExpress(id);
				BigDecimal cost = ipoExpress.getCost();
				IpoDelivery ipoDelivery = new IpoDelivery();
				ipoDelivery.setBrokerid(brokerid);
				ipoDelivery.setBrokername(brokername);
				ipoDelivery.setFirmid(firmid);
				ipoDelivery.setCommodityid(commodityId);
				ipoDelivery.setCommodityname(commodityName);
				ipoDelivery.setCounts(counts);
				ipoDelivery.setQuantity(quatity);
				ipoDelivery.setDeliverytype(method);
				ipoDelivery.setTransferfee(amount);
				ipoDelivery.setPostage(cost);
				ipoDelivery.setCreatetime(apply);
				ipoDelivery.setCreatetime(new Date());
				ipoDeliveryMapper.insert(ipoDelivery);
			}
		}
	}

	/**
	 * @Title: holdCommodity
	 * @Description: 持仓表
	 */
	@Transactional
	public void holdCommodity() {
		logger.info("经纪会员持仓表汇总开始执行");
		List<BrBroker> brokersList = brokerMapper.findMemberTrader();
		for (BrBroker ipoBroker : brokersList) {
			String brokerid = ipoBroker.getBrokerid();
			String brokername = ipoBroker.getName();
			String firmid = ipoBroker.getFirmid();
			List<TCustomerholdsum> customerholdList = tCustomerholdsumMapper.selectByFirmId(firmid);
			for (TCustomerholdsum tCustomerholdsum : customerholdList) {
				Short flag = tCustomerholdsum.getBsFlag();
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
				IpoHoldcommodity ipoHoldcommodity = new IpoHoldcommodity();
				ipoHoldcommodity.setBrokerid(brokerid);
				ipoHoldcommodity.setBrokername(brokername);
				ipoHoldcommodity.setBsFlag(flag);
				ipoHoldcommodity.setCommodityid(commodityid);
				ipoHoldcommodity.setCommodityname(commodityName);
				ipoHoldcommodity.setEvenprice(evenPrice);
				ipoHoldcommodity.setFrozenqty(frozenqty);
				ipoHoldcommodity.setHoldinggainsandlosses(floatingLoss);
				ipoHoldcommodity.setHoldqty(holdqty);
				ipoHoldcommodity.setFirmid(firmid);
				ipoHoldcommodity.setCreatetime(new Date());
				ipoHoldcommodity.setQuantityavailable(available);
				ipoHoldcommodity.setPrice(price);
				ipoHoldcommodity.setMarketvalue(value);
				ipoHoldcommodityMapper.insert(ipoHoldcommodity);
			}
		}
	}

}
