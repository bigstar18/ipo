package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Nottradeday;
import com.yrdce.ipo.modules.sys.vo.Tradetime;
import com.yrdce.ipo.modules.sys.vo.TradetimeComm;

/**
 * 
 * @author Bob
 *
 */
public interface TradetimeService {
	// 查询交易节（分页）
	public List<Tradetime> selectByPage(String page, String rows) throws Exception;

	// 修改交易节
	public int upDate(Tradetime tradetime, String comms) throws Exception;

	// 查询与交易节关联的商品
	public List<TradetimeComm> getTradetimeByComm(Short id) throws Exception;

	// 增加交易节

	public int insert(Tradetime tradetime, String comms) throws Exception;

	// 删除交易节
	public int delete(String ids) throws Exception;

	// 根据主键查询交易节
	public Tradetime selectByKey(Short id) throws Exception;

	// 根据交易节主键查询相关联的商品和品种
	public boolean tradeTimeAndCom(String id) throws Exception;

	// 查询交易节总数
	public int selectByCounts() throws Exception;

	// 查询所有交易节
	public List<Tradetime> selectAll() throws Exception;

	// 非交易日插入(删除、更新、提交共用此方法)
	public int insertByNottradeday(Nottradeday notTradeDays) throws Exception;

	// 非交易日查询
	public Nottradeday select() throws Exception;

	// 判断当前时间是否在交易节前5分钟
	public boolean timeComparison();

	// 判断当前是否是交易节时间
	public boolean getTime() throws Exception;

}
