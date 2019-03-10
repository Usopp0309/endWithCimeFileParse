package com.hdtd.domain;

import javax.persistence.Column;

public class Transformerwinding extends BasePojo {


	@Column(name="WindingType")
	private String WindingType;			//绕组类型
	
	@Column(name="Substation")
	private String Substation;			//所属厂站/站房
	
	@Column(name="PowerTransformer")
	private String PowerTransformer;			//变压器标识
	
	@Column(name="I_node")
	private String I_node;			//物理连接节点
	
	@Column(name="BaseVoltage")
	private String BaseVoltage;			//基准电压标识
	
	@Column(name="VoltageLevel")
	private String VoltageLevel;			//电压等级标识
	
	@Column(name="TapChangerType")
	private String TapChangerType;			//分接头类型标识
	
	@Column(name="ratedMVA")
	private String ratedMVA;			//额定功率
	
	@Column(name="ratedkV")
	private String ratedkV;			//额定电压
	
	@Column(name="loadLoss")
	private String loadLoss;			//短路损耗
	
	@Column(name="leakageImpedence")
	private String leakageImpedence;			//短路电压百分比
	
	@Column(name="r")
	private String r;			//电阻
	
	@Column(name="x")
	private String x;			//电抗
	
	@Column(name="r0")
	private String r0;			//零序电阻
	
	@Column(name="x0")
	private String x0;			//零序电抗
	
	
	
	
	
	public String getWindingType() {
		return this.WindingType;
	}
	public void setWindingType(String WindingType) {
		this.WindingType = WindingType;
	}	
	
	public String getSubstation() {
		return this.Substation;
	}
	public void setSubstation(String Substation) {
		this.Substation = Substation;
	}	
	
	public String getPowerTransformer() {
		return this.PowerTransformer;
	}
	public void setPowerTransformer(String PowerTransformer) {
		this.PowerTransformer = PowerTransformer;
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
	
	public String getTapChangerType() {
		return this.TapChangerType;
	}
	public void setTapChangerType(String TapChangerType) {
		this.TapChangerType = TapChangerType;
	}	
	
	public String getRatedMVA() {
		return this.ratedMVA;
	}
	public void setRatedMVA(String ratedMVA) {
		this.ratedMVA = ratedMVA;
	}	
	
	public String getRatedkV() {
		return this.ratedkV;
	}
	public void setRatedkV(String ratedkV) {
		this.ratedkV = ratedkV;
	}	
	
	public String getLoadLoss() {
		return this.loadLoss;
	}
	public void setLoadLoss(String loadLoss) {
		this.loadLoss = loadLoss;
	}	
	
	public String getLeakageImpedence() {
		return this.leakageImpedence;
	}
	public void setLeakageImpedence(String leakageImpedence) {
		this.leakageImpedence = leakageImpedence;
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
