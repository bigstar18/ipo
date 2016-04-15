package com.yrdce.ipo.modules.sys.dao;

import gnnt.MEBS.common.mgr.model.Menu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRightMapperImpl extends BaseMapper implements CRightMapper {

	@Override
	public Menu selectByPrimaryKey(Long id) {
		Menu menu = new Menu();
		String sql = " select ID, PARENTID, NAME, ICON, VISITURL, MODULEID, SEQ, VISIBLE,  TYPE  from C_RIGHT  where ID = ?";
		Object[] params = { id };
		ResultSet rs = this.select(sql, params);
		try {
			while (rs.next()) {
				menu.setId(id);
				menu.setParentID(rs.getLong("PARENTID"));
				menu.setName(rs.getString("NAME"));
				menu.setIcon(rs.getString("ICON"));
				menu.setUrl(rs.getString("VISITURL"));
				menu.setModuleId(rs.getInt("MODULEID"));
				menu.setSeq(rs.getInt("SEQ"));
				menu.setVisible(rs.getInt("VISIBLE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menu;
	}

	@Override
	public List<Menu> selectAll() {
		List<Menu> menuDetails = new ArrayList<Menu>();
		String sql = "select * from C_RIGHT";
		Object[] params = {};
		ResultSet rs = this.select(sql, params);

		try {
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getLong("ID"));
				menu.setParentID(rs.getLong("PARENTID"));
				menu.setName(rs.getString("NAME"));
				menu.setIcon(rs.getString("ICON"));
				menu.setUrl(rs.getString("VISITURL"));
				menu.setModuleId(rs.getInt("MODULEID"));
				menu.setSeq(rs.getInt("SEQ"));
				menu.setVisible(rs.getInt("VISIBLE"));
				menuDetails.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
		return menuDetails;

	}

	@Override
	public List<Menu> getMenuByFilter(int paramInt1, int paramInt2,
			int paramInt3) {
		List<Menu> menuDetails = new ArrayList<Menu>();
		String sql = "select * from C_RIGHT   where  (TYPE = ? or TYPE = ?) and VISIBLE =? order by MODULEID,SEQ";
		Object[] params = { paramInt1, paramInt2, paramInt3 };
		ResultSet rs = this.select(sql, params);

		try {
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getLong("ID"));
				menu.setParentID(rs.getLong("PARENTID"));
				menu.setName(rs.getString("NAME"));
				menu.setIcon(rs.getString("ICON"));
				menu.setUrl(rs.getString("VISITURL"));
				menu.setModuleId(rs.getInt("MODULEID"));
				menu.setSeq(rs.getInt("SEQ"));
				menu.setVisible(rs.getInt("VISIBLE"));
				menuDetails.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
		return menuDetails;
	}

	@Override
	public List<Menu> getMenuBySubFilter(int paramInt1, int paramInt2,
			int paramInt3) {
		List<Menu> menuDetails = new ArrayList<Menu>();
		String sql = "select * from C_RIGHT where PARENTID!=-1   and (TYPE = ? or TYPE = ?) and VISIBLE =? order by MODULEID,SEQ";
		Object[] params = { paramInt1, paramInt2, paramInt3 };
		ResultSet rs = this.select(sql, params);

		try {
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getLong("ID"));
				menu.setParentID(rs.getLong("PARENTID"));
				menu.setName(rs.getString("NAME"));
				menu.setIcon(rs.getString("ICON"));
				menu.setUrl(rs.getString("VISITURL"));
				menu.setModuleId(rs.getInt("MODULEID"));
				menu.setSeq(rs.getInt("SEQ"));
				menu.setVisible(rs.getInt("VISIBLE"));
				menuDetails.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
		return menuDetails;
	}

	@Override
	public List<Menu> getMenuById(long paramLong, int paramInt1, int paramInt2,
			int paramInt3, List<Integer> paramList) {
		List<Menu> menuDetails = new ArrayList<Menu>();
		String sql = "select * from C_RIGHT  where ID = ? and  PARENTID != -1  and (TYPE = ? or TYPE = ?) and VISIBLE =? and MODULEID in(?) order by SEQ";
		Object[] params = { paramLong, paramInt1, paramInt2, paramInt3,
				paramList };
		ResultSet rs = this.select(sql, params);

		try {
			while (rs.next()) {
				Menu menu = new Menu();
				menu.setId(rs.getLong("ID"));
				menu.setParentID(rs.getLong("PARENTID"));
				menu.setName(rs.getString("NAME"));
				menu.setIcon(rs.getString("ICON"));
				menu.setUrl(rs.getString("VISITURL"));
				menu.setModuleId(rs.getInt("MODULEID"));
				menu.setSeq(rs.getInt("SEQ"));
				menu.setVisible(rs.getInt("VISIBLE"));
				menuDetails.add(menu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.closeResource();
		}
		return menuDetails;
	}

}
