<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="url1" value="/11JSTL_c_set.jsp"/>
<c:url var="url2" value="http://127.0.0.1:8080/MyFirstWebProject22/51JSTL_c_import.jsp" scope="session">
	<c:param name="name" value="value"/>
</c:url>
<c:url var="url3" value="http://www.daum.net"/>

1. URL�� ����ϸ�<br/>
${ url1 }<br/>
${ url2 }<br/>
${ url3 }<br/>

<br/>
<br/>
<br/>
<br/>

2. c:url, c:import ���� ����غ���...<br/>
 <c:import url="${ url2 }" var="importPage" scope="request"/>
 ${requestScope.importPage }
 
 <br/>
 <br/>
 <br/>
 <br/>
 
3. sessionObject�� ����� url2 ����ϱ�<br/>
<a href="${sessionScope.url2 }">���� ��ũ�� �ɷ��ֳ� Ȯ������...</a>