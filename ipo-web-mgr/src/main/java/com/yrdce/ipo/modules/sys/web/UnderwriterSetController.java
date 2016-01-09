package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.UnderwriterSubscribeService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.UnderwriterSubscribe;

/**
 * 承销设置
 * 
 * @author chenjing
 *
 */
@Controller
@RequestMapping("UnderwriterSetController")
public class UnderwriterSetController {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(UnderwriterSetController.class);

	@Autowired
	private UnderwriterSubscribeService underwritersubscribeService;

	/**
	 * 分页返回承销设置
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findUnderwriterSet", method = RequestMethod.POST)
	@ResponseBody
	public String findUnderwriterSet(@RequestParam("page") String page,
			@RequestParam("rows") String rows, UnderwriterSubscribe example)
			throws IOException {
		log.info("分页查询承销设置");
		try {
			if (example != null) {
				List<UnderwriterSubscribe> list = underwritersubscribeService
						.getInfosByPage(page, rows, example);
				int totalnums = underwritersubscribeService
						.getQueryNum(example);
				ResponseResult result = new ResponseResult();
				result.setTotal(totalnums);
				result.setRows(list);
				log.info(JSON.json(result));
				return JSON.json(result);
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
