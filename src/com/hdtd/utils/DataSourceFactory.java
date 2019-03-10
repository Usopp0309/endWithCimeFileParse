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
//				数据库驱动
//				<property name="driverClass" value="${jdbc.driver}" />
//				相应驱动的jdbcUrl
//				<property name="jdbcUrl" value="${jdbc.url}" />
//				数据库的用户名
//				<property name="username" value="${jdbc.username}" />
//				数据库的密码
//				<property name="password" value="${jdbc.password}" />
//				检查数据库连接池中空闲连接的间隔时间，单位是分，默认值：240，如果要取消则设置为0
//				<property name="idleConnectionTestPeriod" value="60" />
//				连接池中未使用的链接最大存活时间，单位是分，默认值：60，如果要永远存活设置为0
//				<property name="idleMaxAge" value="30" />
//				每个分区最大的连接数
//				<property name="maxConnectionsPerPartition" value="150" />
//				每个分区最小的连接数
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
