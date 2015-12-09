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
	private BigDecimal monery;
	private int number;
	private int units;
	private BigDecimal price;
	private long purchaseCredits; // 申购额度

	public Display() {

	}

	public Display(int id, String name, int number, int units, BigDecimal price, long purchaseCredits) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.units = units;
		this.price = price;
		this.purchaseCredits = purchaseCredits;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

}
