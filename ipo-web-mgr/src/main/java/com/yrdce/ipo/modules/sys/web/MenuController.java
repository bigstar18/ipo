package com.yrdce.ipo.modules.sys.web;

import gnnt.MEBS.common.mgr.common.Global;
import gnnt.MEBS.common.mgr.common.Page;
import gnnt.MEBS.common.mgr.common.PageRequest;
import gnnt.MEBS.common.mgr.model.Menu;
import gnnt.MEBS.common.mgr.model.MyMenu;
import gnnt.MEBS.common.mgr.model.Right;
import gnnt.MEBS.common.mgr.model.StandardModel;
import gnnt.MEBS.common.mgr.model.User;
import gnnt.MEBS.common.mgr.service.StandardService;
import gnnt.MEBS.logonService.vo.UserManageVO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yrdce.ipo.modules.sys.service.MenuService;

/**
 * 菜单权限
 * 
 * @author chenj
 *
 */
@Controller
@RequestMapping("MenuController")
public class MenuController {

	static org.slf4j.Logger logger = org.slf4j.LoggerFactory
			.getLogger(MenuController.class);

	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/menuList", method = RequestMethod.GET)
	public String menuList(HttpServletRequest request) {
		String userId = this.getLoginUserId(request);
		User localUser = (User) request.getSession()
				.getAttribute("CurrentUser");

		if (localUser != null) {
			boolean isSuperAdminRole = false;
			isSuperAdminRole = (Boolean) request.getSession().getAttribute(
					Global.ISSUPERADMIN);

			Menu allMenu = Global.getRootMenu();

			// 保存当前用户有权限的菜单 Map key：菜单编号，value 菜单
			Map<Long, Menu> menuMap = null;
			// 如果是超级管理员则拥有所有菜单
			if (isSuperAdminRole) {
				request.setAttribute(Global.HAVERIGHTMENU, allMenu);
				menuMap = getMenuMap(allMenu, menuMap);
			}
			// 不是超级管理员获取自己有权限的菜单
			else {
				Map<Long, Right> rightMap = localUser.getRightMap();
				Menu menu = menuService.getHaveRightMenu(allMenu, rightMap);
				request.setAttribute(Global.HAVERIGHTMENU, menu);
				menuMap = getMenuMap(menu, menuMap);
			}

			// 当前系统所加载的菜单模块
			List<Integer> moduleIDList = Global.getModuleIDList();
			String filter = " and primary.user.userId='"
					+ localUser.getUserId() + "' ";
			if (moduleIDList != null) {
				String modules = "" + Global.COMMONMODULEID;
				for (Integer moduleID : moduleIDList) {
					if (moduleID != Global.COMMONMODULEID) {
						modules += "," + moduleID;
					}
				}
				filter += " and primary.right.moduleId in (" + modules + ") ";
			}

			// 获取该登录用户下的快捷菜单中菜单ID的集合并存入数组中
			PageRequest<String> pageRequest = new PageRequest<String>(filter);
			StandardService standardService = new StandardService();
			Page<StandardModel> page = standardService.getPage(pageRequest,
					new MyMenu());
			List<MyMenu> myMenuList = new ArrayList<MyMenu>();

			// 遍历查看我的菜单中菜单权限，防止设置我的菜单后，管理员撤销了本用户的权限
			if (page != null && page.getResult() != null && menuMap != null) {
				for (StandardModel standardModel : page.getResult()) {
					MyMenu myMenu = (MyMenu) standardModel;
					if (menuMap.get(myMenu.getRight().getId()) != null) {
						myMenuList.add(myMenu);
					}
				}
			}

			request.setAttribute("myMenuList", page.getResult());
			return "frame/leftmenu1";
		} else {
			return "error/500";
		}

	}

	private Map<Long, Menu> getMenuMap(Menu paramMenu, Map<Long, Menu> paramMap) {
		if (paramMenu == null)
			return paramMap;
		if (paramMap == null)
			paramMap = new LinkedHashMap();
		paramMap.put(paramMenu.getId(), paramMenu);
		if (paramMenu.getChildMenuSet() != null) {
			Iterator localIterator = paramMenu.getChildMenuSet().iterator();
			while (localIterator.hasNext()) {
				Menu localMenu = (Menu) localIterator.next();
				getMenuMap(localMenu, paramMap);
			}
		}
		return paramMap;
	}

	private String getLoginUserId(HttpServletRequest request) {
		UserManageVO user = (UserManageVO) request.getSession().getAttribute(
				"CurrentUser");
		if (user != null) {
			return user.getUserID();
		}
		return "nologin";
	}

}
