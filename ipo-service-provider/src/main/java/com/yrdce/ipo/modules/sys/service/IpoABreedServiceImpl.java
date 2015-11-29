package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoBreedMapper;
import com.yrdce.ipo.modules.sys.entity.IpoBreed;
import com.yrdce.ipo.modules.sys.vo.VIpoABreed;

@Service("vIpoABreedService")
public class IpoABreedServiceImpl implements VIpoABreedService {
	
	@Autowired
	private IpoBreedMapper ipoBreedMapper;



	public IpoBreedMapper getIpoBreedMapper() {
		return ipoBreedMapper;
	}

	public void setIpoBreedMapper(IpoBreedMapper ipoBreedMapper) {
		this.ipoBreedMapper = ipoBreedMapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<VIpoABreed> findIpoABreedsByPage(String page, String rows) {
			page = (page == null ? "1" : page);
			rows = (rows == null ? "5" : rows);
			int curpage = Integer.parseInt(page);
			int pagesize = Integer.parseInt(rows);
			List<IpoBreed> ipoabreedslist = new ArrayList<IpoBreed>();
			List<VIpoABreed> ipoabreedslist2 = new ArrayList<VIpoABreed>();
			ipoabreedslist = ipoBreedMapper.getAllByPage((curpage - 1) * pagesize
					+ 1, curpage * pagesize);
			for (int i = 0; i < ipoabreedslist.size(); i++) {
				VIpoABreed vipoabreed = new VIpoABreed();
				BeanUtils.copyProperties(ipoabreedslist.get(i), vipoabreed);
				ipoabreedslist2.add(vipoabreed);
			}
			return ipoabreedslist2;
	}

	@Override
	public int getTotalIpoABreeds() {
			return ipoBreedMapper.countAll();	
	}

	@Override
	@Transactional(readOnly = true)
	public List<VIpoABreed> findAll() {
			List<IpoBreed> ipoabreedslist = new ArrayList<IpoBreed>();
			List<VIpoABreed> ipoabreedslist2 = new ArrayList<VIpoABreed>();
			ipoabreedslist = ipoBreedMapper.selectAll();
			for (int i = 0; i < ipoabreedslist.size(); i++) {
				VIpoABreed vipoabreed = new VIpoABreed();
				BeanUtils.copyProperties(ipoabreedslist.get(i), vipoabreed);
				ipoabreedslist2.add(vipoabreed);
			}
			return ipoabreedslist2;
	}

	@Override
	public VIpoABreed getIpoABreed(Long breedid) {
		VIpoABreed ipoabreed=new VIpoABreed();
		BeanUtils.copyProperties(ipoBreedMapper.selectByBreedid(breedid), ipoabreed);
		return ipoabreed;
	}

	

	@Override
	@Transactional
	public void updateBreed(VIpoABreed breed) {
			IpoBreed ipoabreed=new IpoBreed();
			BeanUtils.copyProperties(breed, ipoabreed);
			ipoBreedMapper.update(ipoabreed);
	}

	@Override
	@Transactional
	public void deleteBreed(Long breedid) {
		ipoBreedMapper.deleteByBreedid(breedid);
	}

	@Override
	@Transactional
	public void addBreed(VIpoABreed breed) {
		IpoBreed ipoabreed=new IpoBreed();
		BeanUtils.copyProperties(breed, ipoabreed);
		ipoBreedMapper.insert(ipoabreed);
	}

	@Override
	@Transactional(readOnly = true)
	public List<VIpoABreed> findIpoABreedsByName(String name, String page,
			String rows) {
			page = (page == null ? "1" : page);
			rows = (rows == null ? "5" : rows);
			int curpage = Integer.parseInt(page);
			int pagesize = Integer.parseInt(rows);
			List<IpoBreed> ipoabreedslist = new ArrayList<IpoBreed>();
			List<VIpoABreed> ipoabreedslist2 = new ArrayList<VIpoABreed>();
			ipoabreedslist = ipoBreedMapper.getAllByName("%"+name+"%",(curpage - 1) * pagesize
					+ 1, curpage * pagesize);
			for (int i = 0; i < ipoabreedslist.size(); i++) {
				VIpoABreed vipoabreed = new VIpoABreed();
				BeanUtils.copyProperties(ipoabreedslist.get(i), vipoabreed);
				ipoabreedslist2.add(vipoabreed);
			}
			return ipoabreedslist2;
	
	}

	@Override
	public int getTotalIpoABreedsByName(String name) {
			return ipoBreedMapper.countByName("%"+name+"%");	
	}

}
