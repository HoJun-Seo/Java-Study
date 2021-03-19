<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>responseRedirect() : url 한글 인코딩</title>
</head>
<body>
<%
	// url 에는 한글, 특수문자 사용이 제한되므로 한글 사용시 
	// 반드시 인코딩 과정을 해야한다.
	String name = "홍길동 만세";
	name = URLEncoder.encode(name, "utf-8");
	response.sendRedirect("responseRedirected.jsp?name="+name);
%>
</body>
</html>