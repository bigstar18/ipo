package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.modules.sys.service.SPOService;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;
import com.yrdce.ipo.modules.sys.vo.SpoCommoditymanmaagement;

@Controller
@RequestMapping("SPOController")
public class SPOController {
	static org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(SPOController.class);
	@Autowired
	private SPOService spoService;

	@RequestMapping(value = "/insertSPOInfo", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String InsertSPOInfo(SpoCommoditymanmaagement ipospo)throws IOException{
		logger.info("添加商品增发信息");
		try {
			int temp = spoService.insertSPOInfo(ipospo);
			if (temp==1) {
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
	
	
	@RequestMapping(value = "/getIPOCommonity", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String GetIPOCommonity()throws IOException{
		logger.info("获取商品信息");
		String result="";
		try {
			Map<String, String> commonityInfo = spoService.getCommodityidByAll();
			if (commonityInfo.size()!=0) {
				for (Map.Entry<String, String> temp : commonityInfo.entrySet()) {
					String tempStr ="";
					String commId = temp.getKey();
					String commName = temp.getValue();
					tempStr = commName+"("+commId+")"+"|";
					result+=tempStr;
				}
				logger.info(result);
				return result;
			}else{
				return "error";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
	@RequestMapping(value = "/getAllSPOInfo", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String GetAllSPOInfo(@RequestParam("page")String page,
			@RequestParam("rows")String rows,
			@RequestParam("communityId")String communityId,
			@RequestParam("registerDate")String registerDate,
			@RequestParam("spoDate")String spoDate,
			@RequestParam("ipoDate")String ipoDate,
			@RequestParam("rationType")String rationType,
			@RequestParam("rationSate")String rationSate
			)throws IOException{
		logger.info("获取商品增发信息");
		try {
			SpoCommoditymanmaagement spoComm = new SpoCommoditymanmaagement();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			logger.info(communityId);
			logger.info(registerDate);
			logger.info(spoDate);
			logger.info(ipoDate);
			logger.info(rationType);
			logger.info(rationSate);
			if (!communityId.equals("")) {
				spoComm.setCommunityId(communityId);
			}
			if (!registerDate.equals("")) {
				Date date = sdf.parse(registerDate);  
				spoComm.setRegisterDate(date);
			}
			if (!spoDate.equals("")) {
				Date date = sdf.parse(spoDate);
				spoComm.setSpoDate(date);
			}
			if (!ipoDate.equals("")) {
				Date date = sdf.parse(spoDate);
				spoComm.setIpoDate(date);
			}
			if(!rationType.equals("")){
				if(rationType.equals("比例配售")){
					spoComm.setRationType("1");
				}
				if (rationType.equals("定向配售"))
					spoComm.setRationType("2");
			}
			if(!rationSate.equals("")){
				if(rationSate.equals("已增发"))
					spoComm.setRationSate(1);
				if(rationSate.equals("增发失败"))
					spoComm.setRationSate(2);
			}
			logger.info(spoComm.getRationType());
			List<SpoCommoditymanmaagement> tempList = spoService.getSPOList(page, rows, spoComm);
			int counts = spoService.spoCounts();
			ResponseResult responseResult = new ResponseResult();
			responseResult.setRows(tempList);
			responseResult.setTotal(counts);
			String resultJson =JSON.json(responseResult);
			System.out.println(resultJson);
			return resultJson;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
		
}
