<%@page import="com.junhojohn.models.Client"%>
<%@ page language="java" %>
<%@ page contentType="text/html; charset=EUC-KR" %>
<!-- JSTL ��� : taglib Directive ���� -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- c:set/c:remove�� ���, EL�� ��� -->
<h3>��JSTL c:set�� ����� ���3: JSTL c:set�� EL�� ���</h3> 
<c:set var="test01" value="<%= new com.junhojohn.models.Client() %>" scope="session"/>
<c:set var="test02" value="${ test01 }" scope="session"/>

<!-- Call By Value / Call By Reference
	==> �Ʒ��� ������ �����Ͽ� ��°���� ����
	A a1 = new A();
	A a2 = a1;
 -->
1. session Object Scope �� ����� test01�� name: ${ sessionScope.test01.name }<br/>
1. session Object Scope �� ����� test02�� name: ${ test02.name }<br/>

<h3>��Object Scope�� ����� bean�� setter method�� ȣ��(change name "junhojohn" into "hello")<br/>
��Call By Reference ����ϸ�...?</h3>
<c:set target="${ test01 }" property="name" value="hello"/>
2. session Object Scope �� ����� test01�� name: ${ sessionScope.test01.name }<br/>
2. session Object Scope �� ����� test02�� name: ${ test02.name }<br/>

<h3>������ var�� �ٽ� ��ü�� ������ ���... ������ �ٸ� ��ü�� ������ ��</h3>
<!-- Call By Value / Call By Reference
	==> �Ʒ��� ������ �����Ͽ� ��°���� ����
	A a1 = new A();
	A a2 = a1;
	a1 = new A();
 -->
<c:set var="test01" value="<%= new Client() %>" scope="session"/>
3. session Object Scope �� ����� test01�� name: ${ sessionScope.test01.name }<br/>
3. session Object Scope �� ����� test02�� name: ${ test02.name }<br/>

<h3>��c:set�� �̿��� Call by Reference ���� �ߴٸ�...</h3>
<jsp:useBean id="test03" class="com.junhojohn.models.Client"/>
<c:set var="test04" value="<%=test03.getInfo() %>" scope="session"/>
<!-- 
	1. test03 instance page Object Scope�� ����������,
	2. test03 instance �Ϻ�����(array)�� session Object Scope�� �ٽ� ������.
 -->
4. session Object Scope �� ����� test04�� info array: ${ sessionScope.test04[0] }<br/>
4. session Object Scope �� ����� test04�� info array: ${ test04[1] }<br/>