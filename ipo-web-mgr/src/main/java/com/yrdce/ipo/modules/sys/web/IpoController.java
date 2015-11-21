package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.web.BaseController;
import com.yrdce.ipo.modules.sys.service.MBreedService;
import com.yrdce.ipo.modules.sys.vo.MBreed;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

/**
 * 查询商品Controller
 * 
 * @author ThinkGem
 * @version 2013-5-31
 */
@Controller
@RequestMapping("IpoController")
public class IpoController extends BaseController  {
	
	static Logger log = Logger.getLogger(IpoController.class);
	
	@Autowired
	private MBreedService mBreedservice;
	
	public MBreedService getmBreedservice() {
		return mBreedservice;
	}

	public void setmBreedservice(MBreedService mBreedservice) {
		this.mBreedservice = mBreedservice;
	}
	
	/*
	 * 交易节管理视图
	 */
	@RequestMapping(value = "/tradeTimeManage", method = RequestMethod.POST)
	public String tradeTimeManage(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "app/tradetime/tradeTime_list";
	}

	/*
	 * 商品管理视图
	 */
	@RequestMapping(value = "/CommodityManage", method = RequestMethod.POST)
	public String CommodityManage(HttpServletRequest request,
			HttpServletResponse response, Model model) {
		return "app/breed/breed_list";
	}
	
	/*
	 * 新增品种视图
	 */
	@RequestMapping(value = "/addBreedforward", method = RequestMethod.POST)
	public String addBreedforward(HttpServletRequest request,
			HttpServletResponse response, Model model) throws IOException {
		request.setAttribute("crud", "create");
		log.info("查询所有分配到IPO权限下的品种至下拉框");
		List<MBreed> Mlist = new ArrayList<MBreed>();
		Mlist = mBreedservice.findAll();
		request.setAttribute("Mlist",JSON.json(Mlist));
		return "app/breed/breed";
	}
}
