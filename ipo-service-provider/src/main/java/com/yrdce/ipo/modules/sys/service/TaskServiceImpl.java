package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.common.utils.DateUtil;
import com.yrdce.ipo.common.utils.Selection;
import com.yrdce.ipo.modules.sys.dao.BrBrokerMapper;
import com.yrdce.ipo.modules.sys.dao.IpoBallotNoInfoMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDebitFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoDistributionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoNumberofrecordsMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOrderMapper;
import com.yrdce.ipo.modules.sys.dao.IpoPositionMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoCommoditymanmaagementMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
import com.yrdce.ipo.modules.sys.entity.BrBroker;
import com.yrdce.ipo.modules.sys.entity.IpoBallotNoInfo;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityExtended;
import com.yrdce.ipo.modules.sys.entity.IpoDistribution;
import com.yrdce.ipo.modules.sys.entity.IpoNumberofrecords;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.entity.IpoPosition;
import com.yrdce.ipo.modules.sys.entity.IpoSpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.entity.IpoSpoRation;
import com.yrdce.ipo.modules.sys.entity.TFirmHoldSum;
import com.yrdce.ipo.modules.sys.vo.DebitFlow;

/**
 * 定时任务相关的 service
 * 
 * @author wq 2016-1-2
 *
 */
public class TaskServiceImpl implements TaskService {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat sdtf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
	@Autowired
	private IpoPositionMapper ipoPositionMapper;
	@Autowired
	private IpoCommodityMapper commodityMapper;
	@Autowired
	private IpoOrderMapper ipoOrderMapper;

	@Autowired
	private IpoSpoRationMapper ipoSpoRationMapper;
	@Autowired
	private IpoSpoCommoditymanmaagementMapper ipoSPOCommMapper;
	@Autowired
	private BrBrokerMapper brBrokerMapper;
	@Autowired
	private IpoDebitFlowMapper debitFlowMapper;

	/**
	 * 配号
	 * 
	 * @param commodityid
	 *            商品id
	 * @throws Exception
	 */
	@Transactional()
	public void distribution(String commodityid) throws Exception {
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

	/**
	 * 配号
	 * 
	 * @throws Exception
	 */
	@Transactional
	public void distribution() throws Exception {
		List<IpoCommodityConf> commodityConfList = commodityConfMapper.findAllIpoCommConfs();
		logger.info("遍历商品配置表");
		for (IpoCommodityConf conf : commodityConfList) {
			int i = +1;
			logger.info("遍历商品配置表:" + i);
			int day = conf.getTradedays();
			String oldtime = DateUtil.getTime(day);// 做了修改，此处参数应为day
			Date endtime = conf.getEndtime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String endtime1 = sdf.format(endtime);
			if (oldtime.equals(endtime1) && conf.getStatus().intValue() == 1) {
				logger.info("T+N天符合要求");
				String commodityid = conf.getCommodityid();
				distribution(commodityid);
			}
		}

	}

	/**
	 * 摇号
	 * 
	 * @throws Exception
	 */
	@Transactional
	public void lottery() throws Exception {
		// 查找所有此商品的申购记录
		logger.info("申购记录查询开始");
		String ballotNowtime = DateUtil.getTime(1);// 做了修改，此处参数应为1
		List<IpoDistribution> ipoDidList = ipoDistribution.allByTime(ballotNowtime);
		logger.info(ipoDidList.size() + "");
		for (IpoDistribution ipoDistribution1 : ipoDidList) {
			String commId = ipoDistribution1.getCommodityid();
			IpoCommodity ipoCommodity = commodity.getSelectByComid(commId.toUpperCase());
			if (ipoCommodity.getStatus() == 2) {
				lottery(commId);
			}
		}
	}

	// 商品摇号
	@Transactional()
	public void lottery(String commId) throws Exception {
		logger.info("commID:" + commId);
		List<IpoDistribution> ipoDidList = ipoDistribution.selectByCommId(commId);
		IpoCommodity ipoCommodity = commodity.getSelectByComid(commId.toUpperCase());

		commodity.updateByStatus(31, commId);// 31表示摇号中
		commodityConfMapper.updateByStatus(31, commId);
		int commCounts = ipoCommodity.getCounts() / ipoCommodity.getUnits();
		logger.info("单位" + ipoCommodity.getUnits());
		logger.info("commCounts:" + commCounts + ":" + ipoCommodity.getUnits());
		int saleCounts = order.bycommodityid(commId) / ipoCommodity.getUnits();
		logger.info("saleCounts:" + saleCounts);
		Selection selection = new Selection();
		List<String> endNumList = selection.MainSelection(commCounts, saleCounts);// 尾号集合
		logger.info("申购记录查询成功");
		int numLength = String.valueOf(ipoDidList.get(0).getStartnumber()).length();// 配号号码长度
		// 号码匹配
		logger.info("中签号匹配开始");
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
			// commodityConfMapper.updateByStatus(3, commId);
			// commodity.updateByStatus(3, commId);
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
		commodityConfMapper.updateByStatus(3, commId);
		commodity.updateByStatus(3, commId);
		logger.info("摇号结束");

	}

	@Transactional()
	public void orderBalance(String commId) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<IpoDistribution> ipoDidList1 = ipoDistribution.selectByCommId(commId);
		for (IpoDistribution ipodb : ipoDidList1) {
			if (ipodb.getZcounts() != 0) {
				logger.info("获取发售商品信息" + ipodb.getCommodityid());
				IpoCommodityExtended commodityExtended = commodity.selectPriceByCommodityid(ipodb.getCommodityid());
				List<IpoOrder> counterFeeInfo = ipoOrderMapper.selectCounterFeeInfo(ipodb.getCommodityid());
				IpoCommodityConf commodityConf = commodityConfMapper.selectCommUnit(ipodb.getCommodityid());
				if (commodityConf != null) {
					BigDecimal bigDecimal = commodityExtended.getPrice();
					logger.info("计算成交金额" + bigDecimal);
					BigDecimal tempPrice = bigDecimal.multiply(new BigDecimal(ipodb.getZcounts()));
					logger.info("成交金额" + tempPrice);
					ipodb.setTradingamount(tempPrice);
					logger.info("计算手续费" + counterFeeInfo.get(0).getTradealgr());
					short tradealgr = counterFeeInfo.get(0).getTradealgr();
					BigDecimal buyfee = counterFeeInfo.get(0).getBuy();
					logger.info("计算手续费算法" + tradealgr);
					if (tradealgr == 1) {
						BigDecimal tempDecimal = buyfee.divide(new BigDecimal(100));
						BigDecimal counterfee = tempPrice.multiply(tempDecimal);
						ipodb.setCounterfee(counterfee);
					} else if (tradealgr == 2) {
						BigDecimal counterfee = buyfee.multiply(new BigDecimal(ipodb.getZcounts()));
						ipodb.setCounterfee(counterfee);
					}
					Date dt = sdf.parse(DateUtil.getTime(0));
					ipodb.setFrozendate(dt);
					logger.info("跟新中签计算金额开始");
					ipoDistribution.setSomeInfo(ipodb);
					logger.info("跟新中签计算金额结束");
					transferPosition(commodityExtended, ipodb, commodityConf);
					commodityMapper.updateStatusByStatusId(3, 32, ipodb.getCommodityid());
				}
			}
		}

	}

