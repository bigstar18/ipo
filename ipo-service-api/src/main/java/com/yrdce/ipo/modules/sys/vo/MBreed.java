package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.util.Arrays;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonProperty;

/*
 * 品种下拉框
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MBreed implements Serializable{
	
	
    private Long breedid;

    private String breedname;

    private String unit;

    private Short trademode;

    private Long categoryid;

    private Short status;

    private String belongmodule;

    private Long sortno;

    private byte[] picture;
    
    

    public MBreed() {
		super();
	}

	public MBreed(Long breedid, String breedname, String unit, Short trademode,
			Long categoryid, Short status, String belongmodule, Long sortno,
			byte[] picture) {
		super();
		this.breedid = breedid;
		this.breedname = breedname;
		this.unit = unit;
		this.trademode = trademode;
		this.categoryid = categoryid;
		this.status = status;
		this.belongmodule = belongmodule;
		this.sortno = sortno;
		this.picture = picture;
	}

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

	@Override
	public String toString() {
		return "MBreed [breedid=" + breedid + ", breedname=" + breedname
				+ ", unit=" + unit + ", trademode=" + trademode
				+ ", categoryid=" + categoryid + ", status=" + status
				+ ", belongmodule=" + belongmodule + ", sortno=" + sortno
				+ ", picture=" + Arrays.toString(picture) + "]";
	}
    
    
}