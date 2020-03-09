<%@page import="java.util.HashMap"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>��c:forEach�� �̿��� ������ ���</h3>

1. c:forEach�� �̿��� 5�� ���<br/>
<c:forEach var="i" begin="1" end="10" step="1">
	5 * ${ i } = ${ 5 * i }<br/>
</c:forEach>
<br/>
<hr/>

2. ��ø c:forEach�� ���Ͽ� �������� ¦���� ���<br/>
<c:forEach var="i" begin="2" end="9" step="2">
	<c:forEach var="j" begin="1" end="9" step="1">
		${ i } * ${ j } = ${ i * j }
	</c:forEach>
	<br/>
</c:forEach>
<br/>
<hr/>

<h3>3. Index ���� CollectionValue ����</h3>
<%
	Vector vector = new Vector();
	vector.add("A");
	vector.add("B");
	vector.add("C");
	vector.add("D");
	
	System.out.println("==================");
	
	for(int i = 0 ; i < vector.size() ; i ++){
		System.out.println((String)vector.get(i));
	}
	
	System.out.println("==================");
	
	for(Object obj : vector){
		System.out.println((String)obj);
	}
	
	System.out.println("==================");
%>
<c:forEach var="i" items="<%= vector %>" begin="0" end="10" step="1">
	��Vector�� ����� ������ : ${ i }<br/>
</c:forEach>

<c:forEach var="i" items="<%=vector %>" begin="1" step="1">
	��Vector�� ����� ������ : ${ i }<br/>	
</c:forEach>
<c:forEach var="i" items="<%=vector %>" begin="0" step="2">
	��Vector�� ����� ������ : ${ i }<br/>
</c:forEach>
<c:forEach var="i" items="<%=vector %>" begin="0" end="1" step="1">
	��Vector�� ����� ������ : ${ i }<br/>
</c:forEach>

<h3>4. key=value ������ map�� value ����</h3><br/>
<%
	HashMap<String, String> hashMap = new HashMap<String, String>();
	hashMap.put("a", "A");
	hashMap.put("b", "B");
	hashMap.put("c", "C");
	hashMap.put("d", "D");
%>

<c:forEach var="i" items="<%=hashMap %>" begin="0" end="<%=hashMap.size() %>" step="1">
	��HashMap�� ����� ������ : ${ i.key } = ${ i.value }<br/>
</c:forEach>
<br/>

<c:set var="aaa" value="<%= hashMap %>"/>
<c:forEach var="i" items="${ aaa  }">
	<c:if test="${ i.key == 'a'}">
		key a�� value : ${ i.value }
	</c:if>
	<br/>
</c:forEach>	
