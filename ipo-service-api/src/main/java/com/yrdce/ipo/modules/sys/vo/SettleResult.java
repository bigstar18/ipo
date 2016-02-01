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
	private Object balance;

	private Object list;

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

	@Override
	public String toString() {
		return "SettleResult [balance=" + balance + ", list=" + list + "]";
	}

}
