package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoCommodityConf {
	private String commodityid;

	private String commodityname;

	private BigDecimal price;

	private long units;

	private long counts;

	private Date starttime;

	private Date endtime;

	private long maxapplynum;

	private BigDecimal status;

	private Long breedid;

	private Integer tradedays;

	private BigDecimal codedelivery;

	private BigDecimal nonissuereg;// 非发行注册

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

	private String contractfactorname;

	private String mapperid;

	private BigDecimal minpricemove;

	private Short spreadalgr;

	private BigDecimal spreaduplmt;

	private BigDecimal spreaddownlmt;

	private Integer minquantitymove;

	private Short tradealgr;

	private BigDecimal buy;

	private BigDecimal sell;

	private BigDecimal mktbuyfeeradio;

	private BigDecimal mktsellfeeradio;

	private BigDecimal warehousedailyrent;

	private Date warehousestartday;

	private BigDecimal trusteedailyrent;

	private BigDecimal insurancedailyrent;

	private Date insurancestartday;

	private Integer freetrusteedays;

	private String deliveryunit;

	private BigDecimal deliunittocontract;

	private Date deliverystartday;

	private BigDecimal registfeeradio;

	private BigDecimal mktregistfeeradio;

	private BigDecimal cancelfeeradio;

	private BigDecimal mktcancelfeeradio;

	private Integer deliverycostbefore;

	private BigDecimal transferfeeradio;

	private String commdetails;

	private Short deliveryProp;

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
		this.commodityname = commodityname == null ? null : commodityname
				.trim();
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getTransferfeeradio() {
		return transferfeeradio;
	}

	public void setTransferfeeradio(BigDecimal transferfeeradio) {
		this.transferfeeradio = transferfeeradio;
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

	public long getUnits() {
		return units;
	}

	public void setUnits(long units) {
		this.units = units;
	}

	public long getCounts() {
		return counts;
	}

	public void setCounts(long counts) {
		this.counts = counts;
	}

	public long getMaxapplynum() {
		return maxapplynum;
	}

	public void setMaxapplynum(long maxapplynum) {
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

	public String getContractfactorname() {
		return contractfactorname;
	}

	public void setContractfactorname(String contractfactorname) {
		this.contractfactorname = contractfactorname == null ? null
				: contractfactorname.trim();
	}

	public String getMapperid() {
		return mapperid;
	}

	public void setMapperid(String mapperid) {
		this.mapperid = mapperid == null ? null : mapperid.trim();
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

	public Integer getMinquantitymove() {
		return minquantitymove;
	}

	public void setMinquantitymove(Integer minquantitymove) {
		this.minquantitymove = minquantitymove;
	}

	public Short getTradealgr() {
		return tradealgr;
	}

	public void setTradealgr(Short tradealgr) {
		this.tradealgr = tradealgr;
	}

	public BigDecimal getBuy() {
		return buy;
	}

	public void setBuy(BigDecimal buy) {
		this.buy = buy;
	}

	public BigDecimal getSell() {
		return sell;
	}

	public void setSell(BigDecimal sell) {
		this.sell = sell;
	}

	public BigDecimal getMktbuyfeeradio() {
		return mktbuyfeeradio;
	}

	public void setMktbuyfeeradio(BigDecimal mktbuyfeeradio) {
		this.mktbuyfeeradio = mktbuyfeeradio;
	}

	public BigDecimal getMktsellfeeradio() {
		return mktsellfeeradio;
	}

	public void setMktsellfeeradio(BigDecimal mktsellfeeradio) {
		this.mktsellfeeradio = mktsellfeeradio;
	}

	public BigDecimal getWarehousedailyrent() {
		return warehousedailyrent;
	}

	public void setWarehousedailyrent(BigDecimal warehousedailyrent) {
		this.warehousedailyrent = warehousedailyrent;
	}

	public Date getWarehousestartday() {
		return warehousestartday;
	}

	public void setWarehousestartday(Date warehousestartday) {
		this.warehousestartday = warehousestartday;
	}

	public BigDecimal getTrusteedailyrent() {
		return trusteedailyrent;
	}

	public void setTrusteedailyrent(BigDecimal trusteedailyrent) {
		this.trusteedailyrent = trusteedailyrent;
	}

	public BigDecimal getInsurancedailyrent() {
		return insurancedailyrent;
	}

	public void setInsurancedailyrent(BigDecimal insurancedailyrent) {
		this.insurancedailyrent = insurancedailyrent;
	}

	public Date getInsurancestartday() {
		return insurancestartday;
	}

	public void setInsurancestartday(Date insurancestartday) {
		this.insurancestartday = insurancestartday;
	}

	public Integer getFreetrusteedays() {
		return freetrusteedays;
	}

	public void setFreetrusteedays(Integer freetrusteedays) {
		this.freetrusteedays = freetrusteedays;
	}

	public String getDeliveryunit() {
		return deliveryunit;
	}

	public void setDeliveryunit(String deliveryunit) {
		this.deliveryunit = deliveryunit == null ? null : deliveryunit.trim();
	}

	public BigDecimal getDeliunittocontract() {
		return deliunittocontract;
	}

	public void setDeliunittocontract(BigDecimal deliunittocontract) {
		this.deliunittocontract = deliunittocontract;
	}

	public Date getDeliverystartday() {
		return deliverystartday;
	}

	public void setDeliverystartday(Date deliverystartday) {
		this.deliverystartday = deliverystartday;
	}

	public BigDecimal getRegistfeeradio() {
		return registfeeradio;
	}

	public void setRegistfeeradio(BigDecimal registfeeradio) {
		this.registfeeradio = registfeeradio;
	}

	public BigDecimal getMktregistfeeradio() {
		return mktregistfeeradio;
	}

	public void setMktregistfeeradio(BigDecimal mktregistfeeradio) {
		this.mktregistfeeradio = mktregistfeeradio;
	}

	public BigDecimal getCancelfeeradio() {
		return cancelfeeradio;
	}

	public void setCancelfeeradio(BigDecimal cancelfeeradio) {
		this.cancelfeeradio = cancelfeeradio;
	}

	public BigDecimal getMktcancelfeeradio() {
		return mktcancelfeeradio;
	}

	public void setMktcancelfeeradio(BigDecimal mktcancelfeeradio) {
		this.mktcancelfeeradio = mktcancelfeeradio;
	}

	public Integer getDeliverycostbefore() {
		return deliverycostbefore;
	}

	public void setDeliverycostbefore(Integer deliverycostbefore) {
		this.deliverycostbefore = deliverycostbefore;
	}

	public String getCommdetails() {
		return commdetails;
	}

	public void setCommdetails(String commdetails) {
		this.commdetails = commdetails;
	}

	public Short getDeliveryProp() {
		return deliveryProp;
	}

	public void setDeliveryProp(Short deliveryProp) {
		this.deliveryProp = deliveryProp;
	}

}