package com.yrdce.ipo.modules.sys.web;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yrdce.ipo.common.security.shiro.session.SessionDAO;
import com.yrdce.ipo.common.web.BaseController;
import com.yrdce.ipo.modules.sys.service.CommodityService;
import com.yrdce.ipo.modules.sys.vo.Commodity;


/**
 * 查询商品Controller
 * 
 * @author ThinkGem
 * @version 2013-5-31
 */
@Controller
@RequestMapping("CommodityController") 
public class CommodityController extends BaseController {

	@Autowired
	private SessionDAO sessionDAO;
	
	private CommodityService commodityService;  
   
    public CommodityService getCommodityService() {
		return commodityService;
	}

    @Autowired
	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	/**  
     * 分页返回商品列表
     * @param   
     * @return  
     */    
    @RequestMapping(value="/ipo/findComms", method = RequestMethod.GET)    
    @ResponseBody    
    public List<Commodity> findComms(String page,String rows){    
        return commodityService.findCommList(page, rows);
    }
	 
    
 
	
}
