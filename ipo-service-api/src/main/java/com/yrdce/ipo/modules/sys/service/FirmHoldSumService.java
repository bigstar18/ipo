package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.FirmHoldSum;

public interface FirmHoldSumService {

	public long queryForCount(FirmHoldSum firmHoldSum);
	
	public List<FirmHoldSum> queryForList(FirmHoldSum firmHoldSum);
}
