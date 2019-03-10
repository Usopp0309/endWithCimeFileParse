package com.hdtd.domain;

import javax.persistence.Column;

public class Synchronousmachine extends BasePojo {


	@Column(name="type")
	private String type;			//发电机类型
	
	@Column(name="I_node")
	private String I_node;			//物理连接节点
	
	@Column(name="Substation")
	private String Substation;			//所属厂站/站房
	
	@Column(name="BaseVoltage")
	private String BaseVoltage;			//基准电压标识
	
	@Column(name="VoltageLevel")
	private String VoltageLevel;			//电压等级标识
	
	@Column(name="RatedMW")
	private String RatedMW;			//额定功率
	
	@Column(name="maxU")
	private String maxU;			//最大电压限值
	
	@Column(name="minU")
	private String minU;			//最小电压限值
	
	@Column(name="maxQ")
	private String maxQ;			//最大无功限值
	
	@Column(name="minQ")
	private String minQ;			//最小无功限值
	
	@Column(name="maxP")
	private String maxP;			//最大有功限值
	
	@Column(name="minP")
	private String minP;			//最小有功限值
	
	@Column(name="r")
	private String r;			//正序电阻
	
	@Column(name="x")
	private String x;			//正序电抗
	
	@Column(name="r0")
	private String r0;			//零序电阻
	
	@Column(name="x0")
	private String x0;			//零序电抗
	
	
	
	
	
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
	
	public String getVoltageLevel() {
		return this.VoltageLevel;
	}
	public void setVoltageLevel(String VoltageLevel) {
		this.VoltageLevel = VoltageLevel;
	}	
	
	public String getRatedMW() {
		return this.RatedMW;
	}
	public void setRatedMW(String RatedMW) {
		this.RatedMW = RatedMW;
	}	
	
	public String getMaxU() {
		return this.maxU;
	}
	public void setMaxU(String maxU) {
		this.maxU = maxU;
	}	
	
	public String getMinU() {
		return this.minU;
	}
	public void setMinU(String minU) {
		this.minU = minU;
	}	
	
	public String getMaxQ() {
		return this.maxQ;
	}
	public void setMaxQ(String maxQ) {
		this.maxQ = maxQ;
	}	
	
	public String getMinQ() {
		return this.minQ;
	}
	public void setMinQ(String minQ) {
		this.minQ = minQ;
	}	
	
	public String getMaxP() {
		return this.maxP;
	}
	public void setMaxP(String maxP) {
		this.maxP = maxP;
	}	
	
	public String getMinP() {
		return this.minP;
	}
	public void setMinP(String minP) {
		this.minP = minP;
	}	
	
	public String getR() {
		return this.r;
	}
	public void setR(String r) {
		this.r = r;
	}	
	
	public String getX() {
		return this.x;
	}
	public void setX(String x) {
		this.x = x;
	}	
	
	public String getR0() {
		return this.r0;
	}
	public void setR0(String r0) {
		this.r0 = r0;
	}	
	
	public String getX0() {
		return this.x0;
	}
	public void setX0(String x0) {
		this.x0 = x0;
	}	
	
}
