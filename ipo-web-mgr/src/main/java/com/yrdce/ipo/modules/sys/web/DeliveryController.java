package com.yrdce.ipo.modules.sys.web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.json.JSON;
import com.yrdce.ipo.common.web.BaseController;
import com.yrdce.ipo.modules.sys.service.DeliveryOrderService;
import com.yrdce.ipo.modules.sys.vo.DeliveryOrder;
import com.yrdce.ipo.modules.sys.vo.Express;
import com.yrdce.ipo.modules.sys.vo.Pickup;
import com.yrdce.ipo.modules.sys.vo.ResponseResult;

/**
 * 交收管理Controller
 * 
 * @author chenjing
 * @version 2013-5-31
 */
@Controller
@RequestMapping("DeliveryController")
public class DeliveryController extends BaseController {

	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(DeliveryController.class);

	@Autowired
	private DeliveryOrderService deliveryorderservice;

	public DeliveryOrderService getDeliveryorderservice() {
		return deliveryorderservice;
	}

	public void setDeliveryorderservice(
			DeliveryOrderService deliveryorderservice) {
		this.deliveryorderservice = deliveryorderservice;
	}

	/**
	 * 分页返回提货单列表
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/findAllDeliveryOrders", method = RequestMethod.POST)
	@ResponseBody
	public String findAllDeliveryOrders(@RequestParam("page") String page,
			@RequestParam("rows") String rows) throws IOException {
		log.info("分页查询所有提货单");
		try {
			List<DeliveryOrder> tlist = deliveryorderservice
					.findAllDeliOrdersByPage(page, rows);
			int totalnums = deliveryorderservice.getTotalNum();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			log.info(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 分页返回提货单列表（模糊查询）
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/QueryByConditions", method = RequestMethod.POST)
	@ResponseBody
	public String QueryByConditions(@RequestParam("page") String page,
			@RequestParam("rows") String rows,
			@RequestParam("deliveryorderId") String deliveryorderId,
			@RequestParam("applyDate") String applyDate,
			@RequestParam("approvalStatus") String approvalStatus,
			@RequestParam("dealerId") String dealerId) throws IOException {
		log.info("模糊查询提货单");
		try {
			DeliveryOrder record = new DeliveryOrder();
			if (!deliveryorderId.equals("")) {
				record.setDeliveryorderId(deliveryorderId + "%");
			}
			if (!applyDate.equals("")) {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Date date = sdf.parse(applyDate);
				record.setApplyDate(date);
			}
			if (!approvalStatus.equals("")) {
				record.setApprovalStatus(Integer.parseInt(approvalStatus));
			}
			if (!dealerId.equals("")) {
				record.setDealerId(dealerId + "%");
			}
			List<DeliveryOrder> dlist = deliveryorderservice
					.queryAllDeliOrdersByPage(page, rows, record);
			int totalnums = deliveryorderservice.getQueryNum(record).intValue();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(dlist);
			System.out.println(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * 分页展示待审核提货单
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/approveDeliveryOrders", method = RequestMethod.POST)
	@ResponseBody
	public String approveDeliveryOrders(@RequestParam("page") String page,
			@RequestParam("rows") String rows) throws IOException {
		log.info("分页查询待审核提货单");
		try {
			List<DeliveryOrder> tlist = deliveryorderservice
					.approveDeliOrdersByPage(page, rows);
			int totalnums = deliveryorderservice.getApproveNum();
			ResponseResult result = new ResponseResult();
			result.setTotal(totalnums);
			result.setRows(tlist);
			log.info(JSON.json(result));
			return JSON.json(result);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 审核提货单(自提)
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkPorders", method = RequestMethod.POST)
	@ResponseBody
	public String checkPorders(@RequestParam("entity") DeliveryOrder deorder,
			@RequestParam("detail") Pickup detail) throws IOException {
		log.info("进行自提方式提货单审核");
		try {
			deliveryorderservice.updateDeliveryOrder(deorder, detail);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

	/**
	 * 审核提货单(配送)
	 * 
	 * @param
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value = "/checkEorders", method = RequestMethod.POST)
	@ResponseBody
	public String checkEorders(@RequestParam("entity") DeliveryOrder deorder,
			@RequestParam("detail") Express detail) throws IOException {
		log.info("进行在线配送方式提货单审核");
		try {
			deliveryorderservice.updateDeliveryOrder(deorder, detail);
			return "true";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
