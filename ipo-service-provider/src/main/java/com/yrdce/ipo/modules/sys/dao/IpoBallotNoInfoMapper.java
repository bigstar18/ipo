package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.modules.sys.entity.IpoBallotNoInfo;

public interface IpoBallotNoInfoMapper {

	void insert(IpoBallotNoInfo ballot);

	IpoBallotNoInfo selectByCommonityid(String commonityid);

}
