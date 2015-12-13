package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoExpress;

@MyBatisDao
public interface IpoExpressMapper {
	int deleteByPrimaryKey(Long expressId);

	int insert(IpoExpress record);

	IpoExpress selectByPrimaryKey(Long expressId);

	List<IpoExpress> selectAll();

	int updateByPrimaryKey(IpoExpress record);
}