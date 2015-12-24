package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esotericsoftware.minlog.Log;
import com.yrdce.ipo.modules.sys.dao.IpoOutboundMapper;
import com.yrdce.ipo.modules.sys.entity.IpoOutboundExtended;
import com.yrdce.ipo.modules.sys.vo.OutboundExtended;

/**
 * @author chenjing
 *
 */
@Service("outboundService")
public class OutboundServiceImpl implements OutboundService {
	@Autowired
	private IpoOutboundMapper ipoOutboundMapper;

	@Override
	public List<OutboundExtended> getAllOutboundInfo(String page, String rows,
			OutboundExtended record) {
		Log.info("分页查询出库单服务");
		page = (page == null ? "1" : page);
		rows = (rows == null ? "5" : rows);
		int curpage = Integer.parseInt(page);
		int pagesize = Integer.parseInt(rows);
		Log.info("调用后台服务" + record.toString());
		if (record != null) {
			IpoOutboundExtended example = new IpoOutboundExtended();
			BeanUtils.copyProperties(record, example);
			String delimethod = record.getDeliveryMethod();
			if (delimethod != null) {
				if (delimethod.equals("")) {
					example.setDeliveryMethod(null);
				}
			}
			Log.info("调用后台服务" + example.toString());
			List<IpoOutboundExtended> storageslist = ipoOutboundMapper
					.findOutboundsByPage((curpage - 1) * pagesize + 1, curpage
							* pagesize, example);
			List<OutboundExtended> storageslist2 = new ArrayList<OutboundExtended>();
			for (int i = 0; i < storageslist.size(); i++) {
				OutboundExtended temp = new OutboundExtended();
				BeanUtils.copyProperties(storageslist.get(i), temp);
				storageslist2.add(temp);
				Log.info(temp.toString());
			}
			return storageslist2;
		}
		return null;
	}

	@Override
	public Integer getTotalNum(OutboundExtended record) {
		Log.info("查询出库单记录数");
		if (record != null) {
			IpoOutboundExtended example = new IpoOutboundExtended();
			BeanUtils.copyProperties(record, example);
			String delimethod = record.getDeliveryMethod();
			if (delimethod != null) {
				if (delimethod.equals("")) {
					example.setDeliveryMethod(null);
				}
			}
			return ipoOutboundMapper.getTotalNum(example);
		}
		return 0;
	}

}
