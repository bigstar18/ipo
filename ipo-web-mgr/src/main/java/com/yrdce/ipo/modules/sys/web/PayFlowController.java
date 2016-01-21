package com.yrdce.ipo.modules.sys.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.PayFlowService;
import com.yrdce.ipo.modules.sys.vo.PayFlow;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
/**
 * 付款流水Controller
 * @author wq 2016-1-21
 *
 */
@Controller
@RequestMapping("/payFlowController")
public class PayFlowController {

	@Autowired
	private PayFlowService payFlowService;
	
	
	/**
	 * 查询发行的货款记录
	 * @param pageNo
	 * @param pageSize
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryPublishGoods")
	@ResponseBody
	public String queryPublishGoods(@RequestParam("page") String pageNo,@RequestParam("rows")String pageSize,
			HttpServletRequest request) throws Exception {
		
		PayFlow payFlow = new PayFlow();
		payFlow.setPayee(request.getParameter("payee"));
		payFlow.setCommodityId(request.getParameter("commodityId"));
		long count=payFlowService.queryPublishGoodsForCount(payFlow);
		List<PayFlow> dataList=new ArrayList<PayFlow>();
		if(count>0){
			dataList=payFlowService.queryPublishGoodsForPage(pageNo, pageSize, payFlow);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal( new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}
	
	
	
	
	
	
	
	
	
	
	
}
