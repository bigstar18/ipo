package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.yrdce.ipo.modules.sys.service.FirmAuthorityService;

/**
 * @ClassName: ModularServlet
 * @Description: 客户端请求获取交易客户权限
 * @author bob
 */
public class ModularServlet extends HttpServlet {

	@Autowired
	private FirmAuthorityService firmAuthorityService;

	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String firmid = request.getParameter("firmid");
		if (firmid == "" || firmid == null) {
			new RuntimeException("客户端登陆权限登录名为空");
			response.getWriter().print(4);
		} else {
			List<String> permissions = firmAuthorityService.getFirmAuthority(firmid);
			boolean modual1 = false;
			boolean modual2 = false;
			if (permissions.size() != 0) {
				for (String module : permissions) {
					if ("1".equals(module)) {
						modual1 = true;
					} else if ("2".equals(module)) {
						modual2 = true;
					}
				}

				/**
				 * 0：全部权限 1：邮币卡权限 2：大宗权限 3：无权限 4:用户名空
				 */
				if (modual1 && modual2) {
					response.getWriter().print(0);
				} else if (modual1) {
					response.getWriter().print(1);
				} else if (modual2) {
					response.getWriter().print(2);
				}
			} else {
				response.getWriter().print(3);
			}
		}
	}
}
