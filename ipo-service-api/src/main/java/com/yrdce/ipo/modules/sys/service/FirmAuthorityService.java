package com.yrdce.ipo.modules.sys.service;

import java.util.List;

/**
 * @ClassName: FirmAuthorityService
 * @Description: 交易商权限
 * @author bob
 */
public interface FirmAuthorityService {

	/**
	 * @Title: getFirmAuthority
	 * @Description: 获取交易商权限
	 * @param firmId
	 */
	public List<String> getFirmAuthority(String firmId);

	public Integer delete(String firmId);

	public Integer insert(String firmId, String moudel);

}
