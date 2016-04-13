package com.yrdce.ipo.modules.sys.web;

import gnnt.MEBS.common.mgr.action.MenuAction;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 菜单权限
 * 
 * @author chenj
 *
 */
@Controller
@RequestMapping("MenuController")
public class MenuController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/menuList", method = RequestMethod.GET)
	public String menuList(HttpServletRequest request) {
		MenuAction menu = new MenuAction();
		menu.menuList();

		Object menulist = request.getAttribute("myMenuList");
		if (menulist != null) {
			logger.info(menulist.toString());
		} else {
			logger.info("**********************************************");
		}
		return "frame/leftmenu1";
	}

}
