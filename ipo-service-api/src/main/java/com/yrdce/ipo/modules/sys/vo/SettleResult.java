package com.yrdce.ipo.modules.sys.vo;

import java.io.Serializable;

public class SettleResult implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7154114444244471776L;

	/*
	 * 一个返回类，用于返回jquery easyui封装的json串
	 */
	private Object broker;

	private Object balance;

	private Object list;

	private Object totalLoan;

	private Object billfladInfo;//经纪会员

	private Object deliveryInfo;//经纪会员

	private Object holdInfo;//经纪会员

	private Object releaInfo;//经纪会员

	private Object ipoSubRevenue;

	private Object bolIncome;

	private Object commodity;

	private Object purchase;//统计报表发行申购

	private Object purcount;//申购数量合计

	private Object purcost;//申购金额合计

	private Object purcir;//发行量合计

	private Object purrate;//申购倍率合计

	public Object getTotalLoan() {
		return totalLoan;
	}

	public void setTotalLoan(Object totalLoan) {
		this.totalLoan = totalLoan;
	}

	public Object getBalance() {
		return balance;
	}

	public void setBalance(Object balance) {
		this.balance = balance;
	}

	public Object getList() {
		return list;
	}

	public void setList(Object list) {
		this.list = list;
	}

	public Object getBroker() {
		return broker;
	}

	public void setBroker(Object broker) {
		this.broker = broker;
	}

	public Object getBillfladInfo() {
		return billfladInfo;
	}

	public void setBillfladInfo(Object billfladInfo) {
		this.billfladInfo = billfladInfo;
	}

	public Object getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(Object deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}

	public Object getHoldInfo() {
		return holdInfo;
	}

	public void setHoldInfo(Object holdInfo) {
		this.holdInfo = holdInfo;
	}

	public Object getReleaInfo() {
		return releaInfo;
	}

	public void setReleaInfo(Object releaInfo) {
		this.releaInfo = releaInfo;
	}

	public Object getIpoSubRevenue() {
		return ipoSubRevenue;
	}

	public void setIpoSubRevenue(Object ipoSubRevenue) {
		this.ipoSubRevenue = ipoSubRevenue;
	}

	public Object getBolIncome() {
		return bolIncome;
	}

	public void setBolIncome(Object bolIncome) {
		this.bolIncome = bolIncome;
	}

	public Object getCommodity() {
		return commodity;
	}

	public void setCommodity(Object commodity) {
		this.commodity = commodity;
	}

	public Object getPurchase() {
		return purchase;
	}

	public void setPurchase(Object purchase) {
		this.purchase = purchase;
	}

	public Object getPurcount() {
		return purcount;
	}

	public void setPurcount(Object purcount) {
		this.purcount = purcount;
	}

	public Object getPurcost() {
		return purcost;
	}

	public void setPurcost(Object purcost) {
		this.purcost = purcost;
	}

	public Object getPurcir() {
		return purcir;
	}

	public void setPurcir(Object purcir) {
		this.purcir = purcir;
	}

	public Object getPurrate() {
		return purrate;
	}

	public void setPurrate(Object purrate) {
		this.purrate = purrate;
	}

	@Override
	public String toString() {
		return "SettleResult [broker=" + broker + ", balance=" + balance + ", list=" + list + ", totalLoan="
				+ totalLoan + "]";
	}

}
