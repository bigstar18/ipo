package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;

/**
 * 承销商
 * 
 * @author Bob
 *
 */
public class Iposales {
	private String salesid;// 承销商代码

	private String commodityid;// 商品代码

	private int subscriptionNum;// 认购数量

	private int proportion;// 占承销商会员手续费综合的比例

	private BigDecimal payment;// 预付货款

	private String subscriptionCommodity;// 认购商品

	public String getSalesid() {
		return salesid;
	}

	public void setSalesid(String salesid) {
		this.salesid = salesid;
	}

	public String getCommodityid() {
		return commodityid;
	}

	public void setCommodityid(String commodityid) {
		this.commodityid = commodityid;
	}

	public int getSubscriptionNum() {
		return subscriptionNum;
	}

	public void setSubscriptionNum(int subscriptionNum) {
		this.subscriptionNum = subscriptionNum;
	}

	public int getProportion() {
		return proportion;
	}

	public void setProportion(int proportion) {
		this.proportion = proportion;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public String getSubscriptionCommodity() {
		return subscriptionCommodity;
	}

	public void setSubscriptionCommodity(String subscriptionCommodity) {
		this.subscriptionCommodity = subscriptionCommodity;
	}

}
