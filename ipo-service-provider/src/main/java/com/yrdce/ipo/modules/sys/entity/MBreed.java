package com.yrdce.ipo.modules.sys.entity;

/*
 * 品种明细表
 */
public class MBreed {
    private Long breedid;

    private String breedname;

    private String unit;

    private Short trademode;

    private Long categoryid;

    private Short status;

    private String belongmodule;

    private Long sortno;

    private byte[] picture;

    public Long getBreedid() {
        return breedid;
    }

    public void setBreedid(Long breedid) {
        this.breedid = breedid;
    }

    public String getBreedname() {
        return breedname;
    }

    public void setBreedname(String breedname) {
        this.breedname = breedname == null ? null : breedname.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public Short getTrademode() {
        return trademode;
    }

    public void setTrademode(Short trademode) {
        this.trademode = trademode;
    }

    public Long getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(Long categoryid) {
        this.categoryid = categoryid;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public String getBelongmodule() {
        return belongmodule;
    }

    public void setBelongmodule(String belongmodule) {
        this.belongmodule = belongmodule == null ? null : belongmodule.trim();
    }

    public Long getSortno() {
        return sortno;
    }

    public void setSortno(Long sortno) {
        this.sortno = sortno;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
}