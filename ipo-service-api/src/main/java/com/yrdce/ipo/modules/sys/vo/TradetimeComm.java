package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * 
 * @author Bob 交易节与商品关联表
 */
public class TradetimeComm implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8770869564351143667L;

	@JsonProperty("id")
	@XmlElement(name = "id")
	@NotNull
	private BigDecimal id;// 关联表主键

	@JsonProperty("tradetimeid")
	@XmlElement(name = "tradetimeid")
	@NotNull
	private Short tradetimeid;// 交易节id

	@JsonProperty("commodityid")
	@XmlElement(name = "commodityid")
	@NotNull
	private String commodityid;// 商品id

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Short getTradetimeid() {
		return tradetimeid;
	}

	public void setTradetimeid(Short tradetimeid) {
		this.tradetimeid = tradetimeid;
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid == null ? null : commodityid.trim();
	}
}