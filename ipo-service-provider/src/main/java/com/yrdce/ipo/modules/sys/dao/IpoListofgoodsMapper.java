package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.CrudDao;
import com.yrdce.ipo.modules.sys.entity.IpoListofgoods;
import com.yrdce.ipo.modules.sys.entity.IpoListofgoodsExample;

public interface IpoListofgoodsMapper extends CrudDao<IpoListofgoodsExample> {
	int countByExample(IpoListofgoodsExample example);

	int deleteByExample(IpoListofgoodsExample example);

	int deleteByPrimaryKey(BigDecimal id);

	int insert(IpoListofgoods record);

	int insertSelective(IpoListofgoods record);

	List<IpoListofgoods> selectByExample(IpoListofgoodsExample example);

	IpoListofgoods selectByPrimaryKey(BigDecimal id);

	int updateByExampleSelective(@Param("record") IpoListofgoods record, @Param("example") IpoListofgoodsExample example);

	int updateByExample(@Param("record") IpoListofgoods record, @Param("example") IpoListofgoodsExample example);

	int updateByPrimaryKeySelective(IpoListofgoods record);

	int updateByPrimaryKey(IpoListofgoods record);
}