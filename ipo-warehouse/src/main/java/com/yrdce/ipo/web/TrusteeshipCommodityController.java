package com.yrdce.ipo.web;

import gnnt.MEBS.logonService.vo.UserManageVO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.esotericsoftware.minlog.Log;
import com.yrdce.ipo.modules.sys.service.BiWarehouseService;
import com.yrdce.ipo.modules.sys.service.SystemService;
import com.yrdce.ipo.modules.sys.service.TrusteeshipCommodityService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.Trusteeship;
import com.yrdce.ipo.util.WriteLog;

/**
 * 托管审核
 * 
 * @author chenjing
 *
 */
@Controller
@RequestMapping("/trusteeshipCommodityController")
public class TrusteeshipCommodityController {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TrusteeshipCommodityService trusteeshipCommodityService;

	@Autowired
	private BiWarehouseService biWarehouseService;

	@Autowired
	private SystemService systemService;

	/**
	 * 跳转到初审界面
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/query")
	public String query(HttpServletRequest request, Model model) {
		return "app/trusteeship/query";
	}

	/**
	 * 跳转到初审界面
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/apply")
	public String apply(HttpServletRequest request, Model model) {
		return "app/trusteeship/apply";
	}

	/**
	 * 跳转到终审界面
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/lastApply")
	public String lastApply(HttpServletRequest request, Model model) {
		return "app/trusteeship/lastApply";
	}

	/**
	 * 查询商户的申请记录
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryApply")
	@ResponseBody
	public String queryApply(@RequestParam("page") String pageNo,
			@RequestParam("rows") String pageSize, HttpServletRequest request)
			throws Exception {
		Log.info("查询托管申请");
		Trusteeship ship = new Trusteeship();
		ship.setCommodityId(request.getParameter("commodityId"));
		ship.setCommodityName(request.getParameter("commodityName"));
		if (request.getParameter("state") != null) {
			ship.setState(Integer.parseInt(request.getParameter("state")));
		}
		// String warehouseUserId = "001";
		String warehouseUserId = getloginUserId(request);
		ship.setWarehouseId(biWarehouseService
				.getWarehousePrimary(biWarehouseService
						.getWarehouseId(warehouseUserId)));
		ship.setBeginCreateDate(request.getParameter("beginCreateDate"));
		ship.setEndCreateDate(request.getParameter("endCreateDate"));
		ship.setBeginAuditingDate(request.getParameter("beginAuditingDate"));
		ship.setEndAuditingDate(request.getParameter("endAuditingDate"));
		ship.setCreateUser(request.getParameter("createUser"));
		long count = trusteeshipCommodityService.queryApplyForCount(ship);
		List<Trusteeship> dataList = new ArrayList<Trusteeship>();
		if (count > 0) {
			dataList = trusteeshipCommodityService.queryApplyForPage(pageNo,
					pageSize, ship);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal(new Long(count).intValue());
		result.setRows(dataList);
		logger.debug(JSON.json(result));
		return JSON.json(result);
	}

	/**
	 * 仓库初审审核通过
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/warehouseFirstAuditPass")
	@ResponseBody
	public boolean warehouseFirstAuditPass(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Trusteeship ship = new Trusteeship();
			ship.setId(Long.valueOf(request.getParameter("id")));
			ship.setUpdateUser(getloginUserId(request));
			trusteeshipCommodityService.warehouseFirstAuditPass(ship);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
					"IPO出库审核: 托管申请单号" + request.getParameter("id") + "初审成功",
					WriteLog.SYS_LOG_OPE_SUCC, "", request.getSession(),
					systemService);
		} catch (Exception e) {
			logger.error("warehouseFirstAuditPass error:" + e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
					"IPO出库审核: 托管申请单号" + request.getParameter("id") + "初审失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", request.getSession(),
					systemService);
			return false;
		}
		return true;
	}

	/**
	 * 仓库初审审核不通过
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/warehouseFirstAuditNoPass")
	@ResponseBody
	public boolean warehouseFirstAuditNoPass(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Trusteeship ship = new Trusteeship();
			ship.setId(Long.valueOf(request.getParameter("id")));
			ship.setUpdateUser(getloginUserId(request));
			trusteeshipCommodityService.warehouseFirstAuditNoPass(ship);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
					"IPO出库审核: 托管申请单号" + request.getParameter("id") + "初审成功",
					WriteLog.SYS_LOG_OPE_SUCC, "", request.getSession(),
					systemService);
		} catch (Exception e) {
			logger.error("warehouseFirstAuditNoPass error:" + e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
					"IPO出库审核: 托管申请单号" + request.getParameter("id") + "初审失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", request.getSession(),
					systemService);
			return false;
		}
		return true;
	}

	/**
	 * 仓库终审审核通过
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/warehouseLastAuditPass")
	@ResponseBody
	public boolean warehouseLastAuditPass(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Trusteeship ship = new Trusteeship();
			ship.setId(Long.valueOf(request.getParameter("id")));
			ship.setUpdateUser(getloginUserId(request));
			trusteeshipCommodityService.warehouseLastAuditPass(ship);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
					"IPO出库审核: 托管申请单号" + request.getParameter("id") + "终审成功",
					WriteLog.SYS_LOG_OPE_SUCC, "", request.getSession(),
					systemService);
		} catch (Exception e) {
			logger.error("warehouseLastAuditPass error:" + e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
					"IPO出库审核: 托管申请单号" + request.getParameter("id") + "终审失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", request.getSession(),
					systemService);
			return false;
		}
		return true;
	}

	/**
	 * 仓库终审审核不通过
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/warehouseLastAuditNoPass")
	@ResponseBody
	public boolean warehouseLastAuditNoPass(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			Trusteeship ship = new Trusteeship();
			ship.setId(Long.valueOf(request.getParameter("id")));
			ship.setUpdateUser(getloginUserId(request));
			trusteeshipCommodityService.warehouseLastAuditNoPass(ship);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
					"IPO出库审核: 托管申请单号" + request.getParameter("id") + "终审成功",
					WriteLog.SYS_LOG_OPE_SUCC, "", request.getSession(),
					systemService);
		} catch (Exception e) {
			logger.error("warehouseLastAuditNoPass error:" + e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_OUTBOUND_CATALOGID,
					"IPO出库审核: 托管申请单号" + request.getParameter("id") + "终审失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", request.getSession(),
					systemService);
			return false;
		}
		return true;
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
