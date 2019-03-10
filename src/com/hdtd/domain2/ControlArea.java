package com.hdtd.domain2;

import javax.persistence.Table;

import com.hdtd.domain.BasePojo;

@Table(name="ControlArea")
public class ControlArea extends BasePojo{
//	private String Num;
//	private String mRID;
//	private String name;
	
	
	private String Parent;
	
	public String getParent() {
		return Parent;
	}
	public void setParent(String parent) {
		Parent = parent;
	}
	@Override
	public String toString() {
		return "ControlArea [Parent=" + Parent + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
