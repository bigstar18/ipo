package com.yrdce.ipo.modules.sys.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
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
public class OrderServiceImpl implements OrderService {

	static org.slf4j.Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private IpoOrderMapper ipoOrderMapper;

	@Override
	@Transactional(readOnly = true)
	public List<Order> getOrderInfo(String page, String rows, String userId) throws Exception {
		logger.info("根据id进入分页查询订单表");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<Order> list2 = new ArrayList<Order>();
		List<IpoOrder> list = ipoOrderMapper.selectByUserId((curpage - 1) * pagesize + 1, curpage * pagesize, userId);

		for (int i = 0; i < list.size(); i++) {
			Order order = new Order();
			order.setOrderid(list.get(i).getOrderid());
			order.setUserid(list.get(i).getUserid());
			order.setCommodityid(list.get(i).getCommodityid());
			order.setCommodityname(list.get(i).getCommodityname());
			order.setCounts(list.get(i).getCounts());
			Timestamp timestamp = list.get(i).getCreatetime();
			Date date = new Date(timestamp.getTime());
			order.setCreatetime(date);
			order.setFrozenfunds(list.get(i).getFrozenfunds());
			logger.info(order.toString());
			list2.add(order);
		}
		return list2;
	}

	@Override
	@Transactional(readOnly = true)
	public int getAll(String userid) throws Exception {
		logger.info("根据id查询共有几条订单信息");
		return ipoOrderMapper.selectByCounts(userid);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Order> getOrder(String page, String rows) throws Exception {
		logger.info("分页查询订单信息");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<Order> list2 = new ArrayList<Order>();
		List<IpoOrder> list = ipoOrderMapper.selectByPage((curpage - 1) * pagesize + 1, curpage * pagesize);

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
		return list2;
	}

	@Override
	@Transactional(readOnly = true)
	public int getAllOrder() throws Exception {
		logger.info("查询共有几条记录");

		int counts = ipoOrderMapper.selectByCounts(null);
		return counts;

	}

	@Override
	public List<Order> queryUnsettleOrdersByCommId(String commId) throws Exception {
		List<Order> result = new ArrayList<Order>();

		logger.info("申购结算：根据商品id={} and frozenst=0，查询发售记录", commId);
		List<IpoOrder> list = ipoOrderMapper.selectByCidPaged(0, 500, commId);
		if (list != null && !list.isEmpty()) {
			for (int i = 0; i < list.size(); i++) {
				Order order = new Order();
				order.setOrderid(list.get(i).getOrderid());
				order.setUserid(list.get(i).getUserid());
				order.setCommodityid(list.get(i).getCommodityid());
				order.setCommodityname(list.get(i).getCommodityname());
				order.setCounts(list.get(i).getCounts());
				Timestamp timestamp = list.get(i).getCreatetime();
				Date date = new Date(timestamp.getTime());
				order.setCreatetime(date);
				order.setFrozenfunds(list.get(i).getFrozenfunds());
				order.setFrozencounterfee(list.get(i).getFrozencounterfee());
				// 坑货啊
				result.add(order);
			}
		} else
			logger.info("申购结算：没有获得发售商品id={} 的申购记录", commId);

		return result;
	}

	@Override
	public int updateOrderSettled(String orderid) throws Exception {
		return ipoOrderMapper.updateByOrderId(1, orderid);
	}

}
