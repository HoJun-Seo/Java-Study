<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>responseRedirected.jsp 페이지</title>
</head>
<body>
	<h1>이름 : <%=name %></h1>
</body>
</html>