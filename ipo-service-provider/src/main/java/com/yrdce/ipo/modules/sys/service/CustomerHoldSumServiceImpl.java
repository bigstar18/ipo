package com.yrdce.ipo.modules.sys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.yrdce.ipo.modules.sys.dao.TCustomerholdsumMapper;
import com.yrdce.ipo.modules.sys.entity.TCustomerholdsum;

@Service
public class CustomerHoldSumServiceImpl implements CustomerHoldSumService {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private TCustomerholdsumMapper customerholdsumMapper;

	/**
	 * 冻结客户持仓
	 * 
	 * @param freezeqty
	 *            冻结数量
	 * @param customerid
	 *            客户代码
	 * @param commodityid
	 *            商品编码
	 * @param bsFlag
	 *            买卖标记
	 */
	@Transactional
	public void freezeCustomerHold(Long frozenqty, String customerid,
			String commodityid, Short bsFlag) {

		TCustomerholdsum dbCustomerHold = customerholdsumMapper
				.selectByPrimaryKey(customerid, commodityid, bsFlag);
		if (dbCustomerHold == null) {
			throw new RuntimeException("冻结客户持仓记录不存在");
		}
		;
		TCustomerholdsum param = new TCustomerholdsum();
		Long frozen = dbCustomerHold.getFrozenqty() + frozenqty;
		BeanUtils.copyProperties(dbCustomerHold, param);
		param.setFrozenqty(frozen);
		customerholdsumMapper.updateByPrimaryKey(param);
	}

	/**
	 * 解冻客户持仓
	 * 
	 * @param unfreezeqty
	 *            解冻数量
	 * @param customerid
	 *            客户代码
	 * @param commodityid
	 *            商品编码
	 * @param bsFlag
	 *            买卖标记
	 */
	@Transactional
	public void unfreezeCustomerHold(Long unfreezeqty, String customerid,
			String commodityid, Short bsFlag) {
		TCustomerholdsum dbCustomerHold = customerholdsumMapper
				.selectByPrimaryKey(customerid, commodityid, bsFlag);
		if (dbCustomerHold == null) {
			throw new RuntimeException("解冻客户持仓记录不存在");
		}
		;
		TCustomerholdsum param = new TCustomerholdsum();
		BeanUtils.copyProperties(dbCustomerHold, param);
		Long frozenqty = dbCustomerHold.getFrozenqty() - unfreezeqty;
		if (frozenqty < 0) {
			frozenqty = 0L;
		}
		;
		param.setFrozenqty(frozenqty);
		customerholdsumMapper.updateByPrimaryKey(param);
	}

	/**
	 * 增加客户持仓
	 */
	@Transactional
	public void increaseCustomerHold(Long frozenqty, String customerid,
			String commodityid, short bsFlag) {
		// TODO Auto-generated method stub

	}

	/**
	 * 减少客户持仓
	 */
	@Transactional
	public void reduceCustomerHold(Long frozenqty, String customerid,
			String commodityid, short bsFlag) {
		// TODO Auto-generated method stub

	}

	@Override
	public void myfreezeCustomerHold(Long frozenqty, String customerid,
			String commodityid, Short bsFlag) {
		freezeCustomerHold(frozenqty, customerid, commodityid,
				bsFlag.shortValue());

	}

	/**
	 * 更新交易用户持仓合计信息，根据数量平均分配金额 扣持仓传正值 加持仓传负值
	 */
	@Transactional
	public String updateFirmHold(Long tradeqty, String customerid,
			String commodityid, short bsFlag) {
		TCustomerholdsum dbCustomerHold = customerholdsumMapper
				.selectByPrimaryKey(customerid, commodityid, bsFlag);
		if (dbCustomerHold == null) {
			throw new RuntimeException("扣除客户持仓记录不存在");
		}
		long newfrozenqty = dbCustomerHold.getFrozenqty() - tradeqty;
		long newholdqty = dbCustomerHold.getHoldqty() - tradeqty;
		dbCustomerHold.setFrozenqty(newfrozenqty);
		dbCustomerHold.setHoldqty(newholdqty);
		int num = customerholdsumMapper.updateByPrimaryKey(dbCustomerHold);
		String firmid = customerholdsumMapper.selectFirmId(customerid);
		long newFirmHoldqty = customerholdsumMapper.selectFirmHoldByFirmId(
				firmid, commodityid, (short) 1) - tradeqty;
		int result = customerholdsumMapper.updateFirmHoldSum(firmid,
				commodityid, (short) 1, newFirmHoldqty);
		if (result == 1 && num == 1) {
			return "success";
		}
		return "false";
	}
}
