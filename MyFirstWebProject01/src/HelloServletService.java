import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServletService extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("1. servlet service() start");
		System.out.println("Client IP: " + req.getRemoteAddr());
		// 아래의 두 실행문을 변경하여 실행:: 한글 처리
		//res.setContentType("text/html");
		res.setContentType("text/html;charset=EUC_KR");
		// Client로 보내는 Stream을 생성(1번째 방법)
		/*
		ServletOutputStream sos = res.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(sos);
		PrintWriter out = new PrintWriter(osw);
		*/
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
		System.out.println("2. servlet service() stop");
	}
	//destroy() ==> method overriding 하지 않음

}// end of class
