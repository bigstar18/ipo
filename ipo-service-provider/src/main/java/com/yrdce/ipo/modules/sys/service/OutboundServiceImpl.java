package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.yrdce.ipo.modules.sys.dao.IpoOutboundMapper;
import com.yrdce.ipo.modules.sys.entity.IpoOutbound;
import com.yrdce.ipo.modules.sys.vo.Outbound;

/**
 * 出库流程服务
 * li
 * 2015.12.20
 * */
@Service("outboundService")
public class OutboundServiceImpl implements OutboundService {
	@Autowired
	private IpoOutboundMapper ipoOutboundMapper;
	
	@Override
	public List<Outbound> getAllOutboundInfo() {
		// TODO Auto-generated method stub
		List<IpoOutbound> outboundsList = ipoOutboundMapper.selectAll();
		List<Outbound> tempList = new ArrayList<Outbound>();
		for (IpoOutbound ipoOutbound : outboundsList) {
			Outbound outbound = new Outbound();
			BeanUtils.copyProperties(ipoOutbound, outbound);
			tempList.add(outbound);
		}
		return tempList;
	}
	
	
	
	
}
