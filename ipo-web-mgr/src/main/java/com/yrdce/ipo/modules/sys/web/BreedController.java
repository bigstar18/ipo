package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.web.BaseController;
import com.yrdce.ipo.modules.sys.service.IpoCommConfService;
import com.yrdce.ipo.modules.sys.service.MBreedService;
import com.yrdce.ipo.modules.sys.service.VIpoABreedService;
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
public class BreedController extends BaseController {
	
	static Logger log = org.slf4j.LoggerFactory.getLogger(BreedController.class);
	
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
	@RequestMapping(value = "/findIpoABreeds", method = RequestMethod.GET)
	@ResponseBody
	public String findIpoABreeds(@RequestParam("page") String page, @RequestParam("rows") String rows) throws IOException {
		log.info("分页查询品种列表");
		try {
			List<VIpoABreed> tlist = new ArrayList<VIpoABreed>();
			tlist = vIpoABreedService.findIpoABreedsByPage(page, rows);
			int totalnums = vIpoABreedService.getTotalIpoABreeds();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			//System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
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
		List<MBreed> Mlist = new ArrayList<MBreed>();
		Mlist = mBreedservice.findAll();
		ResponseResult result = new ResponseResult();
		result.setRows(Mlist);
		return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
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
	public String findBreedByName(HttpServletRequest request,HttpServletResponse response,@RequestParam("breedname") String name,
			@RequestParam("page") String page, @RequestParam("rows") String rows) throws IOException {
		log.info("根据品名模糊查询");
		try {
		String	breedName = java.net.URLDecoder.decode(name,"UTF-8");   
		List<VIpoABreed> blist = new ArrayList<VIpoABreed>();
		blist = vIpoABreedService.findIpoABreedsByName(breedName, page, rows);
		int totalnums = vIpoABreedService.getTotalIpoABreedsByName(breedName);
		ResponseResult result = new ResponseResult();
		result.setTotal(totalnums);
		result.setRows(blist);
		return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
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
	public String addBreed(VIpoABreed vipoabreed) throws IOException {
		log.info("增加一个品种");
		try {
			vIpoABreedService.addBreed(vipoabreed);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
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
	public String updateBreed(VIpoABreed vipoabreed) throws IOException {
		log.info("修改一个品种");
		try {
			vIpoABreedService.updateBreed(vipoabreed);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
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
	public String deleteBreed(@RequestParam("breedid") String breedid) throws IOException {
		log.info("删除品种");
		try {
			int totalnum=ipoCommConfService.getTotalIpoCommsByBreedid(Long.parseLong(breedid));
			if(totalnum==0){
				vIpoABreedService.deleteBreed(Long.parseLong(breedid));
				return "true";
			}
			return "false";
		} catch (Exception e) {
			e.printStackTrace();
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
	@RequestMapping(value = "/findExsitIds" ,method = RequestMethod.GET)
	@ResponseBody
	public String findExsitIds(@RequestParam("breedid") String breedid) throws IOException {
		log.info("查询已配置IPO信息的品种ID");
		try {
			Long bid=Long.parseLong(breedid);
			List<VIpoABreed> blist = new ArrayList<VIpoABreed>();
			blist=vIpoABreedService.findAll();
			for(int i=0;i<blist.size();i++){
				if(bid.equals(blist.get(i).getBreedid())){
					return "0";//该品种ID已存在
				}
			}
			return "1";//新增的品种ID
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
	@RequestMapping(value = "/findExsitCommIds" ,method = RequestMethod.GET)
	@ResponseBody
	public String findExsitCommIds(@RequestParam("commoidtyid") String commid) throws IOException {
		log.info("查询已存在的商品ID");
		try {
			
			List<String> idlist = ipoCommConfService.findIpoCommConfIds();
			for(int i=0;i<idlist.size();i++){
				if(commid.equals(idlist.get(i))){
					return "0";//该商品ID已存在
				}
			}
			return "1";//新增的商品ID
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
	@RequestMapping(value = "/findCommsByBreedId" ,method = RequestMethod.GET)
	@ResponseBody
	public String findCommsByBreedId(@RequestParam("breedid") String breedid,@RequestParam("page") String page, @RequestParam("rows") String rows) throws IOException {
		log.info("查询对应商品列表");
		try {
			Long Breedid=Long.parseLong(breedid);
			List<VIpoCommConf> comlist=ipoCommConfService.findIpoCommConfByBreedid(Breedid, page, rows);
			int totalnum=ipoCommConfService.getTotalIpoCommsByBreedid(Breedid);
			ResponseResult result = new ResponseResult();
			result.setRows(comlist);
			result.setTotal(totalnum);
			System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
	/**
	 * 增加商品
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/addCommodity" ,method = RequestMethod.POST)
	@ResponseBody
	public void addCommodity(VIpoCommConf ipocomm) throws IOException {
		log.info("新增商品");
		try {
		ipoCommConfService.addCommodity(ipocomm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改商品
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/updateCommodity" ,method = RequestMethod.POST)
	@ResponseBody
	public void updateCommodity(VIpoCommConf ipocomm) throws IOException {
		log.info("修改商品");
		try {
		ipoCommConfService.updateCommodity(ipocomm);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
