package com.yrdce.ipo.modules.sys.web;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.yrdce.ipo.integrate.Global;

import gnnt.MEBS.common.mgr.model.Menu;
import gnnt.MEBS.common.mgr.model.Right;
import gnnt.MEBS.logonService.vo.UserManageVO;

/**
 * 菜单权限
 * 
 * @author chenj
 *
 */
@Controller
@RequestMapping("MenuController")
public class MenuController {

	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(MenuController.class);

	@RequestMapping(value = "/menuList", method = RequestMethod.GET)
	public String menuList(HttpServletRequest request) {

		String userId = getLoginUserId(request);

		if (userId != null) {
			boolean isSuperAdminRole = (Boolean) request.getSession().getAttribute(Global.ISSUPERADMIN);

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
				Map<Long, Right> rightMap = getRightMap();
				Menu menu = getHaveRightMenu(allMenu, rightMap);
				request.setAttribute(Global.HAVERIGHTMENU, menu);
				menuMap = getMenuMap(menu, menuMap);
			}

			return "frame/leftmenu1";
		} else {
			return "error/500";
		}

	}

	/**
	 * 遍历 menu 将子 menu 添加到 map 中<br/>
	 * key：菜单编号，value 菜单
	 * 
	 * @param menu
	 * @param map
	 * @return
	 */
	private Map<Long, Menu> getMenuMap(Menu menu, Map<Long, Menu> map) {
		if (menu == null)
			return map;
		if (map == null)
			map = new LinkedHashMap<Long, Menu>();
		map.put(menu.getId(), menu);
		if (menu.getChildMenuSet() != null) {
			for (Menu child : menu.getChildMenuSet()) {
				getMenuMap(child, map);
			}
		}
		return map;
	}

	/**
	 * 根据菜单树和权限 获取有权限的菜单集合
	 * 
	 * @param allMenu
	 *            所有菜单
	 * @param rightMap
	 *            权限
	 * @return 有权限的菜单树
	 */
	public Menu getHaveRightMenu(Menu allMenu, Map<Long, Right> rightMap) {
		// 新菜单对象 将有权限的菜单复制到新菜单对象
		Menu newMenu = (Menu) allMenu.clone();

		// 因为是克隆过来的所以 子菜单有内容，清空子菜单;子菜单使用seq排序
		newMenu.setChildMenuSet(new TreeSet<Menu>(new Comparator<Menu>() {
			public int compare(Menu menu1, Menu menu2) {
				if (menu1.getSeq() == menu2.getSeq()) {
					return 0;
				} else if (menu1.getSeq() > menu2.getSeq()) {
					return 1;
				} else {
					return -1;
				}
			}
		}));

		// 源菜单的子菜单集合
		Set<Menu> childMenuSet = allMenu.getChildMenuSet();

		// 新菜单子菜单集合
		Set<Menu> newChildMenuSet = newMenu.getChildMenuSet();

		// 遍历子菜单 查看是否有权限 有权限则添加到新菜单
		for (Menu childMenu : childMenuSet) {
			// 权限中是否包含菜单权限标志
			boolean includeFlag = false;
			for (Long rightID : rightMap.keySet()) {
				if (childMenu.getId().longValue() == rightID.longValue()) {
					includeFlag = true;
					break;
				}
			}
			// 如果有权限
			if (includeFlag) {
				// 新子菜单对象
				Menu newChildMenu = (Menu) childMenu.clone();
				// 递归判断子菜单是否还有子菜单 如果有递归
				if (newChildMenu.getChildMenuSet() != null && newChildMenu.getChildMenuSet().size() > 0) {
					newChildMenu = getHaveRightMenu(newChildMenu, rightMap);
				}
				newChildMenuSet.add(newChildMenu);
			}

		}

		return newMenu;
	}

	private Map<Long, Right> getRightMap() {

		return null;
	}

	private String getLoginUserId(HttpServletRequest request) {
		UserManageVO user = (UserManageVO) request.getSession().getAttribute("CurrentUser");
		if (user != null) {
			return user.getUserID();
		}
		return null;
	}

}
