package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoChargeItem;
import com.yrdce.ipo.modules.sys.vo.ChargeItem;
/**
 * 费用配置
 * @author wq
 *
 */
@MyBatisDao
public interface IpoChargeItemMapper {

	
	/**
	 * 分页查询下级费用配置
	 * @param startIndex
	 * @param endIndex
	 * @param chargeItem
	 * @return
	 */
	public List<IpoChargeItem> querySubLevelForPage( @Param("startIndex") int startIndex,
			@Param("endIndex") int endIndex, @Param("param") ChargeItem chargeItem);
	
    /**
     * 分页查询下级费用配置数量
     * @param chargeItem
     * @return
     */
	public long querySubLevelForCount( @Param("param")ChargeItem chargeItem);
	
	/**
	 * 分页查询所有子费用配置
	 * @param startIndex
	 * @param endIndex
	 * @param chargeItem
	 * @return
	 */
	public List<IpoChargeItem> queryChildLevelForPage( @Param("startIndex") int startIndex,
			@Param("endIndex") int endIndex, @Param("param") ChargeItem chargeItem);
	
    /**
     * 分页查询所有子费用配置数量
     * @param chargeItem
     * @return
     */
	public long queryChildLevelForCount( @Param("param")ChargeItem chargeItem);
	
	
	/**
	 * 查询费用配置
	 * @param chargeItem
	 * @return
	 */
	public List<IpoChargeItem> queryForList(@Param("param") ChargeItem chargeItem);
	
	
	/**
	 * 获取最大的id
	 * @param chargeItem
	 * @return
	 */
	public String getMaxId(@Param("param") ChargeItem chargeItem);
	
	/**
	 * 添加费用
	 * @param chargeItem
	 */
	public void insert(ChargeItem chargeItem);

	/**
	 * 查找费用
	 * @param id
	 * @return
	 */
	public IpoChargeItem findById(String id);

	/**
	 * 更新费用
	 * @param chargeItem
	 */
	public void update(@Param("param")ChargeItem chargeItem);
	
	/**
	 * 更新节点状态
	 * @param chargeItem
	 */
	public void updateLeaf(@Param("param")ChargeItem chargeItem);
	
	
}
