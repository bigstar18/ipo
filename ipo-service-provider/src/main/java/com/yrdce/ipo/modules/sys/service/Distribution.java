package com.yrdce.ipo.modules.sys.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
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
	@Autowired
	private IpoCommodityMapper commodity;

	private IpoDistribution ipodistribution = new IpoDistribution();

	@SuppressWarnings("unused")
	@Transactional
	public void start(List<IpoOrder> orderList) throws Exception {
		// 获得系统当前时间的前一天
		// String oldtime = DateUtil.getTime(1);

		// 获取系统前一天订单列表
		// List<IpoOrder> orderList = order.selectAll(oldtime);
		if (orderList != null || orderList.size() > 0) {
			logger.info("获取前一天订单列表");
			for (int i = 0; i < orderList.size(); i++) {
				IpoOrder order1 = orderList.get(i);
				String sId = order1.getCommodityid();
				String userid = order1.getUserid();
				int counts = order1.getCounts();
				String sname = order1.getCommodityname();

				// 获取商品总配号数
				int sum = order.selectbysid(sId) + 10000000;
				// 获取记录表有无记录
				int all = unmberofrecord.selectbysid(sId);
				// 格局配号规则选择配号方式
				if (sum < 99999999) {
					if (all == 0) {
						System.out.println("3 - 1");
						int allCounts = 0;
						long startNum = 10000001;
						// 更新数据
						this.updateTable(allCounts, sId, sname, startNum, userid, counts);
					} else {
						System.out.println("3 - 2");
						int allCounts = all + counts;
						System.out.println(allCounts);
						long startNum = 10000001 + all;
						// 更新数据
						this.updateTable(allCounts, sId, sname, startNum, userid, counts);

					}
				} else {
					int Record = 0;
					int Records = Record++;
					if (Records < 99999999) {
						if (all == 0) {
							System.out.println("4 - 1");
							// 更新记录表
							String str1 = 10000001 + "";
							StringBuffer str2 = new StringBuffer("111111");
							String str3 = str2.append(str1).toString();
							long startNum = Long.parseLong(str3);
							// 更新数据
							this.updateTable(counts, sId, sname, startNum, userid, counts);

						} else {
							System.out.println("4 - 2");

							String str = 10000001 + "";
							StringBuffer str1 = new StringBuffer("111111");
							String str2 = (str1.append(str)).toString();
							long serialNumber = Long.parseLong(str2);
							int allCounts = all + counts;
							long startNum = serialNumber + all;
							// 更新数据
							this.updateTable(allCounts, sId, sname, startNum, userid, counts);

						}

					} else {
						if (all == 0) {
							System.out.println("5 - 1");

							String str1 = 10000001 + "";
							StringBuffer str2 = new StringBuffer("222222");
							String str3 = str2.append(str1).toString();
							long startNum = Long.parseLong(str3);
							// 更新数据
							this.updateTable(counts, sId, sname, startNum, userid, counts);

						} else {
							System.out.println("5 - 2");

							String str = 10000001 + "";
							StringBuffer str1 = new StringBuffer("222222");
							String str3 = (str1.append(str)).toString();
							long serialNumber = Long.parseLong(str3);
							int allCounts = all + counts;
							long startNum = serialNumber + all;
							// 更新数据
							this.updateTable(allCounts, sId, sname, startNum, userid, counts);

						}

					}

				}
				// 更新商品状态
				// 1：配号成功
				// 2：摇号成功
				// 3：结算成功
				commodity.updateByStatus(1, sId);
			}
			// 删除配号临时表
			unmberofrecord.deleteAll();
		}

	}

	public void updateTable(int allCounts, String sId, String sname, long num, String userId, int counts) {
		// 更新配号临时表
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("counts", allCounts);
		map.put("commodityid", sId);
		unmberofrecord.update(map);
		// 插入更新数据
		ipodistribution.setCommodityname(sname);
		ipodistribution.setStartnumber(num);
		ipodistribution.setUserid(userId);
		ipodistribution.setPcounts(counts);
		ipodistribution.setCommodityid(sId);
		Date date = new Date();
		ipodistribution.setPtime(date);
		distribution.insert(ipodistribution);
	}
}
