package com.yrdce.ipo.modules.sys.web;

import gnnt.MEBS.logonService.vo.UserManageVO;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.yrdce.ipo.modules.sys.service.DebitFlowService;
import com.yrdce.ipo.modules.sys.vo.DebitFlow;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

/**
 * 扣款流水
 * @author wq 2016-1-26
 *
 */
@Controller
@RequestMapping("/debitFlowController")
public class DebitFlowController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private  DebitFlowService debitFlowService;
	
	
	
	
	/**
	 * 首页
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/index")
	public String index(HttpServletRequest request,Model model)throws Exception {
		
		model.addAttribute("businessTypeList", ChargeConstant.BusinessType.values());
		model.addAttribute("chargeTypeList", ChargeConstant.ChargeType.values());
		model.addAttribute("debitStateList", ChargeConstant.DebitState.values());
		model.addAttribute("debitChannelList", ChargeConstant.DebitChannel.values());
		model.addAttribute("debitModeList", ChargeConstant.DebitMode.values());
		
		return "app/debitflow/index";
	}
	
	
	
	/**
	 * 查询扣款
	 * @param pageNo
	 * @param pageSize
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query")
	@ResponseBody
	public String query(@RequestParam("page") String pageNo,@RequestParam("rows")String pageSize,
			HttpServletRequest request) 
			throws Exception {
		
		DebitFlow debitFlow = new DebitFlow();
		debitFlow.setCommodityId(request.getParameter("commodityId"));
		debitFlow.setPayer(request.getParameter("payer"));
		
		debitFlow.setBusinessType(request.getParameter("businessType"));
		debitFlow.setChargeType(request.getParameter("chargeType"));
		String debitModeVal=request.getParameter("debitMode");
		if(debitModeVal!=null&&debitModeVal.length()>0){
			debitFlow.setDebitMode(Integer.parseInt(debitModeVal));
		};
		long count=debitFlowService.queryForCount(debitFlow);
		List<DebitFlow> dataList=new ArrayList<DebitFlow>();
		if(count>0){
			dataList=debitFlowService.queryForPage(pageNo, pageSize, debitFlow);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal( new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}
	
	
	
	/**
	 * 转向新增页面
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request,Model model)throws Exception {
		
		model.addAttribute("businessTypeList", ChargeConstant.BusinessType.values());
		model.addAttribute("chargeTypeList", ChargeConstant.ChargeType.values());
		model.addAttribute("debitStateList", ChargeConstant.DebitState.values());
		model.addAttribute("debitChannelList", ChargeConstant.DebitChannel.values());
		model.addAttribute("debitModeList", ChargeConstant.DebitMode.values());
		
		return "app/debitflow/add";
	}
	
	
	
	/**
	 * 添加费用
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(HttpServletRequest request,DebitFlow debitFlow) 
			throws Exception {
		try {
			debitFlow.setCreateUser(getloginUserId(request));
			debitFlowService.saveOffline(debitFlow);
		} catch (Exception e) {
			logger.error("save error:"+e);
			return "error";
		}
		return "success";
	}
	
	
	
	
	private String getloginUserId(HttpServletRequest request){
		UserManageVO user = (UserManageVO) request.getSession().getAttribute("CurrentUser");
		if(user!=null){
			return user.getUserID();
		}
		return "nologin";
	}
	
	
	
	
	
	
}
