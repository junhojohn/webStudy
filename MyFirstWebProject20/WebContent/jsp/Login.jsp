<%@page import="com.junhojohn.core.daos.UserDao"%>
<%@page import="com.junhojohn.core.models.UserVO"%>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page import="com.junhojohn.core.*" %>
<%@ page errorPage="ErrorPage.jsp" %> 
<!-- GET 방식 방어처리 -->
<% if(request.getMethod().equals("GET")){ %>
	<jsp:forward page="../html/Login.html"></jsp:forward>
<% } %>

<%
	String requestId 	= null;
	String requestPwd 	= null;
	
	request.setCharacterEncoding("EUC_KR");
	requestId 	= request.getParameter("id");
	requestPwd 	= request.getParameter("pwd");
	
	System.out.println("0.session id: " + session.getId());
	UserVO userVO = (UserVO)session.getAttribute("userVO");
	System.out.println("00.session id: " + session.getId());
	if(userVO == null){
		System.out.println("1.session id: " + session.getId());
		// session이 없는 경우
		userVO = new UserVO();
		userVO.setId(requestId);
		userVO.setPwd(requestPwd);
	}else{
		// session이 있고 다시 로그인한 아이디가 다를 경우
		if((!requestId.equals(userVO.getId())) &&
				(!requestPwd.equals(userVO.getPwd()))){
			userVO.setId(requestId);
			userVO.setPwd(requestPwd);			
		}
		System.out.println("2.session id: " + session.getId());
	}
	
	UserDao userDao = new UserDao();
	userDao.getUserVO(userVO);
%>
	
<% if(userVO.isActive()){ 						%>
<% 		session.setAttribute("userVO", userVO); %>		
		<jsp:forward page="LoginSuccess.jsp">
			<jsp:param value="<%= userVO.getId() %>" name="requestId"/>
		</jsp:forward>
<% }else{ %>	
		<jsp:forward page="../html/LoginFailed.html"/>
<% } %>	