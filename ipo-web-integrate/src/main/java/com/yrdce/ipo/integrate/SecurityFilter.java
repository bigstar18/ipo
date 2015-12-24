package com.yrdce.ipo.integrate;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import gnnt.MEBS.checkLogon.util.Tool;
import gnnt.MEBS.logonService.vo.CheckUserResultVO;
import gnnt.MEBS.logonService.vo.UserManageVO;

public class SecurityFilter implements Filter {
	Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());
	private static Object syncObject = new Object();

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if ((request.getHeader("X-Requested-With") != null) && (request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest"))) {
			request.setCharacterEncoding("UTF-8");
		} else {
			request.setCharacterEncoding("GBK");
		}

		String url = request.getServletPath();
		// 不需要验证
		if (url.indexOf("403.jsp") > -1 || url.indexOf("404.jsp") > -1 || url.indexOf("500.jsp") > -1) {
			logger.info("current url : {}", url);
			chain.doFilter(req, res);
			return;
		}

		String loginURL = "/front/error/403.jsp";

		UserManageVO user = (UserManageVO) request.getSession().getAttribute("CurrentUser");
		if (user != null) {
			// TODO 权限检查
		}

		if (user == null) {
			synchronized (syncObject) {
				long sessionID = Tool.strToLong(request.getParameter("sessionID"), -1L);
				int fromModuleID = Tool.strToInt(request.getParameter("FromModuleID"), -1);
				String userID = request.getParameter("userID");
				if ((sessionID > 0L) && (fromModuleID > 0)) {
					String fromLogonType = request.getParameter("FromLogonType");
					String selfLogonType = request.getParameter("LogonType");
					if ((selfLogonType == null) || (selfLogonType.trim().length() == 0)) {
						selfLogonType = "web";
					}
					int selfModuleID = Tool.strToInt(request.getParameter("ModuleID"), 40);// TODO

					String contextPath = request.getContextPath();
					if (contextPath.indexOf("front") < 0) // 非前台
						ActiveUserManager.configId = 199001;
					ActiveUserManager.wac = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
					CheckUserResultVO au = ActiveUserManager.checkUser(userID, sessionID, fromModuleID, selfLogonType, fromLogonType, selfModuleID);
					user = au.getUserManageVO();
					if (user != null)
						request.getSession().setAttribute("CurrentUser", user);
				}
			}
		}

		request.setAttribute("currenturl", url);
		String preUrl = (String) request.getSession().getAttribute("currentRealPath");

		if (user != null) {
			chain.doFilter(req, res);
		} else {
			// response.sendRedirect(loginURL + "?preUrl" + "=" + preUrl);
			// request.getRequestDispatcher(loginURL + "?preUrl" + "=" + preUrl).forward(request, response);
			logger.info("user is null, forward to : {}", loginURL);
			request.getSession().getServletContext().getRequestDispatcher(loginURL + "?preUrl" + "=" + preUrl).forward(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
