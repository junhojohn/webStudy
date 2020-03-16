package mybatis.service.daos;

import java.sql.SQLException;
import java.util.List;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;

public interface UserDao {

	public int insertUser(final User user) throws SQLException;
	
	public User selectUser(final String id) throws SQLException;
	
	public List<User> selectAllUserList(final Search search) throws SQLException;
	
	public int updateUser(final User user) throws SQLException;
	
	public int deleteUser(final String id) throws SQLException;
	
}
