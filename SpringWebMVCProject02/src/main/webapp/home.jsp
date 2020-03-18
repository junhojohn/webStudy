<%@page import="com.junhojohn.models.UserVO"%>
<%@page import="com.junhojohn.consts.Const"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"%>

<%
	UserVO userVO = (UserVO)session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Welcome Page</title>
</head>
<body>
	Welcome, <%=userVO.getId() %>!
</body>
</html>