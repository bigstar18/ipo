package com.yrdce.ipo.modules.sys.web;

import gnnt.MEBS.logonService.vo.UserManageVO;

import java.io.IOException;
import java.math.BigDecimal;
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
import com.yrdce.ipo.modules.sys.service.IpoCommConfService;
import com.yrdce.ipo.modules.sys.service.PublisherPositionService;
import com.yrdce.ipo.modules.sys.service.PubpaymentTrackService;
import com.yrdce.ipo.modules.sys.service.SPOService;
import com.yrdce.ipo.modules.sys.service.UnderwriterSubscribeService;
import com.yrdce.ipo.modules.sys.vo.PublisherPosition;
import com.yrdce.ipo.modules.sys.vo.PubpaymentTrack;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.UnderWriters;
import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;

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
	private UnderwriterSubscribeService underwritersubscribeService;

	@Autowired
	private PubpaymentTrackService paymenttrackservice;

	@Autowired
	private SPOService spoService;

	@Autowired
	private PublisherPositionService publisherpositionService;

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
	 * 判断承销商可用资金能否支付认购数量的商品
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkFundsAvailable", method = RequestMethod.POST)
	@ResponseBody
	public String checkFundsAvailable(
			@RequestParam("underwriterid") String underwriterid,
			@RequestParam("amount") String amount) {
		String dealId = spoService.getFirmid(underwriterid);
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
			@RequestParam("rows") String rows, PublisherPosition example)
			throws IOException {
		log.info("查询发行会员转持仓信息");
		try {
			List<PublisherPosition> comlist = publisherpositionService
					.getInfoByPage(page, rows, example);
			int totalnum = publisherpositionService.getPubPositionNum(example);
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

}
