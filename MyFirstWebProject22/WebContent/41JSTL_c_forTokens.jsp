<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ page language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>��c:forTokens�� �̿��� ���ڿ��� ����</h3>
1. jun#ho#john�� ���ڿ��� #�� �����ڷ� ����<br/>
<c:forTokens var ="i" items="jun#ho#john" delims="#">
	name1: ${ i }
	<br/>
	name2: <c:out value="${ i }"/>
	<br/><br/>
</c:forTokens>
<br/>
<hr/>
2.jun#ho#john�� ���ڿ��� #�� �����ڷ� ����<br/>
c:set�� �̿��غ���<br/>
<c:set value="jun#ho#john" var="names"/>
<c:forTokens var="name" items="${ names }" delims="#">
	name: ${ name }<br/>
</c:forTokens>