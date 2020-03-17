package com.junhojohn.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;

import com.junhojohn.consts.DB_CONNECTION_INFO_ENUM;
import com.junhojohn.models.UserVO;

public class UserDaoImpl implements UserDao {

	private SqlSession sqlSession;
	
	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * TODO SqlSession AUTOWIRING 해서 물리커플링 완화시키는게 맞다.
	 * @param sqlSession
	 */
	public UserDaoImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
//	public UserVO selectUserVO(final String id) throws SQLException {
//		return sqlSession.selectOne("",id);
//	}
	
	public UserVO selectUserVO(final String id) {
		UserVO newUserVO 					= null; 
		ResultSet resultSet 				= null;
		Connection connection 				= null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName(DB_CONNECTION_INFO_ENUM.ORACLE_DB_DRIVER.getValue());
			connection 			= DriverManager.getConnection(DB_CONNECTION_INFO_ENUM.ORACLE_DB_URL.getValue(), 
																DB_CONNECTION_INFO_ENUM.ORACLE_DB_ID.getValue(), 
																DB_CONNECTION_INFO_ENUM.ORACLE_DB_PWD.getValue());
		
			preparedStatement 	= connection.prepareStatement("SELECT USER_ID, USER_NAME, PASSWORD, AGE, GRADE, REG_DATE FROM USERS WHERE USER_ID = ?");
			preparedStatement.setString(1, id);
			resultSet 			= preparedStatement.executeQuery();
			if(resultSet.next()) {
				newUserVO = new UserVO();
				newUserVO.setId(resultSet.getString(1));
				newUserVO.setName(resultSet.getString(2));
				newUserVO.setPwd(resultSet.getString(3));
				newUserVO.setAge(resultSet.getInt(4));
				newUserVO.setGrade(resultSet.getInt(5));
				newUserVO.setRegDate(resultSet.getTimestamp(6));
			}
		
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					if(preparedStatement != null) {
						try {
							preparedStatement.close();
						} catch (SQLException e) {
							e.printStackTrace();
						} finally {
							if(connection != null) {
								try {
									connection.close();
								} catch (SQLException e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			}
		}
		
		return newUserVO;
	}

	public final void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

}
