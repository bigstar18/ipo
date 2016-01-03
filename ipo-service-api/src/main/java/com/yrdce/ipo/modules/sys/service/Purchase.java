package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;

/**
 * 
 * @author Bob
 *
 */
public interface Purchase {

	/**
	 * 
	 * Methods:商品申购
	 */
	public int apply(String userid, String sid, Integer count, Integer id) throws Exception;

	/**
	 * 冻结资金
	 * 
	 * @param userId
	 * @param allMonery
	 * @return
	 */
	public BigDecimal frozen(String userId, BigDecimal allMonery);

}
