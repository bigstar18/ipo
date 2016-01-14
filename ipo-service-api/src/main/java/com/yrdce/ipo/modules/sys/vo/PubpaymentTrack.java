package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 发行会员货款跟踪
 * 
 * @author chenjing
 *
 */
public class PubpaymentTrack implements Serializable {
	private Long trackid;

	private String commodityid;

	private BigDecimal payables;// 应付货款

	private Short status;// 1 未付款 2 已付款

	private String createperson;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdate;

	private String updateperson;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedate;

	private Short deleteflag;// 0有效 1 无效

	private String commodityname;

	private String pubmemberid;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
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

	@Override
	public String toString() {
		return "PubpaymentTrack [trackid=" + trackid + ", commodityid="
				+ commodityid + ", payables=" + payables + ", status=" + status
				+ ", createperson=" + createperson + ", createdate="
				+ createdate + ", updateperson=" + updateperson
				+ ", updatedate=" + updatedate + ", deleteflag=" + deleteflag
				+ "]";
	}

}