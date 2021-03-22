<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>세션 삭제(개별)</title>
</head>
<body>
<%
	// 세션 삭제(개별) : 세션.removeAttribute("세션 변수")
	session.removeAttribute("id");
%>
	<hr>
		<a href="session_result.jsp">세션 확인</a>
</body>
</html>