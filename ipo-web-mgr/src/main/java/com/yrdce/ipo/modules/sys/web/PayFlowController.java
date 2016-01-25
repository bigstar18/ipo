package com.yrdce.ipo.modules.sys.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yrdce.ipo.modules.sys.service.PayFlowService;
/**
 * 付款流水Controller
 * @author wq 2016-1-21
 *
 */
@Controller
@RequestMapping("/payFlowController")
public class PayFlowController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private PayFlowService payFlowService;
	
	 
	
	
}
