package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.TABreed;
import com.yrdce.ipo.modules.sys.entity.TABreedExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface TABreedMapper {
    int countByExample(TABreedExample example);

    int deleteByExample(TABreedExample example);

    int deleteByPrimaryKey(Long breedid);

    int insert(TABreed record);

    int insertSelective(TABreed record);

    List<TABreed> selectByExample(TABreedExample example);

    TABreed selectByPrimaryKey(Long breedid);

    int updateByExampleSelective(@Param("record") TABreed record, @Param("example") TABreedExample example);

    int updateByExample(@Param("record") TABreed record, @Param("example") TABreedExample example);

    int updateByPrimaryKeySelective(TABreed record);

    int updateByPrimaryKey(TABreed record);
    
    List<TABreed> getAllByPage(@Param("beginnum") int beginnum,
			@Param("endnum") int endnum);// 分页获取品种
}