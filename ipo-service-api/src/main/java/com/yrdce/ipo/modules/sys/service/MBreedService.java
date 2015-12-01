package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.MBreed;

public interface MBreedService {

	// 获取所有品种
	public List<MBreed> findAll();

	// 根据品种代码获取详细信息
	public MBreed getMBreed(Long breedid);

}
