import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDao {

	String dbUrl 		= "jdbc:oracle:thin:@127.0.0.1:1521:junhojohn";
	String dbuser 		= "SYSTEM";
	String dbpwd 		= "Wnsgh3535";
	String driverName 	= "oracle.jdbc.driver.OracleDriver";
	
	public UserDao() {
		// TODO Auto-generated constructor stub
	}
	
	public void getUser(UserVO userVO) {
		
		ResultSet rs 			= null;
		Connection con 			= null;
		PreparedStatement pStmt = null;
		
		try {
			
			//Step1: connection
			Class.forName(driverName);
			con = DriverManager.getConnection(dbUrl, dbuser, dbpwd);
			
			//Step2: statement
			pStmt = con.prepareStatement("SELECT id, pwd FROM users WHERE id=? and pwd=?");
			pStmt.setString(1, userVO.getId());
			pStmt.setString(2, userVO.getPwd());
			
			//Step3: resultset
			rs = pStmt.executeQuery();
			if(rs.next()) {
				System.out.println("db id, pwd ==>" + rs.getString(1) + ":" + rs.getString(2));
				userVO.setActive(true);
			}else {
				System.out.println("not existing data : " + userVO.getId());
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			
			if(rs != null) {
				try {
					rs.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(pStmt != null) {
				try {
					pStmt.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
			if(con != null) {
				try {
					con.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}// end of getUser()
	
}//end of class
