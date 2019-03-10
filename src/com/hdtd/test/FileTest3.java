package com.hdtd.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

import com.hdtd.utils.EFileUtils;

public class FileTest3 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new FileReader("efile/chengde_20180108aa.CIME"));
		long q = System.currentTimeMillis();
		
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
					System.out.println("结束");
					System.out.println("结束");
					System.out.println();
//					flag == true
					break;
				}
				System.out.println(dataLine);
				Map<String, Object> map = zhuan(fieldLine,dataLine);
				String className = "com.hdtd.domain."+type;
				System.out.println(className);
				Object object = topojo(map, type, className);
			}
			
			
			
		}
		

		System.out.println();
		System.out.println();
		
		br.close();
		long w = System.currentTimeMillis();
//		System.out.println(w-q);
		
	}
	
	
	public static Map<String, Object> zhuan(String fieldLine,String dataLine){
		//字段行
		String[] fieldSplit = fieldLine.replace("@", "").split("\t");
//		for (String string : fieldSplit) {
//			System.out.println(string);
//		}
		
		//数据行
		dataLine = dataLine.replace("#\t", "");
//		System.out.println(dataLine);
		String[] dataSplit = dataLine.split("\t");
//		for (String string : dataSplit) {
//			System.out.println(string);
//		}
		Map<String, Object> map = new HashMap<String,Object>();
		for (int i = 0; i < fieldSplit.length; i++) {
			fieldSplit[i] = EFileUtils.firstChar2Lower(fieldSplit[i]);
//			if("Num".equals(fieldSplit[i])){
//				fieldSplit[i] = "num";
//			}
//			System.out.println(fieldSplit[i]+" = "+dataSplit[i]);
			map.put(fieldSplit[i], dataSplit[i]);
		}
		System.out.println(map);
		
		return map;
	}
	
	
	public static <T> T topojo(Map<String, Object> map,String type,String className) throws ClassNotFoundException, Exception {
		Class clazz = Class.forName(className);
		Object obj = clazz.newInstance();
		BeanUtils.populate(obj, map);
		System.out.println(obj);
//		switch (type){
//			case "BaseVoltage":
//				
//			case "":
//				
//		}
		return null;
		
	}
	
}
