package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.UnderwritingQuery;

public interface UnderwritingQueryService {
	// 商品承销信息
	public List<UnderwritingQuery> getUnderInfo(String page, String rows, UnderwritingQuery underwritingQuery) throws Exception;

	// 商品承销信息页数
	public Integer getQueryNum(UnderwritingQuery example);
}