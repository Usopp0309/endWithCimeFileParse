package com.hdtd.dao;

import org.springframework.context.ApplicationContext;

public interface BaseDao {
	
	public void saveOrUpdate(ApplicationContext context, Object obj) throws ClassNotFoundException ;
		
}
