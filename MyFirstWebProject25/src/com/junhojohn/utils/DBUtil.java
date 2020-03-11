package com.junhojohn.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.junhojohn.consts.DB_CONNECTION_INFO_ENUM;

/**
 * new instance 생성 불가한 DB 유틸 성격의 클래스
 */
public class DBUtil {

	/**
	 * new instance 생성 불가한 DB 유틸 성격의 클래스
	 */
	private DBUtil() {
		// Limit creating Util class instance.
	}
	
	/**
	 * Oracle DB Connection 객체를 얻는다.
	 * @return Oracle Connection 객체
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getOracleConnection() throws ClassNotFoundException, SQLException {
		
		Class.forName(DB_CONNECTION_INFO_ENUM.ORACLE_DB_DRIVER.getValue());
		return DriverManager.getConnection(
				DB_CONNECTION_INFO_ENUM.ORACLE_DB_URL.getValue(),
				DB_CONNECTION_INFO_ENUM.ORACLE_DB_ID.getValue(), 
				DB_CONNECTION_INFO_ENUM.ORACLE_DB_PWD.getValue());
	}
	
	/**
	 * 모든 자원을 close 한다.																<br>
	 * close 순서: ResultSet.close() -> PreparedStatement.close() -> Connection.close()	<br>
	 * @param resultSet
	 * @param preparedStatement
	 * @param connection
	 * @throws SQLException
	 */
	public static void closeAllResources(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) throws SQLException {
		closeResultSetAndOthers(resultSet, preparedStatement, connection);
	}
	
	/**
	 * ResultSet과 그와 연관된 상위 자원들을 모두 close 한다.										<br>
	 * close 순서: ResultSet.close() -> PreparedStatement.close() -> Connection.close()	<br>
	 * @param resultSet
	 * @param preparedStatement
	 * @param connection
	 * @throws SQLException
	 */
	public static void closeResultSetAndOthers(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) throws SQLException {
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closePreparedStatementAndOthers(preparedStatement, connection);
			}
		}
	}
	
	/**
	 * PreparedStatement와 그와 연관된 상위 자원들을 모두 close 한다.			<br>
	 * close 순서: PreparedStatement.close() -> Connection.close()	<br>
	 * @param preparedStatement
	 * @param connection
	 * @throws SQLException
	 */
	public static void closePreparedStatementAndOthers(PreparedStatement preparedStatement, Connection connection) throws SQLException {
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close(connection);
			}
		}
	}
	
	/**
	 * Connection 자원을 close 한다.
	 * @param connection
	 * @throws SQLException
	 */
	public static void close(Connection connection) throws SQLException {
		if(connection != null) {
			connection.close();
		}
	}
	
}
