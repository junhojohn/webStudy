<%@page import="com.junhojohn.models.User"%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=EUC-KR" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>view.jsp</title>
</head>
<body>

	<h3>1. Servlet���� Request Object Scope�� ������ ���� ���</h3><br/>
	<% User requestObjectUser = (User)request.getAttribute("user"); %>
	<% if(requestObjectUser != null){ %>
			�̸�: <%= requestObjectUser.getName() %><br/>
			����: <%= requestObjectUser.getAge()  %><br/>
	<% } %>
	<br/>
	<hr/>
	<br/>

	<h3>2. Servlet���� Session Object Scope�� ������ ���� ���</h3><br/>
	<% User sessionObjectUser = (User)session.getAttribute("user"); %>
	<% if( sessionObjectUser != null){ %>
			�̸�: <%= sessionObjectUser.getName() %><br/>
			����: <%= sessionObjectUser.getAge()  %><br/>
	<% } %>
	<br/>
	<hr/>
	<br/>

	<h3>3. Servlet���� Application Object Scope�� ������ ���� ���</h3><br/>
	<% User applicationObjectUser = (User)application.getAttribute("user"); %>
	<% if( applicationObjectUser != null){ %>
			�̸�: <%= applicationObjectUser.getName() %><br/>
			����: <%= applicationObjectUser.getAge()  %><br/>
	<% } %>	
	<br/>
	<hr/>
	<br/>
		
</body>
</html>