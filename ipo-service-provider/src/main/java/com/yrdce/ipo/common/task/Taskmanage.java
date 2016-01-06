package com.yrdce.ipo.common.task;

import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.yrdce.ipo.modules.sys.service.TaskService;

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
}
