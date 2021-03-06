package com.yrdce.ipo.integrate;

import gnnt.MEBS.common.mgr.model.Menu;
import gnnt.MEBS.common.mgr.model.Right;
import gnnt.MEBS.common.mgr.model.Role;
import gnnt.MEBS.common.mgr.model.StandardModel;
import gnnt.MEBS.common.mgr.model.TradeModule;
import gnnt.MEBS.common.mgr.model.User;
import gnnt.MEBS.logonService.dao.BaseDAOJdbc;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
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
			roleInfo.setId(((BigDecimal) map.get("id")).longValue());
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
			roleInfo.setId(((BigDecimal) map.get("id")).longValue());
			roleInfo.setName((String) map.get("name"));
			roleInfo.setDescription((String) map.get("description"));
			roleInfo.setRightSet(getRoleRight(roleInfo.getId().toString()));
			roleInfos.add(roleInfo);
		}
		Set<Role> result = new HashSet<Role>();
		result.addAll(roleInfos);
		return result;

	}

	public Set<Right> getRoleRight(String roleId) {
		String sql = "select r.* from c_role_right t left join c_right r on t.rightid=r.id where t.roleid=? ";
		Object[] o = { roleId };
		List<Map<String, Object>> rightList = this.getJdbcTemplate()
				.queryForList(sql, o);
		List<Right> rightInfos = new ArrayList<Right>();
		for (Map<String, Object> map : rightList) {
			Right rightInfo = new Right();
			if ((BigDecimal) map.get("id") != null) {
				rightInfo.setId(((BigDecimal) map.get("id")).longValue());
			}
			rightInfo.setName((String) map.get("name"));
			rightInfo.setIcon((String) map.get("icon"));
			rightInfo.setUrl((String) map.get("url"));
			rightInfo.setVisiturl((String) map.get("visiturl"));
			if ((BigDecimal) map.get("moduleId") != null) {
				rightInfo.setModuleId(((BigDecimal) map.get("moduleId"))
						.intValue());
			}
			if ((BigDecimal) map.get("visible") != null) {
				rightInfo.setVisible(((BigDecimal) map.get("visible"))
						.intValue());
			}
			if ((BigDecimal) map.get("seq") != null) {
				rightInfo.setSeq(((BigDecimal) map.get("seq")).intValue());
			}
			if ((BigDecimal) map.get("type") != null) {
				rightInfo.setType(((BigDecimal) map.get("type")).intValue());
			}
			rightInfos.add(rightInfo);
		}
		Set<Right> result = new HashSet<Right>();
		result.addAll(rightInfos);
		return result;
	}

	public Set<Right> getAllRight() {
		String sql = "select * from C_RIGHT where type!=-2 ";
		List<Map<String, Object>> rightList = this.getJdbcTemplate()
				.queryForList(sql);
		List<Right> rightInfos = new ArrayList<Right>();
		for (Map<String, Object> map : rightList) {
			Right rightInfo = new Right();
			if ((BigDecimal) map.get("id") != null) {
				rightInfo.setId(((BigDecimal) map.get("id")).longValue());
			}
			rightInfo.setName((String) map.get("name"));
			rightInfo.setIcon((String) map.get("icon"));
			rightInfo.setUrl((String) map.get("url"));
			rightInfo.setVisiturl((String) map.get("visiturl"));
			if ((BigDecimal) map.get("moduleId") != null) {
				rightInfo.setModuleId(((BigDecimal) map.get("moduleId"))
						.intValue());
			}
			if ((BigDecimal) map.get("visible") != null) {
				rightInfo.setVisible(((BigDecimal) map.get("visible"))
						.intValue());
			}
			if ((BigDecimal) map.get("seq") != null) {
				rightInfo.setSeq(((BigDecimal) map.get("seq")).intValue());
			}
			if ((BigDecimal) map.get("type") != null) {
				rightInfo.setType(((BigDecimal) map.get("type")).intValue());
			}
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
			if ((BigDecimal) map.get("id") != null) {
				rightInfo.setId(((BigDecimal) map.get("id")).longValue());
			}
			rightInfo.setName((String) map.get("name"));
			rightInfo.setIcon((String) map.get("icon"));
			rightInfo.setUrl((String) map.get("url"));
			rightInfo.setVisiturl((String) map.get("visiturl"));
			if ((BigDecimal) map.get("moduleId") != null) {
				rightInfo.setModuleId(((BigDecimal) map.get("moduleId"))
						.intValue());
			}
			if ((BigDecimal) map.get("visible") != null) {
				rightInfo.setVisible(((BigDecimal) map.get("visible"))
						.intValue());
			}
			if ((BigDecimal) map.get("seq") != null) {
				rightInfo.setSeq(((BigDecimal) map.get("seq")).intValue());
			}
			if ((BigDecimal) map.get("type") != null) {
				rightInfo.setType(((BigDecimal) map.get("type")).intValue());
			}
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
			if ((BigDecimal) map.get("moduleId") != null) {
				rightInfo.setModuleId(((BigDecimal) map.get("moduleId"))
						.intValue());
			}
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

	public List<Menu> getMenuById(long paramLong, int paramInt1, int paramInt2,
			int paramInt3, List<Integer> paramList) {
		try {
			String sql = "select * from C_RIGHT  where ID = :paramLong and  (TYPE = :paramInt1 or TYPE = :paramInt2) and VISIBLE =:paramInt3 and MODULEID in(:param) order by SEQ";
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("paramLong", paramLong);
			paramMap.put("paramInt1", paramInt1);
			paramMap.put("paramInt2", paramInt2);
			paramMap.put("paramInt3", paramInt3);
			paramMap.put("param", paramList);
			NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(
					this.getJdbcTemplate());
			List<Menu> menulist = jdbc.query(sql, paramMap,
					new RowMapper<Menu>() {

						@Override
						public Menu mapRow(ResultSet rs, int index)
								throws SQLException {
							Menu rightInfo = new Menu();
							rightInfo.setId(rs.getLong("id"));
							rightInfo.setName(rs.getString("name"));
							rightInfo.setIcon(rs.getString("icon"));
							rightInfo.setUrl(rs.getString("VISITURL"));
							rightInfo.setModuleId(rs.getInt("moduleId"));
							rightInfo.setVisible(rs.getInt("visible"));
							rightInfo.setSeq(rs.getInt("seq"));
							rightInfo.setParentID(rs.getLong("parentID"));
							return rightInfo;
						}
					});

			return menulist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<Menu> getMenuByParentId(long paramLong, int paramInt1,
			int paramInt2, int paramInt3, List<Integer> paramList) {
		try {
			String sql = "select * from C_RIGHT  where parentID = :paramLong and  (TYPE = :paramInt1 or TYPE = :paramInt2) and VISIBLE =:paramInt3 and MODULEID in(:param) order by SEQ";
			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("paramLong", paramLong);
			paramMap.put("paramInt1", paramInt1);
			paramMap.put("paramInt2", paramInt2);
			paramMap.put("paramInt3", paramInt3);
			paramMap.put("param", paramList);
			NamedParameterJdbcTemplate jdbc = new NamedParameterJdbcTemplate(
					this.getJdbcTemplate());
			List<Menu> menulist = jdbc.query(sql, paramMap,
					new RowMapper<Menu>() {

						@Override
						public Menu mapRow(ResultSet rs, int index)
								throws SQLException {
							Menu rightInfo = new Menu();
							rightInfo.setId(rs.getLong("id"));
							rightInfo.setName(rs.getString("name"));
							rightInfo.setIcon(rs.getString("icon"));
							rightInfo.setUrl(rs.getString("VISITURL"));
							rightInfo.setModuleId(rs.getInt("moduleId"));
							rightInfo.setVisible(rs.getInt("visible"));
							rightInfo.setSeq(rs.getInt("seq"));
							rightInfo.setParentID(rs.getLong("parentID"));
							return rightInfo;
						}
					});

			return menulist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
