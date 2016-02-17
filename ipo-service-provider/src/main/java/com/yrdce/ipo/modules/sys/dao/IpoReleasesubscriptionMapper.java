package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoReleasesubscription;

/**
 * 
 * @ClassName: IpoReleasesubscriptionMapper
 * @Description: 经济会员发行申购
 * @author bob
 */
@MyBatisDao
public interface IpoReleasesubscriptionMapper {
	int deleteByPrimaryKey(BigDecimal id);

	int insert(IpoReleasesubscription record);

	IpoReleasesubscription selectByPrimaryKey(BigDecimal id);

	List<IpoReleasesubscription> selectAll();

	int updateByPrimaryKey(IpoReleasesubscription record);

	/**
	 * @Title: selectByFirmidAndTime
	 * @Description: 根据经纪会员id和注册日期查询（交易商条件选填）
	 * @param brokerid
	 *            经纪会员id
	 * @param time
	 *            日期
	 * @return 商品提货单
	 */
	List<IpoReleasesubscription> selectByFirmidAndTime(@Param("brokerid") String brokerid,
			@Param("time") String time);
}