package com.yrdce.ipo.common.utils;

import java.util.HashMap;
import java.util.Map;

public class PageUtil {
    // 默认记录数
	public static final int PAGE_SIZE=10;
	//默认页码
	public static final int PAGE_NO=1;
	
	public static Map<String,Object> getRowNum(int curPage,int pageSize){  
	        Map<String,Object> map=new HashMap<String,Object>();  
	        map.put("curRow", (curPage-1)*pageSize);  
	        map.put("pageSize", pageSize);  
	        return map;  
	}
	 
	
	public static int getStartIndex(String pageNoStr,String pageSizeStr){
		int pageNo=StringUtil.parseInt(pageNoStr, PAGE_NO);
		int pageSize =StringUtil.parseInt(pageSizeStr,PAGE_SIZE);
		return (pageNo - 1)*pageSize+1;
	} 
	 
	public static int getEndIndex(String pageNoStr,String pageSizeStr){
		int pageNo=StringUtil.parseInt(pageNoStr, PAGE_NO);
		int pageSize =StringUtil.parseInt(pageSizeStr,PAGE_SIZE);
		return pageNo * pageSize;
	} 
	 
	
	
	
	
	 
}
