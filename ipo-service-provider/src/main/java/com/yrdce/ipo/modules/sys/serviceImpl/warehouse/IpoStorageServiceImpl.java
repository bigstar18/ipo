package com.yrdce.ipo.modules.sys.serviceImpl.warehouse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esotericsoftware.minlog.Log;
import com.yrdce.ipo.modules.sys.dao.IpoStorageMapper;
import com.yrdce.ipo.modules.sys.entity.IpoStorage;
import com.yrdce.ipo.modules.sys.entity.IpoStorageExtended;
import com.yrdce.ipo.modules.sys.service.warehouse.IpoStorageService;
import com.yrdce.ipo.modules.sys.vo.VIpoStorageExtended;
import com.yrdce.ipo.modules.sys.vo.warehouse.IpoStorageVo;

@Service("ipoStorageService")
public class IpoStorageServiceImpl implements IpoStorageService {
	static org.slf4j.Logger log = org.slf4j.LoggerFactory
			.getLogger(IpoStorageServiceImpl.class);

	@Autowired
	private IpoStorageMapper ipoStorageMapper;

	@Override
	public int deleteByPrimaryKey(String storageid) {
		if (storageid != null && storageid != "") {
			return ipoStorageMapper.deleteByPrimaryKey(storageid);
		}
		return 0;
	}

	@Override
	public int insert(IpoStorageVo record) {
		IpoStorage ipoStorage = new IpoStorage();
		if (record != null) {
			BeanUtils.copyProperties(ipoStorage, record);
			return ipoStorageMapper.insert(ipoStorage);
		}
		return 0;
	}

	@Override
	public IpoStorageVo selectByPrimaryKey(String storageid) {
		if (storageid != null && storageid != "") {
			IpoStorageVo ipoStorageVo = new IpoStorageVo();
			BeanUtils.copyProperties(ipoStorageVo,
					ipoStorageMapper.selectByPrimaryKey(storageid));
			return ipoStorageVo;
		}
		return null;
	}

	@Override
	public List<IpoStorageVo> selectAll() {
		List<IpoStorageVo> IpoSVos = new ArrayList<IpoStorageVo>();
		BeanUtils.copyProperties("IpoSVos", ipoStorageMapper.selectAll());
		return IpoSVos;
	}

	@Override
	public int updateByPrimaryKey(IpoStorageVo record) {
		if (record != null) {
			IpoStorage ipoStorage = new IpoStorage();
			BeanUtils.copyProperties(ipoStorage, record);
			return ipoStorageMapper.updateByPrimaryKey(ipoStorage);
		}
		return 0;
	}

	@Override
	public IpoStorageVo selectByCommodityId(String commodityid) {
		if (commodityid != null) {
			IpoStorageVo IpoStorageVo = new IpoStorageVo();
			BeanUtils.copyProperties(IpoStorageVo,
					ipoStorageMapper.selectByCommodityId(commodityid));
			return IpoStorageVo;
		}
		return null;
	}

	@Override
	public IpoStorageVo selectByStorageDate(Date storagedate) {
		if (storagedate != null) {
			IpoStorageVo IpoStorageVo = new IpoStorageVo();
			BeanUtils.copyProperties(IpoStorageVo,
					ipoStorageMapper.selectByStorageDate(storagedate));
			return IpoStorageVo;
		}
		return null;
	}

	@Override
	public IpoStorageVo selectByStorageState(int storagestate) {
		IpoStorageVo IpoStorageVo = new IpoStorageVo();
		BeanUtils.copyProperties(IpoStorageVo,
				ipoStorageMapper.selectByStorageState(storagestate));
		return IpoStorageVo;
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
	public Integer checkStorage(String storageId, String flag, String checker) {
		Log.info("审核入库单服务");
		if (storageId != null && !storageId.equals("") && flag != null) {
			if (flag.equals("true")) {
				return ipoStorageMapper.updateStorage(storageId, checker, "4");
			}
			if (flag.equals("false")) {
				return ipoStorageMapper.updateStorage(storageId, checker, "5");
			}
		}
		return 0;
	}

}
