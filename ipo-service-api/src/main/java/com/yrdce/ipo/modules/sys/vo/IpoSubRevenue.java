package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: IpoSubRevenue
 * @Description: 经纪会员申购收入报表
 * @author bob
 */
public class IpoSubRevenue {
	private String firmId;//交易商代码

	private String firmName;//交易商名称

	private String commodityId;//商品代码

	private String commodityName;//商品名称

	private int luckyNumber;//中签数量

	private BigDecimal amount;//认购金额

	private BigDecimal brokerIncome;//申购经纪收入 

	private String intermediaryId;//直属居间商代码

	private String intermediaryName;//直属居间商名称

	public String getFirmId() {
		return firmId;
	}

	public void setFirmId(String firmId) {
		this.firmId = firmId;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public int getLuckyNumber() {
		return luckyNumber;
	}

	public void setLuckyNumber(int luckyNumber) {
		this.luckyNumber = luckyNumber;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getBrokerIncome() {
		return brokerIncome;
	}

	public void setBrokerIncome(BigDecimal brokerIncome) {
		this.brokerIncome = brokerIncome;
	}

	public String getIntermediaryId() {
		return intermediaryId;
	}

	public void setIntermediaryId(String intermediaryId) {
		this.intermediaryId = intermediaryId;
	}

	public String getIntermediaryName() {
		return intermediaryName;
	}

	public void setIntermediaryName(String intermediaryName) {
		this.intermediaryName = intermediaryName;
	}
}
