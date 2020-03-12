package com.junhojohn.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.junhojohn.core.models.UserVO;

public class UserTestApp03 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("/config/uservoservice03.xml");
		
		System.out.println("===============context:property-placeholder 이용한 uservoservice02.properties 인스턴스 생성 ===============");
		UserVO userVO04 = (UserVO)context.getBean("userVO04");
		System.out.println("Id:" + userVO04.getId() + ", Pwd:" + userVO04.getPwd() + ", Addr:" + userVO04.getAddr());
		
		System.out.println("===============util:properties 이용한 uservoservice03.properties 인스턴스 생성 ===============");
		UserVO userVO05 = (UserVO)context.getBean("userVO05");
		System.out.println("Id:" + userVO05.getId() + ", Pwd:" + userVO05.getPwd() + ", Addr:" + userVO05.getAddr());
		
		System.out.println("===============SpEL 예제1. ===============");
		UserVO userVO06 = (UserVO)context.getBean("userVO06");
		System.out.println("Id:" + userVO06.getId() + ", Pwd:" + userVO06.getPwd() + ", Addr:" + userVO06.getAddr());
		
		System.out.println("===============SpEL 예제1. userVO06 참조 ===============");
		UserVO userVO07 = (UserVO)context.getBean("userVO07");
		System.out.println("Id:" + userVO07.getId() + ", Pwd:" + userVO07.getPwd() + ", Addr:" + userVO07.getAddr());
		
		System.out.println("===============SpEL 예제2. Client 참조 ===============");
		UserVO userVO08 = (UserVO)context.getBean("userVO08");
		System.out.println("Id:" + userVO08.getId() + ", Pwd:" + userVO08.getPwd() + ", Addr:" + userVO08.getAddr());
	}

}
