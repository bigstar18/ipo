package com.yrdce.ipo.modules.sys.service;

import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.Distribution;

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
	  /**
     * 申购结算
     * @throws Exception
     */
	public void orderBalance() throws Exception;
	
}
