<%@ page language="java" %>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page info="First JSP" %>
<%@ page session="true" %>
<%@ page isThreadSafe="true" %>

<%--
  JSP comment style ==> JSP Container cannot recognize this style when converting JSP to Java!
  Use HTML comment style!
  <%@ page extends="java.util.Vector" %>
--%>


<!-- 1.JSP Code Start. -->
<%
  String title = "This is first JSP.";
  System.out.println(title);
  
  Calendar calendar = Calendar.getInstance();
  int year	 		= calendar.get(Calendar.YEAR);
  int month	 		= calendar.get(Calendar.MONTH) + 1;
  int date 			= calendar.get(Calendar.DATE);
  String today 		= year + "." + month + "." + date;
  System.out.println(today);
  
  String info		= getServletInfo();
  System.out.println("information:" + info);
%>
<!-- 2.JSP Code End. -->


<!-- 3.HTML Code start -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>JSP Directive Elements TEST</title>
</head>
<body>
	Hello, HTML!
	<br/>
	<hr/>
	<%= title %>
	<br/>
	<%= today %>
	<br/>
	<%= "information:" + info %>
	<br/>
	<hr/>
	Bye, HTML!
	<br/>
</body>
</html>
<!-- 3.HTML Code end -->