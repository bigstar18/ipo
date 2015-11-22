package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoABreedMapper;
import com.yrdce.ipo.modules.sys.entity.IpoABreed;
import com.yrdce.ipo.modules.sys.entity.IpoABreedExample;
import com.yrdce.ipo.modules.sys.vo.VIpoABreed;

@Service("vIpoABreedService")
@Transactional(readOnly = true)
public class IpoABreedServiceImpl implements VIpoABreedService {
	
	@Autowired
	private IpoABreedMapper ipoABreedMapper;

	public IpoABreedMapper getIpoABreedMapper() {
		return ipoABreedMapper;
	}

	public void setIpoABreedMapper(IpoABreedMapper ipoABreedMapper) {
		this.ipoABreedMapper = ipoABreedMapper;
	}

	@Override
	public List<VIpoABreed> findIpoABreedsByPage(String page, String rows) {
		try {
			page = (page == null ? "1" : page);
			rows = (rows == null ? "5" : rows);
			int curpage = Integer.parseInt(page);
			int pagesize = Integer.parseInt(rows);
			List<IpoABreed> ipoabreedslist = new ArrayList<IpoABreed>();
			List<VIpoABreed> ipoabreedslist2 = new ArrayList<VIpoABreed>();
			ipoabreedslist = ipoABreedMapper.getAllByPage((curpage - 1) * pagesize
					+ 1, curpage * pagesize);
			for (int i = 0; i < ipoabreedslist.size(); i++) {
				VIpoABreed vipoabreed = new VIpoABreed();
				BeanUtils.copyProperties(ipoabreedslist.get(i), vipoabreed);
				ipoabreedslist2.add(vipoabreed);
			}
			return ipoabreedslist2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getTotalIpoABreeds() {
		try{
			return ipoABreedMapper.countByExample(new IpoABreedExample());	
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	@Override
	public List<VIpoABreed> findAll() {
		try {
			List<IpoABreed> ipoabreedslist = new ArrayList<IpoABreed>();
			List<VIpoABreed> ipoabreedslist2 = new ArrayList<VIpoABreed>();
			ipoabreedslist = ipoABreedMapper.selectAll();
			for (int i = 0; i < ipoabreedslist.size(); i++) {
				VIpoABreed vipoabreed = new VIpoABreed();
				BeanUtils.copyProperties(ipoabreedslist.get(i), vipoabreed);
				ipoabreedslist2.add(vipoabreed);
			}
			return ipoabreedslist2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public VIpoABreed getIpoABreed(Long breedid) {
		// TODO Auto-generated method stub
		return null;
	}

	

	@Override
	public void updateBreed(VIpoABreed breed) {
		try{
			IpoABreed ipoabreed=new IpoABreed();
			BeanUtils.copyProperties(breed, ipoabreed);
			ipoABreedMapper.update(ipoabreed);
			}catch (Exception e) {
				e.printStackTrace();
			}
	}

	@Override
	public void deleteBreed(Long breedid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBreed(VIpoABreed breed) {
		try{
		IpoABreed ipoabreed=new IpoABreed();
		BeanUtils.copyProperties(breed, ipoabreed);
		ipoABreedMapper.insert(ipoabreed);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<VIpoABreed> findIpoABreedsByName(String name, String page,
			String rows) {
		try {
			page = (page == null ? "1" : page);
			rows = (rows == null ? "5" : rows);
			int curpage = Integer.parseInt(page);
			int pagesize = Integer.parseInt(rows);
			List<IpoABreed> ipoabreedslist = new ArrayList<IpoABreed>();
			List<VIpoABreed> ipoabreedslist2 = new ArrayList<VIpoABreed>();
			ipoabreedslist = ipoABreedMapper.getAllByName("%"+name+"%",(curpage - 1) * pagesize
					+ 1, curpage * pagesize);
			for (int i = 0; i < ipoabreedslist.size(); i++) {
				VIpoABreed vipoabreed = new VIpoABreed();
				BeanUtils.copyProperties(ipoabreedslist.get(i), vipoabreed);
				ipoabreedslist2.add(vipoabreed);
			}
			return ipoabreedslist2;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public int getTotalIpoABreedsByName(String name) {
		try{
			return ipoABreedMapper.countByName("%"+name+"%");	
		}catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

}
