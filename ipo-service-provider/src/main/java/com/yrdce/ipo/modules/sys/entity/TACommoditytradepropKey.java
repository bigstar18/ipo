package com.yrdce.ipo.modules.sys.entity;

public class TACommoditytradepropKey {
    private String commodityid;

    private Short sectionid;

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid == null ? null : commodityid.trim();
    }

    public Short getSectionid() {
        return sectionid;
    }

    public void setSectionid(Short sectionid) {
        this.sectionid = sectionid;
    }
}