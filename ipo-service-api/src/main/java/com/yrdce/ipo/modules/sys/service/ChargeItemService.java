package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.ChargeItem;
/**
 * 费用项 service
 * @author wq 2016-1-1
 *
 */
public interface ChargeItemService {

	
	
	/**
	 * 分页查询下级费用配置
	 * @param startIndex
	 * @param endIndex
	 * @param chargeItem
	 * @return
	 */
	public List<ChargeItem> querySubLevelForPage( String pageNo,String pageSize,ChargeItem chargeItem);
	
    /**
     * 分页查询下级费用配置数量
     * @param chargeItem
     * @return
     */
	public long querySubLevelForCount(ChargeItem chargeItem);
	
	/**
	 * 分页查询所有子费用配置
	 * @param startIndex
	 * @param endIndex
	 * @param chargeItem
	 * @return
	 */
	public List<ChargeItem> queryChildLevelForPage(String pageNo,String pageSize,ChargeItem chargeItem);
	
    /**
     * 分页查询所有子费用配置数量
     * @param chargeItem
     * @return
     */
	public long queryChildLevelForCount(ChargeItem chargeItem);
	
	/**
	 * 查询所有的叶子节点
	 * @return
	 */
	public List<ChargeItem> queryLeafForList();

	/**
	 * 添加费用
	 * @param chargeItem
	 */
	public void save(ChargeItem chargeItem);
	
	
	/**
	 * 查询费用配置
	 * @param chargeItem
	 * @return
	 */
	public List<ChargeItem> queryForList(ChargeItem chargeItem);
	
	/**
	 * 查找费用
	 * @param id
	 * @return
	 */
	public ChargeItem findById(String id);
	
    /**
     * 更新费用
     * @param chargeItem
     */
	public void update(ChargeItem chargeItem);

	/**
	 * 删除费用项
	 * @param chargeItem
	 */
	public void delete(ChargeItem chargeItem);
	
	
	
	
}
