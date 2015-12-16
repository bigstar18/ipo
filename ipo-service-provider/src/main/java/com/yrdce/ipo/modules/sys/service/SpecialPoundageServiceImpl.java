package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;
 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.IpoSpecialPoundageMapper;
import com.yrdce.ipo.modules.sys.entity.IpoSpecialPoundage;
import com.yrdce.ipo.modules.sys.vo.SpecialPoundage;

/*
 * 特殊手续费
 * 李伟东*/
@Service("specialPoundageService")
public class SpecialPoundageServiceImpl implements SpecialPoundageService {
	@Autowired
	private IpoSpecialPoundageMapper ipoSpecialPoundageMapper;
	public IpoSpecialPoundageMapper getSpecialPoundageMapper(){
		return ipoSpecialPoundageMapper;
	}
	
	public void setIpoSpecialPoundageMapper(IpoSpecialPoundageMapper ipoSpecialPoundageMapper){
		this.ipoSpecialPoundageMapper = ipoSpecialPoundageMapper;
	}
	
	//查询
	@Override
	public List<SpecialPoundage> GetAllInfo() {
		// TODO Auto-generated method stub
			List<IpoSpecialPoundage> ipoSpecialPoundageList =   ipoSpecialPoundageMapper.selectAll();		
			List<SpecialPoundage> tempList = new ArrayList<SpecialPoundage>();
			for(IpoSpecialPoundage tempPoundage:ipoSpecialPoundageList){
				SpecialPoundage poundage = new SpecialPoundage();
				BeanUtils.copyProperties(tempPoundage, poundage);
				tempList.add(poundage);
			}
			return tempList;
	
	}
	//插入
	@Override
	public int InsertPoundage(SpecialPoundage specialPoundage) {
		// TODO Auto-generated method stub
		IpoSpecialPoundage ipoSpecialPoundage = new IpoSpecialPoundage();
		BeanUtils.copyProperties(specialPoundage, ipoSpecialPoundage);
		int temp = ipoSpecialPoundageMapper.insert(ipoSpecialPoundage);
		return temp;
	}
	//删除
	@Override
	public int DeleteById(String poundId) {
		// TODO Auto-generated method stub
		String[] tempId = poundId.split(",");
		for(String tempPoundId:tempId){
			ipoSpecialPoundageMapper.deleteByPrimaryKey(tempPoundId);
		}
		return 1;
	}
	//特殊手续费修改
	@Override
	public int UpDateInfoById(SpecialPoundage poundage) {
		// TODO Auto-generated method stub
		IpoSpecialPoundage ipoSpecialPoundage = new IpoSpecialPoundage();
		BeanUtils.copyProperties(poundage, ipoSpecialPoundage);
		int result = ipoSpecialPoundageMapper.updateByPrimaryKey(ipoSpecialPoundage);
		if (result>0) {
			return 1;
		}else{
			return 0;
		}
	}
	
}
