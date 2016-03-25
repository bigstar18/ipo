package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.PositionFlow;
import com.yrdce.ipo.modules.sys.vo.PositionReduce;
import com.yrdce.ipo.modules.sys.vo.PubPositionFlow;

/**
 * Iop 持仓 service
 * 
 * @author wq 2016-2-16
 *
 */
public interface PositionService {
	/**
	 * 查询ipo 持仓流水
	 * 
	 * @param positionFlow
	 * @return
	 */
	public List<PositionFlow> queryFlowForList(PositionFlow positionFlow);

	/**
	 * 查找
	 * 
	 * @param id
	 * @return
	 */
	public PositionFlow findFlow(Long id);

	/**
	 * 分页查询 ipo 持仓流水
	 * 
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @param positionFlow
	 * @return
	 */
	public List<PositionFlow> queryFlowForPage(String pageNoStr, String pageSizeStr,
			PositionFlow positionFlow);

	/**
	 * 查询 ipo 持仓流水数量
	 * 
	 * @param positionFlow
	 * @return
	 */
	public long queryFlowForCount(PositionFlow positionFlow);

	/**
	 * 新增 ipo 持仓流水
	 * 
	 * @param positionFlow
	 * @return
	 */
	public int savePositionFlow(PositionFlow positionFlow);

	/**
	 * 查询减持仓设置
	 * 
	 * @param positionReduce
	 * @return
	 */
	public List<PositionReduce> queryReduceForList(PositionReduce positionReduce);

	/**
	 * 分页查询减持仓设置
	 * 
	 * @param positionReduce
	 * @return
	 */
	public List<PositionReduce> queryReduceForListByPage(String page, String row,
			PositionReduce positionReduce);

	/**
	 * 查询减持仓设置记录数
	 * 
	 * @param positionReduce
	 * @return
	 */
	public int queryReduceCount(PositionReduce positionReduce);

	/**
	 * 新增 减持仓设置
	 * 
	 * @param positionReduce
	 * @return
	 */
	public int savePositionReduce(PositionReduce positionReduce);

	/**
	 * 逻辑删除减持仓设置
	 * 
	 * @param positionReduce
	 * @return
	 */
	public int deletePositionReduce(PositionReduce positionReduce);

	/**
	 * 更新减持状态
	 * 
	 * @param positionReduce
	 * @return
	 */
	public int updateReduceState(PositionReduce positionReduce);

	/**
	 * 客户持仓减持
	 * 
	 * @param positionReduce
	 */
	public void reduceeCustomerHold(PositionReduce positionReduce);

	/**
	 * 分页查询发行商 ipo 持仓流水
	 * 
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @param positionFlow
	 * @return
	 */
	public List<PubPositionFlow> queryPubFlowForPage(String pageNoStr, String pageSizeStr,
			PubPositionFlow positionFlow);

	/**
	 * 查询发行商 ipo 持仓流水数量
	 * 
	 * @param positionFlow
	 * @return
	 */
	public long queryPubFlowForCount(PubPositionFlow positionFlow);

	/**
	 * 分页查询 ipo 持仓流水(承销商)
	 * 
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @param positionFlow
	 * @author bob
	 */
	public List<PositionFlow> queryFlowForUnderwriter(String pageNoStr, String pageSizeStr,
			PositionFlow positionFlow);

	/**
	 * 查询 ipo 持仓流水数量(承销商)
	 * 
	 * @param positionFlow
	 * @author bob
	 */
	public long findForCount(PositionFlow positionFlow);

	/**
	 * 分页查询 ipo 持仓流水(客户)
	 * 
	 * @param pageNoStr
	 * @param pageSizeStr
	 * @param positionFlow
	 * @author bob
	 */
	public List<PositionFlow> queryFlowForCustomer(String pageNoStr, String pageSizeStr,
			PositionFlow positionFlow);

	/**
	 * 查询 ipo 持仓流水数量(客户)
	 * 
	 * @param positionFlow
	 * @author bob
	 */
	public long customerForCount(PositionFlow positionFlow);

}
