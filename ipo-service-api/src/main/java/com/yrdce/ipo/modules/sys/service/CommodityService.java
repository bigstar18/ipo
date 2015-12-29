package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Commodity;

/**
 * @author chenjing
 *
 */
public interface CommodityService {

	// 分页获取可申购商品列表
	public List<Commodity> findCommList(String page, String rows);

	// 获取系统时间以后商品总数
	public Integer getAllComms();

	// 获取所有发售商品
	public List<Commodity> findAll();

	// 根据商品代码获取商品详细信息
	public Commodity getCommodity(String commId);

	// mgr手动摇号服务
	public List<Commodity> getList(String page, String rows);

	// 获取商品总数
	public Integer getCounts();

	public Integer getCountsByPage(String commodityid);

	// 根据商品代码分页获取商品详细信息
	public List<Commodity> getCommodityByPage(String page, String rows,
			String commodityid);

	// 发售后台发售商品条件查询
	public List<Commodity> queryByConditions(String page, String rows,
			Commodity comm);

	// 发售后台发售商品条件查询总数
	public Integer countByConditions(Commodity comm);

	// 发售前台发售商品条件查询
	public List<Commodity> queryByConditionsfront(String page, String rows,
			Commodity comm);

	// 发售前台发售商品条件查询总数
	public Integer countByConditionsfront(Commodity comm);
	
	//查询所有的商品代码
	List<String>  queryNames();
	
	//根据id获取商品对象
	Commodity queryByComid(String comid);
}
