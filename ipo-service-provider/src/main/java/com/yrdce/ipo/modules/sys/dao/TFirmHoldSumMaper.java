package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.TFirmHoldSum;
import com.yrdce.ipo.modules.sys.vo.FirmHoldSum;

@MyBatisDao
public interface TFirmHoldSumMaper {

	public long queryForCount(@Param("param") FirmHoldSum firmHoldSum);

	public List<TFirmHoldSum> queryForList(
			@Param("param") FirmHoldSum firmHoldSum);

	public List<String> findAllCom();

	public int insert(FirmHoldSum firmHoldSum);

	// 商品在持仓中的总量(现货持仓)
	int selectSumByComm(@Param("commodityid") String commodityid);

	// 现货持仓信息
	List<TFirmHoldSum> selectPositionList(String commodityid);

}
