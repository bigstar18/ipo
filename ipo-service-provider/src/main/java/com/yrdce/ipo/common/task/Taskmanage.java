package com.yrdce.ipo.common.task;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yrdce.ipo.common.utils.DateUtil;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoNumberofrecordsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoNumberofrecords;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.service.Distribution;
import com.yrdce.ipo.modules.sys.service.GetBallotNoUtils;

/**
 * 定时器
 * 
 * @author Bob
 * 
 */
@Component
public class Taskmanage extends TimerTask {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	private IpoNumberofrecords frecord;
	@Autowired
	private IpoOrderMapper order;
	@Autowired
	private Distribution distribution;
	@Autowired
	private GetBallotNoUtils getBallotNoUtils;
	@Autowired
	private IpoNumberofrecordsMapper unmberofrecord;
	@Autowired
	private IpoCommodityMapper commodity;

	@Override
	public void run() {
		try {
			// 获得系统当前时间的前一天
			String oldtime = DateUtil.getTime(1);
			// 已截至日期为依据取发售表商品
			List<IpoCommodity> commod = commodity.selectByEnd(oldtime);
			for (IpoCommodity com : commod) {
				int id = Integer.parseInt(com.getId());
				List<IpoOrder> o = new ArrayList<IpoOrder>();
				o = order.selectByCid(id);

				// 查询前一天交易订单
				// List<IpoOrder> o = order.selectAll(oldtime);

				if (o != null && o.size() != 0) {
					// for(int z= 0;z<o.size();z++){
					// IpoOrder order1 = o.get(0);
					// Timestamp time = order1.getCreatetime();
					// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					// String nowtime = formatter.format(time);
					// 获得系统当前时间的前一天
					// logger.info("系统时间：" + oldtime, "表时间：" + nowtime);
					// 去重
					List<String> list = order.select(id);
					logger.info("复制插入商品id");
					for (int i = 0; i < list.size(); i++) {
						frecord = new IpoNumberofrecords();
						String sid = list.get(i);
						Date date = new Date();
						frecord.setCommodityid(sid);
						frecord.setCounts(BigDecimal.valueOf(0));
						frecord.setNowtime(date);
						unmberofrecord.insert(frecord);
					}

					// 配号任务开始
					distribution.start(o);
				}
			}

			// 摇号获取系统当前时间的前2天
			String ballotNowtime = DateUtil.getTime(2);
			// // 查询前一天交易订单
			List<IpoCommodity> commod2 = commodity.selectByEnd(ballotNowtime);
			if (commod2 != null && commod2.size() > 0) {
				// // 摇号处理开始
				getBallotNoUtils.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
