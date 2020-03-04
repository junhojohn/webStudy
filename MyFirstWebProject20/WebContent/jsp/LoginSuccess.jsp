<%@page import="com.junhojohn.core.models.UserVO"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="com.junhojohn.core.*" %>
<%@ page errorPage="ErrorPage.jsp" %> 
<%
	UserVO userVO = (UserVO)session.getAttribute("userVO");
	if(userVO == null){
		userVO = new UserVO();
	}

	if(!userVO.isActive()){
		response.sendRedirect("/MyFirstWebProject20");
	}  
%>


<html>
<head>
<title>Login Success!</title>
</head>
<body>
	Welcome, <%=userVO.getId() %>.
	
	<form method="post" action="Logout.jsp">
		<input type="submit" value="Logout"/>
	</form> 
</body>
</html>