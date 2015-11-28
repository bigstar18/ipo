package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.BrBrokerMapper;
import com.yrdce.ipo.modules.sys.entity.BrBroker;
import com.yrdce.ipo.modules.sys.vo.VBrBroker;

/**
 * @author chenjing
 *
 */
@Service("brBrokerService")
@Transactional(readOnly = true)
public class BrBrokerServiceImpl implements BrBrokerService {
	
	@Autowired
	private BrBrokerMapper brBrokerMapper;
	
	public BrBrokerMapper getBrBrokerMapper() {
		return brBrokerMapper;
	}



	public void setBrBrokerMapper(BrBrokerMapper brBrokerMapper) {
		this.brBrokerMapper = brBrokerMapper;
	}

	@Override
	public List<VBrBroker> findAllPublisher() {
		try{
		List<BrBroker> blist=brBrokerMapper.findAllPublisher();
		List<VBrBroker>  blist2=new ArrayList<VBrBroker>();
		for(BrBroker temp: blist){
			VBrBroker brbroker=new VBrBroker();
			BeanUtils.copyProperties(temp, brbroker);
			blist2.add(brbroker);
		}
		return blist2;
		}catch (Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
