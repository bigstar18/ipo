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

import com.yrdce.ipo.modules.sys.dao.IpoSysStatusMapper;
import com.yrdce.ipo.modules.sys.entity.IpoSysStatus;

/**
 * @author hxx
 *
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
	private IpoSysStatusMapper mapper;
	@Autowired
	private SectionManager sectionManager;

	@PostConstruct
	private void postConstruct() throws Exception {
		logger.info("执行IpoSystem: postConstruct");

		sectionManager.init();
		init();
	}

	private void init() throws Exception {
		initTime();

		initStatus();
		logger.info("当前系统状态：tradeDate={},sysStatus={},sectionId={}", tradeDate, status, section);

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
					if (status == null) {// 没有初始化，没有前交易日
						Date date = new Date(System.currentTimeMillis() + timeDiff);
						if (sectionManager.isOpenMarketTime(date)) {
							try {
								openMarketInternal();
							} catch (Exception e) {
							}
						} else {// 休眠到下次开市时间
							long nextOpenTime = sectionManager.getOpenMarketTimeFromNow(date);
							try {
								threadSleep(nextOpenTime);// 只是休眠
							} catch (InterruptedException e) {
							}
						}
					} else {
						Date now = new Date(System.currentTimeMillis() + timeDiff);
						if (sdf.format(now).equals(tradeDate) || isPreTradeDayNormal(now)) {
							switch (Integer.parseInt(status)) {
							case 0:// opened, ready to trade
								long tradeTime = sectionManager.getNextTradeTimeFromNow(new Date(System.currentTimeMillis() + timeDiff));
								try {
									logger.info("系统已开市，离交易还差（{}）毫秒，线程开始休眠。", tradeTime);
									threadSleep(tradeTime + 1);
									startTradeInternal();
								} catch (InterruptedException e) {
								}
								break;
							case 1:// market closed, ready for next day
								long nextOpenTime = sectionManager.getOpenMarketTimeFromNow(new Date(System.currentTimeMillis() + timeDiff));
								try {
									logger.info("系统已闭市，离下次开市还差（{}）毫秒，线程开始休眠。", nextOpenTime);
									threadSleep(nextOpenTime + 1);
									reopenMarketInternal();
								} catch (InterruptedException e) {
								}
								break;
							case 5:// trading
								long continuedTime = sectionManager.getCurSectionEndTimeFromNow((new Date(System.currentTimeMillis() + timeDiff)),
										section);
								try {
									logger.info("系统正在交易，离这节交易结束还差（{}）毫秒，线程开始休眠。", continuedTime);
									threadSleep(continuedTime);
									if (sectionManager.isLastSection(section))
										closeMarketInternal();
									else
										restBetweenSection();// 节间休息
								} catch (InterruptedException e) {
								}
								break;
							case 6:// rest
								long nextTradeTime = sectionManager.getNextTradeTimeFromNow((new Date(System.currentTimeMillis() + timeDiff)));
								// to trade
								try {
									logger.info("系统节间休息，离下个交易节开始还差（{}）毫秒，线程开始休眠。", nextTradeTime);
									threadSleep(nextTradeTime);
									startTradeInternal();// 新交易节
								} catch (InterruptedException e) {
								}
								break;
							case 7:// trade close;
									// close market
								logger.info("系统交易结束，开始闭市。");
								closeMarketInternal();
								break;
							default:
								try {
									threadSleep(1000);
								} catch (InterruptedException e) {
								}
								break;
							}
						} else {
							logger.info("前一交易日没有正常结束：tradeDate={},sysStatus={},sectionId={}", tradeDate, status, section);
							try {
								threadSleep(600000);// 休眠10分钟，可被打断
							} catch (InterruptedException e) {
							}
						}
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
	private void startTradeInternal() {
		this.status = STATUS_TRADE_DOING;
		Date date = new Date(System.currentTimeMillis() + timeDiff);
		this.tradeDate = sdf.format(date);
		section = String.valueOf(sectionManager.getCurrentSectionId(date));

		updateSysStatus(Short.parseShort(section), "交易中");
	}

	// 节间休息 section不变
	private void restBetweenSection() {
		status = STATUS_TRADE_REST;

		updateSysStatus(null, "节间休息");
	}

	// 闭市
	private void closeMarketInternal() {
		this.status = STATUS_MARKET_CLOSE;
		Date date = new Date(System.currentTimeMillis() + timeDiff);
		this.tradeDate = sdf.format(date);

		updateSysStatus(null, "闭市");
	}

	// 状态变更入库
	private void updateSysStatus(Short sectionId, String remark) {
		try {
			IpoSysStatus sysStatus = new IpoSysStatus();
			sysStatus.setTradedate(sdf.parse(tradeDate));
			sysStatus.setStatus(Short.parseShort(status));
			if (sectionId != null)
				sysStatus.setSectionid(sectionId);
			sysStatus.setNote(remark);

			mapper.updateByPrimaryKeySelective(sysStatus);

			logger.info("系统状态变更为：tradeDate={},sysStatus={},sectionId={}", tradeDate, status, section);
		} catch (Exception e) {
			logger.info("error:", e);
		}
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
				status = STATUS_TRADE_PAUSE;
				updateSysStatus(null, "暂停交易");

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
				status = STATUS_TRADE_DOING;
				updateSysStatus(null, "恢复交易");

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
			status = STATUS_TRADE_CLOSE;
			updateSysStatus(null, "结束交易");

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
				status = STATUS_MARKET_CLOSE;
				updateSysStatus(null, "闭市");

				lockStatus.compareAndSet(true, false);
				listener.interrupt();
				return this.status;
			}
		}
		return null;
	}

	/**
	 * 系统是否可交易
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean canSystemTrade() throws Exception {
		return STATUS_TRADE_DOING.equals(status);
	}

	/**
	 * 重新载入交易节和非交易日
	 */
	public void reloadSections() {
		sectionManager.init();
	}

	private void threadSleep(long millis) throws InterruptedException {
		Thread.currentThread().sleep(millis);
	}

}
