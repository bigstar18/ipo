package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.common.constant.PositionConstant;
import com.yrdce.ipo.modules.sys.service.PayFlowService;
import com.yrdce.ipo.modules.sys.service.PositionService;
import com.yrdce.ipo.modules.sys.service.SPOService;
import com.yrdce.ipo.modules.sys.service.TaskService;
import com.yrdce.ipo.modules.sys.vo.PayFlow;
import com.yrdce.ipo.modules.sys.vo.PositionFlow;
import com.yrdce.ipo.modules.sys.vo.PositionReduce;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.SpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.vo.SpoRation;

import gnnt.MEBS.logonService.vo.UserManageVO;

@Controller
@RequestMapping("SPOController")
public class SPOController {
	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SPOController.class);
	@Autowired
	private SPOService spoService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private PayFlowService payFlowService;
	@Autowired
	private PositionService positionService;

	// 添加增发商品信息
	@RequestMapping(value = "/insertSPOInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String insertSPOInfo(SpoCommoditymanmaagement ipospo) throws IOException {
		logger.info("添加商品增发信息");
		try {
			int temp = spoService.insertSPOInfo(ipospo);
			if (temp == 1) {
				return "success";
			} else {
				return "error";
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("添加商品增发信息", e);
			return "error";
		}

	}

	// 获取发售商品信息
	@RequestMapping(value = "/getIPOCommonity", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getIPOCommonity() throws IOException {
		logger.info("获取商品信息");
		String result = "";
		try {
			Map<String, String> commonityInfo = spoService.getCommodityidByAll();
			if (commonityInfo.size() != 0) {
				for (Map.Entry<String, String> temp : commonityInfo.entrySet()) {
					String tempStr = "";
					String commId = temp.getKey();
					String commName = temp.getValue();
					tempStr = commName + "(" + commId + ")" + "|";
					result += tempStr;
				}
				logger.info(result);
				return result;
			} else {
				return "null";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}

	// 查询增发商品信息
	@RequestMapping(value = "/getAllSPOInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getAllSPOInfo(@RequestParam("page") String page, @RequestParam("rows") String rows,
			SpoCommoditymanmaagement spoComm) throws IOException {
		logger.info("获取商品增发信息");
		try {
			// SpoCommoditymanmaagement spoComm = new SpoCommoditymanmaagement();
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// logger.info(commodityId);
			// logger.info(registerDate);
			// logger.info(spoDate);
			// logger.info(ipoDate);
			// logger.info(rationType);
			// logger.info(rationSate);
			// if (!commodityId.equals("")) {
			// spoComm.setCommodityid(commodityId);
			// }
			// if (!registerDate.equals("")) {
			// Date date = sdf.parse(registerDate);
			// spoComm.setRegisterDate(date);
			// }
			// if (!spoDate.equals("")) {
			// Date date = sdf.parse(spoDate);
			// spoComm.setSpoDate(date);
			// }
			// if (!ipoDate.equals("")) {
			// Date date = sdf.parse(spoDate);
			// spoComm.setIpoDate(date);
			// }
			// if (!rationType.equals("")) {
			// if (rationType.equals("比例配售")) {
			// spoComm.setRationType("1");
			// }
			// if (rationType.equals("定向配售"))
			// spoComm.setRationType("2");
			// }
			// if (!rationSate.equals("")) {
			// if (rationSate.equals("已增发"))
			// spoComm.setSpoSate(1);
			// if (rationSate.equals("增发失败"))
			// spoComm.setSpoSate(2);
			// }
			logger.info(spoComm.getRationType());
			List<SpoCommoditymanmaagement> tempList = spoService.getSPOList(page, rows, spoComm);
			int counts = spoService.spoCounts(spoComm);
			ResponseResult responseResult = new ResponseResult();
			responseResult.setRows(tempList);
			responseResult.setTotal(counts);
			String resultJson = JSON.json(responseResult);
			// System.out.println(resultJson);
			return resultJson;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("获取商品增发信息", e);
			return "error";
		}
	}

	// 获取配售信息
	@RequestMapping(value = "/getRationInfopp", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getRationInfopp(@RequestParam("page") String page, @RequestParam("rows") String rows,
			SpoCommoditymanmaagement spoComm) throws IOException {
		logger.info("获取定向配售信息");
		try {
			List<SpoRation> tempList = spoService.getRationInfo(page, rows, spoComm);
			int counts = spoService.rationCounts(spoComm);
			ResponseResult responseResult = new ResponseResult();
			responseResult.setRows(tempList);
			responseResult.setTotal(counts);
			String resultJson = JSON.json(responseResult);
			// System.out.println(resultJson);
			return resultJson;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("获取定向配售信息", e);
			return "error";
		}
	}

	// 删除配售信息
	@RequestMapping(value = "/deleteRationInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteRationInfo(@RequestParam("rationid") String rationId) throws IOException {
		logger.info("删除定向配售信息");
		try {
			int result = spoService.deleteByRation(Long.parseLong(rationId));
			if (result > 0) {
				return "success";
			} else {
				return "error";
			}

		} catch (Exception e) {
			// TODO: handle exception
			logger.error("删除定向配售信息", e);
			return "error";
		}

	}

	// 删除增发商品信息
	@RequestMapping(value = "/deleteSPOInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String deleteSPOInfo(@RequestParam("spoId") String spoId) throws IOException {
		logger.info("删除增发商品信息");
		try {
			int result = spoService.deleteSPOInfo(spoId);
			if (result > 0) {
				return "success";
			} else {
				return "error";
			}

		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}

	}

	// 更改增发状态
	@RequestMapping(value = "/updateSPOSate", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateSPOSate(@RequestParam("spoId") String spoId,
			@RequestParam("rationSate") String rationSate) {
		logger.info("删除增发商品信息");
		try {
			int result = spoService.updateStatus(Integer.parseInt(rationSate), spoId);
			if (result > 0) {
				return "success";
			} else {
				return "error";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
	}

	// 获取增发信息by SPOId
	@RequestMapping(value = "/getSPOInfoBySPOId", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getSPOInfoBySPOId(@RequestParam("spoId") String spoId, HttpServletRequest request) {
		logger.info("根据增发id获取商品信息！");
		try {
			SpoCommoditymanmaagement spoManage = spoService.getListBySpocom(spoId);
			String result = JSON.json(spoManage);
			logger.info(result);
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			return "error";
		}
	}

	// 修改增发商品信息
	@RequestMapping(value = "/updateSPOInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateSPOInfo(SpoCommoditymanmaagement ipospo) throws IOException {
		logger.info("添加商品增发信息");
		try {
			int temp = spoService.updateComm(ipospo);
			if (temp == 1) {
				return "success";
			} else {
				return "error";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}

	}

	// 获取承销商列表
	@RequestMapping(value = "/getUnderwriterInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String getUnderwriterInfo(@RequestParam("spoId") String spoId) {
		logger.info("获取承销商列表");
		try {
			List<SpoRation> tempInfo = spoService.getRationInfo(spoId);
			ResponseResult responseResult = new ResponseResult();
			responseResult.setRows(tempInfo);
			String jsonResult = JSON.json(tempInfo);
			logger.info("承销商配售信息" + jsonResult);
			return jsonResult;
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("承销商配售信息异常！");
			return "error";
		}
	}

	// 承销商配售信息插入
	@RequestMapping(value = "/addUnderwriterRationInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String addUnderwriterRationInfo(@RequestBody List<SpoRation> spoRationList) {
		logger.info("承销商配售信息插入");
		try {
			spoService.insertByRation((ArrayList) spoRationList);
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("承销商配售信息插入", e);
			return "error";
		}
	}

	// 承销商配售信息修改(暂不用)
	@RequestMapping(value = "/updateUnderwriterRationInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateUnderwriterRationInfo(@RequestBody List<SpoRation> spoRationList) {
		logger.info("承销商配售信息修改");
		int result1 = 0;
		try {
			Long sum1 = 0L;
			String spoid = spoRationList.get(0).getSpoid();
			long counts = spoService.circulation(spoid).getSpoCounts();
			logger.info("更新增发总量：" + counts);
			for (SpoRation spoRation : spoRationList) {
				String brokerid = spoRation.getBrokerid();
				String firmid = spoService.getFirmid(brokerid);
				String firmname = spoService.getFirmname(firmid);
				spoRation.setFirmname(firmname);
				spoRation.setFirmid(firmid);
				spoRation.setSalesid(brokerid);
				// 获取以配售总和
				BigDecimal proportion = spoRation.getSalesAllocationratio();
				logger.info("更新承销商配售比例：" + proportion);
				long sum = (long) (counts * (proportion.doubleValue() / 100));
				logger.info("更新承销商配售总数：" + sum);
				spoRation.setRationcounts(sum);
				sum1 += sum;
				result1 += spoService.updateByRation(spoRation);
			}
			Long balance = counts - sum1;
			logger.info("更新共计和：" + sum1);
			int result2 = spoService.updatePlscingNum(sum1, balance, spoid);

			if (result1 >= 1 && result2 >= 1) {
				return "success";
			} else {
				return "fail";
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("承销商配售信息修改", e);
			return "error";
		}
	}

	// 散户手动配
	@RequestMapping(value = "/orderBalance")
	@ResponseBody
	public boolean orderBalance() {
		try {
			taskService.placing();
		} catch (Exception e) {
			logger.error("orderBalance error:", e);
			return false;
		}
		return true;
	}

	/**
	 * 查询增发的货款记录
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryIncreasePublishGoods")
	@ResponseBody
	public String queryIncreasePublishGoods(@RequestParam("page") String pageNo,
			@RequestParam("rows") String pageSize, HttpServletRequest request) throws Exception {

		PayFlow payFlow = new PayFlow();
		payFlow.setPayee(request.getParameter("payee"));
		payFlow.setCommodityId(request.getParameter("commodityId"));
		long count = payFlowService.queryIncreasePublishGoodsForCount(payFlow);
		List<PayFlow> dataList = new ArrayList<PayFlow>();
		if (count > 0) {
			dataList = payFlowService.queryIncreasePublishGoodsForPage(pageNo, pageSize, payFlow);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal(new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}

	/**
	 * 付款
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/pay")
	@ResponseBody
	public String pay(HttpServletRequest request) {

		PayFlow payFlow = new PayFlow();
		payFlow.setId(Long.valueOf(request.getParameter("id")));
		payFlow.setUpdateUser(getLoginUserId(request));
		try {
			payFlowService.pay(payFlow);
		} catch (Exception e) {
			logger.error("pay error:" + e);
			return "error";
		}
		return "success";
	}

	private String getLoginUserId(HttpServletRequest request) {
		UserManageVO user = (UserManageVO) request.getSession().getAttribute("CurrentUser");
		if (user != null) {
			return user.getUserID();
		}
		return "nologin";
	}

	/**
	 * 查询持仓流水
	 * 
	 * @param pageNo
	 * @param pageSize
	 * @param request
	 */
	@RequestMapping(value = "/queryPositionFlow")
	@ResponseBody
	public String queryPositionFlow(@RequestParam("page") String pageNo,
			@RequestParam("rows") String pageSize, HttpServletRequest request) throws Exception {
		PositionFlow positionFlow = new PositionFlow();
		positionFlow.setBusinessCode(ChargeConstant.BusinessType.INCREASE_PUBLISH.getCode());
		positionFlow.setState(PositionConstant.FlowState.turn_goods.getCode());
		positionFlow.setCommodityId(request.getParameter("commodityId"));
		positionFlow.setFirmId(request.getParameter("firmId"));
		long count = positionService.queryFlowForCount(positionFlow);
		List<PositionFlow> dataList = new ArrayList<PositionFlow>();
		if (count > 0) {
			dataList = positionService.queryFlowForPage(pageNo, pageSize, positionFlow);
		}
		ResponseResult result = new ResponseResult();
		result.setTotal(new Long(count).intValue());
		result.setRows(dataList);
		return JSON.json(result);
	}

	/**
	 * 查询减持仓设置
	 * 
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryReduce")
	@ResponseBody
	public String queryReduce(HttpServletRequest request) throws Exception {

		PositionReduce positionReduce = new PositionReduce();
		positionReduce.setPositionFlowId(Long.valueOf(request.getParameter("positionFlowId")));
		positionReduce.setCommodityId(request.getParameter("commodityId"));
		List<PositionReduce> dataList = positionService.queryReduceForList(positionReduce);
		ResponseResult result = new ResponseResult();
		result.setTotal(dataList.size());
		result.setRows(dataList);
		return JSON.json(result);
	}

	/**
	 * 跳转到减持设置页面
	 * 
	 * @param request
	 * @param model
	 */
	@RequestMapping(value = "/reduce")
	public String reduce(HttpServletRequest request, Model model) {
		String positionFlowId = request.getParameter("positionFlowId");
		model.addAttribute("positionFlowId", positionFlowId);
		return "app/SPO/reduce";
	}

	/**
	 * 跳转到 新增减持仓页面
	 * 
	 * @param request
	 * @param model
	 */
	@RequestMapping(value = "/addReduce")
	public String addReduce(HttpServletRequest request, Model model) {
		Long positionFlowId = Long.valueOf(request.getParameter("positionFlowId"));
		PositionFlow flow = positionService.findFlow(positionFlowId);
		model.addAttribute("flow", flow);

		return "app/SPO/add_reduce";
	}

	/**
	 * 删除减持仓设置
	 * 
	 * @param request
	 * @param model
	 */
	@RequestMapping(value = "/deleteReduce")
	@ResponseBody
	public String deleteReduce(HttpServletRequest request, Model model) {
		try {
			Long id = Long.valueOf(request.getParameter("id"));
			PositionReduce param = new PositionReduce();
			param.setId(id);
			param.setUpdateUser(getLoginUserId(request));
			positionService.deletePositionReduce(param);
		} catch (Exception e) {
			logger.error("deleteReduce error:" + e);
			return "error";
		}
		return "success";
	}

	/**
	 * 保存 减持仓设置
	 * 
	 * @param request
	 * @param model
	 */
	@RequestMapping(value = "/saveReduce")
	@ResponseBody
	public String saveReduce(HttpServletRequest request, Model model) {
		try {
			Long positionFlowId = Long.valueOf(request.getParameter("positionFlowId"));
			String reduceDate = request.getParameter("reduceDate");
			BigDecimal ratio = new BigDecimal(request.getParameter("ratio"));
			String reduceqty = request.getParameter("reduceqty");
			//验证输入的减持比例
			PositionReduce positionReduce = new PositionReduce();
			positionReduce.setPositionFlowId(positionFlowId);
			List<PositionReduce> dataList = positionService.queryReduceForList(positionReduce);
			BigDecimal ratioSum = new BigDecimal("0");
			if (dataList != null && !dataList.isEmpty()) {
				for (PositionReduce item : dataList) {
					ratioSum = ratioSum.add(item.getRatio());
				}
			}
			;
			if (ratioSum.add(ratio).intValue() > 100) {
				return "001";
			}
			;

			PositionReduce param = new PositionReduce();
			param.setPositionFlowId(positionFlowId);
			param.setReduceDate(DateUtils.parseDate(reduceDate, "yyyy-MM-dd"));
			param.setRatio(ratio);
			param.setReduceqty(Long.valueOf((reduceqty)));
			param.setCreateUser(getLoginUserId(request));
			positionService.savePositionReduce(param);
		} catch (Exception e) {
			logger.error("saveReduce error:" + e);
			return "error";
		}
		return "success";
	}
}
