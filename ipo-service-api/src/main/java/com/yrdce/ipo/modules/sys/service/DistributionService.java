package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Distribution;

public interface DistributionService {

	// 分页获取用户所有配号信息
	public List<Distribution> getDistriList(String page, String rows, String userid) throws Exception;

	// 获取配号总记录数
	public int getAllDistris(String userid) throws Exception;

	// 获取客户所有配号信息
	public List<Distribution> findAll() throws Exception;

	// 分页获取所有配号信息
	public List<Distribution> getDistriAllList(String page, String rows) throws Exception;

	// 获取总记录
	public int getAllDistribution() throws Exception;
	
	//根据货款冻结情况查询 li
	public List<Distribution> getInfobyFrozen(int frozen) throws Exception;
}
