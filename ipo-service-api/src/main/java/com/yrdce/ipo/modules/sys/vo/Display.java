package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Display implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8909435383589858100L;
	private Integer id;
	private String sid;
	private String name;
	private BigDecimal money;
	private int number;
	private int units;
	private BigDecimal price;
	private long maxapplynum; // 申购额度

	public Display() {

	}

	public Display(int id, String name, int number, int units, BigDecimal price, long maxapplynum) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.units = units;
		this.price = price;
		this.maxapplynum = maxapplynum;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public long getPurchaseCredits() {
		return maxapplynum;
	}

	public void setPurchaseCredits(long maxapplynum) {
		this.maxapplynum = maxapplynum;
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
		return money;
	}

	public void setMonery(BigDecimal money) {
		this.money = money;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
