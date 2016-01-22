package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoPayFlowMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSysStatusMapper;
import com.yrdce.ipo.modules.sys.entity.IpoPayFlow;
import com.yrdce.ipo.modules.sys.vo.PayFlow;

/**
 * 付款流水
 * 
 * @author wq 2016-1-21
 * 
 */
public class PayFlowServiceImpl implements PayFlowService {

	@Autowired
	private IpoPayFlowMapper payFlowMapper;

	@Autowired
	private IpoSysStatusMapper mapper;

	/**
	 * 分页查询发行货款费用
	 * @param PayFlow
	 * @return
	 */
	public List<PayFlow> queryPublishGoodsForPage(String pageNo, String pageSize, PayFlow payFlow) {
		int startIndex = PageUtil.getStartIndex(pageNo, pageSize);
		int endIndex = PageUtil.getEndIndex(pageNo, pageSize);
		payFlow.setBusinessType(ChargeConstant.BusinessType.PUBLISH.getCode());
		payFlow.setChargeType(ChargeConstant.ChargeType.GOODS.getCode());
		List<IpoPayFlow> dbList = payFlowMapper.queryPublishGoodsForPage(startIndex, endIndex, payFlow);
		List<PayFlow> dataList = new ArrayList<PayFlow>();
		for (IpoPayFlow item : dbList) {
			PayFlow entity = new PayFlow();
			BeanUtils.copyProperties(item, entity);
			dataList.add(entity);
		}
		;
		return dataList;
	}

	/**
	 * 查询发行货款费用数量
	 * @param PayFlow
	 * @return
	 */
	public long queryPublishGoodsForCount(PayFlow payFlow) {
		payFlow.setBusinessType(ChargeConstant.BusinessType.PUBLISH.getCode());
		payFlow.setChargeType(ChargeConstant.ChargeType.GOODS.getCode());
		return payFlowMapper.queryPublishGoodsForCount(payFlow);
	}

	/**
	 * 付款
	 */
	@Transactional
	public void pay(PayFlow payFlow) {
		IpoPayFlow dbPayFlow = payFlowMapper.findById(payFlow.getId());
		String payee = dbPayFlow.getPayee();
		BigDecimal amount = dbPayFlow.getAmount();
		String commodityId = dbPayFlow.getCommodityId();
		updateFundsFull(payee, "40002", amount, commodityId);
		Date now = new Date();
		payFlow.setPayState(ChargeConstant.PayState.PAY_SUCCESS.getCode());
		payFlow.setUpdateDate(now);
		payFlow.setPayDate(now);
		payFlowMapper.updateState(payFlow);

	}

	private BigDecimal updateFundsFull(String userId, String opCode, BigDecimal amount, String commoId) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("money", "");
		param.put("userid", userId);
		param.put("oprcode", opCode);
		param.put("amount", amount.doubleValue());
		param.put("contractNo", null);
		param.put("extraCode", commoId);
		param.put("appendAmount", null);
		param.put("voucherNo", null);
		mapper.updateFundsFull(param);
		BigDecimal money = (BigDecimal) (param.get("money"));
		return money;
	}

}
