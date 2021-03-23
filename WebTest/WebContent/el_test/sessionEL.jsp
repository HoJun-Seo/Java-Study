<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 생성</title>
</head>
<body>
<%
	 session.setAttribute("id", "abc");
	 session.setAttribute("pwd", "1234");
	 
	 // 페이지 이동
	 response.sendRedirect("sessionEL_result.jsp");
%>
</body>
</html>