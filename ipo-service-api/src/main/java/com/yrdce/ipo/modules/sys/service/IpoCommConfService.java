package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;


public interface IpoCommConfService {
	
	//通过品种ID分页获取商品列表
		public List<VIpoCommConf> findIpoCommConfByBreedid(Long Breedid,String page,String rows);
		
	//通过所有商品ID
	    public List<String> findIpoCommConfIds();
		
	//根据品种ID获取对应商品总数
		public int getTotalIpoCommsByBreedid(Long Breedid);
		
    //根据商品ID获取商品
		public VIpoCommConf getVIpoCommConfByCommid(String commid);
		
	//增加商品
		public void addCommodity(VIpoCommConf comm);

	//修改商品
		public void updateCommodity(VIpoCommConf comm);
		
	//根据商品ID删除商品
		public void deleteCommodityByCommid(String commid);
		
	//根据品种ID删除商品
	public void deleteCommodityByBreedID(Long breedid);
	
	//分页获取所有商品
	public List<VIpoCommConf> findIpoCommConf(String page,String rows);
	
	//查询所有商品记录数
	public int getAllComms();
}
