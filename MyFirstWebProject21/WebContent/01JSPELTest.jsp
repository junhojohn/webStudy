<%@ page contentType="text/html; charset=EUC-KR"%>

<!-- JSP 2.0 SPEC 추가 :: EL(Expression Language -->
<!-- 확인1: page 지시자를 주석처리하고 실행 default 값은 false -->
<!-- 확인2: page 지시자의 속성을 true로 하고 실행 ==> EL. \${} 문자로 인식 -->
<%@ page isELIgnored="true" %>

<%--
	1. EL은 ${표현식}의 형태
	2. JSP 2.0부터는 default 사용이나, 이하 버전에서 사용불가
	3. EL의 이해 및 사용
--%>
<%="##### Expression tag 표현 ######" %><br/>
문자: <%= "junhojohn" %><br/>
숫자: <%= 1234 %><br/><hr/><br/>

${ "##### Expression Language 로 표현 / Expression Tag와 비교 이해 #####" }<br/>
문자: ${ "junhojohn" }<br/>
숫자: ${ 1234 }<br/><hr/><br/>

<h3>1. 기본적 산술, 논리, 관계연산자 사용</h3><p/>
숫자+숫자: ${ 1 + 2 } <br/>
문자+숫자: ${ "1" + 2 } <br/>

<h4>expression tag 사용 : 문자 * 숫자 : <%=Integer.parseInt("1") * 2 %></h4>
<%--
	주석을 풀면 에러 발생한다 확인해 보자.
	문자*숫자 : ${"junhojohn"*3} &nbsp&nbsp (문자는 연산시 Runtime 에러발생)
 --%>

10==10 : ${ 10==10 }<br/>
10>=1  : ${ 10>=1  }<br/>
!true  : ${ !true  }<br/>

<h3>2. 조건연산자 사용</h3><p/>
조건 ? true : false = ${ 10 > 100 ? "10이 100보다 크다 true" : "10이 100보다 작다 false" }<br/><hr/><br/>

<h3>3. empty 연산자 사용</h3><p/>
empty null: ${ empty null }<br/>
empty " ": ${empty " " }<br/>
empty "": ${empty "" } &nbsp;&nbsp;&nbsp; null String을 이해하자 String str = new String()
