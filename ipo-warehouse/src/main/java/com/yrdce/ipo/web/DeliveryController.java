package com.yrdce.ipo.web;

import gnnt.MEBS.logonService.vo.UserManageVO;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.yrdce.ipo.common.constant.DeliveryConstant;
import com.yrdce.ipo.modules.sys.service.DeliveryCommodityService;
import com.yrdce.ipo.modules.sys.service.DeliveryOrderService;
import com.yrdce.ipo.modules.sys.service.IpoCommConfService;
import com.yrdce.ipo.modules.sys.service.OutboundService;
import com.yrdce.ipo.modules.sys.service.SystemService;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;
import com.yrdce.ipo.modules.warehouse.service.IpoStorageService;
import com.yrdce.ipo.modules.warehouse.service.IpoWarehouseStockService;
import com.yrdce.ipo.modules.warehouse.vo.IpoStorageVo;
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
	public static Map statusMap = new HashMap();

	static {
		statusMap.put("0", "初始化完成");
		statusMap.put("1", "闭市状态");
		statusMap.put("2", "结算中");
		statusMap.put("3", "资金结算完成");
		statusMap.put("4", "暂停交易");
		statusMap.put("5", "交易中");
		statusMap.put("6", "节间休息");
		statusMap.put("7", "交易结束");
		statusMap.put("8", "集合竞价交易中");
		statusMap.put("9", "集合竞价交易结束");
		statusMap.put("10", "交易结算完成");

		statusMap.put("05", "暂停交易");
		statusMap.put("06", "恢复交易");
		statusMap.put("07", "闭市操作");
		statusMap.put("08", "开市准备");
		statusMap.put("09", "交易结束");
	}

	public static final int SYS_LOG_CATALOGID = 4001;
	public static final int SYS_LOG_OPE_SUCC = 1;
	public static final int SYS_LOG_OPE_FAILURE = 0;

	private static Logger log = org.slf4j.LoggerFactory
			.getLogger(DeliveryController.class);
	@Autowired
	private SystemService systemService;
	private ExecutorService executorService = Executors
			.newCachedThreadPool(new ThreadFactoryBuilder()
					.setNameFormat("writeOperateLog-%d").setDaemon(true)
					.build());

	@Autowired
	private IpoCommConfService ipoCommConfService;

	@Autowired
	private DeliveryOrderService deliveryorderservice;

	@Autowired
	private IpoStorageService ipoStorageService;

	@Autowired
	private OutboundService outboundService;

	@Autowired
	private DeliveryCommodityService deliveryCommService;

	@Autowired
	private IpoWarehouseStockService warehouseStockService;

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

	public IpoCommConfService getIpoCommConfService() {
		return ipoCommConfService;
	}

	public void setIpoCommConfService(IpoCommConfService ipoCommConfService) {
		this.ipoCommConfService = ipoCommConfService;
	}

	public void setDeliveryCommService(
			DeliveryCommodityService deliveryCommService) {
		this.deliveryCommService = deliveryCommService;
	}

	public IpoWarehouseStockService getWarehouseStockService() {
		return warehouseStockService;
	}

	public void setWarehouseStockService(
			IpoWarehouseStockService warehouseStockService) {
		this.warehouseStockService = warehouseStockService;
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
	 * 获取某仓库具有交收属性的商品
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getDeliveryCommodity", method = RequestMethod.POST)
	@ResponseBody
	public String getDeliveryCommodity(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		log.info("获取具有交收属性的商品");
		List<VIpoCommConf> commlist = ipoCommConfService
				.selectCommodityByWarehouse(this.getloginUserId(request));
		return JSON.json(commlist);
	}

	/**
	 * 新增入库单
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */

	@RequestMapping(value = "/saveStorage", method = RequestMethod.POST)
	@ResponseBody
	public String saveStorage(IpoStorageVo storage, HttpSession session)
			throws IOException {
		log.info("增加入库单");
		String inserter = ((UserManageVO) session.getAttribute("CurrentUser"))
				.getUserID();
		storage.setOperatorid(inserter);
		storage.setWarehouseid(ipoStorageService.getWarehousePrimary(inserter));
		int num = ipoStorageService.insert(storage);
		if (num != 0) {
			return "true";
		}
		return "false";
	}

	/**
	 * 审核入库单
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/approveStorages", method = RequestMethod.GET)
	public String approveStorages(@RequestParam("storageId") String storageId,
			@RequestParam("flag") String flag, HttpSession session)
			throws IOException {
		log.info("审核入库单");
		String userId = ((UserManageVO) session.getAttribute("CurrentUser"))
				.getUserID();
		// String userId = "111";
		flag = "warehouse" + flag;
		ipoStorageService.checkStorage(storageId, flag, userId);
		return "app/storage/storageApprove";
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
		log.debug(stock.toString());
		try {

			String userId = ((UserManageVO) session.getAttribute("CurrentUser"))
					.getUserID();
			stock.setWarehouseid(ipoStorageService.getWarehousePrimary(userId));
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

	/**
	 * 分页返回配送提货单列表（模糊查询）
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
			record.setDeliveryMethod("在线配送");
			record.setApprovalStatus(DeliveryConstant.StatusType.MARKETPASS
					.getCode());
			List<DeliveryOrder> dlist = deliveryorderservice
					.queryAllDeliOrdersByPage(page, rows, record);
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
	 * 设置配送费用
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/setExpressFee", method = RequestMethod.GET)
	public String setExpressFee(
			@RequestParam("deliveryorderId") String deliveryorderId,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		log.info("跳转到设置费用视图");
		try {
			DeliveryOrder record = deliveryorderservice
					.getDeliveryOrderByDeliOrderID(deliveryorderId);
			if (record != null) {
				log.debug(record.toString());
				String deliveryDate = formatDate(record.getDeliveryDate());
				String applyDate = formatDate(record.getApplyDate());
				String approveDate = formatDate(record.getApproveDate());
				// String cancelDate = formatDate(record.getCancelDate());
				request.setAttribute("deliveryDate", deliveryDate);
				request.setAttribute("applyDate", applyDate);
				request.setAttribute("approveDate", approveDate);
				// request.setAttribute("cancelDate", cancelDate);
				request.setAttribute("entity", record);
				Express express = deliveryorderservice.getExpressDetail(record
						.getMethodId());
				log.debug(express.toString());
				request.setAttribute("detail", express);
			}
			return "app/expressFeeSet/detail";
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	public String formatDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	/**
	 * 设置费用(配送)
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkEorders", method = RequestMethod.POST)
	@ResponseBody
	public String checkEorders(DeliveryOrder deorder, Express detail)
			throws IOException {
		log.info("设置配送费用");
		try {
			log.debug(detail.getCost().toString());
			deorder.setApprovalStatus(DeliveryConstant.StatusType.EXPRESSCOSTSET
					.getCode());
			return deliveryorderservice.setExpressFee(deorder, detail);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	private String getloginUserId(HttpServletRequest request) {
		UserManageVO user = (UserManageVO) request.getSession().getAttribute(
				"CurrentUser");
		if (user != null) {
			return user.getUserID();
		}
		return "nologin";
	}
}
