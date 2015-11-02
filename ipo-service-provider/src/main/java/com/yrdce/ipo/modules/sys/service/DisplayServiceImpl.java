package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.CapitalDao;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.vo.Display;

@Service("DisplayService")
public class DisplayServiceImpl implements DisplayService {

	private IpoCommodityMapper commodity;

	public Display display(String userid, String sid) {
		// 获得商品名称
		IpoCommodity c = commodity.selectByPrimaryKey(userid);
		String name = c.getCommodityname();
		// 获取可用资金
		BigDecimal monery = CapitalDao.expendable(userid);
		// 获取商品单价
		BigDecimal price = c.getPrice();
		// 1000为一单位
		BigDecimal Unitprice = new BigDecimal(1000);
		// 1单位价格
		BigDecimal total = price.multiply(Unitprice);
		// 计算可购买多少单位
		int number = (monery.divide(total, 0, BigDecimal.ROUND_DOWN)).intValue();

		Display display = new Display(sid, name, monery, number, 100000000);
		// Commodity d = new Commodity();
		// BeanUtils.copyProperties(d, c);
		return display;

	}

}
