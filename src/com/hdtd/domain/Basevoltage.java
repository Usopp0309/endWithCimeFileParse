package com.hdtd.domain;

import javax.persistence.Column;

public class Basevoltage extends BasePojo {


	@Column(name="nomkV")
	private String nomkV;			//基准电压
	
	
	
	
	
	public String getNomkV() {
		return this.nomkV;
	}
	public void setNomkV(String nomkV) {
		this.nomkV = nomkV;
	}	
	
}
