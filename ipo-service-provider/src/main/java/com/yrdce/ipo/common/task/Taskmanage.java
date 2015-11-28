package com.yrdce.ipo.common.task;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yrdce.ipo.common.utils.DateUtil;
import com.yrdce.ipo.common.utils.Selection;
import com.yrdce.ipo.modules.sys.dao.IpoBallotNoInfoMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDistributionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoNumberofrecordsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoBallotNoInfo;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoDistribution;
import com.yrdce.ipo.modules.sys.entity.IpoNumberofrecords;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.service.Distribution;

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
	// @Autowired
	// private GetBallotNoUtils getBallotNoUtils;
	private Selection selection;
	@Autowired
	private IpoNumberofrecordsMapper unmberofrecord;
	@Autowired
	private IpoCommodityMapper commodity;
	@Autowired
	private IpoDistributionMapper ipoDistribution;
	@Autowired
	private IpoBallotNoInfoMapper ipoBallotNoInfoMapper;

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

				List<IpoCommodity> ipoCommList = commodity.selectByEnd(ballotNowtime);
				if (ipoCommList == null)
					return;
				selection = new Selection();
				for (IpoCommodity ipoComm : ipoCommList) {
					String commId = ipoComm.getCommodityid();// 获取需要摇号的商品id
					int commCounts = ipoComm.getCounts();// 改商品的发行数量
					int saleCounts = order.bycommodityid(commId);// 根据发售id获取申购总量
					// 摇号开始
					List<String> endNumList = selection.MainSelection(commCounts, saleCounts);// 尾号集合
					// 查找所有此商品的申购记录
					List<IpoDistribution> ipoDidList = ipoDistribution.selectByCommId(commId);
					int numLength = String.valueOf(ipoDidList.get(0).getStartnumber()).length();// 配号号码长度
					// 号码匹配
					for (IpoDistribution ipoDis : ipoDidList) {
						int userGetNum = 0;
						for (String endNum : endNumList) {
							userGetNum += selection.OwnMatchingEndNum((int) ipoDis.getStartnumber(), ipoDis.getPcounts(), endNum);
						}
						ipoDis.setZcounts(userGetNum);// 更新对象中匹配的个数
						ipoDistribution.updateByPrimaryKey(ipoDis);// 更新数据库记录
					}
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date dt = sdf.parse(DateUtil.getTime(0));
					// 将尾号记录到数据库
					for (String endNum : endNumList) {
						IpoBallotNoInfo ipoBallotNoInfo = new IpoBallotNoInfo();
						ipoBallotNoInfo.setBallotno(endNum);
						ipoBallotNoInfo.setBallotnoendlen(numLength);
						ipoBallotNoInfo.setBallotnostartlen(numLength - endNum.length());
						ipoBallotNoInfo.setCommodityid(commId);
						ipoBallotNoInfo.setCreatetime(dt);
						ipoBallotNoInfoMapper.insert(ipoBallotNoInfo);

					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
