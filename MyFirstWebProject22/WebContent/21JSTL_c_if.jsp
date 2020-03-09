<%@ page language="java"%>
<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("EUC_KR");%>

<h3>��JSTL c:if�� ���</h3>
 <c:if test="true">
 	if clause1<br/>
 </c:if>
 <c:if test="false">
 	if clause2<br/>
 </c:if>
 <br/>
 <hr/>
 
<h3>��21JSTLMultiCheck.html�� ���۵Ǵ� Client Data ó��...</h3>
1. name: <%=request.getParameter("name")%><br/><!-- script et tag�� nulló���� -->
2. name: ${ param.name }<br/> <!-- EL������ nulló���� ���� �� -->

<!-- single, double, quote ����ϴ� ���� ���� -->
<c:if test="${ param.name } == 'junhojohn'">
4. Welcome, junhojohn.<br/> 
</c:if>

<c:if test="${ ! empty param.name }">
4. Welcome, ${ param.name }.<br/>
</c:if>

<c:set var="level" value="����" scope="session"/>
<c:if test="${ param.age } < 19">
	<c:set var="level" value="û�ҳ�"/>
</c:if>

5. ${ param.name } age is ${ param.age } and he/she is ${ sessionScope.level }.<br/>

<!-- �������� ���۵Ǵ� sw client data ó�� -->
<c:if test="${ ! empty paramValues.sw[0] }">
	6. �����Ͻ� sw: ${ paramValues.sw[0] }<br/>
</c:if>
<c:if test="${ ! empty paramValues.sw[1] }">
	6. �����Ͻ� sw: ${ paramValues.sw[1] }<br/>
</c:if>
<c:if test="${ ! empty paramValues.sw[2] }">
	6. �����Ͻ� sw: ${ paramValues.sw[2] }<br/>
</c:if>
<hr/>

<h3>��c:choose, c:when, c:otherwise�� ���</h3>
<!-- c:choose�� switch ���Ͽ� ���� -->
<c:choose>
	<c:when test="${ param.age > 19 }">
		7. ${ param.name } is adult and age is ${ param.age }.<br/>
	</c:when>
	<c:when test="${ param.age < 18 }">
		7. ${ param.name } is teenage and age is ${ param.age }.<br/>
	</c:when>
	<c:otherwise>
		7. I don't have no idea what ${ param.name } age is.<br/>
	</c:otherwise>
</c:choose>
