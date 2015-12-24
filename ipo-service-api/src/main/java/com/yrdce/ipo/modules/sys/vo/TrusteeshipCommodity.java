package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class TrusteeshipCommodity implements Serializable {
	private static final long serialVersionUID = 5164987906151243891L;
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 商品编码
	 */
	private String commodityId;
	/**
	 * 托管计划
	 */
	private String plan;
	/**
	 * 商品名称
	 */
	private String commodityName;
	/**
	 * 发行价
	 */
	private BigDecimal price;
	/**
	 * 发行数量
	 */
	private long counts;
	
	
	public TrusteeshipCommodity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getPlan() {
		return plan;
	}

	public void setPlan(String plan) {
		this.plan = plan;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public long getCounts() {
		return counts;
	}

	public void setCounts(long counts) {
		this.counts = counts;
	}
	
	
}
