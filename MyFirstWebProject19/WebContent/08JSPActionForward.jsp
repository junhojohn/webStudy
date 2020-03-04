<%@ page contentType="text/html;charset=euc-kr" %>

<%@ page errorPage="WEB-INF/edu/JSPErrorPage.jsp" %>

<%--	
	위의 error page 의 접근을 이해하고 아래의  RelativeURI를 이해하자
	<%@ page errorPage="../jw07/03JSPErrorPage.jsp" %>   
--%>

<!--  buffer 를 사용할때와 사용하지 않을 경우를 비교  -->
<%-- <%@ page buffer="none" %> --%>

<html>
<body>
	1. Start of 08JSPActionForward.jsp....<br/>

	<%	
		request.setAttribute("aaa",new String("request connected."));
	%>
	<% String str = "abc"; %>
	<% Integer.parseInt(str); %>
	<!-- 	forward 는 RelativeURI만 사용 
			:: ==> 아래의 두 forward 를 번갈아 주석처리하고 Test -->
	<jsp:forward page="09JSPActionForward.jsp" />
	
	2. End of 08JSPActionForward.jsp...<br/>
</body>
</html>

<%--
	하나 :	위의 page  buffer="none "지시자의 를 주석을 test ==> exception
	            ==> forward 시 내부적으로 buffer 를 clear 
--%>