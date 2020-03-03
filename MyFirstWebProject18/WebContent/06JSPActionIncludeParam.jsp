<%@ page contentType="text/html; charset=EUC-KR"%>

<html>
<head>
<title>06JSPActionIncludeParam</title>
</head>
<body>

	<%
		String str ="local variable";
		request.setAttribute("aaa", new String("It is request."));
		session.setAttribute("bbb", new String("It is session."));
		application.setAttribute("ccc", new String("It is application."));
	%>
	<jsp:include page="07JSPActionIncludeParam.jsp">
		<jsp:param value="<%= str %>" name="str"/>
	</jsp:include>
</body>
</html>