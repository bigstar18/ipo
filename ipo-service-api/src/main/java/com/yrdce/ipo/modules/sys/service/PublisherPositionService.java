package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.PublisherPosition;

public interface PublisherPositionService {

	/**
	 * 分页查询转持仓信息
	 * 
	 * @param page
	 * @param rows
	 * @param example
	 * @return
	 */
	public List<PublisherPosition> getInfoByPage(String page, String rows,
			PublisherPosition example);

	/**
	 * 获取符合条件的转持仓记录数
	 * 
	 * @param example
	 */
	public Integer getPubPositionNum(PublisherPosition example);

	/**
	 * 新增一条转持仓信息
	 * 
	 * @param example
	 * @return
	 */
	public Integer insertPubPoition(PublisherPosition example);

}
