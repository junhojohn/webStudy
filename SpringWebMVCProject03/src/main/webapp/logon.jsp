<%@page import="com.junhojohn.consts.Const"%>
<%@page import="com.junhojohn.consts.REQ_ACTION_PAGES_ENUM"%>
<%@ page language="java"%>
<%@ page contentType="text/html; charset=EUC-KR" %>

<%
	String userId  = "���̵��Է�";
	String userPwd = "��й�ȣ�Է�"; 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Logon Page</title>
</head>
<body>
	<!-- <form action="/MyFirstWebProject24/logonAction.do" method="post" id="login"> -->
	<form action="<%=REQ_ACTION_PAGES_ENUM.REQ_LOGON_ACTION.getRequestURI() %>" method="post" id="login">
		���̵�: <input id="<%=Const.REQ_PARAM_KEY_USER_ID%>" type="text" name="<%=Const.REQ_PARAM_KEY_USER_ID%>" value="userId"><br/><br/>
		��й�ȣ: <input id="<%=Const.REQ_PARAM_KEY_USER_PWD%>" type="text" name="<%=Const.REQ_PARAM_KEY_USER_PWD%>" value="userPwd"><br/><br/>
		<input id="submit" type="submit" name="submnit" value="Enter">
	</form>
</body>
</html>