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

import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDebitFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.vo.DebitFlow;

/**
 * 申购服务
 * 
 * @author Bob
 * 
 */
@Service("purchase")
public class PurchaseImpl implements Purchase {
	final static int SECCESS = 0;
	final static int NOT_COMMODITY_TIME = 1;
	final static int LACK_OF_FUNDS = 2;
	final static int REPEAT = 3;
	// final static int ERROR = 4;
	final static int OUT_OF_QUOTA = 5;
	final static int NOT_TIME = 6;

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private FFirmfundsMapper fundsMapper;
	@Autowired
	private IpoCommodityMapper ipoComMapper;
	@Autowired
	private IpoOrderMapper ipoOrderMapper;
	@Autowired
	@Qualifier("systemService")
	private SystemService system;
	@Autowired
	private IpoCommodityConfMapper ipoCommConfMapper;
	@Autowired
	private IpoDebitFlowMapper ipoDebitFlowMapper;

	private ThreadLocal<String> applyUser = new ThreadLocal<String>();

	// 时间判断
	public boolean isInDates(String sId) {
		logger.info("查询商品一列信息");
		IpoCommodity c = ipoComMapper.selectByComid(sId);
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
		if (applyUser.get() != null)
			return REPEAT;

		applyUser.set(userId);// 要求不高
		int result = SECCESS;

		logger.info("进入申购方法");
		if (system.canSystemTrade()) {
			String ID = sId.toUpperCase();
			if (this.isInDates(ID)) {
				logger.info("进入时间判断");
				if (this.repeat(userId, sId)) {
					logger.info("进入重复申购");
					// TODO Auto-generated method stub
					// 获取商品信息
					logger.info("获取商品信息");
					IpoCommodity commodity = ipoComMapper.selectByComid(ID);
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
					fundsMapper.getMonery(param);
					BigDecimal monery = (BigDecimal) param.get("monery");
					// int类型转换
					BigDecimal num = new BigDecimal(counts);
					// 申购消费总额
					BigDecimal allMonery = num.multiply(price);
					// 获取算法方式，比例值 1：百分比 2：绝对值
					IpoCommodityConf ipoCommodityConf = ipoCommConfMapper.selectCommUnit(sId);
					short mode = ipoCommodityConf.getPublishalgr();
					BigDecimal val = ipoCommodityConf.getDealerpubcharatio();
					BigDecimal fee = new BigDecimal(0);
					if (mode == 1) {
						BigDecimal valparam = val.divide(new BigDecimal("100"));
						fee = allMonery.multiply(valparam);
						logger.info("比例手续费：" + fee);
					} else {
						fee = num.multiply(val);
						logger.info("绝对值手续费：" + fee);
					}
					BigDecimal cost = allMonery.add(fee);
					logger.info("总值：" + cost);
					// 申购额度判断
					if (counts <= e) {
						// 申购资金判断
						if (monery.compareTo(cost) != -1) {
							logger.info("进入资金判断");
							// 查询主键值
							long sequence = ipoOrderMapper.sequence();
							// 当前时间
							Timestamp date = new Timestamp(System.currentTimeMillis());
							SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
							String sequence1 = String.format("%04d", sequence);
							String time = sdf.format(date);
							String primaryKey = time + sequence1;
							IpoOrder ipoOrder = new IpoOrder();
							ipoOrder.setOrderid(primaryKey);
							ipoOrder.setUserid(userId);
							ipoOrder.setCommodityid(sId);
							ipoOrder.setCommodityname(name);
							ipoOrder.setCounts(counts);
							ipoOrder.setCreatetime(date);
							ipoOrder.setFrozenfunds(cost);
							ipoOrder.setFrozenst(0);
							ipoOrder.setCommodity_id(id);
							ipoOrder.setBuy(val);
							ipoOrder.setTradealgr(mode);
							ipoOrder.setFrozencounterfee(fee);
							ipoOrderMapper.insert(ipoOrder);
							this.frozen(userId, cost);
							DebitFlow debitFlow = new DebitFlow();
							debitFlow.setBusinessType(ChargeConstant.BusinessType.PUBLISH.getCode());
							debitFlow.setChargeType(ChargeConstant.Type.DISPOSABLE.getName());
							debitFlow.setCommodityId(sId);
							debitFlow.setOrderId(primaryKey);
							debitFlow.setDebitState(ChargeConstant.DebitState.FROZEN_SUCCESS.getCode());
							debitFlow.setPayer(userId);
							debitFlow.setAmount(allMonery);
							debitFlow.setDebitMode(ChargeConstant.DebitMode.ONLINE.getCode());
							debitFlow.setDebitChannel(ChargeConstant.DebitChannel.DEPOSIT.getCode());
							debitFlow.setBuyBackFlag(0);
							debitFlow.setCreateUser(userId);
							debitFlow.setCreateDate(new Date());
							ipoDebitFlowMapper.insert(debitFlow);
							result = SECCESS;
						} else {
							result = LACK_OF_FUNDS;
						}
					} else {
						result = OUT_OF_QUOTA;
					}
				} else {
					result = REPEAT;
				}
			} else {
				result = NOT_COMMODITY_TIME;
			}
		} else {
			result = NOT_TIME;
		}

		applyUser.remove();
		return result;
	}

	// 冻结资金
	public BigDecimal frozen(String userId, BigDecimal allMonery) {
		logger.info("调用冻结资金函数");
		float mony = allMonery.floatValue();

		Map<String, Object> param = new HashMap<String, Object>();
		param.put("monery", "");
		param.put("userid", userId);
		param.put("amount", mony);
		param.put("moduleid", "40");
		fundsMapper.getfrozen(param);
		BigDecimal monery = new BigDecimal((Double) (param.get("monery")));
		return monery;

	}

	// 判断是重复申购
	public boolean repeat(String userId, String sId) {
		logger.info("查询商品重复申购 ");
		IpoOrder ipoOrder = ipoOrderMapper.selectByid(userId, sId);
		if (ipoOrder != null) {
			return false;
		} else {
			return true;
		}
	}

}
