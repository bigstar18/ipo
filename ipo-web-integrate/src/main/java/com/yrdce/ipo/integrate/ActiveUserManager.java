package com.yrdce.ipo.integrate;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import gnnt.MEBS.common.mgr.model.User;
import gnnt.MEBS.logonServerUtil.au.AUConnectManager;
import gnnt.MEBS.logonServerUtil.au.LogonActualize;
import gnnt.MEBS.logonService.dao.LogonManagerDAO;
import gnnt.MEBS.logonService.kernel.ILogonService;
import gnnt.MEBS.logonService.po.LogonConfigPO;
import gnnt.MEBS.logonService.vo.CheckUserResultVO;
import gnnt.MEBS.logonService.vo.CheckUserVO;
import gnnt.MEBS.logonService.vo.LogoffVO;
import gnnt.MEBS.logonService.vo.RemoteLogonServerVO;
import gnnt.MEBS.logonService.vo.UserManageVO;

public abstract class ActiveUserManager {
	private static final transient Logger logger = LoggerFactory.getLogger(ActiveUserManager.class);

	private static Map<Integer, RemoteLogonServerVO> logonManagerMap = new HashMap<Integer, RemoteLogonServerVO>();
	public static DataSource ds;
	static int configId = 223001;
	static QueryDao queryDao;

	public static CheckUserResultVO checkUser(String userID, long sessionID, int fromModuleID, String selfLogonType, String fromLogonType,
			int selfModuleID) {
		CheckUserResultVO checkUserResultVO = new CheckUserResultVO();
		CheckUserVO checkUserVO = new CheckUserVO();
		checkUserVO.setUserID(userID);
		checkUserVO.setSessionID(sessionID);
		checkUserVO.setToModuleID(selfModuleID);
		checkUserVO.setLogonType(selfLogonType);
		checkUserResultVO = checkUser(checkUserVO, fromModuleID, fromLogonType);
		return checkUserResultVO;
	}

	/**
	 * 
	 * 用户跳转 <br/>
	 * <br/>
	 * 
	 * @param checkUserVO
	 *            登录 RMI 信息
	 * @param fromModuleID
	 *            来源模块编号
	 * @param fromLogonType
	 *            来源登录类型 (web web服务登录、pc 电脑客户端登录、mobile 手机客户端登录)
	 * @return
	 */
	public static CheckUserResultVO checkUser(CheckUserVO checkUserVO, int fromModuleID, String fromLogonType) {
		CheckUserResultVO result = new CheckUserResultVO();
		result.setResult(-1);
		ILogonService logonService = null;

		RemoteLogonServerVO remoteLogonServerVO = null;
		if (checkUserVO.getToModuleID() > 0) {
			remoteLogonServerVO = getRemoteLogonServerVO(Integer.valueOf(configId));// TODO
		} else {
			remoteLogonServerVO = AUConnectManager.getInstance().getRemoteLogonServerVO();
		}
		try {
			logonService = remoteLogonServerVO.getRmiService();
			result = logonService.checkUser(checkUserVO, fromModuleID, fromLogonType);
			logger.info("userId={}, fromModuleID={}, configId={}, fromLogonType={},logonService.checkUser result is: {}", checkUserVO.getUserID(),
					fromModuleID, configId, fromLogonType, result.getResult() + result.getMessage());
		} catch (RemoteException e) {
			int times = remoteLogonServerVO.clearRMI();
			try {
				logonService = remoteLogonServerVO.getRmiService();
				result = logonService.checkUser(checkUserVO, fromModuleID, fromLogonType);
			} catch (RemoteException e1) {
				// if (clearRMITimes > 0 && times > clearRMITimes) {
				// LogonConfigPO logonConfigPO =
				// logonManagerDAO.getLogonConfigByID(selfConfigID);
				// remoteLogonServerVO.setLogonConfigPO(logonConfigPO);
				// }
				result.setRecode("-1");
				result.setMessage("调用 AU 异常");
				logger.error("调用 AU 异常", e1);
			} catch (Exception e1) {
				result.setRecode("-1");
				result.setMessage("调用 AU 异常");
				logger.error("调用 AU 异常", e1);
			}
		} catch (Exception e) {
			result.setRecode("-1");
			result.setMessage("调用 AU 异常");
			logger.error("调用 AU 异常", e);
		}
		return result;
	}

