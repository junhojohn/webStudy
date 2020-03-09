<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>��c:import�� �̿��Ͽ� include::jsp:include�� ��</h3><br/>
<!-- jsp:include�� ���� Context�� �����ϳ�, c:import�� �ٸ� Context�� ���� -->
<%
	request.setAttribute("save", new String("request Object Scope ����� ���ڿ�"));
%>

1. ���� Context�� page include<br/>
 51JSTL_c_import.jsp page���� requestScope�� ���峻��: [${ requestScope.save }]<br/>
 52JSTL_c_import.jsp page�� include
 <c:import url="/52JSTL_c_import.jsp" var="importPage1" scope="request"/>
 ${ requestScope.importPage1 }
 
 <br/>
 <br/>
 <br/>
 
2. ���� Context�� page include & param���� data���� <br/>
 51JSTL_c_import.jsp page���� requestScope�� ���峻��: [${ requestScope.save }]<br/>
 52JSTL_c_import.jsp page�� include
 <c:import url="/52JSTL_c_import.jsp" var="importPage2" scope="request">
 	<c:param name="name" value="value"/>
 </c:import>
 ${ importPage2 }
 <br/>
