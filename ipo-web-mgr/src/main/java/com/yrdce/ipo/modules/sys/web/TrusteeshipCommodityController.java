package com.yrdce.ipo.modules.sys.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yrdce.ipo.modules.sys.service.TrusteeshipCommodityService;

/**
 * 托管商品
 * @author wq
 *
 */
@Controller
@RequestMapping("/trusteeshipCommodityController")
public class TrusteeshipCommodityController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	private TrusteeshipCommodityService trusteeshipCommodityService;
	
	
	
	
	
	
	
}
