package com.yrdce.ipo.modules.sys.service;

public interface Purchase {

	/**
	 * 
	 * Methods:商品申购 variable :id：客户的ID，price：商品单价，count：申购商品总数
	 */
	public int apply(String id, int count);

}
