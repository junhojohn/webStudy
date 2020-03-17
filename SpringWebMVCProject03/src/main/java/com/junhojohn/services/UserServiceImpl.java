package com.junhojohn.services;

import java.sql.SQLException;

import com.junhojohn.daos.UserDao;
import com.junhojohn.models.UserVO;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl() {

	}
	
	/**
	 * TODO SqlSession AUTOWIRING 해서 물리커플링 완화시키는게 맞다.
	 * @param userDao
	 */
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserVO getUser(final String id) throws SQLException {
		return userDao.selectUserVO(id);
	}

	public final void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
