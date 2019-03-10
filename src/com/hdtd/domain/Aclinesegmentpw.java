package com.hdtd.domain;

import javax.persistence.Column;

public class Aclinesegmentpw extends BasePojo {


	@Column(name="rdfid")
	private String rdfid;			//资源标识
	
	@Column(name="type")
	private String type;			//线路类型
	
	@Column(name="I_node")
	private String I_node;			//物理连接节点
	
	@Column(name="J_node")
	private String J_node;			//物理连接节点
	
	@Column(name="ratedCurrent")
	private String ratedCurrent;			//允许载流量
	
	@Column(name="BaseVoltage")
	private String BaseVoltage;			//基准电压标识
	
	@Column(name="Model")
	private String Model;			//模型
	
	@Column(name="Length")
	private String Length;			//长度
	
	@Column(name="ratedMW")
	private String ratedMW;			//功率限值
	
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
	
	public String getRatedCurrent() {
		return this.ratedCurrent;
	}
	public void setRatedCurrent(String ratedCurrent) {
		this.ratedCurrent = ratedCurrent;
	}	
	
	public String getBaseVoltage() {
		return this.BaseVoltage;
	}
	public void setBaseVoltage(String BaseVoltage) {
		this.BaseVoltage = BaseVoltage;
	}	
	
	public String getModel() {
		return this.Model;
	}
	public void setModel(String Model) {
		this.Model = Model;
	}	
	
	public String getLength() {
		return this.Length;
	}
	public void setLength(String Length) {
		this.Length = Length;
	}	
	
	public String getRatedMW() {
		return this.ratedMW;
	}
	public void setRatedMW(String ratedMW) {
		this.ratedMW = ratedMW;
	}	
	
	public String getFeeder() {
		return this.Feeder;
	}
	public void setFeeder(String Feeder) {
		this.Feeder = Feeder;
	}	
	
}
