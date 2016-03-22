package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.math.BigDecimal;
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
import com.yrdce.ipo.modules.sys.service.MBreedService;
import com.yrdce.ipo.modules.sys.service.VIpoABreedService;
import com.yrdce.ipo.modules.sys.util.WriteLog;
import com.yrdce.ipo.modules.sys.vo.MBreed;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.VIpoABreed;
import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;

/**
 * 品种管理Controller
 * 
 * @author ThinkGem
 * @version 2013-5-31
 */
@Controller
@RequestMapping("BreedController")
public class BreedController {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(BreedController.class);

	@Autowired
	private VIpoABreedService vIpoABreedService;

	@Autowired
	private MBreedService mBreedservice;

	@Autowired
	private IpoCommConfService ipoCommConfService;

	public VIpoABreedService getvIpoABreedService() {
		return vIpoABreedService;
	}

	public void setvIpoABreedService(VIpoABreedService vIpoABreedService) {
		this.vIpoABreedService = vIpoABreedService;
	}

	public MBreedService getmBreedservice() {
		return mBreedservice;
	}

	public void setmBreedservice(MBreedService mBreedservice) {
		this.mBreedservice = mBreedservice;
	}

	public IpoCommConfService getIpoCommConfService() {
		return ipoCommConfService;
	}

	public void setIpoCommConfService(IpoCommConfService ipoCommConfService) {
		this.ipoCommConfService = ipoCommConfService;
	}

