package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

public class IpoBilloflading {
	private long id;

	private String brokerid;//会员id

	private String brokername;//会员名称

	private String firmid;//交易商id

	private String commodityid;//商品id

	private String commodityname;//商品名称

	private long quantity;//数量

	private long counts;//件数

	private String deliverytype;//类型

	private BigDecimal billofladingfee;//提货单手续费

	private BigDecimal warehousingfee;//仓储费

	private BigDecimal insurance;//保险费

	private BigDecimal trusteefee;//托管费

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