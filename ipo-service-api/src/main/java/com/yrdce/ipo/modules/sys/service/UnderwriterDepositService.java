package com.yrdce.ipo.modules.sys.service;

import java.util.List;

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

	/**
	 * 查询认购资金处理列表页面
	 * 
	 * @param example
	 * @return
	 */
	public List<UnderwriterDeposit> selectInfoByPage(String page, String rows,
			UnderwriterDeposit example);

	/**
	 * 获取认购资金处理列表页面总记录数
	 * 
	 * @param example
	 * @return
	 */
	public Integer getInfoCounts(UnderwriterDeposit example);

	/**
	 * 查询承销会员的预付货款
	 * 
	 * @param example
	 * @return
	 */
	public UnderwriterDeposit selectInfoByBrokerId(String brokerid);

}
