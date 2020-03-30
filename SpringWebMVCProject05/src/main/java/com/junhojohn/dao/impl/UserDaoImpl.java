package com.junhojohn.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.junhojohn.dao.UserDao;
import com.junhojohn.models.UserVO;
import com.junhojohn.utils.DBUtil;

@Repository("userDao")
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
	
	public UserVO selectUserVO(final String id) {
		UserVO userVO = (UserVO)sqlSession.selectOne("userMapper.selectUserVO", id);
		
		if(userVO != null) {
			userVO.setActive(true);			
		}else {
			userVO.setActive(false);
		}

		return userVO;
		// TODO UNIT TEST
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
//	public UserVO selectUserVO(final String id) {
//		
//		UserVO userVO 						= new UserVO();
//		ResultSet resultSet					= null;
//		Connection connection 				= null;
//		PreparedStatement preparedStatement	= null;
//		
//		try {
//			connection 			= DBUtil.getConnection();
//			preparedStatement	= connection.prepareStatement("SELECT USER_ID, USER_NAME, PASSWORD, AGE, GRADE, REG_DATE FROM USERS WHERE USER_ID = ?");
//			preparedStatement.setString(1, id);
//			resultSet			= preparedStatement.executeQuery();
//			
//			if(resultSet.next()) {
//				userVO.setId(resultSet.getString(1));
//				userVO.setName(resultSet.getString(2));
//				userVO.setPwd(resultSet.getString(3));
//				userVO.setAge(resultSet.getInt(4));
//				userVO.setGrade(resultSet.getInt(5));
//				userVO.setRegDate(resultSet.getTimestamp(6));
//				userVO.setActive(true);
//			}else {
//				userVO.setActive(true);
//			}
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			DBUtil.closeAllResources(resultSet, preparedStatement, connection);
//		}
//		return null;
//	}

	
}
