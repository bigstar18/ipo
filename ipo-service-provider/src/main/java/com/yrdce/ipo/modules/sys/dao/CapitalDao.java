package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import oracle.jdbc.OracleTypes;

/**
 * 获取可用资金
 * 
 * @author Bob
 *
 */
public class CapitalDao {

	private static JdbcTemplate jdbcT;

	public static BigDecimal expendable(String userid) {

		final String id = userid;
		@SuppressWarnings("unchecked")
		Object param2Value = jdbcT.execute(new CallableStatementCreator() {
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				String storedProc = "{? = call FN_F_GetRealFunds(?,?)}";// 调用的sql
				CallableStatement cs = con.prepareCall(storedProc);
				cs.setString(2, id);// 设置输入参数的值
				cs.setInt(3, 1);
				cs.registerOutParameter(2, OracleTypes.NUMBER);// 注册输出参数的类型
				return cs;
			}
		}, new CallableStatementCallback() {
			public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
				cs.execute();
				return cs.getString(1);// 获取输出参数的值
			}
		});
		return (BigDecimal) param2Value;
	}

}
