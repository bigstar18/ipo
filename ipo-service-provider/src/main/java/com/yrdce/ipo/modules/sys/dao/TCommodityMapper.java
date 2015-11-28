package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.TCommodity;
import com.yrdce.ipo.modules.sys.entity.TCommodityExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface TCommodityMapper {
    int countByExample(TCommodityExample example);

    int deleteByExample(TCommodityExample example);

    int deleteByPrimaryKey(String commodityid);

    int insert(TCommodity record);

    int insertSelective(TCommodity record);

    List<TCommodity> selectByExample(TCommodityExample example);

    TCommodity selectByPrimaryKey(String commodityid);

    int updateByExampleSelective(@Param("record") TCommodity record, @Param("example") TCommodityExample example);

    int updateByExample(@Param("record") TCommodity record, @Param("example") TCommodityExample example);

    int updateByPrimaryKeySelective(TCommodity record);

    int updateByPrimaryKey(TCommodity record);
    
    List<TCommodity> selectAll();
}