package com.hdtd.domain;

import javax.persistence.Column;

public class Breaker extends BasePojo {


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
	
	@Column(name="VoltageLevel")
	private String VoltageLevel;			//电压等级标识
	
	@Column(name="breakingCapacity")
	private String breakingCapacity;			//遮断电流
	
	
	
	
	
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
	
	public String getVoltageLevel() {
		return this.VoltageLevel;
	}
	public void setVoltageLevel(String VoltageLevel) {
		this.VoltageLevel = VoltageLevel;
	}	
	
	public String getBreakingCapacity() {
		return this.breakingCapacity;
	}
	public void setBreakingCapacity(String breakingCapacity) {
		this.breakingCapacity = breakingCapacity;
	}	
	
}
