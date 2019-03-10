package com.hdtd.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JTextArea;

import org.springframework.context.ApplicationContext;

import com.hdtd.dao.BaseDao;
import com.hdtd.gui.JProcessBarDemo;
import com.hdtd.pojo.DataPojo;
import com.hdtd.utils.EFileUtils;
//827851
//842259
public class EParseService {
	
	
	
	public  void parseEfile(ApplicationContext context,File file,JTextArea textArea) throws Exception {
//		File file = new File("efile/chengde_20180108.CIME");
//		final JProcessBarDemo JPBD = new JProcessBarDemo();
//		JPBD.setVisible(true);
//		Thread.sleep(100);
		
//		BufferedReader br = new BufferedReader(new FileReader(file));
		long q = System.currentTimeMillis();
		long count = 0;
		
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		BaseVoltageMapper mapper = context.getBean(BaseVoltageMapper.class);
		
//		String readLine;
//		readLine=br.readLine();
//		ArrayList<String> list = new ArrayList();
//		long maxLine = 0;
//		System.out.println("开始");
//		textArea.append("开始"+"\n");
//		while((readLine=br.readLine())!=null) {
//			list.add(readLine);
//			maxLine++;
////			if(textArea != null ){
////				textArea.append(maxLine+"\n");
////			}
//		}
		DataPojo dataPojo = getDataPojoFromFile(file);
		List<String> list = dataPojo.getList();
		Integer maxLine = dataPojo.getMaxLine();
//		JPBD.setMaximum(Integer.valueOf(maxLine+""));
	
		String type = "";
//		while((line=br.readLine())!=null) {
		for (int i = 0; i < list.size(); i++) {
			String line = list.get(i);
//		}
		//		{
			boolean flag = false;
			String fieldLine = "";
			
			if(line.contains("<") && !line.contains("</")){
				flag = true;
//				System.out.println("");
//				System.out.println("开始");
				//判断表类型
				type = EFileUtils.getClassName(line);
//				fieldLine = br.readLine();
				fieldLine = list.get(++i);
//				br.readLine();
				list.get(++i);
			}
			String dataLine ;	//数据行
//			while(flag == true && (dataLine=br.readLine())!=null){
			while(flag == true && (dataLine=list.get(++i))!=null){
				if(dataLine.contains("</")){
//					System.out.println("结束");
					break;
				}
//				System.out.println(dataLine);
				System.err.println(i);
//				System.err.println(count++);
				
//				if(count == 8){		//异常测试
//					int a = 1/0;
//					System.out.println("sdfasdfasdf");
//				}
				
				
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
					if(i == 10){
//						int a = 1/0;
					}
					
//					int qq = i % 2000;
//					if(qq >= 0 && qq <30){
//						System.out.println("sdfasdfasdffds");
//						final int a = i;
////						Thread.sleep(10);
//						JPBD.setValue(a);
////						new Runnable() {
////							
////							@Override
////							public void run() {
////								System.out.println("sdfa");
////								JPBD.setValue(a);
////							}
////						};
//					}
					
				}
//				System.out.println(obj);
			}
		}
		System.out.println();
		System.out.println();
		
//		br.close();
		long w = System.currentTimeMillis();
		System.err.println(w-q);
	}
	
	
	public DataPojo getDataPojoFromFile(File file) throws IOException{
		DataPojo dataPojo = new DataPojo();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String readLine;
		readLine=br.readLine();
		ArrayList<String> list = new ArrayList();
		int maxLine = 0;
		System.out.println("开始");
//		textArea.append("开始"+"\n");
		while((readLine=br.readLine())!=null) {
			list.add(readLine);
			maxLine++;
//			if(textArea != null ){
//				textArea.append(maxLine+"\n");
//			}
		}
		br.close();
		dataPojo.setList(list);
		dataPojo.setMaxLine(maxLine);
		return dataPojo;
	}
	

	
	

}
