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
import com.yrdce.ipo.modules.sys.service.IpoCommConfService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;

/**
 * 发行会员查询Controller
 * 
 * @author chenjing
 * @version 2013-5-31
 */
@Controller
@RequestMapping("PublisherController")
public class PublisherController {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(PublisherController.class);

	@Autowired
	private IpoCommConfService ipoCommConfService;

	/**
	 * 产品发行查询
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	public IpoCommConfService getIpoCommConfService() {
		return ipoCommConfService;
	}

	public void setIpoCommConfService(IpoCommConfService ipoCommConfService) {
		this.ipoCommConfService = ipoCommConfService;
	}

	/**
	 * 分页查询所有商品列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findAllCommsByExample", method = RequestMethod.POST)
	@ResponseBody
	public String findAllCommsByExample(@RequestParam("page") String page,
			@RequestParam("rows") String rows, VIpoCommConf example)
			throws IOException {
		log.info("查询所有商品列表");
		try {
			List<VIpoCommConf> comlist = ipoCommConfService
					.findIpoCommConfsByExample(page, rows, example);
			int totalnum = ipoCommConfService.getNumsByExample(example);
			ResponseResult result = new ResponseResult();
			result.setRows(comlist);
			result.setTotal(totalnum);
			log.info(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