	/**
	 * 没啥用
	 * 
	 * @param traderID
	 * @param request
	 * @param sessionID
	 * @param logonType
	 * @param selfModuleID
	 * @return
	 */
	public static boolean logon(String sysType, String traderID, HttpServletRequest request, long sessionID, String logonType, int selfModuleID) {
		boolean result = true;

		if ("mgr".equals(sysType))
			mgrLogon(traderID, request, sessionID, logonType, selfModuleID);

		request.getSession().setAttribute("sessionID", Long.valueOf(sessionID));
		request.getSession().setAttribute("LogonType", logonType);
		request.getSession().setMaxInactiveInterval(120 * 60);

		return result;
	}

	private static void mgrLogon(String traderID, HttpServletRequest request, long sessionID, String logonType, int selfModuleID) {
		// 获取登录用户信息
		User user = (User) queryDao.getUserByID(traderID).clone();

		// 记录 AU Session
		user.setSessionId(sessionID);
		// 记录登录地址
		user.setIpAddress(request.getRemoteAddr());
		user.setLogonType(logonType);
		user.setModuleID(selfModuleID);
		// 是否超级/高级管理员
		boolean isSuperAdminRole = false;
		if ("DEFAULT_SUPER_ADMIN".equals(user.getType())// 超级管理员
				|| "DEFAULT_ADMIN".equals(user.getType())) {// 高级管理员
			isSuperAdminRole = true;
			user.setRoleSet(queryDao.getAllRole());
			user.setRightSet(queryDao.getAllRight());
		} else {

			user.setRoleSet(queryDao.getUserRole(traderID));
			user.setRightSet(queryDao.getUserRight(traderID));
		}
		request.getSession().setAttribute("IsSuperAdmin", Boolean.valueOf(isSuperAdminRole));
		request.getSession().setAttribute("mgrUser", user);
	}

	public static void logoff(HttpServletRequest request) throws Exception {

		UserManageVO user = (UserManageVO) request.getSession().getAttribute("CurrentUser");
		request.getSession().invalidate();
		if (user != null) {
			LogoffVO logoffVO = new LogoffVO();
			logoffVO.setSessionID(user.getSessionID());
			logoffVO.setUserID(user.getUserID());
			logoffVO.setLogonType(user.getLogonType());
			logoffVO.setModuleID(user.getModuleIDList().get(0));
			LogonActualize actualize = LogonActualize.getInstance();
			if (actualize != null) {
				actualize.logoff(logoffVO);
			}
		}
	}

	/**
	 * 
	 * 获取对应 AU 连接信息 <br/>
	 * <br/>
	 * 
	 * @param configID
	 *            AU 编号
	 * @return
	 */
	public static RemoteLogonServerVO getRemoteLogonServerVO(int configID) {
		if (logonManagerMap.get(configID) == null) {
			synchronized (ActiveUserManager.class) {
				LogonManagerDAO logonManagerDAO = new LogonManagerDAO();
				logonManagerDAO.setDataSource(ds);
				LogonConfigPO logonConfigPO = logonManagerDAO.getLogonConfigByID(configID);
				if (logonConfigPO != null) {
					RemoteLogonServerVO logonManager = new RemoteLogonServerVO();
					logonManager.setLogonConfigPO(logonConfigPO);
					// AU RMI 连接Map
					logonManagerMap.put(configID, logonManager);
				}
			}
		}
		return logonManagerMap.get(configID);
	}
}
