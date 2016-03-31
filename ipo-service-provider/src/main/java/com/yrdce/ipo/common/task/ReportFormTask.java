package com.yrdce.ipo.common.task;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.dao.IpoDeliveryorderMapper;
import com.yrdce.ipo.modules.sys.dao.IpoRfFirmholdsumMapper;
import com.yrdce.ipo.modules.sys.dao.TFirmHoldSumMaper;
import com.yrdce.ipo.modules.sys.entity.TFirmHoldSum;
import com.yrdce.ipo.modules.sys.vo.FirmHoldSum;

/**
 * @ClassName: ReportFormTask
 * @Description: 持仓记录(每日记录)
 * @author bob
 */
public class ReportFormTask {
	@Autowired
	private IpoDeliveryorderMapper ipoDeliveryorderMapper;
	@Autowired
	private TFirmHoldSumMaper tFirmHoldSumMaper;
	@Autowired
	private IpoRfFirmholdsumMapper ipoRfFirmholdsumMapper;

	@Transactional
	public void allHold() {
		List<String> allFirmList = ipoDeliveryorderMapper.queryAllFrimId();
		for (String FirmId : allFirmList) {
			FirmHoldSum firmHoldSum = new FirmHoldSum();
			firmHoldSum.setBsFlag(1);
			firmHoldSum.setFirmId(FirmId);
			List<TFirmHoldSum> holdList = tFirmHoldSumMaper.queryForList(firmHoldSum);
			for (TFirmHoldSum holdSum : holdList) {
				holdSum.setCleardate(new Date());
				ipoRfFirmholdsumMapper.insert(holdSum);
			}
		}
	}
}
