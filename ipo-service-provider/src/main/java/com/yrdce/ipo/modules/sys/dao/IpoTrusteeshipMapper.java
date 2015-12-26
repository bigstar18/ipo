package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoTrusteeship;
import com.yrdce.ipo.modules.sys.vo.Trusteeship;
/**
 * 托管商品
 * @author wq
 *
 */
@MyBatisDao
public interface IpoTrusteeshipMapper {

	
	/**
	 * 新增申请记录
	 * @param trusteeship
	 * @return
	 */
	public int insertApply(Trusteeship trusteeship);
	
	/**
	 * 查询商户提交的申请
	 * @param startIndex
	 * @param endIndex
	 * @param ship
	 * @return
	 */
	public List<IpoTrusteeship> queryApplyForPage( @Param("startIndex") int startIndex,
			@Param("endIndex") int endIndex, @Param("ship") Trusteeship ship);
	
	/**
	 * 查询商户提交的申请数量
	 * @param ship
	 * @return
	 */
	public long queryApplyForCount( @Param("ship")Trusteeship ship);
	
	/**
	 * 撤销我的申请
	 * @param ship
	 */
	public void canelApply(@Param("ship")Trusteeship ship);
	
	/**
	 * 查找
	 * @param id
	 * @return
	 */
	public IpoTrusteeship get(Long id);
	
	
	
}
