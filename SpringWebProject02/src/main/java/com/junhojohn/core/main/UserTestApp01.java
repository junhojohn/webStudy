package com.junhojohn.core.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.junhojohn.core.models.UserVO;

public class UserTestApp01 {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("src/main/resources/config/uservoservice.xml"));
		
		UserVO userVO01 = (UserVO)beanFactory.getBean("userVO01");
		System.out.println("Id: " + userVO01.getId() + ", Pwd: " + userVO01.getPwd() + ", Addr: " + userVO01.getAddr());
		UserVO userVO02 = (UserVO)beanFactory.getBean("userVO02");
		System.out.println("Id: " + userVO02.getId() + ", Pwd: " + userVO02.getPwd() + ", Addr: " + userVO02.getAddr());
		
	}

}
