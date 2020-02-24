import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetDataServlet extends HttpServlet {
	
	//init() ==> method �������̵� ���� ����
	
	/**
	 * doGet() ==> method �������̵�
	 * http://127.0.0.1:8080/MyFirstWebProject02/GetDataServlet?name=junhojohn&addr=Seoul',���� �����ϸ� doGet() �޼ҵ尡 �޽�¡�ȴ�.
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// Client���� ���۵Ǿ� ���� data(QueryString:: name=value, addr=value)ó�� (API Ȯ��)
		String clientName = req.getParameter("name");
		String clientAddr = req.getParameter("addr");

		// Client�κ��� ���� Data�� ���
		System.out.println("clientName:" + clientName);
		System.out.println("clientAddr:" + clientAddr);
		
		// �Ʒ� ���๮�� servlet���� client�� ���� html ���� �� ���ڼ��� �����ϴ� �κ�
		res.setContentType("text/html;charset=EUC_KR");
		
		// HttpServletResponse API�� Ȯ���ϸ�...(2��° ���:: �Ϲ����� ���)
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head><title>GetData.java</title></head>");
		out.println("<body>");
		out.println("<h2>Get Test</h2>");
		out.println("<li>�̸�:" + clientName);
		out.println("<li>�ּ�:" + clientAddr);
		out.println("<p><p><a href='/MyFirstWebProject02/GetDataServlet'>�ڷ�</a>");
		out.println("</body>");
		out.println("</html>");
		
	}
	
	//destroy() ==> method �������̵� ���� ����

} // end of class
