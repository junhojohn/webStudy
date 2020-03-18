package com.junhojohn.services;

import com.junhojohn.daos.UserDao;
import com.junhojohn.models.UserVO;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserVO getUserVO(final String id) {
		UserVO userVO = null;
		try {
			userVO = userDao.selectUserVO(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userVO;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
}
