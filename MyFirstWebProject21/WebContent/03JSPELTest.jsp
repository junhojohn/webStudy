<%@ page contentType="text/html; charset=EUC-KR"%>

<% request.setCharacterEncoding("EUC_KR"); %>

<h3>�� EL�� ���尴ü�� ����غ���</h3><p/>

1. pageContext EL ���尴ü�� �̿��� requestURI : ${pageContext.request.requestURI}<br/>

2. pageContext EL ���尴ü�� �̿��� session�� ID: ${pageContext.session.id}<br/>

3. Expression Tag�� ���(JSP ���尴ü ���): <%= pageContext.getSession().getId()%>

4. �̸� : <%= request.getParameter("name")%>

5. �ּ� : ${param.addr}<br/>
<%
	String[] sw = request.getParameterValues("sw");
%>
6. ������ ����Ʈ���� : <%=sw[0] %><br/>
6. ������ ����Ʈ���� : ${paramValues.sw[1]}<br/>
6. ������ ����Ʈ���� : ${paramValues.sw[2]}<br/><hr/>

<h5>�� EL�� Cookie ���尴ü�� [�̸�, Cookie��ü]�������� Map�� �����ϰ� �ִ�.</h5>
7. ��Ű�� ����� JSESSIONJD name : ${cookie.JSESSIONID.name}<br/>
7. ��Ű�� ����� JSESSIONJD value : ${cookie.JSESSIONID.value}<br/>