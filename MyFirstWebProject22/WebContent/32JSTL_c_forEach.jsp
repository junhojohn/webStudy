<%@ page language="java" %>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("EUC_KR");%>

<h3>��forEach�� Colleciton ���</h3>

1. c:forEach�� array�� ���۵Ǿ� ���� ParamValues ��ü ���(begin=0, step=1�� ���)<br/>
<!-- paramValues�� EL���尴ü�� [�Ķ�����̸�, ���� �迭]�� ������ Map ��ü�� ���� -->
<!-- paramValues.sw�� index 0�� Value i�� ���� / step �� 1 -->
<c:forEach var="i" items="${ paramValues.sw }" begin="0" step="1">
	�������Ͻ� sw�� : ${ i }<br/>
</c:forEach>

<c:forEach var="i" items="${ param }">
	<c:if test="${ empty param.name }">
		��${ param.name } age is ${ param.age }.<br/>
	</c:if>
</c:forEach>

<c:forEach var="i" items="${ param }">
	<c:if test="${ i.key == 'name' }">
		��${ param.name } age is ${ param.age }.<br/>
	</c:if>
</c:forEach>