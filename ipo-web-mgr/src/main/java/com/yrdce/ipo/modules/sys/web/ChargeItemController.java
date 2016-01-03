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
import com.yrdce.ipo.modules.sys.service.ChargeItemService;
import com.yrdce.ipo.modules.sys.vo.ChargeItem;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
/**
 * 费用项 Controller
 * @author wq 2016-1-1
 */
@Controller
@RequestMapping("/chargeItemController")
public class ChargeItemController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
    @Autowired
	private ChargeItemService chargeItemService;
	
    
    /**
     * 查询顶级费用项
     * @param pageNo
     * @param pageSize
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/queryTopLevel")
	@ResponseBody
	public String queryTopLevel(@RequestParam("page") String pageNo,@RequestParam("rows")String pageSize,
			HttpServletRequest request) 
			throws Exception {
		ChargeItem chargeItem = new ChargeItem();
		chargeItem.setParentId(ChargeItem.TOP_LEVEL_ID);
		chargeItem.setName(request.getParameter("name"));
		long count=chargeItemService.querySubLevelForCount(chargeItem);
		List<ChargeItem> dataList=new ArrayList<ChargeItem>();
		if(count>0){
			dataList=chargeItemService.querySubLevelForPage(pageNo, pageSize, chargeItem);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal( new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}
	
	
	/**
	 * 查询子级费用项
	 * @param pageNo
	 * @param pageSize
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/querySubLevel")
	@ResponseBody
	public String querySubLevel(@RequestParam("page") String pageNo,@RequestParam("rows")String pageSize,
			HttpServletRequest request) 
			throws Exception {
		ChargeItem chargeItem = new ChargeItem();
		chargeItem.setParentId(request.getParameter("parentId"));
		chargeItem.setName(request.getParameter("name"));
		long count=chargeItemService.querySubLevelForCount(chargeItem);
		List<ChargeItem> dataList=new ArrayList<ChargeItem>();
		if(count>0){
			dataList=chargeItemService.querySubLevelForPage(pageNo, pageSize, chargeItem);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal( new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}
	
	
	/**
	 * 跳转到添加费用页面
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request,Model model)throws Exception {
		
		ChargeItem chargeItem = new ChargeItem();
		chargeItem.setParentId(ChargeItem.TOP_LEVEL_ID);
		List<ChargeItem> dataList=chargeItemService.queryForList(chargeItem);
		//一级费用
		model.addAttribute("chargeList", dataList);
		//费用类型
		model.addAttribute("typeList", ChargeConstant.Type.values());
		return "app/chargeitem/add";
	}
	
	/**
	 * 添加费用
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public boolean save(HttpServletRequest request,ChargeItem chargeItem) 
			throws Exception {
		try {
			chargeItem.setCreateUser(getloginUserId(request));
			chargeItemService.save(chargeItem);
		} catch (Exception e) {
			logger.error("save error:"+e);
			return false;
		}
		return true;
	}
	
	
	/**
	 * 跳转到修改费用页面
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request,Model model) throws Exception {
	 
		ChargeItem chargeItem = new ChargeItem();
		chargeItem.setParentId(ChargeItem.TOP_LEVEL_ID);
		List<ChargeItem> dataList=chargeItemService.queryForList(chargeItem);
		ChargeItem entity=chargeItemService.findById(request.getParameter("id"));
		model.addAttribute("entity", entity);
		//一级费用
		model.addAttribute("chargeList", dataList);
		//费用类型
		model.addAttribute("typeList", ChargeConstant.Type.values());
		
		return "app/chargeitem/edit";
	}
	
	
	/**
	 *  费用
	 * @param request
	 * @param chargeItem
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public boolean update(HttpServletRequest request,ChargeItem chargeItem) 
			throws Exception {
		try {
			chargeItem.setUpdateUser(getloginUserId(request));
			chargeItemService.update(chargeItem);
		} catch (Exception e) {
			logger.error("update error:"+e);
			return false;
		}
		return true;
	}
	
	/**
	 * 删除费用项 
	 * @param request
	 * @param chargeItem
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete")
	@ResponseBody
	public String delete(HttpServletRequest request,ChargeItem chargeItem) 
			throws Exception {
		String messageCode="001";
		try {
			ChargeItem subChargeItem =new ChargeItem();
			subChargeItem.setParentId(chargeItem.getId());
			long count=chargeItemService.querySubLevelForCount(subChargeItem);
			if(count==0){
				chargeItem.setUpdateUser(getloginUserId(request));
				chargeItemService.delete(chargeItem);
			}else{
				messageCode="002";
			}
		} catch (Exception e) {
			logger.error("delete error:"+e);
			messageCode="003";
		}
		return messageCode;
	}
	
	
	private String getloginUserId(HttpServletRequest request){
		UserManageVO user = (UserManageVO) request.getSession().getAttribute("CurrentUser");
		if(user!=null){
			return user.getUserID();
		}
		return "nologin";
	}
	
}
