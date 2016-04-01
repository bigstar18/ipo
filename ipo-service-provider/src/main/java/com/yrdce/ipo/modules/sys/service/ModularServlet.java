package com.yrdce.ipo.modules.sys.service;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

public class ModularServlet extends HttpServlet {

	@Autowired
	private FirmAuthorityServiceImpl firmAuthorityServiceImpl;

	public void init(ServletConfig config) throws ServletException {
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String firmid = request.getParameter("firmid");

		String modulars = firmAuthorityServiceImpl.getFirmAuthority(firmid);
		response.getWriter().print(modulars);
	}

}
