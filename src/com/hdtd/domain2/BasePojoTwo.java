package com.hdtd.domain2;

import javax.persistence.Column;
import javax.persistence.Id;

public class BasePojoTwo {
	@Id
	@Column(name="mRID")
	private String mRID;	//ฑ๊สถ

	public String getmRID() {
		return mRID;
	}

	public void setmRID(String mRID) {
		this.mRID = mRID;
	}

	@Override
	public String toString() {
		return "BasePojoTwo [mRID=" + mRID + "]";
	}
	
}
