import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserInitParamDao {

	private String jdbcDriver;
	private String jdbcUrl;
	private String jdbcUser;
	private String jdbcPassword;
	
	public UserInitParamDao() {
		// TODO Auto-generated constructor stub
	}
	
	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public void setJdbcUser(String jdbcUser) {
		this.jdbcUser = jdbcUser;
	}
	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}
	
	public void getUser(UserVO userVO) {
		
		ResultSet rs 			= null;
		Connection con 			= null;
		PreparedStatement pStmt = null;
		
		try {
			
			//Step1: connection
			Class.forName(jdbcDriver);
			con = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
			
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