package com.yrdce.ipo.modules.sys.web;

import gnnt.MEBS.logonService.vo.UserManageVO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.modules.sys.service.ChargeItemService;
import com.yrdce.ipo.modules.sys.service.ChargeRoleService;
import com.yrdce.ipo.modules.sys.util.WriteLog;
import com.yrdce.ipo.modules.sys.vo.ChargeRole;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

/**
 * 一般费用 配置
 * 
 * @author wq 2016-1-3
 *
 */
@Controller
@RequestMapping("/chargeRoleController")
public class ChargeRoleController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ChargeRoleService chargeRoleService;
	@Autowired
	private ChargeItemService chargeItemService;

	/**
	 * 查询一般费用
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query")
	@ResponseBody
	public String query(@RequestParam("page") String pageNo,
			@RequestParam("rows") String pageSize, HttpServletRequest request)
			throws Exception {

		ChargeRole chargeRole = new ChargeRole();
		String chargeName = request.getParameter("chargeName");
		if (chargeName != null && !chargeName.equals("")) {
			chargeRole.setChargeName(chargeName);
		}
		;
		long count = chargeRoleService.queryForCount(chargeRole);
		List<ChargeRole> dataList = new ArrayList<ChargeRole>();
		if (count > 0) {
			dataList = chargeRoleService.queryForPage(pageNo, pageSize,
					chargeRole);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal(new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}

	/**
	 * 跳转到添加一般费用配置界面
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request, Model model) throws Exception {

		// 业务
		model.addAttribute("businessList", ChargeConstant.BusinessType.values());
		// 角色
		model.addAttribute("roleList", ChargeConstant.RoleType.values());
		// 费用
		model.addAttribute("leafChargeList",
				chargeItemService.queryLeafForList());
		// 费用模式
		model.addAttribute("patternList", ChargeConstant.Pattern.values());

		return "app/chargerole/add";
	}

	/**
	 * 保存一般费用配置
	 * 
	 * @param request
	 * @param chargeRole
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(HttpServletRequest request, ChargeRole chargeRole)
			throws Exception {
		try {

			long count = chargeRoleService.queryForCount(chargeRole);
			if (count > 0) {
				return "001";
			}
			chargeRole.setCreateUser(getloginUserId(request));
			chargeRoleService.save(chargeRole);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_ChargeRole_CATALOGID,
					"IPO保存一般费用配置信息成功", WriteLog.SYS_LOG_OPE_SUCC, "",
					request.getSession());
		} catch (Exception e) {
			logger.error("save error:" + e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_ChargeRole_CATALOGID,
					"IPO保存一般费用配置信息失败", WriteLog.SYS_LOG_OPE_FAILURE, "",
					request.getSession());
			return "error";
		}
		return "success";
	}

	/**
	 * 跳转到修改界面
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request, Model model)
			throws Exception {
		Long id = Long.parseLong(request.getParameter("id"));
		// 业务
		model.addAttribute("businessList", ChargeConstant.BusinessType.values());
		// 角色
		model.addAttribute("roleList", ChargeConstant.RoleType.values());
		// 费用
		model.addAttribute("leafChargeList",
				chargeItemService.queryLeafForList());
		// 费用模式
		model.addAttribute("patternList", ChargeConstant.Pattern.values());
		// db
		model.addAttribute("entity", chargeRoleService.findById(id));

		return "app/chargerole/edit";
	}

	/**
	 * 更新一般费用配置
	 * 
	 * @param request
	 * @param chargeRole
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public boolean update(HttpServletRequest request, ChargeRole chargeRole)
			throws Exception {
		try {
			chargeRole.setUpdateUser(getloginUserId(request));
			chargeRoleService.update(chargeRole);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_ChargeRole_CATALOGID,
					"IPO更新一般费用配置信息成功", WriteLog.SYS_LOG_OPE_SUCC, "",
					request.getSession());
		} catch (Exception e) {
			logger.error("update error:" + e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_ChargeRole_CATALOGID,
					"IPO更新一般费用配置信息失败", WriteLog.SYS_LOG_OPE_FAILURE, "",
					request.getSession());
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
