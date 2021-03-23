<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ArrayList 결과 값</title>
</head>
<body>
<%
	// request 객체에 저장된 값 가져오기
	ArrayList<String> items = (ArrayList<String>)request.getAttribute("items");
	for(int i = 0; i < items.size(); i++){
		out.print(items.get(i) + "<br>");
	}
%>
	<hr>
	<h3></h3>
	${items[0]} <br>
	${items[1]} <br>
	${items[2]} <br>
	${items[3]} <br>
</body>
</html>