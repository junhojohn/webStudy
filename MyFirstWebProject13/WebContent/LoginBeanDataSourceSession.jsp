<%@ page language="java" %>
<%@ page import="java.sql.*" %>
<%@ page contentType="text/html; charset=EUC-KR"%>


<!-- 1.JSP Code Start. -->
<%
	String id 	= null;	
	String pwd	= null;
	id 	= request.getParameter("id");
	pwd = request.getParameter("pwd");
	models.UserVO userVO = (models.UserVO)session.getAttribute("userVO");
	System.out.println("userVO in session: " + userVO);
	
	if( !(id == null || id.equals(""))){
		userVO = new models.UserVO();
		userVO.setId(id);
		userVO.setPwd(pwd);
		
		daos.UserDataSourceDao userDataSourceDao = new daos.UserDataSourceDao();
		userDataSourceDao.getUserVO(userVO);
	}
%>
<!-- 2.JSP Code End. -->


<!-- 3.HTML Code Start. -->
<html>
<head>
<title>Login Page</title>
</head>
<body>
	<h2>Login Page</h2>
	
	<% if(userVO != null && userVO.isActive()){ %>
		Welcome, <%= userVO.getId() %>. 
		<%
			session.setAttribute("userVO", userVO);
		%>	
	<% }else{ %>
		Login failed. Please check your id and password.
	<% } %>
	<p/>
	<p/>
	<a href="/MyFirstWebProject13/LoginBeanDataSourceSession.html">Back</a>
</body>
</html>
<!-- 3.HTML Code End. -->