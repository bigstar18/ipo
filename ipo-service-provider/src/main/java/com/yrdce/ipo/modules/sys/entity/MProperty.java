package com.yrdce.ipo.modules.sys.entity;

public class MProperty {
	private Long propertyid;

	private Long categoryid;

	private String propertyname;

	private String propertyvalue;

	private Long sortno;

	public Long getPropertyid() {
		return propertyid;
	}

	public void setPropertyid(Long propertyid) {
		this.propertyid = propertyid;
	}

	public Long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getPropertyname() {
		return propertyname;
	}

	public void setPropertyname(String propertyname) {
		this.propertyname = propertyname;
	}

	public String getPropertyvalue() {
		return propertyvalue;
	}

	public void setPropertyvalue(String propertyvalue) {
		this.propertyvalue = propertyvalue;
	}

	public Long getSortno() {
		return sortno;
	}

	public void setSortno(Long sortno) {
		this.sortno = sortno;
	}

}