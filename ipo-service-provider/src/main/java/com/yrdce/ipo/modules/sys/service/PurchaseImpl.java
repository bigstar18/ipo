package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.dao.TATradetimeMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.entity.TATradetime;

/**
 * 申购服务
 * 
 * @author Bob
 * 
 */
@Service("Purchase")
@Transactional(readOnly = true)
public class PurchaseImpl implements Purchase {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private FFirmfundsMapper funds;
	@Autowired
	private IpoCommodityMapper Commodity;
	@Autowired
	private IpoOrderMapper order;
	@Autowired
	private TATradetimeMapper tat;
	@Autowired
	Distribution distribution;

	// private JdbcTemplate jdbcT;

	// 时间判断
	public boolean isInDates(String sid) {
		logger.info("查询商品一列信息");
		try {
			IpoCommodity c = Commodity.selectByComid(sid);
			logger.info("获取开始时间");
			Date ftime1 = c.getStarttime();
			// Date ftime1 = new Date();//
			// ????????????????????????????????????????????????????????????
			Date times = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String ftime = sdf.format(ftime1);
			String nowtimes = sdf.format(times);

			if (ftime.equals(nowtimes) && ftime != null) {

				// 获取数据库中共有几条时间记录
				logger.info("获取交易节有几条记录");
				int b = tat.selectbycount();
				logger.info("获取交易节表信息");
				List<TATradetime> list = tat.select();
				for (int r = 0; r <= list.size(); r++) {
					TATradetime tradetime = list.get(r);
					String start = tradetime.getStarttime();
					String end = tradetime.getEndtime();

					// 获取状态
					Short i = tradetime.getStatus();
					// 获取当前时间
					if (i != 1)
						continue;

					long begin = Long.parseLong(start.replaceAll(":", ""));
					long finish = Long.parseLong(end.replaceAll(":", ""));

					long now = Long.parseLong(times.getHours() + ""
							+ times.getMinutes() + "" + times.getSeconds());
					System.out.println("开始时间" + begin);
					System.out.println("结束时间" + finish);
					System.out.println("时间" + now);

					if (now >= begin && now < finish) {
						return true;
					}
					System.out.println("*************");
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// 申购
	@Override
	public int apply(String userid, String sid, Integer counts) {
		logger.info("进入申购方法");
		try {
			if (this.isInDates(sid)) {
				logger.info("进入时间判断");
				if (this.repeat(userid, sid)) {
					logger.info("进入重复申购");
					// TODO Auto-generated method stub
					// 获取商品信息
					logger.info("获取商品信息");
					IpoCommodity commodity = Commodity.selectByComid(sid);
					// 获取商品名称
					String name = commodity.getCommodityname();
					// 商品单价
					BigDecimal price = commodity.getPrice();
					// 获取客户可用资金
					logger.info("调用存储函数");
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("monery", "");
					param.put("userid", userid);
					param.put("lock", 1);
					funds.getMonery(param);
					BigDecimal monery = (BigDecimal) param.get("monery");
					// BigDecimal monery = CapitalDao.expendable(userid);
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
						logger.info("进入资金判断");
						// 当前时间
						Timestamp date = new Timestamp(
								System.currentTimeMillis());
						IpoOrder d = new IpoOrder();
						d.setUserid(userid);
						d.setCommodityid(sid);
						d.setCommodityname(name);
						d.setCounts(counts);
						d.setCreatetime(date);
						d.setFrozenfunds(allMonery);
						order.insert(d);
						this.frozen(userid, allMonery);

						distribution.start();
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
		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}

	// 冻结资金
	public BigDecimal frozen(String userid, BigDecimal allMonery) {
		logger.info("调用冻结资金函数");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("monery", "");
		param.put("userid", userid);
		param.put("amount", allMonery);
		param.put("moduleid", "50");
		funds.getfrozen(param);
		BigDecimal monery = (BigDecimal) param.get("monery");
		/*
		 * final String id = userid; final BigDecimal monery = allMonery;
		 * 
		 * @SuppressWarnings("unchecked") Object param2Value = jdbcT.execute(new
		 * CallableStatementCreator() { public CallableStatement
		 * createCallableStatement(Connection con) throws SQLException { String
		 * storedProc = "{?=call FN_F_UpdateFrozenFunds(?,?,?)}";// 调用的sql
		 * CallableStatement cs = con.prepareCall(storedProc); cs.setString(2,
		 * id);// 设置输入参数的值 cs.setBigDecimal(3, monery); cs.setString(4, 50 +
		 * ""); cs.registerOutParameter(1, OracleTypes.NUMBER);// 注册输出参数的类型
		 * return cs; } }, new CallableStatementCallback() { public Object
		 * doInCallableStatement(CallableStatement cs) throws SQLException,
		 * DataAccessException { cs.execute(); return cs.getInt(1);// 获取输出参数的值 }
		 * });
		 */
		return monery;
	}

	// 判断是重复申购
	public boolean repeat(String userid, String sid) {
		logger.info("查询商品重复申购 ");
		IpoOrder ipoOrder = order.selectByid(userid, sid);
		if (ipoOrder != null) {
			return false;
		} else {
			return true;
		}

	}

}
