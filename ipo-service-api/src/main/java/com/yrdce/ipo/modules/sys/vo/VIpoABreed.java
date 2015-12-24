package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author chenjing 发售品种
 */
public class VIpoABreed implements Serializable {
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

	private Short tradealgr;

	private BigDecimal buy;

	private BigDecimal sell;

	private BigDecimal mktbuyfeeradio;

	private BigDecimal mktsellfeeradio;

	private BigDecimal warehousedailyrent;

	private BigDecimal trusteedailyrent;

	private BigDecimal insurancedailyrent;

	private Integer freetrusteedays;

	private String deliveryunit;

	private BigDecimal deliunittocontract;

	private BigDecimal registfeeradio;

	private BigDecimal mktregistfeeradio;

	private BigDecimal cancelfeeradio;

	private BigDecimal mktcancelfeeradio;

	private Integer deliverycostbefore;

	private BigDecimal transferfeeradio;

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

	public String getContractfactorname() {
		return contractfactorname;
	}

	public void setContractfactorname(String contractfactorname) {
		this.contractfactorname = contractfactorname == null ? null
				: contractfactorname.trim();
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
		this.deliveryunit = deliveryunit;
	}

	public BigDecimal getDeliunittocontract() {
		return deliunittocontract;
	}

	public void setDeliunittocontract(BigDecimal deliunittocontract) {
		this.deliunittocontract = deliunittocontract;
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

	public BigDecimal getTransferfeeradio() {
		return transferfeeradio;
	}

	public void setTransferfeeradio(BigDecimal transferfeeradio) {
		this.transferfeeradio = transferfeeradio;
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
				+ contractcurrency + ", tradedays=" + tradedays
				+ ", tradealgr=" + tradealgr + ", buy=" + buy + ", sell="
				+ sell + ", mktbuyfeeradio=" + mktbuyfeeradio
				+ ", mktsellfeeradio=" + mktsellfeeradio
				+ ", warehousedailyrent=" + warehousedailyrent
				+ ", trusteedailyrent=" + trusteedailyrent
				+ ", insurancedailyrent=" + insurancedailyrent
				+ ", freetrusteedays=" + freetrusteedays + ", deliveryunit="
				+ deliveryunit + ", deliunittocontract=" + deliunittocontract
				+ ", registfeeradio=" + registfeeradio + ", mktregistfeeradio="
				+ mktregistfeeradio + ", cancelfeeradio=" + cancelfeeradio
				+ ", mktcancelfeeradio=" + mktcancelfeeradio
				+ ", deliverycostbefore=" + deliverycostbefore
				+ ", transferfeeradio=" + transferfeeradio + "]";
	}

}