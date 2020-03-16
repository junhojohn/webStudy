package mybatis.service.services;

import java.sql.SQLException;
import java.util.List;

import mybatis.service.daos.UserDao;
import mybatis.service.daos.UserDaoImpl;
import mybatis.service.domain.Search;
import mybatis.service.domain.User;

public class UserServiceImpl implements UserService {

	private UserDao userDao;
	
	public UserServiceImpl() {
		System.out.println(getClass().getName() +"() constructor.");
	}
	
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
		System.out.println(getClass().getName() +"(UserDao userDao) constructor.");
	}
	
	public int addUser(final User user) throws SQLException {
		System.out.println(getClass().getName() +".addUser().");
		return userDao.insertUser(user);
	}

	public User getUser(final String id) throws SQLException {
		System.out.println(getClass().getName() +".getUser().");
		return userDao.selectUser(id);
	}

	public List<User> getAllUserList(final Search search) throws SQLException {
		System.out.println(getClass().getName() +".getAllUserList().");
		return userDao.selectAllUserList(search);
	}

	public int modifyUser(final User user) throws SQLException {
		System.out.println(getClass().getName() +".modifyUser().");
		return userDao.updateUser(user);
	}

	public int removeUser(final String id) throws SQLException {
		System.out.println(getClass().getName() +".deleteUser().");
		return userDao.deleteUser(id);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
