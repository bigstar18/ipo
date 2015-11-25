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
import com.yrdce.ipo.modules.sys.service.DisplayService;
import com.yrdce.ipo.modules.sys.service.DistributionService;
import com.yrdce.ipo.modules.sys.service.Purchase;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.Distribution;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

/**
 * 查询商品Controller
 * 
 * @author ThinkGem
 * @version 2013-5-31
 */
@Controller
@RequestMapping("CommodityController")
public class CommodityController extends BaseController {

	static Logger log = Logger.getLogger(CommodityController.class);

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private Purchase purchase;

	@Autowired
	private DisplayService displayService;

	@Autowired
	private DistributionService distributionService;

	public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}

	public DisplayService getDisplayService() {
		return displayService;
	}

	public void setDisplayService(DisplayService displayService) {
		this.displayService = displayService;
	}

	public DistributionService getDistributionService() {
		return distributionService;
	}

	public void setDistributionService(DistributionService distributionService) {
		this.distributionService = distributionService;
	}

	/**
	 * mgr手动摇号服务
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findComms", method = RequestMethod.GET)
	@ResponseBody
	public String findCommsx(@RequestParam("page") String page, @RequestParam("rows") String rows) throws IOException {
		log.info("分页查询发售商品信息");
		try {
			List<Commodity> clist = new ArrayList<Commodity>();
			clist = commodityService.getList(page, rows);
			int totalnums = commodityService.getAllComms();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(clist);
			System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 分页配号查询
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findApplyNums", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findApplyNums(@RequestParam("page") String page, @RequestParam("rows") String rows, @RequestParam("userid") String userid)
			throws IOException {
		log.info("分页查询客户配号信息");
		try {
			List<Distribution> dlist = new ArrayList<Distribution>();
			dlist = distributionService.getDistriList(page, rows, userid);
			// int totalnums = distributionService.getAllDistris();
			ResponseResult result = new ResponseResult();
			// result.setTotal(totalnums);
			result.setRows(dlist);
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	/**
	 * 根据商品id查询商品信息
	 */
	@RequestMapping(value = "/commodityInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String commodityInfo(@RequestParam("commodityid") String commodityid) {
		log.info("根据商品id查询商品信息");
		Commodity com = commodityService.getCommodity(commodityid);
		try {
			return JSON.json(com);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

}