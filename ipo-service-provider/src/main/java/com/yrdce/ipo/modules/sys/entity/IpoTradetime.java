package com.yrdce.ipo.modules.sys.entity;

import java.util.Date;

public class IpoTradetime {
	private Short sectionid;

	private String name;

	private String starttime;

	private String endtime;

	private Short status;

	private Date modifytime;

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

	public Short getSectionid() {
		return sectionid;
	}

	public void setSectionid(Short sectionid) {
		this.sectionid = sectionid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

}