	/**
	 * 费用计算和 转持仓
	 */
	@Transactional
	public void orderBalance() throws Exception {
		// TODO Auto-generated method stub
		logger.info("申购结算开始");
		logger.info("开始获取所有未结算的中签记录");

		String ballotNowtime = DateUtil.getTime(2);
		// List<IpoDistribution> distributions =
		// ipoDistribution.getInfobyDate(ballotNowtime);
		List<IpoDistribution> distributions = ipoDistribution.allByTime(ballotNowtime);
		logger.info("费用结算开始");
		for (IpoDistribution ipod : distributions) {
			IpoCommodity ipoCommodity = commodity.getSelectByComid(ipod.getCommodityid());
			// 不等于摇号成功
			if (ipoCommodity.getStatus() == 3) {
				orderBalance(ipod.getCommodityid());
			}

		}
		logger.info("申购结束");
	}

	@Transactional
	private void transferPosition(IpoCommodityExtended comm, IpoDistribution dst, IpoCommodityConf commodityConf) throws Exception {
		// TODO Auto-generated method stub
		logger.info("转持仓开始");
		String userid = dst.getUserid();
		String commid = comm.getCommodityid();
		IpoPosition ipoPosition = ipoPositionMapper.selectPosition(userid, commid);
		if (ipoPosition != null) {
			long position = ipoPosition.getPosition();
			BigDecimal unit = commodityConf.getUnits();
			logger.info("配售单位" + unit);
			BigDecimal counts = new BigDecimal(dst.getZcounts());
			logger.info("中签数量：" + counts);
			long num = (unit.multiply(counts)).intValue();
			long sum = position + num;
			ipoPositionMapper.updatePosition(userid, commid, sum);
		} else {
			String commUnit = commodityConf.getContractfactorname();
			BigDecimal unit = commodityConf.getUnits();
			logger.info("配售单位" + unit);
			BigDecimal counts = new BigDecimal(dst.getZcounts());
			logger.info("中签数量：" + counts);
			long num = (unit.multiply(counts)).intValue();
			IpoPosition record = new IpoPosition();
			record.setFirmid(dst.getUserid());
			record.setPosition(num);
			record.setCommodityid(dst.getCommodityid());
			record.setCommodityname(dst.getCommodityname());
			record.setPositionPrice(comm.getPrice());
			record.setPositionUnit(commUnit);
			record.setOperationTime(new Date());
			ipoPositionMapper.insert(record);
		}
		logger.info("转持仓结束");
	}

	/**
	 * ipo 转现货持仓
	 */
	@Transactional
	public void ipoTransferGoodsPosition() throws Exception {

		IpoCommodityConf examples = new IpoCommodityConf();
		List<IpoCommodityConf> commList = commodityConfMapper.queryListingCommodity(examples);
		if (commList == null || commList.isEmpty()) {
			return;
		}
		for (IpoCommodityConf item : commList) {
			ipoTransferGoodsPosition(item.getCommodityid());
		}

	}

