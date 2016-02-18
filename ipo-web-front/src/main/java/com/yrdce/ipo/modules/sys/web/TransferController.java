package com.yrdce.ipo.modules.sys.web;

import gnnt.MEBS.logonService.vo.UserManageVO;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.DeliveryOrderService;
import com.yrdce.ipo.modules.sys.service.PickUpService;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;

/**
 * 提单过户Controller
 * 
 * @author 陈婧
 * @version 2015.12.20
 */
@Controller
@RequestMapping("TransferController")
public class TransferController {

	@Autowired
	private DeliveryOrderService deliveryOrderService;

	@Autowired
	private PickUpService pickupservice;

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(TransferController.class);

	@RequestMapping(value = "/getDeliveryInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getDeliveryInfo(DeliveryOrder order, HttpSession session) {
		try {
			log.info("获取提货单信息");
			DeliveryOrder deliveryOrder;
			if (!order.getPickupPassword().equals("")) {
				deliveryOrder = deliveryOrderService
						.getPickupDeliveryInfo(order);
				return JSON.json(deliveryOrder);
			}
			return "";
		} catch (Exception e) {
			log.error("获取提货单信息异常", e);
			return "error";
		}

	}

	// 设置密码
	@RequestMapping(value = "/setPassword", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String setPassword(
			@RequestParam("deliveryorderid") String deliveryorderId,
			@RequestParam("pickupPassword") String pickupPassword) {
		DeliveryOrder order = deliveryOrderService
				.getDeliveryOrderByDeliOrderID(deliveryorderId);
		int num = pickupservice
				.setPassword(order.getMethodId(), pickupPassword);
		if (num == 1) {
			return "success";
		}
		return "fail";

	}

	// 过户
	@RequestMapping(value = "/updateSate", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateSate(
			@RequestParam("deliveryorderId") String deliveryorderId,
			HttpSession session) {
		try {
			log.info("确认过户");
			String userId = ((UserManageVO) session.getAttribute("CurrentUser"))
					.getUserID();
			deliveryOrderService.transferDeliveryOrder(deliveryorderId, userId);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			log.error("过户异常", e);
			return "error";
		}
	}

}
