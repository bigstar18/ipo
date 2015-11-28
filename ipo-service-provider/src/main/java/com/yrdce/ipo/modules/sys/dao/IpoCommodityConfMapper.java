package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoCommodityConf;

import java.util.List;

import org.apache.ibatis.annotations.Param;

@MyBatisDao
public interface IpoCommodityConfMapper {
   
    List<IpoCommodityConf> findIpoCommConfByBreedid(@Param("breedid")Long breedid,@Param("beginnum") int beginnum,@Param("endnum") int endnum);//分页获取对应商品
    
    int countByBreedid(@Param("breedid")Long breedid);//获取品种对应商品总数
    
    IpoCommodityConf findIpoCommConfByCommid(@Param("commid")String commid);//根据商品ID获取商品
    
    int insert(IpoCommodityConf record);
    
    int update(IpoCommodityConf record);
    
    int deleteByCommid(@Param("commid")String commid);//根据商品ID删除商品
    
    int deleteByBreedid(@Param("breedid")Long breedid);//根据品种ID删除对应商品
    
    List<String> findAllCommIds();
}