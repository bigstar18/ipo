package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoSpo;

@MyBatisDao
public interface IpoSpoMapper {
	int deleteByPrimaryKey(String spoId);

	int insert(IpoSpo record);

	IpoSpo selectByPrimaryKey(String spoId);

	List<IpoSpo> selectAll();

	int updateByPrimaryKey(IpoSpo record);
}