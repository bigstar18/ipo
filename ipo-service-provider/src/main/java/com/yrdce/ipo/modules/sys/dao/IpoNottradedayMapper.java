package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoNottradeday;
import com.yrdce.ipo.modules.sys.entity.IpoNottradedayExample;

@MyBatisDao
public interface IpoNottradedayMapper {
	int countByExample(IpoNottradedayExample example);

	int deleteByExample(IpoNottradedayExample example);

	int deleteByPrimaryKey(Long id);

	int insert(IpoNottradeday record);

	int insertSelective(IpoNottradeday record);

	List<IpoNottradeday> selectByExample(IpoNottradedayExample example);

	IpoNottradeday select();

	int updateByExampleSelective(@Param("record") IpoNottradeday record, @Param("example") IpoNottradedayExample example);

	int updateByExample(@Param("record") IpoNottradeday record, @Param("example") IpoNottradedayExample example);

	int updateByPrimaryKeySelective(IpoNottradeday record);

	int updateByPrimaryKey(IpoNottradeday record);
}