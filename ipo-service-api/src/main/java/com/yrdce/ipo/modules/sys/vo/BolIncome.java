package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;

public class BolIncome {

	private String firmId;//交易商id

	private String firmName;//交易商名称

	private String commodityId;//商品id

	private String commodityName;//商品名称

	private String type;//提货类型

	private int count;//件数

	private int quataty;//数量

	private BigDecimal amount;//提货单金额

	private BigDecimal Income;//经纪收入

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getQuataty() {
		return quataty;
	}

	public void setQuataty(int quataty) {
		this.quataty = quataty;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getIncome() {
		return Income;
	}

	public void setIncome(BigDecimal income) {
		Income = income;
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
