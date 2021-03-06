package com.yrdce.ipo.modules.sys.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.CommodityService;
import com.yrdce.ipo.modules.sys.service.DistributionRuleService;
import com.yrdce.ipo.modules.sys.service.SystemService;
import com.yrdce.ipo.modules.sys.util.WriteLog;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.DistributionRule;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

import gnnt.MEBS.logonService.vo.UserManageVO;

@Controller
@RequestMapping("DistributionRuleController")
public class DistributionRuleController {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DistributionRuleController.class);
	@Autowired
	private CommodityService commodityService;
	@Autowired
	private DistributionRuleService distributionRuleService;

	@Autowired
	private SystemService systemService;

	// 获取商品信息
	@RequestMapping("getCommonityById")
	@ResponseBody
	public String getCommonityById(@RequestParam("commodity") String comid) {
		try {
			Commodity commodity = commodityService.getCommInfoById(comid);
			String result = JSON.json(commodity);
			return result;
		} catch (Exception e) {
			log.error("获取商品信息异常：", e);
			return "error";
		}
	}

	// 插入分配信息
	@RequestMapping("insertRuleInfo")
	@ResponseBody
	public String insertRuleInfo(DistributionRule distributionRule, HttpSession session) {
		try {
			String userId = ((UserManageVO) session.getAttribute("CurrentUser")).getUserID();
			distributionRule.setDeleteFlag((short) 0);
			distributionRule.setCreateUser(userId);
			int result = distributionRuleService.insertRuleInfo(distributionRule);
			if (result > 0) {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_DISTRIRULE_CATALOGID, "ipo插入摇号规则分配信息成功",
						WriteLog.SYS_LOG_OPE_SUCC, "", session, systemService);
				return "success";
			}
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DISTRIRULE_CATALOGID, "ipo插入摇号规则分配信息失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", session, systemService);
			return "fail";
		} catch (Exception e) {
			log.error("插入分配方式异常：", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DISTRIRULE_CATALOGID, "ipo插入摇号规则分配信息失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", session, systemService);
			return "error";
		}
	}

	// 验证该信息是否已经存在
	@RequestMapping("isExistence")
	@ResponseBody
	public boolean isExistence(@RequestParam("commodityId") String commonityId) {
		try {
			int result = distributionRuleService.infoIsExistence(commonityId);
			if (result > 0) {
				return false;
			}
			return true;
		} catch (Exception e) {
			log.error("验证商品分配信息是否存在异常：", e);
			return false;
		}
	}

	// 分页查询分配设置信息
	@RequestMapping("getRuleInfoByPages")
	@ResponseBody
	public String getRuleInfoByPages(@RequestParam("page") String page, @RequestParam("rows") String rows,
			DistributionRule distributionRule) {
		try {
			List<DistributionRule> distributionRules = distributionRuleService.selectRuleInfoByPages(page,
					rows, distributionRule);
			int result = distributionRuleService.selectInfoCounts(distributionRule);
			ResponseResult responseResult = new ResponseResult();
			responseResult.setTotal(result);
			responseResult.setRows(distributionRules);
			return JSON.json(responseResult);
		} catch (Exception e) {
			log.error("分页查询配置信息异常：", e);
			return "error";
		}

	}

	// 根据商品id查询分配信息
	@RequestMapping("getRuleInfoByCommId")
	@ResponseBody
	public String getRuleInfoByCommId(@RequestParam("commodityId") String commonityId) {
		try {
			DistributionRule distributionRule = distributionRuleService.selectInfoByCommId(commonityId);
			String result = JSON.json(distributionRule);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;

	}

	// 修改分配信息
	@RequestMapping("updateInfoByCommId")
	@ResponseBody
	public String updateInfoByCommId(DistributionRule distributionRule, HttpSession session) {
		try {
			String userId = ((UserManageVO) session.getAttribute("CurrentUser")).getUserID();
			log.info("用户id{}", userId);
			distributionRule.setUpdateUser(userId);
			int result = distributionRuleService.updateInfoByCommId(distributionRule);
			if (result > 0) {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_DISTRIRULE_CATALOGID, "ipo修改摇号规则分配信息成功",
						WriteLog.SYS_LOG_OPE_SUCC, "", session, systemService);
				return "success";

			} else {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_DISTRIRULE_CATALOGID, "ipo修改摇号规则分配信息失败",
						WriteLog.SYS_LOG_OPE_FAILURE, "", session, systemService);
				return "fail";
			}
		} catch (Exception e) {
			log.error("修改分配信息异常：", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DISTRIRULE_CATALOGID, "ipo修改摇号规则分配信息失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", session, systemService);
			return "error";
		}
	}

	@RequestMapping("deleteInfoByCommId")
	@ResponseBody
	public String deleteInfoByCommId(@RequestParam("commodityid") String commid, HttpSession session) {
		try {
			String userId = ((UserManageVO) session.getAttribute("CurrentUser")).getUserID();
			int result = distributionRuleService.deleteInfoByCommid(commid, userId);
			if (result > 0) {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_DISTRIRULE_CATALOGID, "ipo删除摇号规则分配信息成功",
						WriteLog.SYS_LOG_OPE_SUCC, "", session, systemService);
				return "success";
			}
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DISTRIRULE_CATALOGID, "ipo删除摇号规则分配信息失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", session, systemService);
			return "fail";
		} catch (Exception e) {
			log.error("删除配置信息异常：", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DISTRIRULE_CATALOGID, "ipo删除摇号规则分配信息失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", session, systemService);
			return "error";
		}
	}

}
