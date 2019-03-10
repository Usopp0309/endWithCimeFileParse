package com.hdtd.domain;

import javax.persistence.Column;

public class Feederpw extends BasePojo {


	@Column(name="rdfid")
	private String rdfid;			//资源标识
	
	@Column(name="HVSubstation")
	private String HVSubstation;			//电源厂站
	
	@Column(name="graph_name")
	private String graph_name;			//馈线图名称
	
	
	
	
	
	public String getRdfid() {
		return this.rdfid;
	}
	public void setRdfid(String rdfid) {
		this.rdfid = rdfid;
	}	
	
	public String getHVSubstation() {
		return this.HVSubstation;
	}
	public void setHVSubstation(String HVSubstation) {
		this.HVSubstation = HVSubstation;
	}	
	
	public String getGraph_name() {
		return this.graph_name;
	}
	public void setGraph_name(String graph_name) {
		this.graph_name = graph_name;
	}	
	
}
