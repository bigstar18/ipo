package com.yrdce.ipo.modules.sys.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.LoanDepositService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.UnderwriterDeposit;

@Controller
@RequestMapping("SubFundsController")
public class SubFundsController {
	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SubFundsController.class);

	@Autowired
	private LoanDepositService loanDepositService;

	// 认购资金查询
	@RequestMapping(value = "/insertSPOInfo")
	@ResponseBody
	public String getSubFundsInfo(@RequestParam("page") String page, @RequestParam("rows") String rows,
			@RequestParam("underwriterid") String underwriterid) {
		try {
			logger.info("认购资金查询");
			List<UnderwriterDeposit> underwriterDeposits = loanDepositService.getSubFundsInfo(page, rows,
					underwriterid);
			if (underwriterDeposits == null) {
				underwriterDeposits = new ArrayList<UnderwriterDeposit>();
			}
			int counts = loanDepositService.getSubFundsInfoCounts(underwriterid);
			ResponseResult responseResult = new ResponseResult();
			responseResult.setRows(underwriterDeposits);
			responseResult.setTotal(counts);
			String resultJson = JSON.json(responseResult);
			logger.info(resultJson);
			return resultJson;
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("认购资金查询：", e);
			return "error";
		}
	}
}
