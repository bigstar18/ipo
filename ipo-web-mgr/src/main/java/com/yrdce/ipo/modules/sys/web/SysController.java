package com.yrdce.ipo.modules.sys.web;

import gnnt.MEBS.logonService.vo.UserManageVO;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.yrdce.ipo.common.vo.ResultMsg;
import com.yrdce.ipo.modules.sys.service.SystemService;
import com.yrdce.ipo.modules.sys.vo.CGloballogAll;
import com.yrdce.ipo.modules.sys.vo.IpoSysStatus;

/**
 * @author hxx
 * 
 */
@Controller
@RequestMapping("sysController")
public class SysController {
	public static Map statusMap = new HashMap();

	static {
		statusMap.put("0", "初始化完成");
		statusMap.put("1", "闭市状态");
		statusMap.put("2", "结算中");
		statusMap.put("3", "资金结算完成");
		statusMap.put("4", "暂停交易");
		statusMap.put("5", "交易中");
		statusMap.put("6", "节间休息");
		statusMap.put("7", "交易结束");
		statusMap.put("8", "集合竞价交易中");
		statusMap.put("9", "集合竞价交易结束");
		statusMap.put("10", "交易结算完成");
	}

	public static final int SYS_LOG_CATALOGID = 4001;
	public static final int SYS_LOG_OPE_SUCC = 1;
	public static final int SYS_LOG_OPE_FAILURE = 0;

	private static Logger log = org.slf4j.LoggerFactory
			.getLogger(SysController.class);
	@Autowired
	private SystemService systemService;
	private ExecutorService executorService = Executors
			.newCachedThreadPool(new ThreadFactoryBuilder()
					.setNameFormat("writeOperateLog-%d").setDaemon(true)
					.build());

	// 重新载入交易节
	@RequestMapping(value = "/reloadSections", method = RequestMethod.POST)
	@ResponseBody
	public String reloadSections() throws IOException {
		try {
			log.info("==================reloadSections");
			systemService.reloadSections();
			return "";
		} catch (Exception e) {
			log.error("error:", e);
			return "";
		}
	}

	// 系统状态
	@RequestMapping(value = "/getSysStatus", method = RequestMethod.GET)
	@ResponseBody
	public String getTradeStatus() throws IOException {
		try {
			IpoSysStatus value = systemService.querySysStatus();
			if (value == null) {
				value = new IpoSysStatus();
			}
			Short status = value.getStatus();
			if (status != null && statusMap.containsKey(String.valueOf(status)))
				value.setStatusStr((String) statusMap.get(String
						.valueOf(status)));
			value.setSysTime(DateFormatUtils.format(systemService.getDBTime(),
					"yyyy-MM-dd HH:mm:ss"));
			return JSON.json(value);
		} catch (Exception e) {
			log.error("error:", e);
			return "";
		}
	}

	// 系统操作
	@RequestMapping(value = "/sysOperate", method = RequestMethod.POST)
	@ResponseBody
	public String sysControl(@RequestParam("code") String oprCode,
			HttpSession session) throws IOException {
		try {
			log.info("==================sysOperate, code= {}", oprCode);
			if (oprCode == null)
				throw new Exception("operate code is null.");
			ResultMsg msg = systemService.sysControl(oprCode);
			if (msg == null) {
				msg = new ResultMsg();
				msg.setResult(ResultMsg.RESULT_ERROR);
			}
			writeOperateLog(SYS_LOG_CATALOGID, "IPO系统控制: " + oprCode,
					SYS_LOG_OPE_SUCC, "", session);
			return JSON.json(msg);
		} catch (Exception e) {
			log.error("error:", e);
			writeOperateLog(SYS_LOG_CATALOGID, "IPO系统控制: " + oprCode,
					SYS_LOG_OPE_FAILURE, e.getLocalizedMessage(), session);

			ResultMsg msg = new ResultMsg();
			msg.setResult(ResultMsg.RESULT_EXCEPTION);
			return JSON.json(msg);
		}
	}

	// 交易结算状态
	@RequestMapping(value = "/getSettleStatus", method = RequestMethod.GET)
	@ResponseBody
	public String getSettleStatus() throws IOException {
		try {
			return JSON.json(systemService.getSysStatusFromMem());
		} catch (Exception e) {
			log.error("error:", e);
			return null;
		}
	}

	// 交易结算结果记录
	@RequestMapping(value = "/getClearRecords", method = RequestMethod.GET)
	@ResponseBody
	public String getClearRecords() throws IOException {
		try {
			List records = systemService.getClearRecords();
			if (records != null)
				return JSON.json(records);
			else
				return null;
		} catch (Exception e) {
			log.error("error:", e);
			return null;
		}
	}

	// 结算 ，防止并发
	@RequestMapping(value = "/settle", method = RequestMethod.POST)
	@ResponseBody
	public String settle(HttpSession session) throws Exception {
		try {
			ResultMsg msg = systemService.settle();
			if (msg == null) {
				msg = new ResultMsg();
				msg.setResult(ResultMsg.RESULT_ERROR);
			}
			writeOperateLog(SYS_LOG_CATALOGID, "IPO交易结算: " + msg.getMsg(),
					SYS_LOG_OPE_SUCC, "", session);

			return JSON.json(msg);
		} catch (Exception e) {
			log.error("error:", e);
			writeOperateLog(SYS_LOG_CATALOGID,
					"IPO交易结算: " + e.getLocalizedMessage(), SYS_LOG_OPE_FAILURE,
					"", session);

			ResultMsg msg = new ResultMsg();
			msg.setResult(ResultMsg.RESULT_EXCEPTION);
			msg.setMsg(e.getLocalizedMessage());
			return JSON.json(msg);
		}
	}

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
	private void writeOperateLog(final int catalogID, final String content,
			final int operateResult, final String mark,
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
