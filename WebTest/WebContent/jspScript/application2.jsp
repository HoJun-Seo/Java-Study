<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String) session.getAttribute("name");
	String address = (String) application.getAttribute("address");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application2 내장 객체</title>
</head>
<body>
	<h1>이름 : <%= name%> 과 주소 : <%=address %></h1>
	<hr>
	<a href="application2.jsp">application2 두번째 페이지</a>
</body>
</html>