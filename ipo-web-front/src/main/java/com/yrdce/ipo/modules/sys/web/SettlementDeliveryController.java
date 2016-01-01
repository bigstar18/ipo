package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.SettlementDeliveryService;
import com.yrdce.ipo.modules.sys.vo.DeliveryCost;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
import com.yrdce.ipo.modules.sys.vo.Paging;
import com.yrdce.ipo.modules.sys.vo.Pickup;
import com.yrdce.ipo.modules.sys.vo.Position;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

/**
 * 
 * @author Bob
 *
 */
@Controller
@RequestMapping("SettlementDeliveryController")
public class SettlementDeliveryController {

	static Logger logger = LoggerFactory.getLogger(SettlementDeliveryController.class);
	@Autowired
	private SettlementDeliveryService settlementDeliveryService;

	// 提货申请视图
	@RequestMapping(value = "/deliveryview", method = RequestMethod.POST)
	public String deliveryView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/delivery/withdraw";
	}

	// 自提打印视图
	@RequestMapping(value = "/printView", method = RequestMethod.POST)
	public String printView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/delivery/customer";
	}

	// 撤销提货视图
	@RequestMapping(value = "/revocationView", method = RequestMethod.POST)
	public String revocationView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/delivery/cancel";
	}

	// 在线配送视图
	@RequestMapping(value = "/dispatchingView", method = RequestMethod.POST)
	public String dispatchingView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/delivery/dispatching";
	}

	// 提货查询视图
	@RequestMapping(value = "/deliveryQueryView", method = RequestMethod.POST)
	public String deliveryQueryView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/delivery/deliver";
	}

	// 费用查询视图
	@RequestMapping(value = "/costQueryView", method = RequestMethod.POST)
	public String costQueryView(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/delivery/cost";
	}

	// 提货申请
	@RequestMapping(value = "/deliveryApply", method = RequestMethod.POST)
	@ResponseBody
	public String deliveryApply(DeliveryOrder deliveryOrder) {
		String method = deliveryOrder.getDeliveryMethod();
		try {
			if (method.equals("1")) {
				deliveryOrder.setDeliveryMethod("自提");
				String name = new String(deliveryOrder.getCommodityName().getBytes("gbk"), "utf-8");
				deliveryOrder.setCommodityName(name);
				settlementDeliveryService.applicationByPickup(deliveryOrder);
				return "success";
			} else {
				deliveryOrder.setDeliveryMethod("在线配送");
				String name = new String(deliveryOrder.getCommodityName().getBytes("gbk"), "utf-8");
				deliveryOrder.setCommodityName(name);
				settlementDeliveryService.applicationByexpress(deliveryOrder);
				return "success";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	// 提货申请(初始化数据)
	@RequestMapping(value = "/deliveryInfo", method = RequestMethod.GET)
	@ResponseBody
	public String deliveryInfo(@RequestParam("dealerId") String firmid) {
		logger.info("提货申请(初始化数据)");
		try {
			List<Position> list = settlementDeliveryService.getListByPosition(firmid);
			return JSON.json(list);
		} catch (IOException e) {
			e.printStackTrace();
			return "error";
		}
	}

	// 提货申请(自提打印)(暂不用)
	@RequestMapping(value = "/deliveryBypickup", method = RequestMethod.GET)
	@ResponseBody
	public String deliveryBypickup(Pickup pickup) {
		logger.info("提货申请(自提打印)");
		try {
			settlementDeliveryService.applicationByPickup(pickup);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	// 提货申请(在线配送)(暂不用)
	@RequestMapping(value = "/deliveryByexpress", method = RequestMethod.GET)
	@ResponseBody
	public String deliveryByexpress(Express express) {
		logger.info("提货申请(在线配送)");
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
	public String print(@RequestParam("page") String page, @RequestParam("rows") String rows, Paging paging) {
		logger.info("自提打印" + "userid:" + paging.getDealerId() + "单号：" + paging.getDeliveryorderId());
		try {
			List<DeliveryOrder> clist = settlementDeliveryService.getPrint(page, rows, paging);
			int totalnums = settlementDeliveryService.counts(paging, "自提");
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
	@RequestMapping(value = "/getDetail", method = RequestMethod.POST)
	@ResponseBody
	public String getDetail(@RequestParam("methodid") String methodid) {
		logger.info("自提打印(操作后弹出的数据)" + "methodid:" + methodid);
		try {
			Pickup pickup = settlementDeliveryService.getDetail(methodid);
			return JSON.json(pickup);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	// 提货单状态修改(撤销提货、提货确认)
	@RequestMapping(value = "/updateByStatus", method = RequestMethod.POST)
	@ResponseBody
	public String updateByStatus(@RequestParam("deliveryorderid") String deliveryorderid, @RequestParam("status") String status) {
		logger.info("提货单状态修改(撤销提货、提货确认)" + "deliveryorderid:" + deliveryorderid + "status:" + status);
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
	public String getDispatching(@RequestParam("page") String page, @RequestParam("rows") String rows, Paging paging) {
		logger.info("在线配送" + "用户ID:" + paging.getDealerId() + "单号：" + paging.getDeliveryorderId());
		try {
			List<Express> clist = settlementDeliveryService.getListByExpress(page, rows, paging);
			int totalnums = settlementDeliveryService.counts(paging, "在线配送");
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
	public String delivery(@RequestParam("page") String page, @RequestParam("rows") String rows, Paging paging) {
		logger.info("提货查询" + paging.getDealerId() + "单号：" + paging.getDeliveryorderId());
		try {
			List<DeliveryOrder> clist = settlementDeliveryService.getListByOrder(page, rows, paging);
			int totalnums = settlementDeliveryService.countsByAll(paging);
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

	// 提货查询详细
	@RequestMapping(value = "/detail", method = RequestMethod.POST)
	@ResponseBody
	public String detail(@RequestParam("methodid") String methodid, @RequestParam("deliveryMethod") String deliveryMethod) {
		logger.info("提货查询(自提详细)" + "methodid:" + methodid);
		try {
			if (deliveryMethod.equals("1")) {
				Pickup pickup = settlementDeliveryService.getDetailByPickup(methodid);
				return JSON.json(pickup);
			} else {
				Express express = settlementDeliveryService.getDetailByExpress(methodid);
				return JSON.json(express);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	// 提货查询(自提详细)<暂不用>
	@RequestMapping(value = "/expressDetail", method = RequestMethod.GET)
	@ResponseBody
	public String expressDetail(@RequestParam("methodid") String methodid, @RequestParam("deliveryMethod") String deliveryMethod) {
		logger.info("提货查询(自提详细)" + "methodid:" + methodid);
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
	public String costQuery(@RequestParam("page") String page, @RequestParam("rows") String rows, Paging paging) {
		logger.info("费用查询" + "用户ID:" + paging.getDealerId() + "单号：" + paging.getDeliveryorderId());
		try {
			List<DeliveryCost> clist = settlementDeliveryService.getListByDeliveryCost(page, rows, paging);
			int totalnums = settlementDeliveryService.countsByCost(paging);
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(clist);
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
