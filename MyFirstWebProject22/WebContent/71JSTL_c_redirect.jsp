<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>ㅇc:redirect을 이용하여 redirect::response.sendRedirect() 비교.</h3>
<!-- 각각을 확인 후 브라우저 주소 창에 url을 확인 -->

1. 아래의 내용을 차례로 주석을 풀고 확인
<!-- 
<c:redirect url="/11JSTL_c_set.jsp"/>
-->

 <!--
<c:redirect url="http://127.0.0.1/MyFirstWebProject22/52JSTL_c_import.jsp">
	<c:param name="name" value="value"/>
</c:redirect>
-->

<!--  
<c:url var="url" value="http://127.0.0.1/MyFirstWebProject22/52JSTL_c_import.jsp" scope="session">
	<c:param name="name" value="value"></c:param>
</c:url>
<c:redirect url="${ url }"/>
-->