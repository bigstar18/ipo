package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;

/**
 * 申购服务
 * 
 * @author Bob
 * 
 */
@Service("purchase")
public class PurchaseImpl implements Purchase {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private FFirmfundsMapper funds;
	@Autowired
	private IpoCommodityMapper com;
	@Autowired
	private IpoOrderMapper order;
	@Autowired
	@Qualifier("systemService")
	private SystemService system;

	// 时间判断
	public boolean isInDates(String sId) {
		logger.info("查询商品一列信息");
		IpoCommodity c = com.selectByComid(sId);
		logger.info("获取开始时间");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 获取开售日期
		Date ftimeStart1 = c.getStarttime();
		String ftimeStart = sdf.format(ftimeStart1).replaceAll("-", "");
		int start = Integer.parseInt(ftimeStart);
		// 获取截至日期
		Date ftimeEnd1 = c.getEndtime();
		String ftimrEnd = sdf.format(ftimeEnd1).replaceAll("-", "");
		int end = Integer.parseInt(ftimrEnd);
		// 获取当前日期
		Date times = new Date();
		String time = sdf.format(times).replaceAll("-", "");
		int now = Integer.parseInt(time);
		logger.info(">>>>>>>>>>>>" + "start:" + start + " " + "end:" + end + " " + "now:" + now);
		if (now >= start && now <= end) {
			return true;
		}
		return false;
	}

	// 申购
	@Override
	@Transactional
	public int apply(String userId, String sId, Integer counts, Integer id) throws Exception {
		logger.info("进入申购方法");
		final int SECCESS = 0;
		final int NOT_COMMODITY_TIME = 1;
		final int LACK_OF_FUNDS = 2;
		final int REPEAT = 3;
		// final int ERROR = 4;
		final int OUT_OF_QUOTA = 5;
		final int NOT_TIME = 6;
		if (system.canSystemTrade()) {
			String ID = sId.toUpperCase();
			if (this.isInDates(ID)) {
				logger.info("进入时间判断");
				if (this.repeat(userId, sId)) {
					logger.info("进入重复申购");
					// TODO Auto-generated method stub
					// 获取商品信息
					logger.info("获取商品信息");
					IpoCommodity commodity = com.selectByComid(ID);
					// 获取商品名称
					String name = commodity.getCommodityname();
					// 商品单价
					BigDecimal price = commodity.getPrice();
					// 获取申购额度
					long e = commodity.getPurchaseCredits();
					// 发售单位
					int units = commodity.getUnits();
					// 获取客户可用资金
					logger.info("调用资金存储函数");
					Map<String, Object> param = new HashMap<String, Object>();
					param.put("monery", "");
					param.put("userid", userId);
					param.put("lock", 0);
					funds.getMonery(param);
					BigDecimal monery = (BigDecimal) param.get("monery");
					// int类型转换
					BigDecimal bigDecimal = new BigDecimal(counts);
					// 申购消费总额
					BigDecimal allMonery = bigDecimal.multiply(price);

					// 申购额度判断
					if (counts <= e) {
						// 申购资金判断
						if (monery.compareTo(allMonery) != -1) {
							logger.info("进入资金判断");
							// 查询主键值
							long sequence = order.sequence();

							// 当前时间
							Timestamp date = new Timestamp(System.currentTimeMillis());
							SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
							String sequence1 = String.format("%04d", sequence);
							String time = sdf.format(date);
							String primaryKey = time + sequence1;
							IpoOrder d = new IpoOrder();
							d.setOrderid(primaryKey);
							d.setUserid(userId);
							d.setCommodityid(sId);
							d.setCommodityname(name);
							d.setCounts(counts);
							d.setCreatetime(date);
							d.setFrozenfunds(allMonery);
							d.setFrozenst(0);
							d.setCommodity_id(id);
							order.insert(d);
							this.frozen(userId, allMonery);
							return SECCESS;
						} else {
							return LACK_OF_FUNDS;
						}
					} else {
						return OUT_OF_QUOTA;
					}
				} else {
					return REPEAT;
				}
			} else {
				return NOT_COMMODITY_TIME;
			}
		} else {
			return NOT_TIME;
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
			funds.getfrozen(param);
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
