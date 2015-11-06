package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.web.BaseController;
import com.yrdce.ipo.modules.sys.service.CommodityService;
import com.yrdce.ipo.modules.sys.service.DisplayService;
import com.yrdce.ipo.modules.sys.service.DistributionService;
import com.yrdce.ipo.modules.sys.service.Purchase;
import com.yrdce.ipo.modules.sys.vo.Commodity;
import com.yrdce.ipo.modules.sys.vo.Display;
import com.yrdce.ipo.modules.sys.vo.Distribution;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;


/**
 * 查询商品Controller
 * 
 * @author ThinkGem
 * @version 2013-5-31
 */
@Controller
@RequestMapping("CommodityController") 
public class CommodityController extends BaseController {

	   static Logger log = Logger.getLogger(CommodityController.class);
	 
	
	@Autowired
	private CommodityService commodityService;  
	
	@Autowired
	private Purchase    purchase;
	
	@Autowired
	private DisplayService   displayService;
	
	@Autowired
	private DistributionService distributionService;
   
    public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}
	
	 public Purchase getPurchase() {
		return purchase;
	}

	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	
	public DisplayService getDisplayService() {
		return displayService;
	}

	public void setDisplayService(DisplayService displayService) {
		this.displayService = displayService;
	}

	public DistributionService getDistributionService() {
		return distributionService;
	}

	public void setDistributionService(DistributionService distributionService) {
		this.distributionService = distributionService;
	}
	
    /**  
     * 分页返回商品列表
     * @param
     * @return
     * @throws IOException 
     */    
    @RequestMapping(value="/findComms", method = RequestMethod.GET)  
    @ResponseBody    
    public String findCommsx(@RequestParam("page") String page,@RequestParam("rows") String rows) throws IOException{    
    	log.info("分页查询发售商品信息");   
    	List<Commodity>  clist=new ArrayList<Commodity>();
    	clist=commodityService.findCommList(page, rows);
    	int totalnums=commodityService.getAllComms();
        ResponseResult result = new ResponseResult();
        result.setTotal(totalnums);
        result.setRows(clist);
        System.out.println(JSON.json(result));
        return JSON.json(result);
    }
    
    /**  
     * 异步刷新获取商品和用户详细信息
     * @param
     * @return
     * @throws IOException 
     */    
    @RequestMapping(value="/getInfos", method = RequestMethod.GET)  
    @ResponseBody    
    public String getInfos(@RequestParam("commodityid") String commodityid , @RequestParam("userid") String userid) throws IOException {
    	log.info("获取商品和用户信息");   
    	Display display=displayService.display(userid, commodityid);
    	if(display==null){
    		return "";
    	}
    	return JSON.json(display);
    }
	 
    /**  
     * 申购
     * @param
     * @return
     * @throws IOException 
     */    
    @RequestMapping(value="/purchApply", method = RequestMethod.GET )  
    @ResponseBody    
    public String purchApply(@RequestParam("commodityid") String commodityid , @RequestParam("userid") String userid,
    		@RequestParam("quantity") String quantity) {
    	log.info("调用申购服务"+userid+"  "+commodityid+" "  +quantity);   
    	return purchase.apply(userid, commodityid, Integer.parseInt(quantity))+"";
    }
    
  
    /**  
     * 分页配号查询
     * @param
     * @return
     * @throws IOException 
     */    
    @RequestMapping(value="/findApplyNums", method = RequestMethod.GET , produces = "text/html;charset=UTF-8")  
    @ResponseBody    
    public String findApplyNums(String page,String rows) throws IOException{    
    	log.info("分页查询客户配号信息");   
    	List<Distribution>  dlist=new ArrayList<Distribution>();
    	dlist=distributionService.getDistriList(page, rows);
    	int totalnums=distributionService.getAllDistris();
        ResponseResult result = new ResponseResult();
        result.setTotal(totalnums);
        result.setRows(dlist);
        return JSON.json(result);    	
    }
    
}
