package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoPositionReduce;
import com.yrdce.ipo.modules.sys.vo.PositionReduce;

@MyBatisDao
public interface IpoPositionReduceMapper {

	/**
	 * 新增
	 * 
	 * @param positionReduce
	 * @return
	 */
	int insert(PositionReduce positionReduce);

	/**
	 * 查询
	 * 
	 * @param positionReduce
	 * @return
	 */
	List<IpoPositionReduce> queryForList(
			@Param("param") PositionReduce positionReduce);

	/**
	 * 删除
	 * 
	 * @param positionReduce
	 * @return
	 */
	int deleteById(PositionReduce positionReduce);

	/**
	 * 更新状态
	 * 
	 * @param positionReduce
	 * @return
	 */
	int updateState(PositionReduce positionReduce);

	/**
	 * 分页查询
	 * 
	 * @param positionReduce
	 * @return
	 */
	List<IpoPositionReduce> queryForPositionId(@Param("beginnum") int beginnum,
			@Param("endnum") int endnum,
			@Param("param") PositionReduce positionReduce);

	/**
	 * 查询持仓对应减持设置记录数
	 * 
	 * @param positionReduce
	 * @return
	 */
	int quertReduceCount(@Param("param") PositionReduce positionReduce);

}
