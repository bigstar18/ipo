package com.yrdce.ipo.integrate;

import gnnt.MEBS.common.mgr.model.Menu;
import gnnt.MEBS.common.mgr.model.Right;
import gnnt.MEBS.common.mgr.model.Role;
import gnnt.MEBS.common.mgr.model.StandardModel;
import gnnt.MEBS.common.mgr.model.TradeModule;
import gnnt.MEBS.common.mgr.model.User;
import gnnt.MEBS.logonService.dao.BaseDAOJdbc;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataAccessException;

public class QueryDao extends BaseDAOJdbc {

	public String getFirmid(String arg) throws DataAccessException {
		String currentPhase = "";
		String sql = "select t.firmid from M_TRADER t where t.traderid = ?";
		Object[] o = { arg };
		try {
			currentPhase = (String) this.getJdbcTemplate().queryForObject(sql,
					o, String.class);
		} catch (Exception e) {
			currentPhase = "";
			e.printStackTrace();
		}

		return currentPhase;
	}

	public User getUserByID(String id) {
		String sql = "select * from C_USER t where t.id=?";
		Object[] o = { id };
		return this.getJdbcTemplate().queryForObject(sql, o, User.class);
	}

	public Set<Role> getAllRole() {
		String sql = "select * from C_ROLE  ";
		List<Role> roleList = this.getJdbcTemplate().queryForList(sql,
				Role.class);
		Set<Role> result = new HashSet<Role>();
		result.addAll(roleList);
		return result;
	}

	public Set<Right> getAllRight() {
		String sql = "select * from C_RIGHT where type!=-2 ";
		List<Right> roleList = this.getJdbcTemplate().queryForList(sql,
				Right.class);
		Set<Right> result = new HashSet<Right>();
		result.addAll(roleList);
		return result;
	}

	public List<Map<String, Object>> getMarketInfosBySql(String sql) {
		return this.getJdbcTemplate().queryForList(sql);
	}

	public List<Map<String, Object>> getConfigListBySql(String sql) {
		return this.getJdbcTemplate().queryForList(sql);
	}

	public List<StandardModel> getTradeModulesBySql(String sql,
			TradeModule module) {
		return this.getJdbcTemplate().queryForList(sql, StandardModel.class);
	}

	public Menu getMenuById(long paramLong, int paramInt1, int paramInt2,
			int paramInt3, List<Integer> paramList) {
		String sql = "select * from C_RIGHT  where ID = ? and  PARENTID != -1  and (TYPE = ? or TYPE = ?) and VISIBLE =? and MODULEID in(?) order by SEQ";
		Object[] params = { paramLong, paramInt1, paramInt2, paramInt3,
				paramList };
		try {
			List<Menu> menuDetails = this.getJdbcTemplate().queryForList(sql,
					params, Menu.class);
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
