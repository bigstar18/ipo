package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSpoCommoditymanmaagement;

@MyBatisDao
public interface IpoSpoCommoditymanmaagementMapper {
	int deleteByPrimaryKey(String spoId);

	int insert(IpoSpoCommoditymanmaagement record);

	IpoSpoCommoditymanmaagement selectByPrimaryKey(String spoId);

	List<IpoSpoCommoditymanmaagement> selectAll();

	int updateByPrimaryKey(IpoSpoCommoditymanmaagement record);
}