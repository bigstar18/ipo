package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;

public interface IpoCommConfService {

	// 通过品种ID分页获取商品列表
	public List<VIpoCommConf> findIpoCommConfByBreedid(Long Breedid,
			String page, String rows);

	// 通过所有商品ID
	public List<String> findIpoCommConfIds();

	// 根据品种ID获取对应商品总数
	public int getTotalIpoCommsByBreedid(Long Breedid);

	// 根据商品ID获取商品
	public VIpoCommConf getVIpoCommConfByCommid(String commid);

	// 增加商品
	public String addCommodity(VIpoCommConf comm);

	// 修改商品
	public String updateCommodity(VIpoCommConf comm);

	// 根据商品ID删除商品
	public void deleteCommodityByCommid(String commid);

	// 根据品种ID删除商品
	public void deleteCommodityByBreedID(Long breedid);

	// 分页查询所有商品
	public List<VIpoCommConf> findIpoCommConfsByPage(String page, String rows);

	// 查询所有商品
	public List<VIpoCommConf> findIpoCommConfs();

	// 获取所有商品数
	public int getAllComms();

	// 根据条件分页查询所有商品
	public List<VIpoCommConf> findIpoCommConfsByExample(String page,
			String rows, VIpoCommConf example);

	// 根据条件获取商品数
	public int getNumsByExample(VIpoCommConf example);

	// 获取设置交收属性和托管属性的商品
	public List<VIpoCommConf> selectCommodityByExample(VIpoCommConf example);

}
