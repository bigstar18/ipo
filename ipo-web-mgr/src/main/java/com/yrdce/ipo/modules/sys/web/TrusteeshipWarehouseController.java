package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
import com.yrdce.ipo.modules.sys.service.BiWarehouseService;
import com.yrdce.ipo.modules.sys.service.CommodityService;
import com.yrdce.ipo.modules.sys.service.TrusteeWarehouseService;
import com.yrdce.ipo.modules.sys.vo.BiWarehouse;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.TrusteeshipWarehouse;

/**
 * 托管仓库
 * 
 * @author chenjing
 *
 */
@Controller
@RequestMapping("/trusteeshipWarehouseController")
public class TrusteeshipWarehouseController {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(TrusteeshipWarehouseController.class);

	@Autowired
	private TrusteeWarehouseService trusteeshipWarehouseService;

	@Autowired
	private BiWarehouseService biWarehouseService;

	@Autowired
	private CommodityService commodityService;

	/*
	 * 修改或新增托管仓库视图
	 */
	@RequestMapping(value = "/updateTrusteeWarehouse", method = RequestMethod.GET)
	public String CommodityManage(
			HttpServletRequest request,
			HttpServletResponse response,
			Model model,
			@RequestParam(value = "commId", required = false) String commId,
			@RequestParam(value = "commName", required = false) String commName,
			@RequestParam(value = "flag", required = true) String flag) {
		if (flag.equals("create")) {
			log.info("跳转至新增页面");
		}
		if (flag.equals("update")) {
			log.info("跳转至修改页面");
			List<Long> warehouseIds = trusteeshipWarehouseService
					.getTrusteeshipWarehouseByCommId(commId);
			request.setAttribute("commId", commId);
			request.setAttribute("commName", commName);
			request.setAttribute("warehouseList", warehouseIds);
		}
		List<BiWarehouse> allWarehouse = biWarehouseService.findAllWarehuses();
		request.setAttribute("allWarehouse", allWarehouse);
		request.setAttribute("crud", flag);
		return "app/trusteeship/warehouseDetail";
	}

	/*
	 * 删除托管到仓库的商品
	 */
	@RequestMapping(value = "/deleteTrusteeWarehouse", method = RequestMethod.POST)
	@ResponseBody
	public String deleteTrusteeWarehouse(
			@RequestParam(value = "commId") String commId) {
		return trusteeshipWarehouseService.deleteTrusteeWare(commId);
	}

	/*
	 * 托管仓库列表
	 */
	@RequestMapping(value = "/trusteeWarehouseManage", method = RequestMethod.POST)
	@ResponseBody
	public String trusteeWarehouseManage(@RequestParam("page") String page,
			@RequestParam("rows") String rows, TrusteeshipWarehouse example)
			throws IOException {
		try {
			log.info("根据商品查询仓库列表");
			List<TrusteeshipWarehouse> datalist = trusteeshipWarehouseService
					.queryWarehouseByPage(page, rows, example);
			Integer totalNum = trusteeshipWarehouseService
					.CountWarehouseByExample(example);
			ResponseResult result = new ResponseResult();
			result.setRows(datalist);
			result.setTotal(totalNum);
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}

	}

	/*
	 * 托管商品下拉框
	 */
	@RequestMapping(value = "/trusteeCommodity", method = RequestMethod.POST)
	@ResponseBody
	public String trusteeCommodity() throws IOException {
		List<Commodity> commList = commodityService.findAll();
		return JSON.json(commList);
	}

	/**
	 * 查询已配置仓库的商品ID
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findExsitIds", method = RequestMethod.GET)
	@ResponseBody
	public String findExsitIds(@RequestParam("commId") String commId)
			throws IOException {
		log.info("查询已配置仓库的商品ID");
		try {
			List<String> ExsitIds = trusteeshipWarehouseService.findExsitIds();
			for (int i = 0; i < ExsitIds.size(); i++) {
				if (commId.equals(ExsitIds.get(i))) {
					return "0";// 该商品ID已存在
				}
			}
			return "1";// 新增的托管商品Id
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
	}

	/**
	 * 新增托管仓库的商品
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addTrusteeWarehouse", method = RequestMethod.POST)
	@ResponseBody
	public String addTrusteeWarehouse(
			@RequestParam("commodityId") String commId,
			@RequestParam("warehouse") String warehouse) throws IOException {
		log.info("新增托管仓库的商品");
		return trusteeshipWarehouseService.addTrusteeWare(commId, warehouse);

	}

	/**
	 * 修改托管仓库的商品
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateTrusteeWarehouse", method = RequestMethod.POST)
	@ResponseBody
	public String updateTrusteeWarehouse(
			@RequestParam("commodityId") String commId,
			@RequestParam("warehouse") String warehouse) throws IOException {
		log.info("修改托管仓库的商品");
		return trusteeshipWarehouseService.updateTrusteeWare(commId, warehouse);
	}

	public static void main(String[] args) {
		String name = "";
		try {
			name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}
