package com.yrdce.ipo.modules.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrdce.ipo.common.dao.MyBatisDao;
import com.yrdce.ipo.modules.sys.entity.IpoDataItem;
import com.yrdce.ipo.modules.sys.vo.DataItem;
/**
 * 数据项
 * @author wq
 *
 */
@MyBatisDao
public interface IpoDataItemMapper {

	/**
	 * 分页查询数据项
	 * @param startIndex
	 * @param endIndex
	 * @param dataItem
	 * @return
	 */
	public List<IpoDataItem> queryForPage( @Param("startIndex") int startIndex,
			@Param("endIndex") int endIndex, @Param("param") DataItem dataItem);
	
    /**
     * 查询数据项数量
     * @param dataItem
     * @return
     */
	public long queryForCount( @Param("param")DataItem dataItem);
	
	/**
	 * 查询全部数据项 
	 * @param dataItem
	 * @return
	 */
	public List<IpoDataItem> queryForList(@Param("param") DataItem dataItem);
	
	
	
	
	
}
