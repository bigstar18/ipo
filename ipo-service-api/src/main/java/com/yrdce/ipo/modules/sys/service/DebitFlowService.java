package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.DebitFlow;
/**
 * 扣款流水
 * @author wq 2016-1-26
 *
 */
public interface DebitFlowService {

	/**
	 * 分页查询扣款流水
	 * @param pageNo
	 * @param pageSize
	 * @param debitFlow
	 * @return
	 */
	public List<DebitFlow> queryForPage( String pageNo,String pageSize,DebitFlow debitFlow);
	
	/**
	 * 查询扣款流水数量
	 * @param debitFlow
	 * @return
	 */
	public long queryForCount(DebitFlow debitFlow);
	/**
	 * 保存扣款流水
	 * @param debitFlow
	 */
	public void save(DebitFlow debitFlow);
	
	
	/**
	 * 保存线下扣款流水
	 * @param debitFlow
	 */
	public void saveOffline(DebitFlow debitFlow);
	
	
	
	
	
	
	
}
