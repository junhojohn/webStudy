package com.junhojohn.core.models;

public class UserVO {

	private String id;
	private String pwd;
	private String addr;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserVO(String id, String pwd, String addr) {
		this.id = id;
		this.pwd = pwd;
		this.addr = addr;
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

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}
