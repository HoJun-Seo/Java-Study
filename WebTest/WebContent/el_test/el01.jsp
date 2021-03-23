<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	// 자바 소스 형식은 매개변수 처리
	/* String name = request.getParameter("name"); */
	
	// EL 표현 언어 : ${param.변수}
%>
	<form action="el01.jsp" method="get">
		이름 : <input type="text" name="name" value="100" />
		<input type="submit" value="매개변수 값 보내기">
	</form>
	<%-- 인자로 넘어온 값 : <%=name %> --%>
	인자로 넘어온 값 : ${param.name}
</body>
</html>
<!-- 
스코프 객체
pageScope
requestScope
sessionScope
applicationScope
요청 매개변수
param : request.getParameter() 메소드 호출
paramValues : request.getParameterValues() 메소드 호출과 같은 기능
헤드 값 :
header : request.getHeader() 메소드 호출과 같은 기능
headerValues : request.getheader() 메소드 호출과 같은 기능
쿠키 값 : 
Cookies : 쿠키 이름값을 반환
JSP 내용 : pageContext : pageContext 객체를 참조
초기 매개변수 : initParam : 콘텍스트의 초기화 매개변수 이름의 값을 반환
 -->