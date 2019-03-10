package com.hdtd.domain;

import javax.persistence.Column;

public class Dclinesegment extends BasePojo {


	@Column(name="StartSt")
	private String StartSt;			//首端站房标识
	
	@Column(name="EndSt")
	private String EndSt;			//末端站房标识
	
	@Column(name="r")
	private String r;			//正序串联电阻
	
	@Column(name="BaseVoltage")
	private String BaseVoltage;			//基准电压标识
	
	
	
	
	
	public String getStartSt() {
		return this.StartSt;
	}
	public void setStartSt(String StartSt) {
		this.StartSt = StartSt;
	}	
	
	public String getEndSt() {
		return this.EndSt;
	}
	public void setEndSt(String EndSt) {
		this.EndSt = EndSt;
	}	
	
	public String getR() {
		return this.r;
	}
	public void setR(String r) {
		this.r = r;
	}	
	
	public String getBaseVoltage() {
		return this.BaseVoltage;
	}
	public void setBaseVoltage(String BaseVoltage) {
		this.BaseVoltage = BaseVoltage;
	}	
	
}
