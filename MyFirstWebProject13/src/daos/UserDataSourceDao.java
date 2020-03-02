package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import models.UserVO;

public class UserDataSourceDao {
	
	public UserDataSourceDao() {
		// TODO Auto-generated constructor stub
	}
	
	public void getUserVO(UserVO userVO) {
		ResultSet rs            = null;
		Connection con             = null;
		PreparedStatement pStmt = null;
		try {
			//Step1. get JDBC data from server.xml
			InitialContext context = new InitialContext();
			DataSource dataSource = (DataSource)context.lookup("java:comp/env/jdbc/ora");
			//Step2. getConnection using DataSource
			con = dataSource.getConnection();
			//Step3. prepare SQL statement
			pStmt = con.prepareStatement("SELECT id, pwd FROM USERS WHERE id = ? and pwd = ?");
			pStmt.setString(1, userVO.getId());
			pStmt.setString(2, userVO.getPwd());
			//Step4. get query result 
			rs = pStmt.executeQuery();
			if(rs.next()) {
				System.out.println("db data id:" + rs.getString(1) + ", pwd:" + rs.getString(2));
				userVO.setActive(true);
			}else {
				System.out.println("db data not exists. id:" + userVO.getId());
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pStmt != null) {
				try {
					pStmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}// end of try~catch~finally clause
	}// end of method
}// end of class