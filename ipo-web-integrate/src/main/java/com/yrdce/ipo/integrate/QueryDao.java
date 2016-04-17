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
		List<Map<String, Object>> roleList = this.getJdbcTemplate()
				.queryForList(sql);
		List<Role> roleInfos = new ArrayList<Role>();
		for (Map<String, Object> map : roleList) {
			Role roleInfo = new Role();
			roleInfo.setId((Long) map.get("id"));
			roleInfo.setName((String) map.get("name"));
			roleInfo.setDescription((String) map.get("description"));
			roleInfos.add(roleInfo);
		}
		Set<Role> result = new HashSet<Role>();
		result.addAll(roleInfos);
		return result;
	}

	public Set<Role> getUserRole(String id) {
		String sql = "select r.* from c_user_role t left join c_role r on t.roleid=r.id where t.userid=?  ";
		Object[] o = { id };
		List<Map<String, Object>> roleList = this.getJdbcTemplate()
				.queryForList(sql, o);
		List<Role> roleInfos = new ArrayList<Role>();
		for (Map<String, Object> map : roleList) {
			Role roleInfo = new Role();
			roleInfo.setId((Long) map.get("id"));
			roleInfo.setName((String) map.get("name"));
			roleInfo.setDescription((String) map.get("description"));
			roleInfos.add(roleInfo);
		}
		Set<Role> result = new HashSet<Role>();
		result.addAll(roleInfos);
		return result;

	}

	public Set<Right> getAllRight() {
		String sql = "select * from C_RIGHT where type!=-2 ";
		List<Map<String, Object>> rightList = this.getJdbcTemplate()
				.queryForList(sql);
		List<Right> rightInfos = new ArrayList<Right>();
		for (Map<String, Object> map : rightList) {
			Right rightInfo = new Right();
			rightInfo.setId((Long) map.get("id"));
			rightInfo.setName((String) map.get("name"));
			rightInfo.setIcon((String) map.get("icon"));
			rightInfo.setUrl((String) map.get("url"));
			rightInfo.setVisiturl((String) map.get("visiturl"));
			rightInfo.setModuleId((Integer) map.get("moduleId"));
			rightInfo.setVisible((Integer) map.get("visible"));
			rightInfo.setSeq((Integer) map.get("seq"));
			rightInfo.setType((Integer) map.get("type"));
			rightInfos.add(rightInfo);
		}
		Set<Right> result = new HashSet<Right>();
		result.addAll(rightInfos);
		return result;
	}

	public Set<Right> getUserRight(String id) {
		String sql = "select r.* from c_user_right t left join c_right r on t.rightid=r.id where t.userid=? and type!=-2 ";
		Object[] o = { id };
		List<Map<String, Object>> rightList = this.getJdbcTemplate()
				.queryForList(sql, o);
		List<Right> rightInfos = new ArrayList<Right>();
		for (Map<String, Object> map : rightList) {
			Right rightInfo = new Right();
			rightInfo.setId((Long) map.get("id"));
			rightInfo.setName((String) map.get("name"));
			rightInfo.setIcon((String) map.get("icon"));
			rightInfo.setUrl((String) map.get("url"));
			rightInfo.setVisiturl((String) map.get("visiturl"));
			rightInfo.setModuleId((Integer) map.get("moduleId"));
			rightInfo.setVisible((Integer) map.get("visible"));
			rightInfo.setSeq((Integer) map.get("seq"));
			rightInfo.setType((Integer) map.get("type"));
			rightInfos.add(rightInfo);
		}
		Set<Right> result = new HashSet<Right>();
		result.addAll(rightInfos);
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
		List<Map<String, Object>> trademoduleList = this.getJdbcTemplate()
				.queryForList(sql);
		List<StandardModel> rightInfos = new ArrayList<StandardModel>();
		for (Map<String, Object> map : trademoduleList) {
			TradeModule rightInfo = new TradeModule();
			rightInfo.setModuleId((Integer) map.get("moduleId"));
			rightInfo.setAddFirmFn((String) map.get("addFirmFn"));
			rightInfo.setCnName((String) map.get("cnName"));
			rightInfo.setDelFirmFn((String) map.get("delFirmFn"));
			rightInfo.setEnName((String) map.get("enName"));
			rightInfo.setIsFirmSet((String) map.get("isFirmSet"));
			rightInfo.setIsNeedBreed((String) map.get("isNeedBreed"));
			rightInfo.setShortName((String) map.get("shortName"));
			rightInfo.setUpdateFirmStatusFn((String) map
					.get("updateFirmStatusFn"));
			rightInfos.add(rightInfo);
		}
		return rightInfos;
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
