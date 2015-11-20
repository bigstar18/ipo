package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Tradetime;

public interface TradetimeService {
	// 查询交易节
	public List<Tradetime> select(String page, String rows);

	// 修改交易节
	public int upDate(Tradetime tradetime);

	// 增加交易节
	public int insert(Tradetime tradetime);

	// 删除交易节
	public int delete(Object[] ids);

	// 根据主键查询交易节
	public Tradetime selectByKey(Short id);

	// 根据交易节主键查询相关联的商品和品种
	public int selectByBreedAndCommodity(Short id);

	// 查询交易节总数
	public int selectByCounts();

}
