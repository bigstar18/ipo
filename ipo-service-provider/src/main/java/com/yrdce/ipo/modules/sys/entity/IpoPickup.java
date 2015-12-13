package com.yrdce.ipo.modules.sys.entity;

public class IpoPickup {
    private Long pickupId;

    private String pickupPassword;

    private String idcardNum;

    public Long getPickupId() {
        return pickupId;
    }

    public void setPickupId(Long pickupId) {
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
}