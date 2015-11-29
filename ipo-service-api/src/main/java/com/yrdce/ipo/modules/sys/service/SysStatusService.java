package com.yrdce.ipo.modules.sys.service;

import com.yrdce.ipo.modules.sys.vo.IpoSysStatus;

/**
 * @author hxx
 *
 */
public interface SysStatusService {

	/**
	 * 查询系统状态，只有一条记录，or null
	 * 
	 * @return
	 */
	public IpoSysStatus querySysStatus();

	/**
	 * 获取数据库当前时间
	 * 
	 * @return
	 */
	public String getDBTime();

}
