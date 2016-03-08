package com.yrdce.ipo.modules.sys.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("StockController")
public class StockController {
	// protected Logger logger = LoggerFactory.getLogger(getClass());
	// static org.slf4j.Logger log = org.slf4j.LoggerFactory
	// .getLogger(StockController.class);
	//
	// @Autowired
	// private StockTransferrecordsService stockTransferrecordsService;
	//// @Autowired
	//// Integer getTotalNum(StockTransferrecords storage) {
	//// return null;
	//// }
	// /**
	// * 过户记录列表
	// *
	// * @param
	// * @return
	// * @throws IOException
	// */
	// @RequestMapping(value = "/transferRecordList", method =
	// RequestMethod.POST)
	// @ResponseBody
	// public String transferRecordList(
	// @RequestParam("page") String page,
	// @RequestParam("rows") String rows,
	//
	// StockTransferrecords example)
	// throws IOException {
	// log.info("查询过户记录列表");
	// log.debug(example.toString());
	// try {
	//// StockTransferrecords example = new StockTransferrecords();
	//
	// List<StockTransferrecords> tlist = stockTransferrecordsService
	// .findTransferRecord(page, rows, example);
	// Integer totalnums = stockTransferrecordsService.getNums(example);
	// ResponseResult result = new ResponseResult();
	// result.setTotal(totalnums);
	// result.setRows(tlist);
	// log.debug(JSON.json(result));
	// return JSON.json(result);
	// } catch (Exception e) {
	// e.printStackTrace();
	// return "error";
	// }
	// }
	/// **
	// * 跳转到添加过户界面
	// * @param request
	// * @param model
	// * @return
	// */
	// @RequestMapping(value = "/addTransfer")
	// public String addTransfer() {
	//
	// return "app/stockManagement/add_stockTranster";
	// }
	//
	//
	//
	////// 跳转操作
	//// @RequestMapping(value = "/openTransfer")
	//// public String openTransfer() {
	////
	//// return "app/stockManagement/operationTransfer";
	//// }
	//
	// @RequestMapping(value = "/openTransfer")
	// public String openTransfer(HttpServletRequest request,Model model)
	// throws Exception {
	//
	// Long applicationId =
	// Long.parseLong(request.getParameter("applicationId"));
	// StockTransferrecords
	// stockTransferrecords=stockTransferrecordsService.findById(applicationId);
	// model.addAttribute("entity",stockTransferrecords );
	// //角色
	////
	// return "app/stockManagement/operationTransfer";
	// }
	//
	/// **
	// * 增加发行货款跟踪信息
	// *
	// * @param
	// * @return
	// * @throws IOException
	// */
	// @RequestMapping(value = "/addNewTransfer", method = RequestMethod.POST)
	// @ResponseBody
	// public String addNewTransfer(StockTransferrecords example, HttpSession
	// session)
	// throws IOException {
	// log.info("增加发行货款跟踪信息");
	// try {
	// log.debug(example.toString());
	//// String userId = ((UserManageVO) session.getAttribute("CurrentUser"))
	//// .getUserID();
	//// example.setDeleteflag((short) 0);
	//// example.setCreateperson(userId);
	//// example.setCreatedate(new Date());
	//
	// int num = stockTransferrecordsService.insertTransfer(example);
	// if (num == 1) {
	// return "true";
	// }
	// return "false";
	// } catch (Exception e) {
	// e.printStackTrace();
	// return "error";
	// }
	// }
	/// **
	// * 分页返回过户表
	// *
	// * @param
	// * @return
	// * @throws IOException
	// */
	// @RequestMapping(value = "/findAllRecord", method = RequestMethod.POST)
	// @ResponseBody
	// public String findAllStorages(@RequestParam("page") String page,
	// @RequestParam("rows") String rows, StockTransferrecords storage)
	// throws IOException {
	// log.info("分页查询入库单");
	// log.debug(storage.toString());
	// try {
	// List<StockTransferrecords> tlist =
	// stockTransferrecordsService.selectByPage(
	// page, rows, storage);
	// int totalnums = stockTransferrecordsService.getTotalNum(storage);
	// ResponseResult result = new ResponseResult();
	// result.setTotal(totalnums);
	// result.setRows(tlist);
	// log.debug(JSON.json(result));
	// return JSON.json(result);
	// } catch (Exception e) {
	// e.printStackTrace();
	// return "error";
	// }
	// }
	//
	/// **
	// * 删除承销设置信息
	// *
	// * @param
	// * @return
	// * @throws IOException
	// */
	// @RequestMapping(value = "/deleteInfo", method = RequestMethod.POST)
	// @ResponseBody
	// public String deleteInfo(@RequestParam("applicationIds") String
	// applicationIds)
	// throws IOException {
	// log.info("批量删除过户信息:" + applicationIds);
	// return stockTransferrecordsService.deleteInfo(applicationIds);
	// }
	//
	//// 审核
	// @RequestMapping(value = "/update", method = RequestMethod.POST)
	// @ResponseBody
	// public String update(HttpServletRequest request,StockTransferrecords
	// stockTransferrecords)
	// throws IOException {
	// try {
	// stockTransferrecords.setOperator(getloginUserId(request));
	// stockTransferrecordsService.update(stockTransferrecords);
	// return "true";
	// } catch (Exception e) {
	// logger.error("update error:"+e);
	// return "false";
	// }
	//
	// }
	//
	// private String getloginUserId(HttpServletRequest request){
	// UserManageVO user = (UserManageVO)
	// request.getSession().getAttribute("CurrentUser");
	// if(user!=null){
	// return user.getUserID();
	// }
	// return "nologin";
	//
	// }
}
