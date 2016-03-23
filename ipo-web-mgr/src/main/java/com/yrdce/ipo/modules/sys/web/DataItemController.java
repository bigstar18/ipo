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
import com.yrdce.ipo.modules.sys.service.DataItemService;
import com.yrdce.ipo.modules.sys.util.WriteLog;
import com.yrdce.ipo.modules.sys.vo.DataItem;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

@Controller
@RequestMapping("/dataItemController")
public class DataItemController {

	Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	DataItemService dataItemService;

	/**
	 * 查询
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/query")
	@ResponseBody
	public String query(@RequestParam("page") String pageNo,
			@RequestParam("rows") String pageSize, HttpServletRequest request)
			throws Exception {
		DataItem dataItem = new DataItem();

		long count = dataItemService.queryForCount(dataItem);
		List<DataItem> dataList = new ArrayList<DataItem>();
		if (count > 0) {
			dataList = dataItemService.queryForPage(pageNo, pageSize, dataItem);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal(new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}

	/**
	 * 转向新增界面
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add")
	public String add(HttpServletRequest request, Model model) throws Exception {

		return "app/dataitem/add";
	}

	/**
	 * 新增
	 * 
	 * @param request
	 * @param dataItem
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save")
	@ResponseBody
	public String save(HttpServletRequest request, DataItem dataItem)
			throws Exception {
		try {

			DataItem dbDataItem = dataItemService.findByPrimaryKey(dataItem);
			if (dbDataItem != null) {
				return "001";
			}
			dataItemService.save(dataItem);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DATAITEM_CATALOGID,
					"IPO添加数据项成功", WriteLog.SYS_LOG_OPE_SUCC, "",
					request.getSession());
		} catch (Exception e) {
			logger.error("save error:" + e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DATAITEM_CATALOGID,
					"IPO添加数据项失败", WriteLog.SYS_LOG_OPE_FAILURE, "",
					request.getSession());
			return "error";
		}
		return "success";
	}

	/**
	 * 转向修改界面
	 * 
	 * @param request
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit")
	public String edit(HttpServletRequest request, Model model)
			throws Exception {
		String code = request.getParameter("code");
		String type = request.getParameter("type");
		DataItem dataItem = new DataItem(code, type);
		DataItem entity = dataItemService.findByPrimaryKey(dataItem);
		model.addAttribute("entity", entity);
		return "app/dataitem/edit";
	}

	/**
	 * 更新操作
	 * 
	 * @param request
	 * @param dataItem
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/update")
	@ResponseBody
	public boolean update(HttpServletRequest request, DataItem dataItem)
			throws Exception {
		try {
			dataItemService.update(dataItem);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DATAITEM_CATALOGID,
					"IPO更新数据项成功", WriteLog.SYS_LOG_OPE_SUCC, "",
					request.getSession());
		} catch (Exception e) {
			logger.error("update error:" + e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_DATAITEM_CATALOGID,
					"IPO更新数据项失败", WriteLog.SYS_LOG_OPE_FAILURE, "",
					request.getSession());
			return false;
		}
		return true;
	}

	private String getloginUserId(HttpServletRequest request) {
		UserManageVO user = (UserManageVO) request.getSession().getAttribute(
				"CurrentUser");
		if (user != null) {
			return user.getUserID();
		}
		return "nologin";
	}

}
