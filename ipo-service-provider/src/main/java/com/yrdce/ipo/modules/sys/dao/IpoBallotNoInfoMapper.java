package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoBallotNoInfo;

@MyBatisDao
public interface IpoBallotNoInfoMapper {
	int deleteByPrimaryKey(Short id);

	int insert(IpoBallotNoInfo record);

	int insertSelective(IpoBallotNoInfo record);

	IpoBallotNoInfo selectByPrimaryKey(Short id);

	int updateByPrimaryKeySelective(IpoBallotNoInfo record);

	int updateByPrimaryKey(IpoBallotNoInfo record);
}