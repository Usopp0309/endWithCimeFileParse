package com.hdtd.domain;

import javax.persistence.Column;

public class Rectifierinverter extends BasePojo {


	@Column(name="bridges")
	private String bridges;			//换流器桥数
	
	@Column(name="ratedKV")
	private String ratedKV;			//换流器的铭牌
	
	@Column(name="Substation")
	private String Substation;			//所属厂站/站房
	
	@Column(name="I_node")
	private String I_node;			//正极连接点号
	
	@Column(name="J_node")
	private String J_node;			//负极连接点号
	
	@Column(name="Z_node")
	private String Z_node;			//交流侧连接点号
	
	@Column(name="BaseVoltage")
	private String BaseVoltage;			//交流侧基准电压标识
	
	
	
	
	
	public String getBridges() {
		return this.bridges;
	}
	public void setBridges(String bridges) {
		this.bridges = bridges;
	}	
	
	public String getRatedKV() {
		return this.ratedKV;
	}
	public void setRatedKV(String ratedKV) {
		this.ratedKV = ratedKV;
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
	
	public String getJ_node() {
		return this.J_node;
	}
	public void setJ_node(String J_node) {
		this.J_node = J_node;
	}	
	
	public String getZ_node() {
		return this.Z_node;
	}
	public void setZ_node(String Z_node) {
		this.Z_node = Z_node;
	}	
	
	public String getBaseVoltage() {
		return this.BaseVoltage;
	}
	public void setBaseVoltage(String BaseVoltage) {
		this.BaseVoltage = BaseVoltage;
	}	
	
}
