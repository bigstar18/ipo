package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yrdce.ipo.modules.sys.service.SPOService;
import com.yrdce.ipo.modules.sys.vo.SpoCommoditymanmaagement;

@Controller
@RequestMapping("SPOController")
public class SPOController {
	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SPOController.class);
	@Autowired
	private SPOService spoService;

	
	@RequestMapping(value = "/insertSPOInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String InsertSPOInfo(SpoCommoditymanmaagement ipospo)throws IOException{
		logger.info("添加商品增发信息");
		try {
			int temp = spoService.insertSPOInfo(ipospo);
			if (temp==1) {
				return "success";
			} else {
				return "error";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
		
		
	}
	
		
}
