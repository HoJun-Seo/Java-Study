<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>session 값 EL 표현</title>
</head>
<body>
	아이디 : <%=session.getAttribute("name") %> <br>
	비밀번호 : <%=session.getAttribute("pwd") %> <br>
	<hr>
	<h3>세션 값 EL 표현</h3>	
	아이디 : ${sessionScope.id} <br>
	비밀번호 : ${sessionScope.pwd}
</body>
</html>