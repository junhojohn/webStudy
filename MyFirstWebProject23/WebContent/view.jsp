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

	<h3>1. Servlet에서 Request Object Scope에 저장한 정보 출력</h3><br/>
	<% User requestObjectUser = (User)request.getAttribute("user"); %>
	<% if(requestObjectUser != null){ %>
			이름: <%= requestObjectUser.getName() %><br/>
			나이: <%= requestObjectUser.getAge()  %><br/>
	<% } %>
	<br/>
	<hr/>
	<br/>

	<h3>2. Servlet에서 Session Object Scope에 저장한 정보 출력</h3><br/>
	<% User sessionObjectUser = (User)session.getAttribute("user"); %>
	<% if( sessionObjectUser != null){ %>
			이름: <%= sessionObjectUser.getName() %><br/>
			나이: <%= sessionObjectUser.getAge()  %><br/>
	<% } %>
	<br/>
	<hr/>
	<br/>

	<h3>3. Servlet에서 Application Object Scope에 저장한 정보 출력</h3><br/>
	<% User applicationObjectUser = (User)application.getAttribute("user"); %>
	<% if( applicationObjectUser != null){ %>
			이름: <%= applicationObjectUser.getName() %><br/>
			나이: <%= applicationObjectUser.getAge()  %><br/>
	<% } %>	
	<br/>
	<hr/>
	<br/>
		
</body>
</html>