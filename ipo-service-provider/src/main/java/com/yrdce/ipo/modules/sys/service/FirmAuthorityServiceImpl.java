package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.SysFirmPermissionMapper;
import com.yrdce.ipo.modules.sys.entity.SysFirmPermission;

/**
 * @ClassName: FirmAuthorityServiceImpl
 * @Description: 权限
 * @author bob
 */
@Service
public class FirmAuthorityServiceImpl implements FirmAuthorityService {
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private SysFirmPermissionMapper sysFirmPermissionMapper;

	@Override
	public List<String> getFirmAuthority(String frimId) {
		List<String> modelList = new ArrayList<String>();
		List<SysFirmPermission> permissions = sysFirmPermissionMapper.selectByFirmId(frimId);
		if (permissions.size() != 0) {
			for (SysFirmPermission sysFirmPermission : permissions) {
				String modeid = sysFirmPermission.getModeid();
				modelList.add(modeid);
			}
		}
		return modelList;
	}

	@Override
	public Integer delete(String firmId) {
		return sysFirmPermissionMapper.deleteByFirmId(firmId);
	}

	@Override
	@Transactional
	public Integer insert(String firmId, String moudel) {
		SysFirmPermission sysFirmPermission = new SysFirmPermission();
		sysFirmPermission.setFirmid(firmId);
		sysFirmPermission.setModeid(moudel);
		return sysFirmPermissionMapper.insert(sysFirmPermission);
	}
}
