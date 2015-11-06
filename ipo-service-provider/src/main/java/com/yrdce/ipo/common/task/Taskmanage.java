package com.yrdce.ipo.common.task;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yrdce.ipo.common.utils.DateUtil;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.service.Distribution;
import com.yrdce.ipo.modules.sys.service.PurchaseImpl;

/**
 * 定时器
 * 
 * @author Bob
 *
 */
@Component
public class Taskmanage extends TimerTask {
	@Autowired
	private IpoOrderMapper order;
	@Autowired
	private Distribution distribution;
	@Autowired
	private PurchaseImpl p;

	@Override
	public void run() {
		// 查询第一笔交易订单时间
		IpoOrder o = order.selectByPrimaryKey(1);
		System.out.println("第一个查询");
		if (o != null) {
			Timestamp time = o.getCreatetime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String oldtime = formatter.format(time);
			// 获得系统当前时间的前一天
			String nowtime = DateUtil.getTime(1);
			if (nowtime.equals(oldtime)) {
				distribution.start();
				// System.out.println("配号任务开始");

			}
		}
	}
}
