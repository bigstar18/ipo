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
	 * 
	 * 摇号
	 * 
	 * @param commId
	 *            商品id
	 * @throws Exception
	 */
	public void lottery(String commId) throws Exception;

	/**
	 * 费用计算和 转持仓
	 * 
	 * @param commId
	 *            商品id
	 * @throws Exception
	 */
	public void orderBalance(String commId) throws Exception;

	/**
	 * 费用计算和 转持仓
	 * 
	 * @throws Exception
	 */
	public void orderBalance() throws Exception;

	/**
	 * ipo 现货转持仓
	 * 
	 * @throws Exception
	 */
	public void ipoTransferGoodsPosition() throws Exception;

	/**
	 * ipo 现货转持仓
	 * 
	 * @param commodityid
	 * @throws Exception
	 */
	public void ipoTransferGoodsPosition(String commodityid) throws Exception;

	// 增发散户配售
	public void placing() throws Exception;

	/**
	 * 在上市日期那天扣除发行商的手续费
	 * @throws Exception
	 */
	public void savePublishHandling()throws Exception ;
	
	
}
