package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.DeliveryOrderService;
import com.yrdce.ipo.modules.sys.service.OutboundService;
import com.yrdce.ipo.modules.sys.service.warehouse.IpoStorageService;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
import com.yrdce.ipo.modules.sys.vo.OutboundExtended;
import com.yrdce.ipo.modules.sys.vo.Pickup;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.VIpoStorageExtended;

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
	private IpoStorageService ipoStorageService;

	@Autowired
	private OutboundService outboundService;

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

	/**
	 * 分页返回提货单列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findAllDeliveryOrders", method = RequestMethod.POST)
	@ResponseBody
	public String findAllDeliveryOrders(@RequestParam("page") String page,
			@RequestParam("rows") String rows) throws IOException {
		log.info("分页查询所有提货单");
		try {
			List<DeliveryOrder> tlist = deliveryorderservice
					.findAllDeliOrdersByPage(page, rows);
			int totalnums = deliveryorderservice.getTotalNum();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			log.info(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
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
			@RequestParam("rows") String rows,
			@RequestParam("deliveryorderId") String deliveryorderId,
			@RequestParam("applyDate") String applyDate,
			@RequestParam("approvalStatus") String approvalStatus,
			@RequestParam("dealerId") String dealerId) throws IOException {
		log.info("模糊查询提货单");
		try {
			DeliveryOrder record = new DeliveryOrder();
			if (!deliveryorderId.equals("")) {
				record.setDeliveryorderId(deliveryorderId + "%");
			}
			if (!applyDate.equals("")) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(applyDate);
				record.setApplyDate(date);
			}
			if (!approvalStatus.equals("")) {
				record.setApprovalStatus(Integer.parseInt(approvalStatus));
			}
			if (!dealerId.equals("")) {
				record.setDealerId(dealerId + "%");
			}
			List<DeliveryOrder> dlist = deliveryorderservice
					.queryAllDeliOrdersByPage(page, rows, record);
			int totalnums = deliveryorderservice.getQueryNum(record).intValue();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(dlist);
			System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 分页返回可撤销提货单列表（模糊查询）
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/QueryCancelByConditions", method = RequestMethod.POST)
	@ResponseBody
	public String QueryCancelByConditions(@RequestParam("page") String page,
			@RequestParam("rows") String rows,
			@RequestParam("deliveryorderId") String deliveryorderId,
			@RequestParam("applyDate") String applyDate,
			@RequestParam("dealerId") String dealerId) throws IOException {
		log.info("模糊查询提货单");
		try {
			DeliveryOrder record = new DeliveryOrder();
			if (!deliveryorderId.equals("")) {
				record.setDeliveryorderId(deliveryorderId + "%");
			}
			if (!applyDate.equals("")) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(applyDate);
				record.setApplyDate(date);
			}
			if (!dealerId.equals("")) {
				record.setDealerId(dealerId + "%");
			}
			List<DeliveryOrder> dlist = deliveryorderservice
					.queryCancelDeliOrdersByPage(page, rows, record);

			int totalnums = deliveryorderservice.getQueryCancelNum(record)
					.intValue();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(dlist);
			System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 分页展示待审核提货单
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/approveDeliveryOrders", method = RequestMethod.POST)
	@ResponseBody
	public String approveDeliveryOrders(@RequestParam("page") String page,
			@RequestParam("rows") String rows) throws IOException {
		log.info("分页查询待审核提货单");
		try {
			List<DeliveryOrder> tlist = deliveryorderservice
					.approveDeliOrdersByPage(page, rows);
			int totalnums = deliveryorderservice.getApproveNum();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			log.info(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 分页展示可撤销提货单
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/cancelDeliveryOrders", method = RequestMethod.POST)
	@ResponseBody
	public String cancelDeliveryOrders(@RequestParam("page") String page,
			@RequestParam("rows") String rows) throws IOException {
		log.info("分页查询可撤销提货单");
		try {
			List<DeliveryOrder> tlist = deliveryorderservice
					.cancelDeliOrdersByPage(page, rows);
			int totalnums = deliveryorderservice.getCancelNum();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			log.info(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 审核提货单(自提)
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkPorders", method = RequestMethod.POST)
	@ResponseBody
	public String checkPorders(DeliveryOrder deorder, Pickup detail,
			HttpSession session) throws IOException {
		log.info("进行自提方式提货单审核");
		try {
			/*
			 * String userId = ((UserManageVO)
			 * session.getAttribute("CurrentUser")) .getUserID();
			 */
			String userId = "111";
			deliveryorderservice.updateDeliveryOrder(deorder, detail, userId);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 审核提货单(配送)
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkEorders", method = RequestMethod.POST)
	@ResponseBody
	public String checkEorders(DeliveryOrder deorder, Express detail,
			HttpSession session) throws IOException {
		log.info("进行在线配送方式提货单审核");
		try {
			/*
			 * String userId = ((UserManageVO)
			 * session.getAttribute("CurrentUser")) .getUserID();
			 */
			String userId = "111";
			deliveryorderservice.updateDeliveryOrder(deorder, detail, userId);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
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
	public String cancelOrders(@RequestParam("deorderId") String deorderId)
			throws IOException {
		log.info("撤销审核单");
		try {
			/*
			 * String userId = ((UserManageVO)
			 * session.getAttribute("CurrentUser")) .getUserID();
			 */
			String userId = "111";
			return deliveryorderservice.cancelDeorder(deorderId, userId);
		} catch (Exception e) {
			e.printStackTrace();
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
		log.info(storage.toString());
		try {
			List<VIpoStorageExtended> tlist = ipoStorageService.selectByPage(
					page, rows, storage);
			int totalnums = ipoStorageService.getTotalNum(storage);
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			log.info(JSON.json(result));
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
			/*
			 * String userId = ((UserManageVO)
			 * session.getAttribute("CurrentUser")) .getUserID();
			 */
			String userId = "111";
			int num = ipoStorageService.checkStorage(storageId, flag, userId);
			if (num != 0) {
				return new ModelAndView(
						"redirect:/IpoController/StorageApprove");
			}
			return new ModelAndView("redirect:/IpoController/StorageApprove");
		} catch (Exception e) {
			e.printStackTrace();
			return new ModelAndView("redirect:/IpoController/StorageApprove");
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
		log.info(outbound.toString());
		try {
			if (outbound != null) {
				String deliveryMethod = outbound.getDeliveryMethod();
				if (deliveryMethod.equals("")) {
					outbound.setDeliveryMethod(null);
				}
			}
			List<OutboundExtended> tlist = outboundService.getAllOutboundInfo(
					page, rows, outbound);
			int totalnums = outboundService.getTotalNum(outbound);
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			log.info(totalnums + "");
			log.info(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
