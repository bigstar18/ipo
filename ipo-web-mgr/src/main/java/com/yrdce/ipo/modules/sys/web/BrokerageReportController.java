package com.yrdce.ipo.modules.sys.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yrdce.ipo.modules.sys.service.BrokerageReportService;
import com.yrdce.ipo.modules.sys.vo.Billoflading;
import com.yrdce.ipo.modules.sys.vo.Delivery;
import com.yrdce.ipo.modules.sys.vo.Firmrewarddeail;
import com.yrdce.ipo.modules.sys.vo.Holdcommodity;
import com.yrdce.ipo.modules.sys.vo.Income;
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

	@RequestMapping(value = "/brokerinfoforward", method = RequestMethod.GET)
	public String brokerInfoForward(HttpServletRequest request, Model model,
			@RequestParam(value = "brokerid", required = false) String brokerid,
			@RequestParam("time") String time) {
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
		} else {
			for (int i = 0; i < brokers.size(); i++) {
				String brokerid1 = brokers.get(i).getBrokerid();
				List<Billoflading> billfladInfo = brokerageReportService.getBillfladInfo(brokerid1, time);

				List<Delivery> deliveryInfo = brokerageReportService.getDeliveryInfo(brokerid1, time);

				List<Holdcommodity> holdInfo = brokerageReportService.getHoldInfo(brokerid1, time);

				List<Releasesubscription> releaInfo = brokerageReportService.getReleaInfo(brokerid1, time);

				SettleResult result = new SettleResult();
				result.setBillfladInfo(billfladInfo);
				result.setDeliveryInfo(deliveryInfo);
				result.setHoldInfo(holdInfo);
				result.setReleaInfo(releaInfo);
				result.setBroker(brokers.get(i));
				settles.add(result);
			}
			request.setAttribute("settles", settles);
			request.setAttribute("today", time);
			return "app/brokeragereport/brokerinfo";
		}
	}

	@RequestMapping(value = "/brokerid", method = RequestMethod.GET)
	public String brokerId(Model model) {
		try {
			List<VBrBroker> brokersList = brokerageReportService.getBroker();
			List<String> list = new ArrayList<String>();
			for (VBrBroker ipoBroker : brokersList) {
				String brokerid = ipoBroker.getBrokerid();
				list.add(brokerid);
			}
			model.addAttribute("firmid", list);
			return "app/brokeragereport/queryindex";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(value = "/brokerid", method = RequestMethod.GET)
	public String incomeForward(HttpServletRequest request, Model model,
			@RequestParam(value = "brokerid", required = false) String brokerid,
			@RequestParam("starttime") String starttime, @RequestParam("endtime") String endtime) {
		List<VBrBroker> brokers = brokerageReportService.getBroker();
		if (!"".equals(brokerid)) {
			List<Firmrewarddeail> list1 = brokerageReportService.getHandlingInfo(brokerid, starttime,
					endtime);
			BigDecimal allHandling = new BigDecimal(0);
			for (Firmrewarddeail firmrewarddeail : list1) {
				BigDecimal handling = firmrewarddeail.getReward();
				allHandling = allHandling.add(handling);
			}
			List<Firmrewarddeail> list2 = brokerageReportService.getRegisterInfo(brokerid, starttime,
					endtime);
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
			income.setFirmId(list1.get(0).getFirmid());
			for (VBrBroker broker : brokers) {
				if (brokerid.equals(broker.getBrokerid())) {
					income.setBrokerName(broker.getName());
				}
			}

		}
		return "error";
	}

	/*@RequestMapping(value = "/incomeforward", method = RequestMethod.GET)
	public String incomeForward(HttpServletRequest request, Model model,
			@RequestParam(value = "brokerid", required = false) String brokerid,
			@RequestParam("starttime") String starttime, @RequestParam("endtime") String endtime) {
		List<VBrBroker> brokers = brokerageReportService.getBroker();
		List<SettleResult> settles = new ArrayList<SettleResult>();
		if (!"".equals(brokerid)) {
	
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
		} else {
			for (int i = 0; i < brokers.size(); i++) {
	
				SettleResult result = new SettleResult();
				result.setBillfladInfo(billfladInfo);
				result.setDeliveryInfo(deliveryInfo);
				result.setHoldInfo(holdInfo);
				result.setReleaInfo(releaInfo);
				result.setBroker(brokers.get(i));
				settles.add(result);
			}
			request.setAttribute("settles", settles);
			request.setAttribute("today", time);
			return "app/brokeragereport/brokerinfo";
		}
	}*/

}
