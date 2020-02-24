import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServletDoPost extends HttpServlet {

	// init() => method 오버라이딩 하지 않음
	
	/**
	 * doPost() ==> method 오버라이딩
	 * http://127.0.0.1:8080/MyFirstWebProject02/HelloServletDoPost으로 접속하면 doPost() 메소드가 메시징된다.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("1. Servlet doPost() start");
		System.out.println("Client IP:" + req.getRemoteAddr());
		
		res.setContentType("text/html;charset=EUC_KR");
		
		// HttpServletResponse API를 확인하면...(2번째 방법:: 일반적인 방법)
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>Hello Servlet do Post</title></head>");
		out.println("<body>");
		out.println("English: Hello Servlet");
		out.println("<p>");
		out.println("Korean: 헬로 서블릿");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
		System.out.println("2. Servlet doPost() stop");

	}
	
	//destroy() ==> method 오버라이딩 하지 않음

} // end of class
