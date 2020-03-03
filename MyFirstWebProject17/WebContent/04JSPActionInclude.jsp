<%@ page contentType="text/html;charset=euc-kr" %>

<html>
<body>

1.  Start of 04JSPActionInclude.jsp.... <br/>

<%

	//request,session,application  Object Scope  String  ÀúÀå
	request.setAttribute("aaa",new String("It is request."));
	session.setAttribute("bbb",new String("It is session."));
	application.setAttribute("ccc",new String("It is application."));
%>

<jsp:include  page="05JSPActionInclude.jsp"/>


2.  End of 04JSPActionInclude.jsp.... <br/>

</body>
</html>