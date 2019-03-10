package com.hdtd.test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import org.apache.commons.beanutils.BeanUtils;

public class Testt {
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
		HashMap map = new HashMap();
		map.put("num", 1);
		map.put("user_name", "namee");
		User user = new User();
		BeanUtils.populate(user, map);
		System.out.println(user);
	}
}	
