package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoBreed;
import com.yrdce.ipo.modules.sys.entity.IpoBreedExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
@MyBatisDao
public interface IpoBreedMapper {
	    int countAll();

	    int deleteByBreedid(Long breedid);

	    int insert(IpoBreed record);
	    
	    int update(IpoBreed record);
	    
	    List<IpoBreed> getAllByPage(@Param("beginnum") int beginnum,
				@Param("endnum") int endnum);// 分页获取品种列表
	    
	    List<IpoBreed> getAllByName(@Param("breedname") String breedname,@Param("beginnum") int beginnum,
				@Param("endnum") int endnum);// 分页获取品种模糊查询列表
	    
	    int countByName(@Param("breedname") String breedname);//获取品名模糊查询总数
	    
	    IpoBreed selectByBreedid(@Param("breedid") Long breedid); // 根据品种ID获取品种信息
	    
	    List<IpoBreed> selectAll(); //查询所有的品种 
}