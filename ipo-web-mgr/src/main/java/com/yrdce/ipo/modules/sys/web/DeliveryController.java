package com.yrdce.ipo.modules.sys.web;

import gnnt.MEBS.logonService.vo.UserManageVO;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.constant.DeliveryConstant;
import com.yrdce.ipo.modules.sys.service.CustomerHoldSumService;
import com.yrdce.ipo.modules.sys.service.DeliveryCommodityService;
import com.yrdce.ipo.modules.sys.service.DeliveryOrderService;
import com.yrdce.ipo.modules.sys.service.OutboundService;
import com.yrdce.ipo.modules.sys.service.SystemService;
import com.yrdce.ipo.modules.sys.service.UnderwriterSubscribeService;
import com.yrdce.ipo.modules.sys.util.WriteLog;
import com.yrdce.ipo.modules.sys.vo.DeliveryCommodity;
import com.yrdce.ipo.modules.sys.vo.DeliveryCost;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.IpoDeliveryProp;
import com.yrdce.ipo.modules.sys.vo.MProperty;
import com.yrdce.ipo.modules.sys.vo.OutboundExtended;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.warehouse.service.IpoStorageService;
import com.yrdce.ipo.modules.warehouse.service.IpoWarehouseStockService;
import com.yrdce.ipo.modules.warehouse.vo.IpoWarehouseStock;
import com.yrdce.ipo.modules.warehouse.vo.VIpoStorageExtended;

/**
 * 交收管理Controller
 * 
 * @author chenjing
 * @version 2013-5-31
 */
@Controller
@RequestMapping("DeliveryController")
public class DeliveryController {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(DeliveryController.class);

	@Autowired
	private DeliveryOrderService deliveryorderservice;

	@Autowired
	private SystemService systemService;

	@Autowired
	private IpoStorageService ipoStorageService;

	@Autowired
	private OutboundService outboundService;

	@Autowired
	private DeliveryCommodityService deliveryCommService;

	@Autowired
	private IpoWarehouseStockService warehouseStockService;

	@Autowired
	private CustomerHoldSumService customerHoldSumService;

	@Autowired
	private UnderwriterSubscribeService underwritersubscribeService;

	public OutboundService getOutboundService() {
		return outboundService;
	}

	public void setOutboundService(OutboundService outboundService) {
		this.outboundService = outboundService;
	}

	public DeliveryOrderService getDeliveryorderservice() {
		return deliveryorderservice;
	}

	public void setDeliveryorderservice(
			DeliveryOrderService deliveryorderservice) {
		this.deliveryorderservice = deliveryorderservice;
	}

	public IpoStorageService getIpoStorageService() {
		return ipoStorageService;
	}

	public void setIpoStorageService(IpoStorageService ipoStorageService) {
		this.ipoStorageService = ipoStorageService;
	}

	public DeliveryCommodityService getDeliveryCommService() {
		return deliveryCommService;
	}

	public void setDeliveryCommService(
			DeliveryCommodityService deliveryCommService) {
		this.deliveryCommService = deliveryCommService;
	}

