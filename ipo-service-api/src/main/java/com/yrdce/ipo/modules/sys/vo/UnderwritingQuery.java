package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: UnderwritingQuery
 * @Description: 承销会员查询承销信息
 * @author bob
 */
public class UnderwritingQuery {
	private String underwriterid;// 承销商ID

	private String commodityid;// 商品ID

	private String commodityname;// 商品名称

	private BigDecimal subscribeprice;// 认购价格

	private Long subscribecounts;// 认购数量

	private BigDecimal proportion;// 占承销商手续费总和的比例

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

	public String getCommodityname() {
		return commodityname;
	}

	public void setCommodityname(String commodityname) {
		this.commodityname = commodityname;
	}

	public BigDecimal getSubscribeprice() {
		return subscribeprice;
	}

	public void setSubscribeprice(BigDecimal subscribeprice) {
		this.subscribeprice = subscribeprice;
	}

	public Long getSubscribecounts() {
		return subscribecounts;
	}

	public void setSubscribecounts(Long subscribecounts) {
		this.subscribecounts = subscribecounts;
	}

	public BigDecimal getProportion() {
		return proportion;
	}

	public void setProportion(BigDecimal proportion) {
		this.proportion = proportion;
	}
}
