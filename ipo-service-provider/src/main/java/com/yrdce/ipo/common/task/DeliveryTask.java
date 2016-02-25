package com.yrdce.ipo.common.task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.yrdce.ipo.common.constant.DeliveryConstant;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryorderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;
import com.yrdce.ipo.modules.sys.service.DeliveryOrderService;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;

/**
 * 
 * @ClassName: DeliveryTask
 * @Description: 交收业务中的定时任务
 * @author bob
 */
public class DeliveryTask {
	static Logger logger = LoggerFactory.getLogger(DeliveryTask.class);

	@Autowired
	private IpoDeliveryorderMapper ipoDeliveryorderMapper;
	@Autowired
	@Qualifier("deliveryorderservice")
	private DeliveryOrderService deliveryorderservice;

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	/**
	 * @Title: cancellation
	 * @Description: 查询出库前的所有订单过了提货日期修改为失效
	 */
	public void cancellation() {
		List<String> statusList = new ArrayList<String>();
		statusList.add(DeliveryConstant.StatusType.REGISTER.getCode());
		statusList.add(DeliveryConstant.StatusType.MARKETPASS.getCode());
		statusList.add(DeliveryConstant.StatusType.PRINTED.getCode());
		statusList.add(DeliveryConstant.StatusType.EXPRESSCOSTSET.getCode());
		List<IpoDeliveryorder> list = ipoDeliveryorderMapper.selectAllByStatus(statusList);
		if (list.size() != 0) {
			for (IpoDeliveryorder ipoDeliveryorder : list) {
				int deliveryDate = Integer.parseInt(sdf.format(ipoDeliveryorder.getDeliveryDate()));
				int nowTime = Integer.parseInt(sdf.format(new Date()));
				if (deliveryDate < nowTime) {
					String id = ipoDeliveryorder.getDeliveryorderId();
					String status = ipoDeliveryorder.getApprovalStatus();
					if (status.equals(DeliveryConstant.StatusType.MARKETPASS.getCode())) {
						DeliveryOrder deliveryOrder = new DeliveryOrder();
						BeanUtils.copyProperties(ipoDeliveryorder, deliveryOrder);
						deliveryorderservice.unfrozenStock(deliveryOrder);
					}
					ipoDeliveryorderMapper.updateByStatus(id, DeliveryConstant.StatusType.CANCEL.getCode());
				}
			}
		}
	}
}
