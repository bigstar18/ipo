package com.yrdce.ipo.modules.sys.entity;

import java.util.Date;

public class IpoDeliveryCostExtended extends IpoDeliveryCost {
	private Date deliveryDate;

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

}
