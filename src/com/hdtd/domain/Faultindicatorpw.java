package com.hdtd.domain;

import javax.persistence.Column;

public class Faultindicatorpw extends BasePojo {


	@Column(name="ConductingEquipment")
	private String ConductingEquipment;			//关联设备标识
	
	@Column(name="I_node")
	private String I_node;			//物理连接节点
	
	@Column(name="Substation")
	private String Substation;			//所属厂站/站房
	
	@Column(name="rdfid")
	private String rdfid;			//资源标识
	
	@Column(name="Feeder")
	private String Feeder;			//所属馈线
	
	
	
	
	
	public String getConductingEquipment() {
		return this.ConductingEquipment;
	}
	public void setConductingEquipment(String ConductingEquipment) {
		this.ConductingEquipment = ConductingEquipment;
	}	
	
	public String getI_node() {
		return this.I_node;
	}
	public void setI_node(String I_node) {
		this.I_node = I_node;
	}	
	
	public String getSubstation() {
		return this.Substation;
	}
	public void setSubstation(String Substation) {
		this.Substation = Substation;
	}	
	
	public String getRdfid() {
		return this.rdfid;
	}
	public void setRdfid(String rdfid) {
		this.rdfid = rdfid;
	}	
	
	public String getFeeder() {
		return this.Feeder;
	}
	public void setFeeder(String Feeder) {
		this.Feeder = Feeder;
	}	
	
}
