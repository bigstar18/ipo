package com.yrdce.ipo.integrate;

import org.springframework.dao.DataAccessException;

import gnnt.MEBS.logonService.dao.BaseDAOJdbc;

public class QueryDao extends BaseDAOJdbc {

	public String getFirmid(String arg) throws DataAccessException {
		String currentPhase = "";
		String sql = "select t.firmid from M_TRADER t where t.traderid = ?";
		Object[] o = { arg };
		try {
			currentPhase = (String) this.getJdbcTemplate().queryForObject(sql, o, String.class);
		} catch (Exception e) {
			currentPhase = "";
			e.printStackTrace();
		}

		return currentPhase;
	}

}
