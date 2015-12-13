package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoClearStatus;

@MyBatisDao
public interface IpoClearStatusMapper {
	int deleteByPrimaryKey(Short actionid);

	int insert(IpoClearStatus record);

	int insertSelective(IpoClearStatus record);

	IpoClearStatus selectByPrimaryKey(Short actionid);

	List<IpoClearStatus> selectAll();

	int updateByPrimaryKeySelective(IpoClearStatus record);

	int updateByPrimaryKey(IpoClearStatus record);
}