package ibatis.services.user.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mybatis.service.domain.User;

public class JDBCTestApp {

	public static void main(String[] args) {

		String dbId 	= "ibatis";
		String dbPwd 	= "ibatis";
		String dburl 	= "jdbc:oracle:thin:@127.0.0.1:1521:junhojohn";
		String dbDriver = "oracle.jdbc.driver.OracleDriver";
		
		List<User> userList 				= null;
		ResultSet resultSet 				= null;
		Connection connection 				= null;
		PreparedStatement prepareStatement 	= null;
		
		try {
			
			Class.forName(dbDriver);
			
			userList 			= new ArrayList<User>();
			connection 			= DriverManager.getConnection(dburl, dbId, dbPwd);
			prepareStatement 	= connection.prepareStatement("SELECT * FROM USERS");
			resultSet 			= prepareStatement.executeQuery();
			
			while(resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getString(1));
				user.setName(resultSet.getString(2));
				user.setPwd(resultSet.getString(3));
				user.setAge(resultSet.getInt(4));
				user.setGrade(resultSet.getInt(5));
				user.setRegDate(resultSet.getTimestamp(6));
				user.setActive(true);
				userList.add(user);
			}
			
			
			for(User user : userList) {
				System.out.println(user.toString());
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
					if(prepareStatement != null) {
						try {
							prepareStatement.close();
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
		
		
	}

}
