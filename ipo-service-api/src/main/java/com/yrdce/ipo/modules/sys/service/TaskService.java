package com.yrdce.ipo.modules.sys.service;
/**
 * 定时任务相关的 service
 * @author wq 2016-1-2
 *
 */
public interface TaskService {
	
	/**
	 * 配号
	 * @throws Exception
	 */
	public void distribution() throws Exception;
	
    /**
     * 摇号
     * @throws Exception
     */
	public void lottery() throws Exception;
	
	
	
}
