package com.junhojohn.core.main;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.junhojohn.core.models.UserVO;
import com.junhojohn.core.services.UserService;

public class UserTestAppMain01 {

	public static void main(String[] args) {
		BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:spring/commonService.xml");
		UserService userService = (UserService)beanFactory.getBean("userServiceImpl");
		
		try {
			
			System.out.println("==================전체 사용자 조회==================");
			List<UserVO> allUserList = userService.getAllUserList();
			for(UserVO userVO : allUserList) {
				System.out.println(userVO.toString());
			}

			System.out.println("==================ibatis03이 ID인 사용자 조회==================");
			UserVO user = userService.getUser("ibatis03");
			System.out.println(user.toString());
			
			System.out.println("==================새 사용자 추가==================");
			UserVO newUserVO = new UserVO("newUser01", "newUser01", "newUser01", 20, 6);
			int result = userService.addUser(newUserVO);
			System.out.println("add user result value:" + result);
			
			System.out.println("==================전체 사용자 조회==================");
			allUserList = userService.getAllUserList();
			for(UserVO userVO : allUserList) {
				System.out.println(userVO.toString());
			}
			
			System.out.println("==================newUser01 정보 업데이트==================");
			newUserVO.setName("nameUpdated");
			newUserVO.setPwd("pwdUpdated");
			newUserVO.setAge(30);
			newUserVO.setGrade(10);
			result = userService.modifyUser(newUserVO);
			System.out.println("update user result value:" + result);
			
			System.out.println("==================전체 사용자 조회==================");
			allUserList = userService.getAllUserList();
			for(UserVO userVO : allUserList) {
				System.out.println(userVO.toString());
			}
			
			System.out.println("==================newUser01 정보 삭제==================");
			result = userService.removeUser("newUser01");
			System.out.println("remove user result value:" + result);
			
			System.out.println("==================전체 사용자 조회==================");
			allUserList = userService.getAllUserList();
			for(UserVO userVO : allUserList) {
				System.out.println(userVO.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
