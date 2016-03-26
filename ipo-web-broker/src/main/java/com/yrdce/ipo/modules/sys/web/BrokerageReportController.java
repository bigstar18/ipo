package com.yrdce.ipo.modules.sys.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.modules.sys.service.BrokerageReportService;
import com.yrdce.ipo.modules.sys.vo.Billoflading;
import com.yrdce.ipo.modules.sys.vo.BolIncome;
import com.yrdce.ipo.modules.sys.vo.Brokers;
import com.yrdce.ipo.modules.sys.vo.Delivery;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Distribution;
import com.yrdce.ipo.modules.sys.vo.Firmrewarddeail;
import com.yrdce.ipo.modules.sys.vo.Holdcommodity;
import com.yrdce.ipo.modules.sys.vo.Income;
import com.yrdce.ipo.modules.sys.vo.IpoSubRevenue;
import com.yrdce.ipo.modules.sys.vo.Releasesubscription;
import com.yrdce.ipo.modules.sys.vo.SettleResult;
import com.yrdce.ipo.modules.sys.vo.VBrBroker;

/**
 * @ClassName: BrokerageReportController
 * @Description: 经纪会员报表查询
 * @author bob
 */
@Controller
@RequestMapping("brokerageReportController")
public class BrokerageReportController {
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private BrokerageReportService brokerageReportService;

	/**
	 * @Title: brokerInfoForward
	 * @Description: 经纪会员结算报表
	 * @param request
	 * @param model
	 * @param brokerid
	 *            会员id
	 * @param time
	 *            查询时间
	 */
	@RequestMapping(value = "/brokerinfoforward", method = RequestMethod.GET)
	public String brokerInfoForward(HttpSession session, Model model, @RequestParam("time") String time) {
		String brokerid = (String) session.getAttribute("currentFirmId");
		List<VBrBroker> brokers = brokerageReportService.getBroker();
		List<SettleResult> settles = new ArrayList<SettleResult>();
		if (!"".equals(brokerid)) {
			List<Billoflading> billfladInfo = brokerageReportService.getBillfladInfo(brokerid, time);

			List<Delivery> deliveryInfo = brokerageReportService.getDeliveryInfo(brokerid, time);

			List<Holdcommodity> holdInfo = brokerageReportService.getHoldInfo(brokerid, time);

			List<Releasesubscription> releaInfo = brokerageReportService.getReleaInfo(brokerid, time);

			SettleResult result = new SettleResult();
			result.setBillfladInfo(billfladInfo);
			result.setDeliveryInfo(deliveryInfo);
			result.setHoldInfo(holdInfo);
			result.setReleaInfo(releaInfo);
			for (VBrBroker broker : brokers) {
				if (brokerid.equals(broker.getBrokerid())) {
					result.setBroker(broker);
				}
			}
			settles.add(result);
			model.addAttribute("settles", settles);
			model.addAttribute("today", time);
			return "app/brokeragereport/brokerinfo";
		}
		return "error";
	}

	/**
	 * @Title: incomeForward
	 * @Description: 经纪会员经纪收入
	 * @param request
	 * @param model
	 * @param brokerid
	 *            会员id
	 * @param starttime
	 * @param endtime
	 */
	@RequestMapping(value = "/incomeForward", method = RequestMethod.GET)
	public String incomeForward(HttpSession session, Model model, @RequestParam("starttime") String starttime,
			@RequestParam("endtime") String endtime) {
		String brokerid = (String) session.getAttribute("currentFirmId");
		List<VBrBroker> brokers = brokerageReportService.getBroker();
		if (!"".equals(brokerid)) {
			logger.info("有账号查询");
			Income income = setShare(brokerid, starttime, endtime, brokers);
			List<Income> incomesList = new ArrayList<Income>();
			incomesList.add(income);
			model.addAttribute("incomesList", incomesList);
			return "app/brokeragereport/incomeinfo";
		}
		return "error";
	}

