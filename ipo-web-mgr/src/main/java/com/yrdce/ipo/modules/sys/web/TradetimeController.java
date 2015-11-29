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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.TradetimeService;
import com.yrdce.ipo.modules.sys.vo.Nottradeday;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.Tradetime;

/**
 * 交易节增删改查
 * 
 * @author Bob
 *
 */

@Controller
@RequestMapping("TradetimeController")
public class TradetimeController {

	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(TradetimeController.class);

	@Autowired
	private TradetimeService tradetimeService;

	// 交易节信息展示
	@RequestMapping(value = "/getTradetimeList", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getTradetimeList(@RequestParam("page") String page, @RequestParam("rows") String rows) throws IOException {
		logger.info("交易节信息展示" + "page:" + page + "rows:" + rows);
		try {
			List<Tradetime> clist = tradetimeService.selectByPage(page, rows);
			int totalnums = tradetimeService.selectByCounts();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(clist);
			System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	// 跳出修改页面时的一次查询
	@RequestMapping(value = "/getTradetime", method = RequestMethod.GET)
	@ResponseBody
	public String getTradetime(short id) {
		logger.info("根据主键查询交易节信息" + "id:" + id);
		try {
			Tradetime tradetime = tradetimeService.selectByKey(id);
			return JSON.json(tradetime);
		} catch (Exception e) {
			logger.info("修改交易节信息转换json失败");
			e.printStackTrace();
			return "";
		}
	}

	// 修改交易节
	@RequestMapping(value = "/updateTradetime", method = RequestMethod.GET)
	@ResponseBody
	public int updateTradetime(Tradetime tradetime) {
		logger.info("修改交易节" + "tradetime:" + tradetime);
		try {
			int i = tradetimeService.upDate(tradetime);
			return i;
		} catch (Exception e) {
			return 0;
		}

	}

	// 添加交易节

	@RequestMapping(value = "/addTradetime", method = RequestMethod.POST)
	@ResponseBody
	public int addTradetime(Tradetime tradetime) {
		logger.info("进入添加交易节");
		try {

			int i = tradetimeService.insert(tradetime);
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}

	}

	// 删除交易节
	@RequestMapping(value = "/deleteTradetime", method = RequestMethod.POST)
	@ResponseBody
	public int deleteTradetime(int ids) {
		logger.info("进入删除交易节" + "ids:" + ids);
		try {

			int status = tradetimeService.delete(ids);
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}

	// 修改交易节视图
	@RequestMapping(value = "/updateTradetimeforward", method = RequestMethod.GET)
	public String updateTradetimeforward(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("sectionID") String sectionID) throws IOException {
		logger.info("进入修改视图");
		short sectionID1 = Short.parseShort(sectionID);
		Tradetime tradetime = tradetimeService.selectByKey(sectionID1);
		request.setAttribute("tradetime", tradetime);
		return "app/tradetime/add_tradeTime";
	}

	// 添加交易节视图
	@RequestMapping(value = "/addTradetimeforward", method = RequestMethod.GET)
	public String addTradetimeforward(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		logger.info("进入新增 视图");
		return "app/tradetime/add_tradeTime";
	}

	// 非交易日查询
	@RequestMapping(value = "/getNottradeday", method = RequestMethod.GET)
	@ResponseBody
	public Nottradeday getNottradeday() {
		try {
			Nottradeday nottradeday = tradetimeService.select();

			return nottradeday;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	// 更新、修改
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	@ResponseBody
	public int update(Nottradeday notTradeDay) {
		try {
			int status;// 1：成功 2：失败
			status = tradetimeService.insertByNottradeday(notTradeDay);
			return status;
		} catch (Exception e) {
			e.printStackTrace();
			return 2;
		}
	}
}
