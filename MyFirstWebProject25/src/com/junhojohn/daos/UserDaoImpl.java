package com.junhojohn.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.junhojohn.models.UserVO;
import com.junhojohn.utils.DBUtil;

public class UserDaoImpl implements UserDao {

	@Override
	public UserVO selectUser(final UserVO userVO) {
		ResultSet resultSet	 				= null;
		Connection connection 				= null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection 			= DBUtil.getOracleConnection();
			preparedStatement 	= connection.prepareStatement("SELECT id, pwd FROM USERS WHERE id=? AND pwd=?");
			preparedStatement.setString(1, userVO.getId());
			preparedStatement.setString(2, userVO.getPwd());
			resultSet 			= preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				userVO.setActive(true);				
			}else {
				userVO.setActive(false);
			}

		} catch (ClassNotFoundException | SQLException e) {
			
			userVO.setActive(false);
			e.printStackTrace();
			
		} finally {

			try {
				DBUtil.closeAllResources(resultSet, preparedStatement, connection);
			} catch (SQLException e) {
				
				userVO.setActive(false);
				e.printStackTrace();
			}
			
		}

		return userVO;
	}

	@Override
	public List<UserVO> selectAllUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertUser(final UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(final UserVO targetUserVO, final UserVO destUserVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(final UserVO userVO) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteAllUser() {
		// TODO Auto-generated method stub
		
	}


}
