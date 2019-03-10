package com.hdtd.domain;

import javax.persistence.Column;

public class Aclinesegment extends BasePojo {


	@Column(name="StartSt")
	private String StartSt;			//首端站房标识
	
	@Column(name="EndSt")
	private String EndSt;			//末端站房标识
	
	@Column(name="ratedMW")
	private String ratedMW;			//功率限值
	
	@Column(name="ratedCurrent")
	private String ratedCurrent;			//允许载流量
	
	@Column(name="BaseVoltage")
	private String BaseVoltage;			//基准电压标识
	
	@Column(name="r")
	private String r;			//正序电阻
	
	@Column(name="x")
	private String x;			//正序电抗
	
	@Column(name="bch")
	private String bch;			//正序电纳
	
	@Column(name="r0")
	private String r0;			//零序电阻
	
	@Column(name="x0")
	private String x0;			//零序电抗
	
	@Column(name="bch0")
	private String bch0;			//零序电纳
	
	
	
	
	
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
	
	public String getRatedMW() {
		return this.ratedMW;
	}
	public void setRatedMW(String ratedMW) {
		this.ratedMW = ratedMW;
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
	
	public String getBch() {
		return this.bch;
	}
	public void setBch(String bch) {
		this.bch = bch;
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
	
	public String getBch0() {
		return this.bch0;
	}
	public void setBch0(String bch0) {
		this.bch0 = bch0;
	}	
	
}
