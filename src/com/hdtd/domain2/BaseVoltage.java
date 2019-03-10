package com.hdtd.domain2;

import javax.persistence.Column;
import javax.persistence.Table;

import com.hdtd.domain.BasePojo;

@Table(name="BaseVoltage")
public class BaseVoltage extends BasePojo{
//	private String Num;
//	private String mRID;
//	private String name;
	@Column(name="nomkV")
	private String nomkV;

	public String getNomkV() {
		return nomkV;
	}

	public void setNomkV(String nomkV) {
		this.nomkV = nomkV;
	}

	@Override
	public String toString() {
		return "BaseVoltage [nomkV=" + nomkV + ", toString()=" + super.toString() + "]";
	}
	
	
	
	
}
