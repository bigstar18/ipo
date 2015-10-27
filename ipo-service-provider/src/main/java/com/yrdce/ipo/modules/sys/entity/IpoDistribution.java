package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.yrdce.ipo.common.persistence.DataEntity;

public class IpoDistribution extends DataEntity<IpoDistribution> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal id;

	private BigDecimal orderid;

	private BigDecimal startNumber;

	private BigDecimal distributionQuantity;

	private String distributionNumber;

	private Date distributionTime;

	private String number;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getOrderid() {
		return orderid;
	}

	public void setOrderid(BigDecimal orderid) {
		this.orderid = orderid;
	}

	public BigDecimal getStartNumber() {
		return startNumber;
	}

	public void setStartNumber(BigDecimal startNumber) {
		this.startNumber = startNumber;
	}

	public BigDecimal getDistributionQuantity() {
		return distributionQuantity;
	}

	public void setDistributionQuantity(BigDecimal distributionQuantity) {
		this.distributionQuantity = distributionQuantity;
	}

	public String getDistributionNumber() {
		return distributionNumber;
	}

	public void setDistributionNumber(String distributionNumber) {
		this.distributionNumber = distributionNumber == null ? null : distributionNumber.trim();
	}

	public Date getDistributionTime() {
		return distributionTime;
	}

	public void setDistributionTime(Date distributionTime) {
		this.distributionTime = distributionTime;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number == null ? null : number.trim();
	}
}