package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.ChargeUser;
/**
 * 特殊费用配置 service
 * @author wq 2016-1-3
 *
 */
public interface ChargeUserService {
	
	
	/**
	 * 分页查询特殊费用配置
	 * @param pageNo
	 * @param pageSize
	 * @param chargeUser
	 * @return
	 */
	public List<ChargeUser> queryForPage( String pageNo,String pageSize,ChargeUser chargeUser);
	
    /**
     * 查询特殊费用数量
     * @param chargeUser
     * @return
     */
	public long queryForCount(ChargeUser chargeUser);
	
	 

	/**
	 * 添加特殊费用
	 * @param chargeUser
	 */
	public void save(ChargeUser chargeUser);
	
	
	 
	
	/**
	 * 查找特殊费用
	 * @param id
	 * @return
	 */
	public ChargeUser findById(Long id);
	
   /**
    * 更新特殊费用
    * @param chargeUser
    */
	public void update(ChargeUser chargeUser);
	
	
	
	
}
