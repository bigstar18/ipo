package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoABreed;
import com.yrdce.ipo.modules.sys.entity.IpoABreedExample;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface IpoABreedMapper {
    int countByExample(IpoABreedExample example);

    int deleteByExample(IpoABreedExample example);

    int insert(IpoABreed record);

    int insertSelective(IpoABreed record);

    List<IpoABreed> selectByExample(IpoABreedExample example);

    int updateByExampleSelective(@Param("record") IpoABreed record, @Param("example") IpoABreedExample example);

    int updateByExample(@Param("record") IpoABreed record, @Param("example") IpoABreedExample example);
    
    List<IpoABreed> getAllByPage(@Param("beginnum") int beginnum,
			@Param("endnum") int endnum);// 分页获取品种列表
    
    IpoABreed selectByBreedid(@Param("breedid") String breedid); // 根据品种ID获取品种信息
}