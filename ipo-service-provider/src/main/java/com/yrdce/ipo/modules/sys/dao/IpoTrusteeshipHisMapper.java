package com.yrdce.ipo.modules.sys.dao;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeshipHis;
/**
 * 托管商品
 * @author wq
 *
 */
@MyBatisDao
public interface IpoTrusteeshipHisMapper {
	
	/**
	 * 新增
	 * @param shipHis
	 * @return
	 */
	public int insert(IpoTrusteeshipHis shipHis);
	
	 
	
	
}
