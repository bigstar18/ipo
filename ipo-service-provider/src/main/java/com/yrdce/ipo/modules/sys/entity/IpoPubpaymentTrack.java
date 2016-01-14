package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 发行会员货款跟踪
 * 
 * @author chenjing
 *
 */
public class IpoPubpaymentTrack {
	private Long trackid; // 主键

	private String commodityid;

	private BigDecimal payables;// 应付货款

	private Short status;// 1 未付款 2 已付款

	private String createperson;

	private Date createdate;

	private String updateperson;

	private Date updatedate;

	private Short deleteflag;// 0有效 1 无效

	private String commodityname;

	private String pubmemberid;

	private Date endtime;

	private Integer tradedays;

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname;
	}

	public String getPubmemberid() {
		return pubmemberid;
	}

	public void setPubmemberid(String pubmemberid) {
		this.pubmemberid = pubmemberid;
	}

	public Date getEndtime() {
		return endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public Integer getTradedays() {
		return tradedays;
	}

	public void setTradedays(Integer tradedays) {
		this.tradedays = tradedays;
	}

	public Long getTrackid() {
		return trackid;
	}

	public void setTrackid(Long trackid) {
		this.trackid = trackid;
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid == null ? null : commodityid.trim();
	}

	public BigDecimal getPayables() {
		return payables;
	}

	public void setPayables(BigDecimal payables) {
		this.payables = payables;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public String getCreateperson() {
		return createperson;
	}

	public void setCreateperson(String createperson) {
		this.createperson = createperson == null ? null : createperson.trim();
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getUpdateperson() {
		return updateperson;
	}

	public void setUpdateperson(String updateperson) {
		this.updateperson = updateperson == null ? null : updateperson.trim();
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public Short getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(Short deleteflag) {
		this.deleteflag = deleteflag;
	}
}