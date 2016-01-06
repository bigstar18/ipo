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
import com.yrdce.ipo.modules.sys.service.DeliveryCommodityService;
import com.yrdce.ipo.modules.sys.service.DeliveryOrderService;
import com.yrdce.ipo.modules.sys.service.OutboundService;
import com.yrdce.ipo.modules.sys.vo.DeliveryCommodity;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
import com.yrdce.ipo.modules.sys.vo.IpoDeliveryProp;
import com.yrdce.ipo.modules.sys.vo.MProperty;
import com.yrdce.ipo.modules.sys.vo.OutboundExtended;
import com.yrdce.ipo.modules.sys.vo.Pickup;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.warehouse.service.IpoStorageService;
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
	private IpoStorageService ipoStorageService;

	@Autowired
	private OutboundService outboundService;

	@Autowired
	private DeliveryCommodityService deliveryCommService;

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
			log.info(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
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
			@RequestParam(value = "propertys") String propertys)
			throws IOException {
		log.info("设置商品的交收属性");
		try {
			if (commodityid != null && propertys != null) {
				return deliveryCommService.setDeliveryProps(commodityid,
						propertys);
			}
			return "false";
		} catch (Exception e) {
			e.printStackTrace();
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
			@RequestParam(value = "commodityId") String commodityid)
			throws IOException {
		log.info("删除商品的交收属性");
		try {
			if (commodityid != null) {
				return deliveryCommService.deleteDeliveryProps(commodityid);
			}
			return "false";
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

			String userId = ((UserManageVO) session.getAttribute("CurrentUser"))
					.getUserID();
			flag = "mgr" + flag;
			ipoStorageService.checkStorage(storageId, flag, userId);
			return new ModelAndView("redirect:/IpoController/StorageApprove");
		} catch (Exception e) {
			e.printStackTrace();
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
			log.info(record.toString());
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
			@RequestParam("rows") String rows, DeliveryOrder record)
			throws IOException {
		log.info("模糊查询可撤销提货单");
		try {
			log.info(record.toString());
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

			String userId = ((UserManageVO) session.getAttribute("CurrentUser"))
					.getUserID();
			// String userId = "111";
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
			String userId = ((UserManageVO) session.getAttribute("CurrentUser"))
					.getUserID();
			// String userId = "111";
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
	public String cancelOrders(@RequestParam("deorderId") String deorderId,
			HttpSession session) throws IOException {
		log.info("撤销审核单");
		try {
			// String userId = ((UserManageVO)
			// session.getAttribute("CurrentUser")).getUserID();
			String userId = "111";
			return deliveryorderservice.cancelDeorder(deorderId, userId);
		} catch (Exception e) {
			e.printStackTrace();
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
		log.info(outbound.toString());
		try {
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
