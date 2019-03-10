package com.hdtd.domain;

import javax.persistence.Column;

public class Powertransformerpw extends BasePojo {


	@Column(name="rdfid")
	private String rdfid;			//资源标识
	
	@Column(name="type")
	private String type;			//类型
	
	@Column(name="Substation")
	private String Substation;			//所属厂站/站房
	
	@Column(name="ratedMVA")
	private String ratedMVA;			//额定容量
	
	@Column(name="I_BaseVoltage")
	private String I_BaseVoltage;			//高端基准电压标识
	
	@Column(name="J_BaseVoltage")
	private String J_BaseVoltage;			//低端基准电压标识
	
	@Column(name="I_node")
	private String I_node;			//高端物理连接节点
	
	@Column(name="I_ratedMW")
	private String I_ratedMW;			//高端额定功率
	
	@Column(name="I_ratedkV")
	private String I_ratedkV;			//高端额定电压
	
	@Column(name="J_node")
	private String J_node;			//低端物理连接节点
	
	@Column(name="J_ratedMW")
	private String J_ratedMW;			//低端额定功率
	
	@Column(name="J_ratedkV")
	private String J_ratedkV;			//低端额定电压
	
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
	
	public String getSubstation() {
		return this.Substation;
	}
	public void setSubstation(String Substation) {
		this.Substation = Substation;
	}	
	
	public String getRatedMVA() {
		return this.ratedMVA;
	}
	public void setRatedMVA(String ratedMVA) {
		this.ratedMVA = ratedMVA;
	}	
	
	public String getI_BaseVoltage() {
		return this.I_BaseVoltage;
	}
	public void setI_BaseVoltage(String I_BaseVoltage) {
		this.I_BaseVoltage = I_BaseVoltage;
	}	
	
	public String getJ_BaseVoltage() {
		return this.J_BaseVoltage;
	}
	public void setJ_BaseVoltage(String J_BaseVoltage) {
		this.J_BaseVoltage = J_BaseVoltage;
	}	
	
	public String getI_node() {
		return this.I_node;
	}
	public void setI_node(String I_node) {
		this.I_node = I_node;
	}	
	
	public String getI_ratedMW() {
		return this.I_ratedMW;
	}
	public void setI_ratedMW(String I_ratedMW) {
		this.I_ratedMW = I_ratedMW;
	}	
	
	public String getI_ratedkV() {
		return this.I_ratedkV;
	}
	public void setI_ratedkV(String I_ratedkV) {
		this.I_ratedkV = I_ratedkV;
	}	
	
	public String getJ_node() {
		return this.J_node;
	}
	public void setJ_node(String J_node) {
		this.J_node = J_node;
	}	
	
	public String getJ_ratedMW() {
		return this.J_ratedMW;
	}
	public void setJ_ratedMW(String J_ratedMW) {
		this.J_ratedMW = J_ratedMW;
	}	
	
	public String getJ_ratedkV() {
		return this.J_ratedkV;
	}
	public void setJ_ratedkV(String J_ratedkV) {
		this.J_ratedkV = J_ratedkV;
	}	
	
	public String getFeeder() {
		return this.Feeder;
	}
	public void setFeeder(String Feeder) {
		this.Feeder = Feeder;
	}	
	
}
