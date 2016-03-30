package com.yrdce.ipo.modules.warehouse.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esotericsoftware.minlog.Log;
import com.yrdce.ipo.modules.sys.dao.IpoCommodityConfMapper;
import com.yrdce.ipo.modules.warehouse.dao.IpoStorageMapper;
import com.yrdce.ipo.modules.warehouse.dao.IpoWarehouseStockMapper;
import com.yrdce.ipo.modules.warehouse.entity.IpoStorage;
import com.yrdce.ipo.modules.warehouse.entity.IpoStorageExtended;
import com.yrdce.ipo.modules.warehouse.entity.IpoWarehouseStock;
import com.yrdce.ipo.modules.warehouse.entity.WarehouseStock;
import com.yrdce.ipo.modules.warehouse.service.IpoStorageService;
import com.yrdce.ipo.modules.warehouse.vo.IpoStorageVo;
import com.yrdce.ipo.modules.warehouse.vo.VIpoStorageExtended;

@Service("ipoStorageService")
public class IpoStorageServiceImpl implements IpoStorageService {

	@Autowired
	private IpoStorageMapper ipoStorageMapper;
	@Autowired
	private IpoCommodityConfMapper ipoCommodityConfMapper;
	@Autowired
	private IpoWarehouseStockMapper ipowarehousestockmapper;

	@Override
	@Transactional
	public Integer insert(IpoStorageVo record) {
		IpoStorage ipoStorage = new IpoStorage();
		if (record != null) {
			BeanUtils.copyProperties(record, ipoStorage);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			String id1 = sdf.format(new Date());
			String id2 = String.valueOf(ipoStorageMapper.sequence());
			String primaryKey = id1 + id2;
			ipoStorage.setStorageid(primaryKey);
			ipoStorage.setStoragedate(new Date());
			ipoStorage.setStoragestate(1);// 申请状态
			return ipoStorageMapper.insert(ipoStorage);
		}
		return 0;
	}

	@Override
	public List<VIpoStorageExtended> selectByPage(String page, String rows,
			VIpoStorageExtended storage) {
		Log.info("分页查询入库单服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		if (storage != null) {
			IpoStorageExtended example = new IpoStorageExtended();
			BeanUtils.copyProperties(storage, example);
			List<IpoStorageExtended> storageslist = ipoStorageMapper
					.findStoragesByPage((curpage - 1) * pagesize + 1, curpage
							* pagesize, example);
			List<VIpoStorageExtended> storageslist2 = new ArrayList<VIpoStorageExtended>();
			for (int i = 0; i < storageslist.size(); i++) {
				VIpoStorageExtended temp = new VIpoStorageExtended();
				BeanUtils.copyProperties(storageslist.get(i), temp);
				storageslist2.add(temp);
				Log.info(temp.toString());
			}
			return storageslist2;
		}
		return null;
	}

	@Override
	public Integer getTotalNum(VIpoStorageExtended storage) {
		Log.info("获取入库单记录数");
		if (storage != null) {
			IpoStorageExtended example = new IpoStorageExtended();
			BeanUtils.copyProperties(storage, example);
			return ipoStorageMapper.getTotalNum(example);
		}
		return 0;
	}

	@Override
	@Transactional
	public Integer checkStorage(String storageId, String flag, String checker) {
		Log.info("审核入库单服务");
		if (storageId != null && !storageId.equals("") && flag != null) {
			if (flag.equals("warehousetrue")) {
				return ipoStorageMapper.updateStorageState(storageId, checker,
						"2");// 仓库通过
			}
			if (flag.equals("warehousefalse")) {
				return ipoStorageMapper.updateStorageState(storageId, checker,
						"3");// 仓库驳回
			}
			if (flag.equals("mgrtrue")) {
				WarehouseStock record = new WarehouseStock();
				IpoStorage example = ipoStorageMapper
						.getStorageByPrimary(storageId);
				IpoWarehouseStock stock = ipowarehousestockmapper
						.selectByCommoId(example.getCommodityid(),
								example.getWarehouseid());
				if (stock == null) {
					record.setCommodityid(example.getCommodityid());
					record.setStoragenum(example.getStoragecounts());
					record.setForzennum((long) 0);
					record.setOutboundnum((long) 0);
					record.setAvailablenum(example.getStoragecounts());
					record.setWarehouseid(example.getWarehouseid());
					ipowarehousestockmapper.insert(record);
				} else {
					long newstoragenum = stock.getStoragenum()
							+ example.getStoragecounts();
					long newavailablenum = stock.getAvailablenum()
							+ example.getStoragecounts();
					stock.setStoragenum(newstoragenum);
					stock.setAvailablenum(newavailablenum);
					ipowarehousestockmapper.updateInfo(stock);
				}
				return ipoStorageMapper.updateStorageState(storageId, checker,
						"4");// 市场通过
			}
			if (flag.equals("mgrfalse")) {
				return ipoStorageMapper.updateStorageState(storageId, checker,
						"5");// 市场驳回
			}
		}
		return 0;
	}

	@Override
	public String getWarehouseId(String userID) {

		return ipoStorageMapper.getWarehouseId(userID);
	}

	@Override
	public Long getWarehousePrimary(String userID) {

		return ipoStorageMapper.getWarehousePrimaryKey(userID);
	}

	@Override
	public VIpoStorageExtended getStorageByStorageId(String storageId) {
		IpoStorageExtended example = ipoStorageMapper
				.getStorageByStorageId(storageId);
		if (example != null) {
			VIpoStorageExtended storage = new VIpoStorageExtended();
			BeanUtils.copyProperties(example, storage);
			return storage;
		}
		return null;

	}

	@Override
	public List<VIpoStorageExtended> selectBySale(String page, String rows,
			VIpoStorageExtended storage) {
		Log.info("分页查询可转持仓入库单服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		if (storage != null) {
			IpoStorageExtended example = new IpoStorageExtended();
			BeanUtils.copyProperties(storage, example);
			List<IpoStorageExtended> storageslist = ipoStorageMapper
					.findStoragesBySale((curpage - 1) * pagesize + 1, curpage
							* pagesize, example);
			List<VIpoStorageExtended> storageslist2 = new ArrayList<VIpoStorageExtended>();
			for (int i = 0; i < storageslist.size(); i++) {
				VIpoStorageExtended temp = new VIpoStorageExtended();
				BeanUtils.copyProperties(storageslist.get(i), temp);
				storageslist2.add(temp);
				Log.info(temp.toString());
			}
			return storageslist2;
		}
		return null;
	}

	@Override
	public Integer getSaleTotalNum(VIpoStorageExtended storage) {
		Log.info("获取可转持仓入库单记录数");
		if (storage != null) {
			IpoStorageExtended example = new IpoStorageExtended();
			BeanUtils.copyProperties(storage, example);
			return ipoStorageMapper.getSaleTotalNum(example);
		}
		return 0;
	}

}
