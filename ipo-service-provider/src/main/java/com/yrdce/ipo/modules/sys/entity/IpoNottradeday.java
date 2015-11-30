package com.yrdce.ipo.modules.sys.entity;

import java.util.Date;

/**
 * 
 * @author Bob
 *
 */
public class IpoNottradeday {
	private Long id;// 主键id

	private String week;// 非交易星期

	private String day;// 非交易日日期

	private Date modifytime;// 操作时间

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week == null ? null : week.trim();
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day == null ? null : day.trim();
	}

	public Date getModifytime() {
		return modifytime;
	}

	public void setModifytime(Date modifytime) {
		this.modifytime = modifytime;
	}
}