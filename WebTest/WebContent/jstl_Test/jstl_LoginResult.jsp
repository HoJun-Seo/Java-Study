<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl 로그인 결과값</title>
</head>
<body>
	<c:if test="${empty param.id }">
		아이디를 입력하세요 <br>
		<a href="jstl_Login.jsp">회원 가입</a>
	</c:if>
	<c:if test="${not empty param.id}">
		<c:if test="${param.id == 'admin'}">
			<h2>관리자로 로그인 했습니다.</h2>
			<form >
				<input type="button" value="회원 정보">
				<input type="button" value="회원 정보">
			</form>
		</c:if>
		<c:if test="${param.id != 'admin' }">
			<h2>
				환영합니다.
				<c:out value="${param.id}"></c:out>님!!!
			</h2>
		</c:if>
	</c:if>
	
</body>
</html>