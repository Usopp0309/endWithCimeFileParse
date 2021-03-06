package com.hdtd.domain;

import javax.persistence.Column;

public class Breakerpw extends BasePojo {


	@Column(name="rdfid")
	private String rdfid;			//资源标识
	
	@Column(name="type")
	private String type;			//类型
	
	@Column(name="I_node")
	private String I_node;			//物理连接节点号
	
	@Column(name="J_node")
	private String J_node;			//物理连接节点号
	
	@Column(name="Substation")
	private String Substation;			//所属厂站/站房
	
	@Column(name="BaseVoltage")
	private String BaseVoltage;			//基准电压标识
	
	@Column(name="normalOpen")
	private String normalOpen;			//常开位
	
	@Column(name="breakingCapacity")
	private String breakingCapacity;			//遮断电流
	
	@Column(name="CompositeSwitch")
	private String CompositeSwitch;			//所属组合开关
	
	@Column(name="Feeder")
	private String Feeder;			//所属馈线
	
	
	
	
	
	public String getRdfid() {
		return this.rdfid;
	}
	public void setRdfid(String rdfid) {
		this.rdfid = rdfid;
	}	
	
	public String getType() {
		return this.type;
	}
	public void setType(String type) {
		this.type = type;
	}	
	
	public String getI_node() {
		return this.I_node;
	}
	public void setI_node(String I_node) {
		this.I_node = I_node;
	}	
	
	public String getJ_node() {
		return this.J_node;
	}
	public void setJ_node(String J_node) {
		this.J_node = J_node;
	}	
	
	public String getSubstation() {
		return this.Substation;
	}
	public void setSubstation(String Substation) {
		this.Substation = Substation;
	}	
	
	public String getBaseVoltage() {
		return this.BaseVoltage;
	}
	public void setBaseVoltage(String BaseVoltage) {
		this.BaseVoltage = BaseVoltage;
	}	
	
	public String getNormalOpen() {
		return this.normalOpen;
	}
	public void setNormalOpen(String normalOpen) {
		this.normalOpen = normalOpen;
	}	
	
	public String getBreakingCapacity() {
		return this.breakingCapacity;
	}
	public void setBreakingCapacity(String breakingCapacity) {
		this.breakingCapacity = breakingCapacity;
	}	
	
	public String getCompositeSwitch() {
		return this.CompositeSwitch;
	}
	public void setCompositeSwitch(String CompositeSwitch) {
		this.CompositeSwitch = CompositeSwitch;
	}	
	
	public String getFeeder() {
		return this.Feeder;
	}
	public void setFeeder(String Feeder) {
		this.Feeder = Feeder;
	}	
	
}
