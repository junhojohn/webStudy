package com.junhojohn.service.impl;

import com.junhojohn.dao.UserDao;
import com.junhojohn.models.UserVO;
import com.junhojohn.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserVO getUserVO(final String id) {
		return userDao.selectUserVO(id);
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
