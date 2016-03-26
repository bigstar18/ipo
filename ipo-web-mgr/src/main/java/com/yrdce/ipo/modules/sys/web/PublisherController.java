package com.yrdce.ipo.modules.sys.web;

import gnnt.MEBS.logonService.vo.UserManageVO;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import com.yrdce.ipo.modules.sys.service.PayFlowService;
import com.yrdce.ipo.modules.sys.service.PositionService;
import com.yrdce.ipo.modules.sys.service.PublisherPositionService;
import com.yrdce.ipo.modules.sys.service.PubpaymentTrackService;
import com.yrdce.ipo.modules.sys.service.SPOService;
import com.yrdce.ipo.modules.sys.service.SpecialCounterFeeService;
import com.yrdce.ipo.modules.sys.service.SystemService;
import com.yrdce.ipo.modules.sys.service.UnderwriterSubscribeService;
import com.yrdce.ipo.modules.sys.util.WriteLog;
import com.yrdce.ipo.modules.sys.vo.PayFlow;
import com.yrdce.ipo.modules.sys.vo.PositionFlow;
import com.yrdce.ipo.modules.sys.vo.PositionReduce;
import com.yrdce.ipo.modules.sys.vo.PubPositionFlow;
import com.yrdce.ipo.modules.sys.vo.PublisherBalance;
import com.yrdce.ipo.modules.sys.vo.PublisherPosition;
import com.yrdce.ipo.modules.sys.vo.PublisherSettle;
import com.yrdce.ipo.modules.sys.vo.PubpaymentTrack;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.SettleResult;
import com.yrdce.ipo.modules.sys.vo.Specialcounterfee;
import com.yrdce.ipo.modules.sys.vo.UnderWriters;
import com.yrdce.ipo.modules.sys.vo.VBrBroker;
import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;
import com.yrdce.ipo.modules.warehouse.service.IpoStorageService;
import com.yrdce.ipo.modules.warehouse.vo.VIpoStorageExtended;

/**
 * 发行会员查询Controller
 * 
 * @author chenjing
 * @version 2013-5-31
 */
@Controller
@RequestMapping("PublisherController")
public class PublisherController {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(PublisherController.class);

	@Autowired
	private IpoCommConfService ipoCommConfService;

	@Autowired
	private SystemService systemService;

	@Autowired
	private IpoStorageService ipoStorageService;

	@Autowired
	private UnderwriterSubscribeService underwritersubscribeService;

	@Autowired
	private PubpaymentTrackService paymenttrackservice;

	@Autowired
	private SPOService spoService;

	@Autowired
	private PublisherPositionService publisherpositionService;

	@Autowired
	private BrBrokerService brBrokerService;

	@Autowired
	private SpecialCounterFeeService specialCounterFeeService;
	@Autowired
	private PositionService positionService;

	@Autowired
	private PayFlowService payFlowService;

	public IpoCommConfService getIpoCommConfService() {
		return ipoCommConfService;
	}

	public void setIpoCommConfService(IpoCommConfService ipoCommConfService) {
		this.ipoCommConfService = ipoCommConfService;
	}

