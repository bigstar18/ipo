package com.yrdce.ipo.modules.sys.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.modules.sys.service.DataItemService;
import com.yrdce.ipo.modules.sys.vo.DataItem;

/**
 * 公共接口
 * @author wq 2016-1-1
 */
@Controller("/interface")
public class InterfaceManager {
    
	@Autowired
	private DataItemService dataItemService;
	
	
	//查询费用业务
	@RequestMapping(value = "/queryChargeBusinessDateItem")
	@ResponseBody
	public String queryChargeBusinessDateItem()throws Exception { 
		DataItem dataItem = new DataItem(ChargeConstant.BUSINESS);
		List<DataItem> list =dataItemService.queryForList(dataItem);
		return JSON.json(list);
	}
	
	//查询费用角色
	@RequestMapping(value = "/queryChargeRoleDateItem")
	@ResponseBody
	public String queryChargeRoleDateItem()throws Exception { 
		DataItem dataItem = new DataItem(ChargeConstant.ROLE);
		List<DataItem> list =dataItemService.queryForList(dataItem);
		return JSON.json(list);
	}
	
	
	
	
	
	
	
	
	
}