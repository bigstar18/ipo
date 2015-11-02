package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoDistributionMapper;
import com.yrdce.ipo.modules.sys.entity.IpoCommodity;
import com.yrdce.ipo.modules.sys.entity.IpoDistribution;
import com.yrdce.ipo.modules.sys.entity.IpoDistributionExample;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.Distribution;

@Service("distributionService")
@Transactional(readOnly = true)
public class DistributionServiceImpl implements DistributionService {
	
	
	private IpoDistributionMapper  ipoDistributionMapper;
	
	public IpoDistributionMapper getIpoDistributionMapper() {
		return ipoDistributionMapper;
	}

	public void setIpoDistributionMapper(IpoDistributionMapper ipoDistributionMapper) {
		this.ipoDistributionMapper = ipoDistributionMapper;
	}

	@Override
	public List<Distribution> getDistriList(String page, String rows) {
	    page = (page==null?"1":page);  
        rows = (rows==null?"5":rows); 
        int curpage=Integer.parseInt(page);
        int pagesize=Integer.parseInt(rows);
        List<IpoDistribution> list=new ArrayList<IpoDistribution>();
        List<Distribution> list2=new ArrayList<Distribution>();
        list= ipoDistributionMapper.getAll((curpage-1)*pagesize+1,curpage*pagesize);
        for(int i=0;i<list.size();i++){
        	Distribution distrib=new Distribution();
        	BeanUtils.copyProperties(list.get(i), distrib);
        	distrib.setPcounts(list.get(i).getPcounts().intValue());
        	distrib.setStartnumber(list.get(i).getStartnumber().intValue());
        	distrib.setPtime(list.get(i).getPtime());
        	list2.add(distrib);
        }
        return  list2;  
	}

	@Override
	public int getAllDistris() {
		return ipoDistributionMapper.countByExample(new IpoDistributionExample());
	}

}
