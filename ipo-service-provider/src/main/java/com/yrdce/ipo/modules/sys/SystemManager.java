/**
 * 
 */
package com.yrdce.ipo.modules.sys;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.modules.sys.dao.IpoClearStatusMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDebitFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoFirmrewarddeailMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSysStatusMapper;
import com.yrdce.ipo.modules.sys.entity.IpoClearStatus;
import com.yrdce.ipo.modules.sys.entity.IpoDebitFlow;
import com.yrdce.ipo.modules.sys.entity.IpoSysStatus;
import com.yrdce.ipo.modules.sys.service.BrBrokerService;
import com.yrdce.ipo.modules.sys.service.CommodityService;
import com.yrdce.ipo.modules.sys.service.DistributionService;
import com.yrdce.ipo.modules.sys.service.FirmHoldSumService;
import com.yrdce.ipo.modules.sys.service.IpoCommConfService;
import com.yrdce.ipo.modules.sys.service.OrderService;
import com.yrdce.ipo.modules.sys.service.Purchase;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.DebitFlow;
import com.yrdce.ipo.modules.sys.vo.Distribution;
import com.yrdce.ipo.modules.sys.vo.Order;
import com.yrdce.ipo.modules.sys.vo.VBrBroker;
import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;

/**
 * @author hxx 只能单机部署，多机的话考虑 redis
 */
@Component
public class SystemManager extends Observable {

	private Logger logger = LoggerFactory.getLogger(getClass());
	// statusMap.put("0", "初始化完成");
	// statusMap.put("1", "闭市状态");
	// statusMap.put("2", "结算中");
	// statusMap.put("3", "资金结算完成");
	// statusMap.put("4", "暂停交易");
	// statusMap.put("5", "交易中");
	// statusMap.put("6", "节间休息");自动
	// statusMap.put("7", "交易结束");
	// statusMap.put("8", "集合竞价交易中");
	// statusMap.put("9", "集合竞价交易结束");
	// statusMap.put("10", "交易结算完成");

