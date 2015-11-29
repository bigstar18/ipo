package com.yrdce.ipo.modules.sys.service;

import com.yrdce.ipo.common.vo.ResultMsg;
import com.yrdce.ipo.modules.sys.vo.IpoSysStatus;

/**
 * @author hxx
 *
 */
public interface SystemService {
	// ('08');">开市准备"
	// "('05');"暂停交易
	// ('06'); ">恢复交易"
	// "('09');">交易结束
	// ('07');">闭市操作"
	public static final String OPR_MARKET_OPEN = "08";
	public static final String OPR_TRADE_PAUSE = "05";
	public static final String OPR_TRADE_RESUME = "06";
	public static final String OPR_TRADE_CLOSE = "09";
	public static final String OPR_MARKET_CLOSE = "07";

	/**
	 * 查询系统状态，只有一条记录，or null
	 * 
	 * @return
	 */
	public IpoSysStatus querySysStatus();

	/**
	 * 控制系统状态
	 * 
	 * @param code
	 * @return
	 */
	public ResultMsg sysControl(String code) throws Exception;

	/**
	 * 获取数据库当前时间
	 * 
	 * @return
	 */
	public String getDBTime();

	/**
	 * 系统是否可用（含是否是交易时间）
	 * 
	 * @return
	 * @throws Exception
	 */
	public boolean canSystemTrade() throws Exception;

}
