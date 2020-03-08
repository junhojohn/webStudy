<%@ page contentType="text/html; charset=EUC-KR"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Vector"%>
<%@page isELIgnored="false" %>

<%
	pageContext.setAttribute("name", new String("pageContext�� ����� ���ڿ�"));
	request.setAttribute("name", new String("request�� ����� ���ڿ�"));
	session.setAttribute("name", new Vector());
	
	Vector v = new Vector();
	v.add(new String("sessionScope name1�� Vector�� ����� ���ڿ�"));
	session.setAttribute("name1", v);
	
	HashMap hm = new HashMap();
	hm.put("a", new String("applicationScope name�� HashMap�� ����� ���ڿ�"));
	application.setAttribute("name", hm);
	
%>

<h5>1. pageObject Scope�� ����� name�� value ����</h5>
 �� ${pageScope.name} = ��${pageScope["name"]}
 
<h5>2. requestObject Scope�� ����� name�� value ����</h5>
 �� ${requestScope.name} = ��${requestScope["name"]}
 
<h5>3. sessionObject Scope�� ����� name�� value(Vector)�� empty ����</h5>
 �� ${empty sessionScope.name} = ��${empty sessionScope["name"]}
 
<h5>4.1. sessionObject Scope�� ����� name1�� value(Vector)�� empty ����</h5>
 �� ${empty sessionScope.name1} = ��${empty sessionScope["name1"]}
 
<h5>4.2. sessionObject Scope�� ����� name1�� value(Vector) ����</h5>
 �� ${empty sessionScope.name1[0]} = ��${sessionScope["name1"][0]}
 
<h5>4.1. applicationObject Scope�� ����� name1�� value(HashMap)�� empty ����</h5>
 �� ${empty applicationScope.name} = ��${empty applicationScope["name"]}
 
<h5>4.2. applicationObject Scope�� ����� name1�� value(HashMap) ����</h5>
 �� ${empty applicationScope.name.a} = ��${applicationScope["name"].a}
 
<h3>
Object Scope�� ������ �������� �ʰ� EL�� ��� name�� ���ٽ�
� ObjectScope���� ����Ǵ��� Ȯ������.
<br/>
<br/>
� ObjectScope�� �����ΰ�: ${name} 
<h3/>