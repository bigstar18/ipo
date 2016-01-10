package com.yrdce.ipo.modules.sys.service;


/**
 * 定时任务相关�?service
 * 
 * @author wq 2016-1-2
 *
 */
public interface TaskService {
	/**
	 * 配号
	 * 
	 * @param commodityid
	 * @throws Exception
	 */
	public void distribution(String commodityid) throws Exception;

	/**
	 * 配号
	 * 
	 * @throws Exception
	 */
	public void distribution() throws Exception;

	/**
	 * 摇号
	 * 
	 * @throws Exception
	 */
	public void lottery() throws Exception;

	/**
	 * 摇号
	 * 
	 * @param commId
	 *            商品id
	 * @throws Exception
	 */
	public void lottery(String commId) throws Exception;

	/**
	 * 费用计算�?转持�?
	 * 
	 * @param commId
	 *            商品id
	 * @throws Exception
	 */
	public void orderBalance(String commId) throws Exception;

	/**
	 * 费用计算�?转持�?
	 * 
	 * @throws Exception
	 */
	public void orderBalance() throws Exception;
	
	/**
	 * ipo 转现货持�?
	 * @throws Exception
	 */
	public  void ipoTransferGoodsPosition()throws Exception;
	/**
	 * ipo 转现货持�?
	 * @param commodityid 商品id
	 * @throws Exception
	 */
	public void ipoTransferGoodsPosition(String commodityid) throws Exception;
	
	

}
