package com.junhojohn.core.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.NamingException;
import com.junhojohn.core.models.UserVO;
import com.junhojohn.core.utils.DBUtil;

public class AbstractDao {

	private DBUtil dbUtil;
	
	public AbstractDao() {
		dbUtil = new DBUtil();
	}
	
	/**
	 * Connection 객체를 얻는다.
	 * @return
	 * @throws NamingException
	 * @throws SQLException
	 */
	public Connection getConnection() throws NamingException, SQLException {
		return dbUtil.getConnection();
	}
	
	/**
	 * 쿼리 수행을 위한 PreparedStatement 객체를 얻는다.
	 * @param connection
	 * @param userVO
	 * @return
	 * @throws SQLException
	 */
	public PreparedStatement getPreparedStatement(Connection connection, UserVO userVO) throws SQLException {
		return dbUtil.getPreparedStatement(connection, userVO);
	}
	
	/**
	 * 자원을 CLOSE한다.
	 * @param resultSet
	 * @param preparedStatement
	 * @param connection
	 */
	public void close(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
		if(resultSet != null) {
			
			try {
				resultSet.close();
				
			} catch (SQLException e) {
			
				e.printStackTrace();
			
			}finally {
			
				dbUtil.close(preparedStatement, connection);
				
			}//end of finally
			
		}// end of if
		
	}//end of close()

}//end of class
