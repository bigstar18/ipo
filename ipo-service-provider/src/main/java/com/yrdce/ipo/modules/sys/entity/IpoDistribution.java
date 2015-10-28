package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.yrdce.ipo.common.persistence.DataEntity;

public class IpoDistribution extends DataEntity<IpoDistribution> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

	private String userid;

	private String commodityname;

	private BigDecimal startNumber;

	private BigDecimal distributionQuantity;

	private Date distributionTime;

	private BigDecimal count;

	private byte[] number;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
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

	public Date getDistributionTime() {
		return distributionTime;
	}

	public void setDistributionTime(Date distributionTime) {
		this.distributionTime = distributionTime;
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	public byte[] getNumber() {
		return number;
	}

	public void setNumber(byte[] number) {
		this.number = number;
	}
}