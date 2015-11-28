package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.SysStatusService;
import com.yrdce.ipo.modules.sys.vo.IpoSysStatus;

/**
 * @author hxx
 * 
 */
@Controller
@RequestMapping("tradeController")
public class TradeController {
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

	private static Logger log = org.slf4j.LoggerFactory.getLogger(TradeController.class);

	@Autowired
	private SysStatusService sysStatusService;

	// 交易节信息展示
	@RequestMapping(value = "/getTradeStatus", method = RequestMethod.GET)
	@ResponseBody
	public String getTradeStatus() throws IOException {
		try {
			IpoSysStatus value = sysStatusService.querySysStatus();
			if (value == null) {
				value = new IpoSysStatus();
			}
			Short status = value.getStatus();
			if (status != null && statusMap.containsKey(String.valueOf(status)))
				value.setStatusStr((String) statusMap.get(String.valueOf(status)));
			value.setSysTime(sysStatusService.getDBTime());
			return JSON.json(value);
		} catch (Exception e) {
			log.error("error:", e);
			return "";
		}
	}

}
