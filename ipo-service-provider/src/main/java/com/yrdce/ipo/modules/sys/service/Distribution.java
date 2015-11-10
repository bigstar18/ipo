package com.yrdce.ipo.modules.sys.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.common.utils.DateUtil;
import com.yrdce.ipo.modules.sys.dao.IpoDistributionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoNumberofrecordsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDistribution;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;

/**
 * 配号服务
 * 
 * @author Bob
 * 
 */
@Service
public class Distribution {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IpoOrderMapper order;
	@Autowired
	private IpoNumberofrecordsMapper unmberofrecord;
	@Autowired
	private IpoDistributionMapper distribution;

	// @Autowired
	// private GetBallotNoUtils getBallotNoUtils;

	private IpoDistribution ipodistribution = new IpoDistribution();

	@SuppressWarnings("unused")
	public void start() {
		// System.out.println("配号开始");

		// 获得系统当前时间的前一天
		String oldtime = DateUtil.getTime(1);

		// 获取系统前一天订单列表
		List<IpoOrder> o = order.selectAll(oldtime);
		if (o != null || o.size() > 0) {
			logger.info("获取前一天订单列表");
			for (int i = 0; i < o.size(); i++) {
				IpoOrder order1 = o.get(i);
				String sId = order1.getCommodityid();
				String userid = order1.getUserid();
				int counts = order1.getCounts();
				String sname = order1.getCommodityname();

				// 获取商品总配号数
				int sum = order.selectbysid(sId) + 10000000;
				// 获取记录表有无记录
				int a = unmberofrecord.selectbysid(sId);
				// 格局配号规则选择配号方式
				if (sum < 99999999) {
					int count1 = 0;
					if (a == 0) {
						System.out.println("3 - 1");
						// 更新记录表
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("counts", counts);
						map.put("commodityid", sId);
						unmberofrecord.update(map);
						// 插入ipodistribution表
						ipodistribution.setCommodityname(sname);
						long startNum = 10000001;
						ipodistribution.setStartnumber(startNum);
						ipodistribution.setUserid(userid);
						ipodistribution.setPcounts(counts);
						ipodistribution.setCommodityid(sId);
						Date date = new Date();
						ipodistribution.setPtime(date);
						distribution.insert(ipodistribution);

					} else {
						System.out.println("3 - 2");
						count1 = a + counts;
						System.out.println(count1);
						int count2 = a;
						System.out.println(count2);
						long startNum = 10000001 + count2;
						Map<String, Object> map = new HashMap<String, Object>();
						map.put("counts", count1);
						map.put("commodityid", sId);
						unmberofrecord.update(map);
						ipodistribution.setCommodityname(sname);
						ipodistribution.setStartnumber(startNum);
						ipodistribution.setUserid(userid);
						ipodistribution.setPcounts(counts);
						ipodistribution.setCommodityid(sId);
						Date date = new Date();
						ipodistribution.setPtime(date);
						distribution.insert(ipodistribution);
					}
				} else {
					int Record = 0;
					int Records = Record++;
					if (Records < 99999999) {
						if (a == 0) {
							System.out.println("4 - 1");
							// 更新记录表
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("counts", counts);
							map.put("commodityid", sId);
							unmberofrecord.update(map);
							// 插入ipodistribution表
							ipodistribution.setCommodityname(sname);
							String str1 = 10000001 + "";
							StringBuffer str2 = new StringBuffer("111111");
							String str3 = str2.append(str1).toString();
							long num = Long.parseLong(str3);
							ipodistribution.setStartnumber(num);
							ipodistribution.setUserid(userid);
							ipodistribution.setPcounts(counts);
							ipodistribution.setCommodityid(sId);
							Date date = new Date();
							ipodistribution.setPtime(date);
							distribution.insert(ipodistribution);

						} else {
							System.out.println("4 - 2");

							String str = 10000001 + "";
							StringBuffer str1 = new StringBuffer("111111");
							String str2 = (str1.append(str)).toString();
							long x = Long.parseLong(str2);
							int count3 = a + counts;
							long count2 = x + a;
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("counts", count3);
							map.put("commodityid", sId);
							unmberofrecord.update(map);
							ipodistribution.setCommodityname(sname);
							ipodistribution.setStartnumber(count2);
							ipodistribution.setUserid(userid);
							ipodistribution.setPcounts(counts);
							ipodistribution.setCommodityid(sId);
							Date date = new Date();
							ipodistribution.setPtime(date);
							distribution.insert(ipodistribution);
						}

					} else {
						if (a == 0) {
							System.out.println("5 - 1");

							// 更新记录表
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("counts", counts);
							map.put("commodityid", sId);
							unmberofrecord.update(map);

							// 插入ipodistribution表
							ipodistribution.setCommodityname(sname);
							String str1 = 10000001 + "";
							StringBuffer str2 = new StringBuffer("222222");
							String str3 = str2.append(str1).toString();
							long num = Long.parseLong(str3);
							ipodistribution.setStartnumber(num);
							ipodistribution.setUserid(userid);
							ipodistribution.setPcounts(counts);
							ipodistribution.setCommodityid(sId);
							Date date = new Date();
							ipodistribution.setPtime(date);
							distribution.insert(ipodistribution);

						} else {
							System.out.println("5 - 2");

							String str = 10000001 + "";
							StringBuffer str1 = new StringBuffer("222222");
							String str3 = (str1.append(str)).toString();
							long x = Long.parseLong(str3);
							int count4 = a + counts;
							long count3 = x + a;
							Map<String, Object> map = new HashMap<String, Object>();
							map.put("counts", count4);
							map.put("commodityid", sId);
							unmberofrecord.update(map);
							ipodistribution.setCommodityname(sname);
							ipodistribution.setStartnumber(count3);
							ipodistribution.setUserid(userid);
							ipodistribution.setPcounts(counts);
							ipodistribution.setCommodityid(sId);
							Date date = new Date();
							ipodistribution.setPtime(date);
							distribution.insert(ipodistribution);

						}

					}

				}
			}
		}

	}
}
