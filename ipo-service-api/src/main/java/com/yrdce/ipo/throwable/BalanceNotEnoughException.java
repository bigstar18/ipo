package com.yrdce.ipo.throwable;
/**
 * 余额不足异常
 * @author wq 2016-1-21
 *
 */
 
public class BalanceNotEnoughException extends Exception {
 
	private static final long serialVersionUID = 1491904774701255977L;

	public BalanceNotEnoughException() {
		super();
	}
	
	public BalanceNotEnoughException(String msg) {
		super(msg);
	}
	
	
}
