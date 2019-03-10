package com.hdtd.domain;

import javax.persistence.Column;

public class Voltagelevel extends BasePojo {


	@Column(name="highkV")
	private String highkV;			//电压上限
	
	@Column(name="lowkV")
	private String lowkV;			//电压下限
	
	@Column(name="Substation")
	private String Substation;			//所属厂站/站房
	
	@Column(name="BaseVoltage")
	private String BaseVoltage;			//基准电压标识
	
	
	
	
	
	public String getHighkV() {
		return this.highkV;
	}
	public void setHighkV(String highkV) {
		this.highkV = highkV;
	}	
	
	public String getLowkV() {
		return this.lowkV;
	}
	public void setLowkV(String lowkV) {
		this.lowkV = lowkV;
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
	
}
