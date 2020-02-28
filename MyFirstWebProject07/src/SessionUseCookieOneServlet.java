import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionUseCookieOneServlet extends HttpServlet {

	/**
	 * overriding service() method 
	 * called when connect to "http://127.0.0.1/8080/MyFirstWebProject06/SessionUseCookieOneServlet"
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("1. SessionUseCookieOneServlet service() start");
		System.out.println("Client IP: " + req.getRemoteAddr());
		
		//Receive Http Request data
		req.setCharacterEncoding("EUC_KR");
		
		//if HttpSession exists, use existing HttpSession. If not, create new HttpSession.
		HttpSession session = req.getSession(true);
		if(session.isNew()) {
			session.setAttribute("id", "junhojohn");// set id & value to session.
			session.setMaxInactiveInterval(60); 	// set 60 seconds to retain session.(unit: second)
		}
		System.out.println("Unique Session ID: " + session.getId());
		
		//Send Http Response
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>Cookie Session</title></head>");
		out.println("<body>");
		out.println("<center><h2>SessionUseCookieOneServlet</h2></center>");
		if(session.isNew()) {
			out.println("New session created.");
		}else {
			out.println("Session " + session.getId() + "is in use.");
		}
		out.println("<hr>");
		out.println("<a href='/MyFirstWebProject07/SessionUseCookieTwoServlet'>Link</a>");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("2. SessionUseCookieOneServlet service() stop");
		
	}//end of service()
	
}//end of class
