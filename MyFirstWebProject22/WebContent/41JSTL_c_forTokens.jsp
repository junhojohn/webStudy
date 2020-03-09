<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>ㅇc:forTokens를 이용한 문자열을 추출</h3>
1. jun#ho#john의 문자열을 #을 구분자로 추출<br/>
<c:forTokens var ="i" items="jun#ho#john" delims="#">
	name1: ${ i }
	<br/>
	name2: <c:out value="${ i }"/>
	<br/><br/>
</c:forTokens>
<br/>
<hr/>
2.jun#ho#john의 문자열을 #을 구분자로 추출<br/>
c:set을 이용해보면<br/>
<c:set value="jun#ho#john" var="names"/>
<c:forTokens var="name" items="${ names }" delims="#">
	name: ${ name }<br/>
</c:forTokens>