package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 发行商的承销会员查询
 * 
 * @author chenjing
 *
 */
public class IpoUnderWriters {
	private Long subscribeid;

	private String underwriterid;// 承销商ID

	private String commodityid;// 商品ID

	private String underwritername;// 承销商姓名

	private String commodityname;// 商品姓名

	private String pubmemberid;// 发行商代码

	private BigDecimal price;

	private long counts;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date starttime;

	private Long subscribecounts;// 认购数量

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date listingdate;

	public Long getSubscribeid() {
		return subscribeid;
	}

	public void setSubscribeid(Long subscribeid) {
		this.subscribeid = subscribeid;
	}

	public String getUnderwriterid() {
		return underwriterid;
	}

	public void setUnderwriterid(String underwriterid) {
		this.underwriterid = underwriterid;
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid;
	}

	public String getUnderwritername() {
		return underwritername;
	}

	public void setUnderwritername(String underwritername) {
		this.underwritername = underwritername;
	}

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname;
	}

	public String getPubmemberid() {
		return pubmemberid;
	}

	public void setPubmemberid(String pubmemberid) {
		this.pubmemberid = pubmemberid;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
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

	public Long getSubscribecounts() {
		return subscribecounts;
	}

	public void setSubscribecounts(Long subscribecounts) {
		this.subscribecounts = subscribecounts;
	}

	public Date getListingdate() {
		return listingdate;
	}

	public void setListingdate(Date listingdate) {
		this.listingdate = listingdate;
	}

	@Override
	public String toString() {
		return "IpoUnderWriters [subscribeid=" + subscribeid
				+ ", underwriterid=" + underwriterid + ", commodityid="
				+ commodityid + ", underwritername=" + underwritername
				+ ", commodityname=" + commodityname + ", pubmemberid="
				+ pubmemberid + ", price=" + price + ", counts=" + counts
				+ ", starttime=" + starttime + ", subscribecounts="
				+ subscribecounts + ", listingdate=" + listingdate + "]";
	}

}