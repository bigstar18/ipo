package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityExample;

@MyBatisDao
public interface IpoCommodityMapper {
	int countByExample(IpoCommodityExample example);

	int deleteByExample(IpoCommodityExample example);

	int deleteByPrimaryKey(String id);

	int insert(IpoCommodity record);

	int insertSelective(IpoCommodity record);

	List<IpoCommodity> selectByExample(IpoCommodityExample example);

	IpoCommodity selectByPrimaryKey(String id);

	int updateByExampleSelective(@Param("record") IpoCommodity record, @Param("example") IpoCommodityExample example);

	int updateByExample(@Param("record") IpoCommodity record, @Param("example") IpoCommodityExample example);

	int updateByPrimaryKeySelective(IpoCommodity record);

	int updateByPrimaryKey(IpoCommodity record);
}