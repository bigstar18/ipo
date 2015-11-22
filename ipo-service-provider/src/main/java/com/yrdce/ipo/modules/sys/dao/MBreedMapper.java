package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.MBreed;
import com.yrdce.ipo.modules.sys.entity.MBreedExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface MBreedMapper {
    int countByExample(MBreedExample example);

    int deleteByExample(MBreedExample example);

    int deleteByPrimaryKey(Long breedid);

    int insert(MBreed record);

    int insertSelective(MBreed record);

    List<MBreed> selectByExampleWithBLOBs(MBreedExample example);

    List<MBreed> selectByExample(MBreedExample example);//下拉框

    MBreed selectByPrimaryKey(Long breedid);

    int updateByExampleSelective(@Param("record") MBreed record, @Param("example") MBreedExample example);

    int updateByExampleWithBLOBs(@Param("record") MBreed record, @Param("example") MBreedExample example);

    int updateByExample(@Param("record") MBreed record, @Param("example") MBreedExample example);

    int updateByPrimaryKeySelective(MBreed record);

    int updateByPrimaryKeyWithBLOBs(MBreed record);

    int updateByPrimaryKey(MBreed record);
}