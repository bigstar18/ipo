package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @ClassName: AuthorizationDao
 * @Description: 交易商查看上平行情的权限
 * @author bob
 */
public class AuthorizationDao extends JdbcDaoSupport {

	public String findOperation(String brokerid) {
		String sql = " select orm.centerid from oo_center_broker_orm orm where orm.brokerid =?";
		Object[] params = { brokerid };
		String centerid = null;
		try {
			centerid = (String) this.getJdbcTemplate().queryForObject(sql, params, String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return centerid;
	}

	public List<String> findCommodity(String centerid) {
		String sql = " select orm.commodityid from oo_center_commodity_orm orm where orm.centerid = ?";
		Object[] params = { centerid };
		List<String> commodityid = null;
		try {
			commodityid = (List<String>) this.getJdbcTemplate().queryForList(sql, params, String.class);
			//(List<String>) this.getJdbcTemplate().query(sql, params,new SingleColumnRowMapper())
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commodityid;
	}

}
