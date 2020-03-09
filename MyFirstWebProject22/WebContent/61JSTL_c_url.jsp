<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:url var="url1" value="/11JSTL_c_set.jsp"/>
<c:url var="url2" value="http://127.0.0.1:8080/MyFirstWebProject22/51JSTL_c_import.jsp" scope="session">
	<c:param name="name" value="value"/>
</c:url>
<c:url var="url3" value="http://www.daum.net"/>

1. URL을 출력하면<br/>
${ url1 }<br/>
${ url2 }<br/>
${ url3 }<br/>

<br/>
<br/>
<br/>
<br/>

2. c:url, c:import 동시 사용해보면...<br/>
 <c:import url="${ url2 }" var="importPage" scope="request"/>
 ${requestScope.importPage }
 
 <br/>
 <br/>
 <br/>
 <br/>
 
3. sessionObject에 저장된 url2 사용하기<br/>
<a href="${sessionScope.url2 }">어디로 링크가 걸려있나 확인하자...</a>