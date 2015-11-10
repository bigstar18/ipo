package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.FFirmfundsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.vo.Display;

/**
 * 返回前台数据
 * 
 * @author Bob
 * 
 */
@Service("DisplayService")
public class DisplayServiceImpl implements DisplayService {
	@Autowired
	private IpoCommodityMapper commodity;
	@Autowired
	private FFirmfundsMapper funds;

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

	public Display display(String sId, String monery1) {

		if (sId != null && monery1 != null) {
			String ID = sId.toUpperCase();
			BigDecimal monery = new BigDecimal(monery1);
			// 获得商品名称
			IpoCommodity c = commodity.selectByComid(ID);
			if (c != null) {
				// String name = c.getCommodityname();
				// 获取商品单价
				BigDecimal price = c.getPrice();
				// 获取配售单位
				int units = c.getUnits();
				BigDecimal Unitprice = new BigDecimal(units);
				// 1单位价格
				BigDecimal total = price.multiply(Unitprice);
				// 计算可购买多少单位
				int number = (monery.divide(total, 0, BigDecimal.ROUND_DOWN)).intValue();
				// 获得申购额度
				long purchaseCredits = c.getpurchaseCredits();

				Display display = new Display(number, 100000000, units, price, purchaseCredits);
				return display;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

}
