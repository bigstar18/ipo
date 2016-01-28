package com.yrdce.ipo.modules.sys.entity;

import java.io.Serializable;

public class CTradeModule implements Serializable{

	private static final long serialVersionUID = 7992935568592772646L;
	
	private Long moduleId;
	private String cnName;
	private String enName;
	private String shortName;
	private String addFirmFn;
	private String updateFirmStatusFn;
	private String delFirmFn;
	private String isFirmSet;
	private String hostIp;
	private int port;
	private int rmiDataPort;
	private String isBalanceCheck;
	private String isNeedBreed;

	
	public CTradeModule() {
	}

	public Long getModuleId() {
		return moduleId;
	}

	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}

	public String getCnName() {
		return cnName;
	}

	public void setCnName(String cnName) {
		this.cnName = cnName;
	}

	public String getEnName() {
		return enName;
	}

	public void setEnName(String enName) {
		this.enName = enName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getAddFirmFn() {
		return addFirmFn;
	}

	public void setAddFirmFn(String addFirmFn) {
		this.addFirmFn = addFirmFn;
	}

	public String getUpdateFirmStatusFn() {
		return updateFirmStatusFn;
	}

	public void setUpdateFirmStatusFn(String updateFirmStatusFn) {
		this.updateFirmStatusFn = updateFirmStatusFn;
	}

	public String getDelFirmFn() {
		return delFirmFn;
	}

	public void setDelFirmFn(String delFirmFn) {
		this.delFirmFn = delFirmFn;
	}

	public String getIsFirmSet() {
		return isFirmSet;
	}

	public void setIsFirmSet(String isFirmSet) {
		this.isFirmSet = isFirmSet;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public int getRmiDataPort() {
		return rmiDataPort;
	}

	public void setRmiDataPort(int rmiDataPort) {
		this.rmiDataPort = rmiDataPort;
	}

	public String getIsBalanceCheck() {
		return isBalanceCheck;
	}

	public void setIsBalanceCheck(String isBalanceCheck) {
		this.isBalanceCheck = isBalanceCheck;
	}

	public String getIsNeedBreed() {
		return isNeedBreed;
	}

	public void setIsNeedBreed(String isNeedBreed) {
		this.isNeedBreed = isNeedBreed;
	}
	
	
	
	

}
