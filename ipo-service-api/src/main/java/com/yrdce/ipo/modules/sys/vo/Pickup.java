package com.yrdce.ipo.modules.sys.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Bob
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Pickup {
	private String pickupId;

	private String pickupPassword;

	private String idcardNum;

	private DeliveryOrder deliveryOrder;

	public String getPickupId() {
		return pickupId;
	}

	public void setPickupId(String pickupId) {
		this.pickupId = pickupId;
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

	public DeliveryOrder getDeliveryOrder() {
		return deliveryOrder;
	}

	public void setDeliveryOrder(DeliveryOrder deliveryOrder) {
		this.deliveryOrder = deliveryOrder;
	}
}