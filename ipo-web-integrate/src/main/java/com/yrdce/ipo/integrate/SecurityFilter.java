package com.yrdce.ipo.integrate;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import gnnt.MEBS.checkLogon.util.Tool;
import gnnt.MEBS.logonServerUtil.au.LogonActualize;
import gnnt.MEBS.logonService.vo.CheckUserResultVO;
import gnnt.MEBS.logonService.vo.UserManageVO;

public class SecurityFilter implements Filter {
	Logger logger = org.slf4j.LoggerFactory.getLogger(getClass());

	private static Object syncObject = new Object();
	WebApplicationContext wac;
	DataSource ds;
	Map<String, Long> auExpireTimeMap = new HashMap<String, Long>();
	// front 223001 ws 499001 mgr 199001
	int configId = 223001;
	int moduleId = 40;
	String sysType = "front";
	QueryDao queryDao;
	Global global;

	public void init(FilterConfig filterConfig) throws ServletException {
		String tmp = filterConfig.getInitParameter("sysType");
		if (tmp != null) {
			sysType = tmp;
		}
		tmp = filterConfig.getInitParameter("configId");
		if (tmp != null) {
			configId = Integer.valueOf(tmp);
		}
		tmp = filterConfig.getInitParameter("moduleId");
		if (tmp != null) {
			moduleId = Integer.valueOf(tmp);
			Global.selfModuleID = moduleId;
		}
		Global.selfLogonType = "web";

		try {
			wac = WebApplicationContextUtils.getWebApplicationContext(filterConfig.getServletContext());
			ds = (DataSource) wac.getBean("dataSourceForQuery");
			auExpireTimeMap.put("web", 7200000l);
			auExpireTimeMap.put("pc", 7200000l);
			auExpireTimeMap.put("mobile", 7200000l);

			queryDao = new QueryDao();
			queryDao.setDataSource(ds);

			ActiveUserManager.queryDao = queryDao;

			global = new Global();
			global.queryDao = queryDao;
			global.contextInitialized(null);

			LogonActualize.createInstance(moduleId, 0, ds, auExpireTimeMap, 200, 3, sysType);
		} catch (Exception e) {
			logger.error("error", e);
		}
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		if ((request.getHeader("X-Requested-With") != null) && (request.getHeader("X-Requested-With").equalsIgnoreCase("XMLHttpRequest"))) {
			request.setCharacterEncoding("UTF-8");
		} else {
			request.setCharacterEncoding("GBK");
		}
		logger.debug("FromModuleID={}, FromLogonType={},LogonType={}", request.getParameter("FromModuleID"), request.getParameter("FromLogonType"),
				request.getParameter("LogonType"));

		String url = request.getServletPath();
		request.setAttribute("currenturl", url);
		// 不需要验证
		if (url.indexOf("403.jsp") > -1 || url.indexOf("404.jsp") > -1 || url.indexOf("500.jsp") > -1) {
			logger.info("current url : {}", url);
			chain.doFilter(req, res);
			return;
		}

		UserManageVO user = (UserManageVO) request.getSession().getAttribute("CurrentUser");
		if (user != null) {
			// TODO 权限检查
			String inSession = request.getParameter("sessionID");
			if (inSession != null && !inSession.isEmpty()) {
				String oldSession = String.valueOf(user.getSessionID());
				if (!inSession.equals(oldSession)) {
					synchronized (syncObject) {
						user = null;
						request.getSession().invalidate();
					}
				}
			}

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
					int selfModuleID = Tool.strToInt(request.getParameter("ModuleID"), moduleId);

					ActiveUserManager.configId = configId;
					ActiveUserManager.ds = ds;
					CheckUserResultVO au = ActiveUserManager.checkUser(userID, sessionID, fromModuleID, selfLogonType, fromLogonType, selfModuleID);
					user = au.getUserManageVO();
					if (user != null) {
						boolean logonSuccess = ActiveUserManager.logon(sysType, userID, request, sessionID, selfLogonType, selfModuleID);
						if (logonSuccess) {
							request.getSession().setAttribute("CurrentUser", user);
							if ("front".equals(sysType)) {
								// 查询 m_trader 表，获得firmid TODO
								String firmId = queryDao.getFirmid(user.getUserID());
								logger.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>firmId:{}", firmId);
								request.getSession().setAttribute("currentFirmId", firmId);
								String firmid = (String) request.getSession().getAttribute("currentFirmId");
								logger.info(">>>>>>>>>>>>>>>>>>>>>>getSession.firmId:{}", firmid);
							}
						}
					}
				}
			}
		}

		if (user != null) {
			chain.doFilter(req, res);
		} else {
			// response.sendRedirect(loginURL + "?preUrl" + "=" + preUrl);
			// request.getRequestDispatcher(loginURL + "?preUrl" + "=" + preUrl).forward(request, response);

			String preUrl = (String) request.getSession().getAttribute("currentRealPath");
			String loginURL = "/" + sysType + "/error/403.jsp";
			logger.info("user is null, forward to : {}", loginURL);

			request.getSession().getServletContext().getRequestDispatcher(loginURL + "?preUrl" + "=" + preUrl).forward(request, response);
		}
	}

	public void destroy() {
	}
}
