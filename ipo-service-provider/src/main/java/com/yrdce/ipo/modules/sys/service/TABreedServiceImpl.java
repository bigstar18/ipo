package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.TABreedMapper;
import com.yrdce.ipo.modules.sys.entity.TABreedExample;
import com.yrdce.ipo.modules.sys.vo.TABreed;

@Service("tabreedService")
@Transactional(readOnly = true)
public class TABreedServiceImpl implements TABreedService {
	
	@Autowired
	private TABreedMapper tabreedMapper;

	public TABreedMapper getTabreedMapper() {
		return tabreedMapper;
	}

	public void setTabreedMapper(TABreedMapper tabreedMapper) {
		this.tabreedMapper = tabreedMapper;
	}

	@Override
	public List<TABreed> findTABreedsByPage(String page, String rows) {
		try {
			page = (page == null ? "1" : page);
			rows = (rows == null ? "5" : rows);
			int curpage = Integer.parseInt(page);
			int pagesize = Integer.parseInt(rows);
			List<com.yrdce.ipo.modules.sys.entity.TABreed> tabreedslist = new ArrayList<com.yrdce.ipo.modules.sys.entity.TABreed>();
			List<TABreed> tabreedslist2 = new ArrayList<TABreed>();
			tabreedslist = tabreedMapper.getAllByPage((curpage - 1) * pagesize
					+ 1, curpage * pagesize);
			for (int i = 0; i < tabreedslist.size(); i++) {
				TABreed tabreed = new TABreed();
				BeanUtils.copyProperties(tabreedslist.get(i), tabreed);
				tabreedslist2.add(tabreed);
			}
			return tabreedslist2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getTotalTABreeds() {
		try{
			return tabreedMapper.countByExample(new TABreedExample());	
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	@Override
	public List<TABreed> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TABreed getTABreed(Long breedid) {
		// TODO Auto-generated method stub
		return null;
	}

}
