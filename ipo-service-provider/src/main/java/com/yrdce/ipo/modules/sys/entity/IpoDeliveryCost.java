package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoDeliveryCost {
	public String deliveryId;//提货单号

	public String deliveryMethod;//提货方式

	public Date applyDate;//申请日期

	public BigDecimal insurance;//保险费

	public BigDecimal trusteeFee;//托管费

	public BigDecimal warehousingFee;//仓储费

	public BigDecimal deliveryFee;//提货单费用

	public BigDecimal registrationFee;//注册费

	public BigDecimal cancellationFee;//注销费

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

	public BigDecimal getRegistrationFee() {
		return registrationFee;
	}

	public void setRegistrationFee(BigDecimal registrationFee) {
		this.registrationFee = registrationFee;
	}

	public BigDecimal getCancellationFee() {
		return cancellationFee;
	}

	public void setCancellationFee(BigDecimal cancellationFee) {
		this.cancellationFee = cancellationFee;
	}
}