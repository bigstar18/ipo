package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.UnderwriterSubscribe;

/**
 * 承销会员认购管理承销设置
 * 
 * @author chenjing
 *
 */
public interface UnderwriterSubscribeService {

	/**
	 * 撤销设置列表
	 * 
	 * @param page
	 * @param rows
	 * @param eample
	 * @return
	 */
	public List<UnderwriterSubscribe> getInfosByPage(String page, String rows,
			UnderwriterSubscribe example);

	/**
	 * 获取记录数
	 * 
	 * @param eample
	 * @return
	 */
	public Integer getQueryNum(UnderwriterSubscribe example);

	/**
	 * 删除承销设置信息
	 * 
	 * @param id
	 * @return
	 */
	public String deleteInfo(String ids);

	/**
	 * 添加承销设置信息
	 * 
	 * @param example
	 * @return
	 */
	public Integer insertInfo(UnderwriterSubscribe example);

}
