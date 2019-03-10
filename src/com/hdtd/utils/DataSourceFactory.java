package com.hdtd.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;

import com.jolbox.bonecp.BoneCPDataSource;

public class DataSourceFactory {
	
	public static org.apache.commons.dbcp.BasicDataSource getDataSource(){
		BasicDataSource source = new BasicDataSource();
//		<property name="driverClassName" value="${jdbc.driver}" />
//		<property name="url" value="${jdbc.url}" />
//		<property name="username" value="${jdbc.username}" />
//		<property name="password" value="${jdbc.password}" />
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("config/db.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String driver = properties.getProperty("jdbc.driver");
		String url = properties.getProperty("jdbc.url");
		String username = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");
		
		source.setDriverClassName(driver);
		source.setUrl(url);
		source.setUsername(username);
		source.setPassword(password);
		return source;
	}
	
	public static  BoneCPDataSource getBoneCPDataSource(){
//		<bean id="dataSource" class="com.jolbox.bonecp.BoneCPDataSource"
//				destroy-method="close">
//				���ݿ�����
//				<property name="driverClass" value="${jdbc.driver}" />
//				��Ӧ������jdbcUrl
//				<property name="jdbcUrl" value="${jdbc.url}" />
//				���ݿ���û���
//				<property name="username" value="${jdbc.username}" />
//				���ݿ������
//				<property name="password" value="${jdbc.password}" />
//				������ݿ����ӳ��п������ӵļ��ʱ�䣬��λ�Ƿ֣�Ĭ��ֵ��240�����Ҫȡ��������Ϊ0
//				<property name="idleConnectionTestPeriod" value="60" />
//				���ӳ���δʹ�õ����������ʱ�䣬��λ�Ƿ֣�Ĭ��ֵ��60�����Ҫ��Զ�������Ϊ0
//				<property name="idleMaxAge" value="30" />
//				ÿ����������������
//				<property name="maxConnectionsPerPartition" value="150" />
//				ÿ��������С��������
//				<property name="minConnectionsPerPartition" value="5" />
		BoneCPDataSource source = new BoneCPDataSource();
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream(new File("config/db.properties")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String driver = properties.getProperty("jdbc.driver");
		String url = properties.getProperty("jdbc.url");
		String username = properties.getProperty("jdbc.username");
		String password = properties.getProperty("jdbc.password");
		
		source.setDriverClass(driver);
		source.setJdbcUrl(url);
		source.setUsername(username);
		source.setPassword(password);
		
		source.setIdleConnectionTestPeriod(60);
		source.setIdleMaxAge(30);
		source.setMaxConnectionsPerPartition(150);
		source.setMinConnectionsPerPartition(5);
		
		return source;
	}
	
}
