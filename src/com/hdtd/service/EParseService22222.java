package com.hdtd.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hdtd.dao.BaseDaoImpl;
import com.hdtd.domain2.BaseVoltage;
import com.hdtd.mapper2.BaseVoltageMapper;
import com.hdtd.utils.EFileUtils;

public class EParseService22222 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("efile/chengde_20180108aa.CIME"));
		long q = System.currentTimeMillis();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		BaseVoltageMapper mapper = context.getBean(BaseVoltageMapper.class);
		
		String line;
		line=br.readLine();
		//1:br.readLine()
		//2:line=br.readLine()
		//3:line != null
		ArrayList list = new ArrayList();
		String type = "";
		while((line=br.readLine())!=null) {
			boolean flag = false;
			String fieldLine = "";
			
			if(line.contains("<") && !line.contains("</")){
				flag = true;
				System.out.println("");
				System.out.println("开始");
				//判断表类型
//				if(line.contains("BaseVoltage")){
//					System.out.println("----BaseVoltage");
//					type = "BaseVoltage";
//				}
//				if(line.contains("ControlArea")){
//					type="ControlArea";
//					System.out.println("==========ControlArea");
//				}
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
				System.out.println(dataLine);
				
				Map<String, Object> map = EFileUtils.getPojoMap(fieldLine,dataLine);
				String className = "com.hdtd.domain."+type;
//				System.out.println(className);
				Object obj = topojo(map, type, className);
//				System.out.println(obj.getClass().getSimpleName());
//				System.err.println(type);
				if(type.equals("BaseVoltage")){
//					System.out.println("typeeeeeeeeeeeeeeeeee");
					BaseDaoImpl<BaseVoltage> dao = new BaseDaoImpl<BaseVoltage>();
					dao.saveOrUpdate(context,obj);
					
//					mapper.insertSelective((BaseVoltage)obj);
//					BaseVoltage b = (BaseVoltage)obj;
//					BaseVoltage k = mapper.selectByPrimaryKey(b.getmRID());
//					System.err.println(k);
					
				}
//				System.out.println(obj);
			}
			
			
			
		}
		

		System.out.println();
		System.out.println();
		
		br.close();
		long w = System.currentTimeMillis();
//		System.out.println(w-q);
		
	}
	
	

	
	
	public static <T> T topojo(Map<String, Object> map,String type,String className) throws ClassNotFoundException, Exception {
		Class clazz = Class.forName(className);
		Object obj = clazz.newInstance();
		BeanUtils.populate(obj, map);
		System.out.println(obj);
		return (T)obj;
		
	}
}
