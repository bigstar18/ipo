package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.TABreedtradeprop;
import com.yrdce.ipo.modules.sys.entity.TABreedtradepropExample;
import com.yrdce.ipo.modules.sys.entity.TABreedtradepropKey;
import com.yrdce.ipo.modules.sys.vo.Breedtradeprop;

@MyBatisDao
public interface TABreedtradepropMapper {
	int countByExample(TABreedtradepropExample example);

	int deleteByExample(TABreedtradepropExample example);

	int deleteByPrimaryKey(TABreedtradepropKey key);

	int insert(TABreedtradeprop record);

	int insertSelective(TABreedtradeprop record);

	List<TABreedtradeprop> selectByExample(TABreedtradepropExample example);

	TABreedtradeprop selectByPrimaryKey(TABreedtradepropKey key);

	int updateByExampleSelective(@Param("record") TABreedtradeprop record, @Param("example") TABreedtradepropExample example);

	int updateByExample(@Param("record") TABreedtradeprop record, @Param("example") TABreedtradepropExample example);

	int updateByPrimaryKeySelective(TABreedtradeprop record);

	int updateByPrimaryKey(TABreedtradeprop record);

	List<Breedtradeprop> selectByBreed(Short id);
}