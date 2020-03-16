package mybatis.service.services;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.service.daos.UserDao;
import mybatis.service.domain.Search;
import mybatis.service.domain.User;

@Service("userServiceImpl14")
public class UserServiceImpl14 implements UserService {

	@Autowired
	@Qualifier("userDaoImpl14")
	private UserDao userDao;
	
	public UserServiceImpl14() {
		// TODO Auto-generated constructor stub
	}
	
	public UserServiceImpl14(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public int addUser(final User user) throws SQLException {
		return userDao.insertUser(user);
	}

	public User getUser(final String id) throws SQLException {
		return userDao.selectUser(id);
	}

	public List<User> getAllUserList(final Search search) throws SQLException {
		return userDao.selectAllUserList(search);
	}

	public int modifyUser(final User user) throws SQLException {
		return userDao.updateUser(user);
	}

	public int removeUser(final String id) throws SQLException {
		return userDao.deleteUser(id);
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

}