	//经纪收入报表共用
	private Income setShare(String brokerid, String starttime, String endtime, List<VBrBroker> brokers) {
		List<Firmrewarddeail> list1 = brokerageReportService.getHandlingInfo(brokerid, starttime, endtime);
		BigDecimal allHandling = new BigDecimal(0);
		for (Firmrewarddeail firmrewarddeail : list1) {
			BigDecimal handling = firmrewarddeail.getReward();
			allHandling = allHandling.add(handling);
		}
		List<Firmrewarddeail> list2 = brokerageReportService.getRegisterInfo(brokerid, starttime, endtime);
		BigDecimal allRegister = new BigDecimal(0);
		for (Firmrewarddeail firmrewarddeail : list2) {
			BigDecimal register = firmrewarddeail.getReward();
			allRegister = allRegister.add(register);
		}
		List<Firmrewarddeail> list3 = brokerageReportService.getCancelInfo(brokerid, starttime, endtime);
		BigDecimal allCancel = new BigDecimal(0);
		for (Firmrewarddeail firmrewarddeail : list3) {
			BigDecimal cancel = firmrewarddeail.getReward();
			allCancel = allCancel.add(cancel);
		}
		Income income = new Income();
		income.setBrokerId(brokerid);
		income.setPurchase(allHandling);
		income.setBillOfLading(allRegister.add(allCancel));
		if (list1.size() != 0 && list1 != null) {
			income.setFirmId(list1.get(0).getFirmid());
		} else if (list2.size() != 0 && list2 != null) {
			income.setFirmId(list2.get(0).getFirmid());
		} else if (list3.size() != 0 && list3 != null) {
			income.setFirmId(list3.get(0).getFirmid());
		}
		for (VBrBroker broker : brokers) {
			if (brokerid.equals(broker.getBrokerid())) {
				income.setBrokerName(broker.getName());
			}
		}
		return income;
	}

	@RequestMapping(value = "/purchaseincomeinfo", method = RequestMethod.GET)
	public String purchaseIncomeInfo(HttpSession session, Model model, @RequestParam("time") String time) {
		String brokerid = (String) session.getAttribute("currentFirmId");
		List<VBrBroker> brokers = brokerageReportService.getBroker();
		List<SettleResult> settles = new ArrayList<SettleResult>();
		if (!"".equals(brokerid)) {
			List<IpoSubRevenue> subRevenueList = setSubRevenue(brokerid, time);
			for (VBrBroker broker : brokers) {
				SettleResult result = new SettleResult();
				result.setIpoSubRevenue(subRevenueList);
				if (brokerid.equals(broker.getBrokerid())) {
					result.setBroker(broker);
					settles.add(result);
				}
			}
			model.addAttribute("settles", settles);
			model.addAttribute("today", time);
			return "app/brokeragereport/purchaseincomeinfo";
		}
		return "error";
	}

	private List<IpoSubRevenue> setSubRevenue(String brokerid, String time) {
		List<Firmrewarddeail> list = brokerageReportService.getCommission(time, brokerid,
				ChargeConstant.BusinessType.PURCHASE.getCode(), ChargeConstant.ChargeType.HANDLING.getCode());
		List<IpoSubRevenue> subRevenuesList = new ArrayList<IpoSubRevenue>();
		for (Firmrewarddeail firmrewarddeail : list) {
			Distribution distribution = brokerageReportService.getPurchase(firmrewarddeail.getFirmid(),
					firmrewarddeail.getCommodityid());
			Brokers brokers1 = brokerageReportService.getIntermediary(brokerid, firmrewarddeail.getFirmid());
			String firmName = brokerageReportService.getFirmName(firmrewarddeail.getFirmid());
			logger.info("brokers1.getBrokerageid():{}", brokers1.getBrokerageid());
			String intermediaryName = null;
			if (brokers1.getBrokerageid() != null) {
				intermediaryName = brokerageReportService.getFirmName(brokers1.getBrokerageid());
			}
			IpoSubRevenue ipoSubRevenue = new IpoSubRevenue();
			ipoSubRevenue.setAmount(distribution.getTradingamount());
			ipoSubRevenue.setBrokerIncome(firmrewarddeail.getReward());
			ipoSubRevenue.setCommodityId(firmrewarddeail.getCommodityid());
			ipoSubRevenue.setCommodityName(firmrewarddeail.getCommodityname());
			ipoSubRevenue.setFirmId(firmrewarddeail.getFirmid());
			ipoSubRevenue.setFirmName(firmName);
			ipoSubRevenue.setIntermediaryId(brokers1.getBrokerageid());
			ipoSubRevenue.setIntermediaryName(intermediaryName);
			ipoSubRevenue.setLuckyNumber(distribution.getZcounts());
			subRevenuesList.add(ipoSubRevenue);
		}
		return subRevenuesList;
	}

