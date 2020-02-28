import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Read saved Cookie data from client
 *
 */
public class CookieReaderToServerServlet extends HttpServlet {

	/**
	 * overriding service() method 
	 * called when connect to "http://127.0.0.1/8080/MyFirstWebProject06/CookieReaderToServerServlet"
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("1. CookieReaderToServerServlet service() start");
		System.out.println("Client IP: " + req.getRemoteAddr());
		
		//Field
		String name 		= null;
		String value 		= null;
		boolean wasVisted 	= false;
		
		//Get Cookie data from client
		req.setCharacterEncoding("EUC_KR");
		Cookie[] cookies = req.getCookies();
		if(cookies != null) {
			System.out.println("Cookie exists!");
			for(int i = 0 ; i < cookies.length ; i ++) {
				name 		= cookies[i].getName();
				value 		= cookies[i].getValue();
				wasVisted 	= true;
				System.out.println("Cookie data send from client. name: " + name + ", value: " + value);
			}
		}else{
			System.out.println("No cookie was found from client...");
		} 
		
		//Send welcome message to client if cookie exists.
		res.setContentType("text/html;charset=EUC_KR");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(wasVisted) {
			out.println("Welcome back, " + value + ".");
		}else {
			out.println("This is the first visit.");
		}
		out.println("</body>");
		out.println("</html>");
		
		System.out.println("2. CookieReaderToServerServlet service() stop");
	
	}// end of service()

}// end of class
