/**
 * 
 */
package com.yrdce.ipo.modules.sys.service;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoSysStatusMapper;
import com.yrdce.ipo.modules.sys.vo.IpoSysStatus;

/**
 * @author hxx
 *
 */
@org.springframework.stereotype.Service
public class SysStatusServiceImpl implements SysStatusService {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	IpoSysStatusMapper mapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.yrdce.ipo.modules.sys.service.SysStatusService#querySysStatus()
	 */
	@Override
	@Transactional(readOnly = true)
	public IpoSysStatus querySysStatus() {
		try {
			com.yrdce.ipo.modules.sys.entity.IpoSysStatus status = mapper.selectAll();
			if (status != null) {
				IpoSysStatus result = new IpoSysStatus();
				BeanUtils.copyProperties(result, status);
				return result;
			} else
				return null;
		} catch (Exception e) {
			logger.error("error:", e);
			return null;
		}
	}

	@Override
	public String getDBTime() {
		try {
			return mapper.getDBTime();
		} catch (Exception e) {
			logger.error("error:", e);
			return null;
		}
	}

}
