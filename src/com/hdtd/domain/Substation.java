package com.hdtd.domain;

import javax.persistence.Column;

public class Substation extends BasePojo {


	@Column(name="type")
	private String type;			//厂站类型
	
	@Column(name="ControlArea")
	private String ControlArea;			//区域
	
	@Column(name="graph_name")
	private String graph_name;			//接线图名称
	
	
	
	
	
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}	
	
	public String getControlArea() {
		return this.ControlArea;
	}
	public void setControlArea(String ControlArea) {
		this.ControlArea = ControlArea;
	}	
	
	public String getGraph_name() {
		return this.graph_name;
	}
	public void setGraph_name(String graph_name) {
		this.graph_name = graph_name;
	}	
	
}
