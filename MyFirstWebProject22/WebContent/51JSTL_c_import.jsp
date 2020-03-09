<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>ㅇc:import를 이용하여 include::jsp:include와 비교</h3><br/>
<!-- jsp:include는 같은 Context만 가능하나, c:import는 다른 Context도 가능 -->
<%
	request.setAttribute("save", new String("request Object Scope 저장된 문자열"));
%>

1. 동일 Context의 page include<br/>
 51JSTL_c_import.jsp page에서 requestScope에 저장내용: [${ requestScope.save }]<br/>
 52JSTL_c_import.jsp page를 include
 <c:import url="/52JSTL_c_import.jsp" var="importPage1" scope="request"/>
 ${ requestScope.importPage1 }
 
 <br/>
 <br/>
 <br/>
 
2. 동일 Context의 page include & param으로 data전송 <br/>
 51JSTL_c_import.jsp page에서 requestScope에 저장내용: [${ requestScope.save }]<br/>
 52JSTL_c_import.jsp page를 include
 <c:import url="/52JSTL_c_import.jsp" var="importPage2" scope="request">
 	<c:param name="name" value="value"/>
 </c:import>
 ${ importPage2 }
 <br/>