	/**
	 * 交收属性管理列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/deliveryPropsList", method = RequestMethod.POST)
	@ResponseBody
	public String deliveryPropsList(
			@RequestParam("page") String page,
			@RequestParam("rows") String rows,
			@RequestParam(value = "commodityName", required = false) String commodityname,
			@RequestParam(value = "commodityId", required = false) String commodityid)
			throws IOException {
		log.info("查询交收属性管理商品列表");
		try {
			DeliveryCommodity example = new DeliveryCommodity();
			if (commodityname != null && commodityid != null) {
				example.setCommodityId(commodityid);
				example.setCommodityName(commodityname);
			}
			List<DeliveryCommodity> tlist = deliveryCommService
					.findDeliveryCommoditys(page, rows, example);
			int totalnums = deliveryCommService.getNums(example);
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			log.debug(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			log.error(" 查询交收属性管理列表error:", e);
			return "error";
		}
	}

	/**
	 * 设置交收属性视图
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/setDeliveryProps", method = RequestMethod.GET)
	public String setDeliveryProps(
			HttpServletRequest request,
			@RequestParam(value = "commodityId", required = false) String commodityid,
			@RequestParam(value = "categoryId", required = false) String categoryId,
			@RequestParam(value = "commName", required = false) String commName,
			@RequestParam(value = "breedId", required = false) String breedId)
			throws IOException {
		log.info("跳转至交收属性视图");
		try {
			request.setAttribute("commodityId", commodityid);
			request.setAttribute("commodityName", commName);
			List<MProperty> proplist = null;
			List<MProperty> propvaluelist = null;
			List<IpoDeliveryProp> ipoproplist = null;
			if (categoryId != null) {
				proplist = deliveryCommService.getPropsByCategoryId(Long
						.parseLong(categoryId));
			}
			if (breedId != null) {
				propvaluelist = deliveryCommService.getPropertyValues(
						Long.parseLong(categoryId), Long.parseLong(breedId));
			}
			if (commodityid != null) {
				ipoproplist = deliveryCommService
						.selectByCommodityId(commodityid);
			}
			request.setAttribute("ipoproplist", ipoproplist);
			request.setAttribute("proplist", proplist);
			request.setAttribute("flag", proplist.size());
			request.setAttribute("propvaluelist", propvaluelist);
			return "app/delivery/propsManage";
		} catch (Exception e) {
			log.error("跳转设置交收属性视图error:", e);
			return "error";
		}
	}

	/**
	 * 设置商品交收属性
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/setCommDeliveryProps", method = RequestMethod.POST)
	@ResponseBody
	public String setCommDeliveryProps(
			@RequestParam(value = "commodityId") String commodityid,
			@RequestParam(value = "propertys") String propertys,
			HttpSession session) throws IOException {
		log.info("设置商品的交收属性");
		try {
			if (commodityid != null && propertys != null) {
				String result = deliveryCommService.setDeliveryProps(
						commodityid, propertys);
				if (result.equals("true")) {
					WriteLog.writeOperateLog(
							WriteLog.SYS_LOG_DELIVERY_CATALOGID, "ipo设置交收属性成功",
							WriteLog.SYS_LOG_OPE_SUCC, "", session,
							systemService);
				}
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_DELIVERY_CATALOGID,
						"ipo设置交收属性失败", WriteLog.SYS_LOG_OPE_FAILURE, "",
						session, systemService);
				return result;
			}
			return "false";
		} catch (Exception e) {
			log.error("设置商品交收属性error:", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DELIVERY_CATALOGID,
					"ipo设置交收属性失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session,
					systemService);
			return "error";
		}
	}

	/**
	 * 删除商品交收属性
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/deleteCommDeliveryProps", method = RequestMethod.POST)
	@ResponseBody
	public String deleteCommDeliveryProps(
			@RequestParam(value = "commodityId") String commodityid,
			HttpSession session) throws IOException {
		log.info("删除商品的交收属性");
		try {
			if (commodityid != null) {
				String result = deliveryCommService
						.deleteDeliveryProps(commodityid);
				if ("true".equals(result)) {
					WriteLog.writeOperateLog(
							WriteLog.SYS_LOG_DELIVERY_CATALOGID,
							"ipo删除商品交收属性成功", WriteLog.SYS_LOG_OPE_SUCC, "",
							session, systemService);
					return result;
				}
			}
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DELIVERY_CATALOGID,
					"ipo删除商品交收属性失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session,
					systemService);
			return "false";
		} catch (Exception e) {
			log.error("删除商品交收属性error:", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DELIVERY_CATALOGID,
					"ipo删除商品交收属性失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session,
					systemService);
			return "error";
		}

	}

	/**
	 * 分页返回入库单列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findAllStorages", method = RequestMethod.POST)
	@ResponseBody
	public String findAllStorages(@RequestParam("page") String page,
			@RequestParam("rows") String rows, VIpoStorageExtended storage)
			throws IOException {
		log.info("分页查询入库单");
		log.debug(storage.toString());
		try {
			List<VIpoStorageExtended> tlist = ipoStorageService.selectByPage(
					page, rows, storage);
			int totalnums = ipoStorageService.getTotalNum(storage);
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			log.debug(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 审核入库单
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/approveStorages", method = RequestMethod.GET)
	public ModelAndView approveStorages(
			@RequestParam("storageId") String storageId,
			@RequestParam("flag") String flag, HttpSession session)
			throws IOException {
		log.info("审核入库单");
		try {

			String userId = ((UserManageVO) session.getAttribute("CurrentUser"))
					.getUserID();
			flag = "mgr" + flag;
			Integer result = ipoStorageService.checkStorage(storageId, flag,
					userId);
			if (result == 0) {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_DELIVERY_CATALOGID,
						"ipo市场审核入库单失败", WriteLog.SYS_LOG_OPE_FAILURE, "",
						session, systemService);
			} else {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_DELIVERY_CATALOGID,
						"ipo市场审核入库单成功", WriteLog.SYS_LOG_OPE_SUCC, "", session,
						systemService);
			}
			return new ModelAndView("redirect:/IpoController/StorageApprove");
		} catch (Exception e) {
			log.error("市场审核入库单error:", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DELIVERY_CATALOGID,
					"ipo市场审核入库单失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session,
					systemService);
			return new ModelAndView("redirect:/IpoController/StorageApprove");
		}
	}

	/**
	 * 分页返回提货单列表（模糊查询）
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/QueryByConditions", method = RequestMethod.POST)
	@ResponseBody
	public String QueryByConditions(@RequestParam("page") String page,
			@RequestParam("rows") String rows, DeliveryOrder record)
			throws IOException {
		log.info("模糊查询提货单");
		try {
			log.debug(record.toString());
			record.setApprovalStatus(DeliveryConstant.StatusType.REGISTER
					.getCode());
			List<DeliveryOrder> dlist = deliveryorderservice
					.queryAllDeliOrdersByPage(page, rows, record);// 提货单号是以输入数字开头的模糊查询
			int totalnums = deliveryorderservice.getQueryNum(record).intValue();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(dlist);
			log.debug(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 审核提货单
	 * 
	 * @param deorder
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkOrders", method = RequestMethod.POST)
	@ResponseBody
	public String checkPorders(DeliveryOrder deorder, HttpSession session)
			throws IOException {
		log.info("进行提货单审核");
		try {

			String userId = ((UserManageVO) session.getAttribute("CurrentUser"))
					.getUserID();
			if (deorder.getApprovalStatus().equals(
					DeliveryConstant.StatusType.MARKETPASS.getCode())) {
				String result = deliveryorderservice.updateDeliveryOrder(
						deorder, userId);
				if (result.equals("true")) {
					deliveryorderservice.frozenStock(deorder);
					WriteLog.writeOperateLog(
							WriteLog.SYS_LOG_DELIVERY_CATALOGID,
							"ipo市场审核提货单成功", WriteLog.SYS_LOG_OPE_SUCC, "",
							session, systemService);
					return "true";
				}
			}
			if (deorder.getApprovalStatus().equals(
					DeliveryConstant.StatusType.MARKETNOPASS.getCode())) {
				String result = deliveryorderservice.updateDeliveryOrder(
						deorder, userId);
				if (result.equals("true")) {
					customerHoldSumService
							.unfreezeCustomerHold(deorder.getDeliveryQuatity(),
									deorder.getDealerId() + "00",
									deorder.getCommodityId(), (short) 1);
					DeliveryCost cost = deliveryorderservice
							.getCostByDeliveryOrder(deorder);
					if (cost != null) {
						underwritersubscribeService.unfreeFunds(
								deorder.getDealerId(),
								cost.getRegistrationFee());
					}
					WriteLog.writeOperateLog(
							WriteLog.SYS_LOG_DELIVERY_CATALOGID,
							"ipo市场审核提货单成功", WriteLog.SYS_LOG_OPE_SUCC, "",
							session, systemService);
					return "true";
				}
			}
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DELIVERY_CATALOGID,
					"ipo市场审核提货单失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session,
					systemService);
			return "false";
		} catch (Exception e) {
			log.error("市场审核提货单error:", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DELIVERY_CATALOGID,
					"ipo市场审核入库单失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session,
					systemService);
			return "error";
		}
	}

	/**
	 * 撤销审核单
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/cancelOrders", method = RequestMethod.POST)
	@ResponseBody
	public String cancelOrders(@RequestParam("deorderId") String deorderId,
			HttpSession session) throws IOException {
		log.info("撤销审核单");
		try {
			String userId = ((UserManageVO) session.getAttribute("CurrentUser"))
					.getUserID();
			DeliveryOrder deorder = deliveryorderservice
					.getDeliveryOrderByDeliOrderID(deorderId);
			DeliveryCost cost = deliveryorderservice
					.getCostByDeliveryOrder(deorder);
			if (deorder != null && cost != null) {
				if (deorder.getApprovalStatus().equals(
						DeliveryConstant.StatusType.REGISTER.getCode())) {
					String result = deliveryorderservice.cancelDeorder(
							deorderId, userId);
					if (result.equals("true")) {
						customerHoldSumService.unfreezeCustomerHold(
								deorder.getDeliveryQuatity(),
								deorder.getDealerId() + "00",
								deorder.getCommodityId(), (short) 1);
						underwritersubscribeService.unfreeFunds(
								deorder.getDealerId(),
								cost.getRegistrationFee());
						WriteLog.writeOperateLog(
								WriteLog.SYS_LOG_DELIVERY_CATALOGID,
								"ipo市场撤销审核单成功", WriteLog.SYS_LOG_OPE_SUCC, "",
								session, systemService);
						return "true";

					}
				}
				if (deorder.getApprovalStatus().equals(
						DeliveryConstant.StatusType.MARKETPASS.getCode())
						|| deorder.getApprovalStatus().equals(
								DeliveryConstant.StatusType.PRINTED.getCode())
						|| deorder.getApprovalStatus().equals(
								DeliveryConstant.StatusType.EXPRESSCOSTSET
										.getCode())) {
					String result = deliveryorderservice.cancelDeorder(
							deorderId, userId);
					if (result.equals("true")) {
						customerHoldSumService.unfreezeCustomerHold(
								deorder.getDeliveryQuatity(),
								deorder.getDealerId() + "00",
								deorder.getCommodityId(), (short) 1);
						deliveryorderservice.unfrozenStock(deorder);
						underwritersubscribeService.unfreeFunds(
								deorder.getDealerId(),
								cost.getRegistrationFee());
						WriteLog.writeOperateLog(
								WriteLog.SYS_LOG_DELIVERY_CATALOGID,
								"ipo市场撤销审核单成功", WriteLog.SYS_LOG_OPE_SUCC, "",
								session, systemService);
						return "true";
					}
				}
			}
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DELIVERY_CATALOGID,
					"ipo市场撤销审核单失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session,
					systemService);
			return "false";
		} catch (Exception e) {
			log.error("ipo撤销审核单error:", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DELIVERY_CATALOGID,
					"ipo市场撤销审核单失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session,
					systemService);
			return "error";
		}
	}

	/**
	 * 分页返回出库单列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findAllOutBounds", method = RequestMethod.POST)
	@ResponseBody
	public String findAllOutBounds(@RequestParam("page") String page,
			@RequestParam("rows") String rows, OutboundExtended outbound)
			throws IOException {
		log.info("分页查询出库单");
		log.debug(outbound.toString());
		try {
			List<OutboundExtended> tlist = outboundService.getAllOutboundInfo(
					page, rows, outbound);
			int totalnums = outboundService.getTotalNum(outbound);
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			log.debug(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 分页返回库存信息列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findStocks", method = RequestMethod.POST)
	@ResponseBody
	public String findStocks(@RequestParam("page") String page,
			@RequestParam("rows") String rows, IpoWarehouseStock stock,
			HttpSession session) throws IOException {
		log.info("分页查询库存列表");
		try {
			if (stock != null) {
				log.debug(stock.toString());
				if (stock.getWarehouseid() != null) {
					if (stock.getWarehouseid().equals("")) {
						stock.setWarehouseid(null);
					}
				}
			}
			List<IpoWarehouseStock> slist = warehouseStockService
					.findWarehouseStockByPage(page, rows, stock);
			int totalnums = warehouseStockService.getQueryNum(stock);
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(slist);
			log.debug(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
