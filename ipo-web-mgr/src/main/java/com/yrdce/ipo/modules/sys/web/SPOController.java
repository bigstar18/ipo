package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.SPOService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.SpoCommoditymanmaagement;
import com.yrdce.ipo.modules.sys.vo.SpoRation;

@Controller
@RequestMapping("SPOController")
public class SPOController {
	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SPOController.class);
	@Autowired
	private SPOService spoService;

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
	public String getAllSPOInfo(@RequestParam("page") String page, @RequestParam("rows") String rows, SpoCommoditymanmaagement spoComm)
			throws IOException {
		logger.info("获取商品增发信息");
		try {
			// SpoCommoditymanmaagement spoComm = new SpoCommoditymanmaagement();
			// SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// logger.info(communityId);
			// logger.info(registerDate);
			// logger.info(spoDate);
			// logger.info(ipoDate);
			// logger.info(rationType);
			// logger.info(rationSate);
			// if (!communityId.equals("")) {
			// spoComm.setCommunityId(communityId);
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
			System.out.println(resultJson);
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
			@RequestParam("communityId") String communityId, @RequestParam("registerDate") String registerDate) throws IOException {
		logger.info("获取定向配售信息");
		try {
			SpoCommoditymanmaagement spoComm = new SpoCommoditymanmaagement();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (!communityId.equals("")) {
				spoComm.setCommunityId(communityId);
			}
			if (!registerDate.equals("")) {
				Date date = sdf.parse(registerDate);
				spoComm.setRegisterDate(date);
			}
			List<SpoRation> tempList = spoService.getRationInfo(page, rows, spoComm);
			int counts = spoService.rationCounts(spoComm);
			ResponseResult responseResult = new ResponseResult();
			responseResult.setRows(tempList);
			responseResult.setTotal(counts);
			String resultJson = JSON.json(responseResult);
			System.out.println(resultJson);
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
	public String updateSPOSate(@RequestParam("spoId") String spoId, @RequestParam("rationSate") String rationSate) {
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
			int result1 = 0;
			Long sum1 = 0L;
			String spoid = spoRationList.get(0).getSpoid();
			long counts = spoService.circulation(spoid);
			for (SpoRation spoRation : spoRationList) {
				spoRation.setFirmid(spoRation.getBrokerid());
				spoRation.setSalesid(spoRation.getBrokerid());
				// 获取以配售总和
				long proportion = spoRation.getSalesAllocationratio();
				long sum = (long) (counts * ((double) proportion / 100));
				spoRation.setRationcounts(sum);
				sum1 = +sum;

				result1 += spoService.insertByRation(spoRation);
			}
			// 更新已配售和未配售
			Long balance = counts - sum1;
			int result2 = spoService.updatePlscingNum(sum1, balance, spoid);

			if (result1 >= 1 && result2 >= 1) {
				return "success";
			} else {
				return "fail";
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.info("承销商配售信息插入", e);
			return "error";
		}
	}

	// 承销商配售信息修改
	@RequestMapping(value = "/updateUnderwriterRationInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String updateUnderwriterRationInfo(@RequestBody List<SpoRation> spoRationList) {
		logger.info("承销商配售信息修改");
		int result1 = 0;
		try {
			Long sum1 = 0L;
			String spoid = spoRationList.get(0).getSpoid();
			long counts = spoService.circulation(spoid);
			for (SpoRation spoRation : spoRationList) {
				String brokerid = spoRation.getBrokerid();
				String firmid = spoService.getFirmid(brokerid);
				spoRation.setFirmid(firmid);
				spoRation.setSalesid(brokerid);
				// 获取以配售总和
				long proportion = spoRation.getSalesAllocationratio();
				logger.info("承销商配售比例：" + proportion);
				long sum = (long) (counts * ((double) proportion / 100));
				logger.info("承销商配售总数：" + sum);
				spoRation.setRationcounts(sum);
				sum1 = +sum;
				result1 += spoService.updateByRation(spoRation);
			}
			Long balance = counts - sum1;
			logger.info("共计和：" + sum1);
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
}
