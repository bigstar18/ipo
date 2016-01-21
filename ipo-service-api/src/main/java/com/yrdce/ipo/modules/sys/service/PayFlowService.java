package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.PayFlow;

/**
 * 付款流水
 * @author wq 2016-1-21
 *
 */
public interface PayFlowService {

	
	/**
	 * 分页查询发行货款费用
	 * @param PayFlow
	 * @return
	 */
	public List<PayFlow> queryPublishGoodsForPage( String pageNo,String pageSize,PayFlow payFlow);
	
	/**
	 * 查询发行货款费用数量
	 * @param PayFlow
	 * @return
	 */
	public long queryPublishGoodsForCount(PayFlow payFlow);
	
	
	/**
	 * 付款
	 */
	public void pay(PayFlow payFlow);
	
	
	
	
	
}
