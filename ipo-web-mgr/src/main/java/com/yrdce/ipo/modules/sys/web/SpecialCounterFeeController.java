package com.yrdce.ipo.modules.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.SpecialCounterFeeService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.Specialcounterfee;

@Controller
@RequestMapping("SpecialCounterFeeController")
public class SpecialCounterFeeController {
	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SpecialCounterFeeController.class);
	@Autowired
	private SpecialCounterFeeService specialCounterFeeService;

	// 添加特殊手续费
	@RequestMapping(value = "/addSpecialCounterfeeInfo")
	@ResponseBody
	public String addSpecialCounterfeeInfo(Specialcounterfee specialcounterfee) {
		try {
			logger.info("添加特殊手续费");
			int result = specialCounterFeeService.insertSpecialcounterfeeInfo(specialcounterfee);
			if (result == 1) {
				return "success";
			} else {
				return "fail";
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("添加特殊手续费", e);
			return "error";
		}

	}

	// 查询特殊收费
	@RequestMapping(value = "/getSpecialCounterfeeInfo")
	@ResponseBody
	public String getSpecialCounterfeeInfo(@RequestParam("page") String page, @RequestParam("rows") String rows) {
		try {
			logger.info("查询特殊手续费");
			List<Specialcounterfee> specialcounterfees = specialCounterFeeService.getSpecialcounterfeeInfo(page, rows);
			int counts = specialCounterFeeService.getCounts();
			ResponseResult responseResult = new ResponseResult();
			responseResult.setRows(specialcounterfees);
			responseResult.setTotal(counts);
			String resultJson = JSON.json(responseResult);
			logger.info(resultJson);
			return resultJson;
		} catch (Exception e) {
			logger.error("查询特殊手续费异常", e);
			return "";
		}
	}

	// 删除特殊收费
	@RequestMapping(value = "/deleteInfoById")
	@ResponseBody
	public String deleteInfoById(@RequestBody List<String> ids) {
		try {
			logger.info("删除特殊手续费");
			int result = 0;
			for (String id : ids) {
				result += specialCounterFeeService.deleteInfoById(id);
			}
			if (result > 0) {
				return "success";
			} else {
				return "fail";
			}

		} catch (Exception e) {
			logger.error("删除特殊手续费异常", e);
			return "error";
		}
	}

	// 验证交易商账号
	@RequestMapping(value = "/isFirm")
	@ResponseBody
	public boolean isFirm(@RequestParam("firmid") String firmid) {
		try {
			int result = specialCounterFeeService.isFirm(firmid);
			if (result > 0) {
				return true;
			}
			return false;
		} catch (Exception e) {
			logger.error("验证交易商账号异常", e);
			return false;
		}
	}

	// 根据id查询信息
	@RequestMapping(value = "/selectInfoById")
	@ResponseBody
	public String selectInfoById(@RequestParam("id") String id) {
		try {
			Specialcounterfee specialcounterfee = specialCounterFeeService.selectInfoById(id);
			String result = JSON.json(specialcounterfee);
			logger.info(result);
			return result;
		} catch (Exception e) {
			logger.error("根据id查询信息异常", e);
			return "error";
		}
	}

	// 修改特殊手续费信息
	@RequestMapping(value = "/updateInfoById")
	@ResponseBody
	public String updateInfoById(Specialcounterfee specialcounterfee) {
		try {
			logger.info("跟新特殊手续费信息");
			int result = specialCounterFeeService.updateInfoById(specialcounterfee);
			if (result > 0) {
				return "success";
			} else {
				return "fail";
			}

		} catch (Exception e) {
			logger.error("跟新特殊手续费信息", e);
			return "error";
		}

	}
}
