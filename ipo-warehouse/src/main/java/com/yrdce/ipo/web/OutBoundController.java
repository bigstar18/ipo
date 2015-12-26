package com.yrdce.ipo.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.OutboundService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

/**
 * 入库申请Controller
 * 
 * @author 李伟东
 * @version 2015.12.20
 */
@Controller
@RequestMapping("OutBoundController")
public class OutBoundController {
	@Autowired
	private OutboundService outboundService;
	static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(StorageController.class);

	@RequestMapping(value = "/geOutBoundInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String geOutBoundInfo() throws IOException {
		try {
			System.out.println("start");
			// List<Outbound> slist = outboundService.getAllOutboundInfo();
			ResponseResult result = new ResponseResult();
			// result.setRows(slist);
			System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	// 入库单添加视图
	@RequestMapping(value = "/AddOutBoundView", method = RequestMethod.GET)
	public String AddOutBoundView(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		try {
			log.info("入库单添加");
			return "app/outbound/addoutboundaudit";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}

	}
}
