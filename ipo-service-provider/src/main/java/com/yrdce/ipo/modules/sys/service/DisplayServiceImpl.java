package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;

/**
 * 返回前台数据
 * 
 * @author Bob
 * 
 */
@Service("displayService")
public class DisplayServiceImpl implements DisplayService {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IpoCommodityMapper commodity;
	@Autowired
	private FFirmfundsMapper funds;
	@Autowired
	private IpoCommodityConfMapper ipoCommConfMapper;

	public String userInfo(String userId) {
		// 获取可用资金
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("monery", "");
		param.put("userid", userId);
		funds.getMonery(param);
		BigDecimal monery = (BigDecimal) param.get("monery");
		String monery1 = monery + "";
		return monery1;
	}

	public Integer display(String sId, String monery1) {

		if (sId != null && monery1 != null) {
			String ID = sId.toUpperCase();
			BigDecimal monery = new BigDecimal(monery1);
			// 获得商品名称
			IpoCommodity com = commodity.selectByComid(ID);
			if (com != null) {
				// 获取商品单价
				BigDecimal price = com.getPrice();
				BigDecimal sum = this.getFee(sId, monery, price);
				// 计算可购买多少
				Integer number = (monery.divide(sum, 0, BigDecimal.ROUND_DOWN)).intValue();
				return number;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public BigDecimal getFee(String sid, BigDecimal monery, BigDecimal price) {
		// 获取算法方式，比例值 1：百分比 2：绝对值
		IpoCommodityConf ipoCommodityConf = ipoCommConfMapper.selectCommUnit(sid);
		short mode = ipoCommodityConf.getTradealgr();
		BigDecimal val = ipoCommodityConf.getBuy();
		if (mode == 1) {
			BigDecimal valparam = (val.divide(new BigDecimal("100")));
			BigDecimal sum = (valparam.multiply(price)).add(price);
			logger.info("比例购买算法：" + valparam);
			return sum;
		} else {
			BigDecimal sum = val.add(price);
			logger.info("绝对值算法：" + val);
			return sum;
		}
	}

}
