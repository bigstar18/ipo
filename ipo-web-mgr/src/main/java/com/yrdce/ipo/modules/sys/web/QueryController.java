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
import com.yrdce.ipo.modules.sys.service.DistributionService;
import com.yrdce.ipo.modules.sys.service.OrderService;
import com.yrdce.ipo.modules.sys.vo.Distribution;
import com.yrdce.ipo.modules.sys.vo.Order;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

@Controller
@RequestMapping("QueryController")
public class QueryController {

	static Logger logger = Logger.getLogger(QueryController.class);

	@Autowired
	private OrderService orderService;

	@Autowired
	private DistributionService distributionService;

	/**
	 * 订单查询
	 */

	@RequestMapping(value = "/getAllOrder", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getOrder(@RequestParam("page") String page, @RequestParam("rows") String rows) throws IOException {
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
	 * 分页摇号查询
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findRockNums", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String findRockNums(@RequestParam("page") String page, @RequestParam("rows") String rows) throws IOException {
		logger.info("分页查询客户配号信息");
		try {
			List<Distribution> dlist = new ArrayList<Distribution>();
			dlist = distributionService.getDistriAllList(page, rows);
			int totalnums = distributionService.getAllDistribution();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(dlist);
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

}
