package com.yrdce.ipo.modules.sys.web;

import gnnt.MEBS.logonService.vo.UserManageVO;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.BrBrokerService;
import com.yrdce.ipo.modules.sys.service.CommodityService;
import com.yrdce.ipo.modules.sys.service.UnderwriterSubscribeService;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.UnderwriterSubscribe;
import com.yrdce.ipo.modules.sys.vo.VBrBroker;

/**
 * 承销设置
 * 
 * @author chenjing
 *
 */
@Controller
@RequestMapping("UnderwriterSetController")
public class UnderwriterSetController {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(UnderwriterSetController.class);

	@Autowired
	private UnderwriterSubscribeService underwritersubscribeService;

	@Autowired
	private CommodityService commodityService;

	@Autowired
	private BrBrokerService brBrokerService;

	/**
	 * 分页返回承销设置
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findUnderwriterSet", method = RequestMethod.POST)
	@ResponseBody
	public String findUnderwriterSet(@RequestParam("page") String page,
			@RequestParam("rows") String rows, UnderwriterSubscribe example)
			throws IOException {
		log.info("分页查询承销设置");
		try {
			if (example != null) {
				example.setDeleteFlag((short) 0);
				log.info(example.toString());
				List<UnderwriterSubscribe> list = underwritersubscribeService
						.getInfosByPage(page, rows, example);
				int totalnums = underwritersubscribeService
						.getQueryNum(example);
				ResponseResult result = new ResponseResult();
				result.setTotal(totalnums);
				result.setRows(list);
				log.debug(JSON.json(result));
				return JSON.json(result);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 删除承销设置信息
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/deleteInfo", method = RequestMethod.POST)
	@ResponseBody
	public String deleteInfo(@RequestParam("ids") String ids)
			throws IOException {
		log.info("批量删除承销设置信息:" + ids);
		return underwritersubscribeService.deleteInfo(ids);
	}

	/**
	 * 跳转到增加视图
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addInfo", method = RequestMethod.GET)
	public String addInfo(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<Commodity> commist = commodityService.findAll();
		request.setAttribute("commList", commist);
		return "app/underwritingManage/setDetail";
	}

	/**
	 * 新增设置
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addSet", method = RequestMethod.POST)
	@ResponseBody
	public String addSet(UnderwriterSubscribe example, HttpSession session)
			throws IOException {
		if (example != null) {
			example.setDeleteFlag((short) 0);
			String userId = ((UserManageVO) session.getAttribute("CurrentUser"))
					.getUserID();
			example.setCreateUser(userId);
			example.setCreateDate(new Date());
			int num = underwritersubscribeService.insertInfo(example);
			if (num == 1) {
				return "true";
			}
		}
		return "false";

	}

	/**
	 * 查找承销商
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findUnderwriter", method = RequestMethod.POST)
	@ResponseBody
	public String findUnderwriter(
			@RequestParam("underwriterid") String underwriterid)
			throws IOException {
		List<VBrBroker> datalist = brBrokerService.findAllUnderwriter();
		for (VBrBroker temp : datalist) {
			if (underwriterid.equals(temp.getBrokerid())) {
				return "1";// 承销会员代码可用
			}
		}
		return "0";

	}
}
