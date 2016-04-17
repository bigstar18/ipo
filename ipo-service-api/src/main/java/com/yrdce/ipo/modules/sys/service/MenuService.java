package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import gnnt.MEBS.common.mgr.model.Menu;

public interface MenuService {

	public List<Menu> getMenuBySubFilter(int paramInt1, int paramInt2, int paramInt3);

	public List<Menu> getMenuByFilter(int paramInt1, int paramInt2, int paramInt3);

	public Menu getMenuById(long paramLong, List<Integer> paramList);

	//public Menu getHaveRightMenu(Menu paramMenu, Map<Long, Right> paramMap);

}
