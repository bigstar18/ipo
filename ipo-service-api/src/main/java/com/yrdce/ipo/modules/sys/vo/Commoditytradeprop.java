package com.yrdce.ipo.modules.sys.vo;

import java.util.Date;

public class Commoditytradeprop {

	private String commodityid;

	private Short sectionid;

	private Date modifytime;

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid;
	}

	public Short getSectionid() {
		return sectionid;
	}

	public void setSectionid(Short sectionid) {
		this.sectionid = sectionid;
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}

}
