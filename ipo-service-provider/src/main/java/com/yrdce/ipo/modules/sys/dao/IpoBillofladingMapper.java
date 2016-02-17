package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoBilloflading;

/**
 * 
 * @ClassName: IpoBillofladingMapper
 * @Description: 经济会员商品提货单
 * @author bob
 */
@MyBatisDao
public interface IpoBillofladingMapper {
	int deleteByPrimaryKey(BigDecimal id);

	int insert(IpoBilloflading record);

	IpoBilloflading selectByPrimaryKey(BigDecimal id);

	List<IpoBilloflading> selectAll();

	int updateByPrimaryKey(IpoBilloflading record);

	/**
	 * @Title: selectByFirmidAndTime
	 * @Description: 根据经纪会员id和注册日期查询（交易商条件选填）
	 * @param firmid
	 *            交易商id
	 * @param time
	 *            注册日期
	 * @return 商品提货单
	 */
	List<IpoBilloflading> selectByFirmidAndTime(@Param("brokerid") String brokerid,
			@Param("time") String time);
}