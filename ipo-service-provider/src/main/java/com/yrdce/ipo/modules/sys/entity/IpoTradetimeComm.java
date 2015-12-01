package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;

public class IpoTradetimeComm {
    private BigDecimal id;

    private Short tradetimeid;

    private String commodityid;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Short getTradetimeid() {
        return tradetimeid;
    }

    public void setTradetimeid(Short tradetimeid) {
        this.tradetimeid = tradetimeid;
    }

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid == null ? null : commodityid.trim();
    }
}