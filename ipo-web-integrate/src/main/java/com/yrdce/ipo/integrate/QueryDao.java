package com.yrdce.ipo.integrate;

import java.util.List;

import org.springframework.dao.DataAccessException;

import gnnt.MEBS.common.mgr.model.Menu;
import gnnt.MEBS.common.mgr.model.StandardModel;
import gnnt.MEBS.common.mgr.model.TradeModule;
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

	getListBySql("select * from c_marketInfo");
	
	.getListBySql("select * from c_deploy_config t where t.systype='mgr' order by t.sortno,t.moduleid asc");

 getListBySql("select * from c_trademodule where 1=1", new TradeModule());

	public Menu getMenuById(long paramLong, int paramInt1, int paramInt2, int paramInt3, List<Integer> paramList) {
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
