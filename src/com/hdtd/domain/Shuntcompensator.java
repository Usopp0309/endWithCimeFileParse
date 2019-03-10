package com.hdtd.domain;

import javax.persistence.Column;

public class Shuntcompensator extends BasePojo {


	@Column(name="nomQ")
	private String nomQ;			//额定容量
	
	@Column(name="V_rate")
	private String V_rate;			//额定电压
	
	@Column(name="I_node")
	private String I_node;			//物理连接节点
	
	@Column(name="BaseVoltage")
	private String BaseVoltage;			//基准电压标识
	
	@Column(name="VoltageLevel")
	private String VoltageLevel;			//电压等级标识
	
	@Column(name="Substation")
	private String Substation;			//所属厂站/站房
	
	
	
	
	
	public String getNomQ() {
		return this.nomQ;
	}
	public void setNomQ(String nomQ) {
		this.nomQ = nomQ;
	}	
	
	public String getV_rate() {
		return this.V_rate;
	}
	public void setV_rate(String V_rate) {
		this.V_rate = V_rate;
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
	
	public String getVoltageLevel() {
		return this.VoltageLevel;
	}
	public void setVoltageLevel(String VoltageLevel) {
		this.VoltageLevel = VoltageLevel;
	}	
	
	public String getSubstation() {
		return this.Substation;
	}
	public void setSubstation(String Substation) {
		this.Substation = Substation;
	}	
	
}
