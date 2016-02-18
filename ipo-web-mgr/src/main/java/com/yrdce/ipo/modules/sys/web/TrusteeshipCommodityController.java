package com.yrdce.ipo.modules.sys.web;

import gnnt.MEBS.logonService.vo.UserManageVO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.common.constant.PositionConstant;
import com.yrdce.ipo.common.constant.TrusteeshipConstant;
import com.yrdce.ipo.modules.sys.service.BiWarehouseService;
import com.yrdce.ipo.modules.sys.service.IpoCommConfService;
import com.yrdce.ipo.modules.sys.service.PayFlowService;
import com.yrdce.ipo.modules.sys.service.PositionService;
import com.yrdce.ipo.modules.sys.service.TrusteeshipCommodityService;
import com.yrdce.ipo.modules.sys.vo.PayFlow;
import com.yrdce.ipo.modules.sys.vo.PositionFlow;
import com.yrdce.ipo.modules.sys.vo.PositionReduce;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.Trusteeship;
import com.yrdce.ipo.modules.sys.vo.TrusteeshipCommodity;
import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;
import com.yrdce.ipo.throwable.BalanceNotEnoughException;

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
	private IpoCommConfService ipoCommConfService;
	@Autowired
	private BiWarehouseService biWarehouseService;
	@Autowired
	private PayFlowService payFlowService;
	@Autowired
	private PositionService positionService;
	
	/**
	 * 查询可申购的托管计划
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
		long count=trusteeshipCommodityService.queryPlanForCount(commodity);
		List<TrusteeshipCommodity> dataList=new ArrayList<TrusteeshipCommodity>();
		if(count>0){
			dataList=trusteeshipCommodityService.queryPlanForPage(pageNo, pageSize, commodity);
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
		commodity.setUpdateUser(getLoginUserId(request));
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
		// 所有的商品
		VIpoCommConf conf = new VIpoCommConf();
		conf.setDeliveryProp((short)1);
		List<?> commodityList=ipoCommConfService.selectCommodityByExample(conf);
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
		commodity.setListingChargeRate(new BigDecimal(request.getParameter("listingChargeRate")));
		commodity.setRemark(request.getParameter("remark"));
		commodity.setCreateUser(getLoginUserId(request));
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
		//所有的商品
		VIpoCommConf conf = new VIpoCommConf();
		conf.setDeliveryProp((short)1);
		List<?> commodityList=ipoCommConfService.selectCommodityByExample(conf);
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
		commodity.setListingChargeRate(new BigDecimal(request.getParameter("listingChargeRate")));
		commodity.setRemark(request.getParameter("remark"));
		commodity.setUpdateUser(getLoginUserId(request));
		try {
			trusteeshipCommodityService.updatePlan(commodity);
		} catch (Exception e) {
			logger.error("updatePlan error:"+e);
			return false;
		}
		return true;
	}
	
	
	/**
	 * 跳转到申请管理界面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/apply")
	public String apply(HttpServletRequest request,Model model){
		
		model.addAttribute("warehouseList", biWarehouseService.findAllWarehuses());
		model.addAttribute("stateList", TrusteeshipConstant.State.values());
		return "app/trusteeship/apply";
	}
	
	
	/**
	 * 查询商户的申请记录 
	 * @param pageNo
	 * @param pageSize
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryApply")
	@ResponseBody
	public String queryApply(@RequestParam("page") String pageNo,@RequestParam("rows")String pageSize,
			HttpServletRequest request) 
			throws Exception {
		Trusteeship ship = new Trusteeship();
		ship.setCommodityId(request.getParameter("commodityId"));
		ship.setCommodityName(request.getParameter("commodityName"));
		if(request.getParameter("state")!=null){
			ship.setState(Integer.parseInt(request.getParameter("state")));
		};
		if(request.getParameter("states")!=null){
			ship.setStates(request.getParameter("states"));
		};
		if(request.getParameter("warehouseId")!=null){
			ship.setWarehouseId(Long.parseLong(request.getParameter("warehouseId")));
		};
		ship.setBeginCreateDate(request.getParameter("beginCreateDate"));
		ship.setEndCreateDate(request.getParameter("endCreateDate"));
		ship.setBeginAuditingDate(request.getParameter("beginAuditingDate"));
		ship.setEndAuditingDate(request.getParameter("endAuditingDate"));
		ship.setCreateUser(request.getParameter("createUser"));
		long count=trusteeshipCommodityService.queryApplyForCount(ship);
		List<Trusteeship> dataList=new ArrayList<Trusteeship>();
		if(count>0){
			dataList=trusteeshipCommodityService.queryApplyForPage(pageNo, pageSize, ship);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal( new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}
	
	
	
	
	
	/**
	 * 市场审核通过
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/marketAuditPass")
	@ResponseBody
	public String  marketAuditPass(HttpServletRequest request,HttpServletResponse response){
		try {
			Trusteeship ship = new Trusteeship();
			ship.setId(Long.valueOf(request.getParameter("id")));
			ship.setUpdateUser(getLoginUserId(request));
			trusteeshipCommodityService.marketAuditPass(ship);
		}catch (BalanceNotEnoughException be) {
		   return "001";
		}catch (Exception e) {
			logger.error("marketAuditPass error:"+e);
		   return "error";
		}
		return "success";
	}
	
	/**
	 * 市场审核不通过
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/marketAuditNoPass")
	@ResponseBody
	public boolean marketAuditNoPass(HttpServletRequest request,HttpServletResponse response){
		try {
			Trusteeship ship = new Trusteeship();
			ship.setId(Long.valueOf(request.getParameter("id")));
			ship.setUpdateUser(getLoginUserId(request));
			trusteeshipCommodityService.marketAuditNoPass(ship);
		} catch (Exception e) {
			logger.error("marketAuditNoPass error:"+e);
		   return false;
		}
		return true;
	}
	
	
	/**
	 * 跳转到托管转持仓界面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/turnToPosition")
	public String turnToPosition(HttpServletRequest request,Model model){
		
		model.addAttribute("warehouseList", biWarehouseService.findAllWarehuses());
		model.addAttribute("stateList", TrusteeshipConstant.State.values());
		return "app/trusteeship/turn_to_position";
	}
	
	/**
	 * 托管转持仓 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/saveTurnToPosition")
	@ResponseBody
	public boolean saveTurnToPosition(HttpServletRequest request,HttpServletResponse response){
		try {
			Trusteeship ship = new Trusteeship();
			ship.setId(Long.valueOf(request.getParameter("id")));
			ship.setUpdateUser(getLoginUserId(request));
			trusteeshipCommodityService.saveTurnToPosition(ship);
		} catch (Exception e) {
			logger.error("saveTurnToPosition error:"+e);
		   return false;
		}
		return true;
	}
	
	
	/**
	 * 返还货款
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/returnGoods")
	public String returnGoods(HttpServletRequest request,Model model){
		
		model.addAttribute("warehouseList", biWarehouseService.findAllWarehuses());
		model.addAttribute("stateList", TrusteeshipConstant.State.values());
		return "app/trusteeship/return_goods";
	}
	
	/**
	 * 付款
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pay")
	@ResponseBody
	public String pay(HttpServletRequest request)  {
			
		PayFlow payFlow = new PayFlow();
		payFlow.setId(Long.valueOf(request.getParameter("id")));
		payFlow.setUpdateUser(getLoginUserId(request));
		try {
			payFlowService.pay(payFlow);
		} catch (Exception e) {
			logger.error("pay error:"+e);
			return "error";
		}
		return "success";
	}
	
	
	/**
	 * 预减持设置
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/prereduce")
	public String prereduce(HttpServletRequest request,Model model){
		StringBuilder states= new StringBuilder();
		states.append(TrusteeshipConstant.State.INCREASE.getCode());
		states.append(",");
		states.append(TrusteeshipConstant.State.REDUCTION.getCode());
		model.addAttribute("states", states);
		
		model.addAttribute("warehouseList", biWarehouseService.findAllWarehuses());
		return "app/trusteeship/prereduce";
	}
	
	/**
	 * 添加预减持设置
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addPrereduce")
	public String addPrereduce(HttpServletRequest request,Model model){
		Long id = Long.valueOf(request.getParameter("id"));
		Trusteeship entity=trusteeshipCommodityService.findTrusteeshipById(id);
		model.addAttribute("entity", entity);
		return "app/trusteeship/add_prereduce";
	}
	
	/**
	 * 保存预减持设置
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/savePrereduce")
	@ResponseBody
	public String savePrereduce(HttpServletRequest request,Model model){
		try {
			Long id = Long.valueOf(request.getParameter("id"));
			String reduceDate =  request.getParameter("reduceDate");
			String reduceRatio = request.getParameter("reduceRatio");
			Trusteeship param = new Trusteeship();
			param.setId(id);
			param.setReduceDate(DateUtils.parseDate(reduceDate, "yyyy-MM-dd"));
			param.setReduceRatio(new BigDecimal(reduceRatio));
			param.setUpdateUser(getLoginUserId(request));
			trusteeshipCommodityService.savePrereduce(param);
		} catch (Exception e) {
			logger.error("savePrereduce error:"+e);
			return "error";
		}
		return "success";
	}
	
	
	/**
	 * 查询持仓流水
	 * @param pageNo
	 * @param pageSize
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryPositionFlow")
	@ResponseBody
	public String queryPositionFlow(@RequestParam("page") String pageNo,@RequestParam("rows")String pageSize,
			HttpServletRequest request) 
			throws Exception {
		PositionFlow positionFlow = new PositionFlow();
		positionFlow.setBusinessCode(ChargeConstant.BusinessType.TRUSTEESHIP.getCode());
		positionFlow.setState(PositionConstant.FlowState.turn_goods.getCode());
		positionFlow.setCommodityId(request.getParameter("commodityId"));
		positionFlow.setFirmId(request.getParameter("firmId"));
		long count=positionService.queryFlowForCount(positionFlow);
		List<PositionFlow> dataList=new ArrayList<PositionFlow>();
		if(count>0){
			dataList=positionService.queryFlowForPage(pageNo, pageSize, positionFlow);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal( new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}
	
	
	/**
	 * 跳转到减持设置页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/reduce")
	public String reduce(HttpServletRequest request,Model model){
		String positionFlowId=request.getParameter("positionFlowId");
		model.addAttribute("positionFlowId", positionFlowId);
		return "app/trusteeship/reduce";
	}
	
	
	/**
	 * 查询减持仓设置
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryReduce")
	@ResponseBody
	public String queryReduce(HttpServletRequest request) throws Exception {
			
		PositionReduce positionReduce = new PositionReduce();
		positionReduce.setPositionFlowId(Long.valueOf(request.getParameter("positionFlowId")));
		positionReduce.setCommodityId(request.getParameter("commodityId"));
		List<PositionReduce> dataList=new ArrayList<PositionReduce>();
		dataList=positionService.queryReduceForList(positionReduce);
		ResponseResult result = new ResponseResult();
		result.setTotal(dataList.size());
		result.setRows(dataList);
		return JSON.json(result);
	}
	
	
	
	/**
	 * 跳转到 新增减持仓页面
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addReduce")
	public String addReduce(HttpServletRequest request,Model model){
		Long positionFlowId=Long.valueOf(request.getParameter("positionFlowId"));
		PositionFlow flow =positionService.findFlow(positionFlowId);
		model.addAttribute("flow", flow);
		
		return "app/trusteeship/add_reduce";
	}
	
	
	/**
	 * 保存 减持仓设置
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveReduce")
	@ResponseBody
	public String saveReduce(HttpServletRequest request,Model model){
		try {
			Long positionFlowId = Long.valueOf(request.getParameter("positionFlowId"));
			String reduceDate =  request.getParameter("reduceDate");
			BigDecimal ratio = new BigDecimal(request.getParameter("ratio"));
			String reduceqty=request.getParameter("reduceqty");
			//验证输入的减持比例
			PositionReduce positionReduce = new PositionReduce();
			positionReduce.setPositionFlowId(positionFlowId);
			List<PositionReduce> dataList=positionService.queryReduceForList(positionReduce);
			BigDecimal ratioSum=new BigDecimal("0");
			if(dataList!=null&&!dataList.isEmpty()){
				for(PositionReduce item:dataList){
					ratioSum=ratioSum.add(item.getRatio());
				}
			}; 
			if(ratioSum.add(ratio).intValue()>100){
				return "001";
			};
			
			PositionReduce param = new PositionReduce();
			param.setPositionFlowId(positionFlowId);
			param.setReduceDate(DateUtils.parseDate(reduceDate, "yyyy-MM-dd"));
			param.setRatio(ratio);
			param.setReduceqty(Long.valueOf((reduceqty)));
			param.setCreateUser(getLoginUserId(request));
			positionService.savePositionReduce(param);
		} catch (Exception e) {
			logger.error("saveReduce error:"+e);
			return "error";
		}
		return "success";
	}
	
	
    /**
     * 删除减持仓设置
     * @param request
     * @param model
     * @return
     */
	@RequestMapping(value = "/deleteReduce")
	@ResponseBody
	public String deleteReduce(HttpServletRequest request,Model model){
		try {
			Long id = Long.valueOf(request.getParameter("id"));
			PositionReduce param = new PositionReduce();
			param.setId(id);
			param.setUpdateUser(getLoginUserId(request));
			positionService.deletePositionReduce(param);
		} catch (Exception e) {
			logger.error("deleteReduce error:"+e);
			return "error";
		}
		return "success";
	}
	
	
	
	
	private String getLoginUserId(HttpServletRequest request){
		UserManageVO user = (UserManageVO) request.getSession().getAttribute("CurrentUser");
		if(user!=null){
			return user.getUserID();
		}
		return "nologin";
	}
	
 
	
}
