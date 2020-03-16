package mybatis.service.daos;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;

@Repository("userDaoImpl14")
public class UserDaoImpl14 implements UserDao {

	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public UserDaoImpl14() {
	}

	public UserDaoImpl14(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public int insertUser(final User user) throws SQLException {
		return sqlSession.insert("userMapper10.addUser", user);
	}

	public User selectUser(final String id) throws SQLException {
		return sqlSession.selectOne("userMapper10.getUser", id);
	}

	public List<User> selectAllUserList(final Search search) throws SQLException {
		return sqlSession.selectList("userMapper10.getUserList", search);
	}

	public int updateUser(final User user) throws SQLException {
		return sqlSession.update("userMapper10.updateUser", user);
	}

	public int deleteUser(final String id) throws SQLException {
		return sqlSession.delete("userMapper10.deleteUser", id);
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}
