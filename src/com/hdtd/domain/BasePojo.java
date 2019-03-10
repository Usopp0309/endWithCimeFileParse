package com.hdtd.domain;

import javax.persistence.Column;
import javax.persistence.Id;

public class BasePojo {
	@Column(name="Num")
	private String Num;		//ÐòºÅ
	
	@Id
	@Column(name="mRID")
	private String mRID;	//±êÊ¶
	
	
	private String name;	//Ãû³Æ
	
	public String getNum() {
		return Num;
	}
	public void setNum(String num) {
		this.Num = num;
	}
	public String getmRID() {
		return mRID;
	}
	public void setmRID(String mRID) {
		this.mRID = mRID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BasePojo [Num=" + Num + ", mRID=" + mRID + ", name=" + name + "]";
	}
	
	
	
	
}
