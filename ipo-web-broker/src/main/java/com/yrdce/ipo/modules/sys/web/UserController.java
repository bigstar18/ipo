package com.yrdce.ipo.modules.sys.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yrdce.ipo.integrate.ActiveUserManager;

/**
 * 用户
 * 
 * @author wq
 *
 */
@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 登出
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/ajaxcheck/communications/logout.action", method = RequestMethod.GET)
	public @ResponseBody boolean logout(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		try {
			ActiveUserManager.logoff(request);
			logger.info("ipo mgr logout success !");
		} catch (Exception e) {
			logger.error("ipo mgr logout error !");
			return false;
		}
		return true;
	}

}
