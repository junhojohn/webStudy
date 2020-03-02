<%@ page language="java" %>
<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="java.sql.*" %>


<!-- 1.JSP Code Start. -->
<%
	
	request.setCharacterEncoding("EUC_KR");
	String requestId 	= request.getParameter("id");
	String requestPwd	= request.getParameter("pwd");
	String fromDbId		= null;
	String fromDbPwd	= null;
	
	String dbDriver = "oracle.jdbc.driver.OracleDriver";
	String dbUrl 	= "jdbc:oracle:thin:@127.0.0.1:1521:junhojohn";
	String dbId		= "SYSTEM";
	String dbPwd	= "Wnsgh3535";

	PreparedStatement pStmt	= null;
	Connection con 			= null;	
	ResultSet rs			= null;
	
	Class.forName(dbDriver);	
	con 	= DriverManager.getConnection(dbUrl, dbId, dbPwd);
	pStmt 	= con.prepareStatement("SELECT id, pwd FROM USERS WHERE id=?");
	pStmt.setString(1, requestId);
	rs 		= pStmt.executeQuery();
	
	if(rs.next()){
		fromDbId 	= rs.getString(1);
		fromDbPwd 	= rs.getString(2);
		System.out.println("DB data found. id:" + fromDbId + ", pwd:" + fromDbPwd);
	}else{
		System.out.println("No DB data found. id:" + requestId);
	}

	rs.close();
	pStmt.close();
	con.close();
%>
<!-- 2.JSP Code End. -->


<!-- 3.HTML Code Start. -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Login Page</title>
</head>
<body>
	<h2>Login Page</h2>
	
	<% if(requestId != null && requestPwd != null && requestId.equals(fromDbId) && requestPwd.equals(fromDbPwd)) { 	%>
			Welcome, <%=fromDbId %>.
	<% }else{ %>
			Login failed. Please check id and password again.
	<% } %>
	
	<p/>
	<p/>
	<a href="/MyFirstWebProject12/LoginJSP.jsp">Back</a>
</body>
</html>
<!-- 4.HTML Code End. -->