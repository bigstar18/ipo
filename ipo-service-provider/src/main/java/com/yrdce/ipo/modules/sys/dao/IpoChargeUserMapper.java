package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoChargeUser;
import com.yrdce.ipo.modules.sys.vo.ChargeUser;
/**
 * 特殊费用配置
 * @author wq 2016-1-3
 *
 */
@MyBatisDao
public interface IpoChargeUserMapper {

	public List<IpoChargeUser> queryForPage( @Param("startIndex") int startIndex,
			@Param("endIndex") int endIndex, @Param("param") ChargeUser chargeUser);
	
   
	public long queryForCount( @Param("param")ChargeUser chargeUser);
	
	 
	public void insert(ChargeUser chargeUser);

	 
	public IpoChargeUser findById(Long id);

	 
	public void update(@Param("param")ChargeUser chargeUser);
	
	
	
}
