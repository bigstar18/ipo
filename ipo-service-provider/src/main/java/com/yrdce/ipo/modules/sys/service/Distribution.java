package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoDistributionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoNumberofrecordsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDistribution;
import com.yrdce.ipo.modules.sys.entity.IpoNumberofrecords;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;

@Service("Distribution")
@Transactional(readOnly = true)
public class Distribution {

	// 起始配号
	private int minStart = 10000001;
	// 最大配号
	private int maxStart = 99999999;
	// 默认起始配号
	// private int m = 1000;
	private IpoOrderMapper order;
	private IpoNumberofrecordsMapper unmberofrecord;
	private IpoNumberofrecords num;
	private IpoDistributionMapper distribution;
	private IpoDistribution ipodistribution;

	@SuppressWarnings("unused")
	public void start() {

		// 复制插入商品id
		List list = order.select();
		for (int i = 0; i < list.size(); i++) {
			String sid = (String) list.get(i);
			Timestamp date = new Timestamp(System.currentTimeMillis());
			num.setCommodityid(sid);
			num.setNowtime(date);
			IpoNumberofrecords frecord = new IpoNumberofrecords();
			unmberofrecord.insert(frecord);
		}

		// 获取全部订单列表
		List<IpoOrder> o = order.selectAll();
		for (int i = 0; i < o.size(); i++) {
			IpoOrder order = o.get(i);
			String sid = order.getCommodityid();
			String userid = order.getUserid();
			BigDecimal counts = order.getCounts();
			String sname = order.getCommodityname();
			int count = counts.intValue();

			// 获取记录表有无记录
			Integer a = unmberofrecord.selectbysid(sid);
			if (a == null) {
				// 更新记录表
				unmberofrecord.update(count, sid);
				// 插入ipodistribution表
				ipodistribution.setCommodityname(sname);
				Long in = (long) 10000001;
				// BigDecimal startnumber = new BigDecimal(10000001);
				ipodistribution.setStartnumber(in);
				ipodistribution.setUserid(userid);
				ipodistribution.setPcounts(count);
				Date date = new Date();
				ipodistribution.setPtime(date);
				distribution.insert(ipodistribution);

			} else if (a != null && a < 99999999) {

				int count1 = a++;
				unmberofrecord.update(count1, sid);
				ipodistribution.setCommodityname(sname);
				// BigDecimal startnumber = new BigDecimal(count1);
				Long startnumber = (long) count1;
				ipodistribution.setStartnumber(startnumber);
				ipodistribution.setUserid(userid);
				ipodistribution.setPcounts(count);
				Date date = new Date();
				ipodistribution.setPtime(date);
				distribution.insert(ipodistribution);
			} else {
				String str = count + "";
				StringBuffer str1 = new StringBuffer("111111");
				String str2 = (str1.append(str)).toString();
				int x = Integer.parseInt(str2);
				int count2 = x++;
				unmberofrecord.update(count2, sid);
				ipodistribution.setCommodityname(sname);
				// BigDecimal startnumber = new BigDecimal(count2);
				Long startnumber = (long) count2;
				ipodistribution.setStartnumber(startnumber);
				ipodistribution.setUserid(userid);
				ipodistribution.setPcounts(count);
				Date date = new Date();
				ipodistribution.setPtime(date);
				distribution.insert(ipodistribution);

			}

		}

		order.insertAll();
		order.deleatAll();

		unmberofrecord.insertAll();
		unmberofrecord.deleatAll();

	}
}
