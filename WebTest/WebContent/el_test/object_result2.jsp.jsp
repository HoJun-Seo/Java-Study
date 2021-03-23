<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ArrayList 값 출력 : jstl 사용</title>
</head>
<body>
	<c:forEach var="fruit" items="${items}">
		${fruit} <br>
	</c:forEach>
</body>
</html>