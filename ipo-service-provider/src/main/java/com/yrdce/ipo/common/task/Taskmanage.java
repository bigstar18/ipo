package com.yrdce.ipo.common.task;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.common.constant.PositionConstant;
import com.yrdce.ipo.modules.sys.service.PositionService;
import com.yrdce.ipo.modules.sys.service.TaskService;
import com.yrdce.ipo.modules.sys.vo.PositionReduce;

/**
 * 定时器
 * 
 * @author Bob
 * 
 */

public class Taskmanage extends TimerTask {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private TaskService taskService;
	@Autowired
	PositionService positionService;

	@Override
	@Transactional
	public void run() {
		try {
			taskService.distribution();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void lottery() {
		try {
			taskService.lottery();
			taskService.orderBalance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void ipoTransferGoodsPosition() {
		try {
			taskService.ipoTransferGoodsPosition();
		} catch (Exception e) {
			logger.error("ipo 转持仓失败:", e);
		}
	}

	//定期减持客户冻结数量
	public void reduceeCustomerHold() {
		logger.info("开始执行减持客户冻结数量");
		try {
			PositionReduce positionReduce = new PositionReduce();
			positionReduce.setState(PositionConstant.ReduceState.no_reduce.getCode());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date today = sdf.parse(sdf.format(new java.util.Date()));
			positionReduce.setReduceDate(today);
			List<PositionReduce> reduceList = positionService.queryReduceForList(positionReduce);
			if (reduceList == null || reduceList.isEmpty()) {
				logger.info("查询 持仓减持设置 记录数为 空");
				return;
			}
			;
			for (PositionReduce item : reduceList) {
				try {
					item.setUpdateUser("job");
					positionService.reduceeCustomerHold(item);
				} catch (Exception e) {
					logger.error("客户持仓减持异常", e);
				}
			}
			;
		} catch (Exception e) {
			logger.error("查询 持仓减持异常", e);
		}
		logger.info("结束执行减持客户冻结数量");
	}
}
