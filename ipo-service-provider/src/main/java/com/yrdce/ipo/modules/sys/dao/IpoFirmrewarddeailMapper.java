package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoFirmrewarddeail;

@MyBatisDao
public interface IpoFirmrewarddeailMapper {
	int deleteByPrimaryKey(BigDecimal id);

	int insert(IpoFirmrewarddeail record);

	IpoFirmrewarddeail selectByPrimaryKey(BigDecimal id);

	List<IpoFirmrewarddeail> selectAll();

	int updateByPrimaryKey(IpoFirmrewarddeail record);

	/**
	 * @Title: findByFirmidAndType
	 * @Description: 通过交易商id、业务类型、费用类型查询会员获得的返佣
	 * @param firmid
	 *            交易商id
	 * @param chargeType
	 *            费用类型
	 * @param businessType
	 *            业务类型
	 * @param startdate
	 * @param enddate
	 */
	List<IpoFirmrewarddeail> findByFirmidAndType(@Param("firmid") String firmid,
			@Param("chargeType") String chargeType, @Param("businessType") String businessType,
			@Param("startdate") String startdate, @Param("enddate") String enddate);

	/**
	 * 佣金结算
	 * 
	 * @return
	 */
	int brokerRewardSettle();

	/**
	 * @Title: findDisAndDea
	 * @param date
	 *            时间
	 * @param firmid
	 *            交易商id
	 * @param business
	 *            业务类型
	 * @param charge
	 *            费用类型
	 * @return 参数说明
	 */
	IpoFirmrewarddeail findDisAndDea(@Param("date") String date, @Param("firmid") String firmid,
			@Param("business") String business, @Param("charge") String charge);

}