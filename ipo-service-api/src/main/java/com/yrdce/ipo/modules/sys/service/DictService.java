/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Dict;

/**
 * 字典Service
 * 
 * @author ThinkGem
 * @version 2014-05-16
 */
public interface DictService {

	/**
	 * 查询字段类型列表
	 * 
	 * @return
	 */
	public List<String> findTypeList();

	public void save(Dict dict);

	public void delete(Dict dict);

}
