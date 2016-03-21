package com.yrdce.ipo.modules.sys.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.yrdce.ipo.modules.sys.service.SPOService;
import com.yrdce.ipo.modules.sys.service.StatisticsReportService;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.Holdcommodity;
import com.yrdce.ipo.modules.sys.vo.Order;
import com.yrdce.ipo.modules.sys.vo.Purchase;
import com.yrdce.ipo.modules.sys.vo.SettleResult;

/**
 * @ClassName: StatisticsReportController
 * @Description: 统计报表
 * @author bob
 */
@Controller
@RequestMapping("statisticsReportController")
public class StatisticsReportController {

	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(StatisticsReportController.class);
	@Autowired
	private StatisticsReportService statisticsReportService;
	@Autowired
	private SPOService spoSerivice;//调用查找交易商名称方法

	@RequestMapping(value = "/purchase", method = RequestMethod.GET)
	public String purchase(Model model) {
		Map<String, String> comMap = statisticsReportService.cGetCommIdList();
		model.addAttribute("comMap", comMap);
		return "app/statisticsReport/purchaseindex";
	}

	@RequestMapping(value = "/purchaseInfo", method = RequestMethod.GET)
	public String purchaseInfo(Model model, @RequestParam(value = "commid", required = false) String commid,
			@RequestParam("time") String time) {
		List<SettleResult> settles = new ArrayList<SettleResult>();
		if (!"".equals(commid)) {
			if (commid != null) {
				SettleResult result = setPurchase(commid, time);
				settles.add(result);
			}
		} else {
			Map<String, String> comMap = statisticsReportService.cGetCommIdList();
			for (String id : comMap.keySet()) {
				SettleResult result = setPurchase(id, time);
				settles.add(result);
			}
		}
		model.addAttribute("settles", settles);
		model.addAttribute("time", time);
		return "app/statisticsReport/purchaseifo";
	}

	private SettleResult setPurchase(String commid, String time) {
		Commodity commod = statisticsReportService.cGetCommd(commid);
		List<Order> list1 = statisticsReportService.oGetOrderList(commid, time);
		List<Purchase> list = new ArrayList<Purchase>();
		int purCount = 0;
		BigDecimal purCost = new BigDecimal(0);
		long circulation = commod.getCounts();
		double purRate = 0;
		for (Order order : list1) {
			Purchase purchase = new Purchase();
			int count = order.getCounts();

			purchase.setFirmId(order.getUserid());
			purchase.setCount(count);
			purchase.setCost(order.getFrozenfunds());
			purchase.setCirculation(circulation);
			double rate = (count / circulation) * 100;
			purchase.setRate(rate);
			String name = spoSerivice.getFirmname(order.getUserid());
			purchase.setFirmName(name);
			list.add(purchase);
			purCount += count;
			purCost = (order.getFrozenfunds()).add(purCost);
			//purCir += circulation;
			purRate += rate;
		}
		SettleResult result = new SettleResult();
		result.setCommodity(commod);
		result.setPurchase(list);
		result.setPurcir(circulation);
		result.setPurcount(purCount);
		result.setPurcost(purCost);
		result.setPurrate(purRate);
		return result;
	}

	@RequestMapping(value = "/firmForHold", method = RequestMethod.GET)
	public String firmForHold(@RequestParam(value = "firmId", required = false) String firmId,
			@RequestParam("date") String date, Model model) {
		List<SettleResult> resultList = new ArrayList<SettleResult>();
		if (firmId != null && firmId != "") {
			List<Holdcommodity> list = statisticsReportService.hGetHold(date, firmId);
			String firmName = statisticsReportService.firmName(firmId);
			SettleResult result = new SettleResult();
			result.setHoldInfo(list);
			result.setBroker(firmName);
			result.setList(firmId);
			resultList.add(result);
		} else {
			List<String> firmIdList = statisticsReportService.findAllFirmid();
			for (String id : firmIdList) {
				logger.debug("遍历id：{}", id);
				List<Holdcommodity> list = statisticsReportService.hGetHold(date, id);
				String firmName = statisticsReportService.firmName(id);
				SettleResult result = new SettleResult();
				result.setBroker(firmName);
				result.setList(id);
				result.setHoldInfo(list);
				resultList.add(result);
			}
		}
		model.addAttribute("holdList", resultList);
		model.addAttribute("time", date);
		return "app/statisticsReport/info_hold_firm";
	}

}
