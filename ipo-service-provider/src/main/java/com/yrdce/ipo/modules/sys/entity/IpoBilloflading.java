package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoBilloflading {
	private long id;

	private String brokerid;

	private String brokername;

	private String firmid;

	private String commodityid;

	private String commodityname;

	private long quantity;

	private long counts;

	private String deliverytype;

	private BigDecimal billofladingfee;

	private BigDecimal warehousingfee;

	private BigDecimal insurance;

	private BigDecimal trusteefee;

	private Date registrationdate;

	private Date createtime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrokerid() {
		return brokerid;
	}

	public void setBrokerid(String brokerid) {
		this.brokerid = brokerid;
	}

	public String getBrokername() {
		return brokername;
	}

	public void setBrokername(String brokername) {
		this.brokername = brokername;
	}

	public String getFirmid() {
		return firmid;
	}

	public void setFirmid(String firmid) {
		this.firmid = firmid == null ? null : firmid.trim();
	}

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

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public long getCounts() {
		return counts;
	}

	public void setCounts(long counts) {
		this.counts = counts;
	}

	public String getDeliverytype() {
		return deliverytype;
	}

	public void setDeliverytype(String deliverytype) {
		this.deliverytype = deliverytype == null ? null : deliverytype.trim();
	}

	public BigDecimal getBillofladingfee() {
		return billofladingfee;
	}

	public void setBillofladingfee(BigDecimal billofladingfee) {
		this.billofladingfee = billofladingfee;
	}

	public BigDecimal getWarehousingfee() {
		return warehousingfee;
	}

	public void setWarehousingfee(BigDecimal warehousingfee) {
		this.warehousingfee = warehousingfee;
	}

	public BigDecimal getInsurance() {
		return insurance;
	}

	public void setInsurance(BigDecimal insurance) {
		this.insurance = insurance;
	}

	public BigDecimal getTrusteefee() {
		return trusteefee;
	}

	public void setTrusteefee(BigDecimal trusteefee) {
		this.trusteefee = trusteefee;
	}

	public Date getRegistrationdate() {
		return registrationdate;
	}

	public void setRegistrationdate(Date registrationdate) {
		this.registrationdate = registrationdate;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
}