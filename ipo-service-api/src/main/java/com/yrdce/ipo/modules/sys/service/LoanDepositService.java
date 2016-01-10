package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Firmcurfunds;
import com.yrdce.ipo.modules.sys.vo.UnderwriterDeposit;
import com.yrdce.ipo.modules.sys.vo.UnderwriterSubscribe;

/*
 *承销会员服务接口
 *李伟东
 *2015.12.14 
 **/
public interface LoanDepositService {

	// 认购资金明细
	public List<UnderwriterSubscribe> GetAllInfo(String page, String rows, String underwriterid);

	public int getpage(String underwriterid);

	public List<Firmcurfunds> GetInfoByName(String name);// 根据畅销会员名称查信息

	public List<Firmcurfunds> GetInfoByType(int memberType);// 根据会员类型查询

	/**
	 * 2016.1.9 li 认购资金
	 */
	public List<UnderwriterDeposit> getSubFundsInfo(String page, String rows, String underwriterid);

	public int getSubFundsInfoCounts(String underwriterid);

}
