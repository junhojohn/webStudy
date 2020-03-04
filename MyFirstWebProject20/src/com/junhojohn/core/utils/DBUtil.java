package com.junhojohn.core.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import com.junhojohn.core.models.UserVO;

public class DBUtil {

	private String databaseName = "java:comp/env/jdbc/ora";
	
	public DBUtil() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Connection 객체를 얻는다.
	 * @return
	 * @throws NamingException
	 * @throws SQLException
	 */
	public Connection getConnection() throws NamingException, SQLException {
		DataSource dataSource 	= null;
		Connection connection 	= null;
		InitialContext context 	= null;
		
		context 	= new InitialContext();
		dataSource 	= (DataSource)context.lookup(databaseName);
		connection 	= dataSource.getConnection();
		
		return connection;
	}
	
	/**
	 * 쿼리 수행을 위한 PreparedStatement 객체를 얻는다.
	 * @param connection
	 * @param userVO
	 * @return
	 * @throws SQLException
	 */
	public PreparedStatement getPreparedStatement(Connection connection, UserVO userVO) throws SQLException {
		PreparedStatement prepareStatement 	= null;
		prepareStatement 					= connection.prepareStatement("SELECT id, pwd FROM USERS WHERE id=? AND pwd=?");
		prepareStatement.setString(1, userVO.getId());
		prepareStatement.setString(2, userVO.getPwd());
		return prepareStatement;
	}
	
	/**
	 * 자원을 CLOSE한다.
	 * @param preparedStatement
	 * @param connection
	 */
	public void close(PreparedStatement preparedStatement, Connection connection) {
		
		if(preparedStatement != null) {

			try {
				
				preparedStatement.close();
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}finally {
				
				close(connection);
			
			}//end of finally
			
		}//end of if
		
	}//end of close()
	
	/**
	 * 자원을 CLOSE한다.
	 * @param connection
	 */
	public void close(Connection connection) {
		
		if(connection != null) {
			
			try {
				
				connection.close();
			
			} catch (SQLException e) {
				
				e.printStackTrace();
			
			}//end of try~catch		
			
		}//end of if

	}//end of close()
	
}//end of class
