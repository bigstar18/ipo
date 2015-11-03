package com.yrdce.ipo.modules.sys.entity;

import java.util.Date;

public class IpoDistribution {
	private int id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
}