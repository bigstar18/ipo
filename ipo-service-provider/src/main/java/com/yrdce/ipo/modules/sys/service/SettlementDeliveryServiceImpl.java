package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import com.alibaba.dubbo.config.annotation.Service;
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
@Service()
public class SettlementDeliveryServiceImpl implements SettlementDeliveryService {

	static Logger logger = LoggerFactory.getLogger(SettlementDeliveryServiceImpl.class);

	// 自提申请
	@Override
	public String applicationByPickup(Pickup pickup) throws Exception {
		logger.info("自提申请");
		IpoPickup ipoPickup = new IpoPickup();
		BeanUtils.copyProperties(pickup, ipoPickup);

		return "success";
	}

	// 在线配送申请
	@Override
	public String applicationByexpress(Express express) throws Exception {
		logger.info("在线配送申请");
		return "success";
	}

	// 自提打印
	@Override
	public List<DeliveryOrder> getApplication(String page, String rows, String userid) throws Exception {
		logger.info("自提打印");
		return null;
	}

	// 自提信息信息
	@Override
	public Pickup getDetail() throws Exception {
		logger.info("自提信息信息");
		return null;
	}

	// 撤销申请
	@Override
	public String getRevocation() throws Exception {
		logger.info("撤销申请");
		return null;
	}

	// 在线配送
	@Override
	public List<Express> getListByExpress(String page, String rows, String userid) throws Exception {
		logger.info("在线配送");
		return null;
	}

	// 在线配送详细信息
	@Override
	public String confirm() {
		logger.info("在线配送详细信息");
		return "success";
	}

	// 提货查询
	@Override
	public List<DeliveryOrder> getListByOrder(String page, String rows, String userid) throws Exception {
		logger.info("提货查询");
		return null;
	}

	// 提货查询(自提)详细信息
	@Override
	public Pickup getDetailByPickup(long methodid) throws Exception {
		logger.info("提货查询(自提)详细信息");
		return null;
	}

	// 提货查询(在线配送)详细信息
	@Override
	public Express getDetailByExpress(long methodid) throws Exception {
		logger.info("提货查询(在线配送)详细信息");
		return null;
	}

	// 费用查询
	@Override
	public List<DeliveryCost> getListByDeliveryCost(String page, String rows, String userid) throws Exception {
		logger.info("费用查询");
		return null;
	}

}
