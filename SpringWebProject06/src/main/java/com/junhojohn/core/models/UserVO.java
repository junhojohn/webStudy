package com.junhojohn.core.models;

import java.sql.Timestamp;

public class UserVO {

	private String id;
	private String name;
	private String pwd;
	private int age;
	private int grade;
	private Timestamp regDate;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserVO(String id, String name, String pwd, int age, int grade) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age= age;
		this.grade = grade;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Timestamp getRegDate() {
		return regDate;
	}

	public void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}
	
	@Override
	public String toString() {
		return "[id:" + getId() + ", name:" + getName() + ", pwd:" + getPwd() + ", age:" + getAge() + ", grade:" + getGrade() + ", regDate:" + getRegDate() + "]";
	}
}