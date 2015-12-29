package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.sys.vo.DeliveryCommodity;

@Service
public class DeliveryCommodityServiceImpl implements DeliveryCommodityService {

	@Autowired
	private IpoCommodityConfMapper commconfmapper;

	public IpoCommodityConfMapper getCommconfmapper() {
		return commconfmapper;
	}

	public void setCommconfmapper(IpoCommodityConfMapper commconfmapper) {
		this.commconfmapper = commconfmapper;
	}

	@Override
	public List<DeliveryCommodity> findDeliveryCommoditys(String page,
			String rows, DeliveryCommodity example) {
		int startIndex = PageUtil.getStartIndex(page, rows);
		int endIndex = PageUtil.getEndIndex(page, rows);
		com.yrdce.ipo.modules.sys.entity.DeliveryCommodity record = new com.yrdce.ipo.modules.sys.entity.DeliveryCommodity();
		if (example != null) {
			BeanUtils.copyProperties(example, record);
		}
		List<com.yrdce.ipo.modules.sys.entity.DeliveryCommodity> dclist = commconfmapper
				.findDeliveryCommoditys(startIndex, endIndex, record);
		List<DeliveryCommodity> dclist2 = new ArrayList<DeliveryCommodity>();
		for (com.yrdce.ipo.modules.sys.entity.DeliveryCommodity temp : dclist) {
			DeliveryCommodity deliveryComm = new DeliveryCommodity();
			BeanUtils.copyProperties(temp, deliveryComm);
			dclist2.add(deliveryComm);
		}
		return dclist2;
	}

	@Override
	public Integer getNums(DeliveryCommodity example) {
		com.yrdce.ipo.modules.sys.entity.DeliveryCommodity record = new com.yrdce.ipo.modules.sys.entity.DeliveryCommodity();
		if (example != null) {
			BeanUtils.copyProperties(example, record);
		}
		return commconfmapper.getDeliveryCommNum(record);
	}

}
