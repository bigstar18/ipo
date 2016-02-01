package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 发行商结算表
 * 
 * @author chenjing
 *
 */
public class PublisherSettle implements Serializable {
	private String commodityid;

	private String commodityname;

	private BigDecimal price;

	private BigDecimal loan;

	private BigDecimal handing;

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid;
	}

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getLoan() {
		return loan;
	}

	public void setLoan(BigDecimal loan) {
		this.loan = loan;
	}

	public BigDecimal getHanding() {
		return handing;
	}

	public void setHanding(BigDecimal handing) {
		this.handing = handing;
	}

	@Override
	public String toString() {
		return "PublisherSettle [commodityid=" + commodityid
				+ ", commodityname=" + commodityname + ", price=" + price
				+ ", loan=" + loan + ", handing=" + handing + "]";
	}

}
