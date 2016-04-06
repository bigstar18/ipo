package com.yrdce.ipo.web;

import gnnt.MEBS.logonService.vo.UserManageVO;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.constant.DeliveryConstant;
import com.yrdce.ipo.modules.sys.service.DeliveryOrderService;
import com.yrdce.ipo.modules.sys.service.OutboundService;
import com.yrdce.ipo.modules.sys.service.SystemService;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Outbound;
import com.yrdce.ipo.modules.sys.vo.OutboundExtended;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.warehouse.service.IpoStorageService;
import com.yrdce.ipo.util.DESCodec;
import com.yrdce.ipo.util.WriteLog;

/**
 * 入库申请Controller
 * 
 * @author 李伟东
 * @version 2015.12.20
 */
@Controller
@RequestMapping("OutBoundController")
public class OutBoundController {

	private static Logger log = org.slf4j.LoggerFactory
			.getLogger(OutBoundController.class);

	@Autowired
	private OutboundService outboundService;
	@Autowired
	private DeliveryOrderService deliveryOrderService;
	@Autowired
	private IpoStorageService ipoStorageService;
	@Autowired
	private SystemService systemService;

	@RequestMapping(value = "/geOutBoundInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String geOutBoundInfo(@RequestParam("page") String page,
			@RequestParam("rows") String rows, OutboundExtended outbound,
			HttpSession session) {
		try {
			String operatorid = ((UserManageVO) session
					.getAttribute("CurrentUser")).getUserID();
			Long wareHouseId = ipoStorageService
					.getWarehousePrimary(operatorid);
			outbound.setWarehouseid(String.valueOf(wareHouseId));
			List<OutboundExtended> slist = outboundService.getAllOutboundInfo(
					page, rows, outbound);
			int counts = outboundService.getTotalNum(outbound);
			ResponseResult result = new ResponseResult();
			result.setRows(slist);
			result.setTotal(counts);
			log.debug(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			log.error("获取出库信息异常", e);
			return "";
		}
	}

	@RequestMapping(value = "/getDeliveryInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getDeliveryInfo(DeliveryOrder order, HttpSession session) {
		try {
			log.info("获取提货单信息");
			DeliveryOrder deliveryOrder;
			String operatorid = ((UserManageVO) session
					.getAttribute("CurrentUser")).getUserID();
			Long wareHouseId = ipoStorageService
					.getWarehousePrimary(operatorid);
			order.setWarehouseId(String.valueOf(wareHouseId));
			if (!order.getPickupPassword().equals("")) {
				String password = order.getPickupPassword();
				order.setPickupPassword(DESCodec.encrypt(password,
						"csjcsjcsjcsj"));
				deliveryOrder = deliveryOrderService
						.getPickupDeliveryInfo(order);
			} else {
				deliveryOrder = deliveryOrderService
						.getExpressDeliveryInfo(order);
			}
			if (deliveryOrder != null) {
				String request = JSON.json(deliveryOrder);
				return request;
			} else {
				return "";
			}
		} catch (Exception e) {
			log.error("获取提货单信息异常", e);
			return "error";
		}

	}

	// 出库单审核
	@RequestMapping(value = "/updateOutBoundInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateOutBoundInfo(Outbound outbound, HttpSession session) {
		try {
			log.info("出库单审核");
			String deliveryid = outbound.getDeliveryorderid();
			DeliveryOrder deliveryOrder = deliveryOrderService
					.getDeliveryOrderByDeliOrderID(deliveryid);
			if (deliveryOrder != null) {
				if ((DeliveryConstant.StatusType.PRINTED.getCode())
						.equals(deliveryOrder.getApprovalStatus())
						|| (DeliveryConstant.StatusType.CONFIRM.getCode())
								.equals(deliveryOrder.getApprovalStatus())) {
					String auditorid = ((UserManageVO) session
							.getAttribute("CurrentUser")).getUserID();
					long wareHouseId = ipoStorageService
							.getWarehousePrimary(auditorid);
					outbound.setAuditorid(auditorid);
					outbound.setWarehouseid(String.valueOf(wareHouseId));
					int result = outboundService.updateOutBoundInfo(outbound);
					if (result > 0) {
						WriteLog.writeOperateLog(
								WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
								"IPO出库审核: 出库单号" + outbound.getOutboundorderid()
										+ "审核成功", WriteLog.SYS_LOG_OPE_SUCC,
								"", session, systemService);
						return "success";
					} else {
						WriteLog.writeOperateLog(
								WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
								"IPO出库审核: 出库单号" + outbound.getOutboundorderid()
										+ "审核失败", WriteLog.SYS_LOG_OPE_FAILURE,
								"", session, systemService);
						return "fail";
					}
				}
				return "nopermisson";
			}
			return "noexist";
		} catch (Exception e) {
			log.error("出库单审核", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
					"IPO出库审核: 出库单号" + outbound.getOutboundorderid() + "审核失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", session, systemService);
			return "error";
		}
	}

	// 出库单添加
	@RequestMapping(value = "/addOutBoundOrder", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addOutBoundOrder(Outbound outBound, HttpSession session) {
		try {
			log.info("出库单添加");
			String deliveryid = outBound.getDeliveryorderid();
			DeliveryOrder deliveryOrder = deliveryOrderService
					.getDeliveryOrderByDeliOrderID(deliveryid);
			if (deliveryOrder != null) {
				if ((DeliveryConstant.StatusType.PRINTED.getCode())
						.equals(deliveryOrder.getApprovalStatus())
						|| (DeliveryConstant.StatusType.CONFIRM.getCode())
								.equals(deliveryOrder.getApprovalStatus())) {
					String operatorid = ((UserManageVO) session
							.getAttribute("CurrentUser")).getUserID();
					long wareHouseId = ipoStorageService
							.getWarehousePrimary(operatorid);
					outBound.setWarehouseid(String.valueOf(wareHouseId));
					log.info(outBound.getIdnum());
					outBound.setOperatorid(operatorid);
					int result = outboundService.addOutBoundOrder(outBound);
					if (result == 1) {
						WriteLog.writeOperateLog(
								WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
								"IPO出库添加: 出库单号" + outBound.getOutboundorderid()
										+ "添加成功", WriteLog.SYS_LOG_OPE_SUCC,
								"", session, systemService);
						return "success";
					} else {
						WriteLog.writeOperateLog(
								WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
								"IPO出库添加: 出库单号" + outBound.getOutboundorderid()
										+ "添加失败", WriteLog.SYS_LOG_OPE_FAILURE,
								"", session, systemService);
						return "fail";
					}
				}
				return "nopermisson";
			}
			return "noexist";
		} catch (Exception e) {
			log.error("出库单添加", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
					"IPO出库添加: 出库单号" + outBound.getOutboundorderid() + "添加失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", session, systemService);
			return "error";
		}
	}

	// 修改提货单状态
	@RequestMapping(value = "/updateSate", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateSate(
			@RequestParam("deliveryorderId") String deliveryorderId,
			@RequestParam("outboundorderid") String outboundorderid,
			HttpSession session) {
		try {
			log.info("确认出库");
			DeliveryOrder temp = deliveryOrderService
					.getDeliveryOrderByDeliOrderID(deliveryorderId);
			if (temp.getDeliveryMethod().equals("在线配送")
					&& !temp.getApprovalStatus()
							.equals(DeliveryConstant.StatusType.WAREHOUSEPASS
									.getCode())) {
				return "no";
			}
			DeliveryOrder deliveryOrder = new DeliveryOrder();
			deliveryOrder.setDeliveryorderId(deliveryorderId);
			deliveryOrder
					.setApprovalStatus(DeliveryConstant.StatusType.WAREHOUSEOUT
							.getCode());
			int result = deliveryOrderService.updateStatus(deliveryOrder,
					outboundorderid);
			if (result == 1) {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
						"IPO确认出库: 出库单号 " + outboundorderid + "出库成功",
						WriteLog.SYS_LOG_OPE_SUCC, "", session, systemService);
				return "success";
			} else {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
						"IPO确认出库: 出库单号" + outboundorderid + "出库失败",
						WriteLog.SYS_LOG_OPE_FAILURE, "", session,
						systemService);
				return "fail";
			}

		} catch (Exception e) {
			log.error("修改出库单状态", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
					"IPO确认出库: 出库单号" + outboundorderid + "出库失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", session, systemService);
			return "error";
		}
	}

	@RequestMapping(value = "/getOutboundorder")
	@ResponseBody
	public boolean getOutboundorder(
			@RequestParam("deliveryorderId") String outboundId) {
		try {
			log.info("验证出库单是否存在");
			Outbound outBound = outboundService.getOutboundOrder(outboundId);
			return outBound == null;

		} catch (Exception e) {
			log.error("验证出库单是否存在", e);
			return false;
		}
	}

}
