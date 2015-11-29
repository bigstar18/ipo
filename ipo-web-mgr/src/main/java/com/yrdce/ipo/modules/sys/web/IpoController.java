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

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.web.BaseController;
import com.yrdce.ipo.modules.sys.service.BrBrokerService;
import com.yrdce.ipo.modules.sys.service.IpoCommConfService;
import com.yrdce.ipo.modules.sys.service.MBreedService;
import com.yrdce.ipo.modules.sys.service.TCommodityService;
import com.yrdce.ipo.modules.sys.service.VIpoABreedService;
import com.yrdce.ipo.modules.sys.vo.MBreed;
import com.yrdce.ipo.modules.sys.vo.VBrBroker;
import com.yrdce.ipo.modules.sys.vo.VIpoABreed;
import com.yrdce.ipo.modules.sys.vo.VIpoCommConf;
import com.yrdce.ipo.modules.sys.vo.VTCommodity;

/**
 * 查询商品Controller
 * 
 * @author ThinkGem
 * @version 2013-5-31
 */
@Controller
@RequestMapping("IpoController")

public class IpoController extends BaseController {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(IpoController.class);

	@Autowired
	private MBreedService mBreedservice;

	@Autowired
	private VIpoABreedService vIpoABreedService;

	@Autowired
	private IpoCommConfService ipoCommConfService;

	@Autowired
	private TCommodityService tCommodityService;

	@Autowired
	private BrBrokerService brBrokerService;

	List<MBreed> Mlist; // 品种列表

	public List<MBreed> getMlist() {
		return Mlist;
	}

	public void setMlist(List<MBreed> mlist) {
		Mlist = mlist;
	}

	List<VBrBroker> Blist; // 发行会员列表

	public List<VBrBroker> getBlist() {
		return Blist;
	}

	public void setBlist(List<VBrBroker> blist) {
		Blist = blist;
	}

	List<VTCommodity> Tlist; // 现货商品列表

	public List<VTCommodity> getTlist() {
		return Tlist;
	}

	public void setTlist(List<VTCommodity> tlist) {
		Tlist = tlist;
	}

	public BrBrokerService getBrBrokerService() {
		return brBrokerService;
	}

	public void setBrBrokerService(BrBrokerService brBrokerService) {
		this.brBrokerService = brBrokerService;
	}

	public TCommodityService gettCommodityService() {
		return tCommodityService;
	}

	public void settCommodityService(TCommodityService tCommodityService) {
		this.tCommodityService = tCommodityService;
	}

	public IpoCommConfService getIpoCommConfService() {
		return ipoCommConfService;
	}

	public void setIpoCommConfService(IpoCommConfService ipoCommConfService) {
		this.ipoCommConfService = ipoCommConfService;
	}

	public MBreedService getmBreedservice() {
		return mBreedservice;
	}

	public void setmBreedservice(MBreedService mBreedservice) {
		this.mBreedservice = mBreedservice;
	}

	public VIpoABreedService getvIpoABreedService() {
		return vIpoABreedService;
	}

	public void setvIpoABreedService(VIpoABreedService vIpoABreedService) {
		this.vIpoABreedService = vIpoABreedService;
	}

	/*
	 * 交易节管理视图
	 */
	@RequestMapping(value = "/tradeTimeManage", method = RequestMethod.GET)
	public String tradeTimeManage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/tradetime/tradeTime_list";
	}

	/*
	 * 品种管理视图
	 */
	@RequestMapping(value = "/CommodityManage", method = RequestMethod.GET)
	public String CommodityManage(HttpServletRequest request, HttpServletResponse response, Model model) {
		return "app/breed/breed_list";
	}

	/*
	 * 商品列表视图
	 */
	@RequestMapping(value = "/CommodityList", method = RequestMethod.GET)
	public String CommodityList(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("breedID") String breedid) {
		request.setAttribute("breedID", breedid);
		return "app/commodity/comm_list";
	}

	/*
	 * 新增品种视图
	 */
	@RequestMapping(value = "/addBreedforward", method = RequestMethod.GET)
	public String addBreedforward(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		request.setAttribute("crud", "create");
		log.info("跳转至新增页面");
		Mlist = mBreedservice.findAll();
		request.setAttribute("Mlist", Mlist);
		request.setAttribute("breedlist", JSON.json(Mlist));
		return "app/breed/breed";
	}

	/*
	 * 修改品种视图
	 */
	@RequestMapping(value = "/updateBreedforward", method = RequestMethod.GET)
	public String updateBreedforward(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("breedID") String breedid)
			throws IOException {
		request.setAttribute("crud", "update");
		log.info("跳转至修改页面");
		VIpoABreed vbreed = vIpoABreedService.getIpoABreed(Long.parseLong(breedid));
		System.out.println(vbreed);
		Mlist = mBreedservice.findAll();
		request.setAttribute("Mlist", Mlist);
		request.setAttribute("entity", vbreed);
		request.setAttribute("breedlist", JSON.json(Mlist));
		return "app/breed/breed";
	}

	/*
	 * 新增商品视图
	 */
	@RequestMapping(value = "/addCommodity", method = RequestMethod.GET)
	public String addCommodity(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam("breedid") String breedid)
			throws IOException {
		log.info("跳转至新增商品页面");
		VIpoABreed ipobreed = vIpoABreedService.getIpoABreed(Long.parseLong(breedid));
		Blist = brBrokerService.findAllPublisher();
		Tlist = tCommodityService.findAllTCommodity();
		request.setAttribute("entity", ipobreed);
		request.setAttribute("Blist", Blist);
		request.setAttribute("Tlist", Tlist);
		return "app/commodity/add_commodity";
	}

	/*
	 * 修改商品视图
	 */
	@RequestMapping(value = "/updateCommodity", method = RequestMethod.GET)
	public String updateCommodity(HttpServletRequest request, HttpServletResponse response, Model model,
			@RequestParam("commodityid") String commodityid, @RequestParam("breedid") String breedid) throws IOException {
		log.info("跳转至修改商品页面");
		VIpoCommConf ipocomm = ipoCommConfService.getVIpoCommConfByCommid(commodityid);
		Blist = brBrokerService.findAllPublisher();
		Tlist = tCommodityService.findAllTCommodity();
		MBreed breed = mBreedservice.getMBreed(Long.parseLong(breedid));
		String breedname = breed.getBreedname();
		request.setAttribute("entity", ipocomm);
		request.setAttribute("breedname", breedname);
		request.setAttribute("Tlist", Tlist);
		request.setAttribute("Blist", Blist);
		return "app/commodity/update_commodity";
	}
}
