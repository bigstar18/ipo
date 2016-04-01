package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;

public class SysFirmPermission {
    private BigDecimal id;

    private String firmid;

    private String modeid;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getFirmid() {
        return firmid;
    }

    public void setFirmid(String firmid) {
        this.firmid = firmid == null ? null : firmid.trim();
    }

    public String getModeid() {
        return modeid;
    }

    public void setModeid(String modeid) {
        this.modeid = modeid == null ? null : modeid.trim();
    }
}