package com.yrdce.ipo.modules.sys.service;

public interface CustomerHoldSumService {

	/**
	 * 冻结客户持仓
	 * 
	 * @param freezeqty
	 *            冻结数量
	 * @param customerid
	 *            客户代码
	 * @param commodityid
	 *            商品编码
	 * @param bsFlag
	 *            买卖标记
	 */
	public void freezeCustomerHold(Long frozenqty, String customerid, String commodityid, short bsFlag);

	/**
	 * 解冻客户持仓
	 * 
	 * @param unfreezeqty
	 *            解冻数量
	 * @param customerid
	 *            客户代码
	 * @param commodityid
	 *            商品编码
	 * @param bsFlag
	 *            买卖标记
	 */
	public void unfreezeCustomerHold(Long unfreezeqty, String customerid, String commodityid, short bsFlag);

	/**
	 * 增加客户持仓
	 * 
	 * @param frozenqty
	 * @param customerid
	 * @param commodityid
	 * @param bsFlag
	 */
	public void increaseCustomerHold(Long frozenqty, String customerid, String commodityid, short bsFlag);

	/**
	 * 减少客户持仓
	 * 
	 * @param frozenqty
	 * @param customerid
	 * @param commodityid
	 * @param bsFlag
	 */
	public void reduceCustomerHold(Long frozenqty, String customerid, String commodityid, short bsFlag);

}
