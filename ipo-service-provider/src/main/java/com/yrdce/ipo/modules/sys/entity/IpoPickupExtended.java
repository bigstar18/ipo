package com.yrdce.ipo.modules.sys.entity;

public class IpoPickupExtended extends IpoDeliveryorder {
	private String pickupId;

	private String pickupPassword;

	private String idcardNum;

	public String getPickupId() {
		return pickupId;
	}

	public void setPickupId(String pickupId) {
		this.pickupId = pickupId == null ? null : pickupId.trim();
	}

	public String getPickupPassword() {
		return pickupPassword;
	}

	public void setPickupPassword(String pickupPassword) {
		this.pickupPassword = pickupPassword == null ? null : pickupPassword.trim();
	}

	public String getIdcardNum() {
		return idcardNum;
	}

	public void setIdcardNum(String idcardNum) {
		this.idcardNum = idcardNum == null ? null : idcardNum.trim();
	}
}