package com.yrdce.ipo.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.yrdce.ipo.modules.sys.vo.Spo;
import com.yrdce.ipo.modules.sys.vo.SpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.vo.SpoRation;

/**
 * 
 * @author Bob
 *
 */
public interface SPOService {
	// 客户端分页查询(front)
	public List<Spo> getInfoByPages(Spo spo, String page, String rows);

	// 获得总页数(front)
	public int getInfoCounts(Spo spo);

	// 更新状态(front)
	public int updateRationType(String rationType);

	// 条件查询(mgr)
	public List<SpoCommoditymanmaagement> getSPOList(String page, String rows, SpoCommoditymanmaagement spoComm) throws Exception;

	// 发售商品查询(添加增发)(mgr)
	public Map<String, String> getCommodityidByAll() throws Exception;

	// 添加增发(mgr)
	public int insertSPOInfo(SpoCommoditymanmaagement SpoCom) throws Exception;

	// 增发商品修改(mgr)
	public int updateSPOInfo(SpoCommoditymanmaagement spoComm) throws Exception;

	// 增发商品删除(mgr)
	public int deleteSPOInfo(String spoid) throws Exception;

	// 承销商配售信息(mgr)
	public List<SpoRation> getRationInfo(String spoid) throws Exception;

	// 承销商配售信息修改(mgr)
	public int updateByRation(List<SpoRation> spoRationList) throws Exception;

	// 承销商配售信息插入(mgr)
	public int insertByRation(List<SpoRation> spoRationList) throws Exception;

	// 增发查询总页数
	public int spoCounts(SpoCommoditymanmaagement spoComm);

	// 定向配售查询(mgr)
	public List<SpoRation> getRationInfo(String page, String rows, SpoCommoditymanmaagement spoComm) throws Exception;

	// 删除定向配售信息(mgr)
	public int deleteByRation(Long rationid) throws Exception;

	// 配售查询总页数
	public int rationCounts(SpoCommoditymanmaagement spoComm);

	// 根据增发id查增发信息
	public SpoCommoditymanmaagement getListBySpocom(String spoid);

	// 承销商列表信息
	public List getList();

	// 跟新状态
	public int updateStatus(Integer rationSate, String spoid) throws Exception;

	// 修改增发商品
	public int updateComm(SpoCommoditymanmaagement spoComm) throws Exception;

}
