import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionUseCookieTwoServlet extends HttpServlet {
	
	/**
	 * overriding service() method 
	 * called when connect to "http://127.0.0.1/8080/MyFirstWebProject06/SessionUseCookieTwoServlet"
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("1. SessionUseCookieTwoServlet service() start");
		System.out.println("Client IP: " + req.getRemoteAddr());
		
		//Receive Http Session data from HttpRequest
		req.setCharacterEncoding("EUC_KR");
		HttpSession session = req.getSession(false);
		
		//Send HttpResponse
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>SessionTwo</title></head>");
		out.println("<body>");
		out.println("<center><h2>SessionUseCookieTwoServlet</h2></center>");
		if(session != null) {
			out.println("Welcome back, " + session.getAttribute("id") + "!");
			out.println("session ID: " + session.getId());
		}else {
			out.println("This is the first visit.");
		}
		out.println("</body>");
		out.println("</html>");

		System.out.println("2. SessionUseCookieOneServlet service() stop");
		
	}//end of service()

}//end of class
