package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yrdce.ipo.modules.sys.dao.SysFirmPermissionMapper;
import com.yrdce.ipo.modules.sys.entity.SysFirmPermission;

public class FirmAuthorityServiceImpl {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SysFirmPermissionMapper sysFirmPermissionMapper;

	public String getFirmAuthority(String frimId) {
		logger.info("方法调用成功");
		List<String> modeList = new ArrayList<String>();
		List<SysFirmPermission> permissions = sysFirmPermissionMapper.selectByFirmId(frimId);
		if (permissions.size() != 0) {
			for (SysFirmPermission sysFirmPermission : permissions) {
				String modeid = sysFirmPermission.getModeid();
				modeList.add(modeid);
			}
			if (modeList.size() == 2) {
				return "0";
			} else if (modeList.size() == 1) {
				String modular = modeList.get(0);
				return modular;
			}
		} else {
			return "3";
		}
		return null;

	}
}
