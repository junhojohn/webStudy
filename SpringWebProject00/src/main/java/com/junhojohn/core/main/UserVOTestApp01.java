package com.junhojohn.core.main;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import com.junhojohn.core.models.UserVO;

public class UserVOTestApp01 {

	public static void main(String[] args) {
		BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("./src/main/resources/config/uservoservice.xml"));
		UserVO userVO = (UserVO)beanFactory.getBean("userVO");
		
		System.out.println("================= UserVO =================");
		System.out.println("ID:" + userVO.getId());
		System.out.println("PWD:" + userVO.getPwd());
	}

}
