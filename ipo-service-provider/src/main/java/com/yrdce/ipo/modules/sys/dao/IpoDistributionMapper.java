package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.CrudDao;
import com.yrdce.ipo.modules.sys.entity.IpoDistribution;
import com.yrdce.ipo.modules.sys.entity.IpoDistributionExample;

public interface IpoDistributionMapper extends CrudDao<IpoDistribution> {
	int countByExample(IpoDistributionExample example);

	int deleteByExample(IpoDistributionExample example);

	int deleteByPrimaryKey(BigDecimal id);

	int insert(IpoDistribution record);

	int insertSelective(IpoDistribution record);

	List<IpoDistribution> selectByExample(IpoDistributionExample example);

	IpoDistribution selectByPrimaryKey(BigDecimal id);

	int updateByExampleSelective(@Param("record") IpoDistribution record, @Param("example") IpoDistributionExample example);

	int updateByExample(@Param("record") IpoDistribution record, @Param("example") IpoDistributionExample example);

	int updateByPrimaryKeySelective(IpoDistribution record);

	int updateByPrimaryKey(IpoDistribution record);
}