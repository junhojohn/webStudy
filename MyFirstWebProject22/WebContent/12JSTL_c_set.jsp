<%@page import="com.junhojohn.models.Client"%>
<%@ page language="java"%>
<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- c:set, c:remove의 사용, EL의 사용 -->
<h3>ㅇ JSTL c:set을 사용 1 : Bean 생성 ObjectScope저장</h3>
<c:set var="client" value="<%= new Client() %>" scope="session"/>

1. session Object Scope에 저장된 name: ${ sessionScope.client.name }	 <br/>
1. session Object Scope에 저장된 name: <c:out value="${ client.name }"/><br/>
2. session Object Scope에 저장된 addr: ${ client.addr }					 <br/>
3. session Object Scope에 저장된 age: ${ client.age } 					 <br/>
4. session Object Scope에 저장된 info 배열은 empty : ${ empty client.info }<br/>
5. session Object Scope에 저장된 info 배열의 각각 value는:<br/>
5.1. info 배열의 index 0 value : ${ sessionScope.client.info[0] }<br/>
5.1. info 배열의 index 1 value : ${ client.info[1] }<br/>

<h3>ㅇ JSTL c:set을 사용 2 : ObjectScope 저장된 Bean setter Method 호출 </h3>

<c:set target="${ client }" property="name" value="hello"/>
1. session Object Scope에 저장된 name: ${ sessionScope.client.name }<br/>

<c:set target="${ client }" property="addr" value="Busan"/>
2. session Object Scope에 저장된 addr: ${ client.addr }<br/>

<h3># 스크립트렛을 이용하여 Object Scope에 저장된 Bean에 접근해보면</h3>
<%
	Client client = (Client)session.getAttribute("client");
	out.println("name:" + client.getName() + "<br/>");
	out.println("addr:" + client.getAddr());
%>
<br/>
<hr/>

<h3># useBean.setProperty, getProperty를 이용하여 접근하면</h3>
<jsp:useBean id="client2" class="com.junhojohn.models.Client" scope="session"/>
name : <jsp:getProperty property="name" name="client2"/>
<br/>
addr : <jsp:getProperty property="addr" name="client2"/>
<br/>
<hr/>

<h3>ㅇ JSTL c:remove를 사용: Object Scope에 저장된 Bean remove</h3>
remove 전 client 객체는 empty : ${ empty sessionScope.client }<br/>
Session에 저장된 bean 객체 remove 하면...<br/>
<c:remove var="client" scope="session"/>
remove 후 client 객체는 empty : ${ empty client }

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>