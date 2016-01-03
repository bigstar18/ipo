package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoChargeRole;
import com.yrdce.ipo.modules.sys.vo.ChargeRole;
/**
 * 一般费用配置
 * @author wq 2016-1-3
 *
 */
@MyBatisDao
public interface IpoChargeRoleMapper {

	public List<IpoChargeRole> queryForPage( @Param("startIndex") int startIndex,
			@Param("endIndex") int endIndex, @Param("param") ChargeRole chargeRole);
	
   
	public long queryForCount( @Param("param")ChargeRole chargeRole);
	
	 
	public void insert(ChargeRole chargeRole);

	 
	public IpoChargeRole findById(Long id);

	 
	public void update(@Param("param")ChargeRole chargeRole);
	
	
	
}
