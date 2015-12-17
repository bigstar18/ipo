package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoDeliveryCost {
	public String deliveryId;

	public String deliveryMethod;

	public Date applyDate;

	public BigDecimal insurance;

	public BigDecimal trusteeFee;

	public BigDecimal warehousingFee;

	public BigDecimal deliveryFee;

	public String getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(String deliveryId) {
		this.deliveryId = deliveryId == null ? null : deliveryId.trim();
	}

	public String getDeliveryMethod() {
		return deliveryMethod;
	}

	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod == null ? null : deliveryMethod.trim();
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public BigDecimal getInsurance() {
		return insurance;
	}

	public void setInsurance(BigDecimal insurance) {
		this.insurance = insurance;
	}

	public BigDecimal getTrusteeFee() {
		return trusteeFee;
	}

	public void setTrusteeFee(BigDecimal trusteeFee) {
		this.trusteeFee = trusteeFee;
	}

	public BigDecimal getWarehousingFee() {
		return warehousingFee;
	}

	public void setWarehousingFee(BigDecimal warehousingFee) {
		this.warehousingFee = warehousingFee;
	}

	public BigDecimal getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(BigDecimal deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
}