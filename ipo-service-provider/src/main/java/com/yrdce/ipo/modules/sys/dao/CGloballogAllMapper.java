package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.CGloballogAll;

@MyBatisDao
public interface CGloballogAllMapper {
	int deleteByPrimaryKey(Long id);

	int insert(CGloballogAll record);

	int insertSelective(CGloballogAll record);

	CGloballogAll selectByPrimaryKey(Long id);

	int updateByPrimaryKeySelective(CGloballogAll record);

	int updateByPrimaryKey(CGloballogAll record);
}