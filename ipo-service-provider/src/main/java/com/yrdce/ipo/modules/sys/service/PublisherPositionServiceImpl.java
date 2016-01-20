package com.yrdce.ipo.modules.sys.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yrdce.ipo.common.utils.PageUtil;
import com.yrdce.ipo.modules.sys.dao.IpoPublisherPositionMapper;
import com.yrdce.ipo.modules.sys.entity.IpoPublisherPosition;
import com.yrdce.ipo.modules.sys.vo.PublisherPosition;

/**
 * @author chenjing
 *
 */
@Service
public class PublisherPositionServiceImpl implements PublisherPositionService {

	@Autowired
	private IpoPublisherPositionMapper publisherPositionmapper;

	@Override
	public List<PublisherPosition> getInfoByPage(String page, String rows,
			PublisherPosition example) {
		int startIndex = PageUtil.getStartIndex(page, rows);
		int endIndex = PageUtil.getEndIndex(page, rows);
		if (example != null) {
			IpoPublisherPosition record = new IpoPublisherPosition();
			BeanUtils.copyProperties(example, record);
			List<IpoPublisherPosition> datalist = publisherPositionmapper
					.selectByPage(startIndex, endIndex, record);
			List<PublisherPosition> datalist2 = new ArrayList<PublisherPosition>();
			for (IpoPublisherPosition temp : datalist) {
				PublisherPosition info = new PublisherPosition();
				BeanUtils.copyProperties(temp, info);
				datalist2.add(info);
			}
			return datalist2;
		}
		return null;
	}

	@Override
	public Integer getPubPositionNum(PublisherPosition example) {
		if (example != null) {
			IpoPublisherPosition record = new IpoPublisherPosition();
			BeanUtils.copyProperties(example, record);
			return publisherPositionmapper.getTotalNum(record);
		}
		return 0;
	}

	@Override
	public Integer insertPubPoition(PublisherPosition example) {
		if (example != null) {
			IpoPublisherPosition record = new IpoPublisherPosition();
			BeanUtils.copyProperties(example, record);
			return publisherPositionmapper.insert(record);
		}
		return 0;
	}

}
