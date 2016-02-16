package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoPositionFlow;
import com.yrdce.ipo.modules.sys.vo.PositionFlow;

@MyBatisDao
public interface IpoPositionFlowMapper {

	/**
	 * 新增持仓流水
	 * @param positionFlow
	 * @return 
	 */
	int insert(PositionFlow positionFlow);
	
	/**
	 * 查询
	 * @param positionFlow
	 * @return
	 */
	List<IpoPositionFlow> queryForList(@Param("param") PositionFlow positionFlow);
	
	/**
	 * 分页查询
	 * @param startIndex
	 * @param endIndex
	 * @param positionFlow
	 * @return
	 */
	List<IpoPositionFlow> queryForPage( @Param("startIndex") int startIndex,
			@Param("endIndex") int endIndex,@Param("param") PositionFlow positionFlow);
	
    /**
     * 
     * @param positionFlow
     * @return
     */
	long queryForCount(@Param("param")PositionFlow positionFlow);
	
	
	
	
	
}
