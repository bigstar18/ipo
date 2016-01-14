package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.PubpaymentTrack;

/**
 * @author chenjing
 *
 */
public interface PubpaymentTrackService {

	/**
	 * 分页查询货款跟踪信息
	 * 
	 * @param page
	 * @param rows
	 * @param example
	 * @return
	 */
	public List<PubpaymentTrack> getTrackInfoByPage(String page, String rows,
			PubpaymentTrack example);

	/**
	 * 获取符合条件的货款跟踪信息记录数
	 * 
	 * @param example
	 */
	public Integer getTrackNum(PubpaymentTrack example);

	/**
	 * 新增一条货款追踪记录
	 * 
	 * @param example
	 * @return
	 */
	public Integer insertTrack(PubpaymentTrack example);

}
