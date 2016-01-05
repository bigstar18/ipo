package com.yrdce.ipo.modules.warehouse.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esotericsoftware.minlog.Log;
import com.yrdce.ipo.modules.warehouse.dao.IpoWarehouseStockMapper;
import com.yrdce.ipo.modules.warehouse.service.IpoWarehouseStockService;
import com.yrdce.ipo.modules.warehouse.vo.IpoWarehouseStock;

@Service
public class IpoWarehouseStockServiceImpl implements IpoWarehouseStockService {
	@Autowired
	private IpoWarehouseStockMapper warehousestockmapper;

	@Override
	public List<IpoWarehouseStock> findWarehouseStockByPage(String page,
			String rows, IpoWarehouseStock example) {
		Log.info("分页查询库存服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		if (example != null) {
			com.yrdce.ipo.modules.warehouse.entity.IpoWarehouseStock record = new com.yrdce.ipo.modules.warehouse.entity.IpoWarehouseStock();
			BeanUtils.copyProperties(example, record);
			List<com.yrdce.ipo.modules.warehouse.entity.IpoWarehouseStock> stocklist = warehousestockmapper
					.findWarehouseStockByPage((curpage - 1) * pagesize + 1,
							curpage * pagesize, record);
			List<IpoWarehouseStock> stocklist2 = new ArrayList<IpoWarehouseStock>();
			for (int i = 0; i < stocklist.size(); i++) {
				IpoWarehouseStock temp = new IpoWarehouseStock();
				BeanUtils.copyProperties(stocklist.get(i), temp);
				stocklist2.add(temp);
				Log.info(temp.toString());
			}
			return stocklist2;
		}
		return null;
	}

	@Override
	public Integer getQueryNum(IpoWarehouseStock example) {
		if (example != null) {
			com.yrdce.ipo.modules.warehouse.entity.IpoWarehouseStock record = new com.yrdce.ipo.modules.warehouse.entity.IpoWarehouseStock();
			BeanUtils.copyProperties(example, record);
			return warehousestockmapper.getQueryNum(record);
		}
		return 0;
	}

}
