package com.yrdce.ipo.modules.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.UnderwritingQueryService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.UnderwritingQuery;

@Controller
@RequestMapping("UnderwriterQueryController")
public class UnderwriterQueryController {
	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(UnderwriterQueryController.class);
	@Autowired
	private UnderwritingQueryService underwritingQueryService;

	// 商品承销信息
	@RequestMapping(value = "/getcommodityInfo", method = RequestMethod.GET)
	@ResponseBody
	public String getcommodityInfo(@RequestParam("page") String page, @RequestParam("rows") String rows, UnderwritingQuery underwritingQuery) {
		logger.info("商品承销信息");
		List<UnderwritingQuery> comlist;
		try {
			comlist = underwritingQueryService.getUnderInfo(page, rows, underwritingQuery);
			int totalnum = underwritingQueryService.getQueryNum(underwritingQuery);
			ResponseResult result = new ResponseResult();
			result.setRows(comlist);
			result.setTotal(totalnum);
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
