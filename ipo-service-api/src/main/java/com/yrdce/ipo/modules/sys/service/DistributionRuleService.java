package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.DistributionRule;

public interface DistributionRuleService {
	public int insertRuleInfo(DistributionRule distributionRule) throws Exception;

	public int infoIsExistence(String commonityId) throws Exception;

	public List<DistributionRule> selectRuleInfoByPages(String page, String rows, DistributionRule distributionRule)
			throws Exception;

	public int selectInfoCounts(DistributionRule distributionRule) throws Exception;

	public DistributionRule selectInfoByCommId(String commId) throws Exception;

	public int updateInfoByCommId(DistributionRule distributionRule) throws Exception;

	public int deleteInfoByCommid(String commid, String userId) throws Exception;
}
