<%@ page language="java" contentType="text/html; charset=EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3>��c:redirect�� �̿��Ͽ� redirect::response.sendRedirect() ��.</h3>
<!-- ������ Ȯ�� �� ������ �ּ� â�� url�� Ȯ�� -->

1. �Ʒ��� ������ ���ʷ� �ּ��� Ǯ�� Ȯ��
<!-- 
<c:redirect url="/11JSTL_c_set.jsp"/>
-->

 <!--
<c:redirect url="http://127.0.0.1/MyFirstWebProject22/52JSTL_c_import.jsp">
	<c:param name="name" value="value"/>
</c:redirect>
-->

<!--  
<c:url var="url" value="http://127.0.0.1/MyFirstWebProject22/52JSTL_c_import.jsp" scope="session">
	<c:param name="name" value="value"></c:param>
</c:url>
<c:redirect url="${ url }"/>
-->