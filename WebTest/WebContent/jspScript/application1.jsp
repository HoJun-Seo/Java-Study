<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	session.setAttribute("name", "홍길순");
	application.setAttribute("address", "부산 광역시");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application1 내장 객체</title>
</head>
<body>
	<h1>이름과 주소를 저장합니다.</h1>
	<hr>
	<a href="application2.jsp">application2 두번째 페이지</a>
</body>
</html>