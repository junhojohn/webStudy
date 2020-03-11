package com.junhojohn.daos;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.junhojohn.models.UserVO;

public class UserDao {

	private String dbId 		= "SYSTEM";
	private String dbPwd 		= "Wnsgh3535";
	private String dbUrl 		= "jdbc:oracle:thin:@127.0.0.1:1521:junhojohn";
	private String dbDriver		= "oracle.jdbc.driver.OracleDriver";
	
	public UserDao() {

	}
	
	public UserVO getUserVO(UserVO userVO) {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement preparedStatement = null;
		String sqlStatement = "SELECT id, pwd FROM USERS WHERE id=? AND pwd=?";
		
		try {
			Class.forName(dbDriver);
			connection = DriverManager.getConnection(dbUrl, dbId, dbPwd);
			preparedStatement = connection.prepareStatement(sqlStatement);
			preparedStatement.setString(1, userVO.getId());
			preparedStatement.setString(2, userVO.getPwd());
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				resultSet.getString(1);
				userVO.setActive(true);
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			userVO.setActive(false);
		} catch (SQLException e) {
			e.printStackTrace();
			userVO.setActive(false);
		}

		return userVO;
	}
	
	public UserVO getUserVOList() {
		return null;
	}
	
	public int addUserVO(UserVO userVO) {
		return -1;
	}
	
	public int addUserVOList(List<UserVO> userVOList) {
		return -1;
	}
	
	public int updateUserVO(UserVO userVO) {
		return -1;
	}
	public int updateUserVOList(List<UserVO> userVOList) {
		return -1;	
	}
	
	public void deleteUserVO(UserVO userVO) {

	}
	
	public void deleteUserVOList(List<UserVO> userVOList) {

	}
}
