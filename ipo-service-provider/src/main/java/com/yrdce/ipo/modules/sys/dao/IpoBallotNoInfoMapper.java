package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoBallotNoInfo;

@MyBatisDao
public interface IpoBallotNoInfoMapper {

	void insert(IpoBallotNoInfo ballot);

	IpoBallotNoInfo selectByCommonityid(String commonityid);

}
