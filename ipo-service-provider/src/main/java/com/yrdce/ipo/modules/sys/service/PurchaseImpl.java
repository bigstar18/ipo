package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;

import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;

import oracle.jdbc.OracleTypes;

public class PurchaseImpl implements Purchase {

	private FFirmfundsMapper funds;
	private IpoCommodityMapper Commodity;
	private IpoOrderMapper order;

	// 客户id
	private String userid;
	@Autowired
	private JdbcTemplate jdbcT;

	@Override
	public int apply(String id, int counts) {
		// TODO Auto-generated method stub
		// 获取商品信息
		IpoCommodity commodity = Commodity.selectByPrimaryKey(id);
		// 获取商品名称
		String name = commodity.getCommodityname();
		BigDecimal price = commodity.getPrice();
		// 获取客户信息
		// FFirmfunds f = funds.selectByPrimaryKey(userid);
		// 获取客户可用资金
		// BigDecimal monery = f.getBalance();
		BigDecimal monery = this.expendable(userid);
		// int类型转换
		BigDecimal bigDecimal = new BigDecimal(counts);
		// 申购消费总额
		BigDecimal allMonery = price.multiply(bigDecimal);
		// 申购判断
		if (monery.compareTo(allMonery) != -1) {
			// 当前时间
			Date date = new Date();
			// DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			// String time = format.format(date);
			IpoOrder d = new IpoOrder();
			d.setUserid(userid);
			d.setCommodityid(id);
			d.setCommodityname(name);
			d.setCounts(bigDecimal);
			d.setCreatetime(date);
			d.setFrozenfunds(allMonery);
			order.insert(d);
			this.frozen(userid, allMonery);
			return 0;
		} else {
			return 1;
		}

	}

	public BigDecimal frozen(String userid, BigDecimal allMonery) {

		final String id = userid;
		final BigDecimal monery = allMonery;
		@SuppressWarnings("unchecked")
		Object param2Value = jdbcT.execute(new CallableStatementCreator() {
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				String storedProc = "{?=call FN_F_UpdateFrozenFunds(?,?,?)}";// 调用的sql
				CallableStatement cs = con.prepareCall(storedProc);
				cs.setString(2, id);// 设置输入参数的值
				cs.setBigDecimal(3, monery);
				cs.setString(4, 50 + "");
				cs.registerOutParameter(1, OracleTypes.NUMBER);// 注册输出参数的类型
				return cs;
			}
		}, new CallableStatementCallback() {
			public Object doInCallableStatement(CallableStatement cs) throws SQLException, DataAccessException {
				cs.execute();
				return cs.getInt(1);// 获取输出参数的值
			}
		});
		return (BigDecimal) param2Value;
	}

	public BigDecimal expendable(String userid) {

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
