<%@ page contentType="text/html; charset=EUC-KR"%>
 
<html>
<head>
<title>07JSPActionIncludeParam</title>
</head>
<body>
 
	Check object scope below...
	<br/>
	<hr/>
	request getAttribute(): <%= request.getAttribute("aaa") %><br/>
	session getAttribute(): <%= session.getAttribute("bbb") %><br/>
	application getAttribute(): <%= application.getAttribute("ccc") %><br/>
	<br/>
	<hr/>
	Check param data below...
	<br/>
	<hr/>
	request Param str: <%= request.getParameter("str") %>
</body>
</html>