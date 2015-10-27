package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.yrdce.ipo.common.persistence.DataEntity;

public class IpoOrder extends DataEntity<IpoOrder> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal orderid;

	private BigDecimal userid;

	private String username;

	private BigDecimal commodityid;

	private String commodityname;

	private BigDecimal count;

	private Date date;

	private BigDecimal moneyisfrozen;

	public BigDecimal getOrderid() {
		return orderid;
	}

	public void setOrderid(BigDecimal orderid) {
		this.orderid = orderid;
	}

	public BigDecimal getUserid() {
		return userid;
	}

	public void setUserid(BigDecimal userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public BigDecimal getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(BigDecimal commodityid) {
		this.commodityid = commodityid;
	}

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname == null ? null : commodityname.trim();
	}

	public BigDecimal getCount() {
		return count;
	}

	public void setCount(BigDecimal count) {
		this.count = count;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public BigDecimal getMoneyisfrozen() {
		return moneyisfrozen;
	}

	public void setMoneyisfrozen(BigDecimal moneyisfrozen) {
		this.moneyisfrozen = moneyisfrozen;
	}
}