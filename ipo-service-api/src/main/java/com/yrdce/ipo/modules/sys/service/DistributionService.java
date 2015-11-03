package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Distribution;

public interface DistributionService {
	
	//分页获取用户所有配号信息
	public List<Distribution> getDistriList(String page,String rows);
	
	//获取配号总记录数
	public int getAllDistris();
	
	//获取客户所有配号信息
	public List<Distribution>   findAll();
	
	
}
