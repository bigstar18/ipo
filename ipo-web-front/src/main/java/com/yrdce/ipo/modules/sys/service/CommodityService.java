package com.yrdce.ipo.modules.sys.service;

import java.util.List;

import com.yrdce.ipo.modules.sys.vo.Commodity;

public interface CommodityService {

	List<Commodity> findCommList(String page, String rows);

}
