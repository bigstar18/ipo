package com.yrdce.ipo.modules.sys.entity;

public class IpoPickup {
	private String pickupId;

	private String pickupPassword;

	private String idcardNum;

	private IpoDeliveryorder ipoDeliveryorder;

	private IpoDeliveryCost ipoDeliveryCost;

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

	public IpoDeliveryorder getIpoDeliveryorder() {
		return ipoDeliveryorder;
	}

	public void setIpoDeliveryorder(IpoDeliveryorder ipoDeliveryorder) {
		this.ipoDeliveryorder = ipoDeliveryorder;
	}

	public IpoDeliveryCost getIpoDeliveryCost() {
		return ipoDeliveryCost;
	}

	public void setIpoDeliveryCost(IpoDeliveryCost ipoDeliveryCost) {
		this.ipoDeliveryCost = ipoDeliveryCost;
	}

}