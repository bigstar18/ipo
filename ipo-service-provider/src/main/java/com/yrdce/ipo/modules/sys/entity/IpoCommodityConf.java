package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class IpoCommodityConf {
    private String commodityid;

    private String commodityname;

    private BigDecimal price;

    private BigDecimal units;

    private BigDecimal counts;

    private Date starttime;

    private Date endtime;

    private BigDecimal maxapplynum;

    private BigDecimal status;

    private Long breedid;

    private Integer tradedays;

    private BigDecimal codedelivery;

    private BigDecimal nonissuereg;

    private String pubmemberid;

    private Long minapplynum;

    private Integer minapplyquamove;

    private Short publishalgr;

    private BigDecimal dealerpubcharatio;

    private BigDecimal mktdeapubcharatio;

    private BigDecimal publishercharatio;

    private BigDecimal mktpubcharatio;

    private Short currstatus;

    private BigDecimal supervisedprice;

    private Date listingdate;

    private Date lasttradate;

    private BigDecimal contractfactor;

    private BigDecimal minpricemove;

    private Integer minquantitymove;

    private Short spreadalgr;

    private BigDecimal spreaduplmt;

    private BigDecimal spreaddownlmt;

    private String contractfactorname;

    private String mapperid;
    
    private List<IpoTradetime> tradetime;

    public String getCommodityid() {
        return commodityid;
    }

    public void setCommodityid(String commodityid) {
        this.commodityid = commodityid == null ? null : commodityid.trim();
    }

    public String getCommodityname() {
        return commodityname;
    }

    public void setCommodityname(String commodityname) {
        this.commodityname = commodityname == null ? null : commodityname.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getUnits() {
        return units;
    }

    public void setUnits(BigDecimal units) {
        this.units = units;
    }

    public BigDecimal getCounts() {
        return counts;
    }

    public void setCounts(BigDecimal counts) {
        this.counts = counts;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public BigDecimal getMaxapplynum() {
        return maxapplynum;
    }

    public void setMaxapplynum(BigDecimal maxapplynum) {
        this.maxapplynum = maxapplynum;
    }

    public BigDecimal getStatus() {
        return status;
    }

    public void setStatus(BigDecimal status) {
        this.status = status;
    }

    public Long getBreedid() {
        return breedid;
    }

    public void setBreedid(Long breedid) {
        this.breedid = breedid;
    }

    public Integer getTradedays() {
        return tradedays;
    }

    public void setTradedays(Integer tradedays) {
        this.tradedays = tradedays;
    }

    public BigDecimal getCodedelivery() {
        return codedelivery;
    }

    public void setCodedelivery(BigDecimal codedelivery) {
        this.codedelivery = codedelivery;
    }

    public BigDecimal getNonissuereg() {
        return nonissuereg;
    }

    public void setNonissuereg(BigDecimal nonissuereg) {
        this.nonissuereg = nonissuereg;
    }

    public String getPubmemberid() {
        return pubmemberid;
    }

    public void setPubmemberid(String pubmemberid) {
        this.pubmemberid = pubmemberid == null ? null : pubmemberid.trim();
    }

    public Long getMinapplynum() {
        return minapplynum;
    }

    public void setMinapplynum(Long minapplynum) {
        this.minapplynum = minapplynum;
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

    public Short getCurrstatus() {
        return currstatus;
    }

    public void setCurrstatus(Short currstatus) {
        this.currstatus = currstatus;
    }

    public BigDecimal getSupervisedprice() {
        return supervisedprice;
    }

    public void setSupervisedprice(BigDecimal supervisedprice) {
        this.supervisedprice = supervisedprice;
    }

    public Date getListingdate() {
        return listingdate;
    }

    public void setListingdate(Date listingdate) {
        this.listingdate = listingdate;
    }

    public Date getLasttradate() {
        return lasttradate;
    }

    public void setLasttradate(Date lasttradate) {
        this.lasttradate = lasttradate;
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

    public Integer getMinquantitymove() {
        return minquantitymove;
    }

    public void setMinquantitymove(Integer minquantitymove) {
        this.minquantitymove = minquantitymove;
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

    public String getContractfactorname() {
        return contractfactorname;
    }

    public void setContractfactorname(String contractfactorname) {
        this.contractfactorname = contractfactorname == null ? null : contractfactorname.trim();
    }

    public String getMapperid() {
        return mapperid;
    }

    public void setMapperid(String mapperid) {
        this.mapperid = mapperid == null ? null : mapperid.trim();
    }

	public List<IpoTradetime> getTradetime() {
		return tradetime;
	}

	public void setTradetime(List<IpoTradetime> tradetime) {
		this.tradetime = tradetime;
	}
    
    
}