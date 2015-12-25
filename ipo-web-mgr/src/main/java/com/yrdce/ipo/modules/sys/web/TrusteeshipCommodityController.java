package com.yrdce.ipo.modules.sys.web;

import java.math.BigDecimal;
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
import com.yrdce.ipo.modules.sys.service.CommodityService;
import com.yrdce.ipo.modules.sys.service.TrusteeshipCommodityService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
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
	@Autowired
	private CommodityService commodityService;
	
	/**
	 * 查询可申购的托管商品
	 * @param pageNo
	 * @param pageSize
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryPlan")
	@ResponseBody
	public String queryPlan(@RequestParam("page") String pageNo,@RequestParam("rows")String pageSize,
			HttpServletRequest request) 
			throws Exception {
		TrusteeshipCommodity commodity = new TrusteeshipCommodity();
		commodity.setCommodityId(request.getParameter("commodityId"));
		commodity.setCommodityName(request.getParameter("commodityName"));
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
	 * 删除托管计划
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/deletePlan")
	@ResponseBody
	public boolean deletePlan(HttpServletRequest request)  {
			
		TrusteeshipCommodity commodity = new TrusteeshipCommodity();
		commodity.setId(Long.valueOf(request.getParameter("id")));
		commodity.setUpdateUser("999");
		try {
			trusteeshipCommodityService.deletePlan(commodity);
		} catch (Exception e) {
			logger.error("delete error:"+e);
			return false;
		}
		
		return true;
	}
	
	/**
	 * 跳转到添加托管计划界面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addPlan")
	public String  addPlan(HttpServletRequest request,Model model)  {
		List<?> commodityList=commodityService.findAll();
		model.addAttribute("commodityList", commodityList);
		return "app/trusteeship/add_plan";
	}
	
	
	/**
	 * 添加托管计划
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/savePlan")
	@ResponseBody
	public boolean savePlan(HttpServletRequest request,HttpServletResponse response){
		
		TrusteeshipCommodity commodity = new TrusteeshipCommodity();
		commodity.setCommodityId(request.getParameter("commodityId"));
		commodity.setPlan(request.getParameter("plan"));
		commodity.setPurchaseRate(new BigDecimal(request.getParameter("purchaseRate")));
		commodity.setRemark(request.getParameter("remark"));
		commodity.setCreateUser("999");
		try {
			trusteeshipCommodityService.savePlan(commodity);
		} catch (Exception e) {
			logger.error("savePlan error:"+e);
			return false;
		}
		return true;
	}
	
	
	/**
	 * 跳转到修改托管计划界面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/editPlan")
	public String  editPlan(HttpServletRequest request,Model model)  {
		
		List<?> commodityList=commodityService.findAll();
		model.addAttribute("commodityList", commodityList);
		Long id=Long.valueOf(request.getParameter("id"));
		TrusteeshipCommodity entity=trusteeshipCommodityService.findPlanById(id);
		model.addAttribute("entity", entity);
		
		return "app/trusteeship/edit_plan";
	}
	
	
	
    /**
     * 更新托管计划
     * @param request
     * @param response
     * @return
     */
	@RequestMapping(value = "/updatePlan")
	@ResponseBody
	public boolean updatePlan(HttpServletRequest request,HttpServletResponse response){
		
		TrusteeshipCommodity commodity = new TrusteeshipCommodity();
		commodity.setId(Long.valueOf(request.getParameter("id")));
		commodity.setCommodityId(request.getParameter("commodityId"));
		commodity.setPlan(request.getParameter("plan"));
		commodity.setPurchaseRate(new BigDecimal(request.getParameter("purchaseRate")));
		commodity.setRemark(request.getParameter("remark"));
		commodity.setUpdateUser("999");
		try {
			trusteeshipCommodityService.updatePlan(commodity);
		} catch (Exception e) {
			logger.error("updatePlan error:"+e);
			return false;
		}
		return true;
	}
	
	
	
	
}
