package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Commodity;

public interface CommodityService {

	//获取所有可申购商品列表
	public List<Commodity> findCommList(String page,String rows);
	
	//根据商品代码获取商品详细信息
	public Commodity getCommodity(String commId);
	
	//获取当前商品的申购额度
	public String  getPurAmount(Commodity comm);

	//新增商品
	public void add(Commodity comm);

	//删除商品
	public void delete(Commodity comm);
	
	
	
}
