<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<hr/>
<h3>��52JSTL_c_import.jsp ����<br/>

requestScope�� ����� ������� ����: ${ requestScope.save} <br/>
<c:if test="${ !empty param.name }">
	Param���� ���޵� value ����: ${ param.name }<br/>
</c:if>

��52JSTL_c_import.jsp ����<br/>
</h3>
<hr/>

