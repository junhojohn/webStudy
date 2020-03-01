<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<html>
	<head>
		<title>JSP Comment Example</title>
	</head>
	<body>
		1. JSP Comment Example
		<br/>
		
		<%
			String str1 = "Comment1";
			String str2 = "Comment2";
		%>
		
		
		<!-- 
			<%= str1 %>
			This is html comment style.
		 -->

		<!-- 
			<%= str2 %>
			This is html comment style.
		 -->		
		 
		 <%--
		 	This is JSP comment style.
		  --%> 
		  
		  <%
		  	//This is Java comment style.
		  	//NewLine..?
		  %>
	</body>
</html>