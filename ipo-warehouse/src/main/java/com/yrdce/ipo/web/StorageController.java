package com.yrdce.ipo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 入库申请Controller
 * 
 * @author 李伟东
 * @version 2015.12.20
 */
@Controller
@RequestMapping("StorageController")
public class StorageController {
	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(StorageController.class);
	//入库单添加视图
	@RequestMapping(value = "/AddStorageView", method = RequestMethod.GET)
	@ResponseBody
	public String AddStorageView(HttpServletRequest request, HttpServletResponse response, Model model){
		log.info("入库单添加");
		return "../addstorageaudit.jsp";
	}
}
