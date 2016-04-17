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

public class CommodityHqServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private FirmAuthorityService firmAuthorityService;

	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String firmid = request.getParameter("firmid");
		if (firmid == "" || firmid == null) {
			new RuntimeException("客户端登录名为空");
			response.getWriter().print(4);
		} else {
			List<String> commodityid = firmAuthorityService.findCommodity(firmid);
			response.getWriter().print(commodityid);
		}
	}

}
