import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloServletDoGet extends HttpServlet {

	//init() ==> method �������̵� ���� ����
	
	/**
	 * doGet() ==> method �������̵�
	 * http://127.0.0.1:8080/MyFirstWebProject02/HelloServletDoGet���� �����ϸ� doGet() �޼ҵ尡 �޽�¡�ȴ�.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("1. Servlet doGet() start");
		System.out.println("Clietn IP:" + req.getRemoteAddr());
		
		// character set �ѱ� ����
		res.setContentType("text/html;charset=EUC_KR");
		
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
		
		System.out.println("2. Servlet doGet() stop");
	}
	
	//destroy() ==> method �������̵� ���� ����

} // end of class
