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
	private IpoCommodityMapper com;
	@Autowired
	private IpoOrderMapper order;
	@Autowired
	private TATradetimeMapper tat;

	// 时间判断
	public boolean isInDates(String sId) {
		logger.info("查询商品一列信息");
		try {
			IpoCommodity c = com.selectByComid(sId);
			logger.info("获取开始时间");
			Date ftime1 = c.getStarttime();
			Date times = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String ftime = sdf.format(ftime1);
			String nowtimes = sdf.format(times);

			if (ftime.equals(nowtimes) && ftime != null) {

				// 获取数据库中共有几条时间记录
				logger.info("获取交易节表信息");
				List<TATradetime> list = tat.select();
				for (int r = 0; r < list.size(); r++) {
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

					long now = Long.parseLong(times.getHours() + "" + times.getMinutes() + "" + times.getSeconds());

					if (now >= begin && now < finish) {
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// 申购
	@Override
	public int apply(String userId, String sId, Integer counts) {
		logger.info("进入申购方法");
		try {
			if (this.isInDates(sId)) {
				logger.info("进入时间判断");
				if (this.repeat(userId, sId)) {
					logger.info("进入重复申购");
					// TODO Auto-generated method stub
					// 获取商品信息
					logger.info("获取商品信息");
					IpoCommodity commodity = com.selectByComid(sId);
					// 获取商品名称
					String name = commodity.getCommodityname();
					// 商品单价
					BigDecimal price = commodity.getPrice();
					// 获取客户可用资金
					logger.info("调用存储函数");
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("monery", "");
					param.put("userid", userId);
					param.put("lock", 0);
					funds.getMonery(param);
					BigDecimal monery = (BigDecimal) param.get("monery");
					// int类型转换，购买几个单位
					BigDecimal bigDecimal = new BigDecimal(counts);
					// 1000为一单位
					BigDecimal Unitprice = new BigDecimal(1000);
					// 1单位价格
					BigDecimal total = price.multiply(Unitprice);
					// 申购消费总额
					BigDecimal allMonery = bigDecimal.multiply(total);
					// 申购判断
					if (monery.compareTo(allMonery) != -1) {
						logger.info("进入资金判断");
						// 当前时间
						Timestamp date = new Timestamp(System.currentTimeMillis());
						IpoOrder d = new IpoOrder();
						d.setUserid(userId);
						d.setCommodityid(sId);
						d.setCommodityname(name);
						d.setCounts(counts);
						d.setCreatetime(date);
						d.setFrozenfunds(allMonery);
						order.insert(d);

						this.frozen(userId, allMonery);

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
			return 4;
		}
	}

	// 冻结资金
	public BigDecimal frozen(String userId, BigDecimal allMonery) {
		logger.info("调用冻结资金函数");
		float mony = allMonery.floatValue();
		try {
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("monery", "");
			param.put("userid", userId);
			param.put("amount", mony);
			param.put("moduleid", "40");
			System.out.println(new Date());
			funds.getfrozen(param);
			System.out.println(new Date());
			BigDecimal monery = new BigDecimal((Double) (param.get("monery")));
			return monery;
		} catch (Exception e) {
			e.printStackTrace();
			return new BigDecimal(0);
		}
	}

	// 判断是重复申购
	public boolean repeat(String userId, String sId) {
		logger.info("查询商品重复申购 ");
		IpoOrder ipoOrder = order.selectByid(userId, sId);
		if (ipoOrder != null) {
			return false;
		} else {
			return true;
		}
	}

}
