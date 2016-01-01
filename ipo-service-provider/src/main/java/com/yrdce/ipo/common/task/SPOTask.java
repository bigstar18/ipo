package com.yrdce.ipo.common.task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yrdce.ipo.modules.sys.dao.IpoSpoCommoditymanmaagementMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSpoRationMapper;
import com.yrdce.ipo.modules.sys.entity.IpoSpoCommoditymanmaagement;

/**
 * 增发状态定时任务
 * 
 * @author Bob
 */
public class SPOTask {

	static Logger logger = LoggerFactory.getLogger(SPOTask.class);
	@Autowired
	private IpoSpoRationMapper ipoSpoRationMapper;
	@Autowired
	private IpoSpoCommoditymanmaagementMapper ipoSPOCommMapper;

	public void runSPO() {
		logger.info("增发状态定时任务启动");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time = sdf.format(new Date());
		List<IpoSpoCommoditymanmaagement> list = ipoSPOCommMapper.select();
		// 遍历增发商品管理列表
		for (IpoSpoCommoditymanmaagement ipoSPOComm : list) {
			String spoid = ipoSPOComm.getSpoId();
			Date spoDate = ipoSPOComm.getSpoDate();
			String spotime = sdf.format(spoDate);
			// 时间判断，更新增发表状态
			if (time == spotime) {
				ipoSPOCommMapper.updateByStatus(4, spoid);
				logger.info("增发状态更新成功");
			}

			Date ipoDate = ipoSPOComm.getIpoDate();
			String ipotime = sdf.format(ipoDate);
			// 时间判断，更新配售表状态
			if (time == ipotime) {
				ipoSpoRationMapper.updateByStatus(3, spoid);
				logger.info("配售状态更新成功");
			}
		}

	}

}
