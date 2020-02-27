import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostDataServlet extends HttpServlet {

	/**
	 * doPost() ==> method 오버라이딩
	 * http://127.0.0.1:8080/MyFirstWebProject02/PostDataServlet.html으로 접속 => click "전송" 하면 doPost() 메소드가 메시징된다.
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("1. Servlet doPost() start");
		System.out.println("Client IP:" + req.getRemoteAddr());
		
		//res.setCharacterEncoding("~~") (API 확인)
		//Client에서 전송되어 오는 data를 encoding하여 처리(API확인)
		req.setCharacterEncoding("EUC_KR");
		
		// Client에서 전송되어 오는 data(QueryString:: name=value, addr=value)처리 (API 확인)
		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");
		
		// Client로부터 받은 Data를 출력
		System.out.println("clientName:" + clientName);
		System.out.println("clientAddr:" + clientAddr);
		
		// character set 한글 설정
		res.setContentType("text/html;charset=EUC_KR");
		
		// HttpServletResponse API를 확인하면...(2번째 방법:: 일반적인 방법)
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>PostDataServlet.java</title></head>");
		out.println("<body>");
		out.println("<h2>Post Test</h2>");
		out.println("<li>이름:" + clientName);
		out.println("<li>주소:" + clientAddr);
		out.println("<p><p><a href='/MyFirstWebProject02/PostDataServlet.html'>뒤로</a>");
		out.println("</body>");
		out.println("</html>");		
		
		System.out.println("1. Servlet doPost() stop");
	}
}
