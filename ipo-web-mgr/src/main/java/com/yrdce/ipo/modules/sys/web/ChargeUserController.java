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
import com.yrdce.ipo.modules.sys.service.ChargeUserService;
import com.yrdce.ipo.modules.sys.util.WriteLog;
import com.yrdce.ipo.modules.sys.vo.ChargeUser;
import com.yrdce.ipo.modules.sys.vo.DataItem;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

/**
 * 特殊费用 配置
 * 
 * @author wq 2016-1-3
 *
 */
@Controller
@RequestMapping("/chargeUserController")
public class ChargeUserController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private ChargeUserService chargeUserService;
	@Autowired
	private ChargeItemService chargeItemService;

	/**
	 * 查询
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

		ChargeUser chargeUser = new ChargeUser();
		String chargeName = request.getParameter("chargeName");
		if (chargeName != null && !chargeName.equals("")) {
			chargeUser.setChargeName(chargeName);
		}
		;
		long count = chargeUserService.queryForCount(chargeUser);
		List<ChargeUser> dataList = new ArrayList<ChargeUser>();
		if (count > 0) {
			dataList = chargeUserService.queryForPage(pageNo, pageSize,
					chargeUser);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal(new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}

	/**
	 * 跳转到添加特殊费用配置界面
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request, Model model) throws Exception {
		DataItem dataItem = new DataItem();
		dataItem.setType(ChargeConstant.BUSINESS);
		// 业务
		model.addAttribute("businessList", ChargeConstant.BusinessType.values());
		// 角色
		model.addAttribute("roleList", ChargeConstant.RoleType.values());
		// 费用
		model.addAttribute("leafChargeList",
				chargeItemService.queryLeafForList());
		// 费用模式
		model.addAttribute("patternList", ChargeConstant.Pattern.values());

		return "app/chargeuser/add";
	}

	/**
	 * 保存特殊费用配置
	 * 
	 * @param request
	 * @param chargeUser
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(HttpServletRequest request, ChargeUser chargeUser)
			throws Exception {
		try {
			long count = chargeUserService.queryForCount(chargeUser);
			if (count > 0) {
				return "001";
			}
			chargeUser.setCreateUser(getloginUserId(request));
			chargeUserService.save(chargeUser);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_ChargeUser_CATALOGID,
					"ipo保存特殊费用配置成功", WriteLog.SYS_LOG_OPE_SUCC, "",
					request.getSession());
		} catch (Exception e) {
			logger.error("save error:" + e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_ChargeUser_CATALOGID,
					"ipo保存特殊费用配置失败", WriteLog.SYS_LOG_OPE_FAILURE, "",
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
		DataItem dataItem = new DataItem();
		dataItem.setType(ChargeConstant.BUSINESS);
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
		model.addAttribute("entity", chargeUserService.findById(id));

		return "app/chargeuser/edit";
	}

	/**
	 * 更新特殊费用配置
	 * 
	 * @param request
	 * @param chargeUser
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public boolean update(HttpServletRequest request, ChargeUser chargeUser)
			throws Exception {
		try {
			chargeUser.setUpdateUser(getloginUserId(request));
			chargeUserService.update(chargeUser);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_ChargeUser_CATALOGID,
					"ipo更新特殊费用配置成功", WriteLog.SYS_LOG_OPE_SUCC, "",
					request.getSession());
		} catch (Exception e) {
			logger.error("update error:" + e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_ChargeUser_CATALOGID,
					"ipo更新特殊费用配置失败", WriteLog.SYS_LOG_OPE_FAILURE, "",
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
