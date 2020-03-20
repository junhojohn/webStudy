package com.junhojohn.core.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.junhojohn.core.daos.UserDao;
import com.junhojohn.core.models.UserVO;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Autowired
	@Qualifier("userDaoImpl")
	private UserDao userDao;
	
	public UserServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<UserVO> getAllUserList() throws SQLException {
		return userDao.selectAllUserList();
	}

	public int addUser(final UserVO userVO) throws SQLException {
		return userDao.insertUser(userVO);
	}
	
	public UserVO getUser(final String id) throws SQLException {
		return userDao.selectUser(id);
	}
	
	public int removeUser(String id) throws SQLException {
		return userDao.deleteUser(id);
	}
	
	public int modifyUser(final UserVO userVO) throws SQLException {
		return userDao.updateUser(userVO);
	}
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
