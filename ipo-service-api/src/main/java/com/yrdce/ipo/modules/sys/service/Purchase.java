package com.yrdce.ipo.modules.sys.service;

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

}
