package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Commodity;

public interface CommodityService {

	//分页获取所有可申购商品列表
	public List<Commodity> findCommList(String page,String rows);
	
	//获取商品总数
	public int getAllComms();
	
	//根据商品代码获取商品详细信息
	public Commodity getCommodity(String commId);
	
	
}
