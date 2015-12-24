package com.yrdce.ipo.modules.sys.web;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.constant.TrusteeshipConstant;
import com.yrdce.ipo.modules.sys.service.TrusteeshipCommodityService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.Trusteeship;
import com.yrdce.ipo.modules.sys.vo.TrusteeshipCommodity;
/**
 * 托管商品
 * @author wq
 *
 */
@Controller
@RequestMapping("/trusteeshipCommodityController")
public class TrusteeshipCommodityController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private TrusteeshipCommodityService trusteeshipCommodityService;
	
	
	/**
	 * 查询可申购的托管商品
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryApply")
	@ResponseBody
	public String queryApply(@RequestParam("page") String pageNo,@RequestParam("rows")String pageSize,
			HttpServletRequest request) 
			throws Exception {
		TrusteeshipCommodity commodity = new TrusteeshipCommodity();
		commodity.setCommodityId(request.getParameter("commodityId"));
		long count=trusteeshipCommodityService.queryApplyForCount(commodity);
		List<TrusteeshipCommodity> dataList=null;
		if(count>0){
			dataList=trusteeshipCommodityService.queryApplyForPage(pageNo, pageSize, commodity);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal( new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}
	
	
	
	
	/**
	 * 新增商户申购的托管商品
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/saveApply")
	@ResponseBody
	public boolean saveApply( HttpServletRequest request,HttpServletResponse response) {
			
		Trusteeship trusteeship = new Trusteeship();
		trusteeship.setApplyAmount(Long.valueOf(request.getParameter("applyAmount")));
		trusteeship.setCommodityId(request.getParameter("commodityId"));
		trusteeship.setTrusteeshipCommodityId(Long.valueOf(request.getParameter("trusteeshipCommodityId")));
		trusteeship.setPrice(new BigDecimal(request.getParameter("price")));
		trusteeship.setCreateUser("999");
		try {
			trusteeshipCommodityService.saveApply(trusteeship);
		} catch (Exception e) {
			logger.error("saveApply error:"+e);
		   return false;
		}
		return true;
	}
	
	
	
	@RequestMapping(value = "/myApply")
	public String myApply(HttpServletRequest request,Model model){
		model.addAttribute("stateList", TrusteeshipConstant.State.values());
		return "app/trusteeship/my_apply";
	}
	
	
	/**
	 * 查询商户提交的申请
	 * @param pageNo
	 * @param pageSize
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryMyApply")
	@ResponseBody
	public String queryMyApply(@RequestParam("page") String pageNo,@RequestParam("rows")String pageSize,
			HttpServletRequest request) 
			throws Exception {
		Trusteeship ship = new Trusteeship();
		ship.setCommodityId(request.getParameter("commodityId"));
		ship.setCommodityName(request.getParameter("commodityName"));
		if(request.getParameter("state")!=null){
			ship.setState(Integer.parseInt(request.getParameter("state")));
		}
		if(request.getParameter("warehouseId")!=null){
			ship.setWarehouseId(Long.parseLong(request.getParameter("warehouseId")));
		}
		ship.setBeginCreateDate(request.getParameter("beginCreateDate"));
		ship.setEndCreateDate(request.getParameter("endCreateDate"));
		ship.setBeginAuditingDate(request.getParameter("beginAuditingDate"));
		ship.setEndAuditingDate(request.getParameter("endAuditingDate"));
		long count=trusteeshipCommodityService.queryMyApplyForCount(ship);
		List<Trusteeship> dataList=new ArrayList<Trusteeship>();
		if(count>0){
			dataList=trusteeshipCommodityService.queryMyApplyForPage(pageNo, pageSize, ship);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal( new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}
	
	
	/**
	 * 撤销操作
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/cancelMyApply")
	@ResponseBody
	public boolean cancelMyApply(HttpServletRequest request,HttpServletResponse response){
		try {
			Trusteeship ship = new Trusteeship();
			ship.setId(Long.valueOf(request.getParameter("id")));
			ship.setUpdateUser("999");
			trusteeshipCommodityService.cancelMyApply(ship);
		} catch (Exception e) {
			logger.error("cancelMyApply error:"+e);
		   return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
}
