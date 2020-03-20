package com.junhojohn.core.daos;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.junhojohn.core.models.UserVO;

@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	@Qualifier("sqlSessionTemplate")
	private SqlSession sqlSession;
	
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<UserVO> selectAllUserList() throws SQLException {
		return sqlSession.selectList("userMapper.selectAllUserList");
	}

	public UserVO selectUser(final String id) throws SQLException {
		return sqlSession.selectOne("userMapper.selectUser", id);
	}
	
	public int insertUser(final UserVO userVO) throws SQLException {
		return sqlSession.insert("userMapper.insertUser", userVO);
	}
	
	public int deleteUser(final String id) throws SQLException {
		return sqlSession.delete("userMapper.deleteUser", id);
	}
	
	public int updateUser(final UserVO userVO) throws SQLException {
		return sqlSession.update("userMapper.updateUser", userVO);
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
}