	@RequestMapping(value = "/deliveryIncomeInfo", method = RequestMethod.GET)
	public String deliveryIncomeInfo(HttpSession session, Model model, @RequestParam("time") String time) {
		String brokerid = (String) session.getAttribute("currentFirmId");
		List<VBrBroker> vBrBrokers = brokerageReportService.getBroker();
		List<SettleResult> settles = new ArrayList<SettleResult>();
		if (!"".equals(brokerid)) {
			List<BolIncome> bilList = getBolList(time, brokerid);
			SettleResult result = new SettleResult();
			result.setBalance(bilList);
			for (VBrBroker broker : vBrBrokers) {
				if (brokerid.equals(broker.getBrokerid())) {
					result.setBroker(broker);
				}
			}
			settles.add(result);
			model.addAttribute("settles", settles);
			model.addAttribute("today", time);
			return "app/brokeragereport/billofladingincome_info";
		}
		return "error";
	}

	private BolIncome setBol(String orderId, String brokerid, BigDecimal Trademoney, BigDecimal sum) {
		DeliveryOrder order = brokerageReportService.getOrder(orderId);
		Brokers broker = brokerageReportService.getIntermediary(brokerid, order.getDealerId());
		String intermediaryName = brokerageReportService.getFirmName(broker.getBrokerageid());
		BolIncome bolIncome = new BolIncome();
		bolIncome.setFirmId(order.getDealerId());
		bolIncome.setFirmName(order.getDealerName());
		bolIncome.setCommodityId(order.getCommodityId());
		bolIncome.setCommodityName(order.getCommodityName());
		bolIncome.setType(order.getDeliveryMethod());
		bolIncome.setCount(order.getDeliveryCounts());
		bolIncome.setQuataty(order.getDeliveryQuatity());
		bolIncome.setAmount(Trademoney);
		bolIncome.setIncome(sum);
		bolIncome.setIntermediaryId(broker.getFirmid());
		bolIncome.setIntermediaryName(intermediaryName);
		return bolIncome;
	}

	private List<BolIncome> getBolList(String time, String brokerid) {
		//注册费
		List<Firmrewarddeail> list1 = brokerageReportService.getCommission(time, brokerid,
				ChargeConstant.BusinessType.DELIVERY.getCode(), ChargeConstant.ChargeType.REGISTER.getCode());

		//注销费
		List<Firmrewarddeail> list2 = brokerageReportService.getCommission(time, brokerid,
				ChargeConstant.BusinessType.DELIVERY.getCode(), ChargeConstant.ChargeType.CANCEL.getCode());

		List<BolIncome> bilList = new ArrayList<BolIncome>();
		for (int i = 0; i < list1.size(); i++) {
			for (int b = 0; b < list2.size(); b++) {
				if (list1.get(i).getOrderId() == list2.get(b).getOrderId()) {
					BigDecimal sum = list1.get(i).getReward().add(list2.get(b).getReward());
					String orderId = list1.get(i).getOrderId();
					BigDecimal trademoney = list1.get(i).getTrademoney();
					BolIncome bolIncome = setBol(orderId, brokerid, trademoney, sum);
					bilList.add(bolIncome);
				} else {
					String orderId = list1.get(b).getOrderId();
					BigDecimal trademoney = list1.get(b).getTrademoney();
					BigDecimal sum = list1.get(b).getReward();
					BolIncome bolIncome = setBol(orderId, brokerid, trademoney, sum);
					bilList.add(bolIncome);
				}
			}
			String orderId = list1.get(i).getOrderId();
			BigDecimal trademoney = list1.get(i).getTrademoney();
			BigDecimal sum = list1.get(i).getReward();
			BolIncome bolIncome = setBol(orderId, brokerid, trademoney, sum);
			bilList.add(bolIncome);
		}
		return bilList;
	}
}
