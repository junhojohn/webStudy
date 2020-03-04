<%@ page contentType="text/html; charset=EUC-KR"%>

<html>
<head>
<title>10ResponseSendRedirect</title>
</head>
<body>
	Start of 10ResponseSendRedirect.jsp...<br/>
	
	<%
		request.setAttribute("aaa", "request connected.");
		//response.sendRedirect("09JSPActionForward.jsp");
		//response.sendRedirect("http://127.0.0.1:8080/MyFirstWebProject19/09JSPActionForward.jsp");
		response.sendRedirect("http://www.google.com");
	%>
</body>
</html>