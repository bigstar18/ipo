package com.yrdce.ipo.modules.sys.vo;

import java.math.BigDecimal;

/**
 * @ClassName: Purchase
 * @Description:统计报表发行申购
 * @author bob
 */
public class Purchase {
	private String firmId;//交易商id

	private String firmName;//交易商名称

	private int count;//申购数量

	private BigDecimal cost;//申购金额

	private long circulation;//发行量

	private double rate;//申购倍率

	public String getFirmId() {
		return firmId;
	}

	public void setFirmId(String firmId) {
		this.firmId = firmId;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public long getCirculation() {
		return circulation;
	}

	public void setCirculation(long circulation) {
		this.circulation = circulation;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}
}
