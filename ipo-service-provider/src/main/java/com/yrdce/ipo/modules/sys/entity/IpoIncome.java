package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;

public class IpoIncome {
	private String brokerId;

	private String brokerName;

	private String firmId;

	private BigDecimal Purchase;

	private BigDecimal BillOfLading;

	public String getBrokerId() {
		return brokerId;
	}

	public void setBrokerId(String brokerId) {
		this.brokerId = brokerId;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public String getFirmId() {
		return firmId;
	}

	public void setFirmId(String firmId) {
		this.firmId = firmId;
	}

	public BigDecimal getPurchase() {
		return Purchase;
	}

	public void setPurchase(BigDecimal purchase) {
		Purchase = purchase;
	}

	public BigDecimal getBillOfLading() {
		return BillOfLading;
	}

	public void setBillOfLading(BigDecimal billOfLading) {
		BillOfLading = billOfLading;
	}

}
