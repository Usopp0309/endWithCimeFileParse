package com.hdtd.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hdtd.dao.BaseDao;
import com.hdtd.dao.BaseDaoImpl;
import com.hdtd.domain.Basevoltage;
import com.hdtd.domain.Controlarea;
import com.hdtd.domain.Substation;
import com.hdtd.utils.EFileUtils;
//827851
//842259
public class EParseServiceMain {
	public static void main(String[] args) throws Exception {
		//File file = new File("efile/chengde_20180108.CIME");
		File file = new File("efile/JB_DD_电力生产调度日报_NEW_20170817.CIME");
		BufferedReader br = new BufferedReader(new FileReader(file));
		long q = System.currentTimeMillis();
		long count = 0;
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		BaseVoltageMapper mapper = context.getBean(BaseVoltageMapper.class);
		
		String line;
		line=br.readLine();
		ArrayList list = new ArrayList();
		String type = "";
		while((line=br.readLine())!=null) {
			boolean flag = false;
			String fieldLine = "";
			
			if(line.contains("<") && !line.contains("</")){
				flag = true;
//				System.out.println("");
//				System.out.println("开始");
				//判断表类型
				type = EFileUtils.getClassName(line);
				fieldLine = br.readLine();
				br.readLine();
			}
			String dataLine ;	//数据行
			while(flag == true && (dataLine=br.readLine())!=null){
				if(dataLine.contains("</")){
//					System.out.println("结束");
					break;
				}
//				System.out.println(dataLine);
				System.err.println(count++);
				Map<String, Object> map = EFileUtils.getPojoMap(fieldLine,dataLine);
				
//				System.out.println(className);
				
//				Object obj = EFileUtils.getPojoFromMap(map, type);
				Object obj = EFileUtils.getPojoFromMap(map, EFileUtils.getName(type));
//				System.out.println(obj.getClass().getSimpleName());
//				System.err.println(type);
				
//				if(type.equals("BaseVoltage")){
//					BaseDao<BaseVoltage> dao = new BaseDao<BaseVoltage>();
//					dao.saveOrUpdate(context,obj);
//				}
				BaseDao dao = EFileUtils.getBaseDao(type);
				
				if(dao != null){
//					System.err.println("sdfsdfadsfafsdf");
					dao.saveOrUpdate(context,obj);
				}
//				System.out.println(obj);
			}
		}
		System.out.println();
		System.out.println();
		
		br.close();
		long w = System.currentTimeMillis();
		System.err.println(w-q);
	}
	
	

	
	

}
