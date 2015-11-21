package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.TABreed;

public interface TABreedService {

	//分页获取品种列表
	public List<TABreed> findTABreedsByPage(String page,String rows);
	
	//获取品种总数
	public int getTotalTABreeds();
	
	//获取所有品种
	public List<TABreed> findAll();
	
	//根据品种代码获取详细信息
	public TABreed getTABreed(Long breedid);
	
	//添加品种
	
}
