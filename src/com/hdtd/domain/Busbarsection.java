package com.hdtd.domain;

import javax.persistence.Column;

public class Busbarsection extends BasePojo {


	@Column(name="I_node")
	private String I_node;			//母线节点号
	
	@Column(name="Substation")
	private String Substation;			//所属厂站/站房
	
	@Column(name="BaseVoltage")
	private String BaseVoltage;			//基准电压标识
	
	@Column(name="VoltageLevel")
	private String VoltageLevel;			//电压等级标识
	
	@Column(name="vmax")
	private String vmax;			//电压上限
	
	@Column(name="vmin")
	private String vmin;			//电压下限
	
	
	
	
	
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
	
	public String getVmax() {
		return this.vmax;
	}
	public void setVmax(String vmax) {
		this.vmax = vmax;
	}	
	
	public String getVmin() {
		return this.vmin;
	}
	public void setVmin(String vmin) {
		this.vmin = vmin;
	}	
	
}
