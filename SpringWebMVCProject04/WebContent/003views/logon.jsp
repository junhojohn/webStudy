<%@page import="com.junhojohn.consts.REQ_ACTION_PAGES_ENUM_002"%>
<%@page import="com.junhojohn.models.UserVO"%>
<%@page import="com.junhojohn.consts.Const"%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=EUC-KR" %>

<%
	String id 	= "아이디 입력";
	String pwd 	= "비밀번호 입력";
	UserVO userVO = (UserVO)session.getAttribute(Const.SESSION_ATTR_KEY_USER_VO);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Logon Page</title>
</head>
<body>
	[Info]: ${ requestScope.message } <br/>
	<% if(userVO != null && userVO.isActive()){ %>
		<%= userVO.getId() %> 님은 이미 로그인 하셨습니다. <br/>
	<% }else{ %>
		<form action="<%= REQ_ACTION_PAGES_ENUM_002.REQ_LOGON_ACTION.getRequestURI() %>" method="post">
			아이디  	: <input type="text" name="<%= Const.REQ_PARAM_KEY_USER_ID %>" value="<%= id %>"> <br/><br/>
			비밀번호	: <input type="text" name="<%= Const.REQ_PARAM_KEY_USER_PWD %>" value="<%= pwd %>"> <br/><br/>
			<input type="submit" name="submit" value="Enter"/>
		</form>
	<% } %>
</body>
</html>