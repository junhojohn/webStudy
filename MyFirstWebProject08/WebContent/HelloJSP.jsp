<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Hello JSP</title>
</head>
<body>


<!-- 1.HTML Code Start -->
<p>Hello JSP!</p>
<!-- 2.HTML Code End -->


<!-- 1.Java Servlet Code Start -->
<% 
	for(int i=0;i<10;i++){
		out.println(" i  : " + i+"<br/>");
	}
%>
<!-- 2.Java Servlet Code End -->


</body>
</html>