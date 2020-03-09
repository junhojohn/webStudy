<%@ page language="java" %>
<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>ㅇ taglib의 c:set, c:remove, c:out을 사용</h3>
<c:set var="num1" value="100" scope="page"/>
<c:set var="num2"/><!-- scope 미정의 default는 page -->

1. num1은 empty : ${ empty pageScope.num1 } num1=${ pageScope.num1 } <br/>
2. num2는 empty : ${ empty pageScope.num2 } num2=${ pageScope.num2 } <br/>
3. num1 + num2 : ${ num1 + pageScope.num2 } <br/>

<!-- EL은 JSTL에서 먼저 사용되었고, JSP2.0에서 DEFAULT를 지원함 -->
4. c:out을 사용한 num1+num2 : <c:out value="${ num1 + num2 }"/><br/>
<!-- EL을 사용할 것인가, c:out을 사용할 것인가?? -->
<!-- JSP2.0이하 SPEC에서도 EL은 사용 가능한가?? -->
<hr/>

<c:set var="num1" value="${ num1 + 100 }"/>
5. num1 : ${ num1 }<br/><hr/>

<c:remove var="num1" scope="page"/>
<!-- Remove 시 Scope를 명확하게 -->
6. num1은 empty : ${ empty num1 } num1 : [_${ num1 }_]<br/>
7. num2는 empty : ${ empty num2 } num2 : [_${ pageScope.num2 }_]
<%
	
%>
