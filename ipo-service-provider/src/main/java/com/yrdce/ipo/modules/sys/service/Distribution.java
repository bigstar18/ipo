package com.yrdce.ipo.modules.sys.service;

import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;

public class Distribution<E> {

	// 起始配号
	private int minStart = 10000001;
	// 最大配号
	private int maxStart = 99999999;
	// 默认起始配号
	// private int m = 1000;
	private IpoOrderMapper order;

	public void start(String userid, String sid) {
		// 根据用户ID和商品ID查询出唯一订单信息
		// IpoOrder o = order.selectByid(userid, sid);
		// 获取数据库中申购的时间
		// Date time = o.getCreatetime();
		// 获取系统当前时间
		// Date nowTime = new Date();
		// 时间运算
		// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		// sdf.format(nowTime);
		// sdf.format(time);
		// Calendar rightNow = Calendar.getInstance();
		// rightNow.setTime(nowTime);
		// rightNow.setTime(time);
		// rightNow.add(Calendar.YEAR,-1);
		// 判断时间是否是前一天

		// 获取商品共应该配多少号
		int counts = order.bycommodityid(sid);
		int num = minStart + counts;
		// 判断配号规则
		if (num < maxStart) {

		} else {

		}
	}
}
