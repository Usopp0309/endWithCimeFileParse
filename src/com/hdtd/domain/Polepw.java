package com.hdtd.domain;

import javax.persistence.Column;

public class Polepw extends BasePojo {


	@Column(name="I_node")
	private String I_node;			//物理连接节点
	
	@Column(name="rdfid")
	private String rdfid;			//资源标识
	
	
	
	
	
	public String getI_node() {
		return this.I_node;
	}
	public void setI_node(String I_node) {
		this.I_node = I_node;
	}	
	
	public String getRdfid() {
		return this.rdfid;
	}
	public void setRdfid(String rdfid) {
		this.rdfid = rdfid;
	}	
	
}
