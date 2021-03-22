<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 유지 시간</title>
</head>
<body>
<%
	// 세션 유효시간은 기본 30분 설정
	int timeout = session.getMaxInactiveInterval(); //유효시간을 초 단위로 표현 
	out.print("세션의 유효시간 : " + timeout);
	
	out.print("<h2>코드로 세션 시간변경</h2>");
	session.setMaxInactiveInterval(2*60);
	timeout = session.getMaxInactiveInterval();
	out.print("세션의 유효시간 : " + timeout);
%>
</body>
</html>