package com.junhojohn.services;

import java.util.List;

import com.junhojohn.daos.UserDao;
import com.junhojohn.daos.UserDaoImpl;
import com.junhojohn.models.UserVO;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public UserVO getUser(final UserVO userVO) {
		return userDao.selectUser(userVO);
	}

	@Override
	public List<UserVO> getAllUserList() {
		return userDao.selectAllUser();
	}

	@Override
	public int addUser(final UserVO userVO) {
		return userDao.insertUser(userVO);
	}

	@Override
	public int replaceUser(final UserVO targetUserVO, final UserVO destUserVO) {
		return userDao.updateUser(targetUserVO, destUserVO);
	}

	@Override
	public void removeUser(final UserVO userVO) {
		userDao.deleteUser(userVO);
	}

	@Override
	public void removeAllUserList() {
		userDao.deleteAllUser();		
	}

	
}
