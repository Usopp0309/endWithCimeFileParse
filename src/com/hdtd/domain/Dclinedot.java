package com.hdtd.domain;

import javax.persistence.Column;

public class Dclinedot extends BasePojo {


	@Column(name="DCLineSegment")
	private String DCLineSegment;			//直流线段标识
	
	@Column(name="Substation")
	private String Substation;			//所属厂站/站房
	
	@Column(name="I_node")
	private String I_node;			//物理连接节点号
	
	@Column(name="BaseVoltage")
	private String BaseVoltage;			//基准电压标识
	
	
	
	
	
	public String getDCLineSegment() {
		return this.DCLineSegment;
	}
	public void setDCLineSegment(String DCLineSegment) {
		this.DCLineSegment = DCLineSegment;
	}	
	
	public String getSubstation() {
		return this.Substation;
	}
	public void setSubstation(String Substation) {
		this.Substation = Substation;
	}	
	
	public String getI_node() {
		return this.I_node;
	}
	public void setI_node(String I_node) {
		this.I_node = I_node;
	}	
	
	public String getBaseVoltage() {
		return this.BaseVoltage;
	}
	public void setBaseVoltage(String BaseVoltage) {
		this.BaseVoltage = BaseVoltage;
	}	
	
}
