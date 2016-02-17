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

	private Object billfladInfo;

	private Object deliveryInfo;

	private Object holdInfo;

	private Object releaInfo;

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

	@Override
	public String toString() {
		return "SettleResult [broker=" + broker + ", balance=" + balance + ", list=" + list + ", totalLoan="
				+ totalLoan + "]";
	}

}
