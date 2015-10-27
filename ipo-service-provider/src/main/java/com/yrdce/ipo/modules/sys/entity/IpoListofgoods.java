package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.yrdce.ipo.common.persistence.DataEntity;

public class IpoListofgoods extends DataEntity<IpoListofgoods> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal id;

	private BigDecimal commodityid;

	private BigDecimal state;

	private Date saleTime;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(BigDecimal commodityid) {
		this.commodityid = commodityid;
	}

	public BigDecimal getState() {
		return state;
	}

	public void setState(BigDecimal state) {
		this.state = state;
	}

	public Date getSaleTime() {
		return saleTime;
	}

	public void setSaleTime(Date saleTime) {
		this.saleTime = saleTime;
	}
}