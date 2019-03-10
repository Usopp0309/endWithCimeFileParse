package com.hdtd.domain;

import javax.persistence.Column;

public class Powertransformer extends BasePojo {


	@Column(name="wind_type")
	private String wind_type;			//绕组类型
	
	@Column(name="Substation")
	private String Substation;			//所属厂站/站房
	
	@Column(name="NoLoadLoss")
	private String NoLoadLoss;			//空载损耗
	
	@Column(name="ExcitingCurrent")
	private String ExcitingCurrent;			//空载电流百分比
	
	
	
	
	
	public String getWind_type() {
		return this.wind_type;
	}
	public void setWind_type(String wind_type) {
		this.wind_type = wind_type;
	}	
	
	public String getSubstation() {
		return this.Substation;
	}
	public void setSubstation(String Substation) {
		this.Substation = Substation;
	}	
	
	public String getNoLoadLoss() {
		return this.NoLoadLoss;
	}
	public void setNoLoadLoss(String NoLoadLoss) {
		this.NoLoadLoss = NoLoadLoss;
	}	
	
	public String getExcitingCurrent() {
		return this.ExcitingCurrent;
	}
	public void setExcitingCurrent(String ExcitingCurrent) {
		this.ExcitingCurrent = ExcitingCurrent;
	}	
	
}
