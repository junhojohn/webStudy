import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetDataServlet extends HttpServlet {
	
	//init() ==> method 오버라이딩 하지 않음
	
	/**
	 * doGet() ==> method 오버라이딩
	 * http://127.0.0.1:8080/MyFirstWebProject02/GetDataServlet?name=junhojohn&addr=Seoul'으로 접속하면 doGet() 메소드가 메시징된다.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// Client에서 전송되어 오는 data(QueryString:: name=value, addr=value)처리 (API 확인)
		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");

	// Client로부터 받은 Data를 출력
	System.out.println("clientName:" + clientName);
	System.out.println("clientAddr:" + clientAddr);
	// 아래 실행문은 servlet에서 client로 응답 html 전송 시 문자셋을 설정하는 부분
	res.setContentType("text/html;charset=EUC_KR");
	// HttpServletResponse API를 확인하면...(2번째 방법:: 일반적인 방법)
	PrintWriter out = res.getWriter();
	out.println("<html>");
	out.println("<head><title>GetData.java</title></head>");
	out.println("<body>");
	out.println("<h2>Get Test</h2>");
	out.println("<li>이름:" + clientName);
	out.println("<li>주소:" + clientAddr);
	out.println("<p><p><a href='/MyFirstWebProject02/GetDataServlet'>뒤로</a>");
	out.println("</body>");
	out.println("</html>");
	}
	//destroy() ==> method 오버라이딩 하지 않음

} // end of class
