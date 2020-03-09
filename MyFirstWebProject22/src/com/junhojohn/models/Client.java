package com.junhojohn.models;

//FileName : Client.java	==> Client Info Bean
public class Client {

	private String name;
	private String addr;
	private int age;
	private String[] info = {"web developer","android developer"};
	

	public Client() {
		this.name = "junhojohn";
		this.addr = "Seoul";
		this.age = 30;
		System.out.println("Client default Constructor.");
	}


	public String getName() {
		System.out.println("Client getName()");
		return name;
	}


	public void setName(String name) {
		System.out.println("Client setName()");
		this.name = name;
	}


	public String getAddr() {
		System.out.println("Client getAddr()");
		return addr;
	}


	public void setAddr(String addr) {
		System.out.println("Client setAddr()");
		this.addr = addr;
	}


	public int getAge() {
		System.out.println("Client getAge()");
		return age;
	}


	public void setAge(int age) {
		System.out.println("Client setAge()");
		this.age = age;
	}


	public String[] getInfo() {
		System.out.println("Client getInfo()");
		return info;
	}


	public void setInfo(String[] info) {
		System.out.println("Client setInfo()");
		this.info = info;
	}
	
	
}

