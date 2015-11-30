package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Nottradeday;
import com.yrdce.ipo.modules.sys.vo.Tradetime;

/**
 * 
 * @author Bob
 *
 */
public interface TradetimeService {
	// 查询交易节（分页）
	public List<Tradetime> selectByPage(String page, String rows);

	// 修改交易节
	public int upDate(Tradetime tradetime);

	// 增加交易节
	public int insert(Tradetime tradetime);

	// 删除交易节
	public int delete(String ids);

	// 根据主键查询交易节
	public Tradetime selectByKey(Short id);

	// 根据交易节主键查询相关联的商品和品种
	public int selectByBreedAndCommodity(Short id);

	// 查询交易节总数
	public int selectByCounts();

	// 查询所有交易节
	public List<Tradetime> selectAll();

	// 非交易日插入(删除、更新、提交共用此方法)
	public int insertByNottradeday(Nottradeday notTradeDay);

	// 非交易日查询
	public Nottradeday select();

}
