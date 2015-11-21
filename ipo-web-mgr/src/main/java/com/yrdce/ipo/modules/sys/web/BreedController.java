package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.web.BaseController;
import com.yrdce.ipo.modules.sys.service.CommodityService;
import com.yrdce.ipo.modules.sys.service.MBreedService;
import com.yrdce.ipo.modules.sys.service.TABreedService;
import com.yrdce.ipo.modules.sys.service.VIpoABreedService;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.MBreed;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.TABreed;
import com.yrdce.ipo.modules.sys.vo.VIpoABreed;

/**
 * 品种管理Controller
 * 
 * @author ThinkGem
 * @version 2013-5-31
 */
@Controller
@RequestMapping("BreedController")
public class BreedController extends BaseController {
	
	static Logger log = Logger.getLogger(BreedController.class);
	
	@Autowired
	private VIpoABreedService vIpoABreedService;
	
	@Autowired
	private MBreedService mBreedservice;
	
	public VIpoABreedService getvIpoABreedService() {
		return vIpoABreedService;
	}

	public void setvIpoABreedService(VIpoABreedService vIpoABreedService) {
		this.vIpoABreedService = vIpoABreedService;
	}

	public MBreedService getmBreedservice() {
		return mBreedservice;
	}

	public void setmBreedservice(MBreedService mBreedservice) {
		this.mBreedservice = mBreedservice;
	}

	/**
	 * 分页返回品种列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findIpoABreeds", method = RequestMethod.GET)
	@ResponseBody
	public String findIpoABreeds(@RequestParam("page") String page, @RequestParam("rows") String rows) throws IOException {
		log.info("分页查询品种列表");
		try {
			List<VIpoABreed> tlist = new ArrayList<VIpoABreed>();
			tlist = vIpoABreedService.findIpoABreedsByPage(page, rows);
			int totalnums = vIpoABreedService.getTotalIpoABreeds();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			//System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 品种下拉框
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectBreed", method = RequestMethod.GET)
	@ResponseBody
	public String selectBreed() throws IOException {
		log.info("查询所有分配到IPO权限下的品种至下拉框");
		try {
		List<MBreed> Mlist = new ArrayList<MBreed>();
		Mlist = mBreedservice.findAll();
		ResponseResult result = new ResponseResult();
		result.setRows(Mlist);
		return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
	/**
	 * 增加一个品种
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addBreed", method = RequestMethod.GET)
	@ResponseBody
	public String addBreed() throws IOException {
		log.info("查询所有分配到IPO权限下的品种至下拉框");
		try {
		List<MBreed> Mlist = new ArrayList<MBreed>();
		Mlist = mBreedservice.findAll();
		ResponseResult result = new ResponseResult();
		result.setRows(Mlist);
		return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	
	
	
	
}
