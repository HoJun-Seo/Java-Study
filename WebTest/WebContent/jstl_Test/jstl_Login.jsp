<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl 로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<hr>
	<form action="jstl_LoginResult.jsp" method="post">
		아이디 : <input type="text" name="id"/> <br>
		비밀번호 : <input type="password" name="pwd" /> <br>
		<input type="submit" value="로그인">
		<input type="reset" value="다시 입력">
	</form>
</body>
</html>