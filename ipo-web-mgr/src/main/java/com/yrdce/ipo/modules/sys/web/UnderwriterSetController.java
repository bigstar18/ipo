package com.yrdce.ipo.modules.sys.web;

import gnnt.MEBS.logonService.vo.UserManageVO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.common.constant.PositionConstant;
import com.yrdce.ipo.modules.sys.service.BrBrokerService;
import com.yrdce.ipo.modules.sys.service.IpoCommConfService;
import com.yrdce.ipo.modules.sys.service.PositionService;
import com.yrdce.ipo.modules.sys.service.UnderwriterDepositService;
import com.yrdce.ipo.modules.sys.service.UnderwriterSubscribeService;
import com.yrdce.ipo.modules.sys.vo.PositionFlow;
import com.yrdce.ipo.modules.sys.vo.PositionReduce;
import com.yrdce.ipo.modules.sys.vo.PubPositionFlow;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.UnderwriterDeposit;
import com.yrdce.ipo.modules.sys.vo.UnderwriterSubscribe;
import com.yrdce.ipo.modules.sys.vo.VBrBroker;
import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;

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
	private IpoCommConfService ipoCommConfService;

	@Autowired
	private BrBrokerService brBrokerService;

	@Autowired
	private UnderwriterDepositService depositService;

	@Autowired
	private PositionService positionService;

	/**
	 * 承销货款押金
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/getAllInfo", method = RequestMethod.POST)
	@ResponseBody
	public String getAllInfo(@RequestParam("page") String page,
			@RequestParam("rows") String rows,
			@RequestParam(value = "brokerid", required = false) String brokerid) {
		try {
			VBrBroker example = new VBrBroker();
			if (brokerid != null) {
				if (!brokerid.trim().equals("")) {
					example.setBrokerid(brokerid);
				}
			}
			List<VBrBroker> datalist = brBrokerService.getUnderscribeFunds(
					example, "承销会员", page, rows);
			int num = brBrokerService.getUnderscribeFundsCount(example, "承销会员");
			ResponseResult result = new ResponseResult();
			result.setRows(datalist);
			result.setTotal(num);
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

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
				log.debug(example.toString());
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
		List<VIpoCommConf> commist = ipoCommConfService
				.findAvaiSubscribeCommoditys();
		request.setAttribute("commList", commist);
		request.setAttribute("commlist", JSON.json(commist));
		return "app/underwritingManage/setDetail";
	}

	/**
	 * 获取已认购同一商品的承销商手续费比例总和
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkRatioSum", method = RequestMethod.POST)
	@ResponseBody
	public String checkRatioSum(@RequestParam("commodityId") String commodityId)
			throws IOException {
		Float ratio = underwritersubscribeService.checkRatioSum(commodityId);
		return ratio.toString();
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
	public String addSet(UnderwriterSubscribe example,
			HttpServletRequest request) throws IOException {
		if (example != null) {
			example.setDeleteFlag((short) 0);
			String flag = underwritersubscribeService.checkExist(example);
			if (flag != null) {
				if (flag.equals("true")) {
					return "existed";
				}
				if (flag.equals("false")) {
					String tag = underwritersubscribeService
							.checkTotalCounts(example.getCommodityid());
					if (tag != null) {
						if (tag.equals("false")) {
							return "full";
						}
						if (tag.equals("true")) {
							String mark = underwritersubscribeService
									.checkFrozenFunds(example);
							if (mark != null) {
								if (mark.equals("false")) {
									return "fundshort";
								}
								if (mark.equals("true")) {
									String userId = this
											.getLoginUserId(request);
									example.setCreateUser(userId);
									example.setCreateDate(new Date());
									underwritersubscribeService
											.insertInfo(example);
									return "true";
								}

							}
						}
					}
				}
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

	/**
	 * 暂扣货款视图
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/withhold", method = RequestMethod.GET)
	public String withhold(@RequestParam("brokerid") String brokerid,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		request.setAttribute("brokerid", brokerid);
		return "app/underwritingManage/withhold";

	}

	/**
	 * 暂扣货款
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/deductMoney", method = RequestMethod.POST)
	@ResponseBody
	public String deductMoney(UnderwriterDeposit deposit,
			HttpServletRequest request) throws IOException {
		String userId = getLoginUserId(request);
		deposit.setCreateDate(new Date());
		deposit.setCreateUser(userId);
		depositService.insertInfo(deposit);
		return "true";
	}

	/**
	 * 认购资金处理列表查询
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/subFundsList", method = RequestMethod.POST)
	@ResponseBody
	public String subFundsList(@RequestParam("page") String page,
			@RequestParam("rows") String rows,
			@RequestParam(value = "brokerid", required = false) String brokerid)
			throws IOException {
		UnderwriterDeposit example = new UnderwriterDeposit();
		if (brokerid != null) {
			if (!brokerid.trim().equals("")) {
				example.setBrokerid(brokerid);
			}
		}
		List<UnderwriterDeposit> datalist = depositService.selectInfoByPage(
				page, rows, example);
		int num = depositService.getInfoCounts(example);
		ResponseResult result = new ResponseResult();
		result.setRows(datalist);
		result.setTotal(num);
		return JSON.json(result);
	}

	/**
	 * 认购商品页面
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/subCommodity", method = RequestMethod.GET)
	public String subCommodity(
			@RequestParam(value = "brokerid") String brokerid,
			HttpServletRequest request) throws IOException {
		List<UnderwriterSubscribe> datalist = underwritersubscribeService
				.selectUnFrozeSet(brokerid);
		UnderwriterDeposit record = depositService
				.selectInfoByBrokerId(brokerid);
		request.setAttribute("subCommList", datalist);
		request.setAttribute("subCommlist", JSON.json(datalist));
		request.setAttribute("brokerid", brokerid);
		request.setAttribute("deposit", record);
		return "app/underwritingManage/subCommodity";
	}

	/**
	 * 认购资金解冻
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/unfrozenSubFunds", method = RequestMethod.POST)
	@ResponseBody
	public String unfrozenSubFunds(UnderwriterSubscribe example,
			HttpServletRequest request) throws IOException {
		try {
			String userId = getLoginUserId(request);
			UnderwriterDeposit record = depositService
					.selectInfoByBrokerId(example.getUnderwriterid());
			underwritersubscribeService.unfrozen(example, record.getAmount(),
					userId);
			return "true";
		} catch (Exception e) {
			log.error("认购资金解冻 error:" + e);
			return "false";
		}
	}

	/**
	 * 分期解冻查询
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/reduceHoldPosition", method = RequestMethod.POST)
	@ResponseBody
	public String reduceHoldPosition(@RequestParam("page") String page,
			@RequestParam("rows") String rows, PubPositionFlow example)
			throws IOException {
		log.info("查询承销商认购转持仓流水记录");
		try {
			example.setBusinessCode(ChargeConstant.BusinessType.UNDERWRITE
					.getCode());
			example.setRoleCode(ChargeConstant.RoleType.UNDERWRITER.getCode());
			example.setState(PositionConstant.FlowState.turn_goods.getCode());// 要等转到现货持仓才行
			long count = positionService.queryPubFlowForCount(example);
			List<PubPositionFlow> dataList = new ArrayList<PubPositionFlow>();
			if (count > 0) {
				dataList = positionService.queryPubFlowForPage(page, rows,
						example);
			}
			ResponseResult result = new ResponseResult();
			result.setTotal(new Long(count).intValue());
			result.setRows(dataList);
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 减持设置查询
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/reduceSet", method = RequestMethod.GET)
	public String reduceSet(@RequestParam("id") String id,
			HttpServletRequest request) throws IOException {
		log.info("跳转持仓单号对应的减持设置信息视图");
		try {
			request.setAttribute("id", id);
			return "app/underwritingManage/reduceSet";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 减持设置分页查询列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/reduceSetList", method = RequestMethod.GET)
	@ResponseBody
	public String reduceSetList(@RequestParam("page") String page,
			@RequestParam("rows") String rows, @RequestParam("id") String id)
			throws IOException {
		log.info("查询持仓单号对应的减持设置列表");
		try {
			PositionReduce positionReduce = new PositionReduce();
			positionReduce.setPositionFlowId(Long.valueOf(id));
			List<PositionReduce> dataList = new ArrayList<PositionReduce>();
			dataList = positionService.queryReduceForListByPage(page, rows,
					positionReduce);
			ResponseResult result = new ResponseResult();
			result.setTotal(positionService.queryReduceCount(positionReduce));
			result.setRows(dataList);
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 跳转到 新增减持仓页面
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/addReduce")
	public String addReduce(HttpServletRequest request, Model model) {
		Long positionFlowId = Long.valueOf(request
				.getParameter("positionFlowId"));
		PositionFlow flow = positionService.findFlow(positionFlowId);
		model.addAttribute("flow", flow);

		return "app/underwritingManage/add_reduce";
	}

	private String getLoginUserId(HttpServletRequest request) {
		UserManageVO user = (UserManageVO) request.getSession().getAttribute(
				"CurrentUser");
		if (user != null) {
			return user.getUserID();
		}
		return "nologin";
	}

}
