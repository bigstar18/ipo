package com.yrdce.ipo.modules.sys.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class IpoOrder {
	private String orderid;// 订单

	private String userid;// 交易商id

	private String username;// 交易商名称

	private String commodityid;// 商品id

	private String commodityname;// 商品名称

	private int counts;// 客户申购数

	private Timestamp createtime;// 开始时间

	private BigDecimal frozenfunds;// 资金冻结

	private int frozenst;// 资金状态

	private int sale_id;// 发售表主键ID
	
	private Short tradealgr;

	private BigDecimal buy;
	
	
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

	public int getCommodity_id() {
		return sale_id;
	}

	public void setCommodity_id(int sale_id) {
		this.sale_id = sale_id;
	}

	public int getFrozenst() {
		return frozenst;
	}

	public void setFrozenst(int frozenst) {
		this.frozenst = frozenst;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid == null ? null : userid.trim();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username == null ? null : username.trim();
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

	public int getCounts() {
		return counts;
	}

	public void setCounts(int counts) {
		this.counts = counts;
	}

	public Timestamp getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}

	public BigDecimal getFrozenfunds() {
		return frozenfunds;
	}

	public void setFrozenfunds(BigDecimal frozenfunds) {
		this.frozenfunds = frozenfunds;
	}
}