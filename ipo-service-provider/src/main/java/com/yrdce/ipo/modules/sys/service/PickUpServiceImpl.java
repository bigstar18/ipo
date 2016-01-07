package com.yrdce.ipo.modules.sys.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.modules.sys.dao.IpoPickupMapper;
import com.yrdce.ipo.modules.sys.entity.IpoPickup;
import com.yrdce.ipo.modules.sys.vo.Pickup;

@Service
public class PickUpServiceImpl implements PickUpService {

	@Autowired
	private IpoPickupMapper ipopickupmapper;

	@Override
	public Pickup getPickUpByPid(String pickupId) {
		IpoPickup example = ipopickupmapper.selectByPrimaryKey(pickupId);
		if (example != null) {
			Pickup pickup = new Pickup();
			BeanUtils.copyProperties(example, pickup);
			return pickup;
		}
		return null;
	}

	@Override
	public Integer setPassword(String pickupId, String password) {
		IpoPickup example = ipopickupmapper.selectByPrimaryKey(pickupId);
		example.setPickupPassword(password);

		return ipopickupmapper.updateByPrimaryKey(example);
	}

}
