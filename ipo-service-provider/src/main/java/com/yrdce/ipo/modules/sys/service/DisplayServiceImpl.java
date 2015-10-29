package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.CapitalDao;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.vo.Display;

@Service
public class DisplayServiceImpl implements DisplayService {

	private IpoCommodityMapper commodity;

	public void display(String userid, String sid) {
		// 获得商品名称
		IpoCommodity c = commodity.selectByPrimaryKey(userid);
		String name = c.getCommodityname();
		// 获取可用资金
		BigDecimal monery = CapitalDao.expendable(userid);
		// 获取商品单价
		BigDecimal price = c.getPrice();
		// 计算可购买数量
		int number = (monery.divide(price, 0, BigDecimal.ROUND_DOWN)).intValue();

		Display display = new Display(sid, name, monery, number, 100000000);
	}

}
