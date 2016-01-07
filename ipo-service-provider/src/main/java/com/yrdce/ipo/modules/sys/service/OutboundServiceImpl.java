package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.client.protocol.RequestDefaultHeaders;
import org.jboss.netty.util.EstimatableObjectWrapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.esotericsoftware.minlog.Log;
import com.yrdce.ipo.modules.sys.dao.IpoDeliveryorderMapper;
import com.yrdce.ipo.modules.sys.dao.IpoOutboundMapper;
import com.yrdce.ipo.modules.sys.entity.IpoDeliveryorder;
import com.yrdce.ipo.modules.sys.entity.IpoOutbound;
import com.yrdce.ipo.modules.sys.entity.IpoOutboundExtended;
import com.yrdce.ipo.modules.sys.vo.Outbound;
import com.yrdce.ipo.modules.sys.vo.OutboundExtended;

/**
 * @author chenjing
 *
 */
@Service("outboundService")
public class OutboundServiceImpl implements OutboundService {
	@Autowired
	private IpoOutboundMapper ipoOutboundMapper;
	@Autowired
	private IpoDeliveryorderMapper ipoDeliveryorderMapper;

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
	//修改出库单状态
	@Override
	@Transactional
	public Integer updateOutBoundInfo(Outbound outbound) {
		// TODO Auto-generated method stub
		try {
			int result1;
			Log.info("修改出库单状态");
			IpoDeliveryorder deliveryorder = new IpoDeliveryorder(); 
			if(outbound==null)
				return 0;
			IpoOutbound ipoOutbound = new IpoOutbound();
			BeanUtils.copyProperties(outbound, ipoOutbound);
			ipoOutboundMapper.updateOutBoundInfo(ipoOutbound);
			Log.info("修改出库单状态"+ipoOutbound.getOutboundstate());
			if (ipoOutbound.getOutboundstate()==2) {
				deliveryorder.setDeliveryorderId(ipoOutbound.getOutboundorderid());
				deliveryorder.setApprovalStatus(6);
				result1 = ipoDeliveryorderMapper.updateStatus(deliveryorder);
			}else if (ipoOutbound.getOutboundstate()==3){
				deliveryorder.setDeliveryorderId(ipoOutbound.getOutboundorderid());
				deliveryorder.setApprovalStatus(7);
				result1 = ipoDeliveryorderMapper.updateStatus(deliveryorder);
			}
			return 1;
		} catch (Exception e) {
			// TODO: handle exception
			Log.error("修改出库单状态",e);
			return 0;
		}
	}

	//添加出库单
	@Override
	@Transactional
	public Integer addOutBoundOrder(Outbound outbound) {
		// TODO Auto-generated method stub
		if (outbound==null) {
			return 0;
		}
		IpoOutbound ipoOutbound = new IpoOutbound();
		BeanUtils.copyProperties(outbound, ipoOutbound);
		ipoOutbound.setOutboundorderid(ipoOutbound.getDeliveryorderid());
		int result = ipoOutboundMapper.insert(ipoOutbound);
		return result;
	}

	@Override
	public int updateOutBoundState(Integer outboundstate, String outboundorderid) {
		// TODO Auto-generated method stub
		return  ipoOutboundMapper.updateOutBoundState(outboundstate, outboundorderid);
	}

	@Override
	public Outbound getOutboundOrder(String outboundOrderId) {
		// TODO Auto-generated method stub
		Outbound outbound = null;
		IpoOutbound ipoOutbound = ipoOutboundMapper.selectByPrimaryKey(outboundOrderId);
		Log.info("ipoOutbound.id["+outboundOrderId+"]:"+ipoOutbound);
		if (ipoOutbound!=null) {
			outbound = new Outbound();
			BeanUtils.copyProperties(ipoOutbound, outbound);
		}
		return outbound;
	}
	
	
}
