package com.yrdce.ipo.modules.sys.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryCostMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryorderMapper;
import com.yrdce.ipo.modules.sys.dao.IpoExpressMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPickupMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;
import com.yrdce.ipo.modules.sys.entity.IpoExpress;
import com.yrdce.ipo.modules.sys.entity.IpoExpressExtended;
import com.yrdce.ipo.modules.sys.entity.IpoPickup;
import com.yrdce.ipo.modules.sys.vo.DeliveryCost;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
import com.yrdce.ipo.modules.sys.vo.Pickup;

/**
 * 交收提货
 * 
 * @author Bob
 *
 */
@Service
public class SettlementDeliveryServiceImpl implements SettlementDeliveryService {

	static Logger logger = LoggerFactory.getLogger(SettlementDeliveryServiceImpl.class);

	@Autowired
	private IpoPickupMapper ipoPickupMapper;
	@Autowired
	private IpoDeliveryorderMapper ipoDeliveryorderMapper;
	@Autowired
	private IpoExpressMapper ipoExpressMapper;
	@Autowired
	private IpoDeliveryCostMapper ipoDeliveryCostMapper;

	// 自提申请
	@Override
	@Transactional
	public String applicationByPickup(Pickup pickup) throws Exception {
		logger.info("自提申请");
		// 自提表
		IpoPickup ipoPickup = new IpoPickup();
		BeanUtils.copyProperties(pickup, ipoPickup);
		ipoPickupMapper.insert(ipoPickup);
		String pickupId = ipoPickup.getPickupId();

		// 提货单表
		IpoDeliveryorder ipoDeliveryorder = new IpoDeliveryorder();
		BeanUtils.copyProperties(pickup, ipoDeliveryorder);
		ipoDeliveryorder.setApprovalStatus(1);
		ipoDeliveryorder.setMethodId(pickupId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String id1 = sdf.format(new Date());
		String id2 = String.valueOf(ipoDeliveryorderMapper.sequence());
		String primaryKey = id1 + id2;
		ipoDeliveryorder.setDealerId(primaryKey);
		ipoDeliveryorderMapper.insert(ipoDeliveryorder);
		return "success";
	}

	// 在线配送申请
	@Override
	@Transactional
	public String applicationByexpress(Express express) throws Exception {
		logger.info("在线配送申请");
		// 在线配送
		IpoExpress ipoExpress = new IpoExpress();
		BeanUtils.copyProperties(express, ipoExpress);
		ipoExpressMapper.insert(ipoExpress);
		String expressId = ipoExpress.getExpressId();

		// 提货单表
		IpoDeliveryorder ipoDeliveryorder = new IpoDeliveryorder();
		BeanUtils.copyProperties(express, ipoDeliveryorder);
		ipoDeliveryorder.setApprovalStatus(1);
		ipoDeliveryorder.setMethodId(expressId);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String id1 = sdf.format(new Date());
		String id2 = String.valueOf(ipoDeliveryorderMapper.sequence());
		String primaryKey = id1 + id2;
		ipoDeliveryorder.setDealerId(primaryKey);
		ipoDeliveryorderMapper.insert(ipoDeliveryorder);
		return "success";
	}

	// 自提打印
	@Override
	public List<DeliveryOrder> getApplication(String page, String rows, String userid) throws Exception {
		logger.info("自提打印");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoDeliveryorder> list1 = ipoDeliveryorderMapper.selectByPickup((curpage - 1) * pagesize + 1, curpage * pagesize, userid);
		List<DeliveryOrder> list2 = new ArrayList<DeliveryOrder>();
		if (list1.size() != 0) {
			for (IpoDeliveryorder ipoDeliveryorder : list1) {
				DeliveryOrder deliveryOrder = new DeliveryOrder();
				BeanUtils.copyProperties(ipoDeliveryorder, deliveryOrder);
				list2.add(deliveryOrder);
			}
			return list2;
		}
		return null;
	}

	// 自提详细信息
	@Override
	public Pickup getDetail(String methodid, String deliveryorderid) throws Exception {
		logger.info("自提信息信息");
		IpoPickup ipoPickup = ipoPickupMapper.selectPickuoAndCost(methodid, deliveryorderid);
		Pickup pickup = new Pickup();
		BeanUtils.copyProperties(ipoPickup, pickup);
		return pickup;
	}

	// 撤销申请
	@Override
	@Transactional
	public String getRevocation(String deliveryorderid) throws Exception {
		logger.info("撤销申请");
		ipoDeliveryorderMapper.updateByStatus(deliveryorderid, 5);
		return "success";
	}

	// 在线配送
	@Override
	public List<Express> getListByExpress(String page, String rows, String userid) throws Exception {
		logger.info("在线配送");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoExpressExtended> list1 = ipoDeliveryorderMapper.selectByExpress((curpage - 1) * pagesize + 1, curpage * pagesize, userid);
		List<Express> list2 = new ArrayList<Express>();
		if (list1.size() != 0) {
			for (IpoExpressExtended ipoExpressExtended : list1) {
				Express express = new Express();
				BeanUtils.copyProperties(ipoExpressExtended, express);
				list2.add(express);
			}
			return list2;
		}
		return null;
	}

	// 在线配送详细信息
	@Override
	public Express confirm(String methodid, String deliveryorderid) throws Exception {
		logger.info("在线配送详细信息");
		IpoExpress ipoExpress = ipoExpressMapper.selectExpressAndCost(methodid, deliveryorderid);
		Express express = new Express();
		BeanUtils.copyProperties(ipoExpress, express);
		return express;
	}

	// 提货查询
	@Override
	public List<DeliveryOrder> getListByOrder(String page, String rows, String userid) throws Exception {
		logger.info("提货查询");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		List<IpoDeliveryorder> list1 = ipoDeliveryorderMapper.selectByUserid((curpage - 1) * pagesize + 1, curpage * pagesize, userid);
		List<DeliveryOrder> list2 = new ArrayList<DeliveryOrder>();
		if (list1.size() != 0) {
			for (IpoDeliveryorder ipoDeliveryorder : list1) {
				DeliveryOrder deliveryOrder = new DeliveryOrder();
				BeanUtils.copyProperties(ipoDeliveryorder, deliveryOrder);
				list2.add(deliveryOrder);
			}
			return list2;
		}
		return null;
	}

	// 提货查询(自提)详细信息<暂不用>
	@Override
	public Pickup getDetailByPickup(String methodid) throws Exception {
		logger.info("提货查询(自提)详细信息");
		IpoPickup ipoPickup = ipoPickupMapper.selectByPrimaryKey(methodid);
		Pickup pickup = new Pickup();
		BeanUtils.copyProperties(ipoPickup, pickup);
		return pickup;
	}

	// 提货查询(在线配送)详细信息<暂不用>
	@Override
	public Express getDetailByExpress(String methodid) throws Exception {
		logger.info("提货查询(在线配送)详细信息");
		IpoExpress ipoExpress = ipoExpressMapper.selectByPrimaryKey(methodid);
		Express express = new Express();
		BeanUtils.copyProperties(ipoExpress, express);
		return express;
	}

	// 费用查询
	@Override
	public List<DeliveryCost> getListByDeliveryCost(String page, String rows, String userid) throws Exception {
		logger.info("费用查询");

		return null;
	}

}
