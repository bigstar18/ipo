package com.yrdce.ipo.modules.sys.service;

import gnnt.MEBS.common.mgr.model.Menu;
import gnnt.MEBS.common.mgr.model.Right;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.common.dao.CRightMapper;

@Service("menuService")
public class MenuServiceImpl implements MenuService {
	@Autowired
	private CRightMapper menuDao;

	@Override
	public List<Menu> getMenuByFilter(int paramInt1, int paramInt2,
			int paramInt3) {
		return menuDao.getMenuByFilter(paramInt1, paramInt2, paramInt3);
	}

	@Override
	public Menu getMenuById(long paramLong, List<Integer> paramList) {
		List<Menu> localList = menuDao.getMenuById(paramLong, -1, 0, 0,
				paramList);
		if (localList.size() > 0) {
			return (Menu) localList.get(0);
		}
		return null;
	}

	@Override
	public List<Menu> getMenuBySubFilter(int paramInt1, int paramInt2,
			int paramInt3) {
		return menuDao.getMenuBySubFilter(paramInt1, paramInt2, paramInt3);
	}

	@Override
	public Menu getHaveRightMenu(Menu paramMenu, Map<Long, Right> paramMap) {
		Menu localMenu1 = (Menu) paramMenu.clone();
		localMenu1.setChildMenuSet(new TreeSet(new Comparator() {
			public int compare(Menu paramAnonymousMenu1,
					Menu paramAnonymousMenu2) {
				if (paramAnonymousMenu1.getSeq() == paramAnonymousMenu2
						.getSeq())
					return 0;
				if (paramAnonymousMenu1.getSeq().intValue() > paramAnonymousMenu2
						.getSeq().intValue())
					return 1;
				return -1;
			}

			@Override
			public int compare(Object o1, Object o2) {
				return this.compare((Menu) o1, (Menu) o2);
			}
		}));
		Set localSet1 = paramMenu.getChildMenuSet();
		Set localSet2 = localMenu1.getChildMenuSet();
		Iterator localIterator = localSet1.iterator();
		while (localIterator.hasNext()) {
			Menu localMenu2 = (Menu) localIterator.next();
			int i = 0;
			Object localObject = paramMap.keySet().iterator();
			while (((Iterator) localObject).hasNext()) {
				Long localLong = (Long) ((Iterator) localObject).next();
				if (localMenu2.getId().longValue() == localLong.longValue()) {
					i = 1;
					break;
				}
			}
			if (i != 0) {
				localObject = (Menu) localMenu2.clone();
				if ((((Menu) localObject).getChildMenuSet() != null)
						&& (((Menu) localObject).getChildMenuSet().size() > 0))
					localObject = getHaveRightMenu((Menu) localObject, paramMap);
				localSet2.add(localObject);
			}
		}
		return localMenu1;
	}

}
