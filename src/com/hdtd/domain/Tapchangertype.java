package com.hdtd.domain;

import javax.persistence.Column;

public class Tapchangertype extends BasePojo {


	@Column(name="neutralStep")
	private String neutralStep;			//额定档位
	
	@Column(name="highStep")
	private String highStep;			//最大档位
	
	@Column(name="lowStep")
	private String lowStep;			//最小档位
	
	@Column(name="stepVolIncre")
	private String stepVolIncre;			//步长
	
	@Column(name="neutralKV")
	private String neutralKV;			//中点电压
	
	
	
	
	
	public String getNeutralStep() {
		return this.neutralStep;
	}
	public void setNeutralStep(String neutralStep) {
		this.neutralStep = neutralStep;
	}	
	
	public String getHighStep() {
		return this.highStep;
	}
	public void setHighStep(String highStep) {
		this.highStep = highStep;
	}	
	
	public String getLowStep() {
		return this.lowStep;
	}
	public void setLowStep(String lowStep) {
		this.lowStep = lowStep;
	}	
	
	public String getStepVolIncre() {
		return this.stepVolIncre;
	}
	public void setStepVolIncre(String stepVolIncre) {
		this.stepVolIncre = stepVolIncre;
	}	
	
	public String getNeutralKV() {
		return this.neutralKV;
	}
	public void setNeutralKV(String neutralKV) {
		this.neutralKV = neutralKV;
	}	
	
}
