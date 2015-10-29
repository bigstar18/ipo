package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;

public class Display {
	private String sid;
	private String name;
	private BigDecimal monery;
	private int number;
	private int limit;

	public Display() {

	}

	public Display(String sid, String name, BigDecimal monery, int number, int limit) {
		super();
		this.sid = sid;
		this.name = name;
		this.monery = monery;
		this.number = number;
		this.limit = limit;
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
