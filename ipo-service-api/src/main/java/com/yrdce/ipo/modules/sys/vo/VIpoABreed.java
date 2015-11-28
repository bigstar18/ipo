package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author chenjing
 *发售品种
 */
public class VIpoABreed implements Serializable{
    private Long breedid;

    private String breedname;

    private Long sortid;

    private BigDecimal contractfactor;

    private BigDecimal minpricemove;

    private Short spreadalgr;

    private BigDecimal spreaduplmt;

    private BigDecimal spreaddownlmt;

    private Short minquantitymove;

    private String contractfactorname;

    private Long minapplynum;

    private BigDecimal maxapplynum;

    private Integer minapplyquamove;

    private Short publishalgr;

    private BigDecimal dealerpubcharatio;

    private BigDecimal mktdeapubcharatio;

    private BigDecimal publishercharatio;

    private BigDecimal mktpubcharatio;

    private String contractcurrency;

    private Integer tradedays;

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

    public Long getSortid() {
        return sortid;
    }

    public void setSortid(Long sortid) {
        this.sortid = sortid;
    }

    public BigDecimal getContractfactor() {
        return contractfactor;
    }

    public void setContractfactor(BigDecimal contractfactor) {
        this.contractfactor = contractfactor;
    }

    public BigDecimal getMinpricemove() {
        return minpricemove;
    }

    public void setMinpricemove(BigDecimal minpricemove) {
        this.minpricemove = minpricemove;
    }

    public Short getSpreadalgr() {
        return spreadalgr;
    }

    public void setSpreadalgr(Short spreadalgr) {
        this.spreadalgr = spreadalgr;
    }

    public BigDecimal getSpreaduplmt() {
        return spreaduplmt;
    }

    public void setSpreaduplmt(BigDecimal spreaduplmt) {
        this.spreaduplmt = spreaduplmt;
    }

    public BigDecimal getSpreaddownlmt() {
        return spreaddownlmt;
    }

    public void setSpreaddownlmt(BigDecimal spreaddownlmt) {
        this.spreaddownlmt = spreaddownlmt;
    }

    public Short getMinquantitymove() {
        return minquantitymove;
    }

    public void setMinquantitymove(Short minquantitymove) {
        this.minquantitymove = minquantitymove;
    }

    public String getContractfactorname() {
        return contractfactorname;
    }

    public void setContractfactorname(String contractfactorname) {
        this.contractfactorname = contractfactorname == null ? null : contractfactorname.trim();
    }

    public Long getMinapplynum() {
        return minapplynum;
    }

    public void setMinapplynum(Long minapplynum) {
        this.minapplynum = minapplynum;
    }

    public BigDecimal getMaxapplynum() {
        return maxapplynum;
    }

    public void setMaxapplynum(BigDecimal maxapplynum) {
        this.maxapplynum = maxapplynum;
    }

    public Integer getMinapplyquamove() {
        return minapplyquamove;
    }

    public void setMinapplyquamove(Integer minapplyquamove) {
        this.minapplyquamove = minapplyquamove;
    }

    public Short getPublishalgr() {
        return publishalgr;
    }

    public void setPublishalgr(Short publishalgr) {
        this.publishalgr = publishalgr;
    }

    public BigDecimal getDealerpubcharatio() {
        return dealerpubcharatio;
    }

    public void setDealerpubcharatio(BigDecimal dealerpubcharatio) {
        this.dealerpubcharatio = dealerpubcharatio;
    }

    public BigDecimal getMktdeapubcharatio() {
        return mktdeapubcharatio;
    }

    public void setMktdeapubcharatio(BigDecimal mktdeapubcharatio) {
        this.mktdeapubcharatio = mktdeapubcharatio;
    }

    public BigDecimal getPublishercharatio() {
        return publishercharatio;
    }

    public void setPublishercharatio(BigDecimal publishercharatio) {
        this.publishercharatio = publishercharatio;
    }

    public BigDecimal getMktpubcharatio() {
        return mktpubcharatio;
    }

    public void setMktpubcharatio(BigDecimal mktpubcharatio) {
        this.mktpubcharatio = mktpubcharatio;
    }

  
    public String getContractcurrency() {
		return contractcurrency;
	}

	public void setContractcurrency(String contractcurrency) {
		this.contractcurrency = contractcurrency;
	}

	public Integer getTradedays() {
        return tradedays;
    }

    public void setTradedays(Integer tradedays) {
        this.tradedays = tradedays;
    }

	@Override
	public String toString() {
		return "VIpoABreed [breedid=" + breedid + ", breedname=" + breedname
				+ ", sortid=" + sortid + ", contractfactor=" + contractfactor
				+ ", minpricemove=" + minpricemove + ", spreadalgr="
				+ spreadalgr + ", spreaduplmt=" + spreaduplmt
				+ ", spreaddownlmt=" + spreaddownlmt + ", minquantitymove="
				+ minquantitymove + ", contractfactorname="
				+ contractfactorname + ", minapplynum=" + minapplynum
				+ ", maxapplynum=" + maxapplynum + ", minapplyquamove="
				+ minapplyquamove + ", publishalgr=" + publishalgr
				+ ", dealerpubcharatio=" + dealerpubcharatio
				+ ", mktdeapubcharatio=" + mktdeapubcharatio
				+ ", publishercharatio=" + publishercharatio
				+ ", mktpubcharatio=" + mktpubcharatio + ", contractcurrency="
				+ contractcurrency + ", tradedays=" + tradedays + "]";
	}
    
    
}