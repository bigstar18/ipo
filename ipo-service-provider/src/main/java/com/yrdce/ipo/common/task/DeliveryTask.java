package com.yrdce.ipo.common.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yrdce.ipo.modules.sys.dao.IpoDeliveryorderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;

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

	SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	/**
	 * @Title: cancellation
	 * @Description: 查询出库前的所有订单过了提货日期修改为失效
	 */
	public void cancellation() {
		List<IpoDeliveryorder> list = ipoDeliveryorderMapper.selectAllByStatus();
		if (list.size() != 0) {
			for (IpoDeliveryorder ipoDeliveryorder : list) {
				int deliveryDate = Integer.parseInt(sdf.format(ipoDeliveryorder.getDeliveryDate()));
				int nowTime = Integer.parseInt(sdf.format(new Date()));
				if (deliveryDate < nowTime) {
					String id = ipoDeliveryorder.getDeliveryorderId();
					ipoDeliveryorderMapper.updateByStatus(id, 10);
				}
			}
		}

	}
}
