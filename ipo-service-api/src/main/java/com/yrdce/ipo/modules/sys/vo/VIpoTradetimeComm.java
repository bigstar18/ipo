package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;

/**
 * 交易节和商品关联表
 * @author chenjing
 *
 */
public class VIpoTradetimeComm {
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