package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.TATradetime;
import com.yrdce.ipo.modules.sys.entity.TATradetimeExample;

@MyBatisDao
public interface TATradetimeMapper {
	int countByExample(TATradetimeExample example);

	int deleteByExample(TATradetimeExample example);

	int deleteByPrimaryKey(Short sectionid);

	int insert(TATradetime record);

	int insertSelective(TATradetime record);

	List<TATradetime> selectByExample(TATradetimeExample example);

	TATradetime selectByPrimaryKey(Short sectionid);

	int updateByExampleSelective(@Param("record") TATradetime record, @Param("example") TATradetimeExample example);

	int updateByExample(@Param("record") TATradetime record, @Param("example") TATradetimeExample example);

	int updateByPrimaryKeySelective(TATradetime record);

	int updateByPrimaryKey(TATradetime record);

	int selectbycount();

	List<TATradetime> select();
}