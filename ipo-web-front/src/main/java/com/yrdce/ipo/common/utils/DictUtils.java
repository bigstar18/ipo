/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.yrdce.ipo.common.utils;

import java.util.ArrayList;
import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Dict;

/**
 * 字典工具类
 * 
 * @author ThinkGem
 * @version 2013-5-29
 */
public class DictUtils {

	public static final String CACHE_DICT_MAP = "dictMap";

	public static String getDictLabel(String value, String type, String defaultValue) {

		return defaultValue;
	}

	public static String getDictLabels(String values, String type, String defaultValue) {

		return defaultValue;
	}

	public static String getDictValue(String label, String type, String defaultLabel) {

		return defaultLabel;
	}

	public static List<Dict> getDictList(String type) {
		return new ArrayList();
	}

	/**
	 * 返回字典列表（JSON）
	 * 
	 * @param type
	 * @return
	 */
	public static String getDictListJson(String type) {
		return type;
	}

}
