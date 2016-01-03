package com.yrdce.ipo.modules.sys.dao;

import java.util.Date;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSysStatus;

@MyBatisDao
public interface IpoSysStatusMapper {
	int deleteByPrimaryKey(Date tradedate);

	int insert(IpoSysStatus record);

	int insertSelective(IpoSysStatus record);

	IpoSysStatus selectByPrimaryKey(Date tradedate);

	int updateByPrimaryKeySelective(IpoSysStatus record);

	int updateByPrimaryKeySelectiveLock(@Param("record") IpoSysStatus record, @Param("oldStatus") Short oldStatus);

	int updateByPrimaryKey(IpoSysStatus record);

	IpoSysStatus selectAll();

	String getDBTimeStr();

	Date getDBTime();

	void updateFundsFull(Map<String, Object> map);
}