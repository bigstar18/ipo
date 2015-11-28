package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;

public class Tradetime implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8355271361786292983L;

	@JsonProperty("sectionid")
	@XmlElement(name = "sectionid")
	@NotNull
	private Short sectionid;// 交易节id

	@JsonProperty("name")
	@XmlElement(name = "name")
	@NotNull
	private String name;// 交易节名称

	@JsonProperty("starttime")
	@XmlElement(name = "starttime")
	@NotNull
	private String starttime;// 交易节开始时间

	@JsonProperty("endtime")
	@XmlElement(name = "endtime")
	@NotNull
	private String endtime;// 交易节结束时间

	@JsonProperty("status")
	@XmlElement(name = "status")
	@NotNull
	private Short status;// 交易节状态

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
		this.name = name == null ? null : name.trim();
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime == null ? null : starttime.trim();
	}

	public String getEndtime() {
		return endtime;
	}

	public void setEndtime(String endtime) {
		this.endtime = endtime == null ? null : endtime.trim();
	}

	public Short getStatus() {
		return status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

}
