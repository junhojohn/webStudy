package mybatis.service.services;

import java.sql.SQLException;
import java.util.List;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;

public interface UserService {

	public int addUser(final User user) throws SQLException;
	
	public User getUser(final String id) throws SQLException;
	
	public List<User> getAllUserList(final Search search) throws SQLException;
	
	public int modifyUser(final User user) throws SQLException;
	
	public int removeUser(final String id) throws SQLException;
}
