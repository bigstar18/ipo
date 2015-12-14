package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esotericsoftware.minlog.Log;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryorderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;

@Service("deliveryorderservice")
public class DeliveryOrderServiceImpl implements DeliveryOrderService {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(DeliveryOrderServiceImpl.class);

	@Autowired
	private IpoDeliveryorderMapper deliveryordermapper;

	public IpoDeliveryorderMapper getDeliveryordermapper() {
		return deliveryordermapper;
	}

	public void setDeliveryordermapper(
			IpoDeliveryorderMapper deliveryordermapper) {
		this.deliveryordermapper = deliveryordermapper;
	}

	@Override
	public List<DeliveryOrder> findAllDeliOrdersByPage(String page,
			String rows, DeliveryOrder deorder) {
		Log.info("分页查询提货单服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoDeliveryorder record = new IpoDeliveryorder();
		if (deorder != null) {
			BeanUtils.copyProperties(deorder, record);
		}
		List<IpoDeliveryorder> dorderslist = deliveryordermapper
				.findAllDeliOrdersByPage((curpage - 1) * pagesize + 1, curpage
						* pagesize, record);
		List<DeliveryOrder> dorderslist2 = new ArrayList<DeliveryOrder>();
		for (int i = 0; i < dorderslist.size(); i++) {
			DeliveryOrder temp = new DeliveryOrder();
			BeanUtils.copyProperties(dorderslist.get(i), temp);
			dorderslist2.add(temp);
		}
		return dorderslist2;

	}

	@Override
	public Integer getTotalNum(DeliveryOrder deorder) {
		IpoDeliveryorder order = new IpoDeliveryorder();
		if (deorder != null) {
			BeanUtils.copyProperties(deorder, order);
		}
		return deliveryordermapper.getTotalNum(order);
	}

	@Override
	public List<DeliveryOrder> approveDeliOrdersByPage(String page, String rows) {
		Log.info("分页查询待审核提货单服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoDeliveryorder> dorderslist = deliveryordermapper
				.approveDeliOrdersByPage((curpage - 1) * pagesize + 1, curpage
						* pagesize);
		List<DeliveryOrder> dorderslist2 = new ArrayList<DeliveryOrder>();
		for (int i = 0; i < dorderslist.size(); i++) {
			DeliveryOrder temp = new DeliveryOrder();
			BeanUtils.copyProperties(dorderslist.get(i), temp);
			dorderslist2.add(temp);
		}
		return dorderslist2;
	}

	@Override
	public Integer getApproveNum() {
		return deliveryordermapper.getApproveNum();
	}

	@Override
	public DeliveryOrder getDeliveryOrderByDeliOrderID(String deliOrderID) {
		Log.info("根据提货单号查询提货单");
		IpoDeliveryorder deorder = deliveryordermapper.selectByPrimaryKey(Long
				.parseLong(deliOrderID));
		if (deorder != null) {
			DeliveryOrder order = new DeliveryOrder();
			BeanUtils.copyProperties(deorder, order);
			return order;
		} else {
			return null;
		}
	}

	@Override
	public String updateDeliveryOrder(DeliveryOrder order) {
		Log.info("审核提货单");
		IpoDeliveryorder deorder = new IpoDeliveryorder();
		if (order != null) {
			BeanUtils.copyProperties(order, deorder);
			int num = deliveryordermapper.updateByPrimaryKey(deorder);
			if (num != 0) {
				return "已审核";
			}
		}
		return "审核失败";
	}

}
