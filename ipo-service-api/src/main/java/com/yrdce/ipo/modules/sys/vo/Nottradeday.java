package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * @author Bob 非交易日属性
 */
public class Nottradeday implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5512035695689646552L;
	@JsonProperty("id")
	@XmlElement(name = "id")
	@NotNull
	private Long id;// 主键id

	@JsonProperty("week")
	@XmlElement(name = "week")
	@NotNull
	private String week;// 非交易星期

	@JsonProperty("day")
	@XmlElement(name = "day")
	@NotNull
	private String day;// 非交易日日期

	@JsonProperty("modifytime")
	@XmlElement(name = "modifytime")
	@NotNull
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