package com.yrdce.ipo.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.yrdce.ipo.modules.sys.vo.DataItem;

/**
 * 数据项 service
 * @author wq 2016-1-1
 *
 */
public interface DataItemService {

    /**
     * 分页查询数据项
     * @param pageNo
     * @param pageSize
     * @param dataItem
     * @return
     */
	public List<DataItem> queryForPage(String pageNo,String pageSize,DataItem dataItem);
			
    /**
     * 查询数据项数量
     * @param dataItem
     * @return
     */
	public long queryForCount(DataItem dataItem);
	
	/**
	 * 查询全部数据项 
	 * @param dataItem
	 * @return
	 */
	public List<DataItem> queryForList(DataItem dataItem);
	/**
	 * 根据类型查询数据项
	 * @param type
	 * @return
	 */
	public Map<String,String> queryForMap(String type);
	
	
}
