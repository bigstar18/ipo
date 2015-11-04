package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityExample;

public interface IpoCommodityMapper {
	int countByExample(IpoCommodityExample example);

	int deleteByExample(IpoCommodityExample example);

	int deleteByPrimaryKey(String id);

	int insert(IpoCommodity record);

	int insertSelective(IpoCommodity record);

	List<IpoCommodity> selectByExample(IpoCommodityExample example);
	
	List<IpoCommodity> selectAll();

	List<IpoCommodity> getAllByPage(@Param("beginnum") int beginnum, @Param("endnum") int endnum);// 分页获取发售商品

	IpoCommodity selectByPrimaryKey(String id);

	IpoCommodity selectByComid(@Param("comid") String comid); // 根据商品ID获取商品信息

	int updateByExampleSelective(@Param("record") IpoCommodity record, @Param("example") IpoCommodityExample example);

	int updateByExample(@Param("record") IpoCommodity record, @Param("example") IpoCommodityExample example);

	int updateByPrimaryKeySelective(IpoCommodity record);

	int updateByPrimaryKey(IpoCommodity record);
}