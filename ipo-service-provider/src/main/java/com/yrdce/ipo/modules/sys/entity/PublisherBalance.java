package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;

/**
 * 交易商上日和当日余额
 * 
 * @author chenjing
 *
 */
public class PublisherBalance {

	private String brokerid;

	private String firmid;

	private String name;

	private BigDecimal yesterdaybalance;

	private BigDecimal todaybalance;

	private String today;

	public String getBrokerid() {
		return brokerid;
	}

	public void setBrokerid(String brokerid) {
		this.brokerid = brokerid;
	}

	public String getFirmid() {
		return firmid;
	}

	public void setFirmid(String firmid) {
		this.firmid = firmid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getYesterdaybalance() {
		return yesterdaybalance;
	}

	public void setYesterdaybalance(BigDecimal yesterdaybalance) {
		this.yesterdaybalance = yesterdaybalance;
	}

	public BigDecimal getTodaybalance() {
		return todaybalance;
	}

	public void setTodaybalance(BigDecimal todaybalance) {
		this.todaybalance = todaybalance;
	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

}
