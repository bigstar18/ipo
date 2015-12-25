package com.yrdce.ipo.modules.sys.entity;


public class IpoTrusteeWarehouse {

	private String commodityId;

	private String commodityName;

	public String getCommodityName() {
		return commodityName;
	}

	public void setCommodityName(String commodityName) {
		this.commodityName = commodityName;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId == null ? null : commodityId.trim();
	}

	@Override
	public String toString() {
		return "IpoTrusteeWarehouse [commodityId=" + commodityId
				+ ", commodityName=" + commodityName + "]";
	}

}