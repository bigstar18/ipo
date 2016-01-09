package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.LoanDepositService;
import com.yrdce.ipo.modules.sys.vo.Firmcurfunds;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.UnderwriterSubscribe;

/*
 * 成效会员管理
 * 李伟东*/
@Controller
@RequestMapping("LoanDepositController")
public class LoanDepositController {
	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(LoanDepositController.class);

	@Autowired
	private LoanDepositService loanDepositService;

	@RequestMapping(value = "/getAllInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAllInfo(@RequestParam("page") String page, @RequestParam("rows") String rows,
			@RequestParam(value = "underwriterid", required = false) String underwriterid) {
		try {
			List<UnderwriterSubscribe> clist;
			if (underwriterid == null) {
				underwriterid = "no";
			}
			clist = loanDepositService.GetAllInfo(page, rows, underwriterid);
			for (UnderwriterSubscribe under : clist) {
				BigDecimal amount = under.getAmount();
				logger.info("冻结金额：" + amount);
				BigDecimal UserBalance = under.getUserBalance();
				logger.info("用户金额：" + UserBalance);
				BigDecimal lBalance = UserBalance.subtract(amount);
				under.setlBalance(lBalance);
			}
			int totalnum = loanDepositService.getpage(underwriterid);
			ResponseResult result = new ResponseResult();
			result.setRows(clist);
			result.setTotal(totalnum);
			System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(value = "/addSubCommonityForward", method = RequestMethod.GET)
	public String addSubCommonityForward(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		try {
			logger.info("跳转至添加");
			return "app/underwritingManage/addSubCommonity";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(value = "/goBackPage", method = RequestMethod.GET)
	public String goBackPage(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		try {
			logger.info("返回手续费设置");
			return "app/underwritingManage/underwritingSet";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	/**
	 * 根据id查询商品信息
	 */
	@RequestMapping(value = "/getInfoByName", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getInfoByName(@RequestParam(value = "name", required = false) String name) {

		try {
			if (name == null) {
				name = "";
			}
			List<Firmcurfunds> clist = loanDepositService.GetInfoByName(name);
			ResponseResult result = new ResponseResult();
			result.setRows(clist);
			System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

}
