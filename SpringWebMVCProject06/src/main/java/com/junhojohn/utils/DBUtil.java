package com.junhojohn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.junhojohn.consts.DB_CONNECTION_INFO_ENUM;

public class DBUtil {

	private DBUtil() {
		
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DB_CONNECTION_INFO_ENUM.ORACLE_DB_DRIVER.getValue());
		return DriverManager.getConnection(DB_CONNECTION_INFO_ENUM.ORACLE_DB_URL.getValue(), 
											DB_CONNECTION_INFO_ENUM.ORACLE_DB_ID.getValue(), 
											DB_CONNECTION_INFO_ENUM.ORACLE_DB_PWD.getValue());
	}
	
	public static void closeAllResources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closePreparedStatementAndConnection(preparedStatement, connection);
			}
		}
	}
	
	public static void closePreparedStatementAndConnection(PreparedStatement preparedStatement, Connection connection) {
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeConnection(connection);
			}
		}
	}
	
	public static void closeConnection(Connection connection) {
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
