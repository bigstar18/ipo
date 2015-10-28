package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

import com.yrdce.ipo.common.persistence.DataEntity;

public class IpoOrder extends DataEntity<IpoOrder> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String orderid;

	private String userid;

	private String username;

	private String commodityid;

	private String commodityname;

	private BigDecimal count;

	private Date date;

	private BigDecimal frozenfunds;

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid == null ? null : orderid.trim();
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid == null ? null : commodityid.trim();
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

	public BigDecimal getFrozenfunds() {
		return frozenfunds;
	}

	public void setFrozenfunds(BigDecimal frozenfunds) {
		this.frozenfunds = frozenfunds;
	}
}