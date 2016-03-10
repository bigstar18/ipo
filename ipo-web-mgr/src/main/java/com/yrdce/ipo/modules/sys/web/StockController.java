package com.yrdce.ipo.modules.sys.web;


import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.yrdce.ipo.modules.sys.service.CustomerHoldSumService;
import com.yrdce.ipo.modules.sys.service.StockFreezeService;
import com.yrdce.ipo.modules.sys.service.StockTransferrecordsService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.StockFreeze;
import com.yrdce.ipo.modules.sys.vo.StockTransferrecords;

import gnnt.MEBS.logonService.vo.UserManageVO;

@Controller
@RequestMapping("StockController")
public class StockController {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(StockController.class);

	@Autowired
	private StockTransferrecordsService stockTransferrecordsService;
	@Autowired
	private StockFreezeService stockFreezeService;
	@Autowired
	@Qualifier("customerHoldSumService")
	private CustomerHoldSumService customerHoldSumService;
//	@Autowired
//	 Integer getTotalNum(StockTransferrecords storage) {
//		return null;
//	}
	/**
	 * 过户记录列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/transferRecordList", method = RequestMethod.POST)
	@ResponseBody
	public String transferRecordList(
			@RequestParam("page") String page,
			@RequestParam("rows") String rows,
			StockTransferrecords example)
			throws IOException {
		log.info("查询过户记录列表"+example.toString());
		log.debug(example.toString());
		try {
			
//			StockTransferrecords example = new StockTransferrecords();
			List<StockTransferrecords> tlist = stockTransferrecordsService
					.findTransferRecord(page, rows, example);
			Integer totalnums = stockTransferrecordsService.getNums(example);
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			log.debug(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	/**
	 * 冻结记录列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/freezeRecordList", method = RequestMethod.POST)
	@ResponseBody
	public String freezeRecordList(
			@RequestParam("page") String page,
			@RequestParam("rows") String rows,
			StockFreeze example)
			throws IOException {
		log.info("查询过户记录列表"+example.toString());
		log.debug(example.toString());
		try {
//			StockTransferrecords example = new StockTransferrecords();
			List<StockFreeze> tlist = stockFreezeService
					.freezeRecord(page, rows, example);
			Integer totalnums = stockFreezeService.getNums(example);
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			log.debug(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
/**
 * 跳转到添加过户界面
 * @param request
 * @param model
 * @return
 */
@RequestMapping(value = "/addTransfer")
public String  addTransfer()  {

	return "app/stockManagement/add_stockTranster";
}
/**
 * 跳转到添加冻结
 * @param request
 * @param model
 * @return
 */
@RequestMapping(value = "/addFreeze")
public String  addFreeze()  {

	return "app/stockManagement/add_stockFreeze";
}



////跳转审核页面
@RequestMapping(value = "/openTransfer")
public String openTransfer(HttpServletRequest request,Model model)
				throws Exception {
	
	Long applicationId = Long.parseLong(request.getParameter("applicationId"));
	StockTransferrecords stockTransferrecords=stockTransferrecordsService.findById(applicationId);
	model.addAttribute("entity",stockTransferrecords );
	//角色
//	
	return "app/stockManagement/operationTransfer";
}

/**
 * 增加过户
 * 
 * @param
 * @return
 * @throws IOException
 */
@RequestMapping(value = "/addNewTransfer", method = RequestMethod.POST)
@ResponseBody
public String addNewTransfer(StockTransferrecords example, HttpSession session)
		throws IOException {
	log.info("增加过户");
	try {
		log.debug(example.toString());	
		Long quatity = Long.parseLong(example.getTransferNumber().toString());
		String firmid = example.getCustomeridApply() + "00";
		String firmid1 = example.getCustomeridApply().toString();
		String firmid2 = example.getCustomeridAccept().toString();
		String commid = (String) example.getCommodityid();
		Short bsFlag = 1;
		//验证商品
		if(!stockTransferrecordsService.checkcommid(commid))
		{
			return "nocommid";
		}
		//验证客户
		if(!stockTransferrecordsService.checkfirmid(firmid1))
		{
			return "nofirmid";
		}
		if(!stockTransferrecordsService.checkfirmid(firmid2))
		{
			return "nofirmid2";
		}
		//验证客户持仓
		if(stockTransferrecordsService.checkCommQuatity(quatity,firmid,commid)==false)
		{
			return "noquatity";
		}
		// 更新持仓量
		customerHoldSumService.myfreezeCustomerHold(quatity, firmid, commid, bsFlag);
		//增加记录
		int num = stockTransferrecordsService.insertTransfer(example);
		if (num == 1) {
			return "true";
		}
		return "false";
	} catch (Exception e) {
		e.printStackTrace();
		return "error";
	}
}

/**
 * 增加冻结
 * 
 * @param
 * @return
 * @throws IOException
 */
@RequestMapping(value = "/addNewFreeze", method = RequestMethod.POST)
@ResponseBody
public String addNewFreeze(StockFreeze example, HttpSession session)
		throws IOException {
	log.info("增加过户");
	try {
		log.debug(example.toString());	
		Long quatity = Long.parseLong(example.getFreezeNumber().toString());
		String firmid = example.getCustomerid() + "00";
		String firmid1 = example.getCustomerid().toString();	
		String commid = (String) example.getCommodityid();
		//String reason = example.getFreezereason();
		Short bsFlag = 1;
		//验证商品
		if(!stockTransferrecordsService.checkcommid(commid))
		{
			return "nocommid";
		}
		//验证客户
		if(!stockTransferrecordsService.checkfirmid(firmid1))
		{
			return "nofirmid";
		}
		//验证客户持仓
		if(stockTransferrecordsService.checkCommQuatity(quatity,firmid,commid)==false)
		{
			return "noquatity";
		}
		// 更新持仓量
		customerHoldSumService.myfreezeCustomerHold(quatity, firmid, commid, bsFlag);
		//增加记录
		int num = stockFreezeService.insertFreeze(example);
		if (num == 1) {
			return "true";
		}
		return "false";
	} catch (Exception e) {
		e.printStackTrace();
		return "error";
	}
}

/**
 * 删除
 * 
 * @param
 * @return
 * @throws IOException
 */
@RequestMapping(value = "/deleteInfo", method = RequestMethod.POST)
@ResponseBody
public String deleteInfo(@RequestParam("applicationIds") String applicationIds)
		throws IOException {
	log.info("批量删除过户信息:" + applicationIds);
	String[] Ids = applicationIds.split(",");	
	for (int i = 0; i < Ids.length; i++) {
		StockTransferrecords example =	stockTransferrecordsService.findById(Long.parseLong(Ids[i]));
//		log.info("测试:" + example.getTransferNumber().longValue()+example.getCustomeridApply() + "00"+example.getCommodityid().toString());
		if(example.getState()==0){
			customerHoldSumService.unfreezeCustomerHold(example.getTransferNumber().longValue(),example.getCustomeridApply() + "00",example.getCommodityid().toString(), (short) 1);
		}
	}
	return stockTransferrecordsService.deleteInfo(applicationIds);
}


/**
 * 解冻
 * 
 * @param
 * @return
 * @throws IOException
 */
@RequestMapping(value = "/unfreezeInfo", method = RequestMethod.POST)
@ResponseBody
public String unfreezeInfo(@RequestParam("applicationIds") String applicationIds)
		throws IOException {
	log.info("批量解冻信息:" + applicationIds);
	String[] Ids = applicationIds.split(",");	
	for (int i = 0; i < Ids.length; i++) {
		StockFreeze example =	stockFreezeService.findById(Long.parseLong(Ids[i]));
//		log.info("测试:" + example.getTransferNumber().longValue()+example.getCustomeridApply() + "00"+example.getCommodityid().toString());
		
		if(example.getState()==0){
			customerHoldSumService.unfreezeCustomerHold(example.getFreezeNumber().longValue(),example.getCustomerid() + "00",example.getCommodityid().toString(), (short) 1);
			stockFreezeService.update(example);
			return "true";
					
		}
		
	}
	return "false";
	
}

/**
 * 分页返回过户表
 * 
 * @param
 * @return
 * @throws IOException
 */
@RequestMapping(value = "/findAllRecord", method = RequestMethod.POST)
@ResponseBody
public String findAllStorages(@RequestParam("page") String page,
		@RequestParam("rows") String rows, StockTransferrecords storage)
		throws IOException {
	log.info("分页查询入库单");
	log.debug(storage.toString());
	try {
		List<StockTransferrecords> tlist = stockTransferrecordsService.selectByPage(
				page, rows, storage);
		int totalnums = stockTransferrecordsService.getTotalNum(storage);
		ResponseResult result = new ResponseResult();
		result.setTotal(totalnums);
		result.setRows(tlist);
		log.debug(JSON.json(result));
		return JSON.json(result);
	} catch (Exception e) {
		e.printStackTrace();
		return "error";
	}
}


//审核
@RequestMapping(value = "/update", method = RequestMethod.POST)
@ResponseBody
public String update(HttpServletRequest request,StockTransferrecords stockTransferrecords) 
		throws IOException {
	try {
		stockTransferrecords.setOperator(getloginUserId(request));
		StockTransferrecords example =	stockTransferrecordsService.findById(Long.parseLong(stockTransferrecords.getApplicationId().toString()));
//		log.info("测试:" + example.getTransferNumber().longValue()+example.getCustomeridApply() + "00"+example.getCommodityid().toString());	
		customerHoldSumService.unfreezeCustomerHold(example.getTransferNumber().longValue(),example.getCustomeridApply() + "00",example.getCommodityid().toString(), (short) 1);
		if(example.getState()==1)
		{
			customerHoldSumService.reduceCustomerHold(example.getTransferNumber().longValue(),example.getCustomeridApply() + "00",example.getCommodityid().toString(), (short) 1);
			customerHoldSumService.increaseCustomerHold(example.getTransferNumber().longValue(),example.getCustomeridAccept() + "00",example.getCommodityid().toString(), (short) 1);
		}
		stockTransferrecordsService.update(stockTransferrecords);
		return "true";
	} catch (Exception e) {
		logger.error("update error:"+e);
		return "false";
	}
	
}

private String getloginUserId(HttpServletRequest request){
	UserManageVO user = (UserManageVO) request.getSession().getAttribute("CurrentUser");
	if(user!=null){
		return user.getUserID();
	}
	return "nologin";

}

}