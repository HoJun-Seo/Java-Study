<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 삭제(전체)</title>
</head>
<body>
<%
	//세션 삭제(개별) : 세션.removeAttribute("세션 변수")
	session.invalidate();
%>
	<h3>세션 전체가 삭제 되었습니다.</h3>
	<hr>
	<a href="session_result.jsp">세션 확인</a>
</body>
</html>