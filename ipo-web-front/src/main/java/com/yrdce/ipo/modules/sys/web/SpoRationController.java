package com.yrdce.ipo.modules.sys.web;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.SpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.vo.SpoRation;

import gnnt.MEBS.logonService.vo.UserManageVO;

@Controller
@RequestMapping("spoRationController")
public class SpoRationController {
	static Logger logger = LoggerFactory.getLogger(SpoRationController.class);
	@Autowired
	private SPOService spoService;

	@RequestMapping(value = "/selectRationInfo", method = RequestMethod.GET)
	@ResponseBody
	public String SelectRationInfo(@RequestParam("page") String page, @RequestParam("rows") String rows,
			SpoCommoditymanmaagement spo, HttpSession session) {
		logger.info("配售信息");
		try {
			String dealerId = ((UserManageVO) session.getAttribute("CurrentUser")).getUserID();
			spo.setFirmid(dealerId);//dealerId
			List<SpoRation> spoList = spoService.getMyRationInfo(spo, page, rows);
			int counts = spoService.getRationInfoCounts(spo);
			logger.info(String.valueOf(counts));
			ResponseResult responseResult = new ResponseResult();
			responseResult.setRows(spoList);
			responseResult.setTotal(counts);
			String resultJson = JSON.json(responseResult);
			System.out.println(resultJson);
			return resultJson;
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	@RequestMapping(value = "/updateRationType", method = RequestMethod.POST)
	@ResponseBody
	public String UpdateRationType(@RequestParam("rationId") String rationId, HttpSession session) {
		logger.info("确认配售");
		try {
			String dealerId = ((UserManageVO) session.getAttribute("CurrentUser")).getUserID();
			//String dealerId = "hl";
			int result = spoService.updateRationType(Long.parseLong(rationId), dealerId);
			if (result == 1) {
				return "success";
			} else if (result == 2) {
				return "funds";
			} else {
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
