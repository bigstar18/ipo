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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.BrBrokerService;
import com.yrdce.ipo.modules.sys.service.IpoCommConfService;
import com.yrdce.ipo.modules.sys.service.PayFlowService;
import com.yrdce.ipo.modules.sys.service.PositionService;
import com.yrdce.ipo.modules.sys.service.PublisherPositionService;
import com.yrdce.ipo.modules.sys.service.PubpaymentTrackService;
import com.yrdce.ipo.modules.sys.service.SPOService;
import com.yrdce.ipo.modules.sys.service.SpecialCounterFeeService;
import com.yrdce.ipo.modules.sys.service.UnderwriterSubscribeService;
import com.yrdce.ipo.modules.sys.vo.PayFlow;
import com.yrdce.ipo.modules.sys.vo.PublisherBalance;
import com.yrdce.ipo.modules.sys.vo.PublisherSettle;
import com.yrdce.ipo.modules.sys.vo.PubpaymentTrack;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.SettleResult;
import com.yrdce.ipo.modules.sys.vo.UnderWriters;
import com.yrdce.ipo.modules.sys.vo.VBrBroker;
import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;
import com.yrdce.ipo.modules.warehouse.service.IpoStorageService;

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
	 * 商品发行查询
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findUnderwriters", method = RequestMethod.POST)
	@ResponseBody
	public String findUnderwriters(@RequestParam("page") String page,
			@RequestParam("rows") String rows, UnderWriters example,
			HttpServletRequest request) throws IOException {
		log.info("查询发行商的产品发行信息");
		try {
			String userid = this.getLoginUserId(request);
			example.setPubmemberid(userid);
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
		// payFlow.setPubmemberid(this.getLoginUserId(request));
		payFlow.setPubmemberid("scfx");

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
	 * 发行货款跟踪查询
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findPaymentTrack", method = RequestMethod.POST)
	@ResponseBody
	public String findPaymentTrack(@RequestParam("page") String page,
			@RequestParam("rows") String rows, PubpaymentTrack example)
			throws IOException {
		log.info("查询发行商应付货款跟踪");
		try {
			log.debug(example.toString());
			List<PubpaymentTrack> paymentlist = paymenttrackservice
					.getTrackInfoByPage(page, rows, example);
			int totalnum = paymenttrackservice.getTrackNum(example);
			ResponseResult result = new ResponseResult();
			result.setRows(paymentlist);
			result.setTotal(totalnum);
			log.debug(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
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
				return "true";
			}
			return "false";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
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
			@RequestParam("queryDate") String queryDate) {
		List<VBrBroker> brokers = brBrokerService.findAllPublisher();
		String publisherid = this.getLoginUserId(request);
		// String publisherid = "scfx";
		List<SettleResult> settles = new ArrayList<SettleResult>();
		if (!"".equals(publisherid)) {
			SettleResult result = this.getSettle(publisherid, queryDate);
			for (VBrBroker broker : brokers) {
				if (publisherid.equals(broker.getBrokerid())) {
					result.setBroker(broker);
				}
			}
			settles.add(result);
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
