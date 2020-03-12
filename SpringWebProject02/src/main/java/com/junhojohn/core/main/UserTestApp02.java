package com.junhojohn.core.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.junhojohn.core.models.UserVO;

public class UserTestApp02 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"/config/uservoservice.xml","/config/uservoservice02.xml"});
		UserVO userVO01 = (UserVO)context.getBean("userVO01");
		System.out.println("Id: " + userVO01.getId() + ", Pwd: " + userVO01.getPwd() + ", Addr: " + userVO01.getAddr());
		UserVO userVO02 = (UserVO)context.getBean("userVO02");
		System.out.println("Id: " + userVO02.getId() + ", Pwd: " + userVO02.getPwd() + ", Addr: " + userVO02.getAddr());
		UserVO userVO03 = (UserVO)context.getBean("userVO03");
		System.out.println("Id: " + userVO03.getId() + ", Pwd: " + userVO03.getPwd() + ", Addr: " + userVO03.getAddr());
	}

}
