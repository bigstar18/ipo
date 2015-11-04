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

import gnnt.MEBS.common.front.model.integrated.User;
import gnnt.MEBS.common.front.statictools.Tools;
import gnnt.MEBS.logonService.vo.CheckUserResultVO;

public class SecurityFilter implements Filter {
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

		String contextPath = request.getContextPath();

		String url = request.getServletPath();

		String loginURL = "/front/public/jsp/nosession.jsp";
		User user = (User) request.getSession().getAttribute("CurrentUser");
		if (user != null) {
			String strSessionId = request.getParameter("sessionID");
			if (strSessionId != null) {
				Long sessionID = Long.valueOf(Tools.strToLong(strSessionId));
				if (!sessionID.equals(user.getSessionId())) {
					synchronized (syncObject) {
						user = (User) request.getSession().getAttribute("CurrentUser");
						if ((user != null) && (!sessionID.equals(user.getSessionId()))) {
							user = null;
							request.getSession().invalidate();
						}
					}
				}
			}
		}
		CheckUserResultVO au = null;
		if (user == null) {
			synchronized (syncObject) {
				long sessionID = Tools.strToLong(request.getParameter("sessionID"), -1L);
				int fromModuleID = Tools.strToInt(request.getParameter("FromModuleID"), -1);
				String userID = request.getParameter("userID");
				if ((sessionID > 0L) && (fromModuleID > 0)) {
					String fromLogonType = request.getParameter("FromLogonType");
					String selfLogonType = request.getParameter("LogonType");
					if ((selfLogonType == null) || (selfLogonType.trim().length() == 0)) {
						selfLogonType = "web";
					}
					int selfModuleID = Tools.strToInt(request.getParameter("ModuleID"), 40);
					au = ActiveUserManager.checkUser(userID, sessionID, fromModuleID, selfLogonType, fromLogonType, selfModuleID);

				}
			}
		}
		request.setAttribute("currenturl", url);

		String preUrl = (String) request.getSession().getAttribute("currentRealPath");

		if (au != null && au.getUserManageVO() != null) {

			chain.doFilter(req, res);

		} else
			response.sendRedirect(contextPath + loginURL + "?preUrl" + "=" + preUrl);

	}

	public void init(FilterConfig filterConfig) throws ServletException {
	}
}
