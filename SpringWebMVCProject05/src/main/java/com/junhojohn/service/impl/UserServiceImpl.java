package com.junhojohn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.junhojohn.dao.UserDao;
import com.junhojohn.models.UserVO;
import com.junhojohn.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDao")
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

	public UserDao getUserDao() {
		return userDao;
	}
	
}
