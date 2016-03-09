package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDistributionRule;

@MyBatisDao
public interface IpoDistributionRuleMapper {
	int insert(IpoDistributionRule record);

	List<IpoDistributionRule> selectAll();

	int selectCountByCommId(String commodityid);

	List<IpoDistributionRule> selectInfoByPages(@Param("beginnum") int beginnum, @Param("endnum") int endnum,
			@Param("dist") IpoDistributionRule distributionRule);

	int selectCounts(@Param("dist") IpoDistributionRule distributionRule);

	IpoDistributionRule selectInfoByCommId(String commodityid);

	int updateInfoByCommId(IpoDistributionRule ipoDistributionRule);

	int deleteInfoByCommid(@Param("commodityid") String commodityid, @Param("userId") String userId);
}