package com.hdtd.main;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hdtd.service.EParseService;

public class EParseMain {
	
	
	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
//		new ClassPathXmlApplicationContext(new String[]{"",""});
		//File file = new File("efile/chengde_20180108aa.CIME");
		File file = new File("efile/JB_DD_电力生产调度日报_NEW_20170817.CIME");
		
		EParseService eParseService = new EParseService();
		eParseService.parseEfile(context,file,null);
	}
	
	
}
