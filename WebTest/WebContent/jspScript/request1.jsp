<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.RequestDispatcher"%>
<%
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>request1 내장 객체</title>
</head>
<body>
<%
	request.setAttribute("name", "홍길동");
	request.setAttribute("address", "부산 광역시");
	RequestDispatcher dispatch = request.getRequestDispatcher("request2.jsp");
	dispatch.forward(request, response);
%>
</body> 
</html>