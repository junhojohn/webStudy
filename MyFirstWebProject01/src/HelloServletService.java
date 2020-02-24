import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServletService extends HttpServlet {

	//init() => method overriding ���� ����
	
	/**
	 * ������������ http://localhost:8080/MyFirstWebProject01/HelloServletService�� url������ �� service()�޼ҵ� ����
	 */
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("1. servlet service() start");
		System.out.println("Client IP: " + req.getRemoteAddr());
		
		// �Ʒ��� �� ���๮�� �����Ͽ� ����:: �ѱ� ó��
		//res.setContentType("text/html");
		res.setContentType("text/html;charset=EUC_KR");
		
		// Client�� ������ Stream�� ����(1��° ���)
		/*
		ServletOutputStream sos = res.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(sos);
		PrintWriter out = new PrintWriter(osw);
		*/
		
		// HttpServletResponse API�� Ȯ���ϸ�...(2��° ���:: �Ϲ����� ���)
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>Hello Servlet</title></head>");
		out.println("<body>");
		out.println("English: Hello Servlet");
		out.println("<p>");
		out.println("Korean: ��� ����");
		out.println("</body>");
		out.println("</html>");
		out.flush();
		out.close();
		
		System.out.println("2. servlet service() stop");
	}
	
	//destroy() ==> method overriding ���� ����

}// end of class
