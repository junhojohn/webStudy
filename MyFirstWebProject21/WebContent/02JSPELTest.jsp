<%@ page contentType="text/html; charset=EUC-KR"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Vector"%>
<%@page isELIgnored="false" %>

<%
	pageContext.setAttribute("name", new String("pageContext에 저장된 문자열"));
	request.setAttribute("name", new String("request에 저장된 문자열"));
	session.setAttribute("name", new Vector());
	
	Vector v = new Vector();
	v.add(new String("sessionScope name1의 Vector에 저장된 문자열"));
	session.setAttribute("name1", v);
	
	HashMap hm = new HashMap();
	hm.put("a", new String("applicationScope name의 HashMap에 저장된 문자열"));
	application.setAttribute("name", hm);
	
%>

<h5>1. pageObject Scope에 저장된 name의 value 접근</h5>
 ㅇ ${pageScope.name} = ㅇ${pageScope["name"]}
 
<h5>2. requestObject Scope에 저장된 name의 value 접근</h5>
 ㅇ ${requestScope.name} = ㅇ${requestScope["name"]}
 
<h5>3. sessionObject Scope에 저장된 name의 value(Vector)의 empty 유무</h5>
 ㅇ ${empty sessionScope.name} = ㅇ${empty sessionScope["name"]}
 
<h5>4.1. sessionObject Scope에 저장된 name1의 value(Vector)의 empty 유무</h5>
 ㅇ ${empty sessionScope.name1} = ㅇ${empty sessionScope["name1"]}
 
<h5>4.2. sessionObject Scope에 저장된 name1의 value(Vector) 접근</h5>
 ㅇ ${empty sessionScope.name1[0]} = ㅇ${sessionScope["name1"][0]}
 
<h5>4.1. applicationObject Scope에 저장된 name1의 value(HashMap)의 empty 유무</h5>
 ㅇ ${empty applicationScope.name} = ㅇ${empty applicationScope["name"]}
 
<h5>4.2. applicationObject Scope에 저장된 name1의 value(HashMap) 접근</h5>
 ㅇ ${empty applicationScope.name.a} = ㅇ${applicationScope["name"].a}
 
<h3>
Object Scope의 영역을 지정하지 않고 EL을 사용 name에 접근시
어떤 ObjectScope값이 추출되는지 확인하자.
<br/>
<br/>
어떤 ObjectScope의 내용인가: ${name} 
<h3/>