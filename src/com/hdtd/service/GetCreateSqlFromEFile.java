package com.hdtd.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hdtd.dao.BaseDao;
import com.hdtd.dao.BaseDaoImpl;
import com.hdtd.domain.Substation;
import com.hdtd.domain2.BaseVoltage;
import com.hdtd.domain2.ControlArea;
import com.hdtd.utils.EFileUtils;

public class GetCreateSqlFromEFile {
	public static void main(String[] args) throws Exception {
		//File file = new File("efile/chengde_20180108.CIME");
		File file = new File("efile/JB_DD_电力生产调度日报_NEW_20170817.CIME");
		int aa = 0;
		BufferedReader br = new BufferedReader(new FileReader(file));
		long q = System.currentTimeMillis();
		
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
				aa += 1;
				//判断表类型
				type = EFileUtils.getClassName(line);
				fieldLine = br.readLine();
				String commentString = br.readLine();
//				String replace = commentString.replace("//", "");
//				System.err.println(replace);
				createSql(type, fieldLine,commentString);
//				dropTableSql(type);
//				System.out.println(type);
//				getGenerator(type);
			}
			String dataLine ;	//数据行
			while(flag == true && (dataLine=br.readLine())!=null){
				if(dataLine.contains("</")){
//					System.out.println("结束");
					break;
				}
//				System.out.println(dataLine);
				
//				Map<String, Object> map = EFileUtils.getPojoMap(fieldLine,dataLine);
				
//				System.out.println(className);
//				Object obj = EFileUtils.getPojoFromMap(map, type);
//				System.out.println(obj.getClass().getSimpleName());
//				System.err.println(type);
				
//				if(type.equals("BaseVoltage")){
//					BaseDao<BaseVoltage> dao = new BaseDao<BaseVoltage>();
//					dao.saveOrUpdate(context,obj);
//				}
				BaseDao dao = null;
				switch (type) {
				case "BaseVoltage":
					dao = new BaseDaoImpl<BaseVoltage>();
//					new BaseDao<BaseVoltage>().saveOrUpdate(context,obj);
					break;
				case "ControlArea":
					dao = new BaseDaoImpl<ControlArea>();
					break;
				case "Substation":
					dao = new BaseDaoImpl<Substation>();
					break;

				default:
					break;
				}
				
				if(dao != null){
//					System.err.println("sdfsdfadsfafsdf");
//					dao.saveOrUpdate(context,obj);
				}
//				System.out.println(obj);
			}
		}
		System.out.println();
		System.out.println();
		System.err.println(aa);
		
		br.close();
		long w = System.currentTimeMillis();
//		System.out.println(w-q);
	}
	
	

	public static void createSql(String tableName,String fieldLine,String commentString){
//		CREATE TABLE `pwaclinesegment` (
//				  `Num` varchar(255) DEFAULT NULL,
//				  `mRID` varchar(255) NOT NULL,
//				  `name` varchar(255) DEFAULT NULL,
//				  `rdfid` varchar(255) DEFAULT NULL,
//				  `type` varchar(255) DEFAULT NULL,
//				  `I_node` varchar(255) DEFAULT NULL,
//				  `J_node` varchar(255) DEFAULT NULL,
//				  `ratedCurrent` varchar(255) DEFAULT NULL,
//				  `BaseVoltage` varchar(255) DEFAULT NULL,
//				  `Model` varchar(255) DEFAULT NULL,
//				  `Length` varchar(255) DEFAULT NULL,
//				  `ratedMW` varchar(255) DEFAULT NULL,
//				  `Feeder` varchar(255) DEFAULT NULL,
//				  PRIMARY KEY (`mRID`)
//				) ENGINE=InnoDB DEFAULT CHARSET=utf8;
//		String tableName = "";
//		 COMMENT '内容类目ID',
		String sql1 = "CREATE TABLE `"+tableName+"` ("
				+"`Num` varchar(255) DEFAULT NULL COMMENT '序号',"
				+ " `mRID` varchar(255) NOT NULL COMMENT '标识',"
				+ " `name` varchar(255) DEFAULT NULL COMMENT '名称',";
		String sql2 = "  PRIMARY KEY (`mRID`)"
				+ ") ENGINE=InnoDB DEFAULT CHARSET=utf8;";
		String sql3 = "";
		String[] fieldSplit = fieldLine.replace("@", "").split("\t");
		String[] comments = commentString.replace("//", "").split("\t");
		for (int i = 3; i < fieldSplit.length; i++) {
			String temp = " `"+fieldSplit[i]+"` varchar(255) DEFAULT NULL COMMENT '"+comments[i]+"',";
			sql3 += temp;
		}
		String sql = sql1 + sql3 + sql2;
		System.out.println(sql);
	}
	
	public static void dropTableSql(String tableName){
		String sql1 = "drop table `";
		String sql = sql1 + tableName+"`;";
		System.out.println(sql);
		
	}
	public static void getGenerator(String tableName){
		String gen = "		<table schema=\"\" tableName=\""+tableName+"\"></table>";
		System.out.println(gen);
	}
	

}
