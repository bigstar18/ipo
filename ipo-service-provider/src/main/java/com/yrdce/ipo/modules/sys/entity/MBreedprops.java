package com.yrdce.ipo.modules.sys.entity;

public class MBreedprops {
    private Long breedid;

    private Long propertyid;

    private String propertyvalue;

    private Long sortno;

    public Long getBreedid() {
        return breedid;
    }

    public void setBreedid(Long breedid) {
        this.breedid = breedid;
    }

    public Long getPropertyid() {
        return propertyid;
    }

    public void setPropertyid(Long propertyid) {
        this.propertyid = propertyid;
    }

    public String getPropertyvalue() {
        return propertyvalue;
    }

    public void setPropertyvalue(String propertyvalue) {
        this.propertyvalue = propertyvalue == null ? null : propertyvalue.trim();
    }

    public Long getSortno() {
        return sortno;
    }

    public void setSortno(Long sortno) {
        this.sortno = sortno;
    }
}