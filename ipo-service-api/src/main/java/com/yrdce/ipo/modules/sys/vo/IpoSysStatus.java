package com.yrdce.ipo.modules.sys.vo;

import java.util.Date;

public class IpoSysStatus {

	private String statusStr;

	public String getStatusStr() {
		return statusStr;
	}

	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}

	private Date tradedate;

	private Short status;

	private Short sectionid;

	private String note;

	private String recovertime;

	private String sysTime;

	public IpoSysStatus(Date tradedate, Short status, Short sectionid, String note, String recovertime) {
		super();
		this.tradedate = tradedate;
		this.status = status;
		this.sectionid = sectionid;
		this.note = note;
		this.recovertime = recovertime;
	}

	public IpoSysStatus(Date tradedate, Short status, Short sectionid, String note, String recovertime, String sysTime) {
		super();
		this.tradedate = tradedate;
		this.status = status;
		this.sectionid = sectionid;
		this.note = note;
		this.recovertime = recovertime;
		this.sysTime = sysTime;
	}

	public String getSysTime() {
		return sysTime;
	}

	public void setSysTime(String sysTime) {
		this.sysTime = sysTime;
	}

	public IpoSysStatus() {
		super();
	}

	public Date getTradedate() {
		return tradedate;
	}

	public void setTradedate(Date tradedate) {
		this.tradedate = tradedate;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public Short getSectionid() {
		return sectionid;
	}

	public void setSectionid(Short sectionid) {
		this.sectionid = sectionid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	public String getRecovertime() {
		return recovertime;
	}

	public void setRecovertime(String recovertime) {
		this.recovertime = recovertime == null ? null : recovertime.trim();
	}
}