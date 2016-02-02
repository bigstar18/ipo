package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 交易商上日和当日余额
 * 
 * @author chenjing
 *
 */
public class PublisherBalance implements Serializable {

	private String brokerid;// 发行商代码

	private String firmid;// 交易商代码

	private String name;// 发行商名称

	private BigDecimal yesterdaybalance;// 上日余额

	private BigDecimal todaybalance;// 当日余额

	private String today;// 日期

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
