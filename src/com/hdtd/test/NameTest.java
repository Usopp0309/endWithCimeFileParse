package com.hdtd.test;

import com.hdtd.utils.EFileUtils;

public class NameTest {
	public static void main(String[] args) {
//		String aa = "<BaseVoltage::³ÐµÂÅäÍø>";
//		String tableName = aa.replace("<", "").split("::")[0];
//		if(aa.contains("ÅäÍø")){
//			tableName += "PW";
//		}
//		System.out.println(tableName);
		
		
//		String bb = "ControlArea";
//		String bb = "";
//		System.out.println(bb.length());
//		String start = String.valueOf(bb.charAt(0)).toLowerCase();
//		String end = "";
//		System.out.println(start);
//		if(bb.length()>1){
//			end = bb.substring(1);
//		}
//		String cc = start + end;
//		System.out.println(cc);
		String s = EFileUtils.firstChar2Lower(null);		
		System.out.println(s);
		
	}
}