	/**
	 * 分页返回品种列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findIpoABreeds", method = RequestMethod.POST)
	@ResponseBody
	public String findIpoABreeds(@RequestParam("page") String page,
			@RequestParam("rows") String rows) throws IOException {
		log.info("分页查询品种列表");
		try {
			List<VIpoABreed> tlist = vIpoABreedService.findIpoABreedsByPage(
					page, rows);
			int totalnums = vIpoABreedService.getTotalIpoABreeds();
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
	 * 品种下拉框
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/selectBreed", method = RequestMethod.GET)
	@ResponseBody
	public String selectBreed() throws IOException {
		log.info("查询所有分配到IPO权限下的品种至下拉框");
		try {
			List<MBreed> Mlist = mBreedservice.findAll();
			ResponseResult result = new ResponseResult();
			result.setRows(Mlist);
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 品名模糊查询
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findBreedByName", method = RequestMethod.POST)
	@ResponseBody
	public String findBreedByName(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam("breedname") String name,
			@RequestParam("page") String page, @RequestParam("rows") String rows)
			throws IOException {
		log.info("根据品名模糊查询");
		try {
			String breedName = java.net.URLDecoder.decode(name, "UTF-8");
			List<VIpoABreed> blist = vIpoABreedService.findIpoABreedsByName(
					breedName, page, rows);
			int totalnums = vIpoABreedService
					.getTotalIpoABreedsByName(breedName);
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(blist);
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 增加一个品种
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addBreed", method = RequestMethod.POST)
	@ResponseBody
	public String addBreed(VIpoABreed vipoabreed, HttpSession session)
			throws IOException {
		log.info("增加一个品种");
		log.debug(vipoabreed.toString());
		try {
			int num = vIpoABreedService.addBreed(vipoabreed);
			if (num != 0) {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_BREED_CATALOGID,
						"ipo新增品种成功", WriteLog.SYS_LOG_OPE_SUCC, "", session);
				return "true";
			} else {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_BREED_CATALOGID,
						"ipo新增品种失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session);
				return "false";
			}
		} catch (Exception e) {
			log.error("新增品种error:", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_BREED_CATALOGID,
					"ipo新增品种失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session);
			return "error";
		}
	}

	/**
	 * 修改一个品种
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateBreed", method = RequestMethod.POST)
	@ResponseBody
	public String updateBreed(VIpoABreed vipoabreed, HttpSession session)
			throws IOException {
		log.info("修改一个品种");
		try {
			int num = vIpoABreedService.updateBreed(vipoabreed);
			if (num != 0) {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_BREED_CATALOGID,
						"ipo修改品种成功", WriteLog.SYS_LOG_OPE_SUCC, "", session);
				return "true";
			} else {
				WriteLog.writeOperateLog(WriteLog.SYS_LOG_BREED_CATALOGID,
						"ipo修改品种失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session);
				return "false";
			}
		} catch (Exception e) {
			log.error("修改品种error:", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_BREED_CATALOGID,
					"ipo修改品种失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session);
			return "error";
		}
	}

	/**
	 * 删除一个品种(此品种下无商品)
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/deleteBreed", method = RequestMethod.POST)
	@ResponseBody
	public String deleteBreed(@RequestParam("breedid") String breedid,
			HttpSession session) throws IOException {
		log.info("删除品种");
		try {

			int totalnum = ipoCommConfService.getTotalIpoCommsByBreedid(Long
					.parseLong(breedid));
			if (totalnum == 0) {
				int num = vIpoABreedService
						.deleteBreed(Long.parseLong(breedid));
				if (num != 0) {
					WriteLog.writeOperateLog(WriteLog.SYS_LOG_BREED_CATALOGID,
							"ipo删除品种成功", WriteLog.SYS_LOG_OPE_SUCC, "", session);
					return "true";
				} else {
					WriteLog.writeOperateLog(WriteLog.SYS_LOG_BREED_CATALOGID,
							"ipo删除品种失败", WriteLog.SYS_LOG_OPE_FAILURE, "",
							session);
					return "false";
				}
			}
			return "false";
		} catch (Exception e) {
			log.error("修改品种error:", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_BREED_CATALOGID,
					"ipo删除品种失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session);
			return "error";
		}
	}

	/**
	 * 查询已配置IPO信息的品种ID
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findExsitIds", method = RequestMethod.GET)
	@ResponseBody
	public String findExsitIds(@RequestParam("breedid") String breedid)
			throws IOException {
		log.info("查询已配置IPO信息的品种ID");
		try {
			Long bid = Long.parseLong(breedid);
			List<VIpoABreed> blist = vIpoABreedService.findAll();
			for (int i = 0; i < blist.size(); i++) {
				if (bid.equals(blist.get(i).getBreedid())) {
					return "0";// 该品种ID已存在
				}
			}
			return "1";// 新增的品种ID
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
	}

	/**
	 * 查询已存在的商品ID
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findExsitCommIds", method = RequestMethod.GET)
	@ResponseBody
	public String findExsitCommIds(@RequestParam("commodityid") String commid)
			throws IOException {
		log.info("查询已存在的商品ID");
		try {

			List<String> idlist = ipoCommConfService.findIpoCommConfIds();
			for (int i = 0; i < idlist.size(); i++) {
				if (commid.equals(idlist.get(i))) {
					return "0";// 该商品ID已存在
				}
			}
			return "1";// 新增的商品ID
		} catch (Exception e) {
			e.printStackTrace();
			return "2";
		}
	}

	/**
	 * 查询对应商品列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findCommsByBreedId", method = RequestMethod.POST)
	@ResponseBody
	public String findCommsByBreedId(@RequestParam("breedid") String breedid,
			@RequestParam("page") String page, @RequestParam("rows") String rows)
			throws IOException {
		log.info("查询对应商品列表");
		try {
			Long Breedid = Long.parseLong(breedid);
			List<VIpoCommConf> comlist = ipoCommConfService
					.findIpoCommConfByBreedid(Breedid, page, rows);
			int totalnum = ipoCommConfService
					.getTotalIpoCommsByBreedid(Breedid);
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
	 * 分页查询所有商品列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findAllComms", method = RequestMethod.GET)
	@ResponseBody
	public String findAllComms(@RequestParam("page") String page,
			@RequestParam("rows") String rows) throws IOException {
		log.info("查询所有商品列表");
		try {
			List<VIpoCommConf> comlist = ipoCommConfService
					.findIpoCommConfsByPage(page, rows);
			int totalnum = ipoCommConfService.getAllComms();
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
	 * 增加商品
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addCommodity", method = RequestMethod.POST)
	@ResponseBody
	public String addCommodity(VIpoCommConf ipocomm, HttpSession session)
			throws IOException {
		log.info("新增商品");
		try {
			if (ipocomm != null) {
				ipocomm.setStatus(new BigDecimal(1));
				ipocomm.setDeliveryProp((short) 2);// 表示未配置交收属性
				ipocomm.setCodedelivery(new BigDecimal(1));
				// ipocomm.setNonissuereg(new BigDecimal(1));
				log.debug(ipocomm.toString());
				String result = ipoCommConfService.addCommodity(ipocomm);
				if (result.equals("success")) {
					WriteLog.writeOperateLog(
							WriteLog.SYS_LOG_COMMODITY_CATALOGID, "ipo新增商品成功",
							WriteLog.SYS_LOG_OPE_SUCC, "", session);
					return result;
				}
			}
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_COMMODITY_CATALOGID,
					"ipo新增商品失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session);
			return "false";
		} catch (Exception e) {
			log.error("新增商品error:", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_COMMODITY_CATALOGID,
					"ipo新增商品失败", WriteLog.SYS_LOG_OPE_FAILURE, "", session);
			return "error";
		}
	}

	/**
	 * 修改商品
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateCommodity", method = RequestMethod.POST)
	@ResponseBody
	public String updateCommodity(VIpoCommConf ipocomm, HttpSession session)
			throws IOException {
		log.info("修改商品");
		try {
			if (ipocomm != null) {
				log.debug(ipocomm.toString());
				String result = ipoCommConfService.updateCommodity(ipocomm);
				if (result.equals("success")) {
					WriteLog.writeOperateLog(
							WriteLog.SYS_LOG_COMMODITY_CATALOGID, "ipo修改商品"
									+ ipocomm.getCommodityid() + "成功",
							WriteLog.SYS_LOG_OPE_SUCC, "", session);
					return result;
				}
			}
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_COMMODITY_CATALOGID,
					"ipo修改商品" + ipocomm.getCommodityid() + "失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", session);
			return "false";
		} catch (Exception e) {
			log.error("新增商品error:", e);
			WriteLog.writeOperateLog(WriteLog.SYS_LOG_COMMODITY_CATALOGID,
					"ipo修改商品" + ipocomm.getCommodityid() + "失败",
					WriteLog.SYS_LOG_OPE_FAILURE, "", session);
			return "error";
		}
	}

}
