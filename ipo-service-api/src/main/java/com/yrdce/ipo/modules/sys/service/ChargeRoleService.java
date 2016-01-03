package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.ChargeRole;
/**
 * 一般费用配置 service
 * @author wq 2016-1-3
 *
 */
public interface ChargeRoleService {

	
	
	/**
	 * 分页查询一般费用配置
	 * @param pageNo
	 * @param pageSize
	 * @param chargeRole
	 * @return
	 */
	public List<ChargeRole> queryForPage( String pageNo,String pageSize,ChargeRole chargeRole);
	
    /**
     * 查询一般费用数量
     * @param chargeRole
     * @return
     */
	public long queryForCount(ChargeRole chargeRole);
	
	 

	/**
	 * 添加一般费用
	 * @param chargeRole
	 */
	public void save(ChargeRole chargeRole);
	
	
	 
	
	/**
	 * 查找一般费用
	 * @param id
	 * @return
	 */
	public ChargeRole findById(Long id);
	
   /**
    * 更新一般费用
    * @param chargeRole
    */
	public void update(ChargeRole chargeRole);
	
	
	
	
}
