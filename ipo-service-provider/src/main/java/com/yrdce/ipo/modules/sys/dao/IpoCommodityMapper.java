package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityExample;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface IpoCommodityMapper {
    int countByExample(IpoCommodityExample example);

    int deleteByExample(IpoCommodityExample example);

    int deleteByPrimaryKey(String id);

    int insert(IpoCommodity record);

    int insertSelective(IpoCommodity record);

    List<IpoCommodity> selectByExample(IpoCommodityExample example);
    
    List<IpoCommodity>  getAll(Map<String, Object> page);

    IpoCommodity selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") IpoCommodity record, @Param("example") IpoCommodityExample example);

    int updateByExample(@Param("record") IpoCommodity record, @Param("example") IpoCommodityExample example);

    int updateByPrimaryKeySelective(IpoCommodity record);

    int updateByPrimaryKey(IpoCommodity record);
}