package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.FirmAuthorityService;
import com.yrdce.ipo.modules.sys.service.StatisticsReportService;

/**
 * @ClassName: AuthorityController
 * @Description: 交易商权限设置
 * @author bob
 */
@Controller
@RequestMapping("authorityController")
public class AuthorityController {
	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(AuthorityController.class);

	@Autowired
	private FirmAuthorityService firmAuthorityService;
	@Autowired
	private StatisticsReportService statisticsReportService;

	@RequestMapping(value = "getMoudel", method = RequestMethod.GET)
	@ResponseBody
	public String getMoudel(@RequestParam("firmid") String firmid) throws IOException {
		logger.info("查询模块");
		String firmName = statisticsReportService.firmName(firmid);
		if (firmName == null) {
			return "error";
		}
		List<String> models = firmAuthorityService.getFirmAuthority(firmid);
		return JSON.json(models);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	@ResponseBody
	public String update(@RequestParam("firmid") String firmid,
			@RequestParam(value = "moudel", required = false) String moudel) {
		logger.info("保存");
		if (moudel == null) {
			firmAuthorityService.delete(firmid);
			return "success";
		} else {
			firmAuthorityService.delete(firmid);
			String[] models = moudel.split(",");
			for (String moudelPaaram : models) {
				firmAuthorityService.insert(firmid, moudelPaaram);
			}
			return "success";
		}
	}
}
