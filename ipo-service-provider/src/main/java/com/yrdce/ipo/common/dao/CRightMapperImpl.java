package com.yrdce.ipo.common.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import gnnt.MEBS.common.mgr.model.Menu;

@Component
public class CRightMapperImpl extends JdbcDaoSupport implements CRightMapper {

	@Override
	public Menu selectByPrimaryKey(Long id) {
		Menu menu;
		String sql = " select ID, PARENTID, NAME, ICON, VISITURL, MODULEID, SEQ, VISIBLE,  TYPE  from C_RIGHT  where ID = ?";
		Object[] params = { id };
		try {
			menu = (Menu) this.getJdbcTemplate().queryForObject(sql, params, Menu.class);
		} catch (Exception e) {
			menu = null;
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public List<Menu> selectAll() {
		List<Menu> menuDetails;
		String sql = "select * from C_RIGHT";
		try {
			menuDetails = this.getJdbcTemplate().queryForList(sql, Menu.class);
		} catch (Exception e) {
			menuDetails = null;
			e.printStackTrace();
		}
		return menuDetails;
	}

	@Override
	public List<Menu> getMenuByFilter(int paramInt1, int paramInt2, int paramInt3) {
		List<Menu> menuDetails;
		String sql = "select * from C_RIGHT   where  (TYPE = ? or TYPE = ?) and VISIBLE =? order by MODULEID,SEQ";
		Object[] params = { paramInt1, paramInt2, paramInt3 };
		try {
			menuDetails = this.getJdbcTemplate().queryForList(sql, params, Menu.class);
		} catch (Exception e) {
			menuDetails = null;
			e.printStackTrace();
		}
		return menuDetails;
	}

	@Override
	public List<Menu> getMenuBySubFilter(int paramInt1, int paramInt2, int paramInt3) {
		List<Menu> menuDetails;
		String sql = "select * from C_RIGHT where PARENTID!=-1   and (TYPE = ? or TYPE = ?) and VISIBLE =? order by MODULEID,SEQ";
		Object[] params = { paramInt1, paramInt2, paramInt3 };
		try {
			menuDetails = this.getJdbcTemplate().queryForList(sql, params, Menu.class);
		} catch (Exception e) {
			menuDetails = null;
			e.printStackTrace();
		}
		return menuDetails;
	}

	@Override
	public Menu getMenuById(long paramLong, int paramInt1, int paramInt2, int paramInt3,
			List<Integer> paramList) {
		String sql = "select * from C_RIGHT  where ID = ? and  PARENTID != -1  and (TYPE = ? or TYPE = ?) and VISIBLE =? and MODULEID in(?) order by SEQ";
		Object[] params = { paramLong, paramInt1, paramInt2, paramInt3, paramList };
		try {
			List<Menu> menuDetails = this.getJdbcTemplate().queryForList(sql, params, Menu.class);
			if (menuDetails.size() > 0) {
				return (Menu) menuDetails.get(0);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
