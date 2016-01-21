package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoPayFlow;
import com.yrdce.ipo.modules.sys.vo.PayFlow;
/**
 * 付款流水记录
 * @author wq 2016-1-21
 *
 */
@MyBatisDao
public interface IpoPayFlowMapper {

	/**
	 * 新增
	 * @param PayFlow
	 */
	public void insert(PayFlow PayFlow); 
	
	/**
	 * 分页查询发行货款费用
	 * @param PayFlow
	 * @return
	 */
	public List<IpoPayFlow> queryPublishGoodsForPage(@Param("startIndex") int startIndex,
			@Param("endIndex") int endIndex,@Param("param")PayFlow PayFlow);
	
	/**
	 * 查询发行货款费用数量
	 * @param PayFlow
	 * @return
	 */
	public long queryPublishGoodsForCount(@Param("param")PayFlow PayFlow);
	/**
	 * 更新状态
	 * @param PayFlow
	 */
	public void updateState(PayFlow PayFlow);
	
	/**
	 * 通过id查找
	 * @param id
	 * @return
	 */
	public IpoPayFlow findById(Long id);
	
	
	
	
}
