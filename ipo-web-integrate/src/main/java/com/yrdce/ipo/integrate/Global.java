package com.yrdce.ipo.integrate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import gnnt.MEBS.common.mgr.model.Menu;
import gnnt.MEBS.common.mgr.model.Right;
import gnnt.MEBS.common.mgr.model.StandardModel;
import gnnt.MEBS.common.mgr.model.TradeModule;
import gnnt.MEBS.common.mgr.statictools.Tools;

/**
 * 全局对象 系统启动时加载；包含菜单等信息
 * 
 * @author Administrator
 * 
 */
public class Global implements ServletContextListener {
	/**
	 * session中存放当前用户信息的key值<br>
	 * 通过 request.getSession().getAttribute(Global.CURRENTUSERSTR)获取 <br>
	 * 通过 request.getSession().setAttribute(Global.CURRENTUSERSTR)设置 <br>
	 */
	public final static String CURRENTUSERSTR = "CurrentUser";

	/**
	 * 转到登录界面原因变量<br>
	 * 通过 request.getParameter(Global.TOLOGINURLREASON)获取
	 */
	public final static String TOLOGINURLREASON = "reason";

	/**
	 * 存放sessionID 变量<br>
	 * 通过 request.getParameter(Global.SESSIONID)获取
	 */
	public final static String SESSIONID = "sessionID";

	/**
	 * 存放是否超级管理员 变量<br>
	 * 通过 request.getAttribute(Global.ISSUPERADMIN)获取 <br>
	 * 通过 request.setAttribute(Global.ISSUPERADMIN)设置 <br>
	 */
	public final static String ISSUPERADMIN = "IsSuperAdmin";

	/**
	 * 存放返回结果 变量<br>
	 * 通过 request.getSession().getAttribute(Global.RESULTMSG)获取 <br>
	 * 通过 request.getSession().setAttribute(Global.RESULTMSG)设置 <br>
	 */
	public final static String RETURNVALUE = "ReturnValue";

	/**
	 * 存放FromModuleID 变量<br>
	 * 通过 request.getParameter(Global.FROMAUID)获取
	 */
	public final static String FROMMODULEID = "FromModuleID";

	/**
	 * 存放fromLogonType 变量(来源登录类型)<br>
	 * 通过 request.getParameter(Global.FROMLOGONTYPE)获取
	 */
	public final static String FROMLOGONTYPE = "FromLogonType";

	/**
	 * 存放LogonType 变量<br>
	 * 通过 request.getParameter(Global.SELFLOGONTYPE)获取
	 */
	public final static String SELFLOGONTYPE = "LogonType";

	/**
	 * 存放 ModuleID 变量<br/>
	 * 通过 request.getParameter(Global.SELFMODULEID)获取
	 */
	public final static String SELFMODULEID = "ModuleID";

	/**
	 * 用户登录ID<br>
	 * 通过 request.getSession().getAttribute(Global.USERID)获取 <br>
	 * 通过 request.getSession().setAttribute(Global.USERID)设置 <br>
	 */
	public final static String USERID = "userID";

	/**
	 * 公用系统模块编号
	 */
	public static int COMMONMODULEID = 99;

	/**
	 * 主菜单编号
	 */
	public static long ROOTRIGHTID = 9900000000L;

	/**
	 * 存放本系統模块
	 */
	public static Integer selfModuleID;

	/**
	 * 存放本系統配置的登录类型
	 */
	public static String selfLogonType;

	/**
	 * 存放有权限菜单 变量<br>
	 * 通过 request.getAttribute(Global.HaveRightMenu)获取 <br>
	 * 通过 request.setAttribute(Global.HaveRightMenu)设置 <br>
	 */
	public final static String HAVERIGHTMENU = "HaveRightMenu";

	/**
	 * 存放当前项目加载菜单模块编号集合
	 */
	private static List<Integer> moduleIDArray;

	/**
	 * 存放系统模块与Context名称的Map集合
	 */
	public static Map<Integer, Map<Object, Object>> modelContextMap;

	/**
	 * 主菜单对象
	 */
	private static Menu rootMenu;

	/**
	 * 权限树
	 */
	private static Right rightTree;

	/**
	 * 市场信息C_marketInfo
	 */
	private static Map<String, String> marketInfoMap;

	QueryDao queryDao;

	public void contextDestroyed(ServletContextEvent arg0) {

	}

	@SuppressWarnings("unchecked")
	public void contextInitialized(ServletContextEvent arg0) {
		// 获取市场信息
		List<Map<String, Object>> listMap = queryDao.getMarketInfosBySql();
		marketInfoMap = new LinkedHashMap<String, String>();
		if (listMap != null && listMap.size() > 0) {
			for (Map<String, Object> map : listMap) {
				marketInfoMap.put((String) map.get("INFONAME"), (String) map.get("INFOVALUE"));
			}
		}

		// 获取模块编号和Context名称对应的Map集合
		modelContextMap = getContextMap();
		// 通过模块编号集合获取菜单
		rootMenu = getMenuById();
	}

