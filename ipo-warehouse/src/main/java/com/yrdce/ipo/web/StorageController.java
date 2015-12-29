package com.yrdce.ipo.web;

import java.io.IOException;
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
import com.yrdce.ipo.modules.sys.service.CommodityService;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.warehouse.service.IpoStorageService;
import com.yrdce.ipo.modules.warehouse.vo.IpoStorageVo;
import com.yrdce.ipo.modules.warehouse.vo.StorageUnionVo;


/**
 * 入库申请Controller
 * 
 * @author 李伟东
 * @version 2015.12.20
 */
@Controller
@RequestMapping("StorageController")
public class StorageController {
	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(StorageController.class);
	@Autowired
	private IpoStorageService ipoStorageService;
	@Autowired
	private CommodityService commodityService;
	
	
	//入库单添加视图
	@RequestMapping(value = "/AddStorageView", method = RequestMethod.GET)
	public String AddStorageView(HttpServletRequest request, HttpServletResponse response,Model model){
		log.info("入库单添加页");
		List<String> names = commodityService.queryNames();
		model.addAttribute("namelist", names);
		return "app/storage/addstorageaudit";
	}
	
	@RequestMapping(value = "/Add")
	public String Add(HttpServletRequest request, HttpServletResponse response){
		log.info("入库单添加");
		Date  date = new Date();
		if(request.getParameter("commodityid") != null && request.getParameter("commodityid") != ""){
		/*VIpoCommConf vIpoCommConf = ipoCommConfService.getVIpoCommConfByCommid(request.getParameter("commodityid"));*/
		IpoStorageVo ipoStorageVo = new IpoStorageVo();
		ipoStorageVo.setCommodityid(request.getParameter("commodityid"));
		ipoStorageVo.setStorageid(request.getParameter("storageid"));
		ipoStorageVo.setStoragenum(Long.parseLong(request.getParameter("storagenum")));
		ipoStorageVo.setStoragestate(1);
		ipoStorageVo.setStoragedate(date);
		ipoStorageService.insert(ipoStorageVo);
		return "true";
		}
		return "error";
	}
	
	//入库单列表页视图
	@RequestMapping(value = "/ToStorageView", method = RequestMethod.GET)
	public String ToStorageView(HttpServletRequest request, HttpServletResponse response){
		log.info("入库单列表页");
		return "app/storage/storageApplication";
	}
	
	
	//入库单列表审核视图
		@RequestMapping(value = "/ToStorageAudit")
		public String ToStorageAudit(HttpServletRequest request, HttpServletResponse response){
			log.info("入库单列表页");
			return "app/storage/storageaudit";
		}
	
	//入库单审核页视图
		@RequestMapping(value = "/ToAuditView")
		public String ToAuditView(HttpServletRequest request, HttpServletResponse response,String storageid,Model model){
			log.info("入库单审核页");
			StorageUnionVo storageUnionVo = ipoStorageService.selectUnionById(storageid);
			model.addAttribute("storageUnionVo", storageUnionVo);
			return "app/storage/auditoperate";
		}
	
	@RequestMapping(value = "/ListStorage")
	@ResponseBody
	public String ListStorage(@RequestParam("page") String page,@RequestParam("rows")  String rows, StorageUnionVo storageUnionVo){
		log.info("入库单列表页查询");
		if(storageUnionVo == null){
			storageUnionVo =  new StorageUnionVo();
		}
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		Integer curpage = Integer.parseInt(page);
		Integer pagesize = Integer.parseInt(rows);
		List<StorageUnionVo> unionVos = ipoStorageService.queryVos((curpage - 1) * pagesize + 1, curpage * pagesize, storageUnionVo);
		int totalnum = ipoStorageService.countStorage();
		ResponseResult result = new ResponseResult();
		result.setTotal(totalnum);
		result.setRows(unionVos);
		try {
			return JSON.json(result);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@RequestMapping(value = "/pass")
	@ResponseBody
	public String modifyUnion(String storageid){
		IpoStorageVo ipoStorageVo = ipoStorageService.selectByPrimaryKey(storageid);
		if(ipoStorageVo != null){
			ipoStorageVo.setStoragestate(2);
			ipoStorageService.updateByPrimaryKey(ipoStorageVo);
		return "true";
		}
		return null;
		
	}
	
	@RequestMapping(value = "/back")
	@ResponseBody
	public String updateUnion(String storageid){
		IpoStorageVo ipoStorageVo = ipoStorageService.selectByPrimaryKey(storageid);
		if(ipoStorageVo != null){
			ipoStorageVo.setStoragestate(3);
			ipoStorageService.updateByPrimaryKey(ipoStorageVo);
		return "true";
		}
		return null;
		
	}
	
	
	@RequestMapping(value = "/auto")
	@ResponseBody
	public String auto(String commodityid){
		Commodity commodity = commodityService.queryByComid(commodityid);
		if(commodity != null){
		try {
			return JSON.json(commodity);
		} catch (IOException e) {
			e.printStackTrace();
		}
		}
		return null;
	}
	
	@RequestMapping(value = "/add")
	@ResponseBody
	public String add( HttpServletRequest request,HttpServletResponse response){
		IpoStorageVo ipoStorageVo = new IpoStorageVo();
		Date date = new Date();
		ipoStorageVo.setStorageid(request.getParameter("storageid"));
		ipoStorageVo.setCommodityid(request.getParameter("commodityid"));
		ipoStorageVo.setStoragenum(Long.parseLong(request.getParameter("storagenum")));
		ipoStorageVo.setStoragestate(1);
		ipoStorageVo.setStoragedate(date);
		ipoStorageService.insert(ipoStorageVo);
		return "true";
		
	}
}
