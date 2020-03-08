<%@ page contentType="text/html; charset=EUC-KR"%>

<!-- JSP 2.0 SPEC �߰� :: EL(Expression Language -->
<!-- Ȯ��1: page �����ڸ� �ּ�ó���ϰ� ���� default ���� false -->
<!-- Ȯ��2: page �������� �Ӽ��� true�� �ϰ� ���� ==> EL. \${} ���ڷ� �ν� -->
<%@ page isELIgnored="true" %>

<%--
	1. EL�� ${ǥ����}�� ����
	2. JSP 2.0���ʹ� default ����̳�, ���� �������� ���Ұ�
	3. EL�� ���� �� ���
--%>
<%="##### Expression tag ǥ�� ######" %><br/>
����: <%= "junhojohn" %><br/>
����: <%= 1234 %><br/><hr/><br/>

${ "##### Expression Language �� ǥ�� / Expression Tag�� �� ���� #####" }<br/>
����: ${ "junhojohn" }<br/>
����: ${ 1234 }<br/><hr/><br/>

<h3>1. �⺻�� ���, ��, ���迬���� ���</h3><p/>
����+����: ${ 1 + 2 } <br/>
����+����: ${ "1" + 2 } <br/>

<h4>expression tag ��� : ���� * ���� : <%=Integer.parseInt("1") * 2 %></h4>
<%--
	�ּ��� Ǯ�� ���� �߻��Ѵ� Ȯ���� ����.
	����*���� : ${"junhojohn"*3} &nbsp&nbsp (���ڴ� ����� Runtime �����߻�)
 --%>

10==10 : ${ 10==10 }<br/>
10>=1  : ${ 10>=1  }<br/>
!true  : ${ !true  }<br/>

<h3>2. ���ǿ����� ���</h3><p/>
���� ? true : false = ${ 10 > 100 ? "10�� 100���� ũ�� true" : "10�� 100���� �۴� false" }<br/><hr/><br/>

<h3>3. empty ������ ���</h3><p/>
empty null: ${ empty null }<br/>
empty " ": ${empty " " }<br/>
empty "": ${empty "" } &nbsp;&nbsp;&nbsp; null String�� �������� String str = new String()
