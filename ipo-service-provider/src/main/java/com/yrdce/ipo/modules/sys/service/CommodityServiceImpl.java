package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.vo.Commodity;

@Service("commodityService") 
@Transactional(readOnly = true)
public class CommodityServiceImpl implements CommodityService{
	
	private IpoCommodityMapper ipoCommodityMapper;
	
	public IpoCommodityMapper getIpoCommodityMapper() {
		return ipoCommodityMapper;
	}

	@Autowired  
	public void setIpoCommodityMapper(IpoCommodityMapper ipoCommodityMapper) {
		this.ipoCommodityMapper = ipoCommodityMapper;
	}

	@Override
	public List<Commodity> findCommList(String page,String rows) {
		  page = (page==null?"1":page);  
	        rows = (rows==null?"5":rows);  
	        List<IpoCommodity> commlist=new ArrayList<IpoCommodity>();
	        List<Commodity> commlist2=new ArrayList<Commodity>();
	        commlist= ipoCommodityMapper.getAll(PageUtil.getRowNum(Integer.parseInt(page), Integer.parseInt(rows)));
	        for(int i=0;i<commlist.size();i++){
	        	Commodity commo=new Commodity();
	        	BeanUtils.copyProperties(commlist.get(i), commo);
	        	commlist2.add(commo);
	        }
	        return commlist2;  
	}

	@Override
	public Commodity getCommodity(String commId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPurAmount(Commodity comm) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Commodity comm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Commodity comm) {
		// TODO Auto-generated method stub
		
	}

}
