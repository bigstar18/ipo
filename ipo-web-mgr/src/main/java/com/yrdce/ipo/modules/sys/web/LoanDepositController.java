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
import com.yrdce.ipo.modules.sys.service.LoanDepositService;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.Firmcurfunds;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;


/*
 * 成效会员管理
 * 李伟东*/
@Controller
@RequestMapping("LoanDepositController")
public class LoanDepositController {
	@Autowired
	private LoanDepositService loanDepositService;
	
	@RequestMapping(value = "/getAllInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAllInfo() throws IOException{
		try {
			List<Firmcurfunds> clist = loanDepositService.GetAllInfo();
			ResponseResult result = new ResponseResult();
			result.setRows(clist);
			System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
		
	}
	
	/**
	 * 根据会员id查询商品信息(发行摇号)
	 */
	@RequestMapping(value = "/getInfoByName", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getInfoByName( @RequestParam(value = "name", required = false) String name) {
		
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
