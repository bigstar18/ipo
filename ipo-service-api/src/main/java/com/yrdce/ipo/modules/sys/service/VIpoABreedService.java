package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.VIpoABreed;

public interface VIpoABreedService {

	//分页获取品种列表
	public List<VIpoABreed> findIpoABreedsByPage(String page,String rows);
	
	//根据品名模糊查询
	public List<VIpoABreed> findIpoABreedsByName(String name,String page,String rows);
	
	//获取品种总数
	public int getTotalIpoABreeds();
	
	//根据品名模糊查询总数
	public int getTotalIpoABreedsByName(String name);
	
	//获取所有品种
	public List<VIpoABreed> findAll();
	
	//根据品种代码获取详细信息
	public VIpoABreed getIpoABreed(Long breedid);
	
	//新增一个品种
	public void addBreed(VIpoABreed breed);
	
	//修改一个品种
	public int updateBreed(VIpoABreed breed);
	
	//删除一个品种
	public void deleteBreed(Long breedid);
}
