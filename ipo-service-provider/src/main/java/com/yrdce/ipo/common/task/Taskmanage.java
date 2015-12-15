package com.yrdce.ipo.common.task;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDistributionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoNumberofrecordsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.entity.IpoBallotNoInfo;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
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
	@Autowired
	private IpoCommodityConfMapper commodityConfMapper;

	@Override
	public void run() {
		try {
			List<IpoCommodityConf> commodityConfList = commodityConfMapper.findAllIpoCommConfs();
			logger.info("遍历商品配置表");
			for (IpoCommodityConf conf : commodityConfList) {
				int i = +1;
				logger.info("遍历商品配置表:" + i);
				int day = conf.getTradedays();
				String oldtime = DateUtil.getTime(day);
				Date endtime = conf.getEndtime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String endtime1 = sdf.format(endtime);
				if (oldtime.equals(endtime1)) {
					logger.info("T+N天符合要求");
					String commodityid = conf.getCommodityid();
					List<IpoOrder> orderList = order.selectByCid(commodityid);
					if (orderList.size() != 0) {
						frecord = new IpoNumberofrecords();
						// String sid = list.get(i);
						Date date = new Date();
						frecord.setCommodityid(commodityid);
						frecord.setCounts(BigDecimal.valueOf(0));
						frecord.setNowtime(date);
						unmberofrecord.insert(frecord);
						// }

						logger.info("调用配号任务");
						distribution.start(orderList);
					}
				}

			}

			System.out.println("摇号开始");
			// 摇号获取系统当前时间的前2天。
			IpoBallotNoInfo ipoBallotNoInfo = new IpoBallotNoInfo();
			String ballotNowtime = DateUtil.getTime(2);
			// // 查询前一天交易订单
			System.out.println("等待摇号订单查询开始");
			List<IpoCommodity> ipoCommList = commodity.selectByEnd(ballotNowtime);
			System.out.println("等待摇号订单查询成功");
			if (ipoCommList != null && ipoCommList.size() > 0) {
				selection = new Selection();
				System.out.println("开始处理订单");
				for (IpoCommodity ipoComm : ipoCommList) {
					String commId = ipoComm.getCommodityid();// 获取需要摇号的商品id
					int commCounts = ipoComm.getCounts();// 改商品的发行数量
					System.out.println("开始获取申购总量" + commId);
					int saleCounts = order.bycommodityid(commId);// 根据发售id获取申购总量
					System.out.println("成功获取申购总量" + saleCounts);
					// 摇号开始
					System.out.println(ipoComm.getCommodityid() + "订单摇号开始");
					List<String> endNumList = selection.MainSelection(commCounts, saleCounts);// 尾号集合
					System.out.println(ipoComm.getCommodityid() + "订单摇号结束");
					// 查找所有此商品的申购记录
					System.out.println("申购记录查询开始");
					List<IpoDistribution> ipoDidList = ipoDistribution.selectByCommId(commId);
					System.out.println("申购记录查询成功");
					int numLength = String.valueOf(ipoDidList.get(0).getStartnumber()).length();// 配号号码长度
					// 号码匹配
					System.out.println("中签号匹配开始");
					for (IpoDistribution ipoDis : ipoDidList) {
						int userGetNum = 0;
						System.out.println(ipoDis.getUserid() + "尾号个数" + endNumList.size());
						System.out.println(ipoDis.getUserid() + "起始号码" + ipoDis.getStartnumber());
						System.out.println(ipoDis.getUserid() + "匹配个数" + ipoDis.getPcounts());
						for (String endNum : endNumList) {

							userGetNum += selection.OwnMatchingEndNum((int) ipoDis.getStartnumber(), ipoDis.getPcounts(), endNum);
						}
						System.out.println(ipoDis.getUserid() + "匹配个数" + userGetNum);
						ipoDis.setZcounts(userGetNum);// 更新对象中匹配的个数
						ipoDistribution.updateByPrimaryKey(ipoDis);// 更新数据库记录
						commodity.updateByStatus(2, commId);
					}
					System.out.println("中签号匹配完成");
					System.out.println(commId + "尾号记录开始");
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date dt = sdf.parse(DateUtil.getTime(0));
					// 将尾号记录到数据库
					for (String endNum : endNumList) {

						ipoBallotNoInfo.setBallotno(endNum);
						ipoBallotNoInfo.setBallotnoendlen(Integer.valueOf(numLength).shortValue());
						ipoBallotNoInfo.setBallotnostartlen(Integer.valueOf(numLength - endNum.length()).shortValue());
						ipoBallotNoInfo.setCommodityid(commId);
						ipoBallotNoInfo.setCreatetime(dt);
						ipoBallotNoInfoMapper.insert(ipoBallotNoInfo);

					}
					System.out.println(commId + "尾号记录成功");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
