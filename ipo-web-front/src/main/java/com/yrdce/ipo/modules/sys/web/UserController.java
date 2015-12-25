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

import gnnt.MEBS.logonService.vo.UserManageVO;

/**
 * 用户
 * 
 * @author wq
 *
 */
@Controller
public class UserController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	// http://10.0.100.182:10062/finance_front/checkneedless/communications/sessionGetUser.action
	// ?jsoncallback=?&sessionID=6310557391051071641&userID=222222&FromModuleID=10&FromLogonType=web&LogonType=web
	/**
	 * 没啥用途
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/checkneedless/communications/sessionGetUser.action", method = RequestMethod.GET)
	public @ResponseBody String sessionGetUser(HttpServletRequest request, HttpServletResponse response, Model model) {
		UserManageVO user = (UserManageVO) request.getSession().getAttribute("CurrentUser");
		String callback = request.getParameter("jsoncallback");

		if (user == null) {
			logger.error("用户信息为空，并且未重新加载");
			return result(callback, "[false]");
		}

		return result(callback, "[true]");
	}

	// ?([true])
	private String result(String callback, String jsonValidateReturn) {
		if ((callback != null) && (callback.length() > 0)) {
			StringBuffer sb = new StringBuffer(callback);
			sb.append("(");
			sb.append(jsonValidateReturn);
			sb.append(")");

			return sb.toString();
		}
		return "success";
	}

	/**
	 * 登出
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/checkneedless/communications/logout.action", method = RequestMethod.GET)
	public @ResponseBody boolean logout(HttpServletRequest request, HttpServletResponse response, Model model) {
		try {
			ActiveUserManager.logoff(request);
			logger.info("ipo front logout success !");
		} catch (Exception e) {
			logger.error("ipo front logout error !");
			return false;
		}
		return true;
	}

}
