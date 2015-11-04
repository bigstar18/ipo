package com.yrdce.ipo.common.task;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.TimerTask;

import com.yrdce.ipo.common.utils.DateUtil;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.service.Distribution;

/**
 * 定时器
 * 
 * @author Bob
 *
 */

public class DistributionTask extends TimerTask {

	private IpoOrderMapper order;

	@Override
	public void run() {
		IpoOrder o = order.selectByPrimaryKey("1");
		Timestamp time = o.getCreatetime();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String oldtime = formatter.format(time);
		// 获得系统当前时间的前一天
		String nowtime = DateUtil.getTime();
		if (nowtime.equals(oldtime)) {
			Distribution distribution = new Distribution();
			distribution.start();
		}
	}
}
