
<%@ page contentType="text/html;charset=euc-kr" %>

<!-- 
	1. set value "true" if jsp is error handling page.
	2. if not setting this, it would get HTTP 500 server error.
-->
<%@ page isErrorPage="true" %>

<% System.out.println("Start running JSPError.jsp!!!");  %>

	<br/>
	<hr/>
	OOPS! Somethings wrong!<br/><br/>

	exception : <%= exception %><br/>
	exception.toString() : <%= exception.toString() %><br/>
	exception.getMessage() : <%= exception.getMessage() %><br/><br/>
	
	Sorry, Could not found web page.<br/>
	<hr/>
	<br/>

<% System.out.println("Stop running 03JSPErrorPage.jsp.");  %>