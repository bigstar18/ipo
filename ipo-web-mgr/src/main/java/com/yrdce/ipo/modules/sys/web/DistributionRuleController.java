package com.yrdce.ipo.modules.sys.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.CommodityService;
import com.yrdce.ipo.modules.sys.vo.Commodity;

@Controller
@RequestMapping("DistributionRuleController")
public class DistributionRuleController {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DistributionRuleController.class);
	@Autowired
	private CommodityService commodityService;

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
}
