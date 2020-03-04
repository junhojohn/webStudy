<%@page import="com.junhojohn.core.models.UserVO"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="com.junhojohn.core.*" %>
<%@ page errorPage="ErrorPage.jsp" %> 
<%
	if(request.getMethod().equals("POST")){
		session.setAttribute("userVO", null);
		session.removeAttribute("userVO");
	}

	UserVO userVO = (UserVO)session.getAttribute("userVO");
	if(userVO == null){
		response.sendRedirect("/MyFirstWebProject20");
	}else{
		response.sendRedirect("LoginSuccess.jsp");	
	}
%>