	/**
	 * 获取根菜单
	 */
	public Menu getMenuById() {
		List<Menu> list = queryDao.getMenuById(ROOTRIGHTID, -1, 0, 0, getModuleIDList());
		if (list == null || list.size() < 1)
			return null;

		setChileMenu(list);
		Menu rootMenu = list.get(0);

		// 将根菜单的子菜单按照模块号的顺序进行排序
		if (modelContextMap != null && modelContextMap.size() > 0) {
			// 重新定义新的子菜单集合
			Set<Menu> childMenuSet = new LinkedHashSet<Menu>();
			// 遍历配置的模块编号
			for (Integer moduleId : modelContextMap.keySet()) {
				// 遍历查询出来的子菜单信息
				for (Menu menu : rootMenu.getChildMenuSet()) {
					// 如果两个模块号相等则将菜单加入新定义的子菜单集合
					if (moduleId != null && moduleId.equals(menu.getModuleId())) {
						childMenuSet.add(menu);
					}
				}
			}
			rootMenu.setChildMenuSet(childMenuSet);
		}

		return rootMenu;
	}

	private void setChileMenu(List<Menu> list) {
		for (Menu menu : list) {
			// List tmp = new ArrayList();
			// tmp.add(menu.getModuleId());
			List<Menu> tmpList = queryDao.getMenuByParentId(menu.getId(), -1, 0, 0, moduleIDArray);
			if (tmpList == null || tmpList.size() < 1)
				break;

			setChileMenu(tmpList);

			Set<Menu> childMenuSet = new HashSet<Menu>();
			childMenuSet.addAll(tmpList);
			menu.setChildMenuSet(childMenuSet);
		}
	}

	/**
	 * 获取Spring配置文件中配置的需要加载菜单的模块编号集合，两个模块号之间以英文逗号分隔
	 * 
	 * @return List<Integer>
	 */
	public static List<Integer> getModuleIDList() {
		if (moduleIDArray == null) {
			synchronized (Global.class) {
				if (moduleIDArray == null) {
					moduleIDArray = new ArrayList<Integer>();
					moduleIDArray.add(COMMONMODULEID);
					int module = getSelfModuleID();// 获取配置文件中配置的本系统模块号
					if (module != COMMONMODULEID) {// 如果本系统不是公用系统，则只加载自己的菜单
						moduleIDArray.add(module);
					} else {// 如果是公用系统，则加载所有客家在模块菜单
						if (modelContextMap != null) {
							for (Integer moduleId : modelContextMap.keySet()) {
								moduleIDArray.add(moduleId);
							}
						}
					}
				}
			}
		}
		return moduleIDArray;
	}

	/**
	 * 获取模块类型和context名称的map集合
	 * 
	 * @param menuService
	 * @return
	 */
	private Map<Integer, Map<Object, Object>> getContextMap() {

		// 返回信息
		Map<Integer, Map<Object, Object>> result = new LinkedHashMap<Integer, Map<Object, Object>>();

		// 从数据库c_deploy_config表中获取系统配置信息
		Map<Integer, Map<Object, Object>> springTradeModuleMap = new LinkedHashMap<Integer, Map<Object, Object>>();
		try {
			List<Map<String, Object>> listMap = queryDao.getConfigListBySql();
			for (Map<String, Object> map : listMap) {
				Map<Object, Object> mapClone = new HashMap<Object, Object>();
				for (Object key : map.keySet()) {
					mapClone.put(key, map.get(key));
				}
				springTradeModuleMap.put(Tools.strToInt((BigDecimal) (mapClone.get("MODULEID")) + ""), mapClone);
			}
		} catch (Exception e) {
		}
		if (springTradeModuleMap != null && springTradeModuleMap.size() > 0) {
			// 查询系统中部署了哪几个系统
			List<StandardModel> list = queryDao.getTradeModulesBySql();
			if (list != null) {
				for (Integer moduleID : springTradeModuleMap.keySet()) {// 外层循环配置文件中的配置，以使得页面展示按钮时有顺序性
					for (StandardModel model : list) {
						TradeModule tm = (TradeModule) model;
						if (moduleID != null && moduleID.equals(tm.getModuleId())) {
							Map<Object, Object> value = springTradeModuleMap.get(moduleID);
							/*
							 * 由于 Spring 配置文件中配置的多个地方引用同一个ID号时，
							 * 认为本ID号所引用的实体对象是同一个实体对象，操作的是同一块内存。
							 * 所以：如果配置文件中错误的将两个 moduleID 配置成一个 Map 对象 则两个
							 * moduleID 中保存的模块信息完全相同，导致页面上展示的信息也是完全相同的。
							 */
							if (value != null) {
								value.put("enName", tm.getEnName());
								value.put("isFirmSet", tm.getIsFirmSet());
								value.put("cnName", tm.getCnName());
								value.put("shortName", tm.getShortName());
								value.put("ISNEEDBREED", tm.getIsNeedBreed());
							}
							result.put(moduleID, value);
							break;
						}
					}
				}
			}
		}
		return result;
	}

	/**
	 * 本系统模块编号
	 * 
	 * @return
	 */
	public static int getSelfModuleID() {
		if (selfModuleID == null) {
			return 40;
		}
		return selfModuleID;
	}

	/**
	 * 登录类型
	 * 
	 * @return
	 */
	public static String getSelfLogonType() {
		if (selfLogonType == null || selfLogonType.trim().length() <= 0) {
			selfLogonType = "web";
		}
		return selfLogonType;
	}

	/**
	 * 获取主菜单对象
	 * 
	 * @return
	 */
	public static Menu getRootMenu() {
		return rootMenu;
	}

	/**
	 * 权限树
	 * 
	 * @return
	 */
	public static Right getRightTree() {
		return rightTree;
	}

	/**
	 * 获取市场信息
	 * 
	 * @return
	 */
	public static Map<String, String> getMarketInfoMap() {
		return marketInfoMap;
	}

}
