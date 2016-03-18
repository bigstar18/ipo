package com.yrdce.ipo.modules.sys.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.TFirmHoldSum;

@MyBatisDao
public interface THFirmholdsumMapper {

	TFirmHoldSum selectByPrimaryKey(@Param("cleardate") Date cleardate, @Param("firmid") String firmid,
			@Param("commodityid") String commodityid, @Param("bsFlag") Short bsFlag);

	List<TFirmHoldSum> selectAll();

	/**
	 * @Title: findByComIdAndFirmId
	 * @Description: 根据交易商id、商品id、日期查询
	 * @param cleardate
	 *            日期
	 * @param firmid
	 *            交易商id
	 * @param commodityid
	 *            商品id
	 */
	List<TFirmHoldSum> findByComIdAndFirmId(@Param("cleardate") String cleardate,
			@Param("firmid") String firmid, @Param("commodityid") String commodityid);

}