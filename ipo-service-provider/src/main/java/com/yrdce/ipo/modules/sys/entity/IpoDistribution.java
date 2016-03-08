package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class IpoDistribution {
	private String id;
	// 用户编号
	private String userid;
	// 商品名称
	private String commodityname;
	// 起始配号
	private long startnumber;
	// 配号数量
	private int pcounts;
	// 配号时间
	private Date ptime;
	// 中签数量
	private int zcounts;
	// 中签号码
	private byte[] numbers;
	// 商品编号
	private String commodityid;

	private int frozen;

	private BigDecimal tradingamount;

	private BigDecimal counterfee;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date frozendate;

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname == null ? null : commodityname.trim();
	}

	public long getStartnumber() {
		return startnumber;
	}

	public void setStartnumber(long startnumber) {
		this.startnumber = startnumber;
	}

	public int getPcounts() {
		return pcounts;
	}

	public void setPcounts(int pcounts) {
		this.pcounts = pcounts;
	}

	public Date getPtime() {
		return ptime;
	}

	public void setPtime(Date ptime) {
		this.ptime = ptime;
	}

	public int getZcounts() {
		return zcounts;
	}

	public void setZcounts(int zcounts) {
		this.zcounts = zcounts;
	}

	public byte[] getNumbers() {
		return numbers;
	}

	public void setNumbers(byte[] numbers) {
		this.numbers = numbers;
	}

	public BigDecimal getTradingamount() {
		return tradingamount;
	}

	public void setTradingamount(BigDecimal tradingamount) {
		this.tradingamount = tradingamount;
	}

	public BigDecimal getCounterfee() {
		return counterfee;
	}

	public void setCounterfee(BigDecimal counterfee) {
		this.counterfee = counterfee;
	}

	public int getFrozen() {
		return frozen;
	}

	public void setFrozen(int frozen) {
		this.frozen = frozen;
	}

	public Date getFrozendate() {
		return frozendate;
	}

	public void setFrozendate(Date frozendate) {
		this.frozendate = frozendate;
	}

}