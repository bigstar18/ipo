package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Outbound;
import com.yrdce.ipo.modules.sys.vo.OutboundExtended;

/**
 * @author chenjing
 *
 */
public interface OutboundService {

	/**
	 * 获取符合条件的出库单
	 * 
	 * @param page
	 * @param rows
	 * @param record
	 * @return
	 */
	public List<OutboundExtended> getAllOutboundInfo(String page, String rows, OutboundExtended record);

	/**
	 * 获取符合条件的记录数
	 * 
	 * @param record
	 * @return
	 */
	public Integer getTotalNum(OutboundExtended record);

	/**
	 * li 根据id修改出库单状态
	 *
	 **/
	public Integer updateOutBoundInfo(Outbound outbound);

	/**
	 * li 添加出库单
	 */
	public Integer addOutBoundOrder(Outbound outbound);

	public int updateOutBoundState(Integer outboundstate, String outboundorderid);

	// 查询出库单记录
	public Outbound getOutboundOrder(String outboundOrderId);

}
