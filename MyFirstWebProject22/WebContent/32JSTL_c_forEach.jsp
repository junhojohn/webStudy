<%@ page language="java" %>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("EUC_KR");%>

<h3>ㅇforEach를 Colleciton 사용</h3>

1. c:forEach를 array로 전송되어 오는 ParamValues 객체 출력(begin=0, step=1인 경우)<br/>
<!-- paramValues는 EL내장객체로 [파라미터이름, 값의 배열]을 저장한 Map 객체로 관리 -->
<!-- paramValues.sw의 index 0의 Value i에 대입 / step 은 1 -->
<c:forEach var="i" items="${ paramValues.sw }" begin="0" step="1">
	ㅇ선택하신 sw는 : ${ i }<br/>
</c:forEach>

<c:forEach var="i" items="${ param }">
	<c:if test="${ empty param.name }">
		ㅇ${ param.name } age is ${ param.age }.<br/>
	</c:if>
</c:forEach>

<c:forEach var="i" items="${ param }">
	<c:if test="${ i.key == 'name' }">
		ㅇ${ param.name } age is ${ param.age }.<br/>
	</c:if>
</c:forEach>