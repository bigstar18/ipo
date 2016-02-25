package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDistributionRule;

@MyBatisDao
public interface IpoDistributionRuleMapper {
	int insert(IpoDistributionRule record);

	List<IpoDistributionRule> selectAll();
}