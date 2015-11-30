package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.TCommodityMapper;
import com.yrdce.ipo.modules.sys.entity.TCommodity;
import com.yrdce.ipo.modules.sys.vo.VTCommodity;

/**
 * @author chenjing
 *
 */
@Service("tCommodityService")
public class TCommodityServiceImpl implements TCommodityService {
	
	@Autowired
	private TCommodityMapper tCommodityMapper;
	
	public TCommodityMapper gettCommodityMapper() {
		return tCommodityMapper;
	}

	public void settCommodityMapper(TCommodityMapper tCommodityMapper) {
		this.tCommodityMapper = tCommodityMapper;
	}

	@Override
	@Transactional(readOnly = true)
	public List<VTCommodity> findAllTCommodity() {
		List<TCommodity> comlist=tCommodityMapper.selectAll();
		List<VTCommodity> comlist2=new ArrayList<VTCommodity>();
		for(TCommodity temp : comlist){
			VTCommodity tcom=new VTCommodity();
			BeanUtils.copyProperties(temp, tcom);
			comlist2.add(tcom);
		}
		return comlist2;
	}

}
