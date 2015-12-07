/**
 * 
 */
package com.yrdce.ipo.modules.sys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoClearStatusMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSysStatusMapper;
import com.yrdce.ipo.modules.sys.entity.IpoClearStatus;
import com.yrdce.ipo.modules.sys.entity.IpoSysStatus;

/**
 * @author hxx
 *         只能单机部署，多机的话考虑 redis
 */
@Component
public class SystemManager {

	private Logger logger = LoggerFactory.getLogger(getClass());
	// statusMap.put("0", "初始化完成");
	// statusMap.put("1", "闭市状态");
	// statusMap.put("2", "结算中");
	// statusMap.put("3", "资金结算完成");
	// statusMap.put("4", "暂停交易");
	// statusMap.put("5", "交易中");
	// statusMap.put("6", "节间休息");自动
	// statusMap.put("7", "交易结束");
	// statusMap.put("8", "集合竞价交易中");
	// statusMap.put("9", "集合竞价交易结束");
	// statusMap.put("10", "交易结算完成");

	public static final String STATUS_MARKET_INIT = "0";
	public static final String STATUS_MARKET_CLOSE = "1";
	public static final String STATUS_MARKET_SETTLING = "2";
	public static final String STATUS_FINANCE_SETTLED = "3";
	public static final String STATUS_TRADE_PAUSE = "4";
	public static final String STATUS_TRADE_DOING = "5";
	public static final String STATUS_TRADE_REST = "6";
	public static final String STATUS_TRADE_CLOSE = "7";
	public static final String STATUS_MARKET_SETTLED = "10";
	public static final String CLEAR_STATUS_Y = "Y";
	public static final String DATE_FORMATTER = "yyyy-MM-dd";
	public static final String DATETIME_FORMATTER = "yyyy-MM-dd HH:mm:ss";
	public static SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMATTER);
	public static SimpleDateFormat sdtf = new SimpleDateFormat(DATETIME_FORMATTER);

	// 线程安全? 数据库状态的映射
	private String status;
	private String tradeDate;
	private String section;

	private long timeDiff = 0l;
	private AtomicBoolean lockStatus = new AtomicBoolean(false);
	private Thread listener;

	@Autowired
	private IpoClearStatusMapper clearStatusMapper;
	@Autowired
	private IpoSysStatusMapper mapper;
	@Autowired
	private SectionManager sectionManager;

	public String getStatus() {
		return status;
	}

	/**
	 * 系统是否可交易
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean canSystemTrade() throws Exception {
		Date date = new Date(System.currentTimeMillis() + timeDiff);
		return STATUS_TRADE_DOING.equals(status) && isTradeDayToday(date) && sectionManager.isTradeTime(date);
	}

	/**
	 * 
	 * 开市，操作失败返回null
	 * 
	 * @throws Exception
	 */
	public String openMarket() throws Exception {
		Date date = new Date(System.currentTimeMillis() + timeDiff);
		if (!sectionManager.isOpenMarketTime(date))
			return null;

		IpoSysStatus sysStatus = mapper.selectAll();
		String dbDate = sdf.format(mapper.getDBTime());
		if (sysStatus != null) {// 有记录
			if (sdf.format(sysStatus.getTradedate()).equals(dbDate))
				return null;
			if (sysStatus.getStatus() != 3) {
				return null;
			}

			mapper.deleteByPrimaryKey(sysStatus.getTradedate());
		}

		initSysStatus(dbDate);
		listener.interrupt();
		return this.status;
	}

	/**
	 * 
	 * 暂停交易
	 * 
	 * @throws Exception
	 */
	public String pauseTrade() throws Exception {
		if (!isTradeDayToday(new Date(System.currentTimeMillis() + timeDiff)))
			return null;

		if (lockStatus.compareAndSet(false, true)) {
			if ((status.equals(STATUS_TRADE_DOING) || status.equals(STATUS_TRADE_REST))) {
				updateSysStatus(STATUS_TRADE_PAUSE, null, "暂停交易");

				lockStatus.compareAndSet(true, false);
				listener.interrupt();
				return this.status;
			}
		}
		return null;
	}

	/**
	 * 
	 * 恢复交易
	 * 
	 * @throws Exception
	 */
	public String resumeTrade() throws Exception {
		if (!isTradeDayToday(new Date(System.currentTimeMillis() + timeDiff)))
			return null;

		if (lockStatus.compareAndSet(false, true)) {
			if (status.equals(STATUS_TRADE_PAUSE)) {
				updateSysStatus(STATUS_TRADE_DOING, null, "恢复交易");

				lockStatus.compareAndSet(true, false);
				listener.interrupt();
				return this.status;
			}
		}
		return null;
	}

	/**
	 * 
	 * 结束交易
	 * 
	 * @throws Exception
	 */
	public String closeTrade() throws Exception {
		if (!isTradeDayToday(new Date(System.currentTimeMillis() + timeDiff)))
			return null;

		if (lockStatus.compareAndSet(false, true)) {
			updateSysStatus(STATUS_TRADE_CLOSE, null, "结束交易");

			lockStatus.compareAndSet(true, false);
			listener.interrupt();
			return this.status;
		}
		return null;
	}

	/**
	 * 闭市
	 * 
	 * @throws Exception
	 */
	public String closeMarket() throws Exception {
		if (!isTradeDayToday(new Date(System.currentTimeMillis() + timeDiff)))
			return null;

		if (lockStatus.compareAndSet(false, true)) {
			if (!status.equals(STATUS_MARKET_CLOSE)) {
				updateSysStatus(STATUS_MARKET_CLOSE, null, "闭市");

				lockStatus.compareAndSet(true, false);
				listener.interrupt();
				return this.status;
			}
		}
		return null;
	}

	public void settle() throws Exception {
		// "select f.billid from T_billFrozen f, T_E_GageBill g where f.operation = g.id and Operationtype = 0 and g.commodityid in (select
		// CommodityID from T_Commodity where SettleDate <= (select trunc(tradedate) from t_systemstatus))");
		// 解冻仓单 抵押unFrozenStocks(15, arrayOfString);

		// i = tradeRMI.balance(); // FN_T_CloseMarketProcess

		if (!STATUS_MARKET_CLOSE.equals(status))
			throw new Exception("交易服务器没有闭市操作，不能结算！");

		updateSysStatusLock(STATUS_MARKET_CLOSE, STATUS_MARKET_SETTLING, null, "结算中");
		updateClearStatus(Short.valueOf("0"), CLEAR_STATUS_Y);
		// TODO

		updateSysStatus(STATUS_MARKET_SETTLED, null, "");
	}

	/**
	 * 重新载入交易节和非交易日
	 */
	public void reloadSections() {
		sectionManager.init();
		listener.interrupt();// 让系统重新判别状态
	}

	@PostConstruct
	private void postConstruct() throws Exception {
		logger.info("执行IpoSystem: postConstruct");

		sectionManager.init();
		init();
	}

	private void init() throws Exception {
		initTime();

		initStatus();
		logCurStatus();

		startListener();
	}

	// 时间差
	private void initTime() {
		timeDiff = mapper.getDBTime().getTime() - System.currentTimeMillis();
		logger.info("数据库时间-本机时间 相差： {}.", timeDiff);
	}

	// 系统状态
	private void initStatus() throws Exception {
		IpoSysStatus sysStatus = mapper.selectAll();
		if (sysStatus != null) {
			status = String.valueOf(sysStatus.getStatus());
			tradeDate = sdf.format(sysStatus.getTradedate());
			if (sysStatus.getSectionid() != null)
				section = String.valueOf(sysStatus.getSectionid());
		} else
			openMarketInternal();
	}

	private void logCurStatus() {
		logger.info("当前系统状态：tradeDate={},sysStatus={},sectionId={}", tradeDate, status, section);
	}

	// 市场初始化，自动
	private void openMarketInternal() throws Exception {
		Date date = new Date(System.currentTimeMillis() + timeDiff);
		if (sectionManager.isOpenMarketTime(date)) {
			initSysStatus(sdf.format(date));
		}
	}

	// 初始化入库
	private void initSysStatus(String dbDate) throws Exception {
		IpoSysStatus sysStatus = new IpoSysStatus();
		sysStatus.setTradedate(sdf.parse(dbDate));
		sysStatus.setStatus(Short.parseShort(STATUS_MARKET_INIT));
		sysStatus.setSectionid(null);
		sysStatus.setNote(null);
		sysStatus.setRecovertime(null);

		mapper.insert(sysStatus);

		this.status = STATUS_MARKET_INIT;
		this.tradeDate = dbDate;
	}

	// 交易日切换
	private void startListener() {
		listener = new Thread() {
			public void run() {
				Thread.currentThread().setName("SystemManager线程");
				logger.info(Thread.currentThread() + ": 线程启动");
				while (true) {
					try {
						if (status == null) {// 没有初始化，没有前交易日
							Date date = new Date(System.currentTimeMillis() + timeDiff);
							if (sectionManager.isOpenMarketTime(date)) {
								try {
									openMarketInternal();
								} catch (Exception e) {
								}
							} else {// 休眠到下次开市时间
								long nextOpenTime = sectionManager.getOpenMarketTimeFromNow(date);
								threadSleep(nextOpenTime);// 可被打断
							}
						} else {
							Date now = new Date(System.currentTimeMillis() + timeDiff);
							if (isTradeDayToday(now) || isPreTradeDayNormal(now)) {
								switch (Integer.parseInt(status)) {
								case 0:// opened, ready to trade
									long tradeTime = sectionManager.getNextTradeTimeFromNow(new Date(System.currentTimeMillis() + timeDiff));
									logger.info("系统已开市，离交易还差（{}）毫秒，线程开始休眠。", tradeTime);

									if (tradeTime > 0)
										threadSleep(tradeTime + 1);
									startTradeInternal();

									break;
								case 1:// market closed, ready for next day
									long nextOpenTime = sectionManager.getOpenMarketTimeFromNow(new Date(System.currentTimeMillis() + timeDiff));
									logger.info("系统已闭市，离下次开市还差（{}）毫秒，线程开始休眠。", nextOpenTime);

									threadSleep(nextOpenTime + 1);
									reopenMarketInternal();

									break;
								case 3:// 发现财务结算完成，准备下个交易日的开市
									nextOpenTime = sectionManager.getOpenMarketTimeFromNow(new Date(System.currentTimeMillis() + timeDiff));
									logger.info("资金结算完成，离下次开市还差（{}）毫秒，线程开始休眠。", nextOpenTime);

									threadSleep(nextOpenTime + 1);
									reopenMarketInternal();

									break;
								case 5:// trading
									long continuedTime = sectionManager.getCurSectionEndTimeFromNow((new Date(System.currentTimeMillis() + timeDiff)),
											section);
									logger.info("系统正在交易，离这节交易结束还差（{}）毫秒，线程开始休眠。", continuedTime);

									threadSleep(continuedTime);
									if (sectionManager.isLastSection(section))
										closeMarketInternal();
									else
										restBetweenSection();// 节间休息

									break;
								case 6:// rest
									long nextTradeTime = sectionManager.getNextTradeTimeFromNow((new Date(System.currentTimeMillis() + timeDiff)));
									logger.info("系统节间休息，离下个交易节开始还差（{}）毫秒，线程开始休眠。", nextTradeTime);

									threadSleep(nextTradeTime);
									startTradeInternal();// 新交易节 // to trade

									break;
								case 7:// trade close; // close market
									logger.info("系统交易结束，开始闭市。");

									closeMarketInternal();
									break;
								default:
									threadSleep(1000);
									break;
								}
							} else {
								logger.info("前一交易日没有正常结束：tradeDate={},sysStatus={},sectionId={}", tradeDate, status, section);
								threadSleep(600000);// 休眠10分钟，可被打断
							}
						}
					} catch (Throwable t) {
						logger.error(t.getLocalizedMessage(), t);
						threadSleep(30000);
					}
				}
			}
		};
		listener.setDaemon(true);
		listener.start();
	}

	// 判断前一交易日是否正常结束
	private boolean isPreTradeDayNormal(Date date) {
		IpoSysStatus sysStatus = mapper.selectAll();
		if (sysStatus != null) {// 有记录
			if (sysStatus.getTradedate().getTime() < date.getTime()) {
				return STATUS_FINANCE_SETTLED.equals(sysStatus.getStatus());
			}
		}

		return false;
	}

	// 交易状态是否是今天的
	private boolean isTradeDayToday(Date date) {
		return sdf.format(date).equals(tradeDate);
	}

	// 交易日切换
	private void reopenMarketInternal() {
		try {
			openMarket();
		} catch (Exception e) {
			logger.info("exception:", e);
		}
	}

	// 开市交易
	private void startTradeInternal() throws Exception {
		Date date = new Date(System.currentTimeMillis() + timeDiff);
		this.tradeDate = sdf.format(date);
		section = String.valueOf(sectionManager.getCurrentSectionId(date));

		updateSysStatus(STATUS_TRADE_DOING, Short.parseShort(section), "交易中");
	}

	// 节间休息 section不变
	private void restBetweenSection() throws Exception {
		updateSysStatus(STATUS_TRADE_REST, null, "节间休息");
	}

	// 闭市
	private void closeMarketInternal() throws Exception {
		Date date = new Date(System.currentTimeMillis() + timeDiff);
		this.tradeDate = sdf.format(date);

		updateSysStatus(STATUS_MARKET_CLOSE, null, "闭市");
	}

	// 状态变更入库
	private void updateSysStatus(String status, Short sectionId, String remark) throws Exception {
		try {
			IpoSysStatus sysStatus = new IpoSysStatus();
			sysStatus.setTradedate(sdf.parse(tradeDate));
			sysStatus.setStatus(Short.parseShort(status));
			if (sectionId != null)
				sysStatus.setSectionid(sectionId);
			sysStatus.setNote(remark);

			int i = mapper.updateByPrimaryKeySelective(sysStatus);
			if (i < 1)
				throw new Exception("更新不成功：status=" + sysStatus + " tradeDate=" + tradeDate);
			this.status = status;// 先入库后变更状态，防止事务回滚导致状态不一致
			logChangeStatus();
		} catch (Exception e) {
			logger.info("error:", e);
			throw e;
		}
	}

	private void threadSleep(long millis) {
		try {
			Thread.currentThread().sleep(millis);// 只是休眠
		} catch (InterruptedException e) {
			logger.info("{} 休眠被打断，当前系统状态: tradeDate={},sysStatus={},sectionId={}", Thread.currentThread().getName(), tradeDate, status, section);
		}
	}

	// 预防多实例并发
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private void updateSysStatusLock(String oldStatus, String toStatus, Short sectionId, String remark) throws Exception {
		try {
			IpoSysStatus sysStatus = new IpoSysStatus();
			sysStatus.setTradedate(sdf.parse(tradeDate));
			sysStatus.setStatus(Short.parseShort(toStatus));
			if (sectionId != null)
				sysStatus.setSectionid(sectionId);
			sysStatus.setNote(remark);

			int i = mapper.updateByPrimaryKeySelectiveLock(sysStatus, new Short(oldStatus));
			if (i < 1)
				throw new Exception("更新不成功：status=" + sysStatus + " tradeDate=" + tradeDate);
			this.status = toStatus;// 先入库后变更状态，防止事务回滚导致状态不一致

			logChangeStatus();
		} catch (Exception e) {
			logger.info("error:", e);
			throw e;
		}
		// batchUpdate（）
		// -2表示update成功，但无法获取准确数目。
	}

	private void logChangeStatus() {
		logger.info("系统状态变更为：tradeDate={},sysStatus={},sectionId={}", tradeDate, status, section);
	}

	// 状态变更入库
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	private void updateClearStatus(Short actionId, String status) throws Exception {
		try {
			IpoClearStatus clearStatus = new IpoClearStatus();
			clearStatus.setActionid(actionId);
			clearStatus.setStatus(status);
			Date date = new Date(System.currentTimeMillis() + timeDiff);
			clearStatus.setFinishtime(date);

			clearStatusMapper.updateByPrimaryKeySelective(clearStatus);

			logger.info("清算状态：actionId={},status={},time={}", actionId, status, date);
		} catch (Exception e) {
			logger.info("error:", e);
			throw e;
		}
	}

	public static void main(String[] args) {
		System.out.println("基本类型：short 二进制位数：" + Short.SIZE);
	}

}
