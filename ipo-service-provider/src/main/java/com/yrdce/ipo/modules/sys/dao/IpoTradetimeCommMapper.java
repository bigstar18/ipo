package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoTradetimeComm;
import com.yrdce.ipo.modules.sys.entity.IpoTradetimeCommExample;

@MyBatisDao
public interface IpoTradetimeCommMapper {
	int countById(int tradeTimeId);

	int deleteByExample(IpoTradetimeCommExample example);

	int deleteByPrimaryKey(BigDecimal id);

	int insert(IpoTradetimeComm record);

	int insertSelective(IpoTradetimeComm record);

	List<IpoTradetimeComm> selectByExample(IpoTradetimeCommExample example);

	IpoTradetimeComm selectByPrimaryKey(BigDecimal id);

	int updateByExampleSelective(@Param("record") IpoTradetimeComm record, @Param("example") IpoTradetimeCommExample example);

	int updateByExample(@Param("record") IpoTradetimeComm record, @Param("example") IpoTradetimeCommExample example);

	int updateByPrimaryKeySelective(IpoTradetimeComm record);

	int updateByPrimaryKey(IpoTradetimeComm record);
}