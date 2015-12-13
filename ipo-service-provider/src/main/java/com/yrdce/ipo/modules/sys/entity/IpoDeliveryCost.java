package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoDeliveryCost {
    private Long deliveryId;

    private String deliveryMethod;

    private Date applyDate;

    private BigDecimal insurance;

    private BigDecimal trusteeFee;

    private BigDecimal warehousingFee;

    private BigDecimal deliveryFee;

    public Long getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Long deliveryId) {
        this.deliveryId = deliveryId;
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