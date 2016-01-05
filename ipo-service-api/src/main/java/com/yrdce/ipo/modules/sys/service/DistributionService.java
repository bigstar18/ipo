package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Distribution;

public interface DistributionService {

	// 分页获取用户所有配号信息
	public List<Distribution> getDistriList(String page, String rows, String userid, String condition) throws Exception;

	// 获取配号总记录数
	public int getAllDistris(String userid, String condition) throws Exception;

	// 获取客户所有配号信息
	public List<Distribution> findAll() throws Exception;

	// 分页获取所有配号信息
	public List<Distribution> getDistriAllList(String page, String rows) throws Exception;

	// 分页获取用户中签信息
	public List<Distribution> getBallotInfo(String page, String rows, String userid, String date);

	// 用户中签总条数
	public int ballotCounts(String userid, String date);

	// 获取总记录
	public int getAllDistribution() throws Exception;

	// 根据货款冻结情况查询 li
	public List<Distribution> getInfobyFrozen(int frozen) throws Exception;

	/**
	 * 根据商品id，查询未结算的摇号单 hxx
	 * 
	 * @param commId
	 * @return
	 * @throws Exception
	 */
	public List<Distribution> queryUnsettleOrdersByCommId(String commId) throws Exception;

	public int updateOrderSettled(String orderId) throws Exception;
}
