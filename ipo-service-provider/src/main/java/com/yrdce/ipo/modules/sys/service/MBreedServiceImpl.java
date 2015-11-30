package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.MBreedMapper;
import com.yrdce.ipo.modules.sys.entity.MBreedExample;
import com.yrdce.ipo.modules.sys.vo.MBreed;

@Service("mBreedservice")
public class MBreedServiceImpl implements MBreedService {
	
	@Autowired
	private MBreedMapper mbreedmapper;

	public MBreedMapper getMbreedmapper() {
		return mbreedmapper;
	}

	public void setMbreedmapper(MBreedMapper mbreedmapper) {
		this.mbreedmapper = mbreedmapper;
	}


	@Override
	@Transactional(readOnly = true)
	public List<MBreed> findAll() {
		List<com.yrdce.ipo.modules.sys.entity.MBreed> mbreedslist = new ArrayList<com.yrdce.ipo.modules.sys.entity.MBreed>();
		List<MBreed> mbreedslist2 = new ArrayList<MBreed>();
		mbreedslist = mbreedmapper.selectByExample(new MBreedExample());
		for (int i = 0; i < mbreedslist.size(); i++) {
			MBreed mbreed = new MBreed();
			BeanUtils.copyProperties(mbreedslist.get(i), mbreed);
			mbreedslist2.add(mbreed);
		}
		return mbreedslist2;
	}

	@Override
	public MBreed getMBreed(Long breedid) {
		MBreed breed=new MBreed();
		com.yrdce.ipo.modules.sys.entity.MBreed mbreed=mbreedmapper.selectByPrimaryKey(breedid);
		BeanUtils.copyProperties(mbreed, breed);
		return breed;
	}

}
