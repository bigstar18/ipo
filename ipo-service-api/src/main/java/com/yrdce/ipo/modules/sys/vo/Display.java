package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;

public class Display {
	private String sid;
	private String name;
	private BigDecimal monery;
	private int number;
	private int limit;
	private int units;
	private BigDecimal price;
	private long purchaseCredits;

	public Display() {

	}

	public Display(int number, int limit, int units, BigDecimal price, long purchaseCredits) {
		super();
		// this.sid = sid;
		// this.name = name;
		// this.monery = monery;
		this.number = number;
		this.limit = limit;
		this.units = units;
		this.price = price;
		this.purchaseCredits = purchaseCredits;

	}

	public long getPurchaseCredits() {
		return purchaseCredits;
	}

	public void setPurchaseCredits(long purchaseCredits) {
		this.purchaseCredits = purchaseCredits;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getMonery() {
		return monery;
	}

	public void setMonery(BigDecimal monery) {
		this.monery = monery;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
