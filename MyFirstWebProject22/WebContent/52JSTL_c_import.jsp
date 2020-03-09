<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<hr/>
<h3>ㅇ52JSTL_c_import.jsp 시작<br/>

requestScope에 저장된 내용공유 유무: ${ requestScope.save} <br/>
<c:if test="${ !empty param.name }">
	Param으로 전달된 value 추출: ${ param.name }<br/>
</c:if>

ㅇ52JSTL_c_import.jsp 종료<br/>
</h3>
<hr/>

