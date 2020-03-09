<%@page import="com.junhojohn.models.Client"%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=EUC-KR" %>
<!-- JSTL 사용 : taglib Directive 설정 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- c:set/c:remove의 사용, EL의 사용 -->
<h3>ㅇJSTL c:set을 사용할 경우3: JSTL c:set의 EL을 사용</h3> 
<c:set var="test01" value="<%= new com.junhojohn.models.Client() %>" scope="session"/>
<c:set var="test02" value="${ test01 }" scope="session"/>

<!-- Call By Value / Call By Reference
	==> 아래의 내용을 참조하여 출력결과를 이해
	A a1 = new A();
	A a2 = a1;
 -->
1. session Object Scope 에 저장된 test01의 name: ${ sessionScope.test01.name }<br/>
1. session Object Scope 에 저장된 test02의 name: ${ test02.name }<br/>

<h3>ㅇObject Scope에 저장된 bean의 setter method를 호출(change name "junhojohn" into "hello")<br/>
ㅇCall By Reference 고려하면...?</h3>
<c:set target="${ test01 }" property="name" value="hello"/>
2. session Object Scope 에 저장된 test01의 name: ${ sessionScope.test01.name }<br/>
2. session Object Scope 에 저장된 test02의 name: ${ test02.name }<br/>

<h3>ㅇ같은 var로 다시 객체를 생성할 경우... 변수에 다른 객체를 대입한 것</h3>
<!-- Call By Value / Call By Reference
	==> 아래의 내용을 참조하여 출력결과를 이해
	A a1 = new A();
	A a2 = a1;
	a1 = new A();
 -->
<c:set var="test01" value="<%= new Client() %>" scope="session"/>
3. session Object Scope 에 저장된 test01의 name: ${ sessionScope.test01.name }<br/>
3. session Object Scope 에 저장된 test02의 name: ${ test02.name }<br/>

<h3>ㅇc:set을 이용한 Call by Reference 이해 했다면...</h3>
<jsp:useBean id="test03" class="com.junhojohn.models.Client"/>
<c:set var="test04" value="<%=test03.getInfo() %>" scope="session"/>
<!-- 
	1. test03 instance page Object Scope에 저장했으며,
	2. test03 instance 일부정보(array)만 session Object Scope에 다시 저장함.
 -->
4. session Object Scope 에 저장된 test04의 info array: ${ sessionScope.test04[0] }<br/>
4. session Object Scope 에 저장된 test04의 info array: ${ test04[1] }<br/>