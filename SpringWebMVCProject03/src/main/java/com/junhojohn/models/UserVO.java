package com.junhojohn.models;

import java.sql.Timestamp;

public class UserVO {

	private String id;
	private String name;
	private String pwd;
	private int age;
	private int grade;
	private Timestamp regDate;
	private boolean isActive;
	
	public UserVO() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * TODO 생성자에 파라미터가 많아지면 빌더 패턴을 쓰는게 맞다.
	 * @param id
	 * @param name
	 * @param pwd
	 * @param age
	 * @param grade
	 */
	public UserVO(String id, String name, String pwd, int age, int grade) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.age = age;
		this.grade = grade;
	}

	public final String getId() {
		return id;
	}

	public final void setId(String id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getPwd() {
		return pwd;
	}

	public final void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public final int getAge() {
		return age;
	}

	public final void setAge(int age) {
		this.age = age;
	}

	public final int getGrade() {
		return grade;
	}

	public final void setGrade(int grade) {
		this.grade = grade;
	}

	public final Timestamp getRegDate() {
		return regDate;
	}

	public final void setRegDate(Timestamp regDate) {
		this.regDate = regDate;
	}

	public final boolean isActive() {
		return isActive;
	}

	public final void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "UserVO [id=" + id + ", name=" + name + ", pwd=" + pwd + ", age=" + age + ", grade=" + grade
				+ ", regDate=" + regDate + ", isActive=" + isActive + "]";
	}

}
