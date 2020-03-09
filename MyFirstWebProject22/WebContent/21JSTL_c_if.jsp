<%@ page language="java"%>
<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<% request.setCharacterEncoding("EUC_KR");%>

<h3>ㅇJSTL c:if를 사용</h3>
 <c:if test="true">
 	if clause1<br/>
 </c:if>
 <c:if test="false">
 	if clause2<br/>
 </c:if>
 <br/>
 <hr/>
 
<h3>ㅇ21JSTLMultiCheck.html에 전송되는 Client Data 처리...</h3>
1. name: <%=request.getParameter("name")%><br/><!-- script et tag의 null처리와 -->
2. name: ${ param.name }<br/> <!-- EL에서의 null처리를 비교할 것 -->

<!-- single, double, quote 사용하는 것은 주의 -->
<c:if test="${ param.name } == 'junhojohn'">
4. Welcome, junhojohn.<br/> 
</c:if>

<c:if test="${ ! empty param.name }">
4. Welcome, ${ param.name }.<br/>
</c:if>

<c:set var="level" value="성인" scope="session"/>
<c:if test="${ param.age } < 19">
	<c:set var="level" value="청소년"/>
</c:if>

5. ${ param.name } age is ${ param.age } and he/she is ${ sessionScope.level }.<br/>

<!-- 다중으로 전송되는 sw client data 처리 -->
<c:if test="${ ! empty paramValues.sw[0] }">
	6. 선택하신 sw: ${ paramValues.sw[0] }<br/>
</c:if>
<c:if test="${ ! empty paramValues.sw[1] }">
	6. 선택하신 sw: ${ paramValues.sw[1] }<br/>
</c:if>
<c:if test="${ ! empty paramValues.sw[2] }">
	6. 선택하신 sw: ${ paramValues.sw[2] }<br/>
</c:if>
<hr/>

<h3>ㅇc:choose, c:when, c:otherwise를 사용</h3>
<!-- c:choose는 switch 비교하여 이해 -->
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
