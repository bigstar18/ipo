package com.yrdce.ipo.modules.sys.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yrdce.ipo.modules.sys.service.StatisticsReportService;
import com.yrdce.ipo.modules.sys.vo.Billoflading;
import com.yrdce.ipo.modules.sys.vo.Delivery;
import com.yrdce.ipo.modules.sys.vo.FundSettlement;
import com.yrdce.ipo.modules.sys.vo.Holdcommodity;
import com.yrdce.ipo.modules.sys.vo.Releasesubscription;

/**
 * @ClassName: BillingReportController
 * @Description: 资金结算报表
 * @author bob
 */
@Controller
@RequestMapping("BillingReportController")
public class BillingReportController {

	Logger logger = LoggerFactory.getLogger(BillingReportController.class);
	@Autowired
	private StatisticsReportService statisticsReportService;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * @Title: getInfo
	 * @Description: 资金结算
	 */
	@RequestMapping(value = "/getInfo", method = RequestMethod.POST)
	public String getInfo(HttpSession session, HttpServletRequest request) {
		String date = sdf.format(new Date());
		querySet(date, request, session);
		return "app/reportform_settlement";
	}

	private void querySet(String date, HttpServletRequest request, HttpSession session) {
		logger.info("查询时间：{}", date);
		String userid = (String) session.getAttribute("currentFirmId");
		//String userid = "SC";
		FundSettlement funs = statisticsReportService.fGetFund(userid, date);
		List<Releasesubscription> rList = statisticsReportService.rGetReleaInfo(userid, date);
		logger.debug("rlist长度：{}", rList.size());
		List<Billoflading> bList = statisticsReportService.bGetBillfladInfo(userid, date);
		logger.debug("blist长度：{}", bList.size());
		List<Holdcommodity> hList = statisticsReportService.hGetHoldInfo(userid, date);
		logger.debug("hlist长度：{}", hList.size());
		List<Delivery> dList = statisticsReportService.dGetDeliveryInfo(userid, date);
		logger.debug("dlist长度：{}", dList.size());

		request.setAttribute("funs", funs);
		request.setAttribute("rList", rList);
		request.setAttribute("bList", bList);
		request.setAttribute("hList", hList);
		request.setAttribute("dList", dList);
		request.setAttribute("time", date);
	}

	@RequestMapping(value = "/fundsforward", method = RequestMethod.GET)
	public String fundsforward(HttpSession session,
			@RequestParam(value = "date", required = false) String date, Model model,
			HttpServletRequest request) {
		querySet(date, request, session);
		return "app/reportform_settlement";
	}

}
