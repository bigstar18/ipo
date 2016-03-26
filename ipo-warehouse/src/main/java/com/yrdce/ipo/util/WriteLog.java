package com.yrdce.ipo.util;

import gnnt.MEBS.logonService.vo.UserManageVO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.yrdce.ipo.modules.sys.service.SystemService;
import com.yrdce.ipo.modules.sys.vo.CGloballogAll;

@Controller
public class WriteLog {

	public static final int SYS_LOG_STORAGE_CATALOGID = 4002;
	public static final int SYS_LOG_EXPRESS_CATALOGID = 4003;
	public static final int SYS_LOG_OUTBOUND_CATALOGID = 4010;
	public static final int SYS_LOG_OPE_SUCC = 1;
	public static final int SYS_LOG_OPE_FAILURE = 0;

	private static Logger log = org.slf4j.LoggerFactory
			.getLogger(WriteLog.class);

	@Autowired
	private static SystemService systemService;
	private static ExecutorService executorService = Executors
			.newCachedThreadPool(new ThreadFactoryBuilder()
					.setNameFormat("writeOperateLog-%d").setDaemon(true)
					.build());

	// writeOperateLog(1503, "RMI交易结算失败！" + localException.getMessage(), 0, "");
	/**
	 * 写操作日志
	 * 
	 * comment on column C_GLOBALLOG_ALL.operateresult is '操作结果 1 成功 0 失败';
	 * comment on column C_GLOBALLOG_ALL.logtype is '0 其他，1 后台，2 前台，3 核心';
	 * 
	 * @param catalogID
	 *            日志类别号
	 * @param content
	 *            操作内容
	 * @param operateResult
	 *            操作结果 1：成功 0：失败
	 * @param mark
	 *            备注
	 */
	public static void writeOperateLog(final int catalogID,
			final String content, final int operateResult, final String mark,
			final HttpSession session) {
		executorService.submit(new Runnable() {
			@Override
			public void run() {
				CGloballogAll operateLog = new CGloballogAll();
				operateLog.setLogtype(Short.valueOf("1"));
				try {// 当前用户
					UserManageVO user = (UserManageVO) session
							.getAttribute("CurrentUser");

					// 设置日志内容
					operateLog.setOperator(user.getUserID());
					operateLog.setOperateip(user.getLogonIp());
					operateLog.setOperatetime(systemService.getDBTime());
					operateLog.setOperatetype(new Short(String
							.valueOf(catalogID)));
					operateLog.setOperatortype(user.getLogonType());
					operateLog.setOperatecontent(content);
					operateLog.setOperateresult(new Short(String
							.valueOf(operateResult)));
					operateLog.setMark(mark);

					systemService.writeOperateLog(operateLog);
				} catch (Throwable e) {
					log.error("writeOperateLog", e);
				}
			}
		});
	}

}