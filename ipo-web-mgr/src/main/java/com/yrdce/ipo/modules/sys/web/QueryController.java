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
import com.yrdce.ipo.modules.sys.service.CommodityService;
import com.yrdce.ipo.modules.sys.service.DistributionService;
import com.yrdce.ipo.modules.sys.service.OrderService;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.Order;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

@Controller
@RequestMapping("QueryController")
public class QueryController {

	static Logger logger = Logger.getLogger(QueryController.class);

	@Autowired
	private OrderService orderService;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private DistributionService distributionService;

	/**
	 * 订单查询
	 */

	@RequestMapping(value = "/getAllOrder", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAllOrder(@RequestParam("page") String page, @RequestParam("rows") String rows) throws IOException {
		logger.info("查询订单信息");
		try {
			List<Order> clist = new ArrayList<Order>();
			clist = orderService.getOrder(page, rows);
			int totalnums = orderService.getAllOrder();
			ResponseResult result = new ResponseResult();
			result.setRows(clist);
			result.setTotal(totalnums);
			System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * mgr发行摇号服务
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findRockNums", method = RequestMethod.GET)
	@ResponseBody
	public String findRockNums(@RequestParam("page") String page, @RequestParam("rows") String rows) throws IOException {
		logger.info("分页查询发售商品信息");
		try {
			List<Commodity> clist = new ArrayList<Commodity>();
			clist = commodityService.getList(page, rows);
			logger.info(clist);
			int totalnums = commodityService.getCounts();
			logger.info(totalnums);
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
	 * 根据商品id查询商品信息
	 */
	@RequestMapping(value = "/commodityInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String commodityInfo(@RequestParam("commodityid") String commodityid) {
		logger.info("根据商品id查询商品信息");
		Commodity com = commodityService.getCommodity(commodityid);
		try {
			return JSON.json(com);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 手动摇号功能
	 */
	@RequestMapping(value = "/rock", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String rock(String commondityid) {

		return 1 + "";
		// return "";
	}

}
