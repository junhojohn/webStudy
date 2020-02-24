import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServletDoGet extends HttpServlet {

	//init() ==> method 오버라이딩 하지 않음
	/**
	 * doGet() ==> method 오버라이딩
	 * 
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("1. Servlet doGet() start");
		System.out.println("Clietn IP:" + req.getRemoteAddr());
		// character set 한글 설정
		res.setContentType("text/html;charset=EUC_KR");
		// HttpServletResponse API를 확인하면...(2번째 방법:: 일반적인 방법)
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>Hello Servlet</title></head>");
		out.println("<body>");
		out.println("English: Hello Servlet");
		out.println("<p>");
		out.println("Korean: 헬로 서블릿");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		System.out.println("2. Servlet doGet() stop");
	}
	//destroy() ==> method 오버라이딩 하지 않음

} // end of class
