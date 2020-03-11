<%@page import="com.junhojohn.models.UserVO"%>
<%@ page language="java"%>
<%@ page contentType="text/html; charset=EUC-KR" %>

<%
	UserVO userVO = (UserVO)session.getAttribute("userVO");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Home Page</title>
</head>
<body>
	<p>Simple Model 2 Example</p>
	<p>Welcome : <%=userVO.getId()%>.
</body>
</html>
