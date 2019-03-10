package com.hdtd.domain2;

import javax.persistence.Column;

public class Substation extends BasePojo{
//	@Num	mRID	name	type	ControlArea	graph_name
//	//序号	标识	名称	厂站类型	区域	接线图名称
	private String type ;
	
	@Column(name="ControlArea")
	private String ControlArea ;
	
	private String  graph_name;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getControlArea() {
		return ControlArea;
	}
	public void setControlArea(String controlArea) {
		ControlArea = controlArea;
	}
	public String getGraph_name() {
		return graph_name;
	}
	public void setGraph_name(String graph_name) {
		this.graph_name = graph_name;
	}
	@Override
	public String toString() {
		return "Substation [type=" + type + ", ControlArea=" + ControlArea + ", graph_name=" + graph_name
				+ ", toString()=" + super.toString() + "]";
	}

	
	
	
	
	
}
