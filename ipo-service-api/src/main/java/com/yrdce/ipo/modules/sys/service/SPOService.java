package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Spo;

public interface SPOService {
	public List<Spo> getInfoByPages(Spo spo,String page,String rows);
	public int getInfoCounts(Spo spo);
	public int updateRationType(String rationType);
}
