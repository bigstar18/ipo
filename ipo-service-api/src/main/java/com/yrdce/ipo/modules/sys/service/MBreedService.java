package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.MBreed;

public interface MBreedService {

	//分页获取品种列表
	public List<MBreed> findMBreedsByPage(String page,String rows);
	
	//获取品种总数
	public int getTotalMBreeds();
	
	//获取所有品种
	public List<MBreed> findAll();
	
	//根据品种代码获取详细信息
	public MBreed getMBreed(Long breedid);
	
	
}
