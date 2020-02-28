import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Send Cookie data to client
 *
 */
public class CookieWriterToClientServlet extends HttpServlet {

	/**
	 * overriding service() method 
	 * called when connect to "http://127.0.0.1/8080/MyFirstWebProject06/CookieWriterToClientServlet"
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("1. CookieWriterToClientServlet service() start");
		System.out.println("Client IP: " + req.getRemoteAddr());
		
		// Receive HTTP Request data
		req.setCharacterEncoding("EUC_KR");
		
		//Create Cookie
		Cookie cookie = new Cookie("id", "junhojohn");
		//cookie.setMaxAge(60);	// set 60 seconds to expire cookie(unit: second)
		//cookie.setMaxAge(-1);	// clear cookie when browser closed
		cookie.setMaxAge(0);	// set 0 seconds to expire cookie
		
		//Send Cookie with HTTP Response
		res.setContentType("text/html;charset=EUC_KR");
		res.addCookie(cookie);
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Cookie saved to client.");
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("2. CookieWriterToClientServlet service() stop");
	
	}//end of service()
	
}// end of class 