	/**
	 * 产品发行查询
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findAllCommsByExample", method = RequestMethod.POST)
	@ResponseBody
	public String findAllCommsByExample(@RequestParam("page") String page,
			@RequestParam("rows") String rows, VIpoCommConf example)
			throws IOException {
		log.info("查询所有商品列表");
		try {
			List<VIpoCommConf> comlist = ipoCommConfService
					.findIpoCommConfsByExample(page, rows, example);
			int totalnum = ipoCommConfService.getNumsByExample(example);
			ResponseResult result = new ResponseResult();
			result.setRows(comlist);
			result.setTotal(totalnum);
			log.debug(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 承销会员查询
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findUnderwriters", method = RequestMethod.POST)
	@ResponseBody
	public String findUnderwriters(@RequestParam("page") String page,
			@RequestParam("rows") String rows, UnderWriters example)
			throws IOException {
		log.info("查询发行商的承销会员列表");
		try {
			List<UnderWriters> comlist = underwritersubscribeService
					.findUnderwriters(page, rows, example);
			int totalnum = underwritersubscribeService
					.getUnderwritersNum(example);
			ResponseResult result = new ResponseResult();
			result.setRows(comlist);
			result.setTotal(totalnum);
			log.debug(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 查询发行的货款记录
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryPublishGoods", method = RequestMethod.POST)
	@ResponseBody
	public String queryPublishGoods(@RequestParam("page") String pageNo,
			@RequestParam("rows") String pageSize, HttpServletRequest request)
			throws Exception {

		PayFlow payFlow = new PayFlow();
		if (request.getParameter("payState") != null) {
			if (!request.getParameter("payState").trim().equals("")) {
				payFlow.setPayState(Integer.parseInt(request
						.getParameter("payState")));
			}
		}
		payFlow.setCommodityId(request.getParameter("commodityId"));
		long count = payFlowService.queryPublishGoodsForCount(payFlow);
		List<PayFlow> dataList = new ArrayList<PayFlow>();
		if (count > 0) {
			dataList = payFlowService.queryPublishGoodsForPage(pageNo,
					pageSize, payFlow);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal(new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}

	/**
	 * 跳转到货款跟踪录入视图
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addInfo", method = RequestMethod.GET)
	public String addInfo(PubpaymentTrack patmentTrack,
			HttpServletRequest request, HttpServletResponse response) {
		List<VIpoCommConf> commlist = ipoCommConfService.findIpoCommConfs();
		request.setAttribute("commlist", commlist);
		return "app/publisherQuery/setDetail";
	}

	/**
	 * 判断商品货款跟踪信息是否已存在
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkExsitPaymentTrack", method = RequestMethod.POST)
	@ResponseBody
	public String checkExsitPaymentTrack(
			@RequestParam("commodityid") String commodityid) throws IOException {
		PubpaymentTrack example = new PubpaymentTrack();
		example.setDeleteflag((short) 0);
		int totalnum = paymenttrackservice.getTrackNum(example);
		List<PubpaymentTrack> paymentlist = paymenttrackservice
				.getTrackInfoByPage(1 + "", totalnum + "", example);
		for (PubpaymentTrack temp : paymentlist) {
			if (commodityid.equals(temp.getCommodityid())) {
				return "true";
			}
		}
		return "false";

	}

	/**
	 * 增加发行货款跟踪信息
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addPaymentTrack", method = RequestMethod.POST)
	@ResponseBody
	public String addPaymentTrack(PubpaymentTrack example, HttpSession session)
			throws IOException {
		log.info("增加发行货款跟踪信息");
		try {
			log.debug(example.toString());
			String userId = ((UserManageVO) session.getAttribute("CurrentUser"))
					.getUserID();
			example.setDeleteflag((short) 0);
			example.setCreateperson(userId);
			example.setCreatedate(new Date());
			int num = paymenttrackservice.insertTrack(example);
			if (num == 1) {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_PUBLISH_CATALOGID,
						"IPO发行商货款跟踪", WriteLog.SYS_LOG_OPE_SUCC, "", session,
						systemService);
				return "true";
			}
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_PUBLISH_CATALOGID,
					"IPO发行商货款跟踪", WriteLog.SYS_LOG_OPE_FAILURE, "", session,
					systemService);
			return "false";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 判断承销商可用资金能否支付认购数量的商品
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkFundsAvailable", method = RequestMethod.POST)
	@ResponseBody
	public String checkFundsAvailable(
			@RequestParam("brokerid") String brokerid,
			@RequestParam("amount") String amount) {
		String dealId = spoService.getFirmid(brokerid);
		return spoService.checkFundsAvailable(dealId, new BigDecimal(amount));
	}

	/**
	 * 发行会员转持仓
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/transferPosition", method = RequestMethod.POST)
	@ResponseBody
	public String transferPosition(@RequestParam("page") String page,
			@RequestParam("rows") String rows, VIpoStorageExtended storage)
			throws IOException {
		log.info("分页查询转持仓信息");
		log.debug(storage.toString());
		try {
			storage.setStoragestate(4);
			List<VIpoStorageExtended> tlist = ipoStorageService.selectBySale(
					page, rows, storage);
			int totalnums = ipoStorageService.getSaleTotalNum(storage);
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
	 * 跳转到新增转持仓视图
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addTransferPosition", method = RequestMethod.GET)
	public String addTransferPosition(
			@RequestParam("storageid") String storageid,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		VIpoStorageExtended storage = ipoStorageService
				.getStorageByStorageId(storageid);
		VIpoCommConf comm = ipoCommConfService.getVIpoCommConfByCommid(storage
				.getCommodityid());
		request.setAttribute("entity", storage);
		request.setAttribute("flag", "add");
		request.setAttribute("comm", comm);
		return "app/publisherQuery/addTransferPosition";
	}

	/**
	 * 跳转到更改转持仓视图
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateTransferPosition", method = RequestMethod.GET)
	public String updateTransferPosition(
			@RequestParam("storageid") String storageid,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		PublisherPosition tposition = publisherpositionService
				.getInfoByStorageId(storageid);
		VIpoCommConf comm = ipoCommConfService
				.getVIpoCommConfByCommid(tposition.getCommodityid());
		request.setAttribute("entity", tposition);
		request.setAttribute("flag", "update");
		request.setAttribute("comm", comm);
		return "app/publisherQuery/addTransferPosition";
	}

	/**
	 * 验证转发售量
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkSaleCounts", method = RequestMethod.POST)
	@ResponseBody
	public String checkSaleCounts(
			@RequestParam("salecounts") String salecounts,
			@RequestParam("commodityid") String commodityid,
			@RequestParam("counts") String counts) {
		long lnum = publisherpositionService.getSaleCounts(commodityid);
		long lcounts = Long.parseLong(counts);
		long lsalecounts = Long.parseLong(salecounts);
		if (lnum + lsalecounts > lcounts) {
			return "false";// 发行量已满
		}
		return "true";
	}

	/**
	 * 新增转持仓信息
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addPublisherPosition", method = RequestMethod.POST)
	@ResponseBody
	public String addPublisherPosition(PublisherPosition example,
			HttpServletRequest request) {

		String userId = this.getLoginUserId(request);
		example.setStatus((short) 1);
		example.setCreater(userId);
		example.setCreatedate(new Date());
		int num = publisherpositionService.insertPubPoition(example);
		if (num == 1) {
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_PUBLISH_CATALOGID,
					"IPO发行库存转持仓新增设置信息成功", WriteLog.SYS_LOG_OPE_SUCC, "",
					request.getSession(), systemService);
			return "true";
		}
		WriteLog.writeOperateLog(WriteLog.SYS_LOG_PUBLISH_CATALOGID,
				"IPO发行库存转持仓新增设置信息失败", WriteLog.SYS_LOG_OPE_FAILURE, "",
				request.getSession(), systemService);
		return "false";
	}

	/**
	 * 修改转持仓信息
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/updatePublisherPosition", method = RequestMethod.POST)
	@ResponseBody
	public String updatePublisherPosition(PublisherPosition example,
			HttpServletRequest request) {
		if (example.getStatus() == 1) {
			String userId = this.getLoginUserId(request);
			// example.setStatus((short) 1);
			example.setUpdater(userId);
			example.setUpdatedate(new Date());
			int num = publisherpositionService.updatePubPoition(example);
			if (num == 1) {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_PUBLISH_CATALOGID,
						"IPO发行库存转持仓修改设置信息成功", WriteLog.SYS_LOG_OPE_SUCC, "",
						request.getSession(), systemService);
				return "true";
			}
		}
		WriteLog.writeOperateLog(WriteLog.SYS_LOG_PUBLISH_CATALOGID,
				"IPO发行库存转持仓修改设置信息失败", WriteLog.SYS_LOG_OPE_FAILURE, "",
				request.getSession(), systemService);
		return "false";
	}

	/**
	 * 冻结
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/frozenFunds", method = RequestMethod.POST)
	@ResponseBody
	public String frozenFunds(@RequestParam("storageid") String storageid,
			HttpSession session) {
		PublisherPosition record = publisherpositionService
				.getInfoByStorageId(storageid);
		Specialcounterfee specialfee = publisherpositionService
				.getSpecialCounterfee(record.getPublisherid(),
						record.getCommodityid(), "3");// 获取交易商的特殊发行手续费比例
		VIpoCommConf commodity = ipoCommConfService
				.getVIpoCommConfByCommid(record.getCommodityid());
		BigDecimal totalValue = record.getTotalvalue();// 鉴定总值
		BigDecimal funds = new BigDecimal(record.getSalecounts())
				.multiply(commodity.getPrice());// 货款
		BigDecimal interest = new BigDecimal(0);// 发行手续费
		if (specialfee != null) {
			Short tradealgr = specialfee.getTradealgr();
			BigDecimal ratio = specialfee.getCounterfee();
			if (tradealgr == 1) {// 百分比算法
				interest = totalValue.multiply(ratio).divide(
						new BigDecimal(100));
			}
			if (tradealgr == 2) {// 绝对值算法
				interest = ratio;
			}
		} else {
			Short publishalgr = commodity.getPublishalgr();// 发行手续费算法
			BigDecimal ratio = commodity.getPublishercharatio();// 发行商发行手续费比例
			if (publishalgr == 1) {// 百分比算法
				interest = totalValue.multiply(ratio).divide(
						new BigDecimal(100));
			}
			if (publishalgr == 2) {// 绝对值算法
				interest = ratio;
			}
		}
		String message = publisherpositionService.frozenFunds(
				record.getPublisherid(), interest);// 冻结客户手续费
		if ("true".equals(message)) {
			record.setStatus((short) 2);
			record.setUpdatedate(new Date());
			record.setUpdater(((UserManageVO) session
					.getAttribute("CurrentUser")).getUserID());
			publisherpositionService.updateStatus(record);
			publisherpositionService.insertPoundage(record, totalValue);
			publisherpositionService.insertLoan(record, funds);
			// 插入持仓流水记录
			publisherpositionService.insertPositionFlow(record);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_PUBLISH_CATALOGID,
					"IPO发行库存转持仓冻结费用成功", WriteLog.SYS_LOG_OPE_SUCC, "", session,
					systemService);
			return "true";
		}
		WriteLog.writeOperateLog(WriteLog.SYS_LOG_PUBLISH_CATALOGID,
				"IPO发行库存转持仓冻结费用失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session,
				systemService);
		return "false";
	}

	/**
	 * 转持仓
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/transfer", method = RequestMethod.POST)
	@ResponseBody
	public String transferPosition(@RequestParam("storageid") String storageid,
			HttpSession session) {
		// 根据入库单找转持仓单，获取转持仓数量
		PublisherPosition record = publisherpositionService
				.getInfoByStorageId(storageid);
		record.setStatus((short) 4);
		record.setUpdatedate(new Date());
		record.setUpdater(((UserManageVO) session.getAttribute("CurrentUser"))
				.getUserID());
		return publisherpositionService.transferPosition(record);
	}

	/**
	 * 减持设置查询
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
		log.info("查询发行商转持仓流水记录");
		try {
			example.setBusinessCode(ChargeConstant.BusinessType.PUBLISH
					.getCode());
			example.setRoleCode(ChargeConstant.RoleType.PUBLISHER.getCode());
			example.setState(PositionConstant.FlowState.turn_goods.getCode());
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
	 * 库存转持仓列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/transferQuery", method = RequestMethod.POST)
	@ResponseBody
	public String transferQuery(@RequestParam("page") String page,
			@RequestParam("rows") String rows, PublisherPosition transposition)
			throws IOException {
		log.info("分页查询已设置的转持仓信息");
		log.debug(transposition.toString());
		try {
			ResponseResult result = new ResponseResult();
			int totalnums = publisherpositionService
					.getPubPositionNum(transposition);
			if (totalnums == 0) {
				result.setTotal(0);
				result.setRows(null);
			} else {
				List<PublisherPosition> tlist = publisherpositionService
						.getInfoByPage(page, rows, transposition);
				result.setTotal(totalnums);
				result.setRows(tlist);
			}
			log.debug(JSON.json(result));
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
			return "app/publisherQuery/reduceSet";
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

		return "app/publisherQuery/add_reduce";
	}

	/**
	 * 跳转到发行会员结算报表页面
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/settleReports", method = RequestMethod.GET)
	public String settleReports(HttpServletRequest request,
			HttpServletResponse response) {
		List<VBrBroker> brokers = brBrokerService.findAllPublisher();
		request.setAttribute("brokerlist", brokers);
		return "app/publisherQuery/settleReports";
	}

	/**
	 * 结算报表子窗口
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/showSettleLists", method = RequestMethod.GET)
	public String showSettleLists(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("publisherid") String publisherid,
			@RequestParam("queryDate") String queryDate) {
		List<VBrBroker> brokers = brBrokerService.findAllPublisher();
		List<SettleResult> settles = new ArrayList<SettleResult>();
		if (!"".equals(publisherid)) {
			SettleResult result = this.getSettle(publisherid, queryDate);
			for (VBrBroker broker : brokers) {
				if (publisherid.equals(broker.getBrokerid())) {
					result.setBroker(broker);
				}
			}
			settles.add(result);
		} else {
			for (int i = 0; i < brokers.size(); i++) {
				String publisher = brokers.get(i).getBrokerid();
				SettleResult result = this.getSettle(publisher, queryDate);
				result.setBroker(brokers.get(i));
				settles.add(result);
			}
		}
		request.setAttribute("settles", settles);
		request.setAttribute("today", queryDate);
		return "/app/publisherQuery/reportsDetail";
	}

	/*
	 * 获取每个交易商的报表内容
	 */
	public SettleResult getSettle(String publisherid, String queryDate) {
		PublisherBalance balance = brBrokerService.findBalance(publisherid,
				queryDate);// 上日和今日资金余额
		// 获取货款和手续费
		List<PublisherSettle> paylist = brBrokerService.findLoanAndHandling(
				publisherid, queryDate);
		BigDecimal totalLoan = new BigDecimal(0);
		for (PublisherSettle temp : paylist) {
			if (temp.getLoan() == null) {
				totalLoan = totalLoan.add(new BigDecimal(0));
			} else {
				totalLoan = totalLoan.add(temp.getLoan());
			}
		}
		SettleResult result = new SettleResult();
		result.setBalance(balance);
		result.setTotalLoan(totalLoan);
		result.setList(paylist);
		return result;

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
