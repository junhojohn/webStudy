package mybatis.service.daos;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;

public class UserDaoImpl implements UserDao {

	private SqlSession sqlSession = null;
	
	public UserDaoImpl() {
		System.out.println(getClass().getName() +"() Constructor.");
	}
	
	public UserDaoImpl(SqlSession sqlSession) {
		System.out.println(getClass().getName() +"(SqlSession sqlSession) Constructor.");
		this.sqlSession = sqlSession;
	}
	
	public int insertUser(final User user) throws SQLException {
		System.out.println(getClass().getName() +".insertUser().");
		return sqlSession.insert("userMapper10.addUser", user);
	}

	public User selectUser(final String id) throws SQLException {
		System.out.println(getClass().getName() +".selectUser().");
		return (User) sqlSession.selectOne("userMapper10.getUser", id);
	}

	public List<User> selectAllUserList(final Search search) throws SQLException {
		System.out.println(getClass().getName() +".selectAllUserList().");
		return sqlSession.selectList("userMapper10.getUserList", search);
	}

	public int updateUser(final User user) throws SQLException {
		System.out.println(getClass().getName() +".updateUser().");
		return sqlSession.update("userMapper10.updateUser", user);
	}

	public int deleteUser(final String id) throws SQLException {
		System.out.println(getClass().getName() +".deleteUser().");
		return sqlSession.delete("userMapper10.deleteUser", id);
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
}
