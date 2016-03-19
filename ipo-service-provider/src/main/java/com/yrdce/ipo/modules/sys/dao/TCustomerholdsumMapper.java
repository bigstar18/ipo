package com.yrdce.ipo.modules.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoOrder;
import com.yrdce.ipo.modules.sys.entity.TCustomerholdsum;

/**
 * @ClassName: TCustomerholdsumMapper
 * @Description: 经纪会员持仓汇总
 * @author bob
 */
@MyBatisDao
public interface TCustomerholdsumMapper {
	int deleteByPrimaryKey(@Param("customerid") String customerid,
			@Param("commodityid") String commodityid,
			@Param("bsFlag") Short bsFlag);

	int insert(TCustomerholdsum record);

	TCustomerholdsum selectByPrimaryKey(@Param("customerid") String customerid,
			@Param("commodityid") String commodityid,
			@Param("bsFlag") Short bsFlag);

	List<TCustomerholdsum> selectAll();

	int updateByPrimaryKey(TCustomerholdsum record);

	/**
	 * @Title: selectByFirmId
	 * @Description: 根据交易商id查询
	 * @param firmid
	 */
	List<TCustomerholdsum> selectByFirmId(String firmid);

	/**
	 * @Title: selectHQT
	 * @Description: 聚合查询（商品id，持仓量）
	 * @param firmid
	 */
	List<TCustomerholdsum> selectHQT(String firmid);

	long selectByCommId(List<IpoOrder> ipoOrders);

	long selectFirmHold(String firmid);

	int updateFirmHoldSum(@Param("firmid") String firmid,
			@Param("commodityid") String commodityid,
			@Param("bs_flag") short bs_flag, @Param("newqty") long newqty);

	long selectFirmHoldByFirmId(@Param("firmid") String firmid,
			@Param("commodityid") String commodityid,
			@Param("bs_flag") short bs_flag);

	void updateFirmHold(Map<String, Object> map);

	String selectFirmId(String customerid);

	String checkCommQuatity(@Param("customerid") String firmid,
			@Param("commodityid") String commid);

	/**
	 * @Title: findFirmIdAndDate
	 * @Description: 根据交易商id和时间查询(查询历史表)
	 * @param firmid
	 * @param date
	 */
	List<TCustomerholdsum> findFirmIdAndDate(@Param("firmid") String firmid,
			@Param("date") String date);

}