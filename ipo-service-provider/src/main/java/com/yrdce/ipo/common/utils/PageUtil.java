package com.yrdce.ipo.common.utils;

import java.util.HashMap;
import java.util.Map;

public class PageUtil {

	
	 public static Map<String,Object> getRowNum(int curPage,int pageSize)  
	    {  
	        Map<String,Object> map=new HashMap<String,Object>();  
	        map.put("curRow", (curPage-1)*pageSize);  
	        map.put("pageSize", pageSize);  
	        return map;  
	    } 
}
