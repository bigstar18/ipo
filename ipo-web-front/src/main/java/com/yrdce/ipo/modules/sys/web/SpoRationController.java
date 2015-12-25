package com.yrdce.ipo.modules.sys.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.SPOService;
import com.yrdce.ipo.modules.sys.vo.Pickup;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.Spo;

@Controller
@RequestMapping("spoRationController")
public class SpoRationController {
	static Logger logger = LoggerFactory.getLogger(SpoRationController.class);
	@Autowired
	private SPOService spoService;
	
	@RequestMapping(value = "/selectRationInfo", method = RequestMethod.GET)
	@ResponseBody
	public String SelectRationInfo(@RequestParam("page")String page,
			@RequestParam("rows")String rows,
			@RequestParam("communityId")String commId,
			@RequestParam("registerDateStart")String startdate,
			@RequestParam("registerDateEnd")String enddate
			){
		logger.info("配售信息");
		logger.info(commId);
		logger.info(startdate);
		logger.info(enddate);
		try {
			Spo spo = new Spo();
			if (!commId.equals("")) {
				spo.setCommunityId(commId);
			}
			if (!startdate.equals("")) {
				String[] temp = startdate.split("/");
				startdate = temp[2]+"-"+temp[0]+"-"+temp[1];
				spo.setRegisterDateSart(startdate);
			}
			if (!enddate.equals("")) {
				String[] temp = enddate.split("/");
				enddate = temp[2]+"-"+temp[0]+"-"+temp[1];
				spo.setRegisterDateEnd(enddate);
			}
			List<Spo> spoList = spoService.getInfoByPages(spo, page, rows);
			int counts = spoService.getInfoCounts(spo);
			ResponseResult responseResult = new ResponseResult();
			responseResult.setRows(spoList);
			responseResult.setTotal(counts);
			String resultJson =JSON.json(responseResult);
			System.out.println(resultJson);
			return resultJson;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String SelectRationInfo2(@RequestParam("page")String page,
			@RequestParam("rows")String rows,
			@RequestParam("communityId")String commId,
			@RequestParam("registerDateStart")String startdate,
			@RequestParam("registerDateEnd")String enddate
			){
		logger.info("配售信息");
		try {
			Spo spo = new Spo();
			if (!commId.equals("")) {
				spo.setCommunityId(commId);
			}
			if (!startdate.equals("")) {
				
			}
			List<Spo> spoList = spoService.getInfoByPages(spo, page, rows);
			int counts = spoService.getInfoCounts(spo);
			ResponseResult responseResult = new ResponseResult();
			responseResult.setRows(spoList);
			responseResult.setTotal(counts);
			String resultJson =JSON.json(responseResult);
			System.out.println(resultJson);
			return resultJson;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	
	@RequestMapping(value = "/updateRationType", method = RequestMethod.POST)
	@ResponseBody
	public String UpdateRationType(@RequestParam("spoId")String spoId){
		logger.info("确认配售");
		try {
			int result = spoService.updateRationType(spoId);
			if (result==1) {
				return "success";
			}else{
				return "error";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
}