package com.hdtd.domain;

import javax.persistence.Column;

public class Controlarea extends BasePojo {


	@Column(name="Parent")
	private String Parent;			//父区域
	
	
	
	
	
	public String getParent() {
		return this.Parent;
	}
	public void setParent(String Parent) {
		this.Parent = Parent;
	}	
	
}
