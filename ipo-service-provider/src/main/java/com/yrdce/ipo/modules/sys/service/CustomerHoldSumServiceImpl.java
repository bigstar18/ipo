package com.yrdce.ipo.modules.sys.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Service;
import com.yrdce.ipo.modules.sys.dao.TCustomerholdsumMapper;
import com.yrdce.ipo.modules.sys.dao.TFirmHoldSumMaper;
import com.yrdce.ipo.modules.sys.entity.TCustomerholdsum;
import com.yrdce.ipo.modules.sys.vo.FirmHoldSum;

@Service
public class CustomerHoldSumServiceImpl implements CustomerHoldSumService {

	protected Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private TCustomerholdsumMapper customerholdsumMapper;

	@Autowired
	private TFirmHoldSumMaper frimholdsumMapper;

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
		logger.info("持仓冻结数量{}", frozen);
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
	 * 增加客户持仓 传正值
	 */
	@Transactional
	public void increaseCustomerHold(Long frozenqty, String customerid,
			String commodityid, Short bsFlag) {
		this.incraseFirmHold(frozenqty, customerid, commodityid, bsFlag);
	}

	/**
	 * 减少客户持仓 传正值
	 */
	@Transactional
	public void reduceCustomerHold(Long frozenqty, String customerid,
			String commodityid, Short bsFlag) {
		this.reduceFirmHold(frozenqty, customerid, commodityid, bsFlag);

	}

	@Override
	public void myfreezeCustomerHold(Long frozenqty, String customerid,
			String commodityid, Short bsFlag) {
		freezeCustomerHold(frozenqty, customerid, commodityid,
				bsFlag.shortValue());

	}

	/**
	 * 扣持仓 更新交易用户持仓合计信息，根据数量平均分配金额传正值
	 */
	@Transactional
	public String reduceFirmHold(Long tradeqty, String customerid,
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

	/**
	 * 加持仓 更新交易用户持仓合计信息，根据数量平均分配金额 传正值
	 */
	@Transactional
	public String incraseFirmHold(Long tradeqty, String customerid,
			String commodityid, short bsFlag) {
		String firmid = customerholdsumMapper.selectFirmId(customerid);
		TCustomerholdsum dbCustomerHold = customerholdsumMapper
				.selectByPrimaryKey(customerid, commodityid, bsFlag);
		if (dbCustomerHold == null) {
			TCustomerholdsum record = new TCustomerholdsum();
			record.setCustomerid(customerid);
			record.setCommodityid(commodityid);
			record.setBsFlag(bsFlag);
			record.setHoldqty(tradeqty);
			BigDecimal orivalue = new BigDecimal(0);
			record.setHoldfunds(orivalue);
			record.setGagefrozenqty((long) 0);
			record.setFirmid(firmid);
			record.setHoldassure(orivalue);
			record.setGageqty((long) 0);
			record.setHoldmargin(orivalue);
			record.setFrozenqty((long) 0);
			record.setFloatingloss(orivalue);
			record.setEvenprice(orivalue);
			int cresult = customerholdsumMapper.insert(record);
			FirmHoldSum example = new FirmHoldSum();
			example.setCommodityId(commodityid);
			example.setFirmId(firmid);
			example.setBsFlag(1);
			long fnum = frimholdsumMapper.queryForCount(example);
			int fresult = 0;
			if (fnum == 0) {
				example.setHoldqty(tradeqty);
				example.setHoldFunds(orivalue);
				example.setFloatingLoss(orivalue);
				example.setEvenPrice(orivalue);
				example.setHoldMargin(orivalue);
				example.setGageqty((long) 0);
				example.setHoldAssure(orivalue);
				frimholdsumMapper.insert(example);
			} else {
				long newFirmHoldqty = customerholdsumMapper
						.selectFirmHoldByFirmId(firmid, commodityid, (short) 1)
						+ tradeqty;
				fresult = customerholdsumMapper.updateFirmHoldSum(firmid,
						commodityid, (short) 1, newFirmHoldqty);
			}
			if (cresult == 1 && fresult == 1) {
				return "success";
			}
			return "false";
		} else {
			long newholdqty = dbCustomerHold.getHoldqty() + tradeqty;
			dbCustomerHold.setHoldqty(newholdqty);
			int num = customerholdsumMapper.updateByPrimaryKey(dbCustomerHold);

			long newFirmHoldqty = customerholdsumMapper.selectFirmHoldByFirmId(
					firmid, commodityid, (short) 1) + tradeqty;
			int result = customerholdsumMapper.updateFirmHoldSum(firmid,
					commodityid, (short) 1, newFirmHoldqty);
			if (result == 1 && num == 1) {
				return "success";
			}
			return "false";
		}
	}

}
