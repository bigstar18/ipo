package com.yrdce.ipo.modules.sys.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.constant.DeliveryConstant;
import com.yrdce.ipo.modules.sys.service.CustomerHoldSumService;
import com.yrdce.ipo.modules.sys.service.DeliveryOrderService;
import com.yrdce.ipo.modules.sys.service.PickUpService;
import com.yrdce.ipo.modules.sys.util.DESCodec;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Pickup;

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

	@Autowired
	private CustomerHoldSumService customerHoldSumService;

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(TransferController.class);

	@RequestMapping(value = "/getDeliveryInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getDeliveryInfo(DeliveryOrder order, HttpSession session) {
		try {
			log.info("获取提货单信息");
			DeliveryOrder deliveryOrder;
			if (!order.getPickupPassword().equals("")) {
				String password = DESCodec.encrypt(order.getPickupPassword(),
						"csjcsjcsjcsj");
				order.setPickupPassword(password);
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
			@RequestParam("pickupPassword") String pickupPassword)
			throws Exception {
		if (pickupPassword.equals("")) {
			return "fail";
		}
		DeliveryOrder order = deliveryOrderService
				.getDeliveryOrderByDeliOrderID(deliveryorderId);
		String password = DESCodec.encrypt(pickupPassword, "csjcsjcsjcsj");
		int num = pickupservice.setPassword(order.getMethodId(), password);
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
			@RequestParam("pickupPassword") String pickupPassword,
			HttpSession session) {
		try {
			log.info("确认过户");
			String firmId = (String) session.getAttribute("currentFirmId");
			// String firmId = "000000003";
			DeliveryOrder deorder = deliveryOrderService
					.getDeliveryOrderByDeliOrderID(deliveryorderId);
			if (deorder != null) {
				Pickup pickup = pickupservice.getPickUpByPid(deorder
						.getMethodId());
				String password = DESCodec.encrypt(pickupPassword,
						"csjcsjcsjcsj");
				if (pickup != null) {
					if (!pickup.getPickupPassword().equals(password)) {
						return "false";
					}
				}
				if (deorder.getApprovalStatus().equals(
						DeliveryConstant.StatusType.PRINTED.getCode())
						|| deorder.getApprovalStatus().equals(
								DeliveryConstant.StatusType.MARKETPASS
										.getCode())) {
					return deliveryOrderService.transferDeliveryOrder(
							deliveryorderId, firmId);
				}
			}
			return "false";
		} catch (Exception e) {
			log.error("过户异常", e);
			return "error";
		}
	}
}
