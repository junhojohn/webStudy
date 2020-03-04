package com.junhojohn.core.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import com.junhojohn.core.models.UserVO;

public class UserDao extends AbstractDao {

	public UserDao() {
		super();
	}
	
	/**
	 * 주어진 사용자 정보를 DB로부터 조회한다.
	 * @param 사용자정보(ID, PWD)
	 */
	public void getUserVO(UserVO userVO) {

		String debugMsg						= null;
		boolean isActive					= false;
		ResultSet resultSet 				= null;
		Connection connection 				= null;
		PreparedStatement prepareStatement 	= null;

		try {
			connection 			= super.getConnection();
			prepareStatement 	= super.getPreparedStatement(connection, userVO);
			resultSet 			= prepareStatement.executeQuery();
			
			if(resultSet.next()) {
				if(userVO.getId().equals(resultSet.getString(1))) {
					isActive = true;
					debugMsg = "Getting user info data from Database success! Requested id:";
				}else {
					isActive = false;
					debugMsg = "Fail to get user info data from database. Requested id:";
				}
			}else {
				isActive = false;
				debugMsg = "Fail to get user info data from database. Requested id:";
			}
			
			userVO.setActive(isActive);		
			System.out.println(debugMsg + userVO.getId());
			
		} catch (NamingException | SQLException e) {
		
			e.printStackTrace();
		
		} finally {
			
			super.close(resultSet, prepareStatement, connection);
		
		}// end of finally

	}//end of getUserVO()
	
}//end of class
