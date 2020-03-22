<%@ page language="java"%>
<%@ page contentType="text/html; charset=EUC-KR" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>SpringWebProject10</title>
</head>
<body>
	1. Expression Tag �̿�	<br/>
	<%
		String requestScopeMsg = (String)request.getAttribute("request");
		String sessionScopeMsg = (String)session.getAttribute("session");
		String applicationScopeMsg = (String)application.getAttribute("application");
	%>
	request.getAttribute("request"): 			<%= requestScopeMsg %>		<br/>
	session.getAttribute("session"): 			<%= sessionScopeMsg %>		<br/>
	application.getAttribute("application"):	<%= applicationScopeMsg %>	<br/>
	<hr/>
	
	2. Expression Language �̿�	<br/>
	requestScope.request: 			${ requestScope.request }			<br/>
	sessionScope.session: 			${ sessionScope.session }			<br/>
	applicationScope.application: 	${ applicationScope.application }	<br/>
	<hr/>
	
	3. ModelAndView �̿�		<br/>
	requestScope.message:		${ requestScope.message }		<br/>
	sessionScope.message:		${ sessionScope.message }		<br/>
	applicationScope.message:	${ applicationScope.message }	<br/>
	<hr/>
	
	4. URI /URL ǥ��		<br/>
	request.getRequestURI(): <%= request.getRequestURI() %>	<br/>
	request.getRequestURL(): <%= request.getRequestURL() %>	<br/>
	
</body>
</html>