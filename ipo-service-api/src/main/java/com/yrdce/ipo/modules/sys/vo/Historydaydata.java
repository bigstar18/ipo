package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author chenjing
 *
 *         行情价格
 */
public class Historydaydata implements Serializable {
	private String marketid;

	private String commodityid;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date tradedate;

	private BigDecimal openprice;

	private BigDecimal closeprice;

	private BigDecimal highprice;

	private BigDecimal lowprice;

	private BigDecimal balanceprice;

	private BigDecimal totalamount;

	private BigDecimal totalmoney;

	private BigDecimal reservecount;

	public String getMarketid() {
		return marketid;
	}

	public void setMarketid(String marketid) {
		this.marketid = marketid;
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid;
	}

	public Date getTradedate() {
		return tradedate;
	}

	public void setTradedate(Date tradedate) {
		this.tradedate = tradedate;
	}

	public BigDecimal getOpenprice() {
		return openprice;
	}

	public void setOpenprice(BigDecimal openprice) {
		this.openprice = openprice;
	}

	public BigDecimal getCloseprice() {
		return closeprice;
	}

	public void setCloseprice(BigDecimal closeprice) {
		this.closeprice = closeprice;
	}

	public BigDecimal getHighprice() {
		return highprice;
	}

	public void setHighprice(BigDecimal highprice) {
		this.highprice = highprice;
	}

	public BigDecimal getLowprice() {
		return lowprice;
	}

	public void setLowprice(BigDecimal lowprice) {
		this.lowprice = lowprice;
	}

	public BigDecimal getBalanceprice() {
		return balanceprice;
	}

	public void setBalanceprice(BigDecimal balanceprice) {
		this.balanceprice = balanceprice;
	}

	public BigDecimal getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(BigDecimal totalamount) {
		this.totalamount = totalamount;
	}

	public BigDecimal getTotalmoney() {
		return totalmoney;
	}

	public void setTotalmoney(BigDecimal totalmoney) {
		this.totalmoney = totalmoney;
	}

	public BigDecimal getReservecount() {
		return reservecount;
	}

	public void setReservecount(BigDecimal reservecount) {
		this.reservecount = reservecount;
	}

}