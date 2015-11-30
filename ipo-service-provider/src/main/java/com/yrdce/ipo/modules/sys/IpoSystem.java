/**
 * 
 */
package com.yrdce.ipo.modules.sys;

import java.text.SimpleDateFormat;
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
public class IpoSystem {

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
	private String sectionId;

	private AtomicBoolean lockStatus = new AtomicBoolean(false);

	@Autowired
	private IpoSysStatusMapper mapper;

	@PostConstruct
	public void postConstruct() {
		logger.info("执行IpoSystem: postConstruct");
		// TODO 启动线程
		// 交易节对象
	}

	/**
	 * 
	 * 开市，操作失败返回null
	 * 
	 * @throws Exception
	 */
	public String openMarket() throws Exception {
		if (!isTradeTimeInclude5m())
			return null;
		IpoSysStatus status = mapper.selectAll();
		String dbDate = sdf.format(mapper.getDBTime());
		if (status != null) {// 有记录
			if (sdf.format(status.getTradedate()).equals(dbDate))
				return null;
			if (status.getStatus() != 3) {
				return null;
			}

			mapper.deleteByPrimaryKey(status.getTradedate());
		}

		initSysStatus(dbDate);

		return this.status;
	}

	/**
	 * 是否是交易时间，含交易前5分钟
	 * 
	 * @return
	 */
	private boolean isTradeTimeInclude5m() {
		// TODO
		return true;
	}

	private void initSysStatus(String dbDate) throws Exception {
		IpoSysStatus status = new IpoSysStatus();
		status.setTradedate(sdf.parse(dbDate));
		status.setStatus(Short.parseShort(STATUS_MARKET_INIT));
		status.setSectionid(null);
		status.setNote(null);
		status.setRecovertime(null);

		mapper.insert(status);

		this.status = STATUS_MARKET_INIT;
		this.tradeDate = dbDate;
		// TODO 交易节
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
				return this.status;
			}
		}
		return null;
	}

	public String getStatus() {
		while (true) {
			if (lockStatus.compareAndSet(false, true))
				break;
			sleep(200);

		}
		lockStatus.compareAndSet(true, false);
		return status;
	}

	private void sleep(long millis) {
		try {
			Thread.currentThread().sleep(millis);
		} catch (InterruptedException e) {
			// e.printStackTrace();
		}
	}

	public void setStatus(String status) {
		while (true) {
			if (lockStatus.compareAndSet(false, true))
				break;
			sleep(200);

		}
		lockStatus.compareAndSet(true, false);

		this.status = status;
	}

	public String getTradeDate() {
		return tradeDate;
	}

	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}

	public String getSectionId() {
		return sectionId;
	}

	public void setSectionId(String sectionId) {
		this.sectionId = sectionId;
	}

}
