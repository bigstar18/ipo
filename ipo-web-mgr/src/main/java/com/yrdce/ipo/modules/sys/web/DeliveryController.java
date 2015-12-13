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
import com.yrdce.ipo.common.web.BaseController;
import com.yrdce.ipo.modules.sys.service.VIpoABreedService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.VIpoABreed;

/**
 * 交收管理Controller
 * 
 * @author chenjing
 * @version 2013-5-31
 */
@Controller
@RequestMapping("DeliveryController")
public class DeliveryController extends BaseController {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(DeliveryController.class);

	@Autowired
	private VIpoABreedService vIpoABreedService;

	/**
	 * 分页返回提货单列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findAllDeliveryOrders", method = RequestMethod.POST)
	@ResponseBody
	public String findAllDeliveryOrders(@RequestParam("page") String page,
			@RequestParam("rows") String rows) throws IOException {
		log.info("分页查询所有提货单");
		try {
			List<VIpoABreed> tlist = vIpoABreedService.findIpoABreedsByPage(
					page, rows);
			int totalnums = vIpoABreedService.getTotalIpoABreeds();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			log.info(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
