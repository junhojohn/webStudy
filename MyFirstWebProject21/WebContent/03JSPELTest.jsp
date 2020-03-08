<%@ page contentType="text/html; charset=EUC-KR"%>

<% request.setCharacterEncoding("EUC_KR"); %>

<h3>ㅇ EL의 내장객체를 사용해보면</h3><p/>

1. pageContext EL 내장객체를 이용한 requestURI : ${pageContext.request.requestURI}<br/>

2. pageContext EL 내장객체를 이요한 session의 ID: ${pageContext.session.id}<br/>

3. Expression Tag를 사용(JSP 내장객체 사용): <%= pageContext.getSession().getId()%>

4. 이름 : <%= request.getParameter("name")%>

5. 주소 : ${param.addr}<br/>
<%
	String[] sw = request.getParameterValues("sw");
%>
6. 선택한 소프트웨어 : <%=sw[0] %><br/>
6. 선택한 소프트웨어 : ${paramValues.sw[1]}<br/>
6. 선택한 소프트웨어 : ${paramValues.sw[2]}<br/><hr/>

<h5>ㅇ EL의 Cookie 내장객체는 [이름, Cookie객체]형식으로 Map에 저장하고 있다.</h5>
7. 쿠키에 저장된 JSESSIONJD name : ${cookie.JSESSIONID.name}<br/>
7. 쿠키에 저장된 JSESSIONJD value : ${cookie.JSESSIONID.value}<br/>