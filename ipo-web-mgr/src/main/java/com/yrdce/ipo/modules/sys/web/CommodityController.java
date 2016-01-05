package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
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
public class CommodityController {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(CommodityController.class);

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
	 * 数据查询（商品查询）
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findComms", method = RequestMethod.POST)
	@ResponseBody
	public String findCommsx(@RequestParam("page") String page, @RequestParam("rows") String rows) throws IOException {
		log.info("分页查询发售商品信息");
		try {
			List<Commodity> clist = commodityService.findCommList(page, rows);
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
	 * 发售商品查询（模糊查询）
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/QueryByConditions", method = RequestMethod.POST)
	@ResponseBody
	public String QueryByConditions(@RequestParam("page") String page, @RequestParam("rows") String rows,
			@RequestParam(value = "status", required = false) String status, @RequestParam("commodityname") String commodityname,
			@RequestParam("commodityid") String commodityid, @RequestParam(value = "starttime", required = false) String starttime,
			@RequestParam(value = "endtime", required = false) String endtime) throws IOException {
		log.info("条件查询发售商品信息");
		try {
			Commodity comm = new Commodity();
			if (!commodityid.equals("")) {
				comm.setCommodityid(commodityid);
			}
			if (!commodityname.equals("")) {
				comm.setCommodityname("%" + commodityname + "%");
			}
			if (!status.equals("")) {
				comm.setStatus(Integer.parseInt(status));
			}
			if (!starttime.equals("")) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(starttime);
				comm.setStarttime(date);
			}
			if (!endtime.equals("")) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(endtime);
				comm.setEndtime(date);
			}
			List<Commodity> clist = commodityService.queryByConditions(page, rows, comm);
			int totalnums = commodityService.countByConditions(comm).intValue();
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
			List<Distribution> dlist = distributionService.getDistriList(page, rows, userid, null);
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
