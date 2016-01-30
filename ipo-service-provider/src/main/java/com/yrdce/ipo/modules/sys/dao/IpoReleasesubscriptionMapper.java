package com.yrdce.ipo.modules.sys.dao;

import java.math.BigDecimal;
import java.util.List;

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
}