package com.yrdce.ipo.modules.sys.service;

import com.yrdce.ipo.modules.sys.vo.UnderwriterDeposit;

/**
 * 承销会员认购管理暂扣预付货款
 * 
 * @author chenjing
 *
 */
public interface UnderwriterDepositService {

	/**
	 * 添加暂扣预付货款信息
	 * 
	 * @param example
	 * @return
	 */
	public void insertInfo(UnderwriterDeposit example);

}
