<%@page import="com.junhojohn.models.Client"%>
<%@ page language="java"%>
<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- c:set, c:remove�� ���, EL�� ��� -->
<h3>�� JSTL c:set�� ��� 1 : Bean ���� ObjectScope����</h3>
<c:set var="client" value="<%= new Client() %>" scope="session"/>

1. session Object Scope�� ����� name: ${ sessionScope.client.name }	 <br/>
1. session Object Scope�� ����� name: <c:out value="${ client.name }"/><br/>
2. session Object Scope�� ����� addr: ${ client.addr }					 <br/>
3. session Object Scope�� ����� age: ${ client.age } 					 <br/>
4. session Object Scope�� ����� info �迭�� empty : ${ empty client.info }<br/>
5. session Object Scope�� ����� info �迭�� ���� value��:<br/>
5.1. info �迭�� index 0 value : ${ sessionScope.client.info[0] }<br/>
5.1. info �迭�� index 1 value : ${ client.info[1] }<br/>

<h3>�� JSTL c:set�� ��� 2 : ObjectScope ����� Bean setter Method ȣ�� </h3>

<c:set target="${ client }" property="name" value="hello"/>
1. session Object Scope�� ����� name: ${ sessionScope.client.name }<br/>

<c:set target="${ client }" property="addr" value="Busan"/>
2. session Object Scope�� ����� addr: ${ client.addr }<br/>

<h3># ��ũ��Ʈ���� �̿��Ͽ� Object Scope�� ����� Bean�� �����غ���</h3>
<%
	Client client = (Client)session.getAttribute("client");
	out.println("name:" + client.getName() + "<br/>");
	out.println("addr:" + client.getAddr());
%>
<br/>
<hr/>

<h3># useBean.setProperty, getProperty�� �̿��Ͽ� �����ϸ�</h3>
<jsp:useBean id="client2" class="com.junhojohn.models.Client" scope="session"/>
name : <jsp:getProperty property="name" name="client2"/>
<br/>
addr : <jsp:getProperty property="addr" name="client2"/>
<br/>
<hr/>

<h3>�� JSTL c:remove�� ���: Object Scope�� ����� Bean remove</h3>
remove �� client ��ü�� empty : ${ empty sessionScope.client }<br/>
Session�� ����� bean ��ü remove �ϸ�...<br/>
<c:remove var="client" scope="session"/>
remove �� client ��ü�� empty : ${ empty client }

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>