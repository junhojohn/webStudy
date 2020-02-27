import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * UserDao.java의 경우 특정 DB를 사용하는 것이 Fix됨
 * DB 관련 사항은 web.xml(Meta-data)에 등록해 놓으면, 특정 DB가 아닌
 * DB에 종속적이지 않은 Web Application을 작성할 수 있다.
 * @author 82109
 *
 */
public class LoginInitParamServlet extends HttpServlet {
	// Field
	private String jdbcDriver 	= null;
	private String jdbcUrl 		= null;
	private String jdbcUser 	= null;
	private String jdbcPassWord = null;
	
	//init() method overriding
	//==> web.xml에 등록된 init-param 추출
	//==> init() method는 client의 최초 request에 1회만 호출(Servlet Life Cycle)
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		
		jdbcDriver 		= config.getInitParameter("jdbcDriver");
		jdbcUrl 		= config.getInitParameter("jdbcUrl");
		jdbcUser 		= config.getInitParameter("jdbcUser");
		jdbcPassWord 	= config.getInitParameter("jdbcPassword");
		
		System.out.println("get init-param data from web.xml.");
		System.out.println("jdbcDriver: " + jdbcDriver);
		System.out.println("jdbcUrl: " + jdbcUrl);
		System.out.println("jdbcUser: " + jdbcUser);
		System.out.println("jdbcPassword:" + jdbcPassWord);
	}
	
	//doPost() method overriding
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("1. Servlet doPost() start");
		System.out.println("Clietn IP:" + req.getRemoteAddr());
		
		// Get Data from Post HTTP Request
		req.setCharacterEncoding("EUC_KR");
		String id 	= req.getParameter("id");
		String pwd 	= req.getParameter("pwd");
		
		// Create User Value Object
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setPwd(pwd);
		
		// Create DB Access Object
		UserInitParamDao userInitParamDao = new UserInitParamDao();
		userInitParamDao.setJdbcDriver(jdbcDriver);
		userInitParamDao.setJdbcUrl(jdbcUrl);
		userInitParamDao.setJdbcUser(jdbcUser);
		userInitParamDao.setJdbcPassword(jdbcPassWord);
		userInitParamDao.getUser(userVO);
		
		// Send Data with HTML Response
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>Login Page</title></head>");
		out.println("<body>");
		out.println("<h2> Login Page </h2>");
		if(userVO.isActive()) {
			out.println("Welcome, " + userVO.getId());
		}else {
			out.println("Fail to login. Invalid password or id.");			
		}
		out.println("<p><p><a href='LoginInitParamServlet.html'>Back</a>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("2. Servlet doGet() stop");
	}
}
