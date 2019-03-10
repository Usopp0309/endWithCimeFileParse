package com.hdtd.domain;

import javax.persistence.Column;

import com.hdtd.domain2.BasePojoTwo;

public class Dlscddmonthpaper  extends BasePojoTwo {
//Num	  attrName	                                               attrValue
	 
	 @Column(name="attrName")
	 private String attrName;
	
	public String getAttrName() {
		return attrName;
	}
	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}
	@Override
	public String toString() {
		return "DlscddMonthPaper [attrName=" + attrName + "]";
	}


}
