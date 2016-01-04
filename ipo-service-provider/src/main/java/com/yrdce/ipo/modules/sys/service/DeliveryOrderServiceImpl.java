package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esotericsoftware.minlog.Log;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryorderMapper;
import com.yrdce.ipo.modules.sys.dao.IpoExpressMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPickupMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;
import com.yrdce.ipo.modules.sys.entity.IpoExpress;
import com.yrdce.ipo.modules.sys.entity.IpoPickup;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
import com.yrdce.ipo.modules.sys.vo.Pickup;

@Service("deliveryorderservice")
public class DeliveryOrderServiceImpl implements DeliveryOrderService {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(DeliveryOrderServiceImpl.class);

	@Autowired
	private IpoDeliveryorderMapper deliveryordermapper;

	@Autowired
	private IpoExpressMapper ipoexpressmapper;

	@Autowired
	private IpoPickupMapper ipopickupmapper;

	public IpoDeliveryorderMapper getDeliveryordermapper() {
		return deliveryordermapper;
	}

	public void setDeliveryordermapper(
			IpoDeliveryorderMapper deliveryordermapper) {
		this.deliveryordermapper = deliveryordermapper;
	}

	public IpoExpressMapper getIpoexpressmapper() {
		return ipoexpressmapper;
	}

	public void setIpoexpressmapper(IpoExpressMapper ipoexpressmapper) {
		this.ipoexpressmapper = ipoexpressmapper;
	}

	public IpoPickupMapper getIpopickupmapper() {
		return ipopickupmapper;
	}

