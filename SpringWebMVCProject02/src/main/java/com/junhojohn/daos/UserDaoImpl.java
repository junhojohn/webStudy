package com.junhojohn.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.junhojohn.models.UserVO;
import com.junhojohn.utils.DBUtil;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public UserVO selectUserVO(final String id) throws Exception {
		UserVO loggedOnUserVO				= new UserVO();
		ResultSet resultSet					= null;
		Connection connection				= null;
		PreparedStatement preparedStatement = null;
		
		connection 			= DBUtil.getConnection();
		preparedStatement 	= connection.prepareStatement("SELECT USER_ID, USER_NAME, PASSWORD, AGE, GRADE, REG_DATE FROM USERS WHERE USER_ID = ?");
		preparedStatement.setString(1, id);
		resultSet			= preparedStatement.executeQuery();
		if(resultSet.next()) {
			loggedOnUserVO.setId(resultSet.getString(1));
			loggedOnUserVO.setName(resultSet.getString(2));
			loggedOnUserVO.setPwd(resultSet.getString(3));
			loggedOnUserVO.setAge(resultSet.getInt(4));
			loggedOnUserVO.setGrade(resultSet.getInt(5));
			loggedOnUserVO.setRegDate(resultSet.getTimestamp(6));
			loggedOnUserVO.setActive(true);
		}else {
			loggedOnUserVO.setActive(false);
		}
		
		return loggedOnUserVO;
	}

}
