package com.yrdce.ipo.modules.sys.serviceImpl.warehouse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.IpoStorageMapper;
import com.yrdce.ipo.modules.sys.entity.IpoStorage;
import com.yrdce.ipo.modules.sys.service.warehouse.IpoStorageService;
import com.yrdce.ipo.modules.sys.vo.warehouse.IpoStorageVo;

@Service("ipoStorageService")
public class IpoStorageServiceImpl implements IpoStorageService{

	@Autowired
	private IpoStorageMapper ipoStorageMapper;
	
	
	@Override
	public int deleteByPrimaryKey(String storageid) {
		if(storageid != null && storageid != ""){
			return ipoStorageMapper.deleteByPrimaryKey(storageid);
		}
		return 0;
	}

	@Override
	public int insert(IpoStorageVo record) {
		IpoStorage ipoStorage = new IpoStorage();
		if(record != null){
			BeanUtils.copyProperties(ipoStorage, record);
			return ipoStorageMapper.insert(ipoStorage);
		}
		return 0;
	}

	@Override
	public IpoStorageVo selectByPrimaryKey(String storageid) {
		if(storageid != null && storageid != ""){
			IpoStorageVo ipoStorageVo = new IpoStorageVo();
			BeanUtils.copyProperties(ipoStorageVo, ipoStorageMapper.selectByPrimaryKey(storageid));
			return ipoStorageVo;
		}
		return null;
	}

	@Override
	public List<IpoStorageVo> selectAll() {
		List<IpoStorageVo> IpoSVos = new ArrayList<IpoStorageVo>();
		BeanUtils.copyProperties("IpoSVos",ipoStorageMapper.selectAll());
		return IpoSVos;
	}

	@Override
	public int updateByPrimaryKey(IpoStorageVo record) {
		if(record != null){
			IpoStorage ipoStorage = new IpoStorage();
			BeanUtils.copyProperties(ipoStorage,record);
			return ipoStorageMapper.updateByPrimaryKey(ipoStorage);
		}
		return 0;
	}

	@Override
	public IpoStorageVo selectByCommodityId(String commodityid) {
		if(commodityid != null){
			IpoStorageVo IpoStorageVo = new IpoStorageVo();
			BeanUtils.copyProperties(IpoStorageVo, ipoStorageMapper.selectByCommodityId(commodityid));
			return IpoStorageVo;
		}
		return null;
	}

	@Override
	public IpoStorageVo selectByStorageDate(Date storagedate) {
		if(storagedate != null){
			IpoStorageVo IpoStorageVo = new IpoStorageVo();
			BeanUtils.copyProperties(IpoStorageVo, ipoStorageMapper.selectByStorageDate(storagedate));
			return IpoStorageVo;
		}
		return null;
	}

	@Override
	public IpoStorageVo selectByStorageState(int storagestate) {
			IpoStorageVo IpoStorageVo = new IpoStorageVo();
			BeanUtils.copyProperties(IpoStorageVo, ipoStorageMapper.selectByStorageState(storagestate));
			return IpoStorageVo;
	}

}
