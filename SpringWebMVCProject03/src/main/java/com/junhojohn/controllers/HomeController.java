package com.junhojohn.controllers;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.junhojohn.daos.UserDao;
import com.junhojohn.daos.UserDaoImpl;
import com.junhojohn.models.UserVO;
import com.junhojohn.services.UserService;
import com.junhojohn.services.UserServiceImpl;

public class HomeController implements Controller {

	public HomeController() {
		// TODO Auto-generated constructor stub
	}
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(getClass().getName() + ".execute() start.");
		
		UserDao userDao = new UserDaoImpl();
		UserService userService = new UserServiceImpl(userDao);
		try {
			UserVO user = userService.getUser("ibatis01");
			System.out.println(user.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
