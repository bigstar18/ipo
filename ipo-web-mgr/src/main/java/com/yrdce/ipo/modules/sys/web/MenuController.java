package com.yrdce.ipo.modules.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
	/*
		@Autowired
		private MenuService menuService;
	
		@RequestMapping(value = "/menuList", method = RequestMethod.GET)
		public String menuList(HttpServletRequest request) {
			User localUser = (User) request.getSession()
					.getAttribute("CurrentUser");
			if (localUser != null) {
				boolean bool = false;
				bool = ((Boolean) request.getSession().getAttribute("IsSuperAdmin"))
						.booleanValue();
				Menu localMenu = Global.getRootMenu();
				Map localMap = null;
				if (bool) {
					request.setAttribute("HaveRightMenu", localMenu);
					localMap = getMenuMap(localMenu, localMap);
				} else {
					localObject1 = localUser.getRightMap();
					localObject2 = this.menuService.getHaveRightMenu(localMenu,
							(Map) localObject1);
					request.setAttribute("HaveRightMenu", localObject2);
					localMap = getMenuMap((Menu) localObject2, localMap);
				}
				Object localObject1 = Global.getModuleIDList();
				Object localObject2 = " and primary.user.userId='"
						+ localUser.getUserId() + "' ";
				if (localObject1 != null) {
					localObject3 = "" + Global.COMMONMODULEID;
					localObject4 = ((List) localObject1).iterator();
					while (((Iterator) localObject4).hasNext()) {
						localObject5 = (Integer) ((Iterator) localObject4).next();
						if (((Integer) localObject5).intValue() != Global.COMMONMODULEID)
							localObject3 = (String) localObject3 + ","
									+ localObject5;
					}
					localObject2 = (String) localObject2
							+ " and primary.right.moduleId in ("
							+ (String) localObject3 + ") ";
				}
				Object localObject3 = new PageRequest(localObject2);
				Object localObject4 = getService().getPage(
						(PageRequest) localObject3, new MyMenu());
				Object localObject5 = new ArrayList();
				if ((localObject4 != null)
						&& (((Page) localObject4).getResult() != null)
						&& (localMap != null)) {
					Iterator localIterator = ((Page) localObject4).getResult()
							.iterator();
					while (localIterator.hasNext()) {
						StandardModel localStandardModel = (StandardModel) localIterator
								.next();
						MyMenu localMyMenu = (MyMenu) localStandardModel;
						if (localMap.get(localMyMenu.getRight().getId()) != null)
							((List) localObject5).add(localMyMenu);
					}
				}
				request.setAttribute("myMenuList",
						((Page) localObject4).getResult());
				return "success";
			}
			return "error";
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
		*/
}
