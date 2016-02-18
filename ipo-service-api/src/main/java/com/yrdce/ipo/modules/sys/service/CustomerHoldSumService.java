package com.yrdce.ipo.modules.sys.service;

public interface CustomerHoldSumService {

	
	 /**
	  * 解冻客户持仓
	  * @param unfreezeqty 解冻数量
	  * @param customerid  客户代码
	  * @param commodityid 商品编码
	  * @param bsFlag      买卖标记
	  */
	 public void unfreezeCustomerHold(Long unfreezeqty,String customerid,String commodityid,short bsFlag);
}
