<%@page import="com.junhojohn.consts.REQ_ACTION_PAGES_ENUM_002"%>
<%@page import="com.junhojohn.consts.Const"%>
<%@page import="com.junhojohn.models.UserVO"%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=EUC-KR" %>

<%
	UserVO userVO = (UserVO)session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Home Page</title>
</head>
<body>
	[Info]:: ${ requestScope.message } <br/>
	<p>Simple Model2 Examples</p>
	<p>환영합니다. : <%=userVO.getId() %> 님 </p>
	<br/><br/>
	<a href="<%= REQ_ACTION_PAGES_ENUM_002.REQ_LOGOUT.getRequestURI() %>">logout</a>
</body>
</html>