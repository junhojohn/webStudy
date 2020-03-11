<%@ page language="java"%>
<%@ page contentType="text/html; charset=EUC-KR" %>

<%
	String userId  = "아이디입력";
	String userPwd = "비밀번호입력"; 
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Logon Page</title>
</head>
<body>
	<form action="/MyFirstWebProject24/logonAction.do" method="post" id="login">
		아이디: <input id="userId" type="text" name="userId" value="<%=userId%>"><br/><br/>
		비밀번호: <input id="userPwd" type="text" name="userPwd" value="<%=userPwd%>"><br/><br/>
		<input id="submit" type="submit" name="submnit" value="Enter">
	</form>
</body>
</html>