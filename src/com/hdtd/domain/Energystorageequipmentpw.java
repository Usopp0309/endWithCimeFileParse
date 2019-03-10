package com.hdtd.domain;

import javax.persistence.Column;

public class Energystorageequipmentpw extends BasePojo {


	@Column(name="rdfid")
	private String rdfid;			//资源标识
	
	@Column(name="type")
	private String type;			//储能设备类型
	
	@Column(name="I_node")
	private String I_node;			//物理连接节点
	
	@Column(name="BaseVoltage")
	private String BaseVoltage;			//基准电压标识
	
	@Column(name="RatedKV")
	private String RatedKV;			//额定电压
	
	@Column(name="ActiveEnergy")
	private String ActiveEnergy;			//总电量
	
	@Column(name="InRatedMW")
	private String InRatedMW;			//额定输入功率
	
	@Column(name="OutRatedMW")
	private String OutRatedMW;			//额定输出功率
	
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
	
	public String getBaseVoltage() {
		return this.BaseVoltage;
	}
	public void setBaseVoltage(String BaseVoltage) {
		this.BaseVoltage = BaseVoltage;
	}	
	
	public String getRatedKV() {
		return this.RatedKV;
	}
	public void setRatedKV(String RatedKV) {
		this.RatedKV = RatedKV;
	}	
	
	public String getActiveEnergy() {
		return this.ActiveEnergy;
	}
	public void setActiveEnergy(String ActiveEnergy) {
		this.ActiveEnergy = ActiveEnergy;
	}	
	
	public String getInRatedMW() {
		return this.InRatedMW;
	}
	public void setInRatedMW(String InRatedMW) {
		this.InRatedMW = InRatedMW;
	}	
	
	public String getOutRatedMW() {
		return this.OutRatedMW;
	}
	public void setOutRatedMW(String OutRatedMW) {
		this.OutRatedMW = OutRatedMW;
	}	
	
	public String getFeeder() {
		return this.Feeder;
	}
	public void setFeeder(String Feeder) {
		this.Feeder = Feeder;
	}	
	
}
