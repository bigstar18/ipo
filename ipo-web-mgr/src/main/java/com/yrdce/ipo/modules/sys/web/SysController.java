package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.utils.DateUtils;
import com.yrdce.ipo.common.vo.ResultMsg;
import com.yrdce.ipo.modules.sys.service.SystemService;
import com.yrdce.ipo.modules.sys.vo.CGloballogAll;
import com.yrdce.ipo.modules.sys.vo.IpoSysStatus;

import gnnt.MEBS.logonService.vo.UserManageVO;

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

	private static Logger log = org.slf4j.LoggerFactory.getLogger(SysController.class);

	@Autowired
	private SystemService systemService;

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
				value.setStatusStr((String) statusMap.get(String.valueOf(status)));
			value.setSysTime(DateUtils.formatDateTime(systemService.getDBTime()));
			return JSON.json(value);
		} catch (Exception e) {
			log.error("error:", e);
			return "";
		}
	}

	// 系统操作
	@RequestMapping(value = "/sysOperate", method = RequestMethod.POST)
	@ResponseBody
	public String sysControl(@RequestParam("code") String oprCode, HttpSession session) throws IOException {
		try {
			if (oprCode == null)
				throw new Exception("operate code is null.");
			ResultMsg msg = systemService.sysControl(oprCode);
			if (msg == null) {
				msg = new ResultMsg();
				msg.setResult(ResultMsg.RESULT_ERROR);
			}
			return JSON.json(msg);
		} catch (Exception e) {
			log.error("error:", e);
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

	// 结算
	@RequestMapping(value = "/settle", method = RequestMethod.POST)
	@ResponseBody
	public String settle(HttpSession session) {
		// localSystemStatus.setStatus(2); t.note = '结算中';

		// 解冻仓单 抵押unFrozenStocks(15, arrayOfString);
		// 交易服务器没有闭市操作，不能结算！ tradeRMI.balance();

		// FN_T_CloseMarketProcess

		// localSystemStatus.setStatus(10);
		// localSystemStatus.setSectionID(null);
		// localSystemStatus.setNote(null);
		// localSystemStatus.setRecoverTime(null);

		// ResultVO localResultVO = null;
		// try {
		// List localList = getService().getListBySql(
		// "select f.billid from T_billFrozen f, T_E_GageBill g where f.operation = g.id and Operationtype = 0 and g.commodityid in (select
		// CommodityID from T_Commodity where SettleDate <= (select trunc(tradedate) from t_systemstatus))");
		// arrayOfString = new String[9999999];
		// for (int j = 0; j < localList.size(); j++) {
		// Map localMap = (Map) localList.get(j);
		// String str2 = localMap.get("BILLID").toString();
		// arrayOfString[j] = str2;
		// }
		// if ((localList != null) && (localList.size() > 0)) {
		// localResultVO = iTradeService.unFrozenStocks(15, arrayOfString);
		// }
		// if ((localResultVO == null) || (localResultVO.getResult() >= 0L) || (localResultVO.getResult() == -2L)) {
		// i = tradeRMI.balance();
		// if (i == 1) {
		// addReturnValue(1, 111502L);
		// writeOperateLog(1503, "交易结算成功", 1, "");
		// } else if (i == -2) {
		// addReturnValue(-1, 131517L);
		// writeOperateLog(1503, "交收处理出错", 0, "");
		// } else {
		// addReturnValue(-1, 131518L);
		// writeOperateLog(1503, "交易结算失败", 0, "");
		// }
		// }
		// } catch (Exception localException) {
		// String[] arrayOfString = localException.getMessage().split(":");
		// String str1 = arrayOfString[(arrayOfString.length - 1)];
		// addReturnValue(-1, 131519L, new Object[] { str1 });
		// writeOperateLog(1503, "RMI交易结算失败！" + localException.getMessage(), 0, "");
		// }
		return null;
	}

	/**
	 * 写操作日志
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
	private void writeOperateLog(int catalogID, String content, int operateResult, String mark, HttpSession session) {
		CGloballogAll operateLog = new CGloballogAll();
		operateLog.setLogtype(Short.valueOf("1"));
		// 当前用户
		UserManageVO user = (UserManageVO) session.getAttribute("CurrentUser");

		// 设置日志内容
		operateLog.setOperator(user.getUserID());
		operateLog.setOperateip(user.getLogonIp());
		operateLog.setOperatetime(systemService.getDBTime());
		operateLog.setOperatetype(new Short(String.valueOf(catalogID)));
		operateLog.setOperatortype(user.getLogonType());
		operateLog.setOperatecontent(content);
		operateLog.setOperateresult(new Short(String.valueOf(operateResult)));
		operateLog.setMark(mark);

		try {
			systemService.writeOperateLog(operateLog);
		} catch (Exception e) {
			log.error("writeOperateLog", e);
		}
	}

}
