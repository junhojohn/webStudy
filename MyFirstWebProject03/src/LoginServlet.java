import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

	
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
		UserDao userDao = new UserDao();
		userDao.getUser(userVO);
		
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
		out.println("<p><p><a href='LoginServlet.html'>Back</a>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("2. Servlet doGet() stop");
	}
}
