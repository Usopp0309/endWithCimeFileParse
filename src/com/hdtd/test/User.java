package com.hdtd.test;

public class User {
	private int num;
	private String user_name;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	@Override
	public String toString() {
		return "User [num=" + num + ", user_name=" + user_name + "]";
	}
	
	
}
