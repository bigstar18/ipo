package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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

/**
 * 定时任务相关的 service
 * @author wq 2016-1-2
 *
 */
public class TaskServiceImpl implements TaskService {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	 
	@Autowired
	private IpoOrderMapper order;
	@Autowired
	private Distribution distribution;
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

	
	/**
	 * 配号
	 * @throws Exception
	 */
	public void distribution() throws Exception {
		List<IpoCommodityConf> commodityConfList = commodityConfMapper.findAllIpoCommConfs();
		logger.info("遍历商品配置表");
		for (IpoCommodityConf conf : commodityConfList) {
			int i = +1;
			logger.info("遍历商品配置表:" + i);
			int day = conf.getTradedays();
			String oldtime = DateUtil.getTime(0);// 做了修改，此处参数应为day
			Date endtime = conf.getEndtime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String endtime1 = sdf.format(endtime);
			if (oldtime.equals(endtime1)) {
				logger.info("T+N天符合要求");
				String commodityid = conf.getCommodityid();
				List<IpoOrder> orderList = order.selectByCid(commodityid);
				if (orderList.size() != 0) {
					IpoNumberofrecords frecord = new IpoNumberofrecords();
					Date date = new Date();
					frecord.setCommodityid(commodityid);
					frecord.setCounts(BigDecimal.valueOf(0));
					frecord.setNowtime(date);
					unmberofrecord.insert(frecord);

					logger.info("调用配号任务");
					distribution.start(orderList);
				}
			}
		}

	}
	
	
	/**
     * 摇号
     * @throws Exception
     */
	public void lottery() throws Exception {
		// 查找所有此商品的申购记录
		System.out.println("申购记录查询开始");
		String ballotNowtime = DateUtil.getTime(0);
		List<IpoDistribution> ipoDidList = ipoDistribution.allByTime(ballotNowtime);
		// List<IpoDistribution> ipoDidList1 = ipoDistribution.selectByTime(ballotNowtime);
		logger.info(ipoDidList.size() + "");
		for (IpoDistribution ipoDistribution1 : ipoDidList) {
			String commId = ipoDistribution1.getCommodityid();
			logger.info("commID:" + commId);
			IpoCommodity ipoCommodity = commodity.getSelectByComid(commId.toUpperCase());
			int commCounts = ipoCommodity.getCounts();
			logger.info("commCounts:" + commCounts);
			int saleCounts = order.bycommodityid(commId);
			logger.info("saleCounts:" + saleCounts);
			Selection selection = new Selection();
			List<String> endNumList = selection.MainSelection(commCounts, saleCounts);// 尾号集合
			System.out.println("申购记录查询成功");
			int numLength = String.valueOf(ipoDidList.get(0).getStartnumber()).length();// 配号号码长度
			// 号码匹配
			System.out.println("中签号匹配开始");
			List<IpoDistribution> ipoDidList1 = ipoDistribution.selectByCommId(commId);
			for (IpoDistribution ipoDis : ipoDidList1) {
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
				commodityConfMapper.updateByStatus(3, commId);
				commodity.updateByStatus(3, commId);

				System.out.println("中签号匹配完成");

			}
			System.out.println(commId + "尾号记录开始");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dt = sdf.parse(DateUtil.getTime(0));
			IpoBallotNoInfo ipoBallotNoInfo = new IpoBallotNoInfo();
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


}