	/**
	 * ipo 转现货持仓
	 */
	@Transactional
	public void ipoTransferGoodsPosition(String commodityid) throws Exception {
		ipoPositionMapper.transferGoodsPosition(commodityid);
	}

	/**
	 * 比例增发散户的配售
	 * 
	 * @param
	 * @throws Exception
	 */
	@Transactional
	public void placing() throws Exception {
		logger.info("散户增发定时任务启动");
		List<IpoSpoCommoditymanmaagement> list = ipoSPOCommMapper.select("1", null, null);
		for (IpoSpoCommoditymanmaagement ipospocomm : list) {
			String spoid = ipospocomm.getSpoId();
			logger.info(">>>>>>>>>>>>>>>>>>spoid：" + spoid);
			int sate = ipospocomm.getSpoSate();//
			if (sate == 1) {
				// 获得增发商品id
				String commodityid = ipospocomm.getCommodityid();
				logger.info(">>>>>>>>>>>>>>>>>>commodityid:" + commodityid);
				// 获得未增发的量
				long otration = ipospocomm.getNotRationCounts();
				logger.info(">>>>>>>>>>>>>>>>>>otration:" + otration);
				// 商品在持仓中的总量(现货持仓)
				int sum = ipoPositionMapper.selectSumByComm(commodityid);
				logger.info(">>>>>>>>>>>>>>>>>>sum:" + sum);
				// 现货持仓信息
				List<TFirmHoldSum> tFirmholdsumslist = ipoPositionMapper.selectPositionList(commodityid);
				for (TFirmHoldSum tFirmholdsums : tFirmholdsumslist) {
					String firmid = tFirmholdsums.getFirmId();
					logger.info(">>>>>>>>>>>>>>>>>>firmid:" + firmid);
					double position = tFirmholdsums.getHoldqty();
					logger.info(">>>>>>>>>>>>>>>>>>position:" + position);
					double value = position / (double) sum;
					logger.info(">>>>>>>>>>>>>>>>>>value:" + value);
					// 增发量
					long num = (long) (otration * value);
					IpoSpoRation ipoSpoRation = new IpoSpoRation();
					ipoSpoRation.setSpoid(spoid);
					ipoSpoRation.setRationcounts(num);
					ipoSpoRation.setFirmid(firmid);
					ipoSpoRation.setOperationdate(new Date());
					String firmname = ipoSpoRationMapper.selectFirmname(firmid);
					ipoSpoRation.setFirmname(firmname);
					ipoSpoRation.setRationSate(1);
					ipoSpoRationMapper.insert(ipoSpoRation);
					ipoSPOCommMapper.updateByStatus(5, spoid);
					logger.info("散户增发定时任务结束");
				}
			}
		}
	}

	/**
	 * 在上市日期那天扣除发行商的手续费
	 */
	public void savePublishHandling() throws Exception {
		List<IpoCommodityConf> commList = commodityConfMapper.findAllIpoCommConfs();
		if (commList == null || commList.isEmpty()) {
			return;
		}
		;
		Date listingDate = null;// 上市日期
		for (IpoCommodityConf commConf : commList) {
			listingDate = commConf.getListingdate();
			if (!sdf.format(new Date()).equals(sdf.format(listingDate))) {
				continue;
			}
			savePublishHandling(commConf);
		}
	}

	/**
	 * 在上市日期那天扣除发行商的手续费
	 * 
	 * @param commConf
	 * @throws Exception
	 */
	@Transactional
	public void savePublishHandling(IpoCommodityConf commConf) throws Exception {
		String commodityId = commConf.getCommodityid();
		// 发行手续费算法(1、按百分比 2、按绝对值)
		Short publishalgr = commConf.getPublishalgr();
		BigDecimal amount = new BigDecimal(0);
		if (publishalgr == 2) {
			amount = commConf.getPublishercharatio();
		} else {
			amount = commConf.getPrice().multiply(commConf.getCounts()).multiply(commConf.getPublishercharatio()).divide(new BigDecimal(100));
		}
		;
		BrBroker broker = brBrokerMapper.selectById(commConf.getPubmemberid());
		String firmId = broker.getFirmid();
		DebitFlow debitFlow = new DebitFlow();
		debitFlow.setAmount(amount);
		debitFlow.setBusinessType(ChargeConstant.BusinessType.PUBLISH.getCode());
		debitFlow.setChargeType(ChargeConstant.ChargeType.HANDLING.getCode());
		debitFlow.setCommodityId(commodityId);
		debitFlow.setDebitState(ChargeConstant.DebitState.FROZEN_SUCCESS.getCode());
		debitFlow.setPayer(firmId);
		debitFlow.setDebitMode(ChargeConstant.DebitMode.ONLINE.getCode());
		debitFlow.setDebitChannel(ChargeConstant.DebitChannel.DEPOSIT.getCode());
		debitFlow.setCreateUser("job");
		debitFlow.setCreateDate(new Date());
		debitFlowMapper.insert(debitFlow);
	}

}
