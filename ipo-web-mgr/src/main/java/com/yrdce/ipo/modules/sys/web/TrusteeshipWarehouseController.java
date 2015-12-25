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

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.TrusteeWarehouseService;
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

	/*
	 * 修改托管仓库视图
	 */
	@RequestMapping(value = "/updateTrusteeWarehouse", method = RequestMethod.GET)
	public String CommodityManage(HttpServletRequest request,
			HttpServletResponse response, Model model,
			@RequestParam("commId") String commId) {
		return "app/breed/breed_list";
	}

	/*
	 * 托管仓库列表
	 */
	@RequestMapping(value = "/trusteeWarehouseManage", method = RequestMethod.POST)
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

}
