package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.CapitalDao;
import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.dao.TATradetimeMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.entity.TATradetime;

import oracle.jdbc.OracleTypes;

@Service("Purchase")
@Transactional(readOnly = true)
public class PurchaseImpl implements Purchase {

	private FFirmfundsMapper funds;
	private IpoCommodityMapper Commodity;
	private IpoOrderMapper order;
	private TATradetimeMapper tat;

	@Autowired
	private JdbcTemplate jdbcT;

	// 时间判断
	public boolean isInDates(String sid) {
		IpoCommodity c = Commodity.selectByPrimaryKey(sid);
		Date ftime1 = c.getStarttime();
		Date times = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String ftime = sdf.format(ftime1);
		String nowtimes = sdf.format(times);
		if (ftime.equals(nowtimes) && ftime != null) {

			// 获取数据库中共有几条时间记录
			int b = tat.selectbycount();
			for (int r = 0; r <= b; r++) {
				TATradetime time = tat.selectbyrownum(r);
				String start = time.getStarttime();
				String end = time.getEndtime();

				// 获取状态
				Short i = time.getStatus();
				// 获取当前时间

				SimpleDateFormat sd = new SimpleDateFormat("HH:mm:ss");
				String nowTime = sd.format(times);
				// 时间格式转换
				int strDateH = Integer.parseInt(nowTime.substring(0, 2));
				int strDateM = Integer.parseInt(nowTime.substring(3, 5));
				int strDateS = Integer.parseInt(nowTime.substring(6, 8));

				int strDateBeginH = Integer.parseInt(start.substring(0, 2));
				int strDateBeginM = Integer.parseInt(start.substring(3, 5));
				int strDateBeginS = Integer.parseInt(start.substring(6, 8));

				int strDateEndH = Integer.parseInt(end.substring(0, 2));
				int strDateEndM = Integer.parseInt(end.substring(3, 5));
				int strDateEndS = Integer.parseInt(end.substring(6, 8));

				if (strDateH >= strDateBeginH && strDateH < strDateEndH && i == 1) {
					if (strDateM >= strDateBeginM && strDateM <= strDateEndM) {
						if (strDateS >= strDateBeginS && strDateS <= strDateEndS) {
							return true;
						} else {
							return false;
						}
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
		}
		return false;
	}

	// 申购
	@Override
	public int apply(String userid, String sid, int counts) {
		if (this.isInDates(sid)) {
			if (this.repeat(userid, sid)) {
				// TODO Auto-generated method stub
				// 获取商品信息
				IpoCommodity commodity = Commodity.selectByPrimaryKey(sid);
				// 获取商品名称
				String name = commodity.getCommodityname();
				// 商品单价
				BigDecimal price = commodity.getPrice();
				// 获取客户信息
				// FFirmfunds f = funds.selectByPrimaryKey(userid);
				// 获取客户可用资金
				// BigDecimal monery = f.getBalance();
				BigDecimal monery = CapitalDao.expendable(userid);
				// int类型转换，购买几个单位
				BigDecimal bigDecimal = new BigDecimal(counts);
				// 1000为一单位
				BigDecimal Unitprice = new BigDecimal(1000);
				// 1单位价格
				BigDecimal total = price.multiply(Unitprice);
				// 申购消费总额
				// BigDecimal allMonery1 = price.multiply(bigDecimal);
				BigDecimal allMonery = bigDecimal.multiply(total);
				// 申购判断
				if (monery.compareTo(allMonery) != -1) {
					// 当前时间
					Date date = new Date();
					// DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					// String time = format.format(date);
					IpoOrder d = new IpoOrder();
					d.setUserid(userid);
					d.setCommodityid(sid);
					d.setCommodityname(name);
					d.setCounts(bigDecimal);
					d.setCreatetime(date);
					d.setFrozenfunds(allMonery);
					order.insert(d);
					this.frozen(userid, allMonery);

					return 0;
				} else {
					return 2;
				}
			} else {
				return 3;
			}
		} else {
			return 1;
		}

	}

	// 冻结资金
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

	// 判断是重复申购
	public boolean repeat(String userid, String sid) {
		IpoOrder o = order.selectByid(userid, sid);
		if (o.getCounts() != null) {
			return false;
		} else {
			return true;
		}

	}

}