	public void setIpopickupmapper(IpoPickupMapper ipopickupmapper) {
		this.ipopickupmapper = ipopickupmapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<DeliveryOrder> queryAllDeliOrdersByPage(String page,
			String rows, DeliveryOrder deorder) {
		Log.info("分页模糊查询提货单服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoDeliveryorder record = new IpoDeliveryorder();
		if (deorder != null) {
			BeanUtils.copyProperties(deorder, record);
			List<IpoDeliveryorder> dorderslist = deliveryordermapper
					.queryAllDeliOrdersByPage((curpage - 1) * pagesize + 1,
							curpage * pagesize, record);
			List<DeliveryOrder> dorderslist2 = new ArrayList<DeliveryOrder>();
			for (int i = 0; i < dorderslist.size(); i++) {
				DeliveryOrder temp = new DeliveryOrder();
				BeanUtils.copyProperties(dorderslist.get(i), temp);
				dorderslist2.add(temp);
				Log.info(temp.toString());
			}
			return dorderslist2;
		}
		return null;

	}

	@Override
	public Integer getQueryNum(DeliveryOrder deorder) {
		IpoDeliveryorder order = new IpoDeliveryorder();
		if (deorder != null) {
			BeanUtils.copyProperties(deorder, order);
			return deliveryordermapper.getQueryNum(order);
		}
		return 0;
	}

	@Override
	public DeliveryOrder getDeliveryOrderByDeliOrderID(String deliOrderID) {
		Log.info("根据提货单号查询提货单");
		IpoDeliveryorder deorder = deliveryordermapper
				.selectByPrimaryKey(deliOrderID);
		if (deorder != null) {
			DeliveryOrder order = new DeliveryOrder();
			BeanUtils.copyProperties(deorder, order);
			return order;
		} else {
			return null;
		}
	}

	@Override
	@Transactional
	public String updateDeliveryOrder(DeliveryOrder order, Pickup pickup,
			String managerId) {
		Log.info("审核自提提货单服务");
		IpoDeliveryorder deorder = new IpoDeliveryorder();
		IpoPickup ipopickup = new IpoPickup();
		if (order != null) {
			if (pickup != null) {
				BeanUtils.copyProperties(order, deorder);
				BeanUtils.copyProperties(pickup, ipopickup);
				deorder.setApproveDate(new Date());
				deorder.setApprovers(managerId);
				int onum = deliveryordermapper.updateByPrimaryKey(deorder);
				if (order.getApprovalStatus() == 2) {
					ipopickup.setPickupPassword(genRandomNum());
					ipopickupmapper.updateByPrimaryKey(ipopickup);
				}
				if (onum != 0) {
					return "已审核";
				}
			}
		}
		return "审核失败";
	}

	@Override
	@Transactional
	public String updateDeliveryOrder(DeliveryOrder order, Express express,
			String managerId) {
		Log.info("审核配送提货单服务");
		IpoDeliveryorder deorder = new IpoDeliveryorder();
		IpoExpress ipoexpress = new IpoExpress();
		if (order != null) {
			if (express != null) {
				BeanUtils.copyProperties(order, deorder);
				BeanUtils.copyProperties(express, ipoexpress);
				deorder.setApproveDate(new Date());
				deorder.setApprovers(managerId);
				int onum = deliveryordermapper.updateByPrimaryKey(deorder);
				if (order.getApprovalStatus() == 2) {
					ipoexpressmapper.updateByPrimaryKey(ipoexpress);
				}
				if (onum != 0) {
					return "已审核";
				}
			}
		}
		return "审核失败";
	}

	@Override
	public Pickup getPickUpDetail(String pickUpId) {
		Pickup pickup = new Pickup();
		IpoPickup detail = ipopickupmapper.selectByPrimaryKey(pickUpId);
		if (detail != null) {
			BeanUtils.copyProperties(detail, pickup);
			return pickup;
		}
		return null;
	}

	@Override
	public Express getExpressDetail(String expressId) {
		Express express = new Express();
		IpoExpress detail = ipoexpressmapper.selectByPrimaryKey(expressId);
		if (detail != null) {
			BeanUtils.copyProperties(detail, express);
			return express;
		}
		return null;
	}

	@Override
	public List<DeliveryOrder> cancelDeliOrdersByPage(String page, String rows) {
		Log.info("分页查询可撤销提货单服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoDeliveryorder> dorderslist = deliveryordermapper
				.cancelDeliOrdersByPage((curpage - 1) * pagesize + 1, curpage
						* pagesize);
		List<DeliveryOrder> dorderslist2 = new ArrayList<DeliveryOrder>();
		for (int i = 0; i < dorderslist.size(); i++) {
			DeliveryOrder temp = new DeliveryOrder();
			BeanUtils.copyProperties(dorderslist.get(i), temp);
			dorderslist2.add(temp);
			Log.info(temp.toString());
		}
		return dorderslist2;
	}

	@Override
	public Integer getCancelNum() {
		return deliveryordermapper.getCancelNum();
	}

	@Override
	public String cancelDeorder(String deOrderId, String cancellId) {
		deliveryordermapper.cancelDeorder(deOrderId, cancellId);
		IpoDeliveryorder deorder = deliveryordermapper
				.selectByPrimaryKey(deOrderId);
		if (deorder != null) {
			Integer status = deorder.getApprovalStatus();
			if (status == 7) {
				return "撤销成功";
			}
		}
		return "撤销失败";
	}

	@Override
	public List<DeliveryOrder> queryCancelDeliOrdersByPage(String page,
			String rows, DeliveryOrder deorder) {
		Log.info("分页模糊查询提货单服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		IpoDeliveryorder record = new IpoDeliveryorder();
		if (deorder != null) {
			BeanUtils.copyProperties(deorder, record);
			List<IpoDeliveryorder> dorderslist = deliveryordermapper
					.queryCancelDeliOrdersByPage((curpage - 1) * pagesize + 1,
							curpage * pagesize, record);
			List<DeliveryOrder> dorderslist2 = new ArrayList<DeliveryOrder>();
			for (int i = 0; i < dorderslist.size(); i++) {
				DeliveryOrder temp = new DeliveryOrder();
				BeanUtils.copyProperties(dorderslist.get(i), temp);
				dorderslist2.add(temp);
				Log.info(temp.toString());
			}
			return dorderslist2;
		}
		return null;
	}

	@Override
	public Integer getQueryCancelNum(DeliveryOrder deorder) {
		IpoDeliveryorder order = new IpoDeliveryorder();
		if (deorder != null) {
			BeanUtils.copyProperties(deorder, order);
			return deliveryordermapper.getQueryCancelNum(order);
		}
		return null;
	}

	public String genRandomNum() {
		final int maxNum = 36;
		int i;
		int count = 0;
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < 9) {
			i = Math.abs(r.nextInt(maxNum));
			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}
		return pwd.toString();
	}

	/**
	 * li
	 * 
	 */
	@Override
	public DeliveryOrder getPickupDeliveryInfo(DeliveryOrder order) {
		IpoDeliveryorder delivery = new IpoDeliveryorder();
		DeliveryOrder deliveryOrder = new DeliveryOrder();
		BeanUtils.copyProperties(order, delivery);
		IpoDeliveryorder temporder = deliveryordermapper
				.getPickupDeliveryInfo(delivery);
		if (temporder != null) {
			BeanUtils.copyProperties(temporder, deliveryOrder);
		}
		return deliveryOrder;
	}

	@Override
	public DeliveryOrder getExpressDeliveryInfo(DeliveryOrder order) {
		// TODO Auto-generated method stub
		IpoDeliveryorder delivery = new IpoDeliveryorder();
		DeliveryOrder deliveryOrder = new DeliveryOrder();

		BeanUtils.copyProperties(order, delivery);
		IpoDeliveryorder temporder = deliveryordermapper
				.getExpressDeliveryInfo(delivery);
		if (temporder != null) {
			BeanUtils.copyProperties(temporder, deliveryOrder);
		}
		return deliveryOrder;
	}

}
