package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.yrdce.ipo.common.constant.ChargeConstant;
import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoDebitFlowMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDebitFlow;
import com.yrdce.ipo.modules.sys.vo.DebitFlow;
/**
 * 扣款流水
 * @author wq 2016-1-26
 *
 */
public class DebitFlowServiceImpl implements DebitFlowService {

	@Autowired
	private IpoDebitFlowMapper debitFlowMapper;
	/**
	 * 分页查询扣款流水
	 * @param pageNo
	 * @param pageSize
	 * @param debitFlow
	 * @return
	 */
	public List<DebitFlow> queryForPage(String pageNo, String pageSize,
			DebitFlow debitFlow) {
		int startIndex = PageUtil.getStartIndex(pageNo, pageSize);
		int endIndex = PageUtil.getEndIndex(pageNo, pageSize);
		List<IpoDebitFlow> dbList = debitFlowMapper.queryForPage(startIndex, endIndex, debitFlow);
		List<DebitFlow> dataList = new ArrayList<DebitFlow>();
		for(IpoDebitFlow item :dbList){
			DebitFlow entity=new DebitFlow();
			BeanUtils.copyProperties(item, entity);
			entity.setBusinessTypeName(ChargeConstant.BusinessType.getName(item.getBusinessType()));
			entity.setChargeTypeName(ChargeConstant.ChargeType.getName(item.getChargeType()));
			entity.setDebitStateName(ChargeConstant.DebitState.getName(item.getDebitState()));
			entity.setDebitModeName(ChargeConstant.DebitMode.getName(item.getDebitMode()));
			dataList.add(entity);
		};
		return dataList;
	}

	
	/**
	 * 查询扣款流水数量
	 * @param debitFlow
	 * @return
	 */
	public long queryForCount(DebitFlow debitFlow) {
		 
		return debitFlowMapper.queryForCount(debitFlow);
	}

	
	/**
	 * 保存扣款流水
	 * @param debitFlow
	 */
	public void save(DebitFlow debitFlow) {
		debitFlow.setCreateDate(new Date());
		debitFlowMapper.insert(debitFlow);
	}

	
	/**
	 * 保存线下扣款流水
	 * @param debitFlow
	 */
	public void saveOffline(DebitFlow debitFlow) {
		debitFlow.setDebitMode(ChargeConstant.DebitMode.OFFLINE.getCode());
		debitFlow.setDebitState(ChargeConstant.DebitState.PAY_SUCCESS.getCode());
		save(debitFlow);
	}

	
	
	
	
	
}
