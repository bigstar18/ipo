package com.yrdce.ipo.common.utils;

public class StringUtil {

	public static int parseInt(String str,int defaultValue){
		int target=defaultValue;
		try {
			target=Integer.parseInt(str);
		} catch (Exception e) {
		}
		return target;
	}
	
	public static long parseLong(String str,long defaultValue){
		long target=defaultValue;
		try {
			target=Long.parseLong(str);
		} catch (Exception e) {
		}
		return target;
	}
	
	
	
	
	
}
