package com.yrdce.ipo.modules.sys.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ModularServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String firmid = request.getParameter("firmid");
		System.out.println(firmid);
		FirmAuthorityServiceImpl firmAuthorityServiceImpl = new FirmAuthorityServiceImpl();
		String modulars = firmAuthorityServiceImpl.getFirmAuthority(firmid);
		response.getWriter().print(modulars);
	}

}
