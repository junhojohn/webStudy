<%@ page contentType="text/html;charset=euc-kr" %>

<%@ page errorPage="WEB-INF/edu/JSPErrorPage.jsp" %>

<%--	
	���� error page �� ������ �����ϰ� �Ʒ���  RelativeURI�� ��������
	<%@ page errorPage="../jw07/03JSPErrorPage.jsp" %>   
--%>

<!--  buffer �� ����Ҷ��� ������� ���� ��츦 ��  -->
<%-- <%@ page buffer="none" %> --%>

<html>
<body>
	1. Start of 08JSPActionForward.jsp....<br/>

	<%	
		request.setAttribute("aaa",new String("request connected."));
	%>
	<% String str = "abc"; %>
	<% Integer.parseInt(str); %>
	<!-- 	forward �� RelativeURI�� ��� 
			:: ==> �Ʒ��� �� forward �� ������ �ּ�ó���ϰ� Test -->
	<jsp:forward page="09JSPActionForward.jsp" />
	
	2. End of 08JSPActionForward.jsp...<br/>
</body>
</html>

<%--
	�ϳ� :	���� page  buffer="none "�������� �� �ּ��� test ==> exception
	            ==> forward �� ���������� buffer �� clear 
--%>