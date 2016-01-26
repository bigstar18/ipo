package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

/*
 * 发售商品表
 */
public class IpoCommodityExtended {
	private String id;

	private String commodityid; // 商品代码

	private String commodityname; // 商品名称

	private BigDecimal price;// 发售价格

	private int units;// 配售单位

	private long counts;// 发售总数

	private Date starttime;// 发售日期

	private Date endtime;// 截止日期

	private long maxapplynum;// 申购额度

	private int status;// 申购状态

	private int ccounts;// 客户申购数

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getMaxapplynum() {
		return maxapplynum;
	}

	public void setMaxapplynum(long maxapplynum) {
		this.maxapplynum = maxapplynum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
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

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public long getCounts() {
		return counts;
	}

	public void setCounts(long counts) {
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

	public int getCcounts() {
		return ccounts;
	}

	public void setCcounts(int ccounts) {
		this.ccounts = ccounts;
	}

}