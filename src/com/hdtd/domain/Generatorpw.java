package com.hdtd.domain;

import javax.persistence.Column;

public class Generatorpw extends BasePojo {


	@Column(name="rdfid")
	private String rdfid;			//资源标识
	
	@Column(name="type")
	private String type;			//电源类型
	
	@Column(name="I_node")
	private String I_node;			//物理连接节点
	
	@Column(name="Substation")
	private String Substation;			//所属厂站/站房
	
	@Column(name="BaseVoltage")
	private String BaseVoltage;			//基准电压标识
	
	@Column(name="RatedPMW")
	private String RatedPMW;			//额定有功功率
	
	@Column(name="RatedQMW")
	private String RatedQMW;			//额定无功功率
	
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
	
	public String getRatedPMW() {
		return this.RatedPMW;
	}
	public void setRatedPMW(String RatedPMW) {
		this.RatedPMW = RatedPMW;
	}	
	
	public String getRatedQMW() {
		return this.RatedQMW;
	}
	public void setRatedQMW(String RatedQMW) {
		this.RatedQMW = RatedQMW;
	}	
	
	public String getFeeder() {
		return this.Feeder;
	}
	public void setFeeder(String Feeder) {
		this.Feeder = Feeder;
	}	
	
}
