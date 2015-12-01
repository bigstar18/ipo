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
	// statusMap.put("6", "节间休息");
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

	// 线程安全?
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

	private void reopenMarketInternal() {
		try {
			openMarket();
		} catch (Exception e) {
			logger.info("exception:", e);
		}
	}

	// 交易日切换
	private void startListener() {
		listener = new Thread() {
			public void run() {
				Thread.currentThread().setName("SystemManager线程");
				logger.info(Thread.currentThread() + ": 线程启动");
				while (true) {
					if (status == null) {
						Date date = new Date(System.currentTimeMillis() + timeDiff);
						if (sectionManager.isOpenMarketTime(date)) {
							try {
								openMarketInternal();
							} catch (Exception e) {
							}
						} else {// 休眠到下次开市时间
							long nextOpenTime = sectionManager.getOpenMarketTimeFromNow(date);
							try {
								threadSleep(nextOpenTime);
							} catch (InterruptedException e) {
							}
						}
					} else {
						switch (Integer.parseInt(status)) {
						case 0:
							long tradeTime = sectionManager.getTradeTimeFromNow(new Date(System.currentTimeMillis() + timeDiff));
							try {
								threadSleep(tradeTime);
								startTradeInternal();
							} catch (InterruptedException e) {
							}
							break;
						case 1:
							long nextOpenTime = sectionManager.getOpenMarketTimeFromNow(new Date(System.currentTimeMillis() + timeDiff));
							try {
								threadSleep(nextOpenTime);
								reopenMarketInternal();
							} catch (InterruptedException e) {
							}
							break;
						default:
							try {
								threadSleep(1000);
							} catch (InterruptedException e) {
							}
							break;
						}
					}
				}
			}
		};
		listener.setDaemon(true);
		listener.start();
	}

	// 开市交易
	private void startTradeInternal() {
		try {
			Date date = new Date(System.currentTimeMillis() + timeDiff);

			IpoSysStatus sysStatus = new IpoSysStatus();
			sysStatus.setTradedate(sdf.parse(sdf.format(date)));
			sysStatus.setStatus(Short.parseShort(STATUS_TRADE_DOING));
			sysStatus.setSectionid((new Integer(sectionManager.getCurrentSectionId(date))).shortValue());
			sysStatus.setNote("交易中");
			sysStatus.setRecovertime(null);

			mapper.updateByPrimaryKey(sysStatus);

			this.status = STATUS_TRADE_DOING;
			this.tradeDate = sdf.format(date);
			section = sysStatus.getSectionid().toString();
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

	/**
	 * 
	 * 暂停交易
	 * 
	 * @throws Exception
	 */
	public String pauseTrade() throws Exception {
		if (lockStatus.compareAndSet(false, true)) {
			if ((status.equals(STATUS_TRADE_DOING) || status.equals(STATUS_TRADE_REST))) {
				status = STATUS_TRADE_PAUSE;
				lockStatus.compareAndSet(true, false);
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
		if (lockStatus.compareAndSet(false, true)) {
			if (status.equals(STATUS_TRADE_PAUSE)) {
				status = STATUS_TRADE_DOING;
				lockStatus.compareAndSet(true, false);
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
		if (lockStatus.compareAndSet(false, true)) {
			status = STATUS_TRADE_CLOSE;
			lockStatus.compareAndSet(true, false);
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
		if (lockStatus.compareAndSet(false, true)) {
			if (!status.equals(STATUS_MARKET_CLOSE)) {
				status = STATUS_MARKET_CLOSE;
				lockStatus.compareAndSet(true, false);

				listener.interrupt();
				return this.status;
			}
		}
		return null;
	}

	private void threadSleep(long millis) throws InterruptedException {
		Thread.currentThread().sleep(millis);
	}

}