	public static final String STATUS_MARKET_INIT = "0";
	public static final String STATUS_MARKET_CLOSE = "1";
	public static final String STATUS_MARKET_SETTLING = "2";
	public static final String STATUS_FINANCE_SETTLED = "3";
	public static final String STATUS_TRADE_PAUSE = "4";
	public static final String STATUS_TRADE_DOING = "5";
	public static final String STATUS_TRADE_REST = "6";
	public static final String STATUS_TRADE_CLOSE = "7";
	public static final String STATUS_MARKET_SETTLED = "10";
	public static final String CLEAR_STATUS_Y = "Y";
	public static final String DATE_FORMATTER = "yyyy-MM-dd";
	public static final String DATETIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
	public static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATTER);
	public static SimpleDateFormat sdtf = new SimpleDateFormat(
			DATETIME_FORMATTER);

	// 线程安全? 数据库状态的映射
	private String status;
	private String tradeDate;
	private String section;

	private long timeDiff = 0l;
	private AtomicBoolean lockStatus = new AtomicBoolean(false);
	private Thread listener;

	@Autowired
	private IpoClearStatusMapper clearStatusMapper;
	@Autowired
	private IpoSysStatusMapper mapper;
	@Autowired
	private SectionManager sectionManager;
	@Autowired
	private DataSourceTransactionManager transactionManager;
	@Autowired
	@Qualifier("commodityService")
	private CommodityService commodityService;
	@Autowired
	@Qualifier("orderService")
	private OrderService orderService;
	@Autowired
	@Qualifier("purchase")
	private Purchase purchase;
	@Autowired
	@Qualifier("distributionService")
	private DistributionService distributionService;
	@Autowired
	@Qualifier("ipoCommConfService")
	private IpoCommConfService commConfService;
	@Autowired
	@Qualifier("brBrokerService")
	private BrBrokerService brokerService;
	@Autowired
	@Qualifier("firmHoldSumService")
	private FirmHoldSumService firmHoldSumService;

	@Autowired
	private IpoDebitFlowMapper debitFlowMapper;
	@Autowired
	private IpoFirmrewarddeailMapper ipoFirmrewarddeailMapper;

	public String getStatus() {
		return status;
	}

	/**
	 * 系统是否可交易
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean canSystemTrade() throws Exception {
		Date date = new Date(System.currentTimeMillis() + timeDiff);
		return STATUS_TRADE_DOING.equals(status) && isTradeDayToday(date)
				&& sectionManager.isTradeTime(date);
	}

	/**
	 * 
	 * 开市，操作失败返回null，检查时间、状态
	 * 
	 * @throws Exception
	 */
	public String openMarket() throws Exception {
		Date date = new Date(System.currentTimeMillis() + timeDiff);
		if (!sectionManager.isOpenMarketTime(date))
			return null;

		IpoSysStatus sysStatus = mapper.selectAll();
		String dbDate = sdf.format(mapper.getDBTime());
		if (sysStatus != null) {// 有记录
			if (sdf.format(sysStatus.getTradedate()).equals(dbDate))
				return null;
			if (sysStatus.getStatus() != 3) {
				return null;
			}

			mapper.deleteByPrimaryKey(sysStatus.getTradedate());
		}

		initSysStatus(dbDate);
		listener.interrupt();
		return this.status;
	}

	/**
	 * 
	 * 暂停交易
	 * 
	 * @throws Exception
	 */
	public String pauseTrade() throws Exception {
		if (!isTradeDayToday(new Date(System.currentTimeMillis() + timeDiff)))
			return null;

		if (lockStatus.compareAndSet(false, true)) {
			if ((status.equals(STATUS_TRADE_DOING) || status
					.equals(STATUS_TRADE_REST))) {
				updateSysStatus(tradeDate, STATUS_TRADE_PAUSE, "暂停交易");

				lockStatus.compareAndSet(true, false);
				listener.interrupt();
				return this.status;
			}
			lockStatus.compareAndSet(true, false);
		}
		return null;
	}

	/**
	 * 
	 * 恢复交易
	 * 
	 * @throws Exception
	 */
	public String resumeTrade() throws Exception {
		Date date = new Date(System.currentTimeMillis() + timeDiff);
		if (!isTradeDayToday(date))
			return null;

		if (lockStatus.compareAndSet(false, true)) {
			if (status.equals(STATUS_TRADE_PAUSE)) {
				updateSysStatus(
						tradeDate,
						STATUS_TRADE_DOING,
						String.valueOf(sectionManager.getCurrentSectionId(date)),
						"交易中");

				lockStatus.compareAndSet(true, false);
				listener.interrupt();
				return this.status;
			}
			lockStatus.compareAndSet(true, false);
		}
		return null;
	}

	/**
	 * 
	 * 结束交易
	 * 
	 * @throws Exception
	 */
	public String closeTrade() throws Exception {
		if (!isTradeDayToday(new Date(System.currentTimeMillis() + timeDiff)))
			return null;

		if (lockStatus.compareAndSet(false, true)) {
			updateSysStatus(tradeDate, STATUS_TRADE_CLOSE, "结束交易");

			lockStatus.compareAndSet(true, false);
			listener.interrupt();
			return this.status;
		}
		return null;
	}

	/**
	 * 闭市
	 * 
	 * @throws Exception
	 */
	public String closeMarket() throws Exception {
		if (!isTradeDayToday(new Date(System.currentTimeMillis() + timeDiff)))
			return null;

		if (lockStatus.compareAndSet(false, true)) {
			if (!status.equals(STATUS_MARKET_CLOSE)) {
				updateSysStatus(tradeDate, STATUS_MARKET_CLOSE, "闭市");

				lockStatus.compareAndSet(true, false);
				listener.interrupt();
				return this.status;
			}
			lockStatus.compareAndSet(true, false);
		}
		return null;
	}

	// i = tradeRMI.balance(); // FN_T_CloseMarketProcess
	// FN_F_UpdateFrozenFunds
	// FN_T_TradeFlow
	// FN_F_UpdateFundsFull

	// 计算手续费、插入资金流水f_fundflow 货款 增值税 冻结资金 收延期费 资金f_firmfunds // 付会员佣金
	// 计算付会员佣金尾款日期

	// 交易商T_Firm T_H_Firm
	// 委托表 T_H_Orders T_Orders;
	// 成交表 T_H_Trade T_Trade;
	// T_H_Market 历史市场参数
	// T_H_Quotation 历史行情
	// T_H_Commodity 历史商品
	// T_H_HoldPosition 史持仓明细表
	// T_H_CustomerHoldSum 历史交易客户持仓合计表
	// T_H_FirmHoldSum 历史交易商持仓合计表
	// T_H_FirmMargin 历史交易商特殊保证金表
	// T_H_FirmFee 历史交易商特殊手续费表
	public void settle() throws Exception {

		if (!STATUS_MARKET_CLOSE.equals(status))
			throw new Exception("交易服务器没有闭市操作，不能结算！");

		updateSysStatusLock(STATUS_MARKET_CLOSE, STATUS_MARKET_SETTLING, null,
				"结算中");
		try {
			updateClearStatus(Short.valueOf("0"), CLEAR_STATUS_Y);
			// 扣发行手续费,扣款对象:发行商
			publishHandlingSettle();
			// 扣托管商品的手续费,扣款对象:散户
			trusteeshipHandlingSettle();
			updateClearStatus(Short.valueOf("1"), CLEAR_STATUS_Y);
			// 扣增发的货款,扣款对象:交易商(散户+承销商)
			increasePublishGoodsSettle();
			// 扣增发的手续费,扣款对象:交易商(散户+承销商)
			increasePublishHandlingSettle();
			updateClearStatus(Short.valueOf("2"), CLEAR_STATUS_Y);
			// 扣发售的货款 ,扣款对象:交易商(散户+承销商)
			purchaseGoodsSettle();
			increaseSubscribeGoodsSettle();
			// 扣发售的手续费,扣款对象:交易商(散户+承销商)
			purchaseHandlingSettle();
			increaseSubscribeHandlingSettle();
			updateClearStatus(Short.valueOf("3"), CLEAR_STATUS_Y);
			// 扣交收相关费 ,扣款对象:交易商(散户)
			changeOwnerSettle();
			DeliveryRegisterSettle();
			DeliveryCancelSettle();
			DeliveryExpressSettle();
			updateClearStatus(Short.valueOf("4"), CLEAR_STATUS_Y);
			// 扣仓储费,扣款对象:发行商,托管商品的散户
			warehouseRentSettle();
			// 扣仓库保险费,扣款对象:发行商,托管商品的散户
			warehouseInsuranceSettle();
			// 扣仓库托管费,扣款对象:发行商,托管商品的散户
			warehouseTrusteeSettle();
			updateClearStatus(Short.valueOf("5"), CLEAR_STATUS_Y);
			// 佣金结算
			brokerageSettle();
			updateClearStatus(Short.valueOf("6"), CLEAR_STATUS_Y);
			updateSysStatus(tradeDate, STATUS_FINANCE_SETTLED, null, "");
			updateClearStatus(Short.valueOf("7"), CLEAR_STATUS_Y);
		} catch (Throwable e) {
			updateSysStatusLock(STATUS_MARKET_SETTLING, STATUS_MARKET_CLOSE,
					null, "已闭市");
			throw new Exception(e);
		}
	}

	// 发行手续费结算
	public void publishHandlingSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.PUBLISH.getCode();
		String chargeType = ChargeConstant.ChargeType.HANDLING.getCode();
		debitFlowSettle(businessType, chargeType, "40002", "发行手续费结算");
	}

	// 散户托管商品的手续费
	public void trusteeshipHandlingSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.TRUSTEESHIP.getCode();
		String chargeType = ChargeConstant.ChargeType.HANDLING.getCode();
		debitFlowSettle(businessType, chargeType, "40002", "托管手续费结算");
	}

	// 增发货款结算
	public void increasePublishGoodsSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.INCREASE_PUBLISH
				.getCode();
		String chargeType = ChargeConstant.ChargeType.GOODS.getCode();
		debitFlowSettle(businessType, chargeType, "40005", "增发货款结算 ");
	}

	// 增发手续费结算
	public void increasePublishHandlingSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.INCREASE_PUBLISH
				.getCode();
		String chargeType = ChargeConstant.ChargeType.HANDLING.getCode();
		debitFlowSettle(businessType, chargeType, "40001", "增发手续费结算");
	}

	// 承销货款结算
	public void increaseSubscribeGoodsSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.UNDERWRITE.getCode();
		String chargeType = ChargeConstant.ChargeType.GOODS.getCode();
		debitFlowSettle(businessType, chargeType, "40005", "承销货款结算 ");
	}

	// 承销手续费结算
	public void increaseSubscribeHandlingSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.UNDERWRITE.getCode();
		String chargeType = ChargeConstant.ChargeType.HANDLING.getCode();
		debitFlowSettle(businessType, chargeType, "40001", "承销手续费结算");
	}

	// 申购货款结算
	public void purchaseGoodsSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.PURCHASE.getCode();
		String chargeType = ChargeConstant.ChargeType.GOODS.getCode();
		debitFlowSettle(businessType, chargeType, "40005", "申购货款结算 ");
	}

	// 申购手续费结算
	public void purchaseHandlingSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.PURCHASE.getCode();
		String chargeType = ChargeConstant.ChargeType.HANDLING.getCode();
		debitFlowSettle(businessType, chargeType, "40001", "申购手续费结算");
	}

	// 提单过户费结算
	public void changeOwnerSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.DELIVERY.getCode();
		String chargeType = ChargeConstant.ChargeType.CHANGE_OWNER.getCode();
		debitFlowSettle(businessType, chargeType, "40015", "提单过户费结算");
	}

	// 提单注册费结算
	public void DeliveryRegisterSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.DELIVERY.getCode();
		String chargeType = ChargeConstant.ChargeType.REGISTER.getCode();
		debitFlowSettle(businessType, chargeType, "40013", "提单注册费结算");
	}

	// 提单注销费结算
	public void DeliveryCancelSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.DELIVERY.getCode();
		String chargeType = ChargeConstant.ChargeType.CANCEL.getCode();
		debitFlowSettle(businessType, chargeType, "40014", "提单注销费结算");
	}

	// 提单配送费结算
	public void DeliveryExpressSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.DELIVERY.getCode();
		String chargeType = ChargeConstant.ChargeType.CARRIAGE.getCode();
		debitFlowSettle(businessType, chargeType, "40016", "提单配送费结算");
	}

	// 仓储费结算
	public void warehouseRentSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.DELIVERY.getCode();
		String chargeType = ChargeConstant.ChargeType.WAREHOUSING.getCode();
		debitFlowSettle(businessType, chargeType, "40010", "仓库仓储费结算");
	}

	// 仓库保险费结算
	public void warehouseInsuranceSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.DELIVERY.getCode();
		String chargeType = ChargeConstant.ChargeType.INSURANCE.getCode();
		debitFlowSettle(businessType, chargeType, "40009", "仓库保险费结算");
	}

	// 仓库托管费结算
	public void warehouseTrusteeSettle() throws Exception {
		String businessType = ChargeConstant.BusinessType.DELIVERY.getCode();
		String chargeType = ChargeConstant.ChargeType.TRUSTEE.getCode();
		debitFlowSettle(businessType, chargeType, "40008", "仓库托管费结算");
	}

	// 佣金结算
	private void brokerageSettle() throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("returnCode", "");
		ipoFirmrewarddeailMapper.brokerRewardSettle(param);
		Integer a = (Integer) param.get("returnCode");
		logger.info("佣金结算返回结果:{}", a);
	}

	public void debitFlowSettle(String businessType, String chargeType,
			String opCode, String opName) throws Exception {
		DebitFlow param = new DebitFlow();
		param.setBusinessType(businessType);
		param.setChargeType(chargeType);
		param.setDebitState(ChargeConstant.DebitState.FROZEN_SUCCESS.getCode());
		param.setDebitMode(ChargeConstant.DebitMode.ONLINE.getCode());
		List<IpoDebitFlow> debitFlowList = debitFlowMapper.queryForList(param);
		if (debitFlowList == null || debitFlowList.isEmpty()) {
			logger.info("{}:扣款流水查询记录数为空", opName);
			return;
		}
		for (IpoDebitFlow item : debitFlowList) {
			String firmId = item.getPayer();
			String commodityId = item.getCommodityId();
			BigDecimal amount = item.getAmount();
			if (firmId == null || firmId.isEmpty()) {
				throw new Exception(opName + "：被扣款人不存在");
			}
			// 解冻资金
			purchase.frozen(firmId, amount.negate());
			// 扣除资金
			updateFundsFull(firmId, opCode, amount, commodityId);
			DebitFlow debitFlow = new DebitFlow();
			BeanUtils.copyProperties(item, debitFlow);
			debitFlow.setUpdateDate(new Date());
			debitFlow.setUpdateUser("admin");
			debitFlow.setDebitState(ChargeConstant.DebitState.PAY_SUCCESS
					.getCode());
			debitFlow.setDebitDate(new Date());
			debitFlowMapper.updateState(debitFlow);
			logger.info("{}：商品={}，被扣款人={}，金额={}", opName, commodityId, firmId,
					amount.toString());
			// 结算成功通知监听
			String objs = JSON.json(debitFlow);
			logger.info("{}:通知内容:{}", opName, objs);
			setChanged();
			notifyObservers(objs);
		}
	}

	/**
	 * 重新载入交易节和非交易日
	 */
	public void reloadSections() {
		sectionManager.init();
		reloadStatus();
		listener.interrupt();// 让系统重新判别状态
	}

	// INSERT INTO "TRADE_GNNT"."F_LEDGERFIELD" VALUES ('Payout_I', '申购购货支出',
	// '-1', '40', '40001', 'Y');
	// INSERT INTO "TRADE_GNNT"."F_LEDGERFIELD" VALUES ('Income_I', '发售销售收入',
	// '1', '40', '40002', 'Y');
	// INSERT INTO "TRADE_GNNT"."F_LEDGERFIELD" VALUES ('TradeFee_I', '申购交易手续费',
	// '-1', '40', '40101', 'Y');
	private void purchaseSettle() throws Exception {
		// 找sale表状态为32->41
		List<Commodity> sales = commodityService.queryAllByStatusForSettle();
		if (sales != null && !sales.isEmpty()) {
			logger.info("申购结算：发售商品查询：待结算的商品个数={}", sales.size());

			for (Commodity commodity : sales) {
				String commodityId = commodity.getCommodityid();
				logger.info("申购结算：开始结算处理id={} 的商品", commodityId);
				// 解冻order表中的订单费和手续费
				processApplyOrders(commodityId);

				// 扣distribution表中的订单费和手续费
				BigDecimal commoAmount = processSelectOrders(commodityId);

				// 付钱给发行商
				payPublisher(commodityId, commoAmount);

				// 返佣操作 TODO

				// 变更sale表的状态41->4
				if (commodityService.updateCommoditySettled(commodityId) < 1) {
					logger.error("申购结算：发售状态变更：商品={}，变更sale状态失败", commodityId);
					throw new Exception("变更sale状态失败，全部回滚");
				}
				logger.info("申购结算：结束处理id={} 的商品", commodityId);
			}
		}
	}

	private void processApplyOrders(String commodityId) throws Exception {
		List<Order> orders = orderService
				.queryUnsettleOrdersByCommId(commodityId);
		while (orders != null && !orders.isEmpty()) {
			logger.info("申购结算：申购订单处理：开始处理商品id={} 的申购订单。", commodityId);

			unfrozenOrders(orders);
			orders = orderService.queryUnsettleOrdersByCommId(commodityId);
		}
	}

	// 解冻order表中的订单费和手续费
	private void unfrozenOrders(List<Order> orders) throws Exception {
		for (Order order : orders) {
			String userId = order.getUserid();
			BigDecimal amount = order.getFrozenfunds();
			BigDecimal fee = order.getFrozencounterfee();
			BigDecimal total = amount.add(fee).negate();

			purchase.frozen(userId, total);
			// 标记处理
			if (orderService.updateOrderSettled(order.getOrderid()) < 1)
				throw new Exception("变更申购记录为结算状态失败，全部回滚");

			logger.info("申购结算：申购订单处理：商品={}，firmid={}，冻结资金={}",
					order.getCommodityid(), userId, total.toString());
		}
	}

	private BigDecimal processSelectOrders(String commodityId) throws Exception {
		BigDecimal commoAmount = new BigDecimal(0);// 商品付给发行商总金额
		List<Distribution> distributions = distributionService
				.queryUnsettleOrdersByCommId(commodityId);
		while (distributions != null && !distributions.isEmpty()) {
			logger.info("申购结算：配号摇号单处理：开始结算处理商品id={} 的配号摇号单。", commodityId);

			commoAmount = frozenTrades(distributions, commoAmount);
			distributions = distributionService
					.queryUnsettleOrdersByCommId(commodityId);
		}
		return commoAmount;
	}

	// 扣distribution表中的订单费和手续费
	private BigDecimal frozenTrades(List<Distribution> distributions,
			BigDecimal totalFee) throws Exception {
		BigDecimal result = totalFee;
		for (Distribution distribution : distributions) {
			String userId = distribution.getUserid();
			String commoId = distribution.getCommodityid();
			BigDecimal amount = distribution.getTradingamount();
			BigDecimal fee = distribution.getCounterfee();

			result = result.add(amount);

			updateFundsFull(userId, "40005", amount, commoId);
			updateFundsFull(userId, "40001", fee, commoId);

			if (distributionService.updateOrderSettled(distribution
					.getOrderid()) < 1)
				throw new Exception("变更摇号记录为结算状态失败，全部回滚");

			logger.info("申购结算：配号摇号单处理：商品={}，firmid={}，收货款={}，收手续费={}", commoId,
					userId, amount.toString(), fee.toString());
		}
		return result;
	}

	private void payPublisher(String commodityId, BigDecimal commoAmount)
			throws Exception {
		String firmId = queryBrokerFirmId(commodityId);
		if (firmId == null || firmId.isEmpty()) {
			logger.error("申购结算：查找商品的发行商：商品={}，失败", commodityId);
			throw new Exception("查找商品的发行商失败，全部回滚");
		}
		updateFundsFull(firmId, "40006", commoAmount, commodityId);
		logger.info("申购结算：付发行商货款：商品={}，发行商id={}，付货款={}", commodityId, firmId,
				commoAmount.toString());
	}

	private String queryBrokerFirmId(String commodityId) {
		VIpoCommConf vIpoCommConf = new VIpoCommConf();
		vIpoCommConf.setCommodityid(commodityId);
		List<VIpoCommConf> commConfs = commConfService
				.selectCommodityByExample(vIpoCommConf);
		if (commConfs != null && commConfs.size() == 1) {
			String brokerId = commConfs.get(0).getPubmemberid();
			VBrBroker brBroker = brokerService.queryBrokerById(brokerId);
			if (brBroker != null)
				return brBroker.getFirmid();
		}

		return null;
	}

	@Transactional
	public BigDecimal updateFundsFull(String userId, String opCode,
			BigDecimal amount, String commoId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("money", "");
		param.put("userid", userId);
		param.put("oprcode", opCode);
		param.put("amount", amount.doubleValue());
		param.put("contractNo", null);
		param.put("extraCode", commoId);
		param.put("appendAmount", null);
		param.put("voucherNo", null);

		mapper.updateFundsFull(param);

		BigDecimal money = (BigDecimal) (param.get("money"));
		return money;
	}

	@PostConstruct
	private void postConstruct() throws Exception {
		logger.info("执行IpoSystem: postConstruct");

		sectionManager.init();
		init();
	}

	private void init() throws Exception {
		initTime();

		initStatus();
		logCurStatus();

		startListener();
	}

	// 时间差
	private void initTime() {
		timeDiff = mapper.getDBTime().getTime() - System.currentTimeMillis();
		logger.info("数据库时间-本机时间 相差： {}.", timeDiff);
	}

	// 系统状态
	private void initStatus() throws Exception {
		IpoSysStatus sysStatus = reloadStatus();
		if (sysStatus == null)
			openMarketInternal();
	}

	// 系统状态
	private IpoSysStatus reloadStatus() {
		IpoSysStatus sysStatus = mapper.selectAll();
		if (sysStatus != null) {
			status = String.valueOf(sysStatus.getStatus());
			tradeDate = sdf.format(sysStatus.getTradedate());
			if (sysStatus.getSectionid() != null)
				section = String.valueOf(sysStatus.getSectionid());
			else
				section = null;
		}
		return sysStatus;
	}

	private void logCurStatus() {
		logger.info("当前系统状态：tradeDate={},sysStatus={},sectionId={}", tradeDate,
				status, section);
	}

	// 市场初始化，自动
	private void openMarketInternal() throws Exception {
		Date date = new Date(System.currentTimeMillis() + timeDiff);
		if (sectionManager.isOpenMarketTime(date)) {
			initSysStatus(sdf.format(date));
		}
	}

	// 初始化入库
	private void initSysStatus(String dbDate) throws Exception {
		IpoSysStatus sysStatus = new IpoSysStatus();
		sysStatus.setTradedate(sdf.parse(dbDate));
		sysStatus.setStatus(Short.parseShort(STATUS_MARKET_INIT));
		sysStatus.setSectionid(null);
		sysStatus.setNote(null);
		sysStatus.setRecovertime(null);

		mapper.insert(sysStatus);

		this.status = STATUS_MARKET_INIT;
		this.tradeDate = dbDate;
		section = null;
	}

	// 交易日切换
	private void startListener() {
		listener = new Thread() {
			public void run() {
				Thread.currentThread().setName("SystemManager线程");
				logger.info(Thread.currentThread() + ": 线程启动");
				while (true) {
					try {
						if (status == null) {// 没有初始化，没有前交易日
							Date date = new Date(System.currentTimeMillis()
									+ timeDiff);
							if (sectionManager.isOpenMarketTime(date)) {
								try {
									openMarketInternal();
								} catch (Exception e) {
								}
							} else {// 休眠到下次开市时间
								long nextOpenTime = sectionManager
										.getOpenMarketTimeFromNow(date);
								threadSleep(nextOpenTime);// 可被打断
							}
						} else {
							Date now = new Date(System.currentTimeMillis()
									+ timeDiff);
							if (isTradeDayToday(now)) {
								switch (Integer.parseInt(status)) {
								case 0:// opened, ready to trade
									long tradeTime = sectionManager
											.getNextTradeTimeFromNow(new Date(
													System.currentTimeMillis()
															+ timeDiff));
									try {
										logger.info(
												"系统已开市，离交易还差（{}）毫秒，线程开始休眠。",
												tradeTime);
										Thread.currentThread().sleep(
												tradeTime + 1);

										startTradeInternal();
									} catch (InterruptedException e) {
										logResumeStatus();
									}
									break;
								case 1:// market closed, ready for next day
									long nextOpenTime = sectionManager
											.getOpenMarketTimeFromNow(new Date(
													System.currentTimeMillis()
															+ timeDiff));
									try {
										logger.info(
												"系统已闭市，离下次开市还差（{}）毫秒，线程开始休眠。",
												nextOpenTime);
										Thread.currentThread().sleep(
												nextOpenTime + 1);

										reopenMarketInternal();
									} catch (InterruptedException e) {
										logResumeStatus();
									}
									break;
								case 3:// 发现财务结算完成，准备下个交易日的开市
									nextOpenTime = sectionManager
											.getOpenMarketTimeFromNow(new Date(
													System.currentTimeMillis()
															+ timeDiff));
									try {
										logger.info(
												"资金结算完成，离下次开市还差（{}）毫秒，线程开始休眠。",
												nextOpenTime);
										Thread.currentThread().sleep(
												nextOpenTime + 1);

										reopenMarketInternal();
									} catch (InterruptedException e) {
										logResumeStatus();
									}
									break;
								case 5:// trading
									long continuedTime = sectionManager
											.getCurSectionEndTimeFromNow(
													(new Date(
															System.currentTimeMillis()
																	+ timeDiff)),
													section);
									try {
										logger.info(
												"系统正在交易，离这节交易结束还差（{}）毫秒，线程开始休眠。",
												continuedTime);
										Thread.currentThread().sleep(
												continuedTime);

										if (sectionManager
												.isLastSection(section))
											closeMarketInternal();
										else
											restBetweenSection();// 节间休息
									} catch (InterruptedException e) {
										logResumeStatus();
									}
									break;
								case 6:// rest
									long nextTradeTime = sectionManager
											.getNextTradeTimeFromNow((new Date(
													System.currentTimeMillis()
															+ timeDiff)));
									// to trade
									try {
										logger.info(
												"系统节间休息，离下个交易节开始还差（{}）毫秒，线程开始休眠。",
												nextTradeTime);
										Thread.currentThread().sleep(
												nextTradeTime);

										startTradeInternal();// 新交易节
									} catch (InterruptedException e) {
										logResumeStatus();
									}
									break;
								case 7:// trade close; // close market
									logger.info("系统交易结束，开始闭市。");

									closeMarketInternal();
									break;
								default:
									threadSleep(1000);
									break;
								}
							} else if (isPreTradeDayNormal(now)) {// 以前的交易日
								switch (Integer.parseInt(status)) {
								case 3:// 发现财务结算完成，准备今天的交易日的开市
									long nextOpenTime = sectionManager
											.getOpenMarketTimeFromNow(new Date(
													System.currentTimeMillis()
															+ timeDiff));
									try {
										logger.info(
												"资金结算完成，离下次开市还差（{}）毫秒，线程开始休眠。",
												nextOpenTime);
										Thread.currentThread().sleep(
												nextOpenTime + 1);

										reopenMarketInternal();
									} catch (InterruptedException e) {
										logResumeStatus();
									}
									break;
								default:
									threadSleep(600000);// 休眠10分钟
									break;
								}
							} else {
								logger.info(
										"前一交易日没有正常结束：tradeDate={},sysStatus={},sectionId={}",
										tradeDate, status, section);
								threadSleep(600000);// 休眠10分钟，可被打断
							}
						}
					} catch (Throwable t) {
						logger.error(t.getLocalizedMessage(), t);
						threadSleep(30000);
					}
				}
			}
		};
		listener.setDaemon(true);
		listener.start();
	}

	// 判断前一交易日是否正常结束
	private boolean isPreTradeDayNormal(Date date) {
		IpoSysStatus sysStatus = mapper.selectAll();
		if (sysStatus != null) {// 有记录
			if (sysStatus.getTradedate().getTime() < date.getTime()) {
				return STATUS_FINANCE_SETTLED.equals(String.valueOf(sysStatus
						.getStatus()));
			}
		}

		return false;
	}

	// 交易状态是否是今天的
	private boolean isTradeDayToday(Date date) {
		return sdf.format(date).equals(tradeDate);
	}

	// 交易日切换
	private void reopenMarketInternal() {
		try {
			openMarket();
		} catch (Exception e) {
			logger.info("exception:", e);
		}
	}

	// 开市交易
	private void startTradeInternal() throws Exception {
		Date date = new Date(System.currentTimeMillis() + timeDiff);

		updateSysStatus(sdf.format(date), STATUS_TRADE_DOING,
				String.valueOf(sectionManager.getCurrentSectionId(date)), "交易中");
	}

	// 节间休息 section不变
	private void restBetweenSection() throws Exception {
		updateSysStatus(tradeDate, STATUS_TRADE_REST, "节间休息");
	}

	// 闭市
	private void closeMarketInternal() throws Exception {
		Date date = new Date(System.currentTimeMillis() + timeDiff);

		updateSysStatus(sdf.format(date), STATUS_MARKET_CLOSE, "闭市");
	}

	// 状态变更入库
	private void updateSysStatus(String tradeDate, String status, String remark)
			throws Exception {
		updateSysStatus(tradeDate, status, null, remark);
	}

	// 状态变更入库
	private void updateSysStatus(String tradeDate, String status,
			String sectionId, String remark) throws Exception {
		try {
			IpoSysStatus sysStatus = new IpoSysStatus();
			sysStatus.setTradedate(sdf.parse(tradeDate));
			sysStatus.setStatus(Short.parseShort(status));
			if (sectionId != null)
				sysStatus.setSectionid(Short.valueOf(sectionId));
			sysStatus.setNote(remark);

			int i = mapper.updateByPrimaryKeySelective(sysStatus);
			if (i < 1)
				throw new Exception("更新不成功：status=" + sysStatus + " tradeDate="
						+ tradeDate);

			this.status = status;// 先入库后变更状态，防止事务回滚导致状态不一致
			this.tradeDate = tradeDate;
			if (sectionId != null)
				this.section = sectionId;

			logChangeStatus();
		} catch (Exception e) {
			logger.info("error:", e);
			throw e;
		}
	}

	// 无须捕获打断异常的地方调用
	private void threadSleep(long millis) {
		try {
			Thread.currentThread().sleep(millis);// 只是休眠
		} catch (InterruptedException e) {
			logResumeStatus();
		}
	}

	private void logResumeStatus() {
		logger.info("{} 休眠被打断，当前系统状态: tradeDate={},sysStatus={},sectionId={}",
				Thread.currentThread().getName(), tradeDate, status, section);
	}

	// 预防多实例并发 //注解事务无效
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private void updateSysStatusLock(String oldStatus, String toStatus,
			Short sectionId, String remark) throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus transactionStatus = transactionManager
				.getTransaction(def);
		try {
			IpoSysStatus sysStatus = new IpoSysStatus();
			sysStatus.setTradedate(sdf.parse(tradeDate));
			sysStatus.setStatus(Short.parseShort(toStatus));
			if (sectionId != null)
				sysStatus.setSectionid(sectionId);
			sysStatus.setNote(remark);

			int i = mapper.updateByPrimaryKeySelectiveLock(sysStatus,
					new Short(oldStatus));
			if (i < 1)
				throw new Exception("更新不成功：status=" + sysStatus + " tradeDate="
						+ tradeDate);

			this.status = toStatus;// 先入库后变更状态，防止事务回滚导致状态不一致
			if (sectionId != null)
				this.section = sectionId.toString();

			transactionManager.commit(transactionStatus);

			logChangeStatus();
		} catch (Exception e) {
			logger.info("error:", e);
			transactionManager.rollback(transactionStatus);
			throw e;
		}
		// batchUpdate（）
		// -2表示update成功，但无法获取准确数目。
	}

	private void logChangeStatus() {
		logger.info("系统状态变更为：tradeDate={},sysStatus={},sectionId={}",
				tradeDate, status, section);
	}

	// 状态变更入库 //注解事务无效
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private void updateClearStatus(Short actionId, String status)
			throws Exception {
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
		TransactionStatus transactionStatus = transactionManager
				.getTransaction(def);
		try {
			IpoClearStatus clearStatus = new IpoClearStatus();
			clearStatus.setActionid(actionId);
			clearStatus.setStatus(status);
			Date date = new Date(System.currentTimeMillis() + timeDiff);
			clearStatus.setFinishtime(date);

			clearStatusMapper.updateByPrimaryKeySelective(clearStatus);
			transactionManager.commit(transactionStatus);

			logger.info("清算状态：actionId={},status={},time={}", actionId, status,
					date);
		} catch (Exception e) {
			logger.info("error:", e);
			transactionManager.rollback(transactionStatus);
			throw e;
		}
	}

}
