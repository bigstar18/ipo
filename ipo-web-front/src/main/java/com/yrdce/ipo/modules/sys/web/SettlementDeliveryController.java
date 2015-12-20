package com.yrdce.ipo.modules.sys.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.SettlementDeliveryService;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
import com.yrdce.ipo.modules.sys.vo.Pickup;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

/**
 * 
 * @author Bob
 *
 */
@Controller
@RequestMapping("SettlementDeliveryController")
public class SettlementDeliveryController {
	@Autowired
	private SettlementDeliveryService settlementDeliveryService;

	// 提货申请视图(没有数据)
	@RequestMapping(value = "/deliveryview", method = RequestMethod.POST)
	public String deliveryView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/withdraw";
	}

	// 自提打印视图
	@RequestMapping(value = "/printView", method = RequestMethod.POST)
	public String printView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/customer";
	}

	// 撤销提货视图
	@RequestMapping(value = "/revocationView", method = RequestMethod.POST)
	public String revocationView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/cancel";
	}

	// 在线配送视图(没有页面)
	@RequestMapping(value = "/dispatchingView", method = RequestMethod.POST)
	public String dispatchingView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "null";
	}

	// 提货查询视图
	@RequestMapping(value = "/deliveryQueryView", method = RequestMethod.POST)
	public String deliveryQueryView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/deliver";
	}

	// 费用查询视图
	@RequestMapping(value = "/costQueryView", method = RequestMethod.POST)
	public String costQueryView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/cost";
	}

	// 提货申请(自提打印)
	@RequestMapping(value = "/deliveryBypickup", method = RequestMethod.GET)
	@ResponseBody
	public String deliveryBypickup(Pickup pickup) {
		try {
			settlementDeliveryService.applicationByPickup(pickup);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	// 提货申请(在线配送)
	@RequestMapping(value = "/deliveryByexpress", method = RequestMethod.GET)
	@ResponseBody
	public String deliveryByexpress(Express express) {
		try {
			settlementDeliveryService.applicationByexpress(express);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	// 自提打印
	@RequestMapping(value = "/print", method = RequestMethod.GET)
	@ResponseBody
	public String print(@RequestParam("page") String page, @RequestParam("rows") String rows, @RequestParam("userid") String userid,
			@RequestParam("mothod") String mothod) {
		try {
			List<DeliveryOrder> clist = settlementDeliveryService.getPrint(page, rows, userid);
			int totalnums = settlementDeliveryService.counts(userid, mothod);
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(clist);
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	// 自提打印(操作后弹出的数据)
	@RequestMapping(value = "/getDetail", method = RequestMethod.GET)
	@ResponseBody
	public String getDetail(@RequestParam("methodid") String methodid) {
		try {
			Pickup pickup = settlementDeliveryService.getDetail(methodid);
			return JSON.json(pickup);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	// 提货单状态修改(撤销提货、提货确认)
	@RequestMapping(value = "/updateByStatus", method = RequestMethod.GET)
	@ResponseBody
	public String updateByStatus(@RequestParam("deliveryorderid") String deliveryorderid, @RequestParam("status") String status) {
		try {
			settlementDeliveryService.getRevocation(deliveryorderid, status);
			return "success";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}

	// 在线配送
	@RequestMapping(value = "/getDispatching", method = RequestMethod.GET)
	@ResponseBody
	public String getDispatching(@RequestParam("page") String page, @RequestParam("rows") String rows, @RequestParam("userid") String userid,
			@RequestParam("mothod") String mothod) {
		try {
			List<Express> clist = settlementDeliveryService.getListByExpress(page, rows, userid);
			int totalnums = settlementDeliveryService.counts(userid, mothod);
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(clist);
			return JSON.json(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	// 提货查询
	@RequestMapping(value = "/delivery", method = RequestMethod.GET)
	@ResponseBody
	public String delivery(@RequestParam("page") String page, @RequestParam("rows") String rows, @RequestParam("userid") String userid) {
		try {
			List<DeliveryOrder> clist = settlementDeliveryService.getListByOrder(page, rows, userid);
			int totalnums = settlementDeliveryService.countsByAll(userid);
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(clist);
			return JSON.json(result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	// 提货查询(自提详细)
	@RequestMapping(value = "/pickupDetail", method = RequestMethod.GET)
	@ResponseBody
	public String pickupDetail(@RequestParam("methodid") String methodid) {
		try {
			Pickup pickup = settlementDeliveryService.getDetailByPickup(methodid);
			return JSON.json(pickup);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	// 提货查询(自提详细)
	@RequestMapping(value = "/expressDetail", method = RequestMethod.GET)
	@ResponseBody
	public String expressDetail(@RequestParam("methodid") String methodid) {
		try {
			Express express = settlementDeliveryService.getDetailByExpress(methodid);
			return JSON.json(express);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	// 费用查询
	@RequestMapping(value = "/costQuery", method = RequestMethod.GET)
	@ResponseBody
	public String costQuery(@RequestParam("page") String page, @RequestParam("rows") String rows, @RequestParam("userid") String userid) {
		return "";
	}
}
