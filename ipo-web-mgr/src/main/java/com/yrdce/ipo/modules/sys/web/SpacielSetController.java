package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.SpecialPoundageService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.SpecialPoundage;

/*
 * 成效会员管理
 * 李伟东*/
@Controller
@RequestMapping("SpacialSetController")
public class SpacielSetController {
	@Autowired
	private SpecialPoundageService specialPoundageService;
	@RequestMapping(value = "/getAllInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAllInfo() throws IOException{
		try {
			System.out.println("start");
			List<SpecialPoundage> slist = specialPoundageService.GetAllInfo();
			System.out.println("1");
			ResponseResult result = new ResponseResult();
			result.setRows(slist);
			System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}
