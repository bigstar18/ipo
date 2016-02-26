package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;
import java.util.Date;

public class Specialcounterfee {
	private String id;

	private String firmid;

	private String commodityid;

	private Short tradealgr;

	private BigDecimal counterfee;

	private BigDecimal sell;

	private Date updatedate;

	private String userid;

	private Short counterfeetype;// 手续费种类（暂定）1.交易买2.交易卖3.发行

	public BigDecimal getCounterfee() {
		return counterfee;
	}

	public void setCounterfee(BigDecimal counterfee) {
		this.counterfee = counterfee;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirmid() {
		return firmid;
	}

	public void setFirmid(String firmid) {
		this.firmid = firmid == null ? null : firmid.trim();
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid == null ? null : commodityid.trim();
	}

	public Short getTradealgr() {
		return tradealgr;
	}

	public void setTradealgr(Short tradealgr) {
		this.tradealgr = tradealgr;
	}

	public BigDecimal getSell() {
		return sell;
	}

	public void setSell(BigDecimal sell) {
		this.sell = sell;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	public Short getCounterfeetype() {
		return counterfeetype;
	}

	public void setCounterfeetype(Short counterfeetype) {
		this.counterfeetype = counterfeetype;
	}
}