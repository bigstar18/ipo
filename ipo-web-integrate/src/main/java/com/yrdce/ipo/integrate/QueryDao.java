package com.yrdce.ipo.integrate;

import gnnt.MEBS.common.mgr.model.Menu;
import gnnt.MEBS.common.mgr.model.Right;
import gnnt.MEBS.common.mgr.model.Role;
import gnnt.MEBS.common.mgr.model.StandardModel;
import gnnt.MEBS.common.mgr.model.TradeModule;
import gnnt.MEBS.common.mgr.model.User;
import gnnt.MEBS.logonService.dao.BaseDAOJdbc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

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
		RowMapper<User> rm = ParameterizedBeanPropertyRowMapper
				.newInstance(User.class);
		String sql = "select * from C_USER t where t.id=?";
		Object[] o = { id };
		return this.getJdbcTemplate().queryForObject(sql, o, rm);
	}

	public Set<Role> getAllRole() {
		String sql = "select * from C_ROLE  ";
		List<Role> roleList = this.getJdbcTemplate().queryForList(sql,
				Role.class);
		Set<Role> result = new HashSet<Role>();
		result.addAll(roleList);
		return result;
	}

	public Set<Role> getUserRole(String id) {
		String sql = "select r.* from c_user_role t left join c_role r on t.roleid=r.id where t.userid=?  ";
		Object[] o = { id };
		List<Role> roleList = this.getJdbcTemplate().queryForList(sql, o,
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

	public Set<Right> getUserRight(String id) {
		String sql = "select r.* from c_user_right t left join c_right r on t.rightid=r.id where t.userid=? and type!=-2 ";
		Object[] o = { id };
		List<Right> roleList = this.getJdbcTemplate().queryForList(sql, o,
				Right.class);
		Set<Right> result = new HashSet<Right>();
		result.addAll(roleList);
		return result;
	}

	public List<Map<String, Object>> getMarketInfosBySql() {
		String sql = "select * from c_marketInfo";
		return this.getJdbcTemplate().queryForList(sql);
	}

	public List<Map<String, Object>> getConfigListBySql() {
		String sql = "select * from c_deploy_config t where t.systype='mgr' order by t.sortno,t.moduleid asc";
		return this.getJdbcTemplate().queryForList(sql);
	}

	public List<StandardModel> getTradeModulesBySql() {
		String sql = "select * from c_trademodule where 1=1";
		List<TradeModule> list = this.getJdbcTemplate().queryForList(sql,
				TradeModule.class);
		List<StandardModel> result = new ArrayList<StandardModel>();
		for (TradeModule temp : list) {
			result.add(temp);
		}
		return result;
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
