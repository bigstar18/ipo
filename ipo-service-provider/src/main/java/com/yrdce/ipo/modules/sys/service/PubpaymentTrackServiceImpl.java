package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoPubpaymentTrackMapper;
import com.yrdce.ipo.modules.sys.entity.IpoPubpaymentTrack;
import com.yrdce.ipo.modules.sys.vo.PubpaymentTrack;

/**
 * @author chenjing
 *
 */
@Service
public class PubpaymentTrackServiceImpl implements PubpaymentTrackService {

	@Autowired
	private IpoPubpaymentTrackMapper pubpaymenttrackmapper;

	@Override
	public List<PubpaymentTrack> getTrackInfoByPage(String page, String rows,
			PubpaymentTrack example) {
		int startIndex = PageUtil.getStartIndex(page, rows);
		int endIndex = PageUtil.getEndIndex(page, rows);
		if (example != null) {
			IpoPubpaymentTrack record = new IpoPubpaymentTrack();
			BeanUtils.copyProperties(example, record);
			List<IpoPubpaymentTrack> datalist = pubpaymenttrackmapper
					.selectByPage(startIndex, endIndex, record);
			List<PubpaymentTrack> datalist2 = new ArrayList<PubpaymentTrack>();
			for (IpoPubpaymentTrack temp : datalist) {
				PubpaymentTrack info = new PubpaymentTrack();
				BeanUtils.copyProperties(temp, info);
				datalist2.add(info);
			}
			return datalist2;
		}
		return null;
	}

	@Override
	public Integer getTrackNum(PubpaymentTrack example) {
		if (example != null) {
			IpoPubpaymentTrack record = new IpoPubpaymentTrack();
			BeanUtils.copyProperties(example, record);
			return pubpaymenttrackmapper.getTarckNum(record);
		}
		return 0;
	}

	@Override
	@Transactional
	public Integer insertTrack(PubpaymentTrack example) {
		if (example != null) {
			IpoPubpaymentTrack record = new IpoPubpaymentTrack();
			BeanUtils.copyProperties(example, record);
			return pubpaymenttrackmapper.insert(record);
		}
		return 0;
	}

}
