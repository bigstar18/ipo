package com.yrdce.ipo.modules.sys.web;

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
import com.yrdce.ipo.modules.sys.vo.Holdcommodity;
import com.yrdce.ipo.modules.sys.vo.Paging;
import com.yrdce.ipo.modules.sys.vo.Releasesubscription;

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
			@RequestParam(value = "firmid", required = false) String firmid,
			@RequestParam("time") String time) {
		Paging paging = new Paging();
		logger.debug(">>>>>>>>>>>>>>>>>>>>>>查询时间：" + time);
		paging.setDealerId(firmid);
		paging.setTime(time);
		List<Billoflading> billfladInfo = this.billfladInfo(paging);
		List<Delivery> deliveryInfo = this.deliveryInfo(paging);
		List<Holdcommodity> holdInfo = this.holdInfo(paging);
		List<Releasesubscription> releaInfo = this.releaInfo(paging);
		model.addAttribute("billfladInfo", billfladInfo);
		model.addAttribute("deliveryInfo", deliveryInfo);
		model.addAttribute("holdInfo", holdInfo);
		model.addAttribute("releaInfo", releaInfo);

		return "app/brokeragereport/brokerinfo";
	}

	@RequestMapping(value = "/brokerid", method = RequestMethod.GET)
	public String brokerId(Model model) {
		try {
			List<String> firmid = brokerageReportService.getBroker();
			model.addAttribute("firmid", firmid);
			return "app/brokeragereport/queryindex";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	public List<Billoflading> billfladInfo(Paging paging) {

		try {

			List<Billoflading> list = brokerageReportService.getBillfladInfo(paging);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Delivery> deliveryInfo(Paging paging) {
		try {

			List<Delivery> list = brokerageReportService.getDeliveryInfo(paging);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Holdcommodity> holdInfo(Paging paging) {
		try {

			List<Holdcommodity> list = brokerageReportService.getHoldInfo(paging);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Releasesubscription> releaInfo(Paging paging) {
		try {

			List<Releasesubscription> list = brokerageReportService.getReleaInfo(paging);
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
