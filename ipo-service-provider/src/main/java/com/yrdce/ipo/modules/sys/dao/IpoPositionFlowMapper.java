package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoPositionFlow;
import com.yrdce.ipo.modules.sys.entity.IpoPubPositionFlow;
import com.yrdce.ipo.modules.sys.vo.PositionFlow;
import com.yrdce.ipo.modules.sys.vo.PubPositionFlow;

@MyBatisDao
public interface IpoPositionFlowMapper {

	/**
	 * 新增持仓流水
	 * 
	 * @param positionFlow
	 * @return
	 */
	int insert(PositionFlow positionFlow);

	/**
	 * 查询
	 * 
	 * @param positionFlow
	 * @return
	 */
	List<IpoPositionFlow> queryForList(@Param("param") PositionFlow positionFlow);

	/**
	 * 分页查询
	 * 
	 * @param startIndex
	 * @param endIndex
	 * @param positionFlow
	 * @return
	 */
	List<IpoPositionFlow> queryForPage(@Param("startIndex") int startIndex,
			@Param("endIndex") int endIndex,
			@Param("param") PositionFlow positionFlow);

	/**
	 * 
	 * @param positionFlow
	 * @return
	 */
	long queryForCount(@Param("param") PositionFlow positionFlow);

	/**
	 * 分页查询发行商转持仓流水
	 * 
	 * @param startIndex
	 * @param endIndex
	 * @param positionFlow
	 * @return
	 */
	List<IpoPubPositionFlow> queryPubFlowForPage(
			@Param("startIndex") int startIndex,
			@Param("endIndex") int endIndex,
			@Param("param") PubPositionFlow positionFlow);

	/**
	 * 发行商转持仓流水记录数
	 * 
	 * @param positionFlow
	 * @return
	 */
	long queryPubFlowForCount(@Param("param") PubPositionFlow positionFlow);

	/**
	 * 更新释放数量
	 * 
	 * @param positionFlow
	 * @return
	 */
	int updateFreeqty(PositionFlow positionFlow);

	/**
	 * 转现货持仓
	 * 
	 * @param commodityid
	 * @param operUser
	 */
	void transferGoodsPosition(@Param("commodityid") String commodityid,
			@Param("operUser") String operUser);

}
