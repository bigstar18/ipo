package com.yrdce.ipo.modules.sys;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
 * ����ģ��  
 */
public class ConfigManager {
	private static ConfigManager configManager;
	// ����properties�����load����������ȡ�����ļ�
	private static Properties properties;

	private ConfigManager() {// ��ô��ȡһ�������ļ�
		String configFile = "main/resources/jeesite.properties";
		properties = new Properties();
		InputStream in = ConfigManager.class.getClassLoader()
				.getResourceAsStream(configFile);
		try {
			properties.load(in);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ������̵߳Ĳ���ģʽ
	public synchronized static ConfigManager getinstance() { // ��ȡһ��ʵ��ĵ���ģ��
																// ������
																// �൱�ڴ����
																// synchronized������.class��
																// ����synchronized(this)��Ϊ��̬����������this
		if (configManager == null) {
			configManager = new ConfigManager();
		}
		return configManager;
	}

	public String getString(String key) {
		return properties.getProperty(key);
	}

}
