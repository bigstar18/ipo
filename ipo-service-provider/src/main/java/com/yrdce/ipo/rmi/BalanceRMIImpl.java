package com.yrdce.ipo.rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;
import java.rmi.server.UnicastRemoteObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.yrdce.ipo.modules.sys.dao.CTradeModuleMapper;
import com.yrdce.ipo.modules.sys.dao.IpoSysStatusMapper;
import com.yrdce.ipo.modules.sys.entity.CTradeModule;
import com.yrdce.ipo.modules.sys.entity.IpoSysStatus;

import gnnt.MEBS.common.communicate.IBalanceRMI;
import gnnt.MEBS.common.communicate.model.BalanceVO;

/**
 * 财务结算
 * 
 * @author wq 2016-1-28
 * 
 */

public class BalanceRMIImpl extends UnicastRemoteObject implements IBalanceRMI {

	private static final long serialVersionUID = 3179579252603281728L;
	protected Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired
	private IpoSysStatusMapper sysStatusMapper;
	@Autowired
	private CTradeModuleMapper tradeModuleMapper;
	//IPO 模块
	public static final Long MODULEID = 40L;

	protected BalanceRMIImpl() throws RemoteException {
		super();
	}

	public BalanceVO checkBalance() throws RemoteException {
		BalanceVO localBalanceVO = new BalanceVO();
		IpoSysStatus sysStatus = sysStatusMapper.selectAll();
		localBalanceVO.setTradeDate(sysStatus.getTradedate());
		if (sysStatus.getStatus() == 3 || sysStatus.getStatus() == 10) {
			localBalanceVO.setBalanceStatus(true);
		} else {
			localBalanceVO.setBalanceStatus(false);
			localBalanceVO.setMessage("IPO 结算未完成!");
		}
		logger.info("RMI服务(balanceRMI)当前系统状态为:{}", sysStatus.getStatus());
		return localBalanceVO;
	}

	public boolean noticeSubsystemStatus() throws RemoteException {
		// 更新状态
		IpoSysStatus sysStatus = sysStatusMapper.selectAll();
		sysStatus.setStatus((short) 3);
		sysStatusMapper.updateByPrimaryKey(sysStatus);
		logger.info("RMI服务(balanceRMI)更新系统状态为:{}", sysStatus.getStatus());
		return true;
	}

	public void init() {

		logger.info("RMI服务(balanceRMI)开始启动");
		CTradeModule tradeModule = tradeModuleMapper.findById(MODULEID);
		String host = tradeModule.getHostIp();
		int registryPort = tradeModule.getPort();
		int servicePort = tradeModule.getRmiDataPort();
		String url = "rmi://" + host + ":" + registryPort + "/balanceRMI";
		try {
			RMISocketFactory.setSocketFactory(new RMIDataSocket(servicePort));
			LocateRegistry.createRegistry(tradeModule.getPort());
			Naming.rebind(url, this);
			logger.info("RMI服务(balanceRMI)启动成功:" + url);
		} catch (Exception e) {
			logger.error("RMI服务(balanceRMI)启动失败:{},原因:{}", url, e);
			throw new RuntimeException(e);
		}

	}

}
