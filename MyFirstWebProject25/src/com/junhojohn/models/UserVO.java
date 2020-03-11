package com.junhojohn.models;

public class UserVO {

	private String id;
	private String pwd;
	private boolean isActive;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserVO(String id, String pwd) {
		this.id 	= id;
		this.pwd 	= pwd;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
}
