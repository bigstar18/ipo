package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoDataItemMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDataItem;
import com.yrdce.ipo.modules.sys.vo.DataItem;

/**
 * 数据项 service
 * 
 * @author wq 2016-1-1
 * 
 */
public class DataItemServiceImpl implements DataItemService {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private IpoDataItemMapper dataItemMapper;

	
	/**
	 * 分页查询数据项
	 */
	public List<DataItem> queryForPage(String pageNo, String pageSize,
			DataItem dataItem) {

		int startIndex=PageUtil.getStartIndex(pageNo, pageSize); 
		int endIndex=PageUtil.getEndIndex(pageNo, pageSize);
		List<IpoDataItem> dbList=dataItemMapper.queryForPage(startIndex,endIndex,dataItem);
		List<DataItem> dataList=new ArrayList<DataItem>();
		for(IpoDataItem item :dbList){
			DataItem entity=new DataItem();
			BeanUtils.copyProperties(item, entity);
			dataList.add(entity);
		};
		return dataList;
	}
	
	
	
    /**
     * 查询数据项数量
     */
	public long queryForCount(DataItem dataItem) {
		return dataItemMapper.queryForCount(dataItem);
	}

	/**
	 * 查询全部数据项
	 */
	public List<DataItem> queryForList(DataItem dataItem) {
		List<IpoDataItem> dbList=dataItemMapper.queryForList(dataItem);
		List<DataItem> dataList=new ArrayList<DataItem>();
		for(IpoDataItem item :dbList){
			DataItem entity=new DataItem();
			BeanUtils.copyProperties(item, entity);
			dataList.add(entity);
		}
		return dataList;
	}
	
	
	
	

}
