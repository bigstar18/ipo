package com.yrdce.ipo.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yrdce.ipo.integrate.ActiveUserManager;
import com.yrdce.ipo.modules.sys.service.BrBrokerService;
import com.yrdce.ipo.modules.sys.vo.VBrBroker;

/**
 * 用户
 * 
 * @author wq
 *
 */
@Controller
@RequestMapping("UserController")
public class UserController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private BrBrokerService brBrokerService;

	/**
	 * 登出
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajaxcheck/communications/logout.action", method = RequestMethod.GET)
	public @ResponseBody boolean logout(HttpServletRequest request, HttpServletResponse response,
			Model model) {
		try {
			ActiveUserManager.logoff(request);
			logger.info("ipo mgr logout success !");
		} catch (Exception e) {
			logger.error("ipo mgr logout error !");
			return false;
		}
		return true;
	}

	@RequestMapping(value = "/brokerType", method = RequestMethod.GET)
	public String brokerType(HttpSession session, Model model) {
		//String brokerid = ((UserManageVO) session.getAttribute("CurrentUser")).getUserID();
		String brokerid = "SC";
		VBrBroker broker = brBrokerService.queryBrokerById(brokerid);
		//0：经纪会员 1：发行会员  2：承销会员
		String type = broker.getMembertype().toString();
		model.addAttribute("brokertype", type);
		return "frame/leftmenu";
	}
}
