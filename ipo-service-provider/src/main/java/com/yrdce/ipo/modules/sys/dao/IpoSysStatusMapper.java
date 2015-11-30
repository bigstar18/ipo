package com.yrdce.ipo.modules.sys.dao;

import java.util.Date;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSysStatus;

@MyBatisDao
public interface IpoSysStatusMapper {
	int deleteByPrimaryKey(Date tradedate);

	int insert(IpoSysStatus record);

	int insertSelective(IpoSysStatus record);

	IpoSysStatus selectByPrimaryKey(Date tradedate);

	int updateByPrimaryKeySelective(IpoSysStatus record);

	int updateByPrimaryKey(IpoSysStatus record);

	IpoSysStatus selectAll();

	String getDBTimeStr();

	Date getDBTime();
}