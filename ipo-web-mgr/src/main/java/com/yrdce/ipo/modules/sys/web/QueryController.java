package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.CommodityService;
import com.yrdce.ipo.modules.sys.service.DistributionService;
import com.yrdce.ipo.modules.sys.service.OrderService;
import com.yrdce.ipo.modules.sys.service.TaskService;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.Order;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

@Controller
@RequestMapping("QueryController")
public class QueryController {

	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(QueryController.class);

	@Autowired
	private OrderService orderService;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private DistributionService distributionService;
	@Autowired
	private TaskService taskService;

	/*
	 * 发行摇号视图
	 */
	@RequestMapping(value = "/IssuedManage", method = RequestMethod.GET)
	public String IssuedManage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/pubManager/issued";
	}

	/*
	 * 申购成交视图
	 */
	@RequestMapping(value = "/ApplySuccManage", method = RequestMethod.GET)
	public String ApplySuccManage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/pubManager/order_query";
	}

	/**
	 * 订单查询(申购记录)
	 */

	@RequestMapping(value = "/getAllOrder", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAllOrder(@RequestParam("page") String page, @RequestParam("rows") String rows,
			@RequestParam(value = "userid", required = false) String userid) throws IOException {
		logger.info("查询订单信息");
		try {
			List<Order> clist;
			int totalnums;
			if (userid == null) {
				clist = orderService.getOrder(page, rows);
				totalnums = orderService.getAllOrder();
			} else {
				clist = orderService.getOrderInfo(page, rows, userid);
				totalnums = orderService.getAll(userid);
			}
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
	 * 通过用户ID查询订单(申购记录)<暂不用>
	 */

	@RequestMapping(value = "/getOrderByUserid", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getOrderByUserid(@RequestParam("page") String page, @RequestParam("rows") String rows, @RequestParam("userid") String userid)
			throws IOException {
		logger.info("根据用户ID查询订单信息");
		try {
			List<Order> clist = orderService.getOrderInfo(page, rows, userid);
			int totalnums = orderService.getAll(userid);
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
	public String findRockNums(@RequestParam("page") String page, @RequestParam("rows") String rows,
			@RequestParam(value = "commodityid", required = false) String commodityid) throws IOException {
		logger.info("分页查询发售商品信息");
		try {
			List<Commodity> clist;
			int totalnums;
			if (commodityid == null) {
				clist = commodityService.getList(page, rows);
				totalnums = commodityService.getCounts();
			} else {
				clist = commodityService.getCommodityByPage(page, rows, commodityid);
				totalnums = commodityService.getCountsByPage(commodityid);
			}
			logger.info(totalnums + "");
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
	 * 根据商品id分页查询商品信息(发行摇号)(暂不用)
	 */
	@RequestMapping(value = "/commodityInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String commodityInfo(@RequestParam("page") String page, @RequestParam("rows") String rows,
			@RequestParam(value = "commodityid", required = false) String commodityid) {
		logger.info("根据商品id查询商品信息");
		try {
			if (commodityid == null) {
				commodityid = "";
			}
			List<Commodity> clist = commodityService.getCommodityByPage(page, rows, commodityid);
			logger.info(clist.toString());
			int totalnums = commodityService.getCountsByPage(commodityid);
			logger.info("totalnums:" + totalnums);
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
	 * 手动摇号功能
	 */
	@RequestMapping(value = "/rock")
	@ResponseBody
	public boolean rock(@RequestParam(value = "commodityid",required = true)String commodityid) {
		try {
			taskService.lottery(commodityid);
		} catch (Exception e) {
			logger.error("rock error:", e);
			return false;
		}
		return true;
	}

	
	/**
	 * 手动配号功能
	 */
	@RequestMapping(value = "/distribution")
	@ResponseBody
	public boolean distribution(@RequestParam(value = "commodityid",required = true)String commodityid) {
		try {
			taskService.distribution(commodityid);
		} catch (Exception e) {
			logger.error("distribution error:", e);
			return false;
		}
		return true;
	}
	
	
}
