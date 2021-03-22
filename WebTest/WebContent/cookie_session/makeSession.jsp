<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session 작성하기</title>
</head>
<body>
	<h3>session 생성하기</h3>
<%
	// 세션 변수 : 세션.setAttribute(변수명, 값) : 값은 Object 타입
	String id = "kim";
	String pwd = "1234";
	int age = 20;
	double height = 180.3;
	String name = "홍길동";
	
	
	session.setAttribute("id", id);
	session.setAttribute("pwd", pwd);
	session.setAttribute("name", name);
	session.setAttribute("age", age);
	session.setAttribute("height", height);
	
	//response.sendRedirect("session_result.jsp");
%>
<a href="session_result.jsp">세션 확인</a>
<hr>
<a href="deleteSession.jsp">세션 삭제(개별)</a>
<hr>
<a href="deleteAllSession.jsp">세션 삭제(전체)</a>
</body>
</html>