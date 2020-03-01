
<%@ page contentType="text/html;charset=euc-kr" %>

<!-- 1.JSP Code Start. -->


<!-- 
	errorPage: Designate jsp page when error occurs.
	1. Delete "page errorPage~" and run without it.
	2. Rollback and run with it. Check different result.
-->
<%@ page errorPage="JSPErrorPage.jsp" %> 

<%--
	3. Try running with these errorPages one by one.
	4. These errorPages would cause 404 Htttp erro.
	5. Because Web Application context starts with "/MyFirstWebProject10".
	<%@ page errorPage="http://127.0.0.1:8080/MyFirstWebProject10/JSPErrorPage.jsp" %>
	<%@ page errorPage="/MyFirstWebProject10/JSPErrorPage.jsp" %>
	<%@ page errorPage="/03JSPErrorPage.jsp" %>
 --%>


<!-- 
	6. Delete "buffer=~" and run without it.
	7. Rollback and run with it. Check different result.
-->
  <%-- <%@page buffer="none" %> --%>


<!-- 2.JSP Code End. -->


<!-- 3.HTML Code Start -->
<html>
<body>

	Hello, HTML!
	<br/>
	total Buffer size : <%= out.getBufferSize() %>
	<br/> 
	used Buffer size : <%= out.getRemaining() %>
	<br/>
	<hr/>
	<%= "fire Exception on purpose." %>
	<% int number=0; %>
	<% number = Integer.parseInt("a"); %>
	<%="number : "+number %>
	<%= "Exception fired....?" %>
	<hr/>
	Bye, HTML!
</body>
</html>
<!-- 4.HTML Code End -->