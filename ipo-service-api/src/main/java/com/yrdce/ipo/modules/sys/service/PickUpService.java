package com.yrdce.ipo.modules.sys.service;

import com.yrdce.ipo.modules.sys.vo.Pickup;

public interface PickUpService {

	/**
	 * 获取自提对象
	 * 
	 * @param pickupId
	 * @return
	 */
	public Pickup getPickUpByPid(String pickupId);

	/**
	 * 设置密码
	 * 
	 * @param pickupId
	 * @return
	 */
	public Integer setPassword(String pickupId, String password);

}
