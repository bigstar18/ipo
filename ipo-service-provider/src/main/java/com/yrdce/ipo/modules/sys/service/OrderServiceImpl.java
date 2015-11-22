package com.yrdce.ipo.modules.sys.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.vo.Order;

/**
 * 订单查询
 * 
 * @author Bob
 * 
 */
@Service("orderService")
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

	static Logger logger = Logger.getLogger(OrderServiceImpl.class);

	@Autowired
	private IpoOrderMapper ipoOrderMapper;

	@Override
	public List<Order> getOrderInfo(String page, String rows, String userId) {
		logger.info("根据id进入分页查询订单表");

		List<Order> list2 = null;
		try {
			page = (page == null ? "1" : page);
			rows = (rows == null ? "5" : rows);
			int curpage = Integer.parseInt(page);
			int pagesize = Integer.parseInt(rows);

			List<IpoOrder> list = new ArrayList<IpoOrder>();
			list2 = new ArrayList<Order>();

			list = ipoOrderMapper.selectByUserId((curpage - 1) * pagesize + 1, curpage * pagesize, userId);

			for (int i = 0; i < list.size(); i++) {
				Order order = new Order();
				order.setCommodityid(list.get(i).getCommodityid());
				order.setCommodityname(list.get(i).getCommodityname());
				order.setCounts(list.get(i).getCounts());
				Timestamp timestamp = list.get(i).getCreatetime();
				Date date = new Date(timestamp.getTime());
				order.setCreatetime(date);
				order.setFrozenfunds(list.get(i).getFrozenfunds());
				list2.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list2;
	}

	@Override
	public int getAll(String userid) {
		logger.info("根据id查询共有几条订单信息");
		try {
			return ipoOrderMapper.countByExample(userid);
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<Order> getOrder(String page, String rows) {
		logger.info("分页查询订单信息");
		List<Order> list2 = null;
		try {
			page = (page == null ? "1" : page);
			rows = (rows == null ? "5" : rows);
			int curpage = Integer.parseInt(page);
			int pagesize = Integer.parseInt(rows);

			List<IpoOrder> list = new ArrayList<IpoOrder>();
			list2 = new ArrayList<Order>();

			list = ipoOrderMapper.selectByPage((curpage - 1) * pagesize + 1, curpage * pagesize);

			for (int i = 0; i < list.size(); i++) {
				Order order = new Order();
				order.setCommodityid(list.get(i).getCommodityid());
				order.setCommodityname(list.get(i).getCommodityname());
				order.setCounts(list.get(i).getCounts());
				Timestamp timestamp = list.get(i).getCreatetime();
				Date date = new Date(timestamp.getTime());
				order.setCreatetime(date);
				order.setFrozenfunds(list.get(i).getFrozenfunds());
				order.setUserid(list.get(i).getUserid());
				list2.add(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list2;
	}

	@Override
	public int getAllOrder() {
		logger.info("查询共有几条记录");

		int counts = ipoOrderMapper.selectByCounts();
		return counts;

	}

}
